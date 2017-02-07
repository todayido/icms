package com.core.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.action.model.Action;
import com.core.model.ControllerModel;
import com.core.model.ControllerView;
import com.core.model.DataAndView;
import com.core.model.DataModel;
import com.core.model.SkipType;
import com.core.service.CommonService;
import com.core.service.TemplateRenderService;
import com.manager.model.User;
import com.manager.service.AccessService;
import com.utils.BeanUtils;

public class MainController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 38065037259439084L;
	
	static Logger logger = Logger.getLogger(MainController.class.getName());
	DataModel dataModel;
	TemplateRenderService templateRenderService = new TemplateRenderService();
	CommonService commonService = (CommonService) BeanUtils.getSpringBean("commonServiceImpl");
	AccessService accessService = (AccessService) BeanUtils.getSpringBean("accessServiceImpl");
	
	public void init() throws ServletException {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doMain(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doMain(request, response);
	}
	
	/**
	 * 捕获所有请求
	 * 解析动作，渲染数据并返回
	 * @param request
	 * @param response
	 */
	private void doMain(HttpServletRequest request, HttpServletResponse response){
		//放在 response.getWriter();之前，否则还是会出现乱码现象
		response.setCharacterEncoding("utf-8");
		String uriString = request.getRequestURI().substring(1);
		
		User user = (User) request.getSession().getAttribute("userModel");
		/**
		 * 有权限才能访问的动作，没有权限的用户跳转到登陆页面。
		 * 未配置的资源，所有用户均可访问
		 */
		if(!accessService.access(user, uriString)){
			try {
				response.sendRedirect("/login/login.htm?redirectUrl="+uriString);
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			uriString = uriString.substring(0, uriString.length()-4);
		} catch (Exception e1) {
			uriString = "main";
		}
		String []urlSrting = uriString.split("/");
		int length = urlSrting.length;
		
		if(length==0){
			/**
			 * 返回首页
			 */
			uriString = "main";
			
		}else if(length==1){
			/**
			 * 频道模版
			 * 频道模版没有视图，只是加载频道的模板可以了。
			 */
			String chanelPath = "templates/chanel/"+urlSrting[0]+".ftl";
			
			try {
				PrintWriter out = response.getWriter();
				dataModel = new DataModel(request,this.getServletContext());
				
				StringWriter content = templateRenderService.render(chanelPath,dataModel);
				
				out.print(content.toString());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else if(length==2){
			/**
			 * 单实例组件
			 */
			doSingleton(urlSrting, request, response);
		}else{
			/**
			 * 多实例组件
			 */
			request.setAttribute("blockId", urlSrting[2]);
			doSingleton(urlSrting, request, response);
		}
	}
	/**
	 * 单实例组件 
	 */
	private void doSingleton(String []urlString,HttpServletRequest request, HttpServletResponse response){
		
		DataAndView dataAndView = null;
		response.setCharacterEncoding("utf-8");
		dataModel = new DataModel(request,this.getServletContext());
		//执行的方法名称
		String actionName = urlString[0] + "/" + urlString[1];
		
		//动作对应的类
		ControllerModel controllerModel = ControllerBeanFactory.getControllerModel(actionName);
		//访问的动作不存在，跳转到错误页面
		try {
			if(controllerModel==null){
				response.sendRedirect("/404.htm");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Object obj = ControllerBeanFactory.getController(actionName, request);
		
		//判断动作的类型
		String type = controllerModel.getType();
		/**
		 * json:数据直接返回
		 */
		if(type.equalsIgnoreCase("json")){
			dataAndView = getDataAndView(obj, controllerModel.getMethodName(), request);
			try {
				PrintWriter out;
				out = response.getWriter();
				out.print(dataAndView.getData());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * html:数据渲染后返回
		 */
		if(type.equalsIgnoreCase("html")){
			try {
				/**
				 * 执行方法，返回数据
				 * 动作的属性模型（dataAndView）和视图模型（view）
				 */
				dataAndView = getDataAndView(obj, controllerModel.getMethodName(), request);
				ControllerView view = controllerModel.getControllerView();
				String viewPath = view.getViewPath();
				
				PrintWriter out;
				out = response.getWriter();
				
				if(dataAndView!=null){
					
					String nextAction = dataAndView.getNextController();
					/**
					 * 跳转到下一个动作不为 null，做跳转处理
					 * 将该动作的数据以键值对得形式传递到下一个动作地址
					 * 键：dataAndView.getDataname(), 值dataAndView.getData()
					 */
					if(nextAction!=null){
						// 客户端跳转，不传递参数
						if(dataAndView.getSkipType() == SkipType.REDIRECT){
							response.sendRedirect(nextAction);
							return;
						}else{
							// 服务器端跳转，并传递参数
							if(dataAndView.getDataname()!=null && dataAndView.getDataname()!=""){
								request.setAttribute(dataAndView.getDataname(), dataAndView.getData());
							}
							request.getRequestDispatcher(nextAction).forward(request, response);
							return;
						}
					}else{
						// 如果不跳转，获取返回的数据存入到dataModel中
						if(dataAndView.getDataname()!= null && dataAndView.getDataname()!=""){
							dataModel.put(dataAndView.getDataname(), dataAndView.getData());
						}
					}
				}
				// 视图名称作为网页标题
				dataModel.put("sys_html_title", view.getName());
				
				Action action;
				StringWriter content = null;
				if(request.getAttribute("blockId")!=null){
					// 多实例
					action = commonService.getActionConfigure(actionName+"/"+request.getAttribute("blockId"));
				}else{
					// 单实例
					action = commonService.getActionConfigure(actionName);
				}
				
				/**
				 * 渲染视图
				 * 如果action==null,说明没有配置视图，则加载xml文件中配置的第一个视图。
				 */
				if(action!=null && null!=action.getViewfile() && !"".equals(action.getViewfile())){
					viewPath = action.getViewfile();
				}
				content = templateRenderService.render(viewPath,dataModel);
				
				// 渲染模板中的${content}
				dataModel.put("content", content.toString());

				/**
				 * 渲染模板
				 * 如果action==null,说明没有配置模板，则加载默认摸板。
				 */
				if(action!=null && null!=action.getContentfile() && !"".equals(action.getContentfile())){
					content = templateRenderService.render("templates/template/"+action.getContentfile(),dataModel);
				}
				
				out.print(content.toString());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private DataAndView getDataAndView(Object obj, String methodName, HttpServletRequest request){
		String mName = methodName;
		Class c = obj.getClass();;
		try {
			if(null==methodName){
				mName = "execute";
			}
			
			Method method = c.getMethod(mName, HttpServletRequest.class);
			Object o = method.invoke(obj,request);
			if(null!=o){
				return (DataAndView)o;
			}
		} catch (Exception e) {
			logger.error(MainController.class.toString()+"【执行方法：MainController-getModelAndView 出错！】");
			logger.error("【类："+c.getName()+"中的方法："+mName+"执行出错！】");
			e.printStackTrace();
		}
		return null;
	}

}
