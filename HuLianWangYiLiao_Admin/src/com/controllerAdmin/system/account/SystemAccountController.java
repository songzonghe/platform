package com.controllerAdmin.system.account;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.system.account.SystemAccountService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 账户 controller 实现类 
 * 操作人： 张龙
 */ 
@Controller
public class SystemAccountController  extends ControllerUtil{
	@Resource
	private SystemAccountService  systemAccountServiceImp;
	/**
	 *分页获取账户信息
	 */
	@RequestMapping(value ="/systemAccount_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) { 
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(systemAccountServiceImp.tBody(mapStr),mapStr,"form/system/account/systemAccount_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加账户页面
	 */
	@RequestMapping(value ="/systemAccount_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			return this.returnPage("form/system/account/systemAccount_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行账户修改和新增操作
	 */
	@RequestMapping(value ="/systemAccount_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("account_id"))) {
				Map<String, Object> mapObj = systemAccountServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/system/account/systemAccount_tr.jsp",req,resp);
			} else { 
				Map<String, Object> mapObj = systemAccountServiceImp.add_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/system/account/systemAccount_tr.jsp",req,resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	/**
	 *打开修改账户页面
	 */
	@RequestMapping(value ="/systemAccount_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("info", mapStr);
			return this.editPageUtil(systemAccountServiceImp.find_Map(mapStr),"form/system/account/systemAccount_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除账户信息操作
	 */
	@RequestMapping(value ="/systemAccount_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			systemAccountServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	/**
	 *判断账号是否存在
	 */
	@RequestMapping(value ="/systemAccount_isExistName.do")
	public void isExistName(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			String account_number = req.getParameter("account_number");
			if("admin".equals(account_number)){
				 this.respBack(false, resp);
			}
			mapStr.put("find_account_number", account_number);
			Map<String, Object>map=systemAccountServiceImp.find_Map(mapStr);
			if(UtilValiDate.isEmpty(map)&&map.size()>0){
				this.respBack(false, resp);
			}
			this.respBack(true, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	/**
	 * 获取所有的功能权限
	 */
	@RequestMapping(value ="/systemAccount_getAllfunctionData.do")
	public String getAllfunctionData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			req.setAttribute("mapData", systemAccountServiceImp.findAllfunctionData(mapStr));
			return returnPage("form/system/account/systemAccount_addFunctionsPage.jsp", req, resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	/**
	 * 修改权限
	 */
	@RequestMapping(value ="/systemAccount_editFunctionData.do")
	public String editFunctionData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.updateDataUpdate(systemAccountServiceImp.updateFunctionData(mapStr),"form/system/account/systemAccount_tr.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 *打开修改账户密码页面
	 */
	@RequestMapping(value ="/systemAccount_editUserPwdPage.do")
	public String editUserPwdPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			mapStr.put("findAll", "true");
			mapStr.put("account_id", mapStr.get("login_id"));
			return this.editPageUtil(systemAccountServiceImp.find_Map(mapStr),"form/main/editUserPwd_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	/**
	 *验证旧密码是否正确
	 */
	@RequestMapping(value ="/systemAccount_getPwdData.do")
	public void getPwdData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			mapStr.put("account_id", mapStr.get("login_id"));
			mapStr.put("account_pwd", req.getParameter("account_pwd"));
			this.respBack(systemAccountServiceImp.pwdIsTrue(mapStr), resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
}

