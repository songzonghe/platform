package com.controllerAdmin.doctor.drug;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.doctor.drug.DoctorDrugService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 我的用药 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class DoctorDrugController  extends ControllerUtil {

	@Resource
	private DoctorDrugService  doctorDrugServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取我的用药信息
	 */
	@RequestMapping(value ="/doctorDrug_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(doctorDrugServiceImp.tBody(mapStr),mapStr,"form/doctor/drug/doctorDrug_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加我的用药页面
	 */
	@RequestMapping(value ="/doctorDrug_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/doctor/drug/doctorDrug_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行我的用药修改和新增操作
	 */
	@RequestMapping(value ="/doctorDrug_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("doctor_drug_id"))) {
				Map<String, Object> mapObj = doctorDrugServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/doctor/drug/doctorDrug_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = doctorDrugServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/doctor/drug/doctorDrug_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条我的用药信息
	 */
	@RequestMapping(value ="/doctorDrug_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(doctorDrugServiceImp.find_Map(mapStr),"form/doctor/drug/details/doctorDrug_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改我的用药页面
	 */
	@RequestMapping(value ="/doctorDrug_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(doctorDrugServiceImp.find_Map(mapStr),"form/doctor/drug/doctorDrug_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除我的用药信息操作
	 */
	@RequestMapping(value ="/doctorDrug_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			doctorDrugServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

