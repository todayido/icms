package com.login.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.Sequence;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;
import com.item.model.Pay;
import com.item.service.PayService;
import com.manager.dao.UserDao;
import com.manager.model.User;
import com.manager.service.RoleService;
import com.manager.service.UserService;
import com.utils.UtilsDate;

@Controller
public class RegisterController extends BaseController implements IController{
	
	@Resource
	private UserDao userDao;
	@Resource
	private PayService payService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;

	public DataAndView register(HttpServletRequest request){
		return null;
	}
	
	public DataAndView doRegister(HttpServletRequest request){
		User user =  new User();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(user);
        binder.bind(request);
        
        String anquanma = request.getParameter("anquanma");
        String user_name = user.getUser_name();
        
        Map paramsMap = new HashMap();

        // 用户名不能为空，长度必须为8-20字符之前才能注册
        if(user_name==null || "".equals(user_name)){
        	return new DataAndView("message", "<span style='color:red'>请填写用户名！</span>", null, SkipType.REDIRECT);
        }
        
        if(anquanma==null || "".equals(anquanma)){
        	return new DataAndView("message", "<span style='color:red'>安全码不能为空，提款时需要验证安全码，请认真填写！</span>", null, SkipType.REDIRECT);
        }
        
        // 用户名不能重复
        paramsMap.put("user_name", user.getUser_name());
        User u = userDao.getUserInfo(paramsMap);
        
        if(null != u){
        	return new DataAndView("message", "<span style='color:red'>用户名已经存在，请重新输入！</span>", null, SkipType.REDIRECT);
        }
        
        user.setUser_id(sequenceGeneratorService.getCurrentPrimaryKey("z_user"));
        user.setReg_time(new Date());
        user.setLogin_error_times(0);
        user.setLogin_times(0);
        user.setPriority("0");
        user.setStatus("1");
        
        int flag = userDao.saveUser(user);
        
        if(flag>0){
        	
        	Pay pay =new Pay();
        	pay.setPay_id(sequenceGeneratorService.getCurrentPrimaryKey("t_user_pay"));
        	pay.setUser_dongjie(0);
        	pay.setUser_id(user.getUser_id());
        	pay.setUser_jine(0);
        	pay.setUser_name(user.getUser_name());
        	pay.setWeigui_cishu(0);
        	pay.setAnquanma(anquanma);
        	
        	flag = payService.savePay(pay);
        	
        	if(flag>0){
        		return new DataAndView("message", "注册成功！<a href='/login/login.htm'>点此登录</a>", null, SkipType.REDIRECT);
        	}
        	
        }
        
        return new DataAndView("message", "无法完成注册，请联系管理员！", null, SkipType.REDIRECT);
		
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}
	
}
