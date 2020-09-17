package com.controllerAdmin.util.prescription;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.icon.UtilIconService;
import com.servicesAdmin.util.prescription.UtilPrescriptionService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 处方模板 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilPrescriptionController  extends ControllerUtil {

	@Resource
	private UtilPrescriptionService  utilPrescriptionServiceImp;
	@Resource
	private UtilIconService  utilIconService;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取处方模板信息
	 */
	@RequestMapping(value ="/utilPrescription_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilPrescriptionServiceImp.tBody(mapStr),mapStr,"form/util/prescription/utilPrescription_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加处方模板页面
	 */
	@RequestMapping(value ="/utilPrescription_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("icdList", utilIconService.icdList(mapStr));
			req.setAttribute("diagnosisList", utilPrescriptionServiceImp.find_diagnosisList(mapStr));
			req.setAttribute("doctorList", utilPrescriptionServiceImp.find_doctorList(mapStr));
			return this.returnPage("form/util/prescription/utilPrescription_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行处方模板修改和新增操作
	 */
	@RequestMapping(value ="/utilPrescription_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("prescription_id"))) {
				Map<String, Object> mapObj = utilPrescriptionServiceImp.update_Data(mapStr);
				mapObj.put("imgIsOpne", mapStr.get("imgIsOpne"));
				mapObj.put("imgSrc", mapStr.get("imgSrc"));
				mapObj.put("trIsOpen", mapStr.get("trIsOpen"));
				return this.updateDataUpdate(mapObj,"form/util/prescription/utilPrescription_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilPrescriptionServiceImp.add_Data(mapStr);
				mapObj.put("imgIsOpne", mapStr.get("imgIsOpne"));
				mapObj.put("imgSrc", mapStr.get("imgSrc"));
				mapObj.put("trIsOpen", mapStr.get("trIsOpen"));
				return this.updateDataUpdate(mapObj,"form/util/prescription/utilPrescription_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条处方模板信息
	 */
	@RequestMapping(value ="/utilPrescription_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilPrescriptionServiceImp.find_Map(mapStr),"form/util/prescription/details/utilPrescription_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改处方模板页面
	 */
	@RequestMapping(value ="/utilPrescription_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("icdList", utilIconService.icdList(mapStr));
			req.setAttribute("diagnosisList", utilPrescriptionServiceImp.find_diagnosisList(mapStr));
			req.setAttribute("doctorList", utilPrescriptionServiceImp.find_doctorList(mapStr));
			return this.editPageUtil(utilPrescriptionServiceImp.find_Map(mapStr),"form/util/prescription/utilPrescription_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除处方模板信息操作
	 */
	@RequestMapping(value ="/utilPrescription_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilPrescriptionServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

