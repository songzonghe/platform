package com.controllerAdmin.inquiry.log.img;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.inquiry.log.img.InquiryLogImgService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊记录上传图片 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class InquiryLogImgController  extends ControllerUtil {

	@Resource
	private InquiryLogImgService  inquiryLogImgServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取问诊记录上传图片信息
	 */
	@RequestMapping(value ="/inquiryLogImg_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(inquiryLogImgServiceImp.tBody(mapStr),mapStr,"form/inquiry/log/img/inquiryLogImg_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加问诊记录上传图片页面
	 */
	@RequestMapping(value ="/inquiryLogImg_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/inquiry/log/img/inquiryLogImg_addPages.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行问诊记录上传图片修改和新增操作
	 */
	@RequestMapping(value ="/inquiryLogImg_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("img_id"))) {
				Map<String, Object> mapObj = inquiryLogImgServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/img/inquiryLogImg_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = inquiryLogImgServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/inquiry/log/img/inquiryLogImg_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条问诊记录上传图片信息
	 */
	@RequestMapping(value ="/inquiryLogImg_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(inquiryLogImgServiceImp.find_Map(mapStr),"form/inquiry/log/img/details/inquiryLogImg_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改问诊记录上传图片页面
	 */
	@RequestMapping(value ="/inquiryLogImg_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(inquiryLogImgServiceImp.find_Map(mapStr),"form/inquiry/log/img/inquiryLogImg_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除问诊记录上传图片信息操作
	 */
	@RequestMapping(value ="/inquiryLogImg_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			inquiryLogImgServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

