package com.controllerAdmin.inquiry.log.checklist;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.inquiry.log.checklist.InquiryLogChecklistService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊记录检验单 controller 实现类 
 * 操作人： 苏洪伟
 */ 
@Controller
public class InquiryLogChecklistController  extends ControllerUtil {

	@Resource
	private InquiryLogChecklistService  inquiryLogChecklistServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取问诊记录检验单信息
	 */
	@RequestMapping(value ="/inquiryLogChecklist_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryLogChecklistServiceImp.tBody(mapStr),mapStr,"form/inquiry/log/checklist/inquiryLogChecklist_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加问诊记录检验单页面
	 */
	@RequestMapping(value ="/inquiryLogChecklist_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/inquiry/log/checklist/inquiryLogChecklist_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行问诊记录检验单修改和新增操作
	 */
	@RequestMapping(value ="/inquiryLogChecklist_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("checklist_id"))) {
				Map<String, Object> mapObj = inquiryLogChecklistServiceImp.update_Data(mapStr);
				mapObj.put("imgIsOpne", mapStr.get("imgIsOpne"));
				mapObj.put("imgSrc", mapStr.get("imgSrc"));
				mapObj.put("trIsOpen", mapStr.get("trIsOpen"));
				return this.updateDataUpdate(mapObj,"form/inquiry/log/checklist/inquiryLogChecklist_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryLogChecklistServiceImp.add_Data(mapStr);
				mapObj.put("imgIsOpne", mapStr.get("imgIsOpne"));
				mapObj.put("imgSrc", mapStr.get("imgSrc"));
				mapObj.put("trIsOpen", mapStr.get("trIsOpen"));
				return this.updateDataUpdate(mapObj,"form/inquiry/log/checklist/inquiryLogChecklist_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条问诊记录检验单信息
	 */
	@RequestMapping(value ="/inquiryLogChecklist_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryLogChecklistServiceImp.find_Map(mapStr),"form/inquiry/log/checklist/details/inquiryLogChecklist_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改问诊记录检验单页面
	 */
	@RequestMapping(value ="/inquiryLogChecklist_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(inquiryLogChecklistServiceImp.find_Map(mapStr),"form/inquiry/log/checklist/inquiryLogChecklist_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除问诊记录检验单信息操作
	 */
	@RequestMapping(value ="/inquiryLogChecklist_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryLogChecklistServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

