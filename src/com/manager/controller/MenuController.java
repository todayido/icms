package com.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.manager.model.Menu;
import com.manager.service.MenuService;
import com.news.model.News;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class MenuController extends BaseController implements IController {

	private Menu menu;
	@Resource
	private MenuService menuService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	/**
	 *  菜单管理树
	 */
	public DataAndView menuTreeIndex(HttpServletRequest request){
		return null;
	}
	
	/**
	 *  菜单管理树
	 */
	public DataAndView menuTree(HttpServletRequest request){
		
		Map paramsMap = new HashMap();
		//获取参数
		String parentid = request.getParameter("id");
		
		//json数据返回
		StringBuffer stringBuffer = new StringBuffer();
		if(parentid==null || "".equals(parentid)){
			stringBuffer.append("[{id:\"0\",name:\"菜单维护\",isParent:true,open:true,click:\"Open('菜单维护','0')\"}]");
		}else{
			paramsMap.put("parentid", parentid);
			//获取菜单列表
			List parentMenuList = menuService.getMenuTreeByParentId(paramsMap);
			stringBuffer.append("[");
			News menu;
			for(int i=0; i<parentMenuList.size();i++){
				Menu m = (Menu)parentMenuList.get(i);
				String isParent = "false";
				if(m.getHasnext().equals("1")){
					isParent = "true";
				}
				stringBuffer.append("{");
				stringBuffer.append("id:\""+m.getMenuid()+"\",name:\""+m.getMenuname()+"\",isParent:"+isParent+",");
				stringBuffer.append("click:\"Open('"+m.getMenuname()+"','"+m.getMenuid()+"')\",");
				stringBuffer.append("open:true},");
			}
			stringBuffer.append("]");
		}
		return new DataAndView("json",stringBuffer.toString(),"",SkipType.FORWARD);
	}
	
	public DataAndView menuIndex(HttpServletRequest request) throws Exception {
		String parentid = request.getParameter("parentid");
		return new DataAndView("parentid", parentid, null, SkipType.FORWARD);
	}
	
	public DataAndView menuList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		// 查询参数
		String parentid = request.getParameter("parentid");
		String menuname = request.getParameter("menuname");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("menuname", menuname);
		paramsMap.put("parentid", parentid);
		
		// 分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();// new一个JSON
		jsonObj.accumulate("total", menuService.getMenuCount(paramsMap));// total代表一共有多少数据
		jsonObj.accumulate("rows", menuService.getAllMenus(paramsMap));// rows是代表显示的页的数据集合
		
		return new DataAndView("menuList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView menuAdd(HttpServletRequest request){
		String parentid = request.getParameter("parentid");
		return new DataAndView("parentid", parentid, null, SkipType.FORWARD);
	}
	
	public DataAndView menuAddSubmit(HttpServletRequest request)  {
		// bind form object
		Menu menu =  new Menu();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(menu);
		binder.bind(request);
		
		//父节点has_next置为1
		Menu p = new Menu();
		p.setMenuid(menu.getParentid());
		p.setHasnext("1");
		menuService.modifyMenu(p);
		
		menu.setHasnext("0");
		menu.setDisplay("1");
		menu.setPriority("0");
		menu.setMenuid(sequenceGeneratorService.getCurrentPrimaryKey("z_menu"));
		int row = menuService.saveMenu(menu);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView menuModify(HttpServletRequest request){
		String menuid = request.getParameter("menuid");
		menu = menuService.getMenuById(menuid);
		return new DataAndView("menu", menu, null, SkipType.FORWARD);
	}

	public DataAndView menuModifySubmit(HttpServletRequest request){
		//绑定form对象
		Menu manu =  new Menu();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(manu); 
		binder.bind(request);
		
		int row = menuService.modifyMenu(manu);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView menuDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = menuService.deleteMenuById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}

	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
