package com.view.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.utils.UtilsFile;
import com.view.model.View;
import com.view.service.ViewService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class ViewController extends BaseController implements IController {

	private View view;
	@Resource
	private ViewService viewService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	public DataAndView viewIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	public DataAndView viewList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String viewname = request.getParameter("viewname");
		String viewtype = request.getParameter("viewtype");
		
		Map paramsMap = new HashMap<String, String>();
        paramsMap.put("viewname", viewname);
        paramsMap.put("viewtype", viewtype);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", viewService.getViewCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", viewService.getAllViews(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("viewList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView viewAdd(HttpServletRequest request){
		return null;
	}
	
	public DataAndView viewAddSubmit(HttpServletRequest request){
		//绑定form对象
		View view =  new View();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(view); 
        binder.bind(request);
        
		view.setViewid(sequenceGeneratorService.getCurrentPrimaryKey("z_view"));
		view.setCreatetime(new Date());
		view.setViewpath("templates/views/"+view.getViewtype()+"/"+view.getViewname()+".ftl");
		int row = viewService.saveView(view);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView viewModify(HttpServletRequest request){
		String viewid = request.getParameter("viewid");
		view = viewService.getViewById(viewid);
		return new DataAndView("view", view, null, SkipType.FORWARD);
	}
	
	public DataAndView viewModifySubmit(HttpServletRequest request){
		//绑定form对象
		View newView =  new View();
		View oldView =  new View();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(newView); 
        binder.bind(request);
        
        oldView = viewService.getViewById(newView.getViewid());
        
        //修改文件名
        if(!newView.getViewpath().equals(oldView.getViewpath())){
            String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/"+oldView.getViewpath();
        	File oldFile = new File(path);
        	String newFilePath = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/views/"+view.getViewtype()+"/"+view.getViewname()+".ftl";
        	newView.setViewpath("templates/views/"+view.getViewtype()+"/"+view.getViewname()+".ftl");
            if(oldFile.isFile() && oldFile.exists()){
            	oldFile.renameTo(new File(newFilePath));
            }
        }
        
        newView.setCreatetime(new Date());
        int row = viewService.modifyView(newView);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView viewDelete(HttpServletRequest request){
		View view;
		File file;
		String path;
		String params[] = request.getParameterValues("params[]");
		
		//删除视图文件
		for(String viewid : params){
			view = viewService.getViewById(viewid);
			path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/"+view.getViewpath();
			file = new File(path);
			if(file.exists()){
				file.delete();
				//判断文件夹是否为空，为空则删除文件夹
				file = new File(path);
				if(file.isDirectory() && file.list().length<1){
					file.delete();
				}
			}
		}
		int flag = viewService.deleteViewById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView viewEdit(HttpServletRequest request){
		String viewid = request.getParameter("viewid");
		view = viewService.getViewById(viewid);
		
		//视图路径
		String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/views/"+view.getViewtype()+"/";
		File dic = new File(path);
		if(!dic.exists() && !dic.isDirectory()){
			dic.mkdir();
		}
		File file = new File(this.getSession().getServletContext().getRealPath("")+"/WEB-INF/"+view.getViewpath());
		String fileContent = UtilsFile.getFtlContent(file);
		
		Map map = new HashMap();
		map.put("view", view);
		map.put("fileContent", fileContent);
		
		return new DataAndView("map", map, null, SkipType.FORWARD);
	}
	
	public DataAndView viewEditSubmit(HttpServletRequest request){
		//绑定form对象
		String viewfile = request.getParameter("viewfile");
		String viewtype = request.getParameter("viewtype");
		String fileContent = request.getParameter("fileContent");
		
		String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/";
		File file = new File(path+viewfile);
		if(fileContent==null){
			fileContent = "";
		}
		int flag = UtilsFile.setFtlContent(file, fileContent);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}

	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
