package com.controllerAdmin.util.drug.frequency;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.drug.frequency.UtilDrugFrequencyService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 药品使用频率 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilDrugFrequencyController  extends ControllerUtil {

	@Resource
	private UtilDrugFrequencyService  utilDrugFrequencyServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取药品使用频率信息
	 */
	@RequestMapping(value ="/utilDrugFrequency_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilDrugFrequencyServiceImp.tBody(mapStr),mapStr,"form/util/drug/frequency/utilDrugFrequency_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加药品使用频率页面
	 */
	@RequestMapping(value ="/utilDrugFrequency_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/drug/frequency/utilDrugFrequency_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行药品使用频率修改和新增操作
	 */
	@RequestMapping(value ="/utilDrugFrequency_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("frequency_id"))) {
				Map<String, Object> mapObj = utilDrugFrequencyServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/drug/frequency/utilDrugFrequency_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilDrugFrequencyServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/drug/frequency/utilDrugFrequency_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条药品使用频率信息
	 */
	@RequestMapping(value ="/utilDrugFrequency_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilDrugFrequencyServiceImp.find_Map(mapStr),"form/util/drug/frequency/details/utilDrugFrequency_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改药品使用频率页面
	 */
	@RequestMapping(value ="/utilDrugFrequency_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilDrugFrequencyServiceImp.find_Map(mapStr),"form/util/drug/frequency/utilDrugFrequency_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除药品使用频率信息操作
	 */
	@RequestMapping(value ="/utilDrugFrequency_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilDrugFrequencyServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

