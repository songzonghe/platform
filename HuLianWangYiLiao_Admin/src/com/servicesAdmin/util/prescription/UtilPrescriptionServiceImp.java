package com.servicesAdmin.util.prescription;
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
 * 处方模板 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilPrescriptionServiceImp")
public class UtilPrescriptionServiceImp implements UtilPrescriptionService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取处方模板查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("SELECT p.prescription_id,p.icd_id,p.hospital_id,p.diagnosis_id,p.prescription_name,p.doctor_id,p.prescription_type,p.prescription_price,p.prescription_num,p.prescription_taking,p.prescription_requirements,p.lrsj,p.lrzh,p.zt,p.bz,p.gxsj,d.icd_name,s.diagnosis_name,i.doctor_name");
		sql.append(" FROM util_prescription p,util_icd d ,util_diagnosis s,doctor_info i");
		sql.append(" WHERE p.icd_id=d.icd_id and p.diagnosis_id=s.diagnosis_id and p.doctor_id=i.doctor_id and p.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("prescription_id"))) {
			sql.append(" and p.prescription_id=:prescription_id ");
			mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("icd_name"))) {
				sql.append(" and d.icd_name like :icd_name");
				mapSQLParameter.put("icd_name", "%" + mapStr.get("icd_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("diagnosis_name"))) {
				sql.append(" and s.diagnosis_name like :diagnosis_name");
				mapSQLParameter.put("diagnosis_name", "%" + mapStr.get("diagnosis_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
				sql.append(" and i.doctor_name like :doctor_name");
				mapSQLParameter.put("doctor_name", "%" + mapStr.get("doctor_name") + "%");
			}
		}
	}

	/**
	 *获取处方模板信息列表
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
	 *获取一条处方模板信息
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
		sql.append("insert into util_prescription");
		sql.append("( icd_id,hospital_id,diagnosis_id,doctor_id,prescription_type,prescription_price");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :icd_id,:hospital_id,:diagnosis_id,:doctor_id,:prescription_type,:prescription_price");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("icd_id", mapStr.get("icd_id"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("diagnosis_id", mapStr.get("diagnosis_id"));
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("prescription_type", mapStr.get("prescription_type"));
		mapSQLParameter.put("prescription_price", mapStr.get("prescription_price"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("prescription_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改处方模板操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_prescription set gxsj=:gxsj");
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
		if(null!=mapStr.get("prescription_type")){
			sql.append(",prescription_type=:prescription_type");
			mapSQLParameter.put("prescription_type", mapStr.get("prescription_type"));
		}
		if(null!=mapStr.get("prescription_price")){
			sql.append(",prescription_price=:prescription_price");
			mapSQLParameter.put("prescription_price", mapStr.get("prescription_price"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where prescription_id=:prescription_id");
		mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除处方模板操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_prescription where prescription_id=:prescription_id");
		mapSQLParameter.put("prescription_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		sql.delete(0, sql.length());
		sql.append("delete from util_prescription_details where prescription_id=:prescription_id");
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
	}
	
	/**
	*获取list
	 */
	public List<Map<String, Object>> prescriptionList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("SELECT p.prescription_id,p.icd_id,p.hospital_id,p.diagnosis_id,p.prescription_name,p.doctor_id,p.prescription_type,p.prescription_price,p.prescription_num,p.prescription_taking,p.prescription_requirements,p.lrsj,p.lrzh,p.zt,p.bz,p.gxsj");
		sql.append(" FROM util_prescription p where 1=1");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
		}

	/************************系统生成方法完毕******************************/
	
	
	/**
	*获取诊断不带分页list
	 */
	public List<Map<String, Object>> find_diagnosisList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.diagnosis_id,t.icd_id,t.hospital_id,t.diagnosis_name,t.doctor_id,t.diagnosis_sex,t.diagnosis_dage,t.diagnosis_tage,t.is_restriction,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(" from util_diagnosis t where t.hospital_id=:hospital_id ");
		sql.append(" order by t.diagnosis_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	
	
	/**
	*获取医生不带分页list
	 */
	public List<Map<String, Object>> find_doctorList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.doctor_id,t.hospital_id,t.doctor_phone,t.doctor_paw,t.doctor_openid,t.doctor_name,t.doctor_img,t.doctor_autograph,t.doctor_sex,t.doctot_job_title,t.doctor_work_address,t.department_id,t.doctot_work_day,t.doctot_birthday,t.doctor_document_number,t.doctor_document_img1,t.doctor_document_img2,t.doctor_medical_practitioner_certificate,t.doctor_medical_licence,t.doctor_technical_certificate,t.doctor_begoodat,t.doctor_synopsis,t.doctor_sort,t.is_online,t.doctor_im,t.last_logon_time,t.last_refresh_time,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(" from doctor_info t where hospital_id=:hospital_id ");
		sql.append(" order by t.doctor_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
}