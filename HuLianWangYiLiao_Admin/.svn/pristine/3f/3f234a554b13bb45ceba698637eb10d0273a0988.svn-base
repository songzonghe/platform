package com.controllerAdmin.doctor.info;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.doctor.info.DoctorInfoService;
import com.servicesAdmin.util.department.UtilDepartmentService;
import com.servicesAdmin.util.dictionaries.data.UtilDictionariesDataService;
import com.servicesAdmin.util.doctor.title.UtilDoctorTitleService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 医生基本资料 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class DoctorInfoController  extends ControllerUtil {

	@Resource
	private DoctorInfoService  doctorInfoServiceImp;
	@Resource
	private UtilDepartmentService  utilDepartmentService;
	
	@Resource
	private UtilDoctorTitleService  utilDoctorTitleServiceImp;
	@Resource
	private UtilDictionariesDataService  utilDictionariesDataServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取医生基本资料信息
	 */
	@RequestMapping(value ="/doctorInfo_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(doctorInfoServiceImp.tBody(mapStr),mapStr,"form/doctor/info/doctorInfo_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加医生基本资料页面
	 */
	@RequestMapping(value ="/doctorInfo_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("departmentList", utilDepartmentService.departmentList(mapStr));
			req.setAttribute("doctorTitleList", utilDoctorTitleServiceImp.doctorTitleList(mapStr));
			req.setAttribute("allList", utilDictionariesDataServiceImp.findAllData(mapStr.get("getStr")));
			return this.returnPage("form/doctor/info/doctorInfo_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行医生基本资料修改和新增操作
	 */
	@RequestMapping(value ="/doctorInfo_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("doctor_id"))) {
				Map<String, Object> mapObj = doctorInfoServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/doctor/info/doctorInfo_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = doctorInfoServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/doctor/info/doctorInfo_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条医生基本资料信息
	 */
	@RequestMapping(value ="/doctorInfo_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(doctorInfoServiceImp.find_Map(mapStr),"form/doctor/info/details/doctorInfo_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改医生基本资料页面
	 */
	@RequestMapping(value ="/doctorInfo_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("departmentList", utilDepartmentService.departmentList(mapStr));
			req.setAttribute("doctorTitleList", utilDoctorTitleServiceImp.doctorTitleList(mapStr));
			req.setAttribute("allList", utilDictionariesDataServiceImp.findAllData(mapStr.get("getStr")));
			String url = "form/doctor/info/doctorInfo_editPage.jsp";
			if("2".equals(mapStr.get("type"))) {
				url="form/doctor/info/doctorInfo_editPaw.jsp";
			}
			return this.editPageUtil(doctorInfoServiceImp.find_Map(mapStr),url,req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除医生基本资料信息操作
	 */
	@RequestMapping(value ="/doctorInfo_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			doctorInfoServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

