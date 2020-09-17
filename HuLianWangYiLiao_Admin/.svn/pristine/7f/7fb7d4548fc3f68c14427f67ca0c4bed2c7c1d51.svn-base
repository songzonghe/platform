package com.controllerAdmin.util.hospital.equipment;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.hospital.equipment.UtilHospitalEquipmentService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 系统医院设备 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilHospitalEquipmentController  extends ControllerUtil {

	@Resource
	private UtilHospitalEquipmentService  utilHospitalEquipmentServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取系统医院设备信息
	 */
	@RequestMapping(value ="/utilHospitalEquipment_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilHospitalEquipmentServiceImp.tBody(mapStr),mapStr,"form/util/hospital/equipment/utilHospitalEquipment_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加系统医院设备页面
	 */
	@RequestMapping(value ="/utilHospitalEquipment_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/hospital/equipment/utilHospitalEquipment_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行系统医院设备修改和新增操作
	 */
	@RequestMapping(value ="/utilHospitalEquipment_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("equipment_id"))) {
				Map<String, Object> mapObj = utilHospitalEquipmentServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/hospital/equipment/utilHospitalEquipment_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilHospitalEquipmentServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/hospital/equipment/utilHospitalEquipment_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条系统医院设备信息
	 */
	@RequestMapping(value ="/utilHospitalEquipment_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilHospitalEquipmentServiceImp.find_Map(mapStr),"form/util/hospital/equipment/details/utilHospitalEquipment_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改系统医院设备页面
	 */
	@RequestMapping(value ="/utilHospitalEquipment_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilHospitalEquipmentServiceImp.find_Map(mapStr),"form/util/hospital/equipment/utilHospitalEquipment_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除系统医院设备信息操作
	 */
	@RequestMapping(value ="/utilHospitalEquipment_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilHospitalEquipmentServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

