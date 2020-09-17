package com.servicesAdmin.doctor.drug;
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
 * 我的用药 service 实现类
 * 操作人： 曾晓
 */ 
@Service("doctorDrugServiceImp")
public class DoctorDrugServiceImp implements DoctorDrugService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取我的用药查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.doctor_drug_id,t.hospital_id,t.doctor_id,t.drug_id,t.drug_type,t.doctor_drug_consumption,t.doctor_drug_frequency_str,t.doctor_drug_frequency,t.doctor_drug_day,t.doctor_drug_num,t.doctor_drug_usage,t.doctor_drug_entrust,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from doctor_drug t where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("doctor_drug_id"))) {
			sql.append(" and t.doctor_drug_id=:doctor_drug_id ");
			mapSQLParameter.put("doctor_drug_id", mapStr.get("doctor_drug_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				sql.append(" and t.hospital_id = :hospital_id");
				mapSQLParameter.put("hospital_id",  mapStr.get("hospital_id") );
			}
			if (UtilValiDate.isEmpty(mapStr.get("doctor_id"))) {
				sql.append(" and t.doctor_id like :doctor_id");
				mapSQLParameter.put("doctor_id", "%" + mapStr.get("doctor_id") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("drug_id"))) {
				sql.append(" and t.drug_id like :drug_id");
				mapSQLParameter.put("drug_id", "%" + mapStr.get("drug_id") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("drug_type"))) {
				sql.append(" and t.drug_type = :drug_type");
				mapSQLParameter.put("drug_type",  mapStr.get("drug_type"));
			}
		}
	}

	/**
	 *获取我的用药信息列表
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
	 *获取一条我的用药信息
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
		sql.append("insert into doctor_drug");
		sql.append("( hospital_id,doctor_id,drug_id,drug_type,doctor_drug_consumption,doctor_drug_frequency_str,doctor_drug_frequency,doctor_drug_day,doctor_drug_num,doctor_drug_usage,doctor_drug_entrust");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:doctor_id,:drug_id,:drug_type,:doctor_drug_consumption,:doctor_drug_frequency_str,:doctor_drug_frequency,:doctor_drug_day,:doctor_drug_num,:doctor_drug_usage,:doctor_drug_entrust");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("drug_id", mapStr.get("drug_id"));
		mapSQLParameter.put("drug_type", mapStr.get("drug_type"));
		mapSQLParameter.put("doctor_drug_consumption", mapStr.get("doctor_drug_consumption"));
		mapSQLParameter.put("doctor_drug_frequency_str", mapStr.get("doctor_drug_frequency_str"));
		mapSQLParameter.put("doctor_drug_frequency", mapStr.get("doctor_drug_frequency"));
		mapSQLParameter.put("doctor_drug_day", mapStr.get("doctor_drug_day"));
		mapSQLParameter.put("doctor_drug_num", mapStr.get("doctor_drug_num"));
		mapSQLParameter.put("doctor_drug_usage", mapStr.get("doctor_drug_usage"));
		mapSQLParameter.put("doctor_drug_entrust", mapStr.get("doctor_drug_entrust"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("doctor_drug_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改我的用药操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update doctor_drug set gxsj=:gxsj");
		if(null!=mapStr.get("doctor_id")){
			sql.append(",doctor_id=:doctor_id");
			mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		}
		if(null!=mapStr.get("drug_id")){
			sql.append(",drug_id=:drug_id");
			mapSQLParameter.put("drug_id", mapStr.get("drug_id"));
		}
		if(null!=mapStr.get("drug_type")){
			sql.append(",drug_type=:drug_type");
			mapSQLParameter.put("drug_type", mapStr.get("drug_type"));
		}
		if(null!=mapStr.get("doctor_drug_consumption")){
			sql.append(",doctor_drug_consumption=:doctor_drug_consumption");
			mapSQLParameter.put("doctor_drug_consumption", mapStr.get("doctor_drug_consumption"));
		}
		if(null!=mapStr.get("doctor_drug_frequency_str")){
			sql.append(",doctor_drug_frequency_str=:doctor_drug_frequency_str");
			mapSQLParameter.put("doctor_drug_frequency_str", mapStr.get("doctor_drug_frequency_str"));
		}
		if(null!=mapStr.get("doctor_drug_frequency")){
			sql.append(",doctor_drug_frequency=:doctor_drug_frequency");
			mapSQLParameter.put("doctor_drug_frequency", mapStr.get("doctor_drug_frequency"));
		}
		if(null!=mapStr.get("doctor_drug_day")){
			sql.append(",doctor_drug_day=:doctor_drug_day");
			mapSQLParameter.put("doctor_drug_day", mapStr.get("doctor_drug_day"));
		}
		if(null!=mapStr.get("doctor_drug_num")){
			sql.append(",doctor_drug_num=:doctor_drug_num");
			mapSQLParameter.put("doctor_drug_num", mapStr.get("doctor_drug_num"));
		}
		if(null!=mapStr.get("doctor_drug_usage")){
			sql.append(",doctor_drug_usage=:doctor_drug_usage");
			mapSQLParameter.put("doctor_drug_usage", mapStr.get("doctor_drug_usage"));
		}
		if(null!=mapStr.get("doctor_drug_entrust")){
			sql.append(",doctor_drug_entrust=:doctor_drug_entrust");
			mapSQLParameter.put("doctor_drug_entrust", mapStr.get("doctor_drug_entrust"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where doctor_drug_id=:doctor_drug_id");
		mapSQLParameter.put("doctor_drug_id", mapStr.get("doctor_drug_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除我的用药操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from doctor_drug where doctor_drug_id=:doctor_drug_id");
		mapSQLParameter.put("doctor_drug_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}