package com.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.manager.model.MenuPermission;
import com.manager.service.MenuPermissionService;
import com.news.model.News;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class MenuPermissionController extends BaseController implements IController {

	private MenuPermission menuPermission;
	@Resource
	private MenuPermissionService menuPermisionService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	public DataAndView menuPermissionTreeIndex(HttpServletRequest request){
		return null;
	}
	
	public DataAndView menuPermissionTree(HttpServletRequest request){
		
		Map paramsMap = new HashMap();
		//获取参数
		String parentid = request.getParameter("id");
		
		//json数据返回
		StringBuffer stringBuffer = new StringBuffer();
		if(parentid==null || "".equals(parentid)){
			stringBuffer.append("[{id:\"0\",name:\"菜单权限\",isParent:true,open:true,click:\"Open('菜单权限','0')\"}]");
		}else{
			paramsMap.put("parentid", parentid);
			//获取菜单列表
			List parentMenuList = menuPermisionService.getMenuPermissionMenuByParentId(paramsMap);
			stringBuffer.append("[");
			News menu;
			for(int i=0; i<parentMenuList.size();i++){
				Map map = (HashMap)parentMenuList.get(i);
				String isParent = "false";
				if(((String)map.get("HAS_NEXT")).equals("1")){
					isParent = "true";
				}
				stringBuffer.append("{");
				stringBuffer.append("id:\""+map.get("PERMISSION_ID")+"\",name:\""+map.get("PERMISSION_NAME")+"\",isParent:"+isParent+",");
				stringBuffer.append("click:\"Open('"+map.get("PERMISSION_NAME")+"','"+map.get("PERMISSION_ID")+"')\",");
				stringBuffer.append("open:true},");
			}
			stringBuffer.append("]");
		}
		return new DataAndView("json",stringBuffer.toString(),"",SkipType.FORWARD);
	}
	
	public DataAndView menuPermissionIndex(HttpServletRequest request) throws Exception {
		String parent_id = request.getParameter("parent_id");
		return new DataAndView("parent_id", parent_id, null, SkipType.FORWARD);
	}
	
	public DataAndView menuPermissionList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		// 查询参数
		String parent_id = request.getParameter("parent_id");
		String permission_name = request.getParameter("permission_name");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("permission_name", permission_name);
		paramsMap.put("parent_id", parent_id);
		
		// 分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();// new一个JSON
		jsonObj.accumulate("total", menuPermisionService.getMenuPermissionCount(paramsMap));// total代表一共有多少数据
		jsonObj.accumulate("rows", menuPermisionService.getAllMenuPermissions(paramsMap));// rows是代表显示的页的数据集合
		
		return new DataAndView("permissionList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView menuPermissionAdd(HttpServletRequest request){
		String parent_id = request.getParameter("parent_id");
		return new DataAndView("parent_id", parent_id, null, SkipType.FORWARD);
	}
	
	public DataAndView menuPermissionAddSubmit(HttpServletRequest request)  {
		// bind form object
		MenuPermission menuPermission =  new MenuPermission();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(menuPermission);
		binder.bind(request);
		
		//父节点has_next置为1
		MenuPermission p = new MenuPermission();
		p.setPermission_id(menuPermission.getParent_id());
		p.setHas_next("1");
		menuPermisionService.modifyMenuPermission(p);
		
		menuPermission.setHas_next("0");
		menuPermission.setPriority("0");
		menuPermission.setPermission_id(sequenceGeneratorService.getCurrentPrimaryKey("z_permission"));
		int row = menuPermisionService.saveMenuPermission(menuPermission);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView menuPermissionModify(HttpServletRequest request){
		String permission_id = request.getParameter("permission_id");
		menuPermission = menuPermisionService.getMenuPermissionById(permission_id);
		return new DataAndView("menuPermission", menuPermission, null, SkipType.FORWARD);
	}

	public DataAndView menuPermissionModifySubmit(HttpServletRequest request){
		//绑定form对象
		MenuPermission manuPermission =  new MenuPermission();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(manuPermission); 
		binder.bind(request);
		
		int row = menuPermisionService.modifyMenuPermission(manuPermission);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView menuPermissionDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = menuPermisionService.deleteMenuPermissionById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}

	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
