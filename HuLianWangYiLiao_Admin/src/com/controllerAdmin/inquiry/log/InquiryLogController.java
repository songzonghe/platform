package com.controllerAdmin.inquiry.log;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.doctor.info.DoctorInfoService;
import com.servicesAdmin.inquiry.log.InquiryLogService;
import com.servicesAdmin.inquiry.patient.info.InquiryPatientInfoService;
import com.servicesAdmin.store.info.StoreInfoService;
import com.servicesAdmin.user.info.UserInfoService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 网络医院问诊记录 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class InquiryLogController  extends ControllerUtil {

	@Resource
	private InquiryLogService  inquiryLogServiceImp;
	@Resource
	private StoreInfoService  storeInfoServiceImp;
	@Resource
	private UserInfoService  userInfoServiceImp;
	@Resource
	private DoctorInfoService  doctorInfoService;
	@Resource
	private InquiryPatientInfoService  inquiryPatientInfoService;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取网络医院问诊记录信息
	 */
	@RequestMapping(value ="/inquiryLog_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryLogServiceImp.tBody(mapStr),mapStr,"form/inquiry/log/inquiryLog_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加网络医院问诊记录页面
	 */
	@RequestMapping(value ="/inquiryLog_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("shopList", storeInfoServiceImp.shopList(mapStr));
			req.setAttribute("personList", userInfoServiceImp.personList(mapStr));
			req.setAttribute("doctorList", doctorInfoService.doctorList(mapStr));
			req.setAttribute("patientList", inquiryPatientInfoService.patientList(mapStr));
			return this.returnPage("form/inquiry/log/inquiryLog_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 *进行网络医院问诊记录修改和新增操作
	 */
	@RequestMapping(value ="/inquiryLog_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("log_id"))) {
				Map<String, Object> mapObj = inquiryLogServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/inquiryLog_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryLogServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/inquiryLog_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条网络医院问诊记录信息
	 */
	@RequestMapping(value ="/inquiryLog_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryLogServiceImp.find_Map(mapStr),"form/inquiry/log/details/inquiryLog_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改网络医院问诊记录页面
	 */
	@RequestMapping(value ="/inquiryLog_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("shopList", storeInfoServiceImp.shopList(mapStr));
			req.setAttribute("personList", userInfoServiceImp.personList(mapStr));
			req.setAttribute("doctorList", doctorInfoService.doctorList(mapStr));
			req.setAttribute("patientList", inquiryPatientInfoService.patientList(mapStr));
			return this.editPageUtil(inquiryLogServiceImp.find_Map(mapStr),"form/inquiry/log/inquiryLog_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除网络医院问诊记录信息操作
	 */
	@RequestMapping(value ="/inquiryLog_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryLogServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}

	/**
	 * 弹框 打开/获取 用户其他信息
	 */
	@RequestMapping(value = "/inquiryLog_getInquiryLogDetailsPage.do")
	public String getTeacherInfoPage(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Map<String, String> mapStr = this.getMapStr(req);
			// 打开窗口
			if ("openinquiryLog".equals(mapStr.get("openType"))) {
				req.setAttribute("datas", mapStr);
				return "form/inquiryLogs/page/inquiryLogDetailsPage.jsp";
			}
			// 第一次获取数据
			if (!UtilValiDate.isEmpty(mapStr.get("log_id"))) {
				mapStr.put("log_id", req.getParameter("id"));
			}
			if (!UtilValiDate.isEmpty(mapStr.get("data_type"))) {
				mapStr.put("data_type", req.getParameter("type"));
			}
			String backPage = "";
			// 1.问诊记录健康指导 2.问诊记录检验单03.问诊记录检验检查单详情 04.问诊记录处方05.问诊记录处方详情6.问诊记录住院建议7.问诊记录上传图片
			if ("2".equals(mapStr.get("data_type"))) {
				backPage = "form/inquiryLogs/checklist/inquiryLogChecklist_index.jsp";
			}else if ("3".equals(mapStr.get("data_type"))) {
				backPage = "form/inquiryLogs/inquiryLogChecklistDetails/inquiryLogChecklistDetails_index.jsp";
			}else if ("4".equals(mapStr.get("data_type"))) {
				backPage = "form/inquiryLogs/prescription/inquiryLogPrescription_index.jsp";
			}else if ("5".equals(mapStr.get("data_type"))) {
				backPage = "form/inquiryLogs/inquiryLogPrescriptionDetails/inquiryLogPrescriptionDetails_index.jsp";
			}else if ("6".equals(mapStr.get("data_type"))) {
				backPage = "form/inquiryLogs/hospitalization/inquiryLogHospitalization_index.jsp";
			}else if ("7".equals(mapStr.get("data_type"))) {
				backPage = "form/inquiryLogs/img/inquiryLogImg_index.jsp";
			} else { 
				backPage ="form/inquiryLogs/health/guidance/inquiryLogHealthGuidance_page.jsp";
			}
				
					
			// 获取数据
			return this.tBodyUtil(inquiryLogServiceImp.find_inquiryLogLists(mapStr), mapStr, backPage, req, resp);
								
		} catch (Exception e) {
			this.errorResp(e, resp);
		}
		return this.returnError();
	}
	

	/**
	 *分页获取网络医院问诊记录信息
	 */
	@RequestMapping(value ="/inquiryLog_indexs.do")
	public String indexs(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryLogServiceImp.tBody(mapStr),mapStr,"form/inquiryLogs/inquiryLog_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/************************系统生成方法完毕******************************/
}

