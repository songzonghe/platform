package com.servicesAdmin.inquiry.log.hospitalization;
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
 * 问诊记录住院建议 service 实现类
 * 操作人： 曾晓
 */ 
@Service("inquiryLogHospitalizationServiceImp")
public class InquiryLogHospitalizationServiceImp implements InquiryLogHospitalizationService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取问诊记录住院建议查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.hospitalization_id,t.hospital_id,t.log_id,t.join_type,t.join_id,t.inquiry_patient_id,t.doctor_id,t.hospitalization_hospital,t.hospitalization_department,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from inquiry_log_hospitalization t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("hospitalization_id"))) {
			sql.append(" and t.hospitalization_id=:hospitalization_id ");
			mapSQLParameter.put("hospitalization_id", mapStr.get("hospitalization_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_id"))) {
				sql.append(" and t.inquiry_patient_id like :inquiry_patient_id");
				mapSQLParameter.put("inquiry_patient_id", "%" + mapStr.get("inquiry_patient_id") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("doctor_id"))) {
				sql.append(" and t.doctor_id like :doctor_id");
				mapSQLParameter.put("doctor_id", "%" + mapStr.get("doctor_id") + "%");
			}
		}
	}

	/**
	 *获取问诊记录住院建议信息列表
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
	 *获取一条问诊记录住院建议信息
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
		sql.append("insert into inquiry_log_hospitalization");
		sql.append("( hospital_id,log_id,join_type,join_id,inquiry_patient_id,doctor_id,hospitalization_hospital,hospitalization_department");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:log_id,:join_type,:join_id,:inquiry_patient_id,:doctor_id,:hospitalization_hospital,:hospitalization_department");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		mapSQLParameter.put("join_type", mapStr.get("join_type"));
		mapSQLParameter.put("join_id", mapStr.get("join_id"));
		mapSQLParameter.put("inquiry_patient_id", mapStr.get("inquiry_patient_id"));
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("hospitalization_hospital", mapStr.get("hospitalization_hospital"));
		mapSQLParameter.put("hospitalization_department", mapStr.get("hospitalization_department"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("hospitalization_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改问诊记录住院建议操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update inquiry_log_hospitalization set gxsj=:gxsj");
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
		if(null!=mapStr.get("hospitalization_hospital")){
			sql.append(",hospitalization_hospital=:hospitalization_hospital");
			mapSQLParameter.put("hospitalization_hospital", mapStr.get("hospitalization_hospital"));
		}
		if(null!=mapStr.get("hospitalization_department")){
			sql.append(",hospitalization_department=:hospitalization_department");
			mapSQLParameter.put("hospitalization_department", mapStr.get("hospitalization_department"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where hospitalization_id=:hospitalization_id");
		mapSQLParameter.put("hospitalization_id", mapStr.get("hospitalization_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除问诊记录住院建议操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from inquiry_log_hospitalization where hospitalization_id=:hospitalization_id");
		mapSQLParameter.put("hospitalization_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}