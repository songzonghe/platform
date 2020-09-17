package com.servicesAdmin.inquiry.log.prescription.details.inquiryLogPrescriptionDetails;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.SysFinal;
import com.util.UtilSql;
import com.util.UtilStr;
import com.util.UtilValiDate;
/**
 * 问诊记录处方详情 service 实现类
 *  操作人： 曾晓
 */ 
@Service("inquiryLogPrescriptionDetailsServiceImp ")
public class InquiryLogPrescriptionDetailsServiceImp implements InquiryLogPrescriptionDetailsService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取查询问诊记录处方详情的sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.prescription_details_id,t.hospital_id,t.prescription_id,t.drug_id,t.details_consumption,t.details_frequency_str,t.details_frequency,t.details_day,t.details_num,t.details_usage,t.details_entrust,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh,d.drug_name");
		sql.append(" from inquiry_log_prescription_details t, inquiry_log_prescription p,util_drug d");
		sql.append(" where t.prescription_id=p.prescription_id and t.drug_id=d.drug_id and t.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("prescription_details_id"))) {
			sql.append(" and t.prescription_details_id=:prescription_details_id ");
			mapSQLParameter.put("prescription_details_id", mapStr.get("prescription_details_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("prescription_id"))) {
				sql.append(" and t.prescription_id=:prescription_id ");
				mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
			}
		}
	}
	

	/**
	 *获取问诊记录处方详情数据列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		if (!UtilValiDate.isEmpty(mapStr.get(SysFinal.ISSORT_KEY))){ //由于从菜单进入没有带入参数，这里给入判断进行开启排序
			mapStr.put(SysFinal.ISSORT_KEY,"y");
		}
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	/**
	 *获取单个问诊记录处方详情数据
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		return this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
	}

	/**
	 *添加问诊记录处方详情
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into inquiry_log_prescription_details");
		sql.append("( hospital_id,prescription_id,drug_id,details_consumption,details_frequency_str,details_frequency,details_day,details_num,details_usage,details_entrust");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values(:hospital_id,:prescription_id,:drug_id,:details_consumption,:details_frequency_str,:details_frequency,:details_day,:details_num,:details_usage,:details_entrust");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
		mapSQLParameter.put("drug_id", mapStr.get("drug_id"));
		mapSQLParameter.put("details_consumption", mapStr.get("details_consumption"));
		mapSQLParameter.put("details_frequency_str", mapStr.get("details_frequency_str"));
		mapSQLParameter.put("details_frequency", mapStr.get("details_frequency"));
		mapSQLParameter.put("details_day", mapStr.get("details_day"));
		mapSQLParameter.put("details_num", mapStr.get("details_num"));
		mapSQLParameter.put("details_usage", mapStr.get("details_usage"));
		mapSQLParameter.put("details_entrust", mapStr.get("details_entrust"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapSQLParameter.put("prescription_details_id",this.gyDAOimp.exeSqlBool(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改问诊记录处方详情
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update inquiry_log_prescription_details set gxsj=:gxsj");
		sql.append(" ,hospital_id=:hospital_id,drug_id=:drug_id,details_consumption=:details_consumption,details_frequency_str=:details_frequency_str,details_frequency=:details_frequency,details_day=:details_day,details_num=:details_num,details_usage=:details_usage,details_entrust=:details_entrust, bz=:bz ");
		sql.append(" where prescription_details_id=:prescription_details_id");
		mapStr.put(SysFinal.BZ_KEY, UtilStr.codeUTF_8(mapStr.get(SysFinal.BZ_KEY)));
		mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
		mapSQLParameter.put("drug_id", mapStr.get("drug_id"));
		mapSQLParameter.put("details_consumption", mapStr.get("details_consumption"));
		mapSQLParameter.put("details_frequency_str", mapStr.get("details_frequency_str"));
		mapSQLParameter.put("details_frequency", mapStr.get("details_frequency"));
		mapSQLParameter.put("details_day", mapStr.get("details_day"));
		mapSQLParameter.put("details_num", mapStr.get("details_num"));
		mapSQLParameter.put("details_usage", mapStr.get("details_usage"));
		mapSQLParameter.put("details_entrust", mapStr.get("details_entrust"));
		mapSQLParameter.put("bz", mapStr.get(SysFinal.BZ_KEY));
		mapSQLParameter.put("prescription_details_id", mapStr.get("prescription_details_id"));
		mapSQLParameter.put("gxsj", UtilSql.getGXSJ());
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除问诊记录处方详情
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from inquiry_log_prescription_details where prescription_details_id=:prescription_details_id");
		mapSQLParameter.put("prescription_details_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
	}

	/************************系统生成方法完毕******************************/
}