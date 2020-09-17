package com.controllerAdmin.inquiry.log.prescription;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.doctor.info.DoctorInfoService;
import com.servicesAdmin.inquiry.log.prescription.InquiryLogPrescriptionService;
import com.servicesAdmin.inquiry.patient.info.InquiryPatientInfoService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊记录处方 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class InquiryLogPrescriptionController  extends ControllerUtil {

	@Resource
	private InquiryLogPrescriptionService  inquiryLogPrescriptionServiceImp;
	@Resource
	private DoctorInfoService  doctorInfoService;
	@Resource
	private InquiryPatientInfoService  inquiryPatientInfoService;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取问诊记录处方信息
	 */
	@RequestMapping(value ="/inquiryLogPrescription_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryLogPrescriptionServiceImp.tBody(mapStr),mapStr,"form/inquiry/log/prescription/inquiryLogPrescription_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 *分页获取审核处方信息
	 */
	@RequestMapping(value ="/inquiryLogPrescription_examineIndex.do")
	public String examine(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if("1".equals( mapStr.get("is_examine"))) {//只查询待审核的
				mapStr.put("find_zt","2");
			}
			return this.tBodyUtil(inquiryLogPrescriptionServiceImp.tBody(mapStr),mapStr,"form/inquiry/log/prescription/inquiryLogPrescription_examineIndex.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加问诊记录处方页面
	 */
	@RequestMapping(value ="/inquiryLogPrescription_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("doctorList", doctorInfoService.doctorList(mapStr));
			req.setAttribute("patientList", inquiryPatientInfoService.patientList(mapStr));
			return this.returnPage("form/inquiry/log/prescription/inquiryLogPrescription_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行问诊记录处方修改和新增操作
	 */
	@RequestMapping(value ="/inquiryLogPrescription_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("prescription_id"))) {
				Map<String, Object> mapObj = inquiryLogPrescriptionServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/prescription/inquiryLogPrescription_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryLogPrescriptionServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/prescription/inquiryLogPrescription_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条问诊记录处方信息
	 */
	@RequestMapping(value ="/inquiryLogPrescription_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryLogPrescriptionServiceImp.find_Map(mapStr),"form/inquiry/log/prescription/details/inquiryLogPrescription_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开记录处方页面
	 */
	@RequestMapping(value ="/inquiryLogPrescription_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("info", mapStr);
			mapStr.put("find_details", "details");
			return this.editPageUtil(inquiryLogPrescriptionServiceImp.find_Map(mapStr),"form/inquiry/log/prescription/inquiryLogPrescription_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除问诊记录处方信息操作
	 */
	@RequestMapping(value ="/inquiryLogPrescription_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryLogPrescriptionServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

