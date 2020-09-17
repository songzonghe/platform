package com.controllerAdmin.util.measuring.condition;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.measuring.condition.UtilMeasuringConditionService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 血糖测量条件  controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilMeasuringConditionController  extends ControllerUtil {

	@Resource
	private UtilMeasuringConditionService  utilMeasuringConditionServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取血糖测量条件 信息
	 */
	@RequestMapping(value ="/utilMeasuringCondition_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilMeasuringConditionServiceImp.tBody(mapStr),mapStr,"form/util/measuring/condition/utilMeasuringCondition_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加血糖测量条件 页面
	 */
	@RequestMapping(value ="/utilMeasuringCondition_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/measuring/condition/utilMeasuringCondition_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行血糖测量条件 修改和新增操作
	 */
	@RequestMapping(value ="/utilMeasuringCondition_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("condition_id"))) {
				Map<String, Object> mapObj = utilMeasuringConditionServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/measuring/condition/utilMeasuringCondition_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilMeasuringConditionServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/measuring/condition/utilMeasuringCondition_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条血糖测量条件 信息
	 */
	@RequestMapping(value ="/utilMeasuringCondition_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilMeasuringConditionServiceImp.find_Map(mapStr),"form/util/measuring/condition/details/utilMeasuringCondition_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改血糖测量条件 页面
	 */
	@RequestMapping(value ="/utilMeasuringCondition_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilMeasuringConditionServiceImp.find_Map(mapStr),"form/util/measuring/condition/utilMeasuringCondition_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除血糖测量条件 信息操作
	 */
	@RequestMapping(value ="/utilMeasuringCondition_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilMeasuringConditionServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

