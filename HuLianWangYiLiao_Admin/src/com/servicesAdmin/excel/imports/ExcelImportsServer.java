package com.servicesAdmin.excel.imports;

import java.util.List;
import java.util.Map;

/**
 *导出
 */
public interface ExcelImportsServer {
	/**
	 * 数据导入  
	 */
	public Map<String, Object> addImportDataBaseData(List<Map<String, Object>>listContent,Map<String,String> mapStr)throws Exception;
	
	
	/**
	 *药品 导入模板
	 * * type=name 只获取需导入的名称  其他 获取名称和数据
	 */
	public Map<String, Object> addImportUtil_drug(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception;
	
	/**
	 * 国际疾病模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	public Map<String, Object> addImportUtil_icd(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception;
	/**
	 *医嘱 导入模板
	 * * type=name 只获取需导入的名称  其他 获取名称和数据
	 */
	public Map<String, Object> addImportUtil_medical_advice(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception;
	
	/**
	 *频率 导入模板
	 * * type=name 只获取需导入的名称  其他 获取名称和数据
	 */
	public Map<String, Object> addImportUtil_drug_frequency(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception;
	
	/**
	 *用法导入模板
	 * * type=name 只获取需导入的名称  其他 获取名称和数据
	 */
	public Map<String, Object> addImportUtil_drug_usage(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception;
	
	/**
	 *属性导入模板
	 * * type=name 只获取需导入的名称  其他 获取名称和数据
	 */
	public Map<String, Object> addImportUtil_drug_attribute_option(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception;
	
	/**
	 *批号导入模板
	 * * type=name 只获取需导入的名称  其他 获取名称和数据
	 */
	public Map<String, Object> addImportUtil_batch_number(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception;
	
	/**
	 *厂家导入模板
	 * * type=name 只获取需导入的名称  其他 获取名称和数据
	 */
	public Map<String, Object> addImportUtil_company(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception;


	public Map<String, Object> addImportstore_info_attribute_option(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type)throws Exception;


	/**
	 * 字典导入模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	@SuppressWarnings("serial")
	public Map<String, Object> addImportUtilDictionaries(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception;
}
