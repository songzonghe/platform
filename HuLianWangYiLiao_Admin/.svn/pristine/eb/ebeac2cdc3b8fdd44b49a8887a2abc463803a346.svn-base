package com.controllerAdmin.pharmacist.info;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.pharmacist.info.PharmacistInfoService;
import com.util.MD5;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 药师管理 controller 实现类 
 * 操作人： 张龙
 */ 
@Controller
public class PharmacistInfoController  extends ControllerUtil {

	@Resource
	private PharmacistInfoService  pharmacistInfoServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取药师管理信息
	 */
	@RequestMapping(value ="/pharmacistInfo_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			String url=(req.getRequestURL()+"").replace("pharmacistInfo_index.do", "login.do?hi="+MD5.numberEncoder("2-"+mapStr.get("login_hospital_id")));
			req.setAttribute("showUrl", url);
			return this.tBodyUtil(pharmacistInfoServiceImp.tBody(mapStr),mapStr,"form/pharmacist/info/pharmacistInfo_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加药师管理页面
	 */
	@RequestMapping(value ="/pharmacistInfo_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/pharmacist/info/pharmacistInfo_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行药师管理修改和新增操作
	 */
	@RequestMapping(value ="/pharmacistInfo_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("pharmacist_id"))) {
				Map<String, Object> mapObj = pharmacistInfoServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/pharmacist/info/pharmacistInfo_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = pharmacistInfoServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/pharmacist/info/pharmacistInfo_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *判断账号是否存在
	 */
	@RequestMapping(value ="/pharmacistInfo_findByNumber.do")
	public void findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			mapStr.put("find_number",req.getParameter("number"));
			if(!UtilValiDate.isEmpty(req.getParameter("number")) || pharmacistInfoServiceImp.find_Map(mapStr).size()==0) {
				respBack(true, resp);
			}
			respBack(false, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}

	/**
	 *打开修改药师管理页面
	 */
	@RequestMapping(value ="/pharmacistInfo_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(pharmacistInfoServiceImp.find_Map(mapStr),"form/pharmacist/info/pharmacistInfo_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除药师管理信息操作
	 */
	@RequestMapping(value ="/pharmacistInfo_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			pharmacistInfoServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

