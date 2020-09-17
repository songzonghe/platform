package com.servicesAdmin.inquiry.log.checklist;
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
 * 问诊记录检验单 service 实现类
 * 操作人： 苏洪伟
 */ 
@Service("inquiryLogChecklistServiceImp")
public class InquiryLogChecklistServiceImp implements InquiryLogChecklistService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取问诊记录检验单查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.checklist_id,t.hospital_id,t.log_id,t.join_type,t.join_id,t.inquiry_patient_id,t.doctor_id,t.checklist_name,t.checklist_code,t.checklist_type,t.checklist_last_code,t.checklist_abstract,t.checklist_sbp,t.checklist_dbp,t.is_digitalization,t.checklist_digitalization_num,t.checklist_digitalization_start,t.checklist_digitalization_end,t.is_other_drugs,t.checklist_other_drugs_name,t.checklist_other_drugs_start,t.checklist_other_drugs_end,t.checklist_other_drugs_num,t.checklist_inspection_result,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from inquiry_log_checklist t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("checklist_id"))) {
			sql.append(" and t.checklist_id=:checklist_id ");
			mapSQLParameter.put("checklist_id", mapStr.get("checklist_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_id"))) {
				sql.append(" and t.inquiry_patient_id like :inquiry_patient_id");
				mapSQLParameter.put("inquiry_patient_id", "%" + mapStr.get("inquiry_patient_id") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("doctor_id"))) {
				sql.append(" and t.doctor_id like :doctor_id");
				mapSQLParameter.put("doctor_id", "%" + mapStr.get("doctor_id") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("checklist_name"))) {
				sql.append(" and t.checklist_name like :checklist_name");
				mapSQLParameter.put("checklist_name", "%" + mapStr.get("checklist_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("checklist_code"))) {
				sql.append(" and t.checklist_code like :checklist_code");
				mapSQLParameter.put("checklist_code", "%" + mapStr.get("checklist_code") + "%");
			}
		}
	}

	/**
	 *获取问诊记录检验单信息列表
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
	 *获取一条问诊记录检验单信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		return this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
	}

	/**
	 *新增操作
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into inquiry_log_checklist");
		sql.append("( hospital_id,log_id,join_type,join_id,inquiry_patient_id,doctor_id,checklist_name,checklist_code,checklist_type,checklist_last_code,checklist_abstract,checklist_sbp,checklist_dbp,is_digitalization,checklist_digitalization_num,checklist_digitalization_start,checklist_digitalization_end,is_other_drugs,checklist_other_drugs_name,checklist_other_drugs_start,checklist_other_drugs_end,checklist_other_drugs_num,checklist_inspection_result");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:log_id,:join_type,:join_id,:inquiry_patient_id,:doctor_id,:checklist_name,:checklist_code,:checklist_type,:checklist_last_code,:checklist_abstract,:checklist_sbp,:checklist_dbp,:is_digitalization,:checklist_digitalization_num,:checklist_digitalization_start,:checklist_digitalization_end,:is_other_drugs,:checklist_other_drugs_name,:checklist_other_drugs_start,:checklist_other_drugs_end,:checklist_other_drugs_num,:checklist_inspection_result");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		mapSQLParameter.put("join_type", mapStr.get("join_type"));
		mapSQLParameter.put("join_id", mapStr.get("join_id"));
		mapSQLParameter.put("inquiry_patient_id", mapStr.get("inquiry_patient_id"));
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("checklist_name", mapStr.get("checklist_name"));
		mapSQLParameter.put("checklist_code", mapStr.get("checklist_code"));
		mapSQLParameter.put("checklist_type", mapStr.get("checklist_type"));
		mapSQLParameter.put("checklist_last_code", mapStr.get("checklist_last_code"));
		mapSQLParameter.put("checklist_abstract", mapStr.get("checklist_abstract"));
		mapSQLParameter.put("checklist_sbp", mapStr.get("checklist_sbp"));
		mapSQLParameter.put("checklist_dbp", mapStr.get("checklist_dbp"));
		mapSQLParameter.put("is_digitalization", mapStr.get("is_digitalization"));
		mapSQLParameter.put("checklist_digitalization_num", mapStr.get("checklist_digitalization_num"));
		mapSQLParameter.put("checklist_digitalization_start", mapStr.get("checklist_digitalization_start"));
		mapSQLParameter.put("checklist_digitalization_end", mapStr.get("checklist_digitalization_end"));
		mapSQLParameter.put("is_other_drugs", mapStr.get("is_other_drugs"));
		mapSQLParameter.put("checklist_other_drugs_name", mapStr.get("checklist_other_drugs_name"));
		mapSQLParameter.put("checklist_other_drugs_start", mapStr.get("checklist_other_drugs_start"));
		mapSQLParameter.put("checklist_other_drugs_end", mapStr.get("checklist_other_drugs_end"));
		mapSQLParameter.put("checklist_other_drugs_num", mapStr.get("checklist_other_drugs_num"));
		mapSQLParameter.put("checklist_inspection_result", mapStr.get("checklist_inspection_result"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("checklist_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改问诊记录检验单操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update inquiry_log_checklist set gxsj=:gxsj");
		if(null!=mapStr.get("log_id")){
			sql.append(",log_id=:log_id");
			mapSQLParameter.put("log_id", mapStr.get("log_id"));
		}
		if(null!=mapStr.get("join_type")){
			sql.append(",join_type=:join_type");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		if(null!=mapStr.get("join_id")){
			sql.append(",join_id=:join_id");
			mapSQLParameter.put("join_id", mapStr.get("join_id"));
		}
		if(null!=mapStr.get("inquiry_patient_id")){
			sql.append(",inquiry_patient_id=:inquiry_patient_id");
			mapSQLParameter.put("inquiry_patient_id", mapStr.get("inquiry_patient_id"));
		}
		if(null!=mapStr.get("doctor_id")){
			sql.append(",doctor_id=:doctor_id");
			mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		}
		if(null!=mapStr.get("checklist_name")){
			sql.append(",checklist_name=:checklist_name");
			mapSQLParameter.put("checklist_name", mapStr.get("checklist_name"));
		}
		if(null!=mapStr.get("checklist_code")){
			sql.append(",checklist_code=:checklist_code");
			mapSQLParameter.put("checklist_code", mapStr.get("checklist_code"));
		}
		if(null!=mapStr.get("checklist_type")){
			sql.append(",checklist_type=:checklist_type");
			mapSQLParameter.put("checklist_type", mapStr.get("checklist_type"));
		}
		if(null!=mapStr.get("checklist_last_code")){
			sql.append(",checklist_last_code=:checklist_last_code");
			mapSQLParameter.put("checklist_last_code", mapStr.get("checklist_last_code"));
		}
		if(null!=mapStr.get("checklist_abstract")){
			sql.append(",checklist_abstract=:checklist_abstract");
			mapSQLParameter.put("checklist_abstract", mapStr.get("checklist_abstract"));
		}
		if(null!=mapStr.get("checklist_sbp")){
			sql.append(",checklist_sbp=:checklist_sbp");
			mapSQLParameter.put("checklist_sbp", mapStr.get("checklist_sbp"));
		}
		if(null!=mapStr.get("checklist_dbp")){
			sql.append(",checklist_dbp=:checklist_dbp");
			mapSQLParameter.put("checklist_dbp", mapStr.get("checklist_dbp"));
		}
		if(null!=mapStr.get("is_digitalization")){
			sql.append(",is_digitalization=:is_digitalization");
			mapSQLParameter.put("is_digitalization", mapStr.get("is_digitalization"));
		}
		if(null!=mapStr.get("checklist_digitalization_num")){
			sql.append(",checklist_digitalization_num=:checklist_digitalization_num");
			mapSQLParameter.put("checklist_digitalization_num", mapStr.get("checklist_digitalization_num"));
		}
		if(null!=mapStr.get("checklist_digitalization_start")){
			sql.append(",checklist_digitalization_start=:checklist_digitalization_start");
			mapSQLParameter.put("checklist_digitalization_start", mapStr.get("checklist_digitalization_start"));
		}
		if(null!=mapStr.get("checklist_digitalization_end")){
			sql.append(",checklist_digitalization_end=:checklist_digitalization_end");
			mapSQLParameter.put("checklist_digitalization_end", mapStr.get("checklist_digitalization_end"));
		}
		if(null!=mapStr.get("is_other_drugs")){
			sql.append(",is_other_drugs=:is_other_drugs");
			mapSQLParameter.put("is_other_drugs", mapStr.get("is_other_drugs"));
		}
		if(null!=mapStr.get("checklist_other_drugs_name")){
			sql.append(",checklist_other_drugs_name=:checklist_other_drugs_name");
			mapSQLParameter.put("checklist_other_drugs_name", mapStr.get("checklist_other_drugs_name"));
		}
		if(null!=mapStr.get("checklist_other_drugs_start")){
			sql.append(",checklist_other_drugs_start=:checklist_other_drugs_start");
			mapSQLParameter.put("checklist_other_drugs_start", mapStr.get("checklist_other_drugs_start"));
		}
		if(null!=mapStr.get("checklist_other_drugs_end")){
			sql.append(",checklist_other_drugs_end=:checklist_other_drugs_end");
			mapSQLParameter.put("checklist_other_drugs_end", mapStr.get("checklist_other_drugs_end"));
		}
		if(null!=mapStr.get("checklist_other_drugs_num")){
			sql.append(",checklist_other_drugs_num=:checklist_other_drugs_num");
			mapSQLParameter.put("checklist_other_drugs_num", mapStr.get("checklist_other_drugs_num"));
		}
		if(null!=mapStr.get("checklist_inspection_result")){
			sql.append(",checklist_inspection_result=:checklist_inspection_result");
			mapSQLParameter.put("checklist_inspection_result", mapStr.get("checklist_inspection_result"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where checklist_id=:checklist_id");
		mapSQLParameter.put("checklist_id", mapStr.get("checklist_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除问诊记录检验单操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from inquiry_log_checklist where checklist_id=:checklist_id");
		mapSQLParameter.put("checklist_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		sql.delete(0, sql.length());
		sql.append("delete from inquiry_log_checklist_details where checklist_id=:checklist_id");
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
	}

	/************************系统生成方法完毕******************************/
}