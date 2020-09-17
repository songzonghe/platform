/**
 * 
 */
package com.controllerAdmin.reportForm;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.reportForm.ReportFormServer;
import com.util.UtilJson;


/**
 * 报表管理
 * @author 李裕国
 * @date 2019年10月24日 下午6:00:54
 */
@Controller
public class ReportFormController extends ControllerUtil {
	
	@Resource
	private ReportFormServer reportFormServerImp;
	
	/**
	 *分页获取注册用户信息
	 */
	@RequestMapping(value ="/reportForm_register_user_index.do")
	public String registerUserIndex(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(reportFormServerImp.tRegisterUserBody(mapStr),mapStr,"form/reportForm/reportForm_register_user_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 *获取注册用户导出信息
	 */
	@RequestMapping(value ="/reportForm_register_user_getExcelSql.do")
	public void registerUserIndexExcelSql(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			respBack(UtilJson.mapToJson(reportFormServerImp.registerUserIndexExcelSql(mapStr)), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	
	
	/**
	 *分页获取咨询用户信息
	 */
	@RequestMapping(value ="/reportForm_inquiry_user_index.do")
	public String inquiryUserIndex(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(reportFormServerImp.tInquiryUserBody(mapStr),mapStr,"form/reportForm/reportForm_inquiry_user_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 *获取咨询用户导出信息
	 */
	@RequestMapping(value ="/reportForm_inquiry_user_getExcelSql.do")
	public void inquiryUserIndexExcelSql(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			respBack(UtilJson.mapToJson(reportFormServerImp.inquiryUserIndexExcelSql(mapStr)), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	/**
	 *分页获取处方报表
	 */
	@RequestMapping(value ="/reportForm_prescription_index.do")
	public String prescriptionIndex(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(reportFormServerImp.tPrescriptionBody(mapStr),mapStr,"form/reportForm/reportForm_prescription_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 *获取取处导出信息
	 */
	@RequestMapping(value ="/reportForm_prescription_getExcelSql.do")
	public void prescriptionExcelSql(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			respBack(UtilJson.mapToJson(reportFormServerImp.prescriptionExcelSql(mapStr)), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	/**
	 *分页获取健康指导报表
	 */
	@RequestMapping(value ="/reportForm_health_guidance_index.do")
	public String healthHuidanceIndex(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(reportFormServerImp.tHealthGuidanceBody(mapStr),mapStr,"form/reportForm/reportForm_health_guidance_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 *获取健康指导导出信息
	 */
	@RequestMapping(value ="/reportForm_health_guidance_getExcelSql.do")
	public void healthHuidanceExcelSql(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			respBack(UtilJson.mapToJson(reportFormServerImp.healthHuidanceExcelSql(mapStr)), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	/**
	 *分页获取检验检查报表
	 */
	@RequestMapping(value ="/reportForm_checklist_index.do")
	public String checklistIndex(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(reportFormServerImp.tChecklistBody(mapStr),mapStr,"form/reportForm/reportForm_checklist_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 *获取获取检验检导出信息
	 */
	@RequestMapping(value ="/reportForm_checklist_getExcelSql.do")
	public void checklistExcelSql(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			respBack(UtilJson.mapToJson(reportFormServerImp.checklistExcelSql(mapStr)), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}

	
	/**
	 *分页获取药师审核处方统计报表
	 */
	@RequestMapping(value ="/reportForm_audit_prescription_index.do")
	public String auditPrescriptionIndex(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			
			return this.tBodyUtil(reportFormServerImp.tAuditPrescriptionBody(mapStr),mapStr,"form/reportForm/reportForm_audit_prescription_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 *获取获药师审核导出信息
	 */
	@RequestMapping(value ="/reportForm_audit_prescription_getExcelSql.do")
	public void auditPrescriptionExcelSql(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			respBack(UtilJson.mapToJson(reportFormServerImp.auditPrescriptionExcelSql(mapStr)), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}

	
	/**
	 *分页获取药住院建议报表
	 * @return 
	 */
	@RequestMapping(value ="/reportForm_hospitalization_index.do")
	public String hospitalizationIndex(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(reportFormServerImp.tHospitalizationBody(mapStr),mapStr,"form/reportForm/reportForm_hospitalization_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 *获取获药师审核导出信息
	 */
	@RequestMapping(value ="/reportForm_hospitalization_getExcelSql.do")
	public void hospitalizationExcelSql(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			respBack(UtilJson.mapToJson(reportFormServerImp.hospitalizationExcelSql(mapStr)), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	
	/**
	 *分页获取院长统计报表
	 */
	@RequestMapping(value ="/reportForm_dean_report_index.do")
	public String deanReportIndex(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			String type=req.getParameter("type");
			mapStr.put("type", type);
			req.setAttribute("info", reportFormServerImp.tDeanReport(mapStr));
			return this.returnPage("form/reportForm/reportForm_dean_report_index"+type+".jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	* 问诊记录详情
	* @param mapStr
	* @throws Exception
	*/
	@RequestMapping(value ="reportForm_getInquiryLogDetails.do")
	public void getInquiryLogDetails(HttpServletRequest req,HttpServletResponse resp){
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			this.respBack(reportFormServerImp.updateInquiryLogDetails(mapStr), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}

	/**
	* 住院建议详情
	* @param mapStr
	* @throws Exception
	*/
	@RequestMapping(value ="reportForm_getInquiryLogHospitalizationDetails.do")
	public void getInquiryLogHospitalizationDetails(HttpServletRequest req,HttpServletResponse resp){
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			this.respBack(reportFormServerImp.getInquiryLogHospitalizationDetails(mapStr), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	/**
	* 健康指导详情
	* @param mapStr
	* @throws Exception
	*/
	@RequestMapping(value ="reportForm_getInquiryLogHealthGuidanceDetails.do")
	public void getInquiryLogHealthGuidanceDetails(HttpServletRequest req,HttpServletResponse resp){
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			this.respBack(reportFormServerImp.getInquiryLogHealthGuidanceDetails(mapStr), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	/**
	* 检验单详情
	* @param mapStr
	* @throws Exception
	*/
	@RequestMapping(value ="reportForm_getInquiryLogChecklistDetails.do")
	public void getInquiryLogChecklistDetails(HttpServletRequest req,HttpServletResponse resp){
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			this.respBack(reportFormServerImp.getInquiryLogChecklistDetails(mapStr), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	/**
	* 处方详情
	* @param mapStr
	* @throws Exception
	*/
	@RequestMapping(value ="reportForm_getInquiryLogPrescriptionDetails.do")
	public void getInquiryLogPrescriptionDetails(HttpServletRequest req,HttpServletResponse resp){
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			this.respBack(reportFormServerImp.updateInquiryLogPrescriptionDetails(mapStr), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	
	/**
	 *分页获取大数据图
	 */
	@RequestMapping(value ="/reportForm_bigData_index.do")
	public String bigDataIndex(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			Map<String, String> bigData = reportFormServerImp.tBigDataIndex(mapStr);
			
			req.setAttribute("bigData", bigData);
//			mapStr.put("dataListString", dataListString);
//	   		mapStr.put("geoCoordMapString", geoCoordMapString);
			return this.returnPage("form/reportForm/reportForm_bigData_index.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
		
}
