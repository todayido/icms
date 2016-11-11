package com.depart.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.depart.model.Depart;
import com.depart.service.DepartService;
import com.news.model.News;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class DepartController extends BaseController implements IController {

    private Depart depart;
    @Resource
	private SequenceGeneratorService sequenceGeneratorService;
	@Resource
	private DepartService departService;
	
	public DataAndView departMgrTreeIndex(HttpServletRequest request){
		return null;
	}
	
	public DataAndView departMgrTree(HttpServletRequest request){
		Map paramsMap = new HashMap();
		String parent_id = request.getParameter("id");
		
		StringBuffer stringBuffer = new StringBuffer();
		
		if(parent_id==null){
			stringBuffer.append("[{id:\"\",name:\"组织机构\",isParent:true,open:true,click:\"Open('组织机构','')\"}]");
		}else{
			paramsMap.put("parent_id", parent_id);
			//获取菜单列表
			List parentMenuList = departService.getDepartByParentId(paramsMap);
			stringBuffer.append("[");
			News menu;
			for(int i=0; i<parentMenuList.size();i++){
				depart = (Depart)parentMenuList.get(i);
				String isParent = "false";
				if(depart.getHas_next().equals("1")){
					isParent = "true";
				}
				stringBuffer.append("{");
				stringBuffer.append("id:\""+depart.getDepart_id()+"\",name:\""+depart.getName()+"\",open:true,isParent:"+isParent+",");
				stringBuffer.append("click:\"Open('"+depart.getName()+"','"+depart.getDepart_id()+"')\",");
				stringBuffer.append("open:true},");
			}
			stringBuffer.append("]");
		}
			
		return new DataAndView("json",stringBuffer.toString(),"",SkipType.FORWARD);
	}
	
	// index
	public DataAndView departIndex(HttpServletRequest request) throws Exception {
		String parent_id = request.getParameter("parent_id");
		return new DataAndView("parent_id", parent_id, null, SkipType.FORWARD);
	}
	
	// list
	public DataAndView departList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // cunrrent page
		int rows = Integer.parseInt(request.getParameter("rows")); // display count per page
		
		// seach params
		String parent_id = request.getParameter("parent_id");
		String name = request.getParameter("name");
		String is_show = request.getParameter("is_show");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("name", name);
		paramsMap.put("parent_id", parent_id);
		paramsMap.put("is_show", is_show);
		
		// page params
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();// new一个JSON
		jsonObj.accumulate("total", departService.getDepartCount(paramsMap));// total
		jsonObj.accumulate("rows", departService.getAllDeparts(paramsMap));// rows:data set
		
		return new DataAndView("departList", jsonObj, null, SkipType.FORWARD);
	}
	
	// add
	public DataAndView departAdd(HttpServletRequest request){
		String parent_id = request.getParameter("parent_id");
		return new DataAndView("parent_id", parent_id, null, SkipType.FORWARD);
	}
	
	// add submit
	public DataAndView departAddSubmit(HttpServletRequest request)  {
		// bind form object
		Depart depart =  new Depart();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(depart);
		binder.bind(request);
		
		depart.setDepart_id(sequenceGeneratorService.getCurrentPrimaryKey("z_depart"));
		depart.setHas_next("0");
		depart.setCreate_time(new Date());
		int row = departService.saveDepart(depart);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// modify
	public DataAndView departModify(HttpServletRequest request){
		String depart_id = request.getParameter("depart_id");
		Map departMap = departService.getDepartMapById(depart_id);
		return new DataAndView("depart", departMap, null, SkipType.FORWARD);
	}
	
	//modify submit
	public DataAndView departModifySubmit(HttpServletRequest request){
		// bind form object
		Depart depart =  new Depart();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(depart); 
		binder.bind(request);
		
		int row = departService.modifyDepart(depart);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// delete
	public DataAndView departDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = departService.deleteDepartById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	/**
	 * 组织机构选择对话框
	 * @param request
	 * @return
	 */
	public DataAndView departTreeIndex(HttpServletRequest request){
		return null;
	}
	
	public DataAndView departTree(HttpServletRequest request){
		Map paramsMap = new HashMap();
		String parent_id = request.getParameter("id");
		
		StringBuffer stringBuffer = new StringBuffer();
		if(parent_id==null){
			parent_id = "";
	    }
	    paramsMap.put("parent_id", parent_id);
	    //只查询有效的组织机构图
	    paramsMap.put("is_show", "1");
			
		//获取菜单列表
		List parentMenuList = departService.getDepartByParentId(paramsMap);
		stringBuffer.append("[");
		News menu;
		for(int i=0; i<parentMenuList.size();i++){
			depart = (Depart)parentMenuList.get(i);
			String isParent = "false";
			if(depart.getHas_next().equals("1")){
				isParent = "true";
			}
			stringBuffer.append("{");
			stringBuffer.append("id:\""+depart.getDepart_id()+"\",name:\""+depart.getName()+"\",open:true,isParent:"+isParent+",");
			stringBuffer.append("open:true},");
		}
		stringBuffer.append("]");
		return new DataAndView("json",stringBuffer.toString(),"",SkipType.FORWARD);
	}
	
	/*
	 * 只用于有效的组织结构的展示
	 */
	public DataAndView departTreeShowIndex(HttpServletRequest request){
		return null;
	}
	
	public DataAndView departTreeShow(HttpServletRequest request){
		Map paramsMap = new HashMap();
		String parent_id = request.getParameter("id");
		
		StringBuffer stringBuffer = new StringBuffer();
		if(parent_id==null){
			parent_id = "";
	    }
	    paramsMap.put("parent_id", parent_id);
	    paramsMap.put("is_show", "1");
			
		//获取菜单列表
		List parentMenuList = departService.getDepartByParentId(paramsMap);
		stringBuffer.append("[");
		News menu;
		for(int i=0; i<parentMenuList.size();i++){
			depart = (Depart)parentMenuList.get(i);
			String isParent = "false";
			if(depart.getHas_next().equals("1")){
				isParent = "true";
			}
			stringBuffer.append("{");
			stringBuffer.append("id:\""+depart.getDepart_id()+"\",name:\""+depart.getName()+"\",open:true,isParent:"+isParent+",");
			stringBuffer.append("open:true},");
		}
		stringBuffer.append("]");
		return new DataAndView("json",stringBuffer.toString(),"",SkipType.FORWARD);
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
