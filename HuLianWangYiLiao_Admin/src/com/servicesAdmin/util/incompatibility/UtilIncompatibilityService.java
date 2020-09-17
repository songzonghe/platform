package com.servicesAdmin.util.incompatibility;
import java.util.List;
import java.util.Map;
/**
 * 配伍禁忌 service 接口
 * 操作人： 曾晓
 */ 
public interface UtilIncompatibilityService {

/************************系统生成方法开始******************************/

	/**
	 *获取配伍禁忌信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条配伍禁忌信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行配伍禁忌信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行配伍禁忌信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行配伍禁忌信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;
	
	/**
	 *判断重复
	 */
	public boolean find_boolMap(Map<String, String> mapStr)throws Exception;

 }

/************************系统生成方法完毕******************************/