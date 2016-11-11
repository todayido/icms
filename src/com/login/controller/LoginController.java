package com.login.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.item.model.Pay;
import com.item.service.PayService;
import com.manager.model.User;
import com.manager.service.RoleService;
import com.manager.service.UserService;

@Controller
public class LoginController extends BaseController implements IController{
	
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	@Resource
	private PayService payService;

	public DataAndView login(HttpServletRequest request){
		String redirectUrl = request.getParameter("redirectUrl");
		return new DataAndView("redirectUrl", redirectUrl, null, SkipType.REDIRECT);
	}
	
	public DataAndView doLogin(HttpServletRequest request){
		
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String redirectUrl = request.getParameter("redirectUrl");
		String nextAction;
		
		Map paramsMap = new HashMap();
		paramsMap.put("user_name", user_name);
		paramsMap.put("password", password);
		//有效用户才可以登陆
		paramsMap.put("status", 1);
		
		Map map = new HashMap();
		
		if(user_name==null || "".equals(user_name)){
			map.put("messages", "用户名不能为空！");
			return new DataAndView("map", map, null, SkipType.FORWARD);
		}else if(password==null ||"".equals(password)){
			map.put("messages", "密码名不能为空！");
			map.put("user_name", user_name);
			return new DataAndView("map", map, null, SkipType.FORWARD);
		}else{
			try{
				// 查询用户
				User user = userService.getUserInfo(paramsMap);
				
				if(user == null){
					map = new HashMap();
					map.put("messages", "用户不存在！");
					map.put("user_name", user_name);
					return new DataAndView("map", map, null, SkipType.FORWARD);
				}
				
				// 检测用户是否被锁定
				if(userService.getUserById(user.getUser_id()).getLogin_error_times()>2){
					map = new HashMap();
					map.put("messages", "该账号已经被锁定，请联系管理员！");
					map.put("user_name", user_name);
					return new DataAndView("map", map, null, SkipType.FORWARD);
				}
				
				// 判断用户是否存在
				if(user==null){
					map = new HashMap();
					map.put("messages", "用户名或密码不正确！");
					map.put("user_name", user_name);
					return new DataAndView("map", map, null, SkipType.FORWARD);
				}else{
					// 用户密码正确
					if(null!=user.getPassword() && !"".equals(user.getPassword()) && user.getPassword().equals(password)){
						this.getSession().setAttribute("userModel", user);
						
						// 用户的支付信息放入session
						if(null != user){
							Pay pay = payService.getPayByUserName(user_name);
							this.getSession().setAttribute("payModel", pay);
						}
						
						// 更新用户登录信息
						User userUpdate = new User();
						userUpdate.setUser_id(user.getUser_id());
						userUpdate.setLast_login_time(new Date());
						userUpdate.setLast_login_ip(request.getLocalAddr());
						userUpdate.setLogin_times(user.getLogin_times()+1);
						userService.modifyUser(userUpdate);
						//设置session过期时间：30分钟
						this.getSession().setMaxInactiveInterval(30*60);
						
						if(redirectUrl!=null && redirectUrl!=""){
							nextAction = "/"+redirectUrl;
						}else{
							nextAction = "/main.htm";
						}
						
						return new DataAndView(null, null, nextAction, SkipType.REDIRECT);
					}else{
						User userUpdate = new User();
						userUpdate.setUser_id(user.getUser_id());
						userService.modifyUserErrorTimes(userUpdate);
						
						map = new HashMap();
						map.put("messages", "密码不正确，还有"+
								(4-(userService.getUserById(user.getUser_id())).getLogin_error_times())+"机会，账号将被锁定！");
						map.put("user_name", user_name);
						map.put("error_times", user.getLogin_error_times());
						
						return new DataAndView("map", map, null, SkipType.REDIRECT);
					}
				}
			}catch(Exception e){
				logger().error("用户登录失败！");
				e.printStackTrace();
				map = new HashMap();
				map.put("messages", "用户名或密码不正确！");
				return new DataAndView("map", map, "/login/login.htm", SkipType.FORWARD);
			}
		}
	}
	
	public DataAndView logout(HttpServletRequest request) throws Exception {
		this.getSession().invalidate();
		// 返回网站主页
		return new DataAndView(null, null, "/", SkipType.REDIRECT);
	}
	
	/**
	 * 后台管理登录
	 * @param request
	 * @return
	 */
	public DataAndView manageLogin(HttpServletRequest request){
		return null;
	}
	
	public DataAndView doManageLogin(HttpServletRequest request){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map paramsMap = new HashMap();
		paramsMap.put("username", username);
		paramsMap.put("password", password);
		//有效用户才可以登陆
		paramsMap.put("status", 1);
		Map map;
		
		try{
			// 查询用户
			User user = userService.getUserInfo(paramsMap);
			// 判断用户是否存在
			if(user==null){
				map = new HashMap();
				map.put("messages", "用户名或密码不正确！");
				map.put("username", username);
				return new DataAndView("map", map, null, SkipType.FORWARD);
			}else{
				// 判断用户密码是否正确
				if(null!=user.getPassword() && !"".equals(user.getPassword()) && user.getPassword().equals(password)){
					this.getSession().setAttribute("userModel", user);
					// 更新用户登录信息
					User userUpdate = new User();
					userUpdate.setUser_id(user.getUser_id());
					userUpdate.setLast_login_time(new Date());
					userUpdate.setLast_login_ip(request.getLocalAddr());
					userUpdate.setLogin_times(user.getLogin_times()+1);
					userService.modifyUser(userUpdate);
					//设置session过期时间：30分钟
					this.getSession().setMaxInactiveInterval(30*60);
					return new DataAndView(null, null, "/manage/mainFrame.htm", SkipType.REDIRECT);
				}else{
					map = new HashMap();
					map.put("messages", "用户名或密码不正确！");
					map.put("username", username);
					return new DataAndView("map", map, null, SkipType.REDIRECT);
				}
			}
		}catch(Exception e){
			logger().error("用户登录失败！");
			e.printStackTrace();
			map = new HashMap();
			map.put("messages", "用户名或密码不正确！");
			return new DataAndView("map", map, "/login/manageLogin.htm", SkipType.FORWARD);
		}
	}
	
	public DataAndView manageLogout(HttpServletRequest request) throws Exception {
		this.getSession().invalidate();
		return new DataAndView(null, null, "/login/manageLogin.htm", SkipType.REDIRECT);
	}

	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}
	
}
