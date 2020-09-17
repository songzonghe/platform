package com.controllerAdmin.util.dictionaries.type;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.dictionaries.type.UtilDictionariesTypeService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 字典表类型 controller 实现类 
 * 操作人： 张龙
 */ 
@Controller
public class UtilDictionariesTypeController  extends ControllerUtil {

	@Resource
	private UtilDictionariesTypeService  utilDictionariesTypeServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取字典表类型信息
	 */
	@RequestMapping(value ="/utilDictionariesType_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilDictionariesTypeServiceImp.tBody(mapStr),mapStr,"form/util/dictionaries/type/utilDictionariesType_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加字典表类型页面
	 */
	@RequestMapping(value ="/utilDictionariesType_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("info", mapStr);
			return this.returnPage("form/util/dictionaries/type/utilDictionariesType_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行字典表类型修改和新增操作
	 */
	@RequestMapping(value ="/utilDictionariesType_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("dictionaries_type_id"))) {
				Map<String, Object> mapObj = utilDictionariesTypeServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/dictionaries/type/utilDictionariesType_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilDictionariesTypeServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/dictionaries/type/utilDictionariesType_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条字典表类型信息
	 */
	@RequestMapping(value ="/utilDictionariesType_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilDictionariesTypeServiceImp.find_Map(mapStr),"form/util/dictionaries/type/details/utilDictionariesType_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改字典表类型页面
	 */
	@RequestMapping(value ="/utilDictionariesType_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilDictionariesTypeServiceImp.find_Map(mapStr),"form/util/dictionaries/type/utilDictionariesType_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除字典表类型信息操作
	 */
	@RequestMapping(value ="/utilDictionariesType_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilDictionariesTypeServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

