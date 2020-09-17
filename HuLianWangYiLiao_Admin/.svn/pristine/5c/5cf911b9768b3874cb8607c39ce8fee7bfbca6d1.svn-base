package com.controllerAdmin.util.drug.drugClass;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.drug.drugClass.UtilDrugClassService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 药品分类 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilDrugClassController  extends ControllerUtil {

	@Resource
	private UtilDrugClassService  utilDrugClassServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取药品分类信息
	 */
	@RequestMapping(value ="/utilDrugClass_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilDrugClassServiceImp.tBody(mapStr),mapStr,"form/util/drug/drugClass/utilDrugClass_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加药品分类页面
	 */
	@RequestMapping(value ="/utilDrugClass_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/drug/drugClass/utilDrugClass_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行药品分类修改和新增操作
	 */
	@RequestMapping(value ="/utilDrugClass_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("class_id"))) {
				Map<String, Object> mapObj = utilDrugClassServiceImp.update_Data(mapStr);
				mapObj.put("imgIsOpne", mapStr.get("imgIsOpne"));
				mapObj.put("imgSrc", mapStr.get("imgSrc"));
				mapObj.put("trIsOpen", mapStr.get("trIsOpen"));
				return this.updateDataUpdate(mapObj,"form/util/drug/drugClass/utilDrugClass_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilDrugClassServiceImp.add_Data(mapStr);
				mapObj.put("imgIsOpne", mapStr.get("imgIsOpne"));
				mapObj.put("imgSrc", mapStr.get("imgSrc"));
				mapObj.put("trIsOpen", mapStr.get("trIsOpen"));
				return this.updateDataUpdate(mapObj,"form/util/drug/drugClass/utilDrugClass_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条药品分类信息
	 */
	@RequestMapping(value ="/utilDrugClass_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilDrugClassServiceImp.find_Map(mapStr),"form/util/drug/drugClass/details/utilDrugClass_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改药品分类页面
	 */
	@RequestMapping(value ="/utilDrugClass_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilDrugClassServiceImp.find_Map(mapStr),"form/util/drug/drugClass/utilDrugClass_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除药品分类信息操作
	 */
	@RequestMapping(value ="/utilDrugClass_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilDrugClassServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

