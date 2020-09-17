package com.controllerAdmin.util.icon;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.icon.UtilIconService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * app功能图标 controller 实现类 
 * 操作人： 张龙
 */ 
@Controller
public class UtilIconController  extends ControllerUtil {

	@Resource
	private UtilIconService  utilIconServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取app功能图标信息
	 */
	@RequestMapping(value ="/utilIcon_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilIconServiceImp.tBody(mapStr),mapStr,"form/util/icon/utilIcon_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加app功能图标页面
	 */
	@RequestMapping(value ="/utilIcon_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/icon/utilIcon_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行app功能图标修改和新增操作
	 */
	@RequestMapping(value ="/utilIcon_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("icon_id"))) {
				Map<String, Object> mapObj = utilIconServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/icon/utilIcon_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilIconServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/icon/utilIcon_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条app功能图标信息
	 */
	@RequestMapping(value ="/utilIcon_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilIconServiceImp.find_Map(mapStr),"form/util/icon/details/utilIcon_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改app功能图标页面
	 */
	@RequestMapping(value ="/utilIcon_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilIconServiceImp.find_Map(mapStr),"form/util/icon/utilIcon_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除app功能图标信息操作
	 */
	@RequestMapping(value ="/utilIcon_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilIconServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

