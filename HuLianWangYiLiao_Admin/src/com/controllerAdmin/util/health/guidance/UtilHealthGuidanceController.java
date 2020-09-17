package com.controllerAdmin.util.health.guidance;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.diagnosis.UtilDiagnosisService;
import com.servicesAdmin.util.health.guidance.UtilHealthGuidanceService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 健康指导模板 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilHealthGuidanceController  extends ControllerUtil {

	@Resource
	private UtilHealthGuidanceService  utilHealthGuidanceServiceImp;
	@Resource
	private UtilDiagnosisService  utilDiagnosisServiceImp;
	
	/************************系统生成方法开始******************************/

	/**
	 *分页获取健康指导模板信息
	 */
	@RequestMapping(value ="/utilHealthGuidance_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilHealthGuidanceServiceImp.tBody(mapStr),mapStr,"form/util/health/guidance/utilHealthGuidance_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加健康指导模板页面
	 */
	@RequestMapping(value ="/utilHealthGuidance_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setAttribute("listIcdDoctor", utilDiagnosisServiceImp.getParamListMap());
			return this.returnPage("form/util/health/guidance/utilHealthGuidance_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行健康指导模板修改和新增操作
	 */
	@RequestMapping(value ="/utilHealthGuidance_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("guidance_id"))) {
				Map<String, Object> mapObj = utilHealthGuidanceServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/health/guidance/utilHealthGuidance_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilHealthGuidanceServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/health/guidance/utilHealthGuidance_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条健康指导模板信息
	 */
	@RequestMapping(value ="/utilHealthGuidance_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilHealthGuidanceServiceImp.find_Map(mapStr),"form/util/health/guidance/details/utilHealthGuidance_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改健康指导模板页面
	 */
	@RequestMapping(value ="/utilHealthGuidance_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("listIcdDoctor", utilDiagnosisServiceImp.getParamListMap());
			return this.editPageUtil(utilHealthGuidanceServiceImp.find_Map(mapStr),"form/util/health/guidance/utilHealthGuidance_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除健康指导模板信息操作
	 */
	@RequestMapping(value ="/utilHealthGuidance_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilHealthGuidanceServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

