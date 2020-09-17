package com.servicesAdmin.util.icd;
import java.util.List;
import java.util.Map;
/**
 * 国际疾病分类 service 接口
 * 操作人： 苏洪伟
 */ 
public interface UtilIcdService {

/************************系统生成方法开始******************************/

	/**
	 *获取国际疾病分类信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条国际疾病分类信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行国际疾病分类信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行国际疾病分类信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行国际疾病分类信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

 }

/************************系统生成方法完毕******************************/