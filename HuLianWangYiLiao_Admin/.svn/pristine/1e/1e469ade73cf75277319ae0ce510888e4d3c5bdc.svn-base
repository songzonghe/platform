package com.controllerAdmin.store.info;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.store.info.StoreInfoService;
import com.servicesAdmin.util.dictionaries.data.UtilDictionariesDataService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 门店基本资料 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class StoreInfoController  extends ControllerUtil {

	@Resource
	private StoreInfoService  storeInfoServiceImp;
	@Resource
	private UtilDictionariesDataService  utilDictionariesDataServiceImp;
	/************************系统生成方法开始******************************/

	/**
	 *分页获取门店基本资料信息
	 */
	@RequestMapping(value ="/storeInfo_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(storeInfoServiceImp.tBody(mapStr),mapStr,"form/store/info/storeInfo_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加门店基本资料页面
	 */
	@RequestMapping(value ="/storeInfo_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("allList", utilDictionariesDataServiceImp.findAllData(mapStr.get("getStr")));
			return this.returnPage("form/store/info/storeInfo_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行门店基本资料修改和新增操作
	 */
	@RequestMapping(value ="/storeInfo_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("store_id"))) {
				Map<String, Object> mapObj = storeInfoServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/store/info/storeInfo_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = storeInfoServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/store/info/storeInfo_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条门店基本资料信息
	 */
	@RequestMapping(value ="/storeInfo_findById.do")
	public void findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			mapStr.put("find_store_phone", req.getParameter("store_phone"));
			if(UtilValiDate.isEmpty(mapStr.get("find_store_phone")) && storeInfoServiceImp.find_Map(mapStr).size()>0) {
				respBack(false, resp);
			}
			respBack(true, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}

	/**
	 *打开修改门店基本资料页面
	 */
	@RequestMapping(value ="/storeInfo_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			String url = "form/store/info/storeInfo_editPage.jsp";
			if("2".equals(mapStr.get("type"))) {
				url="form/store/info/storeInfo_editPaw.jsp";
			}
			req.setAttribute("allList", utilDictionariesDataServiceImp.findAllData(mapStr.get("getStr")));
			return this.editPageUtil(storeInfoServiceImp.find_Map(mapStr),url,req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除门店基本资料信息操作
	 */
	@RequestMapping(value ="/storeInfo_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			storeInfoServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

