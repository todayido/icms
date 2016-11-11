package com.manager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.manager.model.User;
import com.manager.service.UserService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class UserController extends BaseController implements IController {

	private User user;
	@Resource
	private UserService userService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;

	public DataAndView userIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	public DataAndView userList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String user_name = request.getParameter("user_name");
		String status = request.getParameter("status");
		String depart_id = request.getParameter("depart_id");
		String duty_id = request.getParameter("duty_id");
		
		Map paramsMap = new HashMap<String, String>();
        paramsMap.put("user_name", user_name);
        paramsMap.put("status", status);
        paramsMap.put("depart_id", depart_id);
        paramsMap.put("duty_id", duty_id);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", userService.getUserCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", userService.getAllUsers(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("userList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView userAdd(HttpServletRequest request) throws Exception {
		return null;
	}
	
	public DataAndView userAddSubmit(HttpServletRequest request){
		//绑定form对象
		User user =  new User();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(user); 
        binder.bind(request);
        
        user.setStatus("1");
        user.setLogin_error_times(0);
        user.setLogin_times(0);
        user.setPriority("0");
        user.setReg_time(new Date());
        user.setLast_login_time(new Date());
        
		user.setUser_id(sequenceGeneratorService.getCurrentPrimaryKey("z_user"));
		int row = userService.saveUser(user);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}

	public DataAndView userModify(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("USER_ID");
		Map userMap = userService.getUserAndDepartInfoById(user_id);
		return new DataAndView("userMap", userMap, null, SkipType.FORWARD);
	}
	
	public DataAndView userModifySubmit(HttpServletRequest request) throws Exception {
		//绑定form对象
		User user =  new User();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(user); 
        binder.bind(request);
        int row = userService.modifyUser(user);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView userDelete(HttpServletRequest request) {
		String params[] = request.getParameterValues("params[]");
		int flag = userService.deleteUserById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView modifyPassword(HttpServletRequest request){
		User user = (User)this.getSession().getAttribute("userModel");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String flag = "-1";
		if(user.getPassword().equals(oldPassword)){
			user.setPassword(newPassword);
			int suc = userService.modifyUserPassword(user);
			if(suc>0){
				flag = "1";
			}else{
				flag = "0";
			}
		}
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView modifyUserInfo(HttpServletRequest request){
		User user =  new User();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(user);
		binder.bind(request);
		
		User currentUser = (User)this.getSession().getAttribute("userModel");
		user.setUser_id(currentUser.getUser_id());
		user.setLogin_times(currentUser.getLogin_times()+1);
		int flag = userService.modifyUser(user);
		
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
