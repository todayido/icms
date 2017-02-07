package com.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.news.model.News;
import com.news.service.NewsService;

/**
 * 新闻内容管理首页
 */
@Controller
public class NewsMgrTree extends BaseController implements IController {

	@Resource
	private NewsService newsService;
	
	public DataAndView newsMgrMain(HttpServletRequest request){
		return null;
	}

	public DataAndView newsMgrMenu(HttpServletRequest request){
			
		Map paramsMap = new HashMap();
		//获取参数
		String parentid = request.getParameter("id");
		//json数据返回
		StringBuffer stringBuffer = new StringBuffer();
		if(parentid==null || "".equals(parentid)){
			stringBuffer.append("[{id:\"0\",name:\"新闻栏目\",isParent:true,open:true}]");
		}else{
			paramsMap.put("parentid", parentid);
			
			//获取菜单列表
			List parentMenuList = newsService.getNewsMgrMenuByParentId(paramsMap);
			stringBuffer.append("[");
			News menu;
			for(int i=0; i<parentMenuList.size();i++){
				Map map = (HashMap)parentMenuList.get(i);
				String isParent = "false";
				if(((String)map.get("hasnext")).equals("1")){
					isParent = "true";
				}
				stringBuffer.append("{");
				stringBuffer.append("id:\""+map.get("blockid")+"\",name:\""+map.get("title")+"\",isParent:"+isParent+",");
				stringBuffer.append("click:\"Open('"+map.get("title")+"','"+map.get("blockid")+"')\",");
				stringBuffer.append("open:true},");
			}
			stringBuffer.append("]");
		}
		return new DataAndView("json",stringBuffer.toString(),"",SkipType.FORWARD);
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}
			
}