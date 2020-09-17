package com.controllerAdmin.user.info;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.user.info.UserInfoService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 用户基本资料 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UserInfoController  extends ControllerUtil {

	@Resource
	private UserInfoService  userInfoServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取用户基本资料信息
	 */
	@RequestMapping(value ="/userInfo_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(userInfoServiceImp.tBody(mapStr),mapStr,"form/user/info/userInfo_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加用户基本资料页面
	 */
	@RequestMapping(value ="/userInfo_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/user/info/userInfo_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行用户基本资料修改和新增操作
	 */
	@RequestMapping(value ="/userInfo_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("user_id"))) {
				Map<String, Object> mapObj = userInfoServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/user/info/userInfo_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = userInfoServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/user/info/userInfo_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *获取一条用户基本资料信息
	 */
	@RequestMapping(value ="/userInfo_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.findByIdUtil(userInfoServiceImp.find_Map(mapStr),"form/user/info/details/userInfo_details.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改用户基本资料页面
	 */
	@RequestMapping(value ="/userInfo_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			String url = "form/user/info/userInfo_editPage.jsp";
			if("2".equals(mapStr.get("type"))) {
				url="form/user/info/userInfo_editPaw.jsp";
			}
			return this.editPageUtil(userInfoServiceImp.find_Map(mapStr),url,req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除用户基本资料信息操作
	 */
	@RequestMapping(value ="/userInfo_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			userInfoServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
}

