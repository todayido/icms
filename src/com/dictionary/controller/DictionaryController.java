package com.dictionary.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.dictionary.model.Dictionary;
import com.dictionary.service.DictionaryService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class DictionaryController extends BaseController implements IController {

    private Dictionary dictionary;
    @Resource
	private SequenceGeneratorService sequenceGeneratorService;
	@Resource
	private DictionaryService dictionaryService;
	
	
	// index
	public DataAndView dictionaryIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	// list
	public DataAndView dictionaryList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // cunrrent page
		int rows = Integer.parseInt(request.getParameter("rows")); // display count per page
		
		// seach params
		String dic_name = request.getParameter("dic_name");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("dic_name", dic_name);
		
		// page params
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();// new一个JSON
		jsonObj.accumulate("total", dictionaryService.getDictionaryCount(paramsMap));// total
		jsonObj.accumulate("rows", dictionaryService.getAllDictionarys(paramsMap));// rows:data set
		
		return new DataAndView("dictionaryList", jsonObj, null, SkipType.FORWARD);
	}
	
	// add
	public DataAndView dictionaryAdd(HttpServletRequest request){
		return null;
	}
	
	// add submit
	public DataAndView dictionaryAddSubmit(HttpServletRequest request)  {
		// bind form object
		Dictionary dictionary =  new Dictionary();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(dictionary);
		binder.bind(request);
		
		dictionary.setDic_id(sequenceGeneratorService.getCurrentPrimaryKey("z_dictionary"));
		int row = dictionaryService.saveDictionary(dictionary);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// modify
	public DataAndView dictionaryModify(HttpServletRequest request){
		String dic_id = request.getParameter("dic_id");
		dictionary = dictionaryService.getDictionaryById(dic_id);
		return new DataAndView("dictionary", dictionary, null, SkipType.FORWARD);
	}
	
	//modify submit
	public DataAndView dictionaryModifySubmit(HttpServletRequest request){
		// bind form object
		Dictionary dictionary =  new Dictionary();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(dictionary); 
		binder.bind(request);
		
		int row = dictionaryService.modifyDictionary(dictionary);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// delete
	public DataAndView dictionaryDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = dictionaryService.deleteDictionaryById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
