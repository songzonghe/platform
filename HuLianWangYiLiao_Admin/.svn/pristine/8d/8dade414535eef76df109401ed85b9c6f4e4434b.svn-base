/**
 * 
 */
package com.servicesAdmin.reportForm;

import java.util.List;
import java.util.Map;

/**
 * 报表管理
 * @author 李裕国
 * @date 2019年10月24日 下午6:02:14
 */
public interface ReportFormServer {

	/**
	 *分页获取药师管理信息
	 * @throws Exception 
	 */
	List<Map<String, Object>> tRegisterUserBody(Map<String, String> mapStr) throws Exception;
	
	/**
	 * 分页获取咨询用户信息
	 * @throws Exception 
	 */
	List<Map<String, Object>> tInquiryUserBody(Map<String, String> mapStr)throws Exception;
	
	/**
	 * 分页获取处方报表
	 * @throws Exception 
	 */
	List<Map<String, Object>> tPrescriptionBody(Map<String, String> mapStr)throws Exception;
	
	/**
	 *分页获取健康指导报表
	 */
	List<Map<String, Object>> tHealthGuidanceBody(Map<String, String> mapStr)throws Exception;

	/**
	 *分页获取检验检查报表
	 */
	List<Map<String, Object>> tChecklistBody(Map<String, String> mapStr)throws Exception;
	
	/**
	 *分页获取药住院建议报表
	 */
	List<Map<String, Object>> tHospitalizationBody(Map<String, String> mapStr)throws Exception;

	/**
	 *分页获取药师审核处方统计报表
	 */
	List<Map<String, Object>> tAuditPrescriptionBody(Map<String, String> mapStr)throws Exception;

	/**
	 *分页获取院长统计报表
	 */
	Map<String, String> tDeanReport(Map<String, String> mapStr)throws Exception;


	/**
	* 问诊记录详情
	* @param mapStr
	* @throws Exception
	*/
	public String updateInquiryLogDetails(Map<String, String> mapStr)throws Exception;
	
	/**
	* 住院建议详情
	* @param mapStr
	* @throws Exception
	*/
	public String getInquiryLogHospitalizationDetails(Map<String, String> mapStr)throws Exception;
	
	/**
	* 健康指导详情
	* @param mapStr
	* @throws Exception
	*/
	public String getInquiryLogHealthGuidanceDetails(Map<String, String> mapStr)throws Exception;
	
	/**
	* 检验单详情
	* @param mapStr
	* @throws Exception
	*/
	public String getInquiryLogChecklistDetails(Map<String, String> mapStr)throws Exception;
	
	/**
	* 处方详情
	* @param mapStr
	* @throws Exception
	*/
	public String updateInquiryLogPrescriptionDetails(Map<String, String> mapStr)throws Exception;
	
	/**
	 *分页获取大数据图
	 * @throws Exception 
	 */
	public Map<String, String> tBigDataIndex(Map<String, String> mapStr) throws Exception;

	/**
	 *获取注册用户导出信息
	 * @throws Exception 
	 */
	Map<String, Object> registerUserIndexExcelSql(Map<String, String> mapStr) throws Exception;

	/**
	 *获取咨询用户导出信息
	 */
	Map<String, Object> inquiryUserIndexExcelSql(Map<String, String> mapStr)throws Exception;

	/**
	 *获取取处导出信息
	 */
	Map<String, Object> prescriptionExcelSql(Map<String, String> mapStr)throws Exception;

	/**
	 *获取健康指导导出信息
	 */
	Map<String, Object> healthHuidanceExcelSql(Map<String, String> mapStr)throws Exception;

	/**
	 *获取健康指导导出信息
	 */
	Map<String, Object>  checklistExcelSql(Map<String, String> mapStr)throws Exception;

	/**
	 *获取获药师审核导出信息
	 */
	Map<String, Object> auditPrescriptionExcelSql(Map<String, String> mapStr)throws Exception;

	/**
	 *获取获药师审核导出信息
	 */
	Map<String, Object> hospitalizationExcelSql(Map<String, String> mapStr)throws Exception;
}
