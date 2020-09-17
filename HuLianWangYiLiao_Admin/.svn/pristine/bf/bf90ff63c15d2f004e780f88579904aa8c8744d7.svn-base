package com.servicesAdmin.util.notice;
import java.util.List;
import java.util.Map;
/**
 * 系统消息 service 接口
 * 操作人： 曾晓
 */ 
public interface UtilNoticeService {

/************************系统生成方法开始******************************/

	/**
	 *获取系统消息信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条系统消息信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 * 根据类型发送信息
	 */
	public String add_Data(Map<String, String> mapStr) throws Exception;

	public void delete_Data(Map<String, String> mapStr) throws Exception;
	

	/**
	 * 获取接收人列表
	 */
	public List<Map<String, Object>> userList(Map<String, String> mapStr) throws Exception;

 }

/************************系统生成方法完毕******************************/