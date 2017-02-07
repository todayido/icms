package com.newsproperty.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.newsproperty.model.Newsproperty;
import com.newsproperty.service.NewspropertyService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class NewspropertyController extends BaseController implements IController {

	private Newsproperty newsproperty;
	@Resource
	private NewspropertyService newspropertyService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	public DataAndView newspropertyIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	public DataAndView newspropertyList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String blockid = request.getParameter("blockid");
		String title = request.getParameter("title");
		
		Map paramsMap = new HashMap<String, String>();
        paramsMap.put("blockid", blockid);
        paramsMap.put("title", title);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", newspropertyService.getNewspropertyCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", newspropertyService.getAllNewspropertys(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("newspropertyList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView newspropertyAdd(HttpServletRequest request){
		return null;
	}
	
	public DataAndView newspropertyAddSubmit(HttpServletRequest request)  {
		//绑定form对象
		Newsproperty newsproperty =  new Newsproperty();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(newsproperty); 
        binder.bind(request);
        
		newsproperty.setBlockid(sequenceGeneratorService.getCurrentPrimaryKey("t_news_property"));
		newsproperty.setCreatetime(new Date());
		int row = newspropertyService.saveNewsproperty(newsproperty);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView newspropertyModify(HttpServletRequest request){
		String blockid = request.getParameter("blockid");
		newsproperty = newspropertyService.getNewspropertyById(blockid);
		return new DataAndView("newsproperty", newsproperty, null, SkipType.FORWARD);
	}
	
	public DataAndView newspropertyModifySubmit(HttpServletRequest request){
		//绑定form对象
		Newsproperty newsproperty =  new Newsproperty();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(newsproperty); 
        binder.bind(request);
        newsproperty.setCreatetime(new Date());
        int row = newspropertyService.modifyNewsproperty(newsproperty);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView newspropertyDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = newspropertyService.deleteNewspropertyById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}

	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
