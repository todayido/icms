package com.template.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.template.model.Template;
import com.template.service.TemplateService;
import com.utils.UtilsFile;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class TemplateController extends BaseController implements IController {

	private Template template;
	@Resource
	private TemplateService templateService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	public DataAndView templateIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	public DataAndView templateList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String templatename = request.getParameter("templatename");
		
		Map paramsMap = new HashMap<String, String>();
        paramsMap.put("templatename", templatename);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", templateService.getTemplateCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", templateService.getAllTemplates(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("templateList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView templateAdd(HttpServletRequest request){
		return null;
	}
	
	public DataAndView templateAddSubmit(HttpServletRequest request)  {
		//绑定form对象
		Template template =  new Template();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(template); 
        binder.bind(request);
        
        template.setTemplatename(template.getTemplatename()+".ftl");
		template.setTemplateid(sequenceGeneratorService.getCurrentPrimaryKey("z_template"));
		template.setCreatetime(new Date());
		int row = templateService.saveTemplate(template);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView templateModify(HttpServletRequest request){
		String templateid = request.getParameter("templateid");
		template = templateService.getTemplateById(templateid);
		return new DataAndView("template", template, null, SkipType.FORWARD);
	}
	
	public DataAndView templateModifySubmit(HttpServletRequest request){
		//绑定form对象
		Template newTemplate = new Template();
		Template oldTemplate = new Template();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(newTemplate); 
        binder.bind(request);
        
        oldTemplate = templateService.getTemplateById(newTemplate.getTemplateid());
        
        //修改文件名
        if(!newTemplate.getTemplatename().equals(oldTemplate.getTemplatename())){
            String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/template/";
        	File oldFile = new File(path+oldTemplate.getTemplatename());
            if(oldFile.isFile() && oldFile.exists()){
            	oldFile.renameTo(new File(path+newTemplate.getTemplatename()));
            }
        }
        
        newTemplate.setCreatetime(new Date());
        int row = templateService.modifyTemplate(newTemplate);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView templateDelete(HttpServletRequest request){
		Template template;
		File file;
		String path;
		String params[] = request.getParameterValues("params[]");
		
		//删除模版文件
		for(String templateId : params){
			template = templateService.getTemplateById(templateId);
			path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/template/";
			file = new File(path+template.getTemplatename());
			if(file.isFile() && file.exists()){
				file.delete();
			}
		}
		
		int flag = templateService.deleteTemplateById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView templateEdit(HttpServletRequest request){
		String templateid = request.getParameter("templateid");
		template = templateService.getTemplateById(templateid);
		
		//模板路径
		String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/template/";
		File file = new File(path+template.getTemplatename());
		String fileContent = UtilsFile.getFtlContent(file);
		
		Map map = new HashMap();
		map.put("template", template);
		map.put("fileContent", fileContent);
		
		return new DataAndView("map", map, null, SkipType.FORWARD);
	}
	
	public DataAndView templateEditSubmit(HttpServletRequest request){
		//绑定form对象
		String templatename = request.getParameter("templatename");
		String fileContent = request.getParameter("fileContent");
		
		String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/template/";
		File file = new File(path+templatename);
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
