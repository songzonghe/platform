package com.controllerAdmin.util.icd;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.icd.UtilIcdService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 国际疾病分类 controller 实现类 
 * 操作人： 苏洪伟
 */ 
@Controller
public class UtilIcdController  extends ControllerUtil {

	@Resource
	private UtilIcdService  utilIcdServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取国际疾病分类信息
	 */
	@RequestMapping(value ="/utilIcd_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilIcdServiceImp.tBody(mapStr),mapStr,"form/util/icd/utilIcd_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加国际疾病分类页面
	 */
	@RequestMapping(value ="/utilIcd_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/icd/utilIcd_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行国际疾病分类修改和新增操作
	 */
	@RequestMapping(value ="/utilIcd_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("icd_id"))) {
				Map<String, Object> mapObj = utilIcdServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/icd/utilIcd_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilIcdServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/icd/utilIcd_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条国际疾病分类信息
	 */
	@RequestMapping(value ="/utilIcd_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilIcdServiceImp.find_Map(mapStr),"form/util/icd/details/utilIcd_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改国际疾病分类页面
	 */
	@RequestMapping(value ="/utilIcd_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilIcdServiceImp.find_Map(mapStr),"form/util/icd/utilIcd_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除国际疾病分类信息操作
	 */
	@RequestMapping(value ="/utilIcd_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilIcdServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

