package com.servicesAdmin.util.checklist.checklistClass.details.utilChecklist;
import java.util.List;
import java.util.Map;
/**
 * 系统检验检查表 service 接口
 *  操作人： 曾晓
 */ 
public interface UtilChecklistService {

	/************************系统生成方法开始******************************/

	/**
	 *获取系统检验检查表数据列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取单个系统检验检查表数据
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *添加系统检验检查表
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *修改系统检验检查表
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *删除系统检验检查表
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

	/************************系统生成方法完毕******************************/
}