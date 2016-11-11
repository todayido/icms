package com.item.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.aspectj.weaver.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.item.model.Pay;
import com.item.model.Paylog;
import com.item.service.PayService;
import com.item.service.PaylogService;
import com.manager.model.User;
import com.utils.UUIDGenerator;
import com.utils.UtilsDate;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class PaylogController extends BaseController implements IController {

    private Paylog payLog;
    @Resource
	private SequenceGeneratorService sequenceGeneratorService;
    @Resource
	private PayService payService;
	@Resource
	private PaylogService payLogService;
	
	
	// index
	public DataAndView payLogIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	// list
	public DataAndView payLogList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // cunrrent page
		int rows = Integer.parseInt(request.getParameter("rows")); // display count per page
		
		// seach params
		String user_name = request.getParameter("user_name");
		String state = request.getParameter("state");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("user_name", user_name);
		paramsMap.put("state", state);
		
		// page params
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();// new一个JSON
		jsonObj.accumulate("total", payLogService.getPaylogCount(paramsMap));// total
		jsonObj.accumulate("rows", payLogService.getAllPaylogs(paramsMap));// rows:data set
		
		return new DataAndView("payLogList", jsonObj, null, SkipType.FORWARD);
	}
	
	// add
	public DataAndView payLogAdd(HttpServletRequest request){
		return null;
	}
	
	// add submit
	public DataAndView payLogAddSubmit(HttpServletRequest request)  {
		// bind form object
		Paylog payLog =  new Paylog();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(payLog);
		binder.bind(request);
		
		payLog.setApply_time(UtilsDate.getStringDate());
		// 提交后状态为审核状态
		payLog.setState("0");
		payLog.setType("1");
		
		User member = (User) this.getSession().getAttribute("userModel");
		
		payLog.setUser_id(member.getUser_id());
		payLog.setUser_name(member.getUser_name());
		
		int row = payLogService.savePaylog(payLog);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// modify
	public DataAndView payLogModify(HttpServletRequest request){
		String user_pay_log_id = request.getParameter("user_pay_log_id");
		payLog = payLogService.getPaylogById(user_pay_log_id);
		return new DataAndView("payLog", payLog, null, SkipType.FORWARD);
	}
	
	//modify submit
	public DataAndView payLogModifySubmit(HttpServletRequest request){
		// bind form object
		Paylog payLog =  new Paylog();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(payLog); 
		binder.bind(request);
		
		int row = payLogService.modifyPaylog(payLog);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// delete
	public DataAndView payLogDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = payLogService.deletePaylogById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	// 支付宝转账充值
	public DataAndView zhifubao(HttpServletRequest request) throws Exception{
		return null;
		
	}
	
	public DataAndView zhifubaoSubmit(HttpServletRequest request) throws Exception{
		
		String pay_zhanghao = request.getParameter("pay_zhanghao");
		String money = request.getParameter("money");
		String beizhu = request.getParameter("beizhu");
		
		User member = (User) this.getSession().getAttribute("userModel");
		
		if(null==member){
			return new DataAndView(null, null, "/login/login/htm", SkipType.REDIRECT);
		}
		
		Paylog payLog = new Paylog();
		payLog.setUser_pay_log_id(UUIDGenerator.getUUID());
		payLog.setApply_time(UtilsDate.getStringDate());
		payLog.setUser_id(member.getUser_id());
		payLog.setUser_name(member.getUser_name());
		payLog.setPay_zhanghao(pay_zhanghao);
		payLog.setMoney(money);
		payLog.setBeizhu(beizhu);
		payLog.setType("1");
		payLog.setState("0");
		
		int flag = payLogService.savePaylog(payLog);
		String message = "";
		
		if(flag>0){
			message = "申请成功!<br>请在20分钟内将充值金额转入以下支付宝账户：<br><span style='color:#F3726D'>hojunf@163.com</span>";
		}else{
			message = "请联系在线客服索要支付宝账号，再进行充值！";
		}
		
		return new DataAndView("message",message,null,SkipType.REDIRECT); 
		
	}
	
	// 后台充值审核
	public DataAndView audit(HttpServletRequest request){
		String user_pay_log_id = request.getParameter("user_pay_log_id");
		payLog = payLogService.getPaylogById(user_pay_log_id);
		return new DataAndView("payLog", payLog, null, SkipType.FORWARD);
	}
	
	// 充值审核提交
	public DataAndView auditSubmit(HttpServletRequest request){
		// bind form object
		Paylog payLog =  new Paylog();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(payLog); 
		binder.bind(request);
		
		payLog.setCheck_time(UtilsDate.getStringDate());
		
		// 审核通过，账号资金=原有金额+申请充值金
		// 根据用户ID和用户名，修改用户的账户信息
		int paySuccess = 0;
		if("1".equals(payLog.getState())){
			Map paramsMap = new HashMap();
			paramsMap.put("user_id", payLog.getUser_id());
			paramsMap.put("user_name", payLog.getUser_name());
			paramsMap.put("money", payLog.getMoney());
			
			paySuccess = payService.paySuccess(paramsMap);
			
			// 充值失败，直接返回
			if(paySuccess==0){
				return new DataAndView("flag", 0, null, SkipType.FORWARD);
			}
		}
		
		// 充值成功，该充值记录已审核
		int row = payLogService.modifyPaylog(payLog);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// 提现申请
	public DataAndView withdraw(HttpServletRequest request){
		User member = (User) this.getSession().getAttribute("userModel");
		Pay pay = payService.getPayByUserName(member.getUser_name());
		
		if(null==member){
			// 未登录
			return new DataAndView(null, null, "/login/login/htm", SkipType.REDIRECT);
		}else{
			return null;
		}
	}
	
	public DataAndView withdrawSubmit(HttpServletRequest request){
		String anquanma = request.getParameter("anquanma");
		String money = request.getParameter("money");
		String beizhu = request.getParameter("beizhu");
		
		User member = (User) this.getSession().getAttribute("userModel");
		
		if(null==member){
			// 未登录
			return new DataAndView(null, null, "/login/login.htm", SkipType.REDIRECT);
		}

		
		Pay pay = payService.getPayByUserName(member.getUser_name());
		
		if(anquanma==null || "".equals(anquanma)){
			// 安全码不能为空
			return new DataAndView("message", "<span style='color:red'>安全码不能为空，请重新输入！</span>", null, SkipType.REDIRECT);
		}
		
		if(money==null || "".equals(money)){
			// 提款金额不能为空
			return new DataAndView("message", "<span style='color:red'>提款金额不能为空，请重新输入！</span>", null, SkipType.REDIRECT);
			
		}
		
		if(pay.getWeigui_cishu()>2){
			// 违规操作，无法进行提款
			return new DataAndView("message", "<span style='color:red'>违规操作，暂不能提款，请联系客服！</span>", null, SkipType.REDIRECT);
		}
		
		if(!anquanma.equals(pay.getAnquanma())){
			// 安全码不正确,三次错误后禁止提款
			pay.setWeigui_cishu(pay.getWeigui_cishu()+1);
			payService.modifyWeiguiCishu(pay);
			return new DataAndView("message", "<span style='color:red'>安全码不正确，还有"+(4-pay.getWeigui_cishu())+"次机会，否则将不能提款，请重新输入！</span>", null, SkipType.REDIRECT);
		}
		
		double tiKuanJinE = Double.parseDouble(money);
		if(tiKuanJinE>pay.getUser_jine()){
			// 取款金额不能大于总金额
			return new DataAndView("message", "<span style='color:red'>取款金额不能大于总金额，请重新输入！</span>", null, SkipType.REDIRECT);
		}else{
			
			Paylog payLog = new Paylog();
			payLog.setUser_pay_log_id(UUIDGenerator.getUUID());
			payLog.setApply_time(UtilsDate.getStringDate());
			payLog.setUser_id(member.getUser_id());
			payLog.setUser_name(member.getUser_name());
			payLog.setPay_zhanghao(pay.getZhifubao());
			payLog.setMoney(money);
			payLog.setBeizhu(beizhu);
			payLog.setType("1");
			payLog.setState("0");
			
			payLogService.savePaylog(payLog);
			
			// 扣除账户资金
			String pay_id = pay.getPay_id();
			pay.setUser_jine(tiKuanJinE);
			pay.setPay_id(pay.getPay_id());
			
			payService.kouChuJinE(pay);
			
			return new DataAndView("message", "申请成功，审核后资金将转入您的支付宝账户，请注意查收！", null, SkipType.REDIRECT);
		}
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
