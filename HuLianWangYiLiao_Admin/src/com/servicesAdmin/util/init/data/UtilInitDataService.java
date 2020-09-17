package com.servicesAdmin.util.init.data;
import java.util.List;
import java.util.Map;
/**
 * 数据初始化 service 接口
 * 操作人： 曾晓
 */ 
public interface UtilInitDataService {

/************************系统生成方法开始******************************/

	/**
	 *获取基本数据信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;
	/**
	 *获取一条基本数据信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;
	/**
	 *进行基本数据信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

 }

/************************系统生成方法完毕******************************/