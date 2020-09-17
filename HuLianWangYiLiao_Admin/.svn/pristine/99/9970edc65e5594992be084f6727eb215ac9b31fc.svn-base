package com.controllerAdmin.util.batch.number;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.batch.number.UtilBatchNumberService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 批号 controller 实现类 
 * 操作人： 刘杰
 */ 
@Controller
public class UtilBatchNumberController  extends ControllerUtil {

	@Resource
	private UtilBatchNumberService  utilBatchNumberServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取批号信息
	 */
	@RequestMapping(value ="/utilBatchNumber_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilBatchNumberServiceImp.tBody(mapStr),mapStr,"form/util/batch/number/utilBatchNumber_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加批号页面
	 */
	@RequestMapping(value ="/utilBatchNumber_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/batch/number/utilBatchNumber_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行批号修改和新增操作
	 */
	@RequestMapping(value ="/utilBatchNumber_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("log_id"))) {
				Map<String, Object> mapObj = utilBatchNumberServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/batch/number/utilBatchNumber_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilBatchNumberServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/batch/number/utilBatchNumber_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条批号信息
	 */
	@RequestMapping(value ="/utilBatchNumber_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilBatchNumberServiceImp.find_Map(mapStr),"form/util/batch/number/details/utilBatchNumber_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改批号页面
	 */
	@RequestMapping(value ="/utilBatchNumber_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilBatchNumberServiceImp.find_Map(mapStr),"form/util/batch/number/utilBatchNumber_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除批号信息操作
	 */
	@RequestMapping(value ="/utilBatchNumber_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilBatchNumberServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

