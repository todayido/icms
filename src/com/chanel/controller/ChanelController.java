package com.chanel.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.chanel.model.Chanel;
import com.chanel.service.ChanelService;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;
import com.utils.UtilsFile;

@Controller
public class ChanelController extends BaseController implements IController {

	private Chanel chanel;
	@Resource
	private ChanelService chanelService;
	@Resource
	private SequenceGeneratorService sequenceGeneratorService;
	
	public DataAndView chanelIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	public DataAndView chanelList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // 当前页
		int rows = Integer.parseInt(request.getParameter("rows")); // 每页显示条数
		
		//查询参数
		String chanelname = request.getParameter("chanelname");
		
		Map paramsMap = new HashMap<String, String>();
        paramsMap.put("chanelname", chanelname);
		
		//分页参数
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();//new一个JSON
		jsonObj.accumulate("total", chanelService.getChanelCount(paramsMap));//total代表一共有多少数据
		jsonObj.accumulate("rows", chanelService.getAllChanels(paramsMap));//rows是代表显示的页的数据集合
		
		return new DataAndView("chanelList", jsonObj, null, SkipType.FORWARD);
	}
	
	public DataAndView chanelAdd(HttpServletRequest request){
		return null;
	}

	public DataAndView chanelAddSubmit(HttpServletRequest request)  {
		//绑定form对象
		Chanel chanel =  new Chanel();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(chanel); 
        binder.bind(request);
        
        chanel.setChanelname(chanel.getChanelname()+".ftl");
		chanel.setChanelid(sequenceGeneratorService.getCurrentPrimaryKey("z_chanel"));
		chanel.setCreatetime(new Date());
		int row = chanelService.saveChanel(chanel);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView chanelModify(HttpServletRequest request){
		String chanelid = request.getParameter("chanelid");
		chanel = chanelService.getChanelById(chanelid);
		return new DataAndView("chanel", chanel, null, SkipType.FORWARD);
	}
	
	public DataAndView chanelModifySubmit(HttpServletRequest request){
		//绑定form对象
		Chanel newChanel =  new Chanel();
		Chanel oldChanel =  new Chanel();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(newChanel); 
        binder.bind(request);
        
        oldChanel = chanelService.getChanelById(newChanel.getChanelid());
        
        //修改文件名
        if(!newChanel.getChanelname().equals(oldChanel.getChanelname())){
            String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/chanel/";
        	File oldFile = new File(path+oldChanel.getChanelname());
            if(oldFile.isFile() && oldFile.exists()){
            	oldFile.renameTo(new File(path+newChanel.getChanelname()));
            }
        }
        
        chanel.setCreatetime(new Date());
        int row = chanelService.modifyChanel(newChanel);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	public DataAndView chanelDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		//删除频道文件
		for(String chanelid : params){
			Chanel chanel = chanelService.getChanelById(chanelid);
			String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/chanel/";
			File file = new File(path+chanel.getChanelname());
			if(file.isFile() && file.exists()){
				file.delete();
			}
		}
		int flag = chanelService.deleteChanelById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView chanelEdit(HttpServletRequest request){
		String chanelid = request.getParameter("chanelid");
		chanel = chanelService.getChanelById(chanelid);
		//模板路径
		String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/chanel/";
		File file = new File(path+chanel.getChanelname());
		String fileContent = UtilsFile.getFtlContent(file);
		
		Map map = new HashMap();
		map.put("chanel", chanel);
		map.put("fileContent", fileContent);
		
		return new DataAndView("map", map, null, SkipType.FORWARD);
	}
	
	public DataAndView chanelEditSubmit(HttpServletRequest request){
		String chanelname = request.getParameter("chanelname");
		String fileContent = request.getParameter("fileContent");
		
		String path = this.getSession().getServletContext().getRealPath("")+"/WEB-INF/templates/chanel/";
		File file = new File(path+chanelname);
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
