package com.servicesAdmin.inquiry.log.prescription;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.SysFinal;
import com.util.UtilSql;
import com.util.UtilValiDate;
/**
 * 问诊记录处方 service 实现类
 * 操作人： 曾晓
 */ 
@Service("inquiryLogPrescriptionServiceImp")
public class InquiryLogPrescriptionServiceImp implements InquiryLogPrescriptionService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取问诊记录处方查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select p.prescription_id,p.hospital_id,p.log_id,p.join_type,p.join_id,p.inquiry_patient_id,p.doctor_id,p.prescription_type,p.prescription_price,p.prescription_num,p.prescription_taking,p.prescription_requirements,p.gxsj,p.bz,p.lrsj,p.zt,p.lrzh,p.prescription_audited_doctor,p.prescription_reasons_invalidation,p.prescription_audited_data,f.inquiry_patient_name,d.doctor_name");
		sql.append(" ,il.lrsj as log_lrsj,il.lof_diagnosis from inquiry_log_prescription p,inquiry_patient_info f,doctor_info d,inquiry_log il ");
		sql.append(" where p.inquiry_patient_id=f.inquiry_patient_id and p.doctor_id=d.doctor_id and il.log_id=p.log_id and p.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("prescription_id"))) {
			sql.append(" and p.prescription_id=:prescription_id ");
			mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_name"))) {
				sql.append(" and f.inquiry_patient_name like :inquiry_patient_name");
				mapSQLParameter.put("inquiry_patient_name", "%" + mapStr.get("inquiry_patient_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
				sql.append(" and d.doctor_name like :doctor_name");
				mapSQLParameter.put("doctor_name", "%" + mapStr.get("doctor_name") + "%");
			}
			//2审核中  0审核通过  1已查看  5作废  3审核失败
			if (UtilValiDate.isEmpty(mapStr.get("find_zt"))) {
				sql.append(" and p.zt = :find_zt");
				mapSQLParameter.put("find_zt",mapStr.get("find_zt"));
			}
		}
	}

	/**
	 *获取问诊记录处方信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		if (!UtilValiDate.isEmpty(mapStr.get(SysFinal.ISSORT_KEY))){ //由于从菜单进入没有带入参数，这里给入判断进行开启排序
			mapStr.put(SysFinal.ISSORT_KEY,"y");
		}
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	/**
	 *获取一条问诊记录处方信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		Map<String, Object> findSqlMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		//获取处方详情
		if(findSqlMap.size()>0 && "details".equals(mapStr.get("find_details"))) {
			sql.delete(0,sql.length());
			//药品信息
			sql.append("select ud.drug_name,ud.drug_packaging_unit,ud.drug_type,ud.drug_is_rx,ud.drug_unit,ud.drug_specifications");
			//处方信息
			sql.append(" ,t.details_consumption,t.details_consumption_util,t.details_frequency_str,t.details_frequency,t.details_day,t.details_num,t.details_usage,t.details_entrust ");
			sql.append("  from inquiry_log_prescription_details t,util_drug ud where ud.drug_id=t.drug_id and t.prescription_id =:prescription_id");
			mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
			List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
			findSqlMap.put("detailsList", findSqlList);
		}
		return findSqlMap;
	}

	/**
	 *新增操作
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into inquiry_log_prescription");
		sql.append("( hospital_id,log_id,join_type,join_id,inquiry_patient_id,doctor_id,prescription_type,prescription_price,prescription_num,prescription_taking,prescription_requirements,prescription_audited_doctor,prescription_reasons_invalidation");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:log_id,:join_type,:join_id,:inquiry_patient_id,:doctor_id,:prescription_type,:prescription_price,:prescription_num,:prescription_taking,:prescription_requirements,:prescription_audited_doctor,:prescription_reasons_invalidation");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		mapSQLParameter.put("join_type", mapStr.get("join_type"));
		mapSQLParameter.put("join_id", mapStr.get("join_id"));
		mapSQLParameter.put("inquiry_patient_id", mapStr.get("inquiry_patient_id"));
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("prescription_type", mapStr.get("prescription_type"));
		mapSQLParameter.put("prescription_price", mapStr.get("prescription_price"));
		mapSQLParameter.put("prescription_num", mapStr.get("prescription_num"));
		mapSQLParameter.put("prescription_taking", mapStr.get("prescription_taking"));
		mapSQLParameter.put("prescription_requirements", mapStr.get("prescription_requirements"));
		mapSQLParameter.put("prescription_audited_doctor", mapStr.get("account_name"));
		mapSQLParameter.put("prescription_reasons_invalidation", mapStr.get("prescription_reasons_invalidation"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("prescription_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *审核处方操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//先判断处方是否被审核
		sql.append("select prescription_id,zt from inquiry_log_prescription where prescription_id=:prescription_id and zt=2");
		mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
		if(!this.gyDAOimp.findSqlBool(sql, mapSQLParameter)) {
			mapSQLParameter.put("backInfo", "该处方已被其他药师审核过了，请刷新列表，再进行审核！！");
			return mapSQLParameter;
		}
		mapStr.put("gxsj", UtilSql.getGXSJ());
		sql.delete(0, sql.length());
		sql.append("update inquiry_log_prescription set gxsj=:gxsj,prescription_audited_data=:gxsj,prescription_audited_doctor=:prescription_audited_doctor,prescription_audited_doctor_id=:prescription_audited_doctor_id");
		mapSQLParameter.put("prescription_audited_doctor", mapStr.get("login_name"));
		mapSQLParameter.put("prescription_audited_doctor_id", mapStr.get("other_id"));
		if(null!=mapStr.get("prescription_requirements")){
			sql.append(",prescription_requirements=:prescription_requirements");
			mapSQLParameter.put("prescription_requirements", mapStr.get("prescription_requirements"));
		}

		if(null!=mapStr.get("prescription_reasons_invalidation")){
			sql.append(",prescription_reasons_invalidation=:prescription_reasons_invalidation");
			mapSQLParameter.put("prescription_reasons_invalidation", mapStr.get("prescription_reasons_invalidation"));
		}
		
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where prescription_id=:prescription_id");
		
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		Map<String, Object> find_Map = this.find_Map(mapStr);
		//发送消息
		if("0".equals(mapStr.get("edit_zt")) || "5".equals(mapStr.get("edit_zt"))) {
			sql.delete(0, sql.length());
			sql.append("insert into util_notice");
			sql.append("( notice_type,user_type,user_id,hospital_id,notice_title,notice_content,notice_join");
			sql.append(UtilSql.getFieldInsertKey());
			sql.append("values(:notice_type,:user_type,:user_id,:hospital_id,:notice_title,:notice_content,:notice_join");
			sql.append(UtilSql.getFieldInsertVal());
			mapSQLParameter.put("notice_type", "2");
			mapSQLParameter.put("user_type", find_Map.get("join_type"));
			mapSQLParameter.put("user_id", find_Map.get("join_id"));
			mapSQLParameter.put("notice_title", "处方审核");
			if("0".equals(mapStr.get("edit_zt"))){
			mapSQLParameter.put("notice_content","处方审核通过！！！");
			}else
			if("5".equals(mapStr.get("edit_zt"))){
				mapSQLParameter.put("notice_content","处方存在问题，审核不通过！！！");
			}
			UtilSql.setMapVal(mapSQLParameter, mapStr);
			mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			mapSQLParameter.put("notice_join", mapStr.get("prescription_id"));
			this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
			//给医生发
			mapSQLParameter.put("user_type", "3");
			mapSQLParameter.put("user_id", find_Map.get("doctor_id"));
			this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		}
		
		return find_Map;
	}

	/**
	 *删除问诊记录处方操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from inquiry_log_prescription where prescription_id=:prescription_id");
		mapSQLParameter.put("prescription_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		sql.delete(0, sql.length());
		sql.append("delete from inquiry_log_prescription_details where prescription_id=:prescription_id");
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
	}

	/************************系统生成方法完毕******************************/
}