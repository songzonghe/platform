package com.servicesAdmin.util.prescription;
import java.util.List;
import java.util.Map;
/**
 * 处方模板 service 接口
 * 操作人： 曾晓
 */ 
public interface UtilPrescriptionService {

/************************系统生成方法开始******************************/

	/**
	 *获取处方模板信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条处方模板信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行处方模板信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行处方模板信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行处方模板信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

	/**
	*获取list
	 */
	public List<Map<String, Object>> prescriptionList(Map<String, String> mapStr)throws Exception;
	
	/**
	 *获取诊断不带分页list
	 */
	public List<Map<String, Object>> find_diagnosisList(Map<String, String> mapStr)throws Exception;
	
	/**
	 *获取医生不带分页list
	 */
	public List<Map<String, Object>> find_doctorList(Map<String, String> mapStr)throws Exception;
 }

/************************系统生成方法完毕******************************/