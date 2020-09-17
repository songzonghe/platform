package com.controllerAdmin.inquiry.patient.info;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.inquiry.patient.info.InquiryPatientInfoService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 网络医院问诊患者信息 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class InquiryPatientInfoController  extends ControllerUtil {

	@Resource
	private InquiryPatientInfoService  inquiryPatientInfoServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取网络医院问诊患者信息信息
	 */
	@RequestMapping(value ="/inquiryPatientInfo_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryPatientInfoServiceImp.tBody(mapStr),mapStr,"form/inquiry/patient/info/inquiryPatientInfo_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加网络医院问诊患者信息页面
	 */
	@RequestMapping(value ="/inquiryPatientInfo_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/inquiry/patient/info/inquiryPatientInfo_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行网络医院问诊患者信息修改和新增操作
	 */
	@RequestMapping(value ="/inquiryPatientInfo_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_id"))) {
				Map<String, Object> mapObj = inquiryPatientInfoServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/patient/info/inquiryPatientInfo_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryPatientInfoServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/patient/info/inquiryPatientInfo_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条网络医院问诊患者信息信息
	 */
	@RequestMapping(value ="/inquiryPatientInfo_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryPatientInfoServiceImp.find_Map(mapStr),"form/inquiry/patient/info/details/inquiryPatientInfo_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改网络医院问诊患者信息页面
	 */
	@RequestMapping(value ="/inquiryPatientInfo_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(inquiryPatientInfoServiceImp.find_Map(mapStr),"form/inquiry/patient/info/inquiryPatientInfo_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除网络医院问诊患者信息信息操作
	 */
	@RequestMapping(value ="/inquiryPatientInfo_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryPatientInfoServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

