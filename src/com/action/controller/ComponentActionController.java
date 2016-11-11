package com.action.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.action.model.Action;
import com.action.service.ActionService;
import com.core.controller.BaseController;
import com.core.controller.ControllerBeanFactory;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;
import com.template.service.TemplateService;
import com.view.model.View;
import com.view.service.ViewService;
/**
 * 解析动作的配置文件
 */
@Controller
public class ComponentActionController extends BaseController implements IController {
	
	static Logger logger = Logger.getLogger(ControllerBeanFactory.class.toString());
	
	@Resource
	private ActionService actionService;
	@Resource
	private TemplateService templateService;
	@Resource
	private ViewService viewService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	public DataAndView componentActionIndex(HttpServletRequest request) throws Exception {
		String confpath = request.getParameter("confpath");
		String blockid = request.getParameter("blockid");
		if(null==blockid){
			blockid = "";
		}else{
			blockid = "&blockid="+blockid;
		}
		return new DataAndView("confpath", confpath+blockid, null, SkipType.FORWARD);
	}
	
	public DataAndView componentActionList(HttpServletRequest request){
		
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		String actionConfPath = request.getParameter("confpath");
		String blockid = request.getParameter("blockid");
		
		//查询参数
		String actionname = request.getParameter("actionname");
		
		try {
			//解析配置文件
			SAXReader saxReader = new SAXReader();
			Document doc = saxReader.read(new File(this.getClass().getResource("/").getPath() + actionConfPath));
			Element componentsElement = doc.getRootElement();
			
			String componentPackage = componentsElement.attributeValue("package");
			
			 /*
			 * 动作的类型，json，html。
			 * 动作类型为html可以配置多个视图，在ControllerBeanFactory中动的默认视图为第一个。
			 * 但是动作配置的时候加载全部，配置之后使用配置的视图，不再使用第一个作为默认。
			 */
			List resultList = new ArrayList();
			Action action = null;
			Iterator it = componentsElement.elementIterator();
			while(it.hasNext()){
				Element actionElement = (Element)it.next();
				//动作类型
				String type = actionElement.attributeValue("type");
				//动作名称
				String name = actionElement.attributeValue("name");
				//动作id
				String id = actionElement.attributeValue("id");
				//栏目block
				String actionUrl = componentPackage;
				if(blockid!=null && !"".equals(blockid)){
					actionUrl = actionUrl+"/"+id+"/"+blockid;
				}else{
					actionUrl = actionUrl+"/"+id;
				}
				
				if(actionname!=null && !"".equals(actionname)){
					if(name.contains(actionname)){
						Map actionMap = new HashMap();
						actionMap.put("actiontype", type);
						actionMap.put("actionname", name);
						actionMap.put("actionurl", actionUrl);
						//获取数据库中动作配置信息
						action = actionService.getActionByUri(actionUrl);
						if(action!=null){
							actionMap.put("contentfile", action.getContentfile());
							actionMap.put("viewfile", action.getViewfile());
						}
						resultList.add(actionMap);
					}
				}else{
					Map actionMap = new HashMap();
					actionMap.put("actiontype", type);
					actionMap.put("actionname", name);
					actionMap.put("actionurl", actionUrl);
					//获取数据库中动作配置信息
					action = actionService.getActionByUri(actionUrl);
					if(action!=null){
						actionMap.put("contentfile", action.getContentfile());
						actionMap.put("viewfile", action.getViewfile());
					}
					resultList.add(actionMap);
				}
				
			}
			
			JSONObject jsonObj = new JSONObject();//new一个JSON
			jsonObj.accumulate("total", resultList.size());//total代表一共有多少数据
			
			/*
			 * 分页调整
			 */
			int begin = (page - 1) * rows;
			int end = 0;
			
			if(begin+rows<=resultList.size()){
				end = begin+rows;
			}else{
				end = resultList.size();
			}
				
			resultList = resultList.subList(begin, end);
			jsonObj.accumulate("rows", resultList);//rows是代表显示的页的数据集合
			return new DataAndView("list", jsonObj, null, SkipType.FORWARD);
			
		}catch (Exception e) {
			logger.debug(this.getClass().toString()+"【加载组件动作配置文件出错！】");
			e.printStackTrace();
		}
		return null;
	}
	
public DataAndView componentActionModify(HttpServletRequest request){
		
		String actionurl = request.getParameter("actionurl");
		String confpath = request.getParameter("confpath");
		
		Map resultMap = new HashMap();
		List viewList = new ArrayList();
		
		String []urlSrting = actionurl.split("/");
		String actionId = urlSrting[1];
		
		//获取所有模板数据
		List templateList = templateService.getAllTemplates();
		resultMap.put("templateList", templateList);
		
		//获取自定义视图
		Map map = new HashMap();
		map.put("viewtype", urlSrting[0]);
		viewList = viewService.getViewsByType(map);
		
		try {
			//解析配置文件
			SAXReader saxReader = new SAXReader();
			Document doc = saxReader.read(new File(this.getClass().getResource("/").getPath() + confpath));
			Element componentsElement = doc.getRootElement();
			
			Iterator it = componentsElement.elementIterator();
			while(it.hasNext()){
				Element actionElement = (Element)it.next();
				String id = actionElement.attributeValue("id");
				if(actionId.equals(id)){
					//解析系统视图文件
					Iterator i = actionElement.elementIterator();
					while(i.hasNext()){
						Element viewElement = (Element)i.next();
						String viewname = viewElement.attributeValue("name");
						String viewpath = viewElement.getTextTrim();
						
						View view = new View();
						view.setViewname(viewname);
						view.setViewpath(viewpath);
						viewList.add(view);
					}
					break;
				}
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		resultMap.put("viewList", viewList);
		
		Action action = actionService.getActionByUri(actionurl);
		if(action!=null){
			resultMap.put("action", action);
		}else{
			action = new Action();
			action.setActionid("");
			action.setActionurl(actionurl);
			action.setActionname("");
			action.setContentfile("");
			action.setViewfile("");
			action.setDescription("");
			resultMap.put("action", action);
		}
		
		return new DataAndView("resultMap", resultMap, null, SkipType.FORWARD);
	}

	public DataAndView componentActionModifySubmit(HttpServletRequest request){
		//绑定form对象
		Action action =  new Action();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(action); 
	    binder.bind(request);
	    
	    int row = 0;
	    //判断是新增还是修改
	    if(action.getActionid()==null || "".equals(action.getActionid())){
	    	action.setActionid(sequenceGeneratorService.getCurrentPrimaryKey("z_action"));
	    	action.setCreatetime(new Date());
	    	row = actionService.saveAction(action);
	    }else{
	    	row = actionService.modifyAction(action);
	    }
	    
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}


	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
