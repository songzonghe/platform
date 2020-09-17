package com.servicesAdmin.util.hospital;
import java.util.List;
import java.util.Map;
/**
 * 系统医院 service 接口
 * 操作人： 曾晓
 */ 
public interface UtilHospitalService {

/************************系统生成方法开始******************************/

	/**
	 *获取系统医院信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条系统医院信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行系统医院信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行系统医院信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行系统医院信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;

 }

/************************系统生成方法完毕******************************/