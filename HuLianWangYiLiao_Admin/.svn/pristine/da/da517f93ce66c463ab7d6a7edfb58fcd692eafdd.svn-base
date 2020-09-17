package com.controllerAdmin.util.department;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.department.UtilDepartmentService;
import com.servicesAdmin.util.dictionaries.data.UtilDictionariesDataService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 系统科室 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilDepartmentController  extends ControllerUtil {

	@Resource
	private UtilDepartmentService  utilDepartmentServiceImp;

	@Resource
	private UtilDictionariesDataService  utilDictionariesDataServiceImp;
	/************************系统生成方法开始******************************/

	/**
	 *分页获取系统科室信息
	 */
	@RequestMapping(value ="/utilDepartment_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilDepartmentServiceImp.tBody(mapStr),mapStr,"form/util/department/utilDepartment_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加系统科室页面
	 */
	@RequestMapping(value ="/utilDepartment_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("allList", utilDictionariesDataServiceImp.findAllData(mapStr.get("getStr")));
			return this.returnPage("form/util/department/utilDepartment_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行系统科室修改和新增操作
	 */
	@RequestMapping(value ="/utilDepartment_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("department_id"))) {
				Map<String, Object> mapObj = utilDepartmentServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/department/utilDepartment_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilDepartmentServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/department/utilDepartment_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条系统科室信息
	 */
	@RequestMapping(value ="/utilDepartment_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilDepartmentServiceImp.find_Map(mapStr),"form/util/department/details/utilDepartment_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改系统科室页面
	 */
	@RequestMapping(value ="/utilDepartment_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("allList", utilDictionariesDataServiceImp.findAllData(mapStr.get("getStr")));
			return this.editPageUtil(utilDepartmentServiceImp.find_Map(mapStr),"form/util/department/utilDepartment_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除系统科室信息操作
	 */
	@RequestMapping(value ="/utilDepartment_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilDepartmentServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

