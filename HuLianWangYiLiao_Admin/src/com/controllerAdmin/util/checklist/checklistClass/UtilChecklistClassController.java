package com.controllerAdmin.util.checklist.checklistClass;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.checklist.checklistClass.UtilChecklistClassService;
import com.servicesAdmin.util.checklist.checklistClass.details.utilChecklist.UtilChecklistService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 检验检查分类 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilChecklistClassController  extends ControllerUtil {

	@Resource
	private UtilChecklistClassService  utilChecklistClassServiceImp;
	@Resource
	private UtilChecklistService  utilChecklistServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取检验检查分类信息
	 */
	@RequestMapping(value ="/utilChecklistClass_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("listMap", utilChecklistClassServiceImp.tBody(mapStr));
			return returnPage("form/util/checklist/checklistClass/utilChecklistClass_index.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加检验检查分类页面
	 */
	@RequestMapping(value ="/utilChecklistClass_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if(UtilValiDate.isEmpty(mapStr.get("checklist_class_id"))) {
				//获取上级
				req.setAttribute("upmap", utilChecklistClassServiceImp.find_Map(mapStr));
			}
			req.setAttribute("info", mapStr);
			return this.returnPage("form/util/checklist/checklistClass/utilChecklistClass_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行检验检查分类修改和新增操作
	 */
	@RequestMapping(value ="/utilChecklistClass_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("data", mapStr);
			if (UtilValiDate.isEmpty(mapStr.get("checklist_class_id"))) {
				Map<String, Object> mapObj = utilChecklistClassServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/checklist/checklistClass/utilChecklistClass_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilChecklistClassServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/checklist/checklistClass/utilChecklistClass_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条检验检查分类信息
	 */
	@RequestMapping(value ="/utilChecklistClass_findData.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("data", mapStr);
			req.setAttribute("listMap", utilChecklistClassServiceImp.tBody(mapStr));
			return returnPage("form/util/checklist/checklistClass/utilChecklistClass_indexTr.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改检验检查分类页面
	 */
	@RequestMapping(value ="/utilChecklistClass_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("info", mapStr);
			return this.editPageUtil(utilChecklistClassServiceImp.find_Map(mapStr),"form/util/checklist/checklistClass/utilChecklistClass_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除检验检查分类信息操作
	 */
	@RequestMapping(value ="/utilChecklistClass_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilChecklistClassServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

