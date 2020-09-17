package com.controllerAdmin.util.certificates;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.certificates.UtilCertificatesService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 系统初始化证件 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilCertificatesController  extends ControllerUtil {

	@Resource
	private UtilCertificatesService  utilCertificatesServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取系统初始化证件信息
	 */
	@RequestMapping(value ="/utilCertificates_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilCertificatesServiceImp.tBody(mapStr),mapStr,"form/util/certificates/utilCertificates_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加系统初始化证件页面
	 */
	@RequestMapping(value ="/utilCertificates_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/certificates/utilCertificates_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行系统初始化证件修改和新增操作
	 */
	@RequestMapping(value ="/utilCertificates_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("certificates_id"))) {
				Map<String, Object> mapObj = utilCertificatesServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/certificates/utilCertificates_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilCertificatesServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/certificates/utilCertificates_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条系统初始化证件信息
	 */
	@RequestMapping(value ="/utilCertificates_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilCertificatesServiceImp.find_Map(mapStr),"form/util/certificates/details/utilCertificates_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改系统初始化证件页面
	 */
	@RequestMapping(value ="/utilCertificates_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilCertificatesServiceImp.find_Map(mapStr),"form/util/certificates/utilCertificates_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除系统初始化证件信息操作
	 */
	@RequestMapping(value ="/utilCertificates_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilCertificatesServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

