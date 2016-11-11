package com.core.template;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.action.model.Action;
import com.core.controller.ControllerBeanFactory;
import com.core.controller.IController;
import com.core.controller.MainController;
import com.core.model.ControllerModel;
import com.core.model.ControllerView;
import com.core.model.DataAndView;
import com.core.model.DataModel;
import com.core.service.CommonService;
import com.core.service.TemplateRenderService;
import com.core.service.impl.CommonServiceImpl;

import freemarker.core.Environment;
import freemarker.template.Template;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
public class TemplateDirectiveBlock implements TemplateDirectiveModel {

	TemplateRenderService templateRenderService = new TemplateRenderService();
	CommonService commonService = new CommonServiceImpl();
	
	public void execute(Environment env, Map map, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = attr.getRequest();
		
		Writer out = env.getOut();
		
		String componentId = "";
		String actionId = "";
		String blockId = "";
		String viewId = "";
		
		if (map.containsKey("component") && map.get("component") != null) {
			componentId = map.get("component").toString();
		}
		
		if (map.containsKey("action_id") && map.get("action_id") != null) {
			actionId = map.get("action_id").toString();
		}
		
		if (map.containsKey("block_id") && map.get("block_id") != null) {
			blockId = map.get("block_id").toString();
		}
		
		if (map.containsKey("view_id") && map.get("view_id") != null) {
			viewId = map.get("view_id").toString();
		}
		
		request.setAttribute("blockId", blockId);
		
		DataModel dataModel = new DataModel(request, request.getSession().getServletContext());
		DataAndView dataAndView = null;
		try {
			Object obj = ControllerBeanFactory.getController(componentId+"/"+actionId, request);
			ControllerModel controllerModel = ControllerBeanFactory.getControllerModel(componentId+"/"+actionId);
			dataAndView = getDataAndView(obj, controllerModel.getMethodName(), request);
			// 获取返回数据
			if(dataAndView!=null){
				if(dataAndView.getDataname()!= null && dataAndView.getDataname()!=""){
					dataModel.put(dataAndView.getDataname(), dataAndView.getData());
				}
			}
			
			if("".equals(viewId)){
				Action action = commonService.getActionConfigure(componentId+"/"+actionId+"/"+blockId);
				
				if(action==null){
					action = commonService.getActionConfigure(componentId+"/"+actionId);
					if(action==null){
						viewId = ((ControllerView)controllerModel.getControllerView()).getViewPath();
					}else{
						if(null!=action.getViewfile() && "".equals(action.getViewfile())){
							viewId = action.getViewfile();
						}else{
							viewId = ((ControllerView)controllerModel.getControllerView()).getViewPath();
						}
					}
				}else{
					viewId = action.getViewfile();
					if(null!=action.getViewfile() && !"".equals(action.getViewfile())){
						viewId = action.getViewfile();
					}else{
						viewId = ((ControllerView)controllerModel.getControllerView()).getViewPath();
					}
				}
				
			}
			
			StringWriter stringWriter = templateRenderService.render(viewId, dataModel);
			
			out.write(stringWriter.toString());
			if(body!=null){
				body.render(out);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String generateHtmlFromFtl(String name,String encoding,DataAndView dv) {
		try{
			Writer out = new StringWriter(2048);
			Template temp = templateRenderService.getTemplateByName(name);
			temp.setEncoding(encoding);
			temp.process(dv, out);
			return out.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}  
	
	private DataAndView getDataAndView(Object obj, String methodName, HttpServletRequest request){
		try {
			String mName = methodName;
			if(null==methodName){
				mName = "execute";
			}
			Class c = obj.getClass();
			Method method = c.getMethod(mName, HttpServletRequest.class);
			Object o = method.invoke(obj,request);
			if(null==o){
				return null;
			}else{
				return (DataAndView)o;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
