package com.controllerAdmin.inquiry.log.health.guidance;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.inquiry.log.health.guidance.InquiryLogHealthGuidanceService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊记录健康指导 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class InquiryLogHealthGuidanceController  extends ControllerUtil {

	@Resource
	private InquiryLogHealthGuidanceService  inquiryLogHealthGuidanceServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取问诊记录健康指导信息
	 */
	@RequestMapping(value ="/inquiryLogHealthGuidance_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryLogHealthGuidanceServiceImp.tBody(mapStr),mapStr,"form/inquiry/log/health/guidance/inquiryLogHealthGuidance_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加问诊记录健康指导页面
	 */
	@RequestMapping(value ="/inquiryLogHealthGuidance_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/inquiry/log/health/guidance/inquiryLogHealthGuidance_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行问诊记录健康指导修改和新增操作
	 */
	@RequestMapping(value ="/inquiryLogHealthGuidance_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("guidance_id"))) {
				Map<String, Object> mapObj = inquiryLogHealthGuidanceServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/health/guidance/inquiryLogHealthGuidance_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryLogHealthGuidanceServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/health/guidance/inquiryLogHealthGuidance_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条问诊记录健康指导信息
	 */
	@RequestMapping(value ="/inquiryLogHealthGuidance_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryLogHealthGuidanceServiceImp.find_Map(mapStr),"form/inquiry/log/health/guidance/details/inquiryLogHealthGuidance_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改问诊记录健康指导页面
	 */
	@RequestMapping(value ="/inquiryLogHealthGuidance_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(inquiryLogHealthGuidanceServiceImp.find_Map(mapStr),"form/inquiry/log/health/guidance/inquiryLogHealthGuidance_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除问诊记录健康指导信息操作
	 */
	@RequestMapping(value ="/inquiryLogHealthGuidance_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryLogHealthGuidanceServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

