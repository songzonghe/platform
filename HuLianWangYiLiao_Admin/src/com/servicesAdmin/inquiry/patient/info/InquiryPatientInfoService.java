package com.servicesAdmin.inquiry.patient.info;
import java.util.List;
import java.util.Map;
/**
 * 网络医院问诊患者信息 service 接口
 * 操作人： 曾晓
 */ 
public interface InquiryPatientInfoService {

/************************系统生成方法开始******************************/

	/**
	 *获取网络医院问诊患者信息信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条网络医院问诊患者信息信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行网络医院问诊患者信息信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行网络医院问诊患者信息信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行网络医院问诊患者信息信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;
	
	/**
	 *获取问诊患者list
	 */
	public List<Map<String, Object>> patientList(Map<String, String> mapStr)throws Exception;

 }

/************************系统生成方法完毕******************************/