package com.controllerAdmin.util.hospital;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.dictionaries.data.UtilDictionariesDataService;
import com.servicesAdmin.util.hospital.UtilHospitalService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 系统医院 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilHospitalController  extends ControllerUtil {

	@Resource
	private UtilHospitalService  utilHospitalServiceImp;
	@Resource
	private UtilDictionariesDataService  utilDictionariesDataServiceImp;
	/************************系统生成方法开始******************************/

	/**
	 *分页获取系统医院信息
	 */
	@RequestMapping(value ="/utilHospital_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if("1".equals(mapStr.get("login_account_type"))) {
				String url=(req.getRequestURL()+"").replace("utilHospital_index.do", "login.do?hi=");
				mapStr.put("showUrl", url);
				req.setAttribute("allList", utilDictionariesDataServiceImp.findAllData("004,005,007,008,011,013"));
				return this.findByIdUtil(utilHospitalServiceImp.find_Map(mapStr),"form/util/hospital/utilHospital_shop_indexPage.jsp", req, resp);
			}
			return this.tBodyUtil(utilHospitalServiceImp.tBody(mapStr),mapStr,"form/util/hospital/utilHospital_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加系统医院页面
	 */
	@RequestMapping(value ="/utilHospital_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("allList", utilDictionariesDataServiceImp.findAllData(mapStr.get("getStr")));
			return this.returnPage("form/util/hospital/utilHospital_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行系统医院修改和新增操作
	 */
	@RequestMapping(value ="/utilHospital_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				Map<String, Object> mapObj = utilHospitalServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/hospital/utilHospital_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilHospitalServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/hospital/utilHospital_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条系统医院信息
	 */
	@RequestMapping(value ="/utilHospital_findById.do")
	public void findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			mapStr.put("find_hospital_number", req.getParameter("hospital_number"));
			if(UtilValiDate.isEmpty(mapStr.get("find_hospital_number")) && utilHospitalServiceImp.find_Map(mapStr).size()>0) {
				respBack(false, resp);
			}
			respBack(true, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}

	/**
	 *打开修改系统医院页面
	 */
	@RequestMapping(value ="/utilHospital_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			String url=(req.getRequestURL()+"").replace("utilHospital_editPage.do", "login.do?hi=");
			mapStr.put("showUrl", url);
			req.setAttribute("allList", utilDictionariesDataServiceImp.findAllData(mapStr.get("getStr")));
			return this.editPageUtil(utilHospitalServiceImp.find_Map(mapStr),"form/util/hospital/utilHospital_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除系统医院信息操作
	 */
	@RequestMapping(value ="/utilHospital_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilHospitalServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

