package com.controllerAdmin.inquiry.patient.measured.data;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.inquiry.patient.measured.data.InquiryPatientMeasuredDataService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊患者测量数据 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class InquiryPatientMeasuredDataController  extends ControllerUtil {

	@Resource
	private InquiryPatientMeasuredDataService  inquiryPatientMeasuredDataServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取问诊患者测量数据信息
	 */
	@RequestMapping(value ="/inquiryPatientMeasuredData_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryPatientMeasuredDataServiceImp.tBody(mapStr),mapStr,"form/inquiry/patient/measured/data/inquiryPatientMeasuredData_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加问诊患者测量数据页面
	 */
	@RequestMapping(value ="/inquiryPatientMeasuredData_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/inquiry/patient/measured/data/inquiryPatientMeasuredData_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行问诊患者测量数据修改和新增操作
	 */
	@RequestMapping(value ="/inquiryPatientMeasuredData_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("data_id"))) {
				Map<String, Object> mapObj = inquiryPatientMeasuredDataServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/patient/measured/data/inquiryPatientMeasuredData_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryPatientMeasuredDataServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/patient/measured/data/inquiryPatientMeasuredData_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条问诊患者测量数据信息
	 */
	@RequestMapping(value ="/inquiryPatientMeasuredData_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryPatientMeasuredDataServiceImp.find_Map(mapStr),"form/inquiry/patient/measured/data/details/inquiryPatientMeasuredData_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改问诊患者测量数据页面
	 */
	@RequestMapping(value ="/inquiryPatientMeasuredData_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(inquiryPatientMeasuredDataServiceImp.find_Map(mapStr),"form/inquiry/patient/measured/data/inquiryPatientMeasuredData_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除问诊患者测量数据信息操作
	 */
	@RequestMapping(value ="/inquiryPatientMeasuredData_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryPatientMeasuredDataServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

