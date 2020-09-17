package com.servicesAdmin.util.health.guidance;
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
 * 健康指导模板 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilHealthGuidanceServiceImp")
public class UtilHealthGuidanceServiceImp implements UtilHealthGuidanceService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取健康指导模板查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.guidance_id,t.icd_id,i.icd_name,t.diagnosis_id,s.diagnosis_name,t.doctor_id,d.doctor_name,t.guidance_content,t.guidance_name,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_health_guidance t,util_diagnosis s,util_icd i,doctor_info d where 1=1");
		sql.append(" and t.diagnosis_id=s.diagnosis_id and t.icd_id=i.icd_id and t.doctor_id=d.doctor_id and s.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("guidance_id"))) {
			sql.append(" and t.guidance_id=:guidance_id ");
			mapSQLParameter.put("guidance_id", mapStr.get("guidance_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("icd_name"))) {
				sql.append(" and i.icd_name like :icd_name");
				mapSQLParameter.put("icd_name", "%" + mapStr.get("icd_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("diagnosis_name"))) {
				sql.append(" and s.diagnosis_name like :diagnosis_name");
				mapSQLParameter.put("diagnosis_name", "%" + mapStr.get("diagnosis_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("guidance_name"))) {
				sql.append(" and t.guidance_name like :guidance_name");
				mapSQLParameter.put("guidance_name", "%" + mapStr.get("guidance_name") + "%");
			}
		}
	}

	/**
	 *获取健康指导模板信息列表
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
	 *获取一条健康指导模板信息
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
		sql.append("insert into util_health_guidance");
		sql.append("( icd_id,diagnosis_id,doctor_id,guidance_content,guidance_name");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :icd_id,:diagnosis_id,:doctor_id,:guidance_content,:guidance_name");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("icd_id", mapStr.get("icd_id"));
		mapSQLParameter.put("diagnosis_id", mapStr.get("diagnosis_id"));
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("guidance_content", mapStr.get("guidance_content"));
		mapSQLParameter.put("guidance_name", mapStr.get("guidance_name"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("guidance_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改健康指导模板操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_health_guidance set gxsj=:gxsj");
		if(null!=mapStr.get("icd_id")){
			sql.append(",icd_id=:icd_id");
			mapSQLParameter.put("icd_id", mapStr.get("icd_id"));
		}
		if(null!=mapStr.get("diagnosis_id")){
			sql.append(",diagnosis_id=:diagnosis_id");
			mapSQLParameter.put("diagnosis_id", mapStr.get("diagnosis_id"));
		}
		if(null!=mapStr.get("doctor_id")){
			sql.append(",doctor_id=:doctor_id");
			mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		}
		if(null!=mapStr.get("guidance_name")){
			sql.append(",guidance_name=:guidance_name");
			mapSQLParameter.put("guidance_name", mapStr.get("guidance_name"));
		}
		if(null!=mapStr.get("guidance_content")){
			sql.append(",guidance_content=:guidance_content");
			mapSQLParameter.put("guidance_content", mapStr.get("guidance_content"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where guidance_id=:guidance_id");
		mapSQLParameter.put("guidance_id", mapStr.get("guidance_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除健康指导模板操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_health_guidance where guidance_id=:guidance_id");
		mapSQLParameter.put("guidance_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}