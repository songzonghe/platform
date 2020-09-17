package com.controllerAdmin.util.medical.advice;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.medical.advice.UtilMedicalAdviceService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 常用医嘱 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilMedicalAdviceController  extends ControllerUtil {

	@Resource
	private UtilMedicalAdviceService  utilMedicalAdviceServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取常用医嘱信息
	 */
	@RequestMapping(value ="/utilMedicalAdvice_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilMedicalAdviceServiceImp.tBody(mapStr),mapStr,"form/util/medical/advice/utilMedicalAdvice_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加常用医嘱页面
	 */
	@RequestMapping(value ="/utilMedicalAdvice_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/medical/advice/utilMedicalAdvice_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行常用医嘱修改和新增操作
	 */
	@RequestMapping(value ="/utilMedicalAdvice_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("advice_id"))) {
				Map<String, Object> mapObj = utilMedicalAdviceServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/medical/advice/utilMedicalAdvice_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilMedicalAdviceServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/medical/advice/utilMedicalAdvice_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条常用医嘱信息
	 */
	@RequestMapping(value ="/utilMedicalAdvice_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilMedicalAdviceServiceImp.find_Map(mapStr),"form/util/medical/advice/details/utilMedicalAdvice_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改常用医嘱页面
	 */
	@RequestMapping(value ="/utilMedicalAdvice_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilMedicalAdviceServiceImp.find_Map(mapStr),"form/util/medical/advice/utilMedicalAdvice_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除常用医嘱信息操作
	 */
	@RequestMapping(value ="/utilMedicalAdvice_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilMedicalAdviceServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

