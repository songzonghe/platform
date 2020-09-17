package com.controllerAdmin.util.drug;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controllerAdmin.ControllerUtil;
import com.custom.interceptor.AccessRequired;
import com.servicesAdmin.util.drug.UtilDrugService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 药品信息 controller 实现类 
 * 操作人： 刘杰
 */ 
@Controller
public class UtilDrugController  extends ControllerUtil {

	@Resource
	private UtilDrugService  utilDrugServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取药品信息信息
	 */
	@RequestMapping(value ="/utilDrug_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilDrugServiceImp.tBody(mapStr),mapStr,"form/util/drug/utilDrug_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加药品信息页面
	 */
	@RequestMapping(value ="/utilDrug_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			//频率list
			req.setAttribute("frequencyList", utilDrugServiceImp.frequencyList(mapStr));
			//最小单位
			mapStr.put("option_type", "1");
			req.setAttribute("smallestList", utilDrugServiceImp.optionTypeList(mapStr));
			//包装单位
			mapStr.put("option_type", "2");
			req.setAttribute("packagingList", utilDrugServiceImp.optionTypeList(mapStr));
			//重量单位
			mapStr.put("option_type", "3");
			req.setAttribute("weightList", utilDrugServiceImp.optionTypeList(mapStr));
			//体积单位
			mapStr.put("option_type", "4");
			req.setAttribute("volumeList", utilDrugServiceImp.optionTypeList(mapStr));
			req.setAttribute("classList", utilDrugServiceImp.classList(mapStr));
			req.setAttribute("companyList", utilDrugServiceImp.companyList(mapStr));
			req.setAttribute("numberList", utilDrugServiceImp.numberList(mapStr));
			req.setAttribute("agenList", utilDrugServiceImp.agenList(mapStr));
			return this.returnPage("form/util/drug/utilDrug_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	
	

	/**
	 *进行药品信息修改和新增操作
	 */
	@RequestMapping(value ="/utilDrug_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("drug_id"))) {
				Map<String, Object> mapObj = utilDrugServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/drug/utilDrug_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilDrugServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/drug/utilDrug_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条药品信息信息
	 */
	@RequestMapping(value ="/utilDrug_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilDrugServiceImp.find_Map(mapStr),"form/util/drug/details/utilDrug_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改药品信息页面
	 */
	@RequestMapping(value ="/utilDrug_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			Map<String, Object> map=utilDrugServiceImp.find_Map(mapStr);
			req.setAttribute("map", mapStr);
			//频率list
			req.setAttribute("frequencyList", utilDrugServiceImp.frequencyList(mapStr));
			//最小单位
			mapStr.put("option_type", "1");
			req.setAttribute("smallestList", utilDrugServiceImp.optionTypeList(mapStr));
			//包装单位
			mapStr.put("option_type", "2");
			req.setAttribute("packagingList", utilDrugServiceImp.optionTypeList(mapStr));
			//重量单位
			mapStr.put("option_type", "3");
			req.setAttribute("weightList", utilDrugServiceImp.optionTypeList(mapStr));
			//体积单位
			mapStr.put("option_type", "4");
			req.setAttribute("volumeList", utilDrugServiceImp.optionTypeList(mapStr));
			req.setAttribute("classList", utilDrugServiceImp.classList(mapStr));
			req.setAttribute("usageList", utilDrugServiceImp.usageList(mapStr));
			req.setAttribute("companyList", utilDrugServiceImp.companyList(mapStr));
			req.setAttribute("numberList", utilDrugServiceImp.numberList(mapStr));
			req.setAttribute("agenList", utilDrugServiceImp.agenList(mapStr));
			return this.editPageUtil(map,"form/util/drug/utilDrug_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除药品信息信息操作
	 */
	@RequestMapping(value ="/utilDrug_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilDrugServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}
	
	
	/**
	 *得到用法
	 */
	@RequestMapping(value ="/utilDrug_up_list.do")
	public void getDrug_up_list(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			this.respBack(utilDrugServiceImp.class_up_list(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}

	/************************系统生成方法完毕******************************/
	
}

