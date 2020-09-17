package com.controllerAdmin.util.diagnosis;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.diagnosis.UtilDiagnosisService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 诊段模板以及规范 controller 实现类 
 * 操作人： 苏洪伟
 */ 
@Controller
public class UtilDiagnosisController  extends ControllerUtil {

	@Resource
	private UtilDiagnosisService  utilDiagnosisServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取诊段模板以及规范信息
	 */
	@RequestMapping(value ="/utilDiagnosis_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilDiagnosisServiceImp.tBody(mapStr),mapStr,"form/util/diagnosis/utilDiagnosis_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加诊段模板以及规范页面
	 */
	@RequestMapping(value ="/utilDiagnosis_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setAttribute("listIcdDoctor", utilDiagnosisServiceImp.getParamListMap());
			return this.returnPage("form/util/diagnosis/utilDiagnosis_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行诊段模板以及规范修改和新增操作
	 */
	@RequestMapping(value ="/utilDiagnosis_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("diagnosis_id"))) {
				Map<String, Object> mapObj = utilDiagnosisServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/diagnosis/utilDiagnosis_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilDiagnosisServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/diagnosis/utilDiagnosis_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条诊段模板以及规范信息
	 */
	@RequestMapping(value ="/utilDiagnosis_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilDiagnosisServiceImp.find_Map(mapStr),"form/util/diagnosis/details/utilDiagnosis_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改诊段模板以及规范页面
	 */
	@RequestMapping(value ="/utilDiagnosis_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("listIcdDoctor", utilDiagnosisServiceImp.getParamListMap());
			return this.editPageUtil(utilDiagnosisServiceImp.find_Map(mapStr),"form/util/diagnosis/utilDiagnosis_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除诊段模板以及规范信息操作
	 */
	@RequestMapping(value ="/utilDiagnosis_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilDiagnosisServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

