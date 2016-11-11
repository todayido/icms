package com.manager.controller;

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
import com.manager.model.Menu;
import com.manager.model.User;
import com.manager.service.AccessService;
import com.manager.service.MenuService;
@Controller
public class MainFrameController extends BaseController implements IController {

	@Resource
	private MenuService menuService;
	@Resource
	AccessService accessService;
	public Menu menu;
	
	public DataAndView mainFrame(HttpServletRequest request) throws Exception {
		User user = (User) this.getSession().getAttribute("userModel");
		return new DataAndView("user",user,null,SkipType.FORWARD);
	}
	
	/**
	 * 后台左侧管理树
	 */
	public DataAndView leftTree(HttpServletRequest request){
			
			Map paramsMap = new HashMap();
			//获取参数
			String parentid = request.getParameter("id");
			if(parentid==null || "".equals(parentid)){
				parentid = "0";
			}
			
			paramsMap.put("parentid", parentid);
			//获取菜单列表
			List parentMenuList = menuService.getLeftTreeByParentId(paramsMap);
			
			//json数据返回
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("[");
			Menu menu;
			User user = null;
			Object obj  = (Object)this.getSession().getAttribute("userModel");
			if(obj!=null){
				user = (User)obj;
			}
			for(int i=0; i<parentMenuList.size();i++){
				menu = (Menu)parentMenuList.get(i);
				//判断是否有菜单的访问权限
				if(!accessService.access(user, menu.getMenuurl())){
					continue;
				}
				
				boolean isParent = false;
				if(menu.getHasnext().equals("1")){
					isParent = true;
				}
				stringBuffer.append("{id:\""+menu.getMenuid()+"\",name:\""+menu.getMenuname()+"\",isParent:"+isParent+",");
				if(null != menu.getMenuurl() && !"".equals(menu.getMenuurl()) && !isParent){
					stringBuffer.append("click:\"Open('"+menu.getMenuname()+"','"+menu.getMenuurl()+"')\",");
				}
				stringBuffer.append("open:true},");
			}
			
			stringBuffer.append("]");
			return new DataAndView("json",stringBuffer.toString(),"",SkipType.FORWARD);
	}

	
	/**
	 * 后台管理设置
	 */
	public DataAndView setup(HttpServletRequest request){
		User user = (User) this.getSession().getAttribute("userModel");
		return new DataAndView("user",user,null,SkipType.FORWARD);
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}
	
}
