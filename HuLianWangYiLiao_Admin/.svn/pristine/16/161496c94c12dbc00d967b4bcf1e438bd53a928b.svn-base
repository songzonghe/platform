package com.controllerAdmin.inquiry.log.checklist.details.inquiryLogChecklistDetails;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.inquiry.log.checklist.details.inquiryLogChecklistDetails.InquiryLogChecklistDetailsService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊记录检验检查单详情 controller 实现类 
 *  操作人： 苏洪伟
 */ 
@Controller
public class InquiryLogChecklistDetailsController  extends ControllerUtil {

	@Resource
	private InquiryLogChecklistDetailsService  inquiryLogChecklistDetailsServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *获取问诊记录检验检查单详情数据
	 */
	@RequestMapping(value ="/inquiryLogChecklistDetails_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryLogChecklistDetailsServiceImp.tBody(mapStr),mapStr,"form/inquiry/log/checklist/details/inquiryLogChecklist_details.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开新增问诊记录检验检查单详情的页面
	 */
	@RequestMapping(value ="/inquiryLogChecklistDetails_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.returnPage("form/inquiry/log/checklist/details/inquiryLogChecklistDetails/inquiryLogChecklistDetails_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *新增/修改问诊记录检验检查单详情的数据
	 */
	@RequestMapping(value ="/inquiryLogChecklistDetails_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("checklist_details_id"))) {
				Map<String, Object> mapObj = inquiryLogChecklistDetailsServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/checklist/details/inquiryLogChecklistDetails/inquiryLogChecklistDetails_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryLogChecklistDetailsServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/checklist/details/inquiryLogChecklistDetails/inquiryLogChecklistDetails_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取单个问诊记录检验检查单详情数据
	 */
	@RequestMapping(value ="/inquiryLogChecklistDetails_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryLogChecklistDetailsServiceImp.find_Map(mapStr),"form/inquiry/log/checklist/details/inquiryLogChecklistDetails/inquiryLogChecklistDetails_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改问诊记录检验检查单详情的页面
	 */
	@RequestMapping(value ="/inquiryLogChecklistDetails_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(inquiryLogChecklistDetailsServiceImp.find_Map(mapStr),"form/inquiry/log/checklist/details/inquiryLogChecklistDetails/inquiryLogChecklistDetails_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *删除问诊记录检验检查单详情数据
	 */
	@RequestMapping(value ="/inquiryLogChecklistDetails_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryLogChecklistDetailsServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

