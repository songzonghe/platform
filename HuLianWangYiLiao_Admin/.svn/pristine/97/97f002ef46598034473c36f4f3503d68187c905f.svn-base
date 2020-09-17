package com.controllerAdmin.doctor.scheduling;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.doctor.scheduling.DoctorSchedulingService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 医生排班 controller 实现类 
 * 操作人： 张龙
 */ 
@Controller
public class DoctorSchedulingController  extends ControllerUtil {

	@Resource
	private DoctorSchedulingService  doctorSchedulingServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取医生排班信息
	 */
	@RequestMapping(value ="/doctorScheduling_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("doctorList", doctorSchedulingServiceImp.findDoctor(mapStr));
			req.setAttribute("listMap", UtilJson.listToJson(doctorSchedulingServiceImp.tBody(mapStr)));
			return this.returnPage("form/doctor/scheduling/doctorScheduling_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	/**
	 *分页获取医生排班信息
	 */
	@RequestMapping(value ="/doctorScheduling_findData.do")
	public String findData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("info", mapStr);
			if("open".equals(mapStr.get("pageType"))) {
				return returnPage("form/doctor/scheduling/details/detailsPage.jsp", req, resp);
			}
			return this.tBodyUtil(doctorSchedulingServiceImp.tBody(mapStr), mapStr, "form/doctor/scheduling/details/detailsBody.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加医生排班页面
	 */
	@RequestMapping(value ="/doctorScheduling_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("doctorList", doctorSchedulingServiceImp.findDoctor(mapStr));
			return this.returnPage("form/doctor/scheduling/doctorScheduling_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行医生排班修改和新增操作
	 */
	@RequestMapping(value ="/doctorScheduling_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("scheduling_id"))) {
				Map<String, Object> mapObj = doctorSchedulingServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/doctor/scheduling/doctorScheduling_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = doctorSchedulingServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/doctor/scheduling/doctorScheduling_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条医生排班信息
	 */
	@RequestMapping(value ="/doctorScheduling_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("doctorList", doctorSchedulingServiceImp.findDoctor(mapStr));
			return this.findByIdUtil(doctorSchedulingServiceImp.find_Map(mapStr),"form/doctor/scheduling/details/doctorScheduling_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改医生排班页面
	 */
	@RequestMapping(value ="/doctorScheduling_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(doctorSchedulingServiceImp.find_Map(mapStr),"form/doctor/scheduling/doctorScheduling_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除医生排班信息操作
	 */
	@RequestMapping(value ="/doctorScheduling_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			doctorSchedulingServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

