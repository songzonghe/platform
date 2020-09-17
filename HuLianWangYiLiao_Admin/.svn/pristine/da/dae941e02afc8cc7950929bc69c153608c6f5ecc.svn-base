package com.controllerAdmin.util.unprescribed.reasons;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.unprescribed.reasons.UtilUnprescribedReasonsService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 未开方原因 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilUnprescribedReasonsController  extends ControllerUtil {

	@Resource
	private UtilUnprescribedReasonsService  utilUnprescribedReasonsServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取未开方原因信息
	 */
	@RequestMapping(value ="/utilUnprescribedReasons_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilUnprescribedReasonsServiceImp.tBody(mapStr),mapStr,"form/util/unprescribed/reasons/utilUnprescribedReasons_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加未开方原因页面
	 */
	@RequestMapping(value ="/utilUnprescribedReasons_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/unprescribed/reasons/utilUnprescribedReasons_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行未开方原因修改和新增操作
	 */
	@RequestMapping(value ="/utilUnprescribedReasons_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("reasons_id"))) {
				Map<String, Object> mapObj = utilUnprescribedReasonsServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/unprescribed/reasons/utilUnprescribedReasons_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilUnprescribedReasonsServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/unprescribed/reasons/utilUnprescribedReasons_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条未开方原因信息
	 */
	@RequestMapping(value ="/utilUnprescribedReasons_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilUnprescribedReasonsServiceImp.find_Map(mapStr),"form/util/unprescribed/reasons/details/utilUnprescribedReasons_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改未开方原因页面
	 */
	@RequestMapping(value ="/utilUnprescribedReasons_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilUnprescribedReasonsServiceImp.find_Map(mapStr),"form/util/unprescribed/reasons/utilUnprescribedReasons_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除未开方原因信息操作
	 */
	@RequestMapping(value ="/utilUnprescribedReasons_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilUnprescribedReasonsServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

