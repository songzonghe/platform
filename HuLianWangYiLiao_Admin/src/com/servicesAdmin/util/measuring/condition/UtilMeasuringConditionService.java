package com.servicesAdmin.util.measuring.condition;
import java.util.List;
import java.util.Map;
/**
 * 血糖测量条件  service 接口
 * 操作人： 曾晓
 */ 
public interface UtilMeasuringConditionService {

/************************系统生成方法开始******************************/

	/**
	 *获取血糖测量条件 信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条血糖测量条件 信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行血糖测量条件 信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行血糖测量条件 信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行血糖测量条件 信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

 }

/************************系统生成方法完毕******************************/