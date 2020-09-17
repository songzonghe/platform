package com.controllerAdmin.admin.notice;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.admin.notice.AdminNoticeService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 平台消息 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class AdminNoticeController  extends ControllerUtil {

	@Resource
	private AdminNoticeService  adminNoticeServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取平台消息信息
	 */
	@RequestMapping(value ="/adminNotice_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(adminNoticeServiceImp.tBody(mapStr),mapStr,"form/admin/notice/adminNotice_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加平台消息页面
	 */
	@RequestMapping(value ="/adminNotice_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/admin/notice/adminNotice_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行平台消息修改和新增操作
	 */
	@RequestMapping(value ="/adminNotice_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("notice_id"))) {
				Map<String, Object> mapObj = adminNoticeServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/admin/notice/adminNotice_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = adminNoticeServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/admin/notice/adminNotice_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条平台消息信息
	 */
	@RequestMapping(value ="/adminNotice_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(adminNoticeServiceImp.find_Map(mapStr),"form/admin/notice/details/adminNotice_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改平台消息页面
	 */
	@RequestMapping(value ="/adminNotice_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(adminNoticeServiceImp.find_Map(mapStr),"form/admin/notice/adminNotice_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除平台消息信息操作
	 */
	@RequestMapping(value ="/adminNotice_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			adminNoticeServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

