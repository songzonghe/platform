package com.servicesAdmin.inquiry.patient.measured.data;
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
 * 问诊患者测量数据 service 实现类
 * 操作人： 曾晓
 */ 
@Service("inquiryPatientMeasuredDataServiceImp")
public class InquiryPatientMeasuredDataServiceImp implements InquiryPatientMeasuredDataService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取问诊患者测量数据查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.data_id,t.hospital_id,t.inquiry_patient_id,t.join_type,t.join_id,t.data_animal_heat,t.data_sbp,t.data_dbp,t.data_heart_rate,t.data_rr,t.data_glu,t.data_condition,t.data_parameter,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from inquiry_patient_measured_data t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("data_id"))) {
			sql.append(" and t.data_id=:data_id ");
			mapSQLParameter.put("data_id", mapStr.get("data_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				sql.append(" and t.hospital_id = :hospital_id");
				mapSQLParameter.put("hospital_id",  mapStr.get("hospital_id") );
			}
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_id"))) {
				sql.append(" and t.inquiry_patient_id like :inquiry_patient_id");
				mapSQLParameter.put("inquiry_patient_id", "%" + mapStr.get("inquiry_patient_id") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("join_type"))) {
				sql.append(" and t.join_type = :join_type");
				mapSQLParameter.put("join_type",  mapStr.get("join_type"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("join_id"))) {
				sql.append(" and t.join_id like :join_id");
				mapSQLParameter.put("join_id", "%" + mapStr.get("join_id") + "%");
			}
		}
	}

	/**
	 *获取问诊患者测量数据信息列表
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
	 *获取一条问诊患者测量数据信息
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
		sql.append("insert into inquiry_patient_measured_data");
		sql.append("( hospital_id,inquiry_patient_id,join_type,join_id,data_animal_heat,data_sbp,data_dbp,data_heart_rate,data_rr,data_glu,data_condition,data_parameter");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:inquiry_patient_id,:join_type,:join_id,:data_animal_heat,:data_sbp,:data_dbp,:data_heart_rate,:data_rr,:data_glu,:data_condition,:data_parameter");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("inquiry_patient_id", mapStr.get("inquiry_patient_id"));
		mapSQLParameter.put("join_type", mapStr.get("join_type"));
		mapSQLParameter.put("join_id", mapStr.get("join_id"));
		mapSQLParameter.put("data_animal_heat", mapStr.get("data_animal_heat"));
		mapSQLParameter.put("data_sbp", mapStr.get("data_sbp"));
		mapSQLParameter.put("data_dbp", mapStr.get("data_dbp"));
		mapSQLParameter.put("data_heart_rate", mapStr.get("data_heart_rate"));
		mapSQLParameter.put("data_rr", mapStr.get("data_rr"));
		mapSQLParameter.put("data_glu", mapStr.get("data_glu"));
		mapSQLParameter.put("data_condition", mapStr.get("data_condition"));
		mapSQLParameter.put("data_parameter", mapStr.get("data_parameter"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("data_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改问诊患者测量数据操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update inquiry_patient_measured_data set gxsj=:gxsj");
		if(null!=mapStr.get("inquiry_patient_id")){
			sql.append(",inquiry_patient_id=:inquiry_patient_id");
			mapSQLParameter.put("inquiry_patient_id", mapStr.get("inquiry_patient_id"));
		}
		if(null!=mapStr.get("join_type")){
			sql.append(",join_type=:join_type");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		if(null!=mapStr.get("join_id")){
			sql.append(",join_id=:join_id");
			mapSQLParameter.put("join_id", mapStr.get("join_id"));
		}
		if(null!=mapStr.get("data_animal_heat")){
			sql.append(",data_animal_heat=:data_animal_heat");
			mapSQLParameter.put("data_animal_heat", mapStr.get("data_animal_heat"));
		}
		if(null!=mapStr.get("data_sbp")){
			sql.append(",data_sbp=:data_sbp");
			mapSQLParameter.put("data_sbp", mapStr.get("data_sbp"));
		}
		if(null!=mapStr.get("data_dbp")){
			sql.append(",data_dbp=:data_dbp");
			mapSQLParameter.put("data_dbp", mapStr.get("data_dbp"));
		}
		if(null!=mapStr.get("data_heart_rate")){
			sql.append(",data_heart_rate=:data_heart_rate");
			mapSQLParameter.put("data_heart_rate", mapStr.get("data_heart_rate"));
		}
		if(null!=mapStr.get("data_rr")){
			sql.append(",data_rr=:data_rr");
			mapSQLParameter.put("data_rr", mapStr.get("data_rr"));
		}
		if(null!=mapStr.get("data_glu")){
			sql.append(",data_glu=:data_glu");
			mapSQLParameter.put("data_glu", mapStr.get("data_glu"));
		}
		if(null!=mapStr.get("data_condition")){
			sql.append(",data_condition=:data_condition");
			mapSQLParameter.put("data_condition", mapStr.get("data_condition"));
		}
		if(null!=mapStr.get("data_parameter")){
			sql.append(",data_parameter=:data_parameter");
			mapSQLParameter.put("data_parameter", mapStr.get("data_parameter"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where data_id=:data_id");
		mapSQLParameter.put("data_id", mapStr.get("data_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除问诊患者测量数据操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from inquiry_patient_measured_data where data_id=:data_id");
		mapSQLParameter.put("data_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}