package com.controllerAdmin.util.doctor.title;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.doctor.title.UtilDoctorTitleService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 医生职称字典 controller 实现类 
 * 操作人： 张龙
 */ 
@Controller
public class UtilDoctorTitleController  extends ControllerUtil {

	@Resource
	private UtilDoctorTitleService  utilDoctorTitleServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取医生职称字典信息
	 */
	@RequestMapping(value ="/utilDoctorTitle_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilDoctorTitleServiceImp.tBody(mapStr),mapStr,"form/util/doctor/title/utilDoctorTitle_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加医生职称字典页面
	 */
	@RequestMapping(value ="/utilDoctorTitle_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/doctor/title/utilDoctorTitle_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行医生职称字典修改和新增操作
	 */
	@RequestMapping(value ="/utilDoctorTitle_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("title_id"))) {
				Map<String, Object> mapObj = utilDoctorTitleServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/doctor/title/utilDoctorTitle_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilDoctorTitleServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/doctor/title/utilDoctorTitle_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条医生职称字典信息
	 */
	@RequestMapping(value ="/utilDoctorTitle_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilDoctorTitleServiceImp.find_Map(mapStr),"form/util/doctor/title/details/utilDoctorTitle_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改医生职称字典页面
	 */
	@RequestMapping(value ="/utilDoctorTitle_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilDoctorTitleServiceImp.find_Map(mapStr),"form/util/doctor/title/utilDoctorTitle_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除医生职称字典信息操作
	 */
	@RequestMapping(value ="/utilDoctorTitle_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilDoctorTitleServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

