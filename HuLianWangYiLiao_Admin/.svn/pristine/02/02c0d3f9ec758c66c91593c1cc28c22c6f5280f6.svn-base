package com.controllerAdmin.util.drug.attribute.option;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.drug.attribute.option.UtilDrugAttributeOptionService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 药品关联属性选项 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilDrugAttributeOptionController  extends ControllerUtil {

	@Resource
	private UtilDrugAttributeOptionService  utilDrugAttributeOptionServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取药品关联属性选项信息
	 */
	@RequestMapping(value ="/utilDrugAttributeOption_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilDrugAttributeOptionServiceImp.tBody(mapStr),mapStr,"form/util/drug/attribute/option/utilDrugAttributeOption_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加药品关联属性选项页面
	 */
	@RequestMapping(value ="/utilDrugAttributeOption_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/drug/attribute/option/utilDrugAttributeOption_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行药品关联属性选项修改和新增操作
	 */
	@RequestMapping(value ="/utilDrugAttributeOption_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("option_id"))) {
				Map<String, Object> mapObj = utilDrugAttributeOptionServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/drug/attribute/option/utilDrugAttributeOption_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilDrugAttributeOptionServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/drug/attribute/option/utilDrugAttributeOption_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *判断药品属性重复
	 */
	@RequestMapping(value ="/utilDrugAttributeOption_findById.do")
	public void findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			mapStr.put("find_id", req.getParameter("id"));
			mapStr.put("find_name", req.getParameter("name"));
			mapStr.put("find_type", req.getParameter("type"));
			if(UtilValiDate.isEmpty(req.getParameter("name")) && UtilValiDate.isEmpty(req.getParameter("type")) && utilDrugAttributeOptionServiceImp.find_Map(mapStr).size()>0) {
				respBack(false, resp);
			}
			respBack(true, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}

	/**
	 *打开修改药品关联属性选项页面
	 */
	@RequestMapping(value ="/utilDrugAttributeOption_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilDrugAttributeOptionServiceImp.find_Map(mapStr),"form/util/drug/attribute/option/utilDrugAttributeOption_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除药品关联属性选项信息操作
	 */
	@RequestMapping(value ="/utilDrugAttributeOption_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilDrugAttributeOptionServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

