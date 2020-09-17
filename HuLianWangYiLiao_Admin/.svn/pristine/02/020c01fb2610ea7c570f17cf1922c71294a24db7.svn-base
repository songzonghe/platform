package com.controllerAdmin.util.specification;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.specification.UtilSpecificationService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 问诊规范 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilSpecificationController  extends ControllerUtil {

	@Resource
	private UtilSpecificationService  utilSpecificationServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取问诊规范信息
	 */
	@RequestMapping(value ="/utilSpecification_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilSpecificationServiceImp.tBody(mapStr),mapStr,"form/util/specification/utilSpecification_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加问诊规范页面
	 */
	@RequestMapping(value ="/utilSpecification_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/specification/utilSpecification_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行问诊规范修改和新增操作
	 */
	@RequestMapping(value ="/utilSpecification_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("specification_id"))) {
				Map<String, Object> mapObj = utilSpecificationServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/specification/utilSpecification_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilSpecificationServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/specification/utilSpecification_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条问诊规范信息
	 */
	@RequestMapping(value ="/utilSpecification_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilSpecificationServiceImp.find_Map(mapStr),"form/util/specification/details/utilSpecification_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改问诊规范页面
	 */
	@RequestMapping(value ="/utilSpecification_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilSpecificationServiceImp.find_Map(mapStr),"form/util/specification/utilSpecification_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除问诊规范信息操作
	 */
	@RequestMapping(value ="/utilSpecification_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilSpecificationServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

