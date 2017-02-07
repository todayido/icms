package com.item.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.item.model.Item;
import com.item.service.ItemService;
import com.manager.model.User;
import com.utils.UUIDGenerator;
import com.utils.UtilsCommon;
import com.core.controller.BaseController;
import com.core.controller.IController;
import com.core.model.DataAndView;
import com.core.model.SimplePage;
import com.core.model.SkipType;
import com.core.service.SequenceGeneratorService;

@Controller
public class ItemController extends BaseController implements IController {

    private Item item;
	@Resource
	private ItemService itemService;
	
	
	// index
	public DataAndView itemIndex(HttpServletRequest request) throws Exception {
		return null;
	}
	
	// list
	public DataAndView itemList(HttpServletRequest request){
		int page = Integer.parseInt(request.getParameter("page")); // cunrrent page
		int rows = Integer.parseInt(request.getParameter("rows")); // display count per page
		
		// seach params
		String user_id = request.getParameter("user_id");
		
		Map paramsMap = new HashMap<String, String>();
		paramsMap.put("user_id", user_id);
		
		// page params
		paramsMap.put("begin", (page - 1) * rows);
		paramsMap.put("end", rows);
		
		JSONObject jsonObj = new JSONObject();// new一个JSON
		jsonObj.accumulate("total", itemService.getItemCount(paramsMap));// total
		jsonObj.accumulate("rows", itemService.getAllItems(paramsMap));// rows:data set
		
		return new DataAndView("itemList", jsonObj, null, SkipType.FORWARD);
	}
	
	// add
	public DataAndView itemAdd(HttpServletRequest request){
		return null;
	}
	
