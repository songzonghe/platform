package com.servicesAdmin.util.prescription.details.utilPrescriptionDetails;
import java.util.List;
import java.util.Map;
/**
 * 问诊记录处方模板详情 service 接口
 *  操作人： 曾晓
 */ 
public interface UtilPrescriptionDetailsService {

	/************************系统生成方法开始******************************/

	/**
	 *获取问诊记录处方模板详情数据列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取单个问诊记录处方模板详情数据
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *添加问诊记录处方模板详情
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *修改问诊记录处方模板详情
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *删除问诊记录处方模板详情
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

	/************************系统生成方法完毕******************************/
}