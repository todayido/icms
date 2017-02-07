package com.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.news.service.NewsService;
import com.newsproperty.model.Newsproperty;
import com.newsproperty.service.NewspropertyService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SimplePage;
import com.core.model.SkipType;

@Controller
public class NewsList extends BaseController implements IController {

	@Resource
	private NewsService newsService;
	@Resource
	private NewspropertyService ns;
	
	@SuppressWarnings("unchecked")
	public DataAndView execute(HttpServletRequest request){
		
		String pageNoStr = request.getParameter("pageNo");
		String blockid = (String) request.getAttribute("blockId");
		
		// 当前第几页
		int pageNo = 1;
		if(pageNoStr!=null){
			pageNo = Integer.parseInt(pageNoStr);
		}
		// 新闻栏目属性
		Newsproperty np = ns.getNewspropertyById(blockid);
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("blockid", blockid);
		
		int totalCount = newsService.getNewsCount(paramsMap);
		
		//分页参数
		SimplePage simplePage =  new SimplePage(pageNo,np.getListpage(),totalCount);
		paramsMap.put("begin", (pageNo - 1) * simplePage.getPageSize());
		paramsMap.put("end", simplePage.getPageSize());
		
		List newsList = newsService.getAllNewss(paramsMap);
		Map map = new HashMap();
		map.put("newsList", newsList);
		map.put("simplePage", simplePage);
		map.put("newsProperty", np);
		
		return new DataAndView("map", map, null, SkipType.FORWARD);
	}

}
