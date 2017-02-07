package com.fragment.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.fragment.model.Fragment;
import com.fragment.service.FragmentService;
import com.utils.UtilsFile;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class FragmentController extends BaseController implements IController {

	private Fragment fragment;
	@Resource
	private FragmentService fragmentService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	public DataAndView fragmentIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	public DataAndView fragmentList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String blockid = request.getParameter("blockid");
		String fragmentname = request.getParameter("fragmentname");
		
		Map paramsMap = new HashMap<String, String>();
        paramsMap.put("blockid", blockid);
        paramsMap.put("fragmentname", fragmentname);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", fragmentService.getFragmentCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", fragmentService.getAllFragments(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("fragmentList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView fragmentAdd(HttpServletRequest request){
		return null;
	}
	
	public DataAndView fragmentAddSubmit(HttpServletRequest request)  {
		//绑定form对象
		Fragment fragment =  new Fragment();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(fragment); 
        binder.bind(request);
        
		fragment.setBlockid(sequenceGeneratorService.getCurrentPrimaryKey("t_fragment"));
		fragment.setCreatetime(new Date());
		int row = fragmentService.saveFragment(fragment);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView fragmentModify(HttpServletRequest request){
		String blockid = request.getParameter("blockid");
		fragment = fragmentService.getFragmentById(blockid);
		return new DataAndView("fragment", fragment, null, SkipType.FORWARD);
	}
	
	public DataAndView fragmentModifySubmit(HttpServletRequest request){
		//绑定form对象
		Fragment fragment =  new Fragment();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(fragment); 
        binder.bind(request);
        
        fragment.setCreatetime(new Date());
        int row = fragmentService.modifyFragment(fragment);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView fragmentDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = fragmentService.deleteFragmentById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView fragmentEdit(HttpServletRequest request){
		String blockid = request.getParameter("blockid");
		fragment = fragmentService.getFragmentById(blockid);
		
		//模板路径
		String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/fragment/";
		File file = new File(path+fragment.getFragmentname()+".ftl");
		String fileContent = UtilsFile.getFtlContent(file);
		
		Map map = new HashMap();
		map.put("fragment", fragment);
		map.put("fileContent", fileContent);
		
		return new DataAndView("map", map, null, SkipType.FORWARD);
	}
	
	public DataAndView fragmentEditSubmit(HttpServletRequest request){
		//绑定form对象
		String fragmentname = request.getParameter("fragmentname");
		String fileContent = request.getParameter("fileContent");
		
		String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/fragment/";
		File file = new File(path+fragmentname+".ftl");
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
