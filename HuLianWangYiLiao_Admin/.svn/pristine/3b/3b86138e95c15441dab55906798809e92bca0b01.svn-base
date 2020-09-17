package com.controllerAdmin.login;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.custom.interceptor.AccessRequired;
import com.servicesAdmin.login.LoginServer;
import com.util.MD5;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 用户登录 
 */
@Controller
public class LoginController extends ControllerUtil {
	@Resource
	private LoginServer loginServerImp;
	
	/**
	 * 登录转换
	 */
	@RequestMapping(value = "/login")
	@AccessRequired
	public String login(HttpServletRequest req,HttpServletResponse resp) {
		req.getSession().invalidate();
		try {
			if(!UtilValiDate.isEmpty(req.getParameter("hi"))){
				System.out.println("登录地址错误=======没有参数");
				return "/form_util/page/login_404.jsp";
			}
			String hospital_pwd=req.getParameter("hi");//加密的id
			String hospital_id=MD5.numberDecoder(hospital_pwd).substring(2);//对加密的id解密拿医院或药师id
			String account_type=MD5.numberDecoder(hospital_pwd).substring(0,1);//对加密的id解密拿医院id
			if(!UtilValiDate.isEmpty(hospital_id)&&!"0".equals(hospital_id)&& loginServerImp.islogin(hospital_id,account_type)) {
				//验证医院账号是否正确
				System.out.println("登录地址错误=======医院id错误"+hospital_id);
				return "/form_util/page/login_404.jsp";
			}
			req.setAttribute("hosid",hospital_pwd);
			return "/form/login/login.jsp";
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return "/form_util/page/login_404.jsp";
	}
	/**
	 * 登录验证
	 * @return String
	 */
	@RequestMapping(value = "/login_valiDate.do")
	@AccessRequired //添加过滤器
	public String valiDate(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
			logger.info("用户登录"+mapStr);
			if(!UtilValiDate.isEmpty(mapStr.get("hosid"))){
				logger.info("登录结果：医院id标识为空"+mapStr.get("hosid")+"）,");
				req.setAttribute("ishosid", "0");
				req.setAttribute("infoError", "访问地址错误！请联系平台！！！");
				return "/form/login/login.jsp";
			}
			String hospital_id=MD5.numberDecoder(mapStr.get("hosid")).substring(2);//对加密的id解密拿医院或药师id
			String account_type=MD5.numberDecoder(mapStr.get("hosid")).substring(0,1);//对加密的id解密类型
			if(!UtilValiDate.isEmpty(MD5.numberDecoder(mapStr.get("hosid"))) || ( !"0".equals(hospital_id)&&!loginServerImp.islogin(hospital_id,account_type))){
				logger.info("登录结果：医院id为空或不正确（"+MD5.numberDecoder(mapStr.get("hosid"))+"）");
				req.setAttribute("ishosid", "0");
				req.setAttribute("infoError", "访问地址错误！请联系平台！！！");
				return "/form/login/login.jsp";
			}
			if(!UtilValiDate.isEmpty(mapStr.get("login_name")) || !UtilValiDate.isEmpty(mapStr.get("login_pwd"))){
				logger.info("登录结果：用户名或密码为空!");
				req.setAttribute("infoError", "请填写完整的登录信息！！！");
				return "/form/login/login.jsp";
			}
			Map<String, Object> mapLogin = loginServerImp.login(mapStr);
			if (mapLogin.size() > 0){
				if(!UtilValiDate.isEmpty(mapLogin.get("mapLogin"))){
					logger.info("登录结果：账号已禁用");
					req.setAttribute("infoError", "您的账户已被禁用，请联系管理员！！！");
					return "/form/login/login.jsp";
				}
				logger.info("登录结果：成功登录!");
				//保存账户登录信息
				req.getSession().setAttribute("feiMaChuXingLoginInfo",mapLogin.get("mapLogin"));
				//获取账户的功能权限
				req.setAttribute("menuData", mapLogin.get("gongNengJson"));
				return "/form/main/main.jsp" ;
			} else {
				logger.info("登录结果：账号或密码错误!");
				req.setAttribute("infoError", "账号或密码错误,请填写正确的信息！！");
				return "/form/login/login.jsp";
			}
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 * 跳转到login页面
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/login_result.do")
	@AccessRequired //添加过滤器
	public String result(HttpServletRequest req,HttpServletResponse resp) {
		req.getSession().invalidate();
		return "form/login/login.jsp";
	}
	

}
