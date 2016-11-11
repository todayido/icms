package com.fragment.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.fragment.model.Fragment;
import com.fragment.service.FragmentService;
import com.utils.UtilsFile;

@Controller
public class FragmentBlock extends BaseController implements IController {

	@Resource
	private FragmentService fragmentService;
	private Fragment fragment;
	
	public DataAndView execute(HttpServletRequest request){
		String blockId = (String)request.getAttribute("blockId");
		fragment = fragmentService.getFragmentById(blockId);
		
		//片段文件路径
		String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/fragment/";
		File file = new File(path+fragment.getFragmentname()+".ftl");
		String fileContent = UtilsFile.getFtlContent(file);
		return new DataAndView("fileContent", fileContent, null, null, SkipType.FORWARD);
	}
		
}