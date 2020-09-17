package com.servicesAdmin.util.health.guidance;
import java.util.List;
import java.util.Map;
/**
 * 健康指导模板 service 接口
 * 操作人： 曾晓
 */ 
public interface UtilHealthGuidanceService {

/************************系统生成方法开始******************************/

	/**
	 *获取健康指导模板信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条健康指导模板信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行健康指导模板信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行健康指导模板信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行健康指导模板信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

 }

/************************系统生成方法完毕******************************/