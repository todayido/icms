package com.item.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.item.model.Pay;
import com.item.service.PayService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class PayController extends BaseController implements IController {

    private Pay pay;
    @Resource
	private SequenceGeneratorService sequenceGeneratorService;
	@Resource
	private PayService payService;
	
	
	// index
	public DataAndView payIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	// list
	public DataAndView payList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // cunrrent page
		int rows = Integer.parseInt(request.getParameter("rows")); // display count per page
		
		// seach params
		String user_name = request.getParameter("user_name");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("user_name", user_name);
		
		// page params
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();// new一个JSON
		jsonObj.accumulate("total", payService.getPayCount(paramsMap));// total
		jsonObj.accumulate("rows", payService.getAllPays(paramsMap));// rows:data set
		
		return new DataAndView("payList", jsonObj, null, SkipType.FORWARD);
	}
	
	// add
	public DataAndView payAdd(HttpServletRequest request){
		return null;
	}
	
	// add submit
	public DataAndView payAddSubmit(HttpServletRequest request)  {
		// bind form object
		Pay pay =  new Pay();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(pay);
		binder.bind(request);
		
		pay.setPay_id(sequenceGeneratorService.getCurrentPrimaryKey("t_user_pay"));
		int row = payService.savePay(pay);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// modify
	public DataAndView payModify(HttpServletRequest request){
		String pay_id = request.getParameter("pay_id");
		pay = payService.getPayById(pay_id);
		return new DataAndView("pay", pay, null, SkipType.FORWARD);
	}
	
	//modify submit
	public DataAndView payModifySubmit(HttpServletRequest request){
		// bind form object
		Pay pay =  new Pay();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(pay); 
		binder.bind(request);
		
		int row = payService.modifyPay(pay);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// delete
	public DataAndView payDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = payService.deletePayById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
