package com.controllerAdmin.util.prescription.details.utilPrescriptionDetails;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.drug.UtilDrugService;
import com.servicesAdmin.util.prescription.UtilPrescriptionService;
import com.servicesAdmin.util.prescription.details.utilPrescriptionDetails.UtilPrescriptionDetailsService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊记录处方模板详情 controller 实现类 
 *  操作人： 曾晓
 */ 
@Controller
public class UtilPrescriptionDetailsController  extends ControllerUtil {

	@Resource
	private UtilPrescriptionDetailsService  utilPrescriptionDetailsServiceImp;
	@Resource
	private UtilPrescriptionService  utilPrescriptionService;
	@Resource
	private UtilDrugService  utilDrugServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *获取问诊记录处方模板详情数据
	 */
	@RequestMapping(value ="/utilPrescriptionDetails_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilPrescriptionDetailsServiceImp.tBody(mapStr),mapStr,"form/util/prescription/details/utilPrescription_details.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开新增问诊记录处方模板详情的页面
	 */
	@RequestMapping(value ="/utilPrescriptionDetails_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("drugList", utilDrugServiceImp.drugList(mapStr));
			return this.returnPage("form/util/prescription/details/utilPrescriptionDetails/utilPrescriptionDetails_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *新增/修改问诊记录处方模板详情的数据
	 */
	@RequestMapping(value ="/utilPrescriptionDetails_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("prescription_details_id"))) {
				Map<String, Object> mapObj = utilPrescriptionDetailsServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/prescription/details/utilPrescriptionDetails/utilPrescriptionDetails_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilPrescriptionDetailsServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/prescription/details/utilPrescriptionDetails/utilPrescriptionDetails_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取单个问诊记录处方模板详情数据
	 */
	@RequestMapping(value ="/utilPrescriptionDetails_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilPrescriptionDetailsServiceImp.find_Map(mapStr),"form/util/prescription/details/utilPrescriptionDetails/utilPrescriptionDetails_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改问诊记录处方模板详情的页面
	 */
	@RequestMapping(value ="/utilPrescriptionDetails_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			Map<String, Object> find_Map = utilPrescriptionService.find_Map(mapStr);
			mapStr.put("find_drug_type", find_Map.get("prescription_type")+"");
			req.setAttribute("drugList", utilDrugServiceImp.drugList(mapStr));
			return this.editPageUtil(utilPrescriptionDetailsServiceImp.find_Map(mapStr),"form/util/prescription/details/utilPrescriptionDetails/utilPrescriptionDetails_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *删除问诊记录处方模板详情数据
	 */
	@RequestMapping(value ="/utilPrescriptionDetails_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilPrescriptionDetailsServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

