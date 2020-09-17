package com.servicesAdmin.system.account;
import java.util.List;
import java.util.Map;
/**
 * 账户 service 接口
 * 操作人： 张龙
 */ 
public interface SystemAccountService {

/************************系统生成方法开始******************************/

	/**
	 *获取账户信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条账户信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行账户信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行账户信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行账户信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;
	
	/**
	 * 获取功能分类
	 */
	public Map<String, Object> findAllfunctionData(Map<String, String> mapStr) throws Exception;
	
	/**
	 *修改账户权限
	 */
	public Map<String, Object> updateFunctionData(Map<String, String> mapStr) throws Exception;
	
	/**
	 *验证旧密码是否正确
	 */
	public boolean pwdIsTrue(Map<String, String> mapStr)throws Exception;

 }

/************************系统生成方法完毕******************************/