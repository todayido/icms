package com.action.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.action.model.Action;
import com.action.service.ActionService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;
import com.template.service.TemplateService;

@Controller
public class ActionController extends BaseController implements IController {

	private Action action;
	@Resource
	private ActionService actionService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	@Resource
	private TemplateService templateService;
	
	public DataAndView actionIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	public DataAndView actionList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String actionid = request.getParameter("actionid");
		String actionname = request.getParameter("actionname");
		
		Map paramsMap = new HashMap<String, String>();
        paramsMap.put("actionid", actionid);
        paramsMap.put("actionname", actionname);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", actionService.getActionCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", actionService.getAllActions(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("actionList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView actionAdd(HttpServletRequest request){
		//获取所有模板数据
		List templateList = templateService.getAllTemplates();
		return new DataAndView("templateList", templateList, null, SkipType.FORWARD);
	}
	
	public DataAndView actionAddSubmit(HttpServletRequest request)  {
		//绑定form对象
		Action action =  new Action();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(action); 
        binder.bind(request);
        
        action.setCreatetime(new Date());
		action.setActionid(sequenceGeneratorService.getCurrentPrimaryKey("z_action"));
		int row = actionService.saveAction(action);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView actionModify(HttpServletRequest request){
		Map resultMap = new HashMap();
		//获取所有模板数据
		List templateList = templateService.getAllTemplates();
		resultMap.put("templateList", templateList);
		
		String actionid = request.getParameter("actionid");
		action = actionService.getActionById(actionid);
		resultMap.put("action", action);
		
		return new DataAndView("resultMap", resultMap, null, SkipType.FORWARD);
	}
	
	public DataAndView actionModifySubmit(HttpServletRequest request){
		//绑定form对象
		Action action =  new Action();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(action); 
        binder.bind(request);
        
        int row = actionService.modifyAction(action);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView actionDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = actionService.deleteActionById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}

	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
