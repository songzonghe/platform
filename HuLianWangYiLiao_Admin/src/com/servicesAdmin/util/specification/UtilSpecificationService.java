package com.servicesAdmin.util.specification;
import java.util.List;
import java.util.Map;
/**
 * 问诊规范 service 接口
 * 操作人： 曾晓
 */ 
public interface UtilSpecificationService {

/************************系统生成方法开始******************************/

	/**
	 *获取问诊规范信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条问诊规范信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行问诊规范信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行问诊规范信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行问诊规范信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

 }

/************************系统生成方法完毕******************************/