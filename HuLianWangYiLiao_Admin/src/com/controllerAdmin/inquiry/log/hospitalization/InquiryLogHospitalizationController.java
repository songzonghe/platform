package com.controllerAdmin.inquiry.log.hospitalization;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.inquiry.log.hospitalization.InquiryLogHospitalizationService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊记录住院建议 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class InquiryLogHospitalizationController  extends ControllerUtil {

	@Resource
	private InquiryLogHospitalizationService  inquiryLogHospitalizationServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取问诊记录住院建议信息
	 */
	@RequestMapping(value ="/inquiryLogHospitalization_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryLogHospitalizationServiceImp.tBody(mapStr),mapStr,"form/inquiry/log/hospitalization/inquiryLogHospitalization_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加问诊记录住院建议页面
	 */
	@RequestMapping(value ="/inquiryLogHospitalization_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/inquiry/log/hospitalization/inquiryLogHospitalization_addPages.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行问诊记录住院建议修改和新增操作
	 */
	@RequestMapping(value ="/inquiryLogHospitalization_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("hospitalization_id"))) {
				Map<String, Object> mapObj = inquiryLogHospitalizationServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/hospitalization/inquiryLogHospitalization_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryLogHospitalizationServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/hospitalization/inquiryLogHospitalization_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条问诊记录住院建议信息
	 */
	@RequestMapping(value ="/inquiryLogHospitalization_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryLogHospitalizationServiceImp.find_Map(mapStr),"form/inquiry/log/hospitalization/details/inquiryLogHospitalization_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改问诊记录住院建议页面
	 */
	@RequestMapping(value ="/inquiryLogHospitalization_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(inquiryLogHospitalizationServiceImp.find_Map(mapStr),"form/inquiry/log/hospitalization/inquiryLogHospitalization_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除问诊记录住院建议信息操作
	 */
	@RequestMapping(value ="/inquiryLogHospitalization_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryLogHospitalizationServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

