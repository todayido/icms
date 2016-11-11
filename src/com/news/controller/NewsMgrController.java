package com.news.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.news.model.News;
import com.news.service.NewsService;
import com.newsproperty.model.Newsproperty;
import com.newsproperty.service.NewspropertyService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class NewsMgrController extends BaseController implements IController {

	private News news;
	@Resource
	private NewsService newsService;
	@Resource
	private NewspropertyService nps;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	public DataAndView newsMgrIndex(HttpServletRequest request) throws Exception {
		String blockid = request.getParameter("blockid");
		return new DataAndView("blockid",blockid,null,SkipType.FORWARD);
	}
	
	public DataAndView newsMgrList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String blockid = request.getParameter("blockid");
		String newsid = request.getParameter("newsid");
		String title = request.getParameter("title");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("blockid", blockid);
        paramsMap.put("newsid", newsid);
        paramsMap.put("title", title);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", newsService.getNewsCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", newsService.getAllNewss(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("newsList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView newsAdd(HttpServletRequest request){
		String blockid = request.getParameter("blockid");
		Newsproperty np =  nps.getNewspropertyById(blockid);
		return new DataAndView("newsProperty", np, null, SkipType.FORWARD);
	}
	
	public DataAndView newsAddSubmit(HttpServletRequest request)  {
		//绑定form对象
		News news =  new News();
		String blockid = request.getParameter("title");
		ServletRequestDataBinder binder = new ServletRequestDataBinder(news); 
        binder.bind(request);
        
		news.setNewsid(sequenceGeneratorService.getCurrentPrimaryKey("t_news"));
		news.setCreatetime(new Date());
		news.setLastedittime(new Date());
		int row = newsService.saveNews(news);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView newsModify(HttpServletRequest request){
		String newsid = request.getParameter("newsid");
		news = newsService.getNewsById(newsid);
		
		String blockid = news.getBlockid();
		Newsproperty newsProperty =  nps.getNewspropertyById(blockid);
		
		Map map = new HashMap();
		map.put("news", news);
		map.put("newsProperty", newsProperty);
		
		return new DataAndView("map", map, null, SkipType.FORWARD);
	}
	
	public DataAndView newsModifySubmit(HttpServletRequest request){
		//绑定form对象
		News news =  new News();
		news.setLastedittime(new Date());
		ServletRequestDataBinder binder = new ServletRequestDataBinder(news); 
        binder.bind(request);
        
        news.setLastedittime(new Date());
        news.setLastedittime(new Date());
        int row = newsService.modifyNews(news);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView newsDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = newsService.deleteNewsById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}

	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
