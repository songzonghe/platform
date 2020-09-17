package com.controllerAdmin.util.company;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.company.UtilCompanyService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 厂家 controller 实现类 
 * 操作人： 刘杰
 */ 
@Controller
public class UtilCompanyController  extends ControllerUtil {

	@Resource
	private UtilCompanyService  utilCompanyServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取厂家信息
	 */
	@RequestMapping(value ="/utilCompany_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilCompanyServiceImp.tBody(mapStr),mapStr,"form/util/company/utilCompany_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加厂家页面
	 */
	@RequestMapping(value ="/utilCompany_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/company/utilCompany_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行厂家修改和新增操作
	 */
	@RequestMapping(value ="/utilCompany_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("log_id"))) {
				Map<String, Object> mapObj = utilCompanyServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/company/utilCompany_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilCompanyServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/company/utilCompany_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条厂家信息
	 */
	@RequestMapping(value ="/utilCompany_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilCompanyServiceImp.find_Map(mapStr),"form/util/company/details/utilCompany_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改厂家页面
	 */
	@RequestMapping(value ="/utilCompany_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilCompanyServiceImp.find_Map(mapStr),"form/util/company/utilCompany_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除厂家信息操作
	 */
	@RequestMapping(value ="/utilCompany_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilCompanyServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

