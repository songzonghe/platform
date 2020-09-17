package com.servicesAdmin.login;

import java.util.Map;

/**
 * 登录service
 *
 */
public interface LoginServer {
	/**
	 * 验证医院id是否存在
	 */
	public boolean islogin(String id,String type) throws Exception;
	
	/**
	 * 用户登录
	 */
	public Map<String, Object> login(Map<String,String> mapStr) throws Exception;
	
}
