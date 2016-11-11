package com.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.item.model.Pay;
import com.item.service.PayService;
import com.manager.model.User;
import com.manager.service.UserService;

@Controller
public class MemberController extends BaseController implements IController {

    private User member;
	@Resource
	private UserService userService;
	@Resource
	private PayService payService;
	
	
	// 会员信息
	public DataAndView memberInfo(HttpServletRequest request) throws Exception {
		member = (User) this.getSession().getAttribute("userModel");
		
		String phone = member.getPhone();
		if(null!=phone && !"".equals(phone)){
			member.setPhone(phone.substring(0, 3)+"********");
		}
		
		String email = member.getEmail();
		if(null!=email && !"".equals(email)){
			member.setEmail(email.substring(0,1)+"********"+email.substring(email.lastIndexOf("@"), email.length()));
		}
		
		return new DataAndView("member",member,null,SkipType.REDIRECT);
	}
	
	// 密码修改
	public DataAndView modifyPass(HttpServletRequest request) throws Exception {
		return null;
	}
	
	// 密码修改提交
	public DataAndView modifyPassSumit(HttpServletRequest request) throws Exception {
		
		String anquanma = request.getParameter("anquanma");
		String old_pass = request.getParameter("old_pass");
		String new_pass1 = request.getParameter("new_pass1");
		String new_pass2 = request.getParameter("new_pass2");
		
		Map map = new HashMap();
		String message = "'";
		
		if(null==old_pass || null == new_pass1 || null == new_pass2 || null == anquanma || "".equals(old_pass) || "".equals(new_pass1) || "".equals(new_pass2) || "".equals(anquanma)){
			message = "密码或安全码不能为空，请重新输入！";
		}else if(!old_pass.equals(member.getPassword())){
			message = "原密码不正确，请重新输入！";
		}else if(!new_pass1.equals(new_pass2)){
			message = "两次密码不一致，请重新输入！";
		}else{
			member = (User) this.getSession().getAttribute("userModel");
			Pay pay = payService.getPayByUserName(member.getUser_name());
			
			if(!pay.getAnquanma().equals(anquanma)){
				message = "安全码不正确，请重新输入！";
			}else{
				member.setPassword(new_pass1);
				int flag = userService.modifyUserPassword(member);
				if(flag>0){
					message = "密码修改成功！";
				}else{
					message = "密码修改失败，请联系管理员！";
				}
			}
			
		}
		
		return new DataAndView("map",message,null,SkipType.REDIRECT);
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
