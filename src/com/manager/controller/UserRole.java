package com.manager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.manager.model.Role;
import com.manager.model.UserRoleRel;
import com.manager.service.RoleService;
import com.manager.service.UserService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class UserRole extends BaseController implements IController {

	@Resource
	private UserService userService;
	@Resource
	private RoleService roleSerive;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	/**
	 * @param request
	 * @return
	 * 查询用户已选角色
	 */
	public DataAndView userRoleListIndex(HttpServletRequest request){
		String user_id = request.getParameter("USER_ID");
		return new DataAndView("user_id", user_id, null, SkipType.FORWARD);
	}
	
	public DataAndView userRoleList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String user_id = request.getParameter("user_id");
		String role_name = request.getParameter("role_name");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("user_id", user_id);
        paramsMap.put("role_name", role_name);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", userService.getUserRoleCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", userService.getUserRoleList(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("userRoleList", jsonObj, null, SkipType.FORWARD);
	}
	
	/**
	 * @param request
	 * @return
	 */
	public DataAndView otherRoleList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String user_id = request.getParameter("user_id");
		String role_name = request.getParameter("role_name");
		
		Map paramsMap = new HashMap<String, String>();
        paramsMap.put("user_id", user_id);
        paramsMap.put("role_name", role_name);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", userService.getOtherRoleCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", userService.getOtherRoleList(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("userRoleList", jsonObj, null, SkipType.FORWARD);
	}

	public DataAndView userRoleDelete(HttpServletRequest request) throws Exception {
		String params[] = request.getParameterValues("params[]");
		int flag = userService.deleteUserRoleById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}

	public DataAndView addRolesToUser(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_id");
		String params[] = request.getParameterValues("params[]");
		
		UserRoleRel userRoleRel =  new UserRoleRel();
		int flag = 0;
		for(String role_id:params){
			userRoleRel.setUser_id(user_id);
			userRoleRel.setUser_role_id(sequenceGeneratorService.getCurrentPrimaryKey("z_user_role"));
			userRoleRel.setRole_id(role_id);
			flag += userService.addRoleToUser(userRoleRel);
		}
		
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
