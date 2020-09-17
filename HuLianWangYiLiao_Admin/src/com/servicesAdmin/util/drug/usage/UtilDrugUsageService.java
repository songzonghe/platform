package com.servicesAdmin.util.drug.usage;
import java.util.List;
import java.util.Map;
/**
 * 药品用法 service 接口
 * 操作人： 曾晓
 */ 
public interface UtilDrugUsageService {

/************************系统生成方法开始******************************/

	/**
	 *获取药品用法信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条药品用法信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行药品用法信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行药品用法信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行药品用法信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

 }

/************************系统生成方法完毕******************************/