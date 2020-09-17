package com.controllerAdmin.util.hospital.institution.business;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.hospital.institution.business.UtilHospitalInstitutionBusinessService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 业务开展情况 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilHospitalInstitutionBusinessController  extends ControllerUtil {

	@Resource
	private UtilHospitalInstitutionBusinessService  utilHospitalInstitutionBusinessServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取业务开展情况信息
	 */
	@RequestMapping(value ="/utilHospitalInstitutionBusiness_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilHospitalInstitutionBusinessServiceImp.tBody(mapStr),mapStr,"form/util/hospital/institution/business/utilHospitalInstitutionBusiness_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加业务开展情况页面
	 */
	@RequestMapping(value ="/utilHospitalInstitutionBusiness_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/hospital/institution/business/utilHospitalInstitutionBusiness_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行业务开展情况修改和新增操作
	 */
	@RequestMapping(value ="/utilHospitalInstitutionBusiness_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("business_id"))) {
				Map<String, Object> mapObj = utilHospitalInstitutionBusinessServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/hospital/institution/business/utilHospitalInstitutionBusiness_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilHospitalInstitutionBusinessServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/hospital/institution/business/utilHospitalInstitutionBusiness_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条业务开展情况信息
	 */
	@RequestMapping(value ="/utilHospitalInstitutionBusiness_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilHospitalInstitutionBusinessServiceImp.find_Map(mapStr),"form/util/hospital/institution/business/details/utilHospitalInstitutionBusiness_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改业务开展情况页面
	 */
	@RequestMapping(value ="/utilHospitalInstitutionBusiness_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilHospitalInstitutionBusinessServiceImp.find_Map(mapStr),"form/util/hospital/institution/business/utilHospitalInstitutionBusiness_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除业务开展情况信息操作
	 */
	@RequestMapping(value ="/utilHospitalInstitutionBusiness_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilHospitalInstitutionBusinessServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

