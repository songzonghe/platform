package com.controllerAdmin.util.drug.usage;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.drug.usage.UtilDrugUsageService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 药品用法 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilDrugUsageController  extends ControllerUtil {

	@Resource
	private UtilDrugUsageService  utilDrugUsageServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取药品用法信息
	 */
	@RequestMapping(value ="/utilDrugUsage_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilDrugUsageServiceImp.tBody(mapStr),mapStr,"form/util/drug/usage/utilDrugUsage_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加药品用法页面
	 */
	@RequestMapping(value ="/utilDrugUsage_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/drug/usage/utilDrugUsage_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行药品用法修改和新增操作
	 */
	@RequestMapping(value ="/utilDrugUsage_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("usage_id"))) {
				Map<String, Object> mapObj = utilDrugUsageServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/drug/usage/utilDrugUsage_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilDrugUsageServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/drug/usage/utilDrugUsage_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条药品用法信息
	 */
	@RequestMapping(value ="/utilDrugUsage_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilDrugUsageServiceImp.find_Map(mapStr),"form/util/drug/usage/details/utilDrugUsage_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改药品用法页面
	 */
	@RequestMapping(value ="/utilDrugUsage_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilDrugUsageServiceImp.find_Map(mapStr),"form/util/drug/usage/utilDrugUsage_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除药品用法信息操作
	 */
	@RequestMapping(value ="/utilDrugUsage_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilDrugUsageServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

