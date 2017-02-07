package com.manager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.manager.model.Permission;
import com.manager.model.RolePermissionRel;
import com.manager.model.UserRoleRel;
import com.manager.service.PermissionService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class PermissionController extends BaseController implements IController {

    private Permission permission;
    @Resource
	private SequenceGeneratorService sequenceGeneratorService;
	@Resource
	private PermissionService permissionService;
	
	
	// index
	public DataAndView permissionIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	// list
	public DataAndView permissionList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // cunrrent page
		int rows = Integer.parseInt(request.getParameter("rows")); // display count per page
		
		// seach params
		String permission_name = request.getParameter("permission_name");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("permission_name", permission_name);
		
		// page params
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();// new一个JSON
		jsonObj.accumulate("total", permissionService.getPermissionCount(paramsMap));// total
		jsonObj.accumulate("rows", permissionService.getAllPermissions(paramsMap));// rows:data set
		
		return new DataAndView("permissionList", jsonObj, null, SkipType.FORWARD);
	}
	
	// add
	public DataAndView permissionAdd(HttpServletRequest request){
		return null;
	}
	
	// add submit
	public DataAndView permissionAddSubmit(HttpServletRequest request)  {
		// bind form object
		Permission permission =  new Permission();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(permission);
		
		permission.setHas_next("0");
		permission.setParent_id("0");
		permission.setPriority("0");
		
		binder.bind(request);
		
		permission.setPermission_id(sequenceGeneratorService.getCurrentPrimaryKey("z_permission"));
		int row = permissionService.savePermission(permission);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// modify
	public DataAndView permissionModify(HttpServletRequest request){
		String permission_id = request.getParameter("permission_id");
		permission = permissionService.getPermissionById(permission_id);
		return new DataAndView("permission", permission, null, SkipType.FORWARD);
	}
	
	//modify submit
	public DataAndView permissionModifySubmit(HttpServletRequest request){
		// bind form object
		Permission permission =  new Permission();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(permission); 
		binder.bind(request);
		
		int row = permissionService.modifyPermission(permission);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// delete
	public DataAndView permissionDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = permissionService.deletePermissionById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	/**
	 * @param request
	 * @return
	 * 查询权限所属的角色
	 */
	public DataAndView permissionRoleListIndex(HttpServletRequest request){
		String permission_id = request.getParameter("permission_id");
		return new DataAndView("permission_id", permission_id, null, SkipType.FORWARD);
	}
	
	public DataAndView permissionRoleList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String permission_id = request.getParameter("permission_id");
		String role_name = request.getParameter("role_name");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("permission_id", permission_id);
        paramsMap.put("role_name", role_name);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", permissionService.getPermissionRoleCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", permissionService.getPermissionRoleList(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("permissionRoleList", jsonObj, null, SkipType.FORWARD);
	}
	
	/**
	 * @param request
	 * @return
	 * 查询哪些角色没有该权限
	 */
	public DataAndView otherPermissionRoleList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String permission_id = request.getParameter("permission_id");
		String role_name = request.getParameter("role_name");
		
		Map paramsMap = new HashMap<String, String>();
        paramsMap.put("permission_id", permission_id);
        paramsMap.put("role_name", role_name);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", permissionService.getOtherPermissionRoleCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", permissionService.getOtherPermissionRoleList(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("permissionRoleList", jsonObj, null, SkipType.FORWARD);
	}
	
	/**
	 * 删除权限所属的角色
	 */
	public DataAndView permissionRoleDelete(HttpServletRequest request) throws Exception {
		String params[] = request.getParameterValues("params[]");
		int flag = permissionService.deletePermissionRoleById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView addRolesToPermission(HttpServletRequest request) throws Exception {
		String permission_id = request.getParameter("permission_id");
		String params[] = request.getParameterValues("params[]");
		
		RolePermissionRel rel =  new RolePermissionRel();
		int flag = 0;
		for(String role_id:params){
			rel.setPermission_id(permission_id);
			rel.setRole_permission_id(sequenceGeneratorService.getCurrentPrimaryKey("z_role_permission"));
			rel.setRole_id(role_id);
			flag += permissionService.addRoleToPermission(rel);
		}
		
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
