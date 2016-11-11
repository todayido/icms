package com.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.news.model.News;
import com.news.service.NewsService;
import com.newsproperty.model.Newsproperty;
import com.newsproperty.service.NewspropertyService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SimplePage;
import com.core.model.SkipType;

@Controller
public class NewsDetails extends BaseController implements IController {

	@Resource
	private NewsService newsService;
	
	public DataAndView execute(HttpServletRequest request){
		
		String newsid = (String) request.getParameter("newsid");
		News news = newsService.getNewsById(newsid);
		
		return new DataAndView("news", news, null, SkipType.FORWARD);
	}

}
