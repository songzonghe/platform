package com.controllerAdmin.inquiry.log.prescription.details.inquiryLogPrescriptionDetails;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.inquiry.log.prescription.details.inquiryLogPrescriptionDetails.InquiryLogPrescriptionDetailsService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊记录处方详情 controller 实现类 
 *  操作人： 曾晓
 */ 
@Controller
public class InquiryLogPrescriptionDetailsController  extends ControllerUtil {

	@Resource
	private InquiryLogPrescriptionDetailsService  inquiryLogPrescriptionDetailsServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *获取问诊记录处方详情数据
	 */
	@RequestMapping(value ="/inquiryLogPrescriptionDetails_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryLogPrescriptionDetailsServiceImp.tBody(mapStr),mapStr,"form/inquiry/log/prescription/details/inquiryLogPrescription_details.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开新增问诊记录处方详情的页面
	 */
	@RequestMapping(value ="/inquiryLogPrescriptionDetails_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.returnPage("form/inquiry/log/prescription/details/inquiryLogPrescriptionDetails/inquiryLogPrescriptionDetails_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *新增/修改问诊记录处方详情的数据
	 */
	@RequestMapping(value ="/inquiryLogPrescriptionDetails_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("prescription_details_id"))) {
				Map<String, Object> mapObj = inquiryLogPrescriptionDetailsServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/prescription/details/inquiryLogPrescriptionDetails/inquiryLogPrescriptionDetails_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryLogPrescriptionDetailsServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/prescription/details/inquiryLogPrescriptionDetails/inquiryLogPrescriptionDetails_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取单个问诊记录处方详情数据
	 */
	@RequestMapping(value ="/inquiryLogPrescriptionDetails_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryLogPrescriptionDetailsServiceImp.find_Map(mapStr),"form/inquiry/log/prescription/details/inquiryLogPrescriptionDetails/inquiryLogPrescriptionDetails_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改问诊记录处方详情的页面
	 */
	@RequestMapping(value ="/inquiryLogPrescriptionDetails_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(inquiryLogPrescriptionDetailsServiceImp.find_Map(mapStr),"form/inquiry/log/prescription/details/inquiryLogPrescriptionDetails/inquiryLogPrescriptionDetails_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *删除问诊记录处方详情数据
	 */
	@RequestMapping(value ="/inquiryLogPrescriptionDetails_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryLogPrescriptionDetailsServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

