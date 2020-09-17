package com.servicesAdmin.util.drug.drugClass;
import java.util.List;
import java.util.Map;
/**
 * 药品分类表 service 接口
 * 操作人： 曾晓
 */ 
public interface UtilDrugClassService {

/************************系统生成方法开始******************************/

	/**
	 *获取药品分类表信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条药品分类表信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行药品分类表信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行药品分类表信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行药品分类表信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

 }

/************************系统生成方法完毕******************************/