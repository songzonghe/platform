package com.controllerAdmin.util.cooperative.enterprises;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.cooperative.enterprises.UtilCooperativeEnterprisesService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 合作企业 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilCooperativeEnterprisesController  extends ControllerUtil {

	@Resource
	private UtilCooperativeEnterprisesService  utilCooperativeEnterprisesServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取合作企业信息
	 */
	@RequestMapping(value ="/utilCooperativeEnterprises_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilCooperativeEnterprisesServiceImp.tBody(mapStr),mapStr,"form/util/cooperative/enterprises/utilCooperativeEnterprises_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加合作企业页面
	 */
	@RequestMapping(value ="/utilCooperativeEnterprises_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/cooperative/enterprises/utilCooperativeEnterprises_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行合作企业修改和新增操作
	 */
	@RequestMapping(value ="/utilCooperativeEnterprises_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("enterprises_id"))) {
				Map<String, Object> mapObj = utilCooperativeEnterprisesServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/cooperative/enterprises/utilCooperativeEnterprises_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilCooperativeEnterprisesServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/cooperative/enterprises/utilCooperativeEnterprises_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条合作企业信息
	 */
	@RequestMapping(value ="/utilCooperativeEnterprises_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilCooperativeEnterprisesServiceImp.find_Map(mapStr),"form/util/cooperative/enterprises/details/utilCooperativeEnterprises_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改合作企业页面
	 */
	@RequestMapping(value ="/utilCooperativeEnterprises_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilCooperativeEnterprisesServiceImp.find_Map(mapStr),"form/util/cooperative/enterprises/utilCooperativeEnterprises_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除合作企业信息操作
	 */
	@RequestMapping(value ="/utilCooperativeEnterprises_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilCooperativeEnterprisesServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

