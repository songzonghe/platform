package com.controllerAdmin.doctor.template;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.doctor.template.DoctorTemplateService;
import com.servicesAdmin.util.prescription.UtilPrescriptionService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 常用模板 controller 实现类 
 * 操作人： 刘杰
 */ 
@Controller
public class DoctorTemplateController  extends ControllerUtil {

	@Resource
	private DoctorTemplateService  doctorTemplateServiceImp;
	@Resource
	private UtilPrescriptionService  utilPrescriptionServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取常用模板信息
	 */
	@RequestMapping(value ="/doctorTemplate_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(doctorTemplateServiceImp.tBody(mapStr),mapStr,"form/doctor/template/doctorTemplate_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加常用模板页面
	 */
	@RequestMapping(value ="/doctorTemplate_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("doctorList", utilPrescriptionServiceImp.find_doctorList(mapStr));
			return this.returnPage("form/doctor/template/doctorTemplate_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行常用模板修改和新增操作
	 */
	@RequestMapping(value ="/doctorTemplate_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("template_id"))) {
				Map<String, Object> mapObj = doctorTemplateServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/doctor/template/doctorTemplate_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = doctorTemplateServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/doctor/template/doctorTemplate_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条常用模板信息
	 */
	@RequestMapping(value ="/doctorTemplate_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(doctorTemplateServiceImp.find_Map(mapStr),"form/doctor/template/details/doctorTemplate_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改常用模板页面
	 */
	@RequestMapping(value ="/doctorTemplate_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("doctorList", utilPrescriptionServiceImp.find_doctorList(mapStr));
			return this.editPageUtil(doctorTemplateServiceImp.find_Map(mapStr),"form/doctor/template/doctorTemplate_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除常用模板信息操作
	 */
	@RequestMapping(value ="/doctorTemplate_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			doctorTemplateServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

