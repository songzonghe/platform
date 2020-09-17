package com.controllerAdmin.util.notice;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.user.info.UserInfoService;
import com.servicesAdmin.util.notice.UtilNoticeService;
import com.util.UtilJson;
/**
 * 系统消息 controller 实现类 
 * 操作人： 曾晓
 */ 
@Controller
public class UtilNoticeController  extends ControllerUtil {

	@Resource
	private UtilNoticeService  utilNoticeServiceImp;
	@Resource
	private UserInfoService  userInfoService;
	

	/************************系统生成方法开始******************************/

	/**
	 *分页获取系统消息信息
	 */
	@RequestMapping(value ="/utilNotice_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilNoticeServiceImp.tBody(mapStr),mapStr,"form/util/notice/utilNotice_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加系统消息页面
	 */
	@RequestMapping(value ="/utilNotice_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.returnPage("form/util/notice/user_notice_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 * 发送信息
	 */
	@RequestMapping(value ="/userNotice_addData.do")
	public void updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			String bool = utilNoticeServiceImp.add_Data(mapStr);
			this.respBack(bool, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	/**
	 * 删除消息
	 */
	@RequestMapping(value ="/userNotice_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilNoticeServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}

	/************************系统生成方法完毕******************************/
	/**
	 * 跳转选择用户页面
	 * @return
	 */
	@RequestMapping(value = "/userNotice_mainPage.do")
	public String mainTeamPage(HttpServletRequest req,HttpServletResponse resp){
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("info", mapStr);
			return this.returnPage("form/util/notice/mainPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		    return this.returnError();
	}
	
	/**
	 * 查询用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userNotice_getUsersData.do")
	public String getUsersData(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("info", mapStr);
			return this.tBodyUtil(utilNoticeServiceImp.userList(mapStr),mapStr,"form/util/notice/mainTbody.jsp",req,resp);	
		} catch (Exception e) {
			this.errorResp(e, resp);
		}
		return this.returnError();
	}

	/************************系统生成方法完毕******************************/
	

}

