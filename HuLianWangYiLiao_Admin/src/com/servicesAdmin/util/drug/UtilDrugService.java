package com.servicesAdmin.util.drug;
import java.util.List;
import java.util.Map;
/**
 * 药品信息 service 接口
 * 操作人： 刘杰
 */ 
public interface UtilDrugService {

/************************系统生成方法开始******************************/

	/**
	 *获取药品信息信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条药品信息信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行药品信息信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行药品信息信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行药品信息信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;
	
	/**
	 *获取药品list
	 */
	public List<Map<String, Object>> drugList(Map<String, String> mapStr)throws Exception;
	
	/**
	 *获取用法不带分页
	 */
	public List<Map<String, Object>> usageList(Map<String, String> mapStr)throws Exception;
	
	/**
	 *获取频率不带分页
	 */
	public List<Map<String, Object>> frequencyList(Map<String, String> mapStr)throws Exception;
	
	/**
	 * 根据上级id查询所有分类  
	 */
	public String class_up_list(Map<String, String> mapStr) throws Exception;
	
	/**
	 *获取单位
	 */
	public List<Map<String, Object>> optionTypeList(Map<String, String> mapStr)throws Exception;
	
	/**
	 *获取分类list
	 */
	public List<Map<String, Object>> classList(Map<String, String> mapStr)throws Exception;
	
	/**
	 * 获取剂型List
	 */
	public List<Map<String,Object>> agenList(Map<String, String> mapStr) throws Exception;
	
	/**
	 *获取批号list
	 */
	public List<Map<String, Object>> numberList(Map<String, String> mapStr)throws Exception;
	
	/**
	 *获取厂家list
	 */
	public List<Map<String, Object>> companyList(Map<String, String> mapStr)throws Exception;

 }

/************************系统生成方法完毕******************************/