package com.controllerAdmin.util.occupation;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.occupation.UtilOccupationService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 职业 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilOccupationController  extends ControllerUtil {

	@Resource
	private UtilOccupationService  utilOccupationServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取职业信息
	 */
	@RequestMapping(value ="/utilOccupation_indexs.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilOccupationServiceImp.tBody(mapStr),mapStr,"form/util/occupation/utilOccupation_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加职业页面
	 */
	@RequestMapping(value ="/utilOccupation_addPages.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/occupation/utilOccupation_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行职业修改和新增操作
	 */
	@RequestMapping(value ="/utilOccupation_updateDatas.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("occupation_id"))) {
				Map<String, Object> mapObj = utilOccupationServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/occupation/utilOccupation_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilOccupationServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/occupation/utilOccupation_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条职业信息
	 */
	@RequestMapping(value ="/utilOccupation_findByIds.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilOccupationServiceImp.find_Map(mapStr),"form/util/occupation/details/utilOccupation_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改职业页面
	 */
	@RequestMapping(value ="/utilOccupation_editPages.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilOccupationServiceImp.find_Map(mapStr),"form/util/occupation/utilOccupation_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除职业信息操作
	 */
	@RequestMapping(value ="/utilOccupation_deleteDatas.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilOccupationServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

