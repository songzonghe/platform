package com.servicesAdmin.util.certificates;
import java.util.List;
import java.util.Map;
/**
 * 系统初始化证件 service 接口
 * 操作人： 曾晓
 */ 
public interface UtilCertificatesService {

/************************系统生成方法开始******************************/

	/**
	 *获取系统初始化证件信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条系统初始化证件信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行系统初始化证件信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行系统初始化证件信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行系统初始化证件信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

 }

/************************系统生成方法完毕******************************/