package com.controllerAdmin.util.questions;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.questions.UtilQuestionsService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 常见问题 controller 实现类 
 * 操作人： 张龙
 */ 
@Controller
public class UtilQuestionsController  extends ControllerUtil {

	@Resource
	private UtilQuestionsService  utilQuestionsServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取常见问题信息
	 */
	@RequestMapping(value ="/utilQuestions_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilQuestionsServiceImp.tBody(mapStr),mapStr,"form/util/questions/utilQuestions_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加常见问题页面
	 */
	@RequestMapping(value ="/utilQuestions_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/util/questions/utilQuestions_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行常见问题修改和新增操作
	 */
	@RequestMapping(value ="/utilQuestions_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("questions_id"))) {
				Map<String, Object> mapObj = utilQuestionsServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/questions/utilQuestions_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = utilQuestionsServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/questions/utilQuestions_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条常见问题信息
	 */
	@RequestMapping(value ="/utilQuestions_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(utilQuestionsServiceImp.find_Map(mapStr),"form/util/questions/details/utilQuestions_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改常见问题页面
	 */
	@RequestMapping(value ="/utilQuestions_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilQuestionsServiceImp.find_Map(mapStr),"form/util/questions/utilQuestions_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除常见问题信息操作
	 */
	@RequestMapping(value ="/utilQuestions_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilQuestionsServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

