package com.servicesAdmin.util.diagnosis;
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
 * 诊段模板以及规范 service 实现类
 * 操作人： 苏洪伟
 */ 
@Service("utilDiagnosisServiceImp")
public class UtilDiagnosisServiceImp implements UtilDiagnosisService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取诊段模板以及规范查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.diagnosis_id,t.icd_id,i.icd_name,t.hospital_id,t.diagnosis_name,t.doctor_id,d.doctor_name,t.diagnosis_sex,t.diagnosis_dage,t.diagnosis_tage,t.is_restriction,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_diagnosis t,util_icd i,doctor_info d where 1=1 and t.icd_id=i.icd_id and t.doctor_id=d.doctor_id and t.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("diagnosis_id"))) {
			sql.append(" and t.diagnosis_id=:diagnosis_id ");
			mapSQLParameter.put("diagnosis_id", mapStr.get("diagnosis_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("icd_name"))) {
				sql.append(" and i.icd_name like :icd_name");
				mapSQLParameter.put("icd_name", "%" + mapStr.get("icd_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("diagnosis_name"))) {
				sql.append(" and t.diagnosis_name like :diagnosis_name");
				mapSQLParameter.put("diagnosis_name", "%" + mapStr.get("diagnosis_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
				sql.append(" and d.doctor_name like :doctor_name");
				mapSQLParameter.put("doctor_name", "%" + mapStr.get("doctor_name") + "%");
			}
		}
	}

	/**
	 *获取诊段模板以及规范信息列表
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
	 *获取一条诊段模板以及规范信息
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
		sql.append("insert into util_diagnosis");
		sql.append("( hospital_id,icd_id,diagnosis_name,doctor_id,diagnosis_sex,diagnosis_dage,diagnosis_tage,is_restriction");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:icd_id,:diagnosis_name,:doctor_id,:diagnosis_sex,:diagnosis_dage,:diagnosis_tage,:is_restriction");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("icd_id", mapStr.get("icd_id"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("diagnosis_name", mapStr.get("diagnosis_name"));
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("diagnosis_sex", mapStr.get("diagnosis_sex"));
		mapSQLParameter.put("diagnosis_dage", mapStr.get("diagnosis_dage"));
		mapSQLParameter.put("diagnosis_tage", mapStr.get("diagnosis_tage"));
		mapSQLParameter.put("is_restriction", mapStr.get("is_restriction"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("diagnosis_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改诊段模板以及规范操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_diagnosis set gxsj=:gxsj");
		if(null!=mapStr.get("icd_id")){
			sql.append(",icd_id=:icd_id");
			mapSQLParameter.put("icd_id", mapStr.get("icd_id"));
		}
		if(null!=mapStr.get("hospital_id")){
			sql.append(",hospital_id=:hospital_id");
			mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		}
		if(null!=mapStr.get("diagnosis_name")){
			sql.append(",diagnosis_name=:diagnosis_name");
			mapSQLParameter.put("diagnosis_name", mapStr.get("diagnosis_name"));
		}
		if(null!=mapStr.get("doctor_id")){
			sql.append(",doctor_id=:doctor_id");
			mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		}
		if(null!=mapStr.get("diagnosis_sex")){
			sql.append(",diagnosis_sex=:diagnosis_sex");
			mapSQLParameter.put("diagnosis_sex", mapStr.get("diagnosis_sex"));
		}
		if(null!=mapStr.get("diagnosis_dage")){
			sql.append(",diagnosis_dage=:diagnosis_dage");
			mapSQLParameter.put("diagnosis_dage", mapStr.get("diagnosis_dage"));
		}
		if(null!=mapStr.get("diagnosis_tage")){
			sql.append(",diagnosis_tage=:diagnosis_tage");
			mapSQLParameter.put("diagnosis_tage", mapStr.get("diagnosis_tage"));
		}
		if(null!=mapStr.get("is_restriction")){
			sql.append(",is_restriction=:is_restriction");
			mapSQLParameter.put("is_restriction", mapStr.get("is_restriction"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where diagnosis_id=:diagnosis_id");
		mapSQLParameter.put("diagnosis_id", mapStr.get("diagnosis_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除诊段模板以及规范操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_diagnosis where diagnosis_id=:diagnosis_id");
		mapSQLParameter.put("diagnosis_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
	
	public Map<String, List<Map<String, Object>>> getParamListMap() throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, List<Map<String, Object>>> retMapListMap = new HashMap<String, List<Map<String, Object>>>();
		//疾病分类
		sql.append("select icd_id,icd_name from util_icd ");
		retMapListMap.put("icdList", this.gyDAOimp.findSqlList(sql, null));
		//诊断模板
		sql.delete(0, sql.length());
		sql.append("select diagnosis_id,diagnosis_name from util_diagnosis ");
		retMapListMap.put("diagnosisList", this.gyDAOimp.findSqlList(sql, null));
		//医生信息
		sql.delete(0, sql.length());
		sql.append("select doctor_id,doctor_name from doctor_info ");
		retMapListMap.put("doctorList", this.gyDAOimp.findSqlList(sql, null));
		return retMapListMap;
	}
	
}