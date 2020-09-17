package com.controllerAdmin.util.dictionaries.data;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.dictionaries.data.UtilDictionariesDataService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 字典数据 controller 实现类 
 * 操作人： 张龙
 */ 
@Controller
public class UtilDictionariesDataController  extends ControllerUtil {

	@Resource
	private UtilDictionariesDataService  utilDictionariesDataServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取字典数据信息
	 */
	@RequestMapping(value ="/utilDictionariesData_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if("openIframe".equals(mapStr.get("openType"))){
				req.setAttribute("map", mapStr);
				return returnPage("form/util/dictionaries/type/detailsPage.jsp", req, resp);
			}
			mapStr.put("dictionaries_type_id", req.getParameter("id"));
			return this.tBodyUtil(utilDictionariesDataServiceImp.tBody(mapStr),mapStr,"form/util/dictionaries/data/utilDictionariesData_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加字典数据页面
	 */
	@RequestMapping(value ="/utilDictionariesData_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("info", mapStr);
			return this.returnPage("form/util/dictionaries/data/utilDictionariesData_addPage.jsp",req,resp);
		} catch (Exception e){
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行字典数据修改和新增操作
	 */
	@RequestMapping(value ="/utilDictionariesData_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("dictionaries_data_id"))){
				Map<String, Object> mapObj = utilDictionariesDataServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/dictionaries/data/utilDictionariesData_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilDictionariesDataServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/dictionaries/data/utilDictionariesData_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *根据类型编号获取数据
	 */
	@RequestMapping(value ="/utilDictionariesData_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilDictionariesDataServiceImp.find_Map(mapStr),"form/util/dictionaries/data/details/utilDictionariesData_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改字典数据页面
	 */
	@RequestMapping(value ="/utilDictionariesData_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilDictionariesDataServiceImp.find_Map(mapStr),"form/util/dictionaries/data/utilDictionariesData_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除字典数据信息操作
	 */
	@RequestMapping(value ="/utilDictionariesData_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilDictionariesDataServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

