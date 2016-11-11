package com.component.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.component.model.Component;
import com.component.service.ComponentService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class ComponentController extends BaseController implements IController {

	private Component component;
	@Resource
	private ComponentService componentService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	
	public DataAndView componentIndex(HttpServletRequest ra) throws Exception {
		return null;
	}
	
	public DataAndView componentList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String issingleton = request.getParameter("issingleton");
		String componentname = request.getParameter("componentname");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("issingleton", issingleton);
		paramsMap.put("componentname", componentname);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", componentService.getComponentCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", componentService.getAllComponents(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("componentList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView componentAdd(HttpServletRequest request){
		return null;
	}
	
	public DataAndView componentAddSubmit(HttpServletRequest request)  {
		//绑定form对象
		Component component =  new Component();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(component); 
        binder.bind(request);
        
		component.setComponentid(sequenceGeneratorService.getCurrentPrimaryKey("z_component"));
		int row = componentService.saveComponent(component);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView componentModify(HttpServletRequest request){
		String componentid = request.getParameter("componentid");
		component = componentService.getComponentById(componentid);
		return new DataAndView("component", component, null, SkipType.FORWARD);
	}
	
	public DataAndView componentModifySubmit(HttpServletRequest request){
		//绑定form对象
		Component component =  new Component();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(component); 
        binder.bind(request);
        
        int row = componentService.modifyComponent(component);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView componentDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = componentService.deleteComponentById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}

	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
