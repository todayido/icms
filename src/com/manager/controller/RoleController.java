package com.manager.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.manager.model.Role;
import com.manager.model.RolePermissionRel;
import com.manager.service.MenuPermissionService;
import com.manager.service.RoleService;
import com.news.model.News;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class RoleController extends BaseController implements IController {

	private Role role;
	@Resource
	private RoleService roleService;
	@Resource
	private MenuPermissionService menuPermissionService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	
	public DataAndView roleIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	public DataAndView roleList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		// 查询参数
		String role_name = request.getParameter("role_name");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("role_name", role_name);
		
		// 分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();// new一个JSON
		jsonObj.accumulate("total", roleService.getRoleCount(paramsMap));// total代表一共有多少数据
		jsonObj.accumulate("rows", roleService.getAllRoles(paramsMap));// rows是代表显示的页的数据集合
		
		return new DataAndView("roleList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView roleAdd(HttpServletRequest request){
		return null;
	}
	
	public DataAndView roleAddSubmit(HttpServletRequest request)  {
		// bind form object
		Role role =  new Role();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(role);
		binder.bind(request);
		
		role.setRole_id(sequenceGeneratorService.getCurrentPrimaryKey("z_role"));
		role.setIssuper("0");
		role.setPriority("0");
		int row = roleService.saveRole(role);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView roleModify(HttpServletRequest request){
		String role_id = request.getParameter("role_id");
		role = roleService.getRoleById(role_id);
		return new DataAndView("role", role, null, SkipType.FORWARD);
	}
	
	public DataAndView roleModifySubmit(HttpServletRequest request){
		//绑定form对象
		Role role =  new Role();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(role); 
		binder.bind(request);
		
		int row = roleService.modifyRole(role);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView roleDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = roleService.deleteRoleById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView menuRoleTreeIndex(HttpServletRequest request){
		String role_id = request.getParameter("role_id");
		return new DataAndView("role_id", role_id, null, SkipType.FORWARD);
	}
	
	public DataAndView menuRoleTree(HttpServletRequest request){
		Map paramsMap = new HashMap();
		//获取参数
		String role_id = request.getParameter("role_id");
		String parentid = request.getParameter("id");
		
		//根据role_id获取该角色已经选择的权限
		paramsMap.put("role_id", role_id);
		List list = roleService.getRolePermissionList(paramsMap);
		Set set = new HashSet();
		Map roleMenuMap = new HashMap();
		for(int i=0;i<list.size();i++){
			roleMenuMap = (Map) list.get(i);
			set.add(roleMenuMap.get("PERMISSION_ID"));
		}
		
		//json数据返回
		StringBuffer stringBuffer = new StringBuffer();
		if(parentid==null || "".equals(parentid)){
			stringBuffer.append("[{id:\"0\",name:\"菜单角色列表\",isParent:true,open:true}]");
		}else{
			paramsMap.put("parentid", parentid);
			
			//获取菜单列表
			List parentMenuList = menuPermissionService.getMenuPermissionMenuByParentId(paramsMap);
			stringBuffer.append("[");
			News menu;
			for(int i=0; i<parentMenuList.size();i++){
				Map map = (HashMap)parentMenuList.get(i);
				
				String isParent = "false";
				if(((String)map.get("HAS_NEXT")).equals("1")){
					isParent = "true";
				}
				stringBuffer.append("{pid:\""+map.get("ROLE_PERMISSION_ID")+"\",id:\""+map.get("PERMISSION_ID")+"\",name:\""+map.get("PERMISSION_NAME")+"\",open:true,isParent:"+isParent+",");
				
				if(set.contains((String)map.get("PERMISSION_ID"))){
					stringBuffer.append("checked:true,");
				}
				stringBuffer.append("open:true},");
			}
			stringBuffer.append("]");
		}
		return new DataAndView("json",stringBuffer.toString(),"",SkipType.FORWARD);
	}
	
	public DataAndView deleteMenuPersmissionFromRole(HttpServletRequest request) throws Exception {
		String role_id = request.getParameter("role_id");
		String params[] = request.getParameterValues("params");
		int flag = roleService.deleteRolePermissionById(params,role_id);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}

	public DataAndView addMenuPermissionToRole(HttpServletRequest request) throws Exception {
		String role_id = request.getParameter("role_id");
		String params[] = request.getParameterValues("params");
		Map paramsMap = new HashMap();
		
		paramsMap.put("role_id", role_id);
		List list = roleService.getRolePermissionList(paramsMap);
		Set set = new HashSet();
		Map rolePermissionMap = new HashMap();
		for(int i=0;i<list.size();i++){
			rolePermissionMap = (Map) list.get(i);
			set.add(rolePermissionMap.get("PERMISSION_ID"));
		}
		
		RolePermissionRel rolePermissionRel =  new RolePermissionRel();
		int flag = 0;
		for(String permission_id:params){
			if(!set.contains(permission_id) && (Integer.parseInt(permission_id))!=0){
				rolePermissionRel.setRole_permission_id(sequenceGeneratorService.getCurrentPrimaryKey("z_role_permission"));
				rolePermissionRel.setRole_id(role_id);
				rolePermissionRel.setPermission_id(permission_id);
				flag += roleService.addPermissionToRole(rolePermissionRel);
			}else{
				flag = 1;
			}
		}
		
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	/**
	 * @param request
	 * @return
	 * 查询角色包含的权限
	 */
	public DataAndView rolePermissionListIndex(HttpServletRequest request){
		String role_id = request.getParameter("role_id");
		return new DataAndView("role_id", role_id, null, SkipType.FORWARD);
	}
	
	public DataAndView rolePermissionList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String role_id = request.getParameter("role_id");
		String permission_name = request.getParameter("permission_name");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("role_id", role_id);
        paramsMap.put("permission_name", permission_name);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", roleService.getPermissionsCountBelongsToARole(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", roleService.getPermissionsListBelongsToARole(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("rolePermissionList", jsonObj, null, SkipType.FORWARD);
	}
	
	/**
	 * @param request
	 * @return
	 * 查询哪些权限不属于某个角色
	 */
	public DataAndView otherRolePermissionList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String role_id = request.getParameter("role_id");
		String permission_name = request.getParameter("permission_name");
		
		Map paramsMap = new HashMap<String, String>();
        paramsMap.put("role_id", role_id);
        paramsMap.put("permission_name", permission_name);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", roleService.getPermissionsCountNotBelongsToARole(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", roleService.getPermissionsListNotBelongsToARole(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("rolePermissionList", jsonObj, null, SkipType.FORWARD);
	}
	
	/**
	 * 删除角色中包含的权限
	 */
	public DataAndView rolePermissionDelete(HttpServletRequest request) throws Exception {
		String role_id = request.getParameter("role_id");
		String params[] = request.getParameterValues("params[]");
		int flag = 0;
		Map paramsMap;
		for(String permission_id:params){
			paramsMap =new HashMap();
			paramsMap.put("role_id", role_id);
			paramsMap.put("permission_id", permission_id);
			flag +=roleService.deletePermissionFromRole(paramsMap);
		}
		
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView addPermissionsToRole(HttpServletRequest request) throws Exception {
		String role_id = request.getParameter("role_id");
		String params[] = request.getParameterValues("params[]");
		
		RolePermissionRel rel =  new RolePermissionRel();
		int flag = 0;
		for(String permission_id:params){
			rel.setPermission_id(permission_id);
			rel.setRole_permission_id(sequenceGeneratorService.getCurrentPrimaryKey("z_role_permission"));
			rel.setRole_id(role_id);
			flag += roleService.addPermissionToRole(rel);
		}
		
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}

	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}
	
}
