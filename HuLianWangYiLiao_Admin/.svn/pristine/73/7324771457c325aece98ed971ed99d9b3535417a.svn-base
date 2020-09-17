package com.controllerAdmin.util.checklist.checklistClass.details.utilChecklist;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.checklist.checklistClass.details.utilChecklist.UtilChecklistService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 系统检验检查表 controller 实现类 
 *  操作人： 曾晓
 */ 
@Controller
public class UtilChecklistController  extends ControllerUtil {

	@Resource
	private UtilChecklistService  utilChecklistServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *获取系统检验检查表数据
	 */
	@RequestMapping(value ="/utilChecklist_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			
			req.setAttribute("info", mapStr);
			if("open".equals(mapStr.get("pageType"))){
				return returnPage("form/util/checklist/checklistClass/details/utilChecklistClass_details.jsp", req, resp);
			}
			return this.tBodyUtil(utilChecklistServiceImp.tBody(mapStr),mapStr,"form/util/checklist/checklistClass/details/utilChecklist/utilChecklist_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开新增系统检验检查表的页面
	 */
	@RequestMapping(value ="/utilChecklist_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.returnPage("form/util/checklist/checklistClass/details/utilChecklist/utilChecklist_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *新增/修改系统检验检查表的数据
	 */
	@RequestMapping(value ="/utilChecklist_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("checklist_id"))) {
				Map<String, Object> mapObj = utilChecklistServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/checklist/checklistClass/details/utilChecklist/utilChecklist_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilChecklistServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/checklist/checklistClass/details/utilChecklist/utilChecklist_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取单个系统检验检查表数据
	 */
	@RequestMapping(value ="/utilChecklist_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilChecklistServiceImp.find_Map(mapStr),"form/util/checklist/checklistClass/details/utilChecklist/utilChecklist_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改系统检验检查表的页面
	 */
	@RequestMapping(value ="/utilChecklist_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilChecklistServiceImp.find_Map(mapStr),"form/util/checklist/checklistClass/details/utilChecklist/utilChecklist_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *删除系统检验检查表数据
	 */
	@RequestMapping(value ="/utilChecklist_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilChecklistServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

