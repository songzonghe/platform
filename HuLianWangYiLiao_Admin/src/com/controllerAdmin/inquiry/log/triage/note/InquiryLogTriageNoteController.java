package com.controllerAdmin.inquiry.log.triage.note;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.inquiry.log.triage.note.InquiryLogTriageNoteService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊记录分诊记录 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class InquiryLogTriageNoteController  extends ControllerUtil {

	@Resource
	private InquiryLogTriageNoteService  inquiryLogTriageNoteServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取问诊记录分诊记录信息
	 */
	@RequestMapping(value ="/inquiryLogTriageNote_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryLogTriageNoteServiceImp.tBody(mapStr),mapStr,"form/inquiry/log/triage/note/inquiryLogTriageNote_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加问诊记录分诊记录页面
	 */
	@RequestMapping(value ="/inquiryLogTriageNote_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/inquiry/log/triage/note/inquiryLogTriageNote_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行问诊记录分诊记录修改和新增操作
	 */
	@RequestMapping(value ="/inquiryLogTriageNote_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("note_id"))) {
				Map<String, Object> mapObj = inquiryLogTriageNoteServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/triage/note/inquiryLogTriageNote_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryLogTriageNoteServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/triage/note/inquiryLogTriageNote_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条问诊记录分诊记录信息
	 */
	@RequestMapping(value ="/inquiryLogTriageNote_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryLogTriageNoteServiceImp.find_Map(mapStr),"form/inquiry/log/triage/note/details/inquiryLogTriageNote_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改问诊记录分诊记录页面
	 */
	@RequestMapping(value ="/inquiryLogTriageNote_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(inquiryLogTriageNoteServiceImp.find_Map(mapStr),"form/inquiry/log/triage/note/inquiryLogTriageNote_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除问诊记录分诊记录信息操作
	 */
	@RequestMapping(value ="/inquiryLogTriageNote_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryLogTriageNoteServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