	// add submit
	public DataAndView itemAddSubmit(HttpServletRequest request)  {
		// bind form object
		Item item =  new Item();
		User member = (User) this.getSession().getAttribute("userModel");
		
		long t = System.currentTimeMillis();//获得当前时间的毫秒数
        Random rd = new Random(t);//作为种子数传入到Random的构造器中
		item.setItem_id(""+t+rd.nextInt());
		item.setUser_id(member.getUser_name());
		item.setItem_time(new Date());
		
		ServletRequestDataBinder binder = new ServletRequestDataBinder(item);
		binder.bind(request);
		
		int row = itemService.saveItem(item);
		
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// modify
	public DataAndView itemModify(HttpServletRequest request){
		String item_id = request.getParameter("item_id");
		item = itemService.getItemById(item_id);
		return new DataAndView("item", item, null, SkipType.FORWARD);
	}
	
	//modify submit
	public DataAndView itemModifySubmit(HttpServletRequest request){
		// bind form object
		Item item =  new Item();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(item); 
		binder.bind(request);
		
		int row = itemService.modifyItem(item);
		return new DataAndView("flag", row, null, SkipType.FORWARD);
	}
	
	// delete
	public DataAndView itemDelete(HttpServletRequest request){
		String params[] = request.getParameterValues("params[]");
		int flag = itemService.deleteItemById(params);
		return new DataAndView("flag", flag, null, SkipType.FORWARD);
	}
	
	public DataAndView itemBlock(HttpServletRequest request){
		
		String pageNoStr = request.getParameter("pageNo");
		String jin_min = request.getParameter("jin_min");
		String jin_max = request.getParameter("jin_max");
		
		Map paramsMap = new HashMap<String, String>();
		Map resultMap = new HashMap();
		// 任务状态为发布状态：0：已保存但未发布。1：审核通过已发布。2：已被接单，3：刷单已完成，4：卖家确认，5：审核通过已结算，6：违规被冻结
		paramsMap.put("item_state",1);
		
		if(null!=jin_min && !"".equals(jin_min)){
			paramsMap.put("jin_min", jin_min);
			resultMap.put("jin_min", jin_min);
		}
		
		if(null!=jin_max && !"".equals(jin_max)){
			paramsMap.put("jin_max", jin_max);
			resultMap.put("jin_max", jin_max);
		}
		
		int pageSize = 10;
		
		// 当前第几页
		int pageNo = 1;
		if(pageNoStr!=null && !"".equals(pageNoStr)){
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		
		int totalCount = itemService.getItemBlockCount(paramsMap);
		
		//分页参数
		SimplePage simplePage =  new SimplePage(pageNo,pageSize,totalCount);
		paramsMap.put("begin", (pageNo - 1) * simplePage.getPageSize());
		paramsMap.put("end", simplePage.getPageSize());
		
		List itemList = itemService.getItemBlock(paramsMap);
		
		resultMap.put("itemList", itemList);
		resultMap.put("simplePage", simplePage);
		
		return new DataAndView("map", resultMap, null, SkipType.FORWARD);
	}
	
	public DataAndView itemPublish(HttpServletRequest request){
		request.getSession().setAttribute("token", "0");
		return new DataAndView("",null, null, SkipType.FORWARD);
	}
	
	public DataAndView itemPublishSubmit(HttpServletRequest request){
		String message = "";
		String success = "0";
		Map resultMap = new HashMap();
		//防止表单重复提交
		if(!"0".equals(request.getSession().getAttribute("token"))){
			message = "<font style='color:red'>任务已经提交，请不要刷新页面避免重复提交.</font><br>您也可以点击【我要发单】继续发布任务.";
			return new DataAndView("message",message,"/item/itemPublish.htm",SkipType.REDIRECT);
		}
		Item item =  new Item();
		User member = (User) this.getSession().getAttribute("userModel");
		
		ServletRequestDataBinder binder = new ServletRequestDataBinder(item);
		
		long t = System.currentTimeMillis();//获得当前时间的毫秒数
        Random rd = new Random(t);//作为种子数传入到Random的构造器中
		item.setItem_id(""+t+rd.nextInt());
		item.setUser_id(member.getUser_name());
		item.setItem_time(new Date());
		
		binder.bind(request);
		
		if(UtilsCommon.isEmperty(item.getItem_source())){
			message = "【宝贝来源】不能为空，请修改后重新提交！";
			return new DataAndView("message",message, null, SkipType.FORWARD);
		}
		
		if(UtilsCommon.isEmperty(item.getItem_link())){
			message = "【宝贝连接地址】不能为空，请修改后重新提交！";
			return new DataAndView("message",message, null, SkipType.FORWARD);
		}
		
		if(!UtilsCommon.isNumeric(item.getItem_one_cost())){
			message = "【宝贝金额】填写的数据格式有误，请修改后重新提交！";
			return new DataAndView("message",message, null, SkipType.FORWARD);
		}
		
		if(!UtilsCommon.isNumeric(item.getComments_after())){
			message = "【几天后确认收货评价】填写的数据格式有误，请修改后重新提交！";
			return new DataAndView("message",message, null, SkipType.FORWARD);
		}
		
		if(!UtilsCommon.isNumeric(item.getComments_stars())){
			message = "【几星好评】填写的数据格式有误，请修改后重新提交！";
			return new DataAndView("message",message, null, SkipType.FORWARD);
		}
		
		if(UtilsCommon.isEmperty(item.getComments_content())){
			message = "【评价内容】不能为空，请修改后重新提交！";
			return new DataAndView("message",message, null, SkipType.FORWARD);
		}
		
		if(UtilsCommon.isEmperty(item.getOther_needs())){
			message = "【其他要求】不能为空，请修改后重新提交！";
			return new DataAndView("message",message, null, SkipType.FORWARD);
		}
		
		int row = itemService.saveItem(item);
		
		if(row>0){
			request.getSession().removeAttribute("token");
			message = "发布成功，等待审核后方可被刷客接单，我们会尽快处理，请耐心等待...<br>您也可以在【我发布的任务】中查看任务进度.";
			success = "1";
		}else{
			success = "0";
			message = "<font style='color:red'>发布任务失败，请联系在线客服...</font>";
		}
		
		resultMap.put("message", message);
		resultMap.put("success", success);
		return new DataAndView("map",resultMap, null, SkipType.FORWARD);
		
		
	}
	
	public DataAndView execute(HttpServletRequest request) throws Exception {
		return null;
	}

}
