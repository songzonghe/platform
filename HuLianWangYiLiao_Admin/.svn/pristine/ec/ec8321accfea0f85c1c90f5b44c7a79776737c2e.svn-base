package com.controllerAdmin.util.incompatibility;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.drug.UtilDrugService;
import com.servicesAdmin.util.incompatibility.UtilIncompatibilityService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 配伍禁忌 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilIncompatibilityController  extends ControllerUtil {

	@Resource
	private UtilIncompatibilityService  utilIncompatibilityServiceImp;
	@Resource
	private UtilDrugService  utilDrugServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取配伍禁忌信息
	 */
	@RequestMapping(value ="/utilIncompatibility_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilIncompatibilityServiceImp.tBody(mapStr),mapStr,"form/util/incompatibility/utilIncompatibility_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加配伍禁忌页面
	 */
	@RequestMapping(value ="/utilIncompatibility_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			String drug_id = req.getParameter("drug_id");
			String drug_id2 = req.getParameter("drug_id2");
			mapStr.put("drug_id", drug_id);
			mapStr.put("drug_id2", drug_id2);
			req.setAttribute("drugList",utilDrugServiceImp.drugList(mapStr));
			return this.returnPage("form/util/incompatibility/utilIncompatibility_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行配伍禁忌修改和新增操作
	 */
	@RequestMapping(value ="/utilIncompatibility_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("incompatibility_id"))) {
				Map<String, Object> mapObj = utilIncompatibilityServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/incompatibility/utilIncompatibility_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilIncompatibilityServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/incompatibility/utilIncompatibility_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条配伍禁忌信息
	 */
	@RequestMapping(value ="/utilIncompatibility_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilIncompatibilityServiceImp.find_Map(mapStr),"form/util/incompatibility/details/utilIncompatibility_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改配伍禁忌页面
	 */
	@RequestMapping(value ="/utilIncompatibility_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("drugList",utilDrugServiceImp.drugList(mapStr));
			return this.editPageUtil(utilIncompatibilityServiceImp.find_Map(mapStr),"form/util/incompatibility/utilIncompatibility_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除配伍禁忌信息操作
	 */
	@RequestMapping(value ="/utilIncompatibility_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilIncompatibilityServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}
	/**
	 *进行配伍禁忌判断
	 */
	@RequestMapping(value ="/utilIncompatibility_isBoolData.do")
	public void isBoolData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			mapStr.put("drug_id", req.getParameter("drug_id"));
			mapStr.put("drug_id2", req.getParameter("drug_id2"));
			if(UtilValiDate.isEmpty(req.getParameter("drug_id")) && UtilValiDate.isEmpty(req.getParameter("drug_id2")) ) {
				this.respBack(utilIncompatibilityServiceImp.find_boolMap(mapStr),resp);
			}else {
				this.respBack(true,resp);
			}
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}

	/************************系统生成方法完毕******************************/
}

