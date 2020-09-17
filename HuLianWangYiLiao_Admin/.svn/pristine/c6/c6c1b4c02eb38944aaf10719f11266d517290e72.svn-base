package com.servicesAdmin.inquiry.patient.info;
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
 * 网络医院问诊患者信息 service 实现类
 * 操作人： 曾晓
 */ 
@Service("inquiryPatientInfoServiceImp")
public class InquiryPatientInfoServiceImp implements InquiryPatientInfoService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取网络医院问诊患者信息查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.inquiry_patient_id,t.hospital_id,t.join_type,t.join_id,t.inquiry_patient_type,t.inquiry_patient_img,t.inquiry_patient_name,t.inquiry_patient_idcard,t.inquiry_patient_sex,t.inquiry_patient_birthday,t.inquiry_patient_phone,t.inquiry_patient_marital_status,t.inquiry_patient_weight,inquiry_patient_profession_code,t.inquiry_patient_profession,t.inquiry_patient_address,t.is_drug_allergy,t.iinquiry_patient_allergy_details,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from inquiry_patient_info t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_id"))) {
			sql.append(" and t.inquiry_patient_id=:inquiry_patient_id ");
			mapSQLParameter.put("inquiry_patient_id", mapStr.get("inquiry_patient_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				sql.append(" and t.hospital_id = :hospital_id");
				mapSQLParameter.put("hospital_id",  mapStr.get("hospital_id") );
			}
			if (UtilValiDate.isEmpty(mapStr.get("join_type"))) {
				sql.append(" and t.join_type = :join_type");
				mapSQLParameter.put("join_type",  mapStr.get("join_type"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("join_id"))) {
				sql.append(" and t.join_id like :join_id");
				mapSQLParameter.put("join_id", "%" + mapStr.get("join_id") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_type"))) {
				sql.append(" and t.inquiry_patient_type = :inquiry_patient_type");
				mapSQLParameter.put("inquiry_patient_type",  mapStr.get("inquiry_patient_type"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_name"))) {
				sql.append(" and t.inquiry_patient_name like :inquiry_patient_name");
				mapSQLParameter.put("inquiry_patient_name", "%" + mapStr.get("inquiry_patient_name") + "%");
			}
		}
	}

	/**
	 *获取网络医院问诊患者信息信息列表
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
	 *获取一条网络医院问诊患者信息信息
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
		sql.append("insert into inquiry_patient_info");
		sql.append("( hospital_id,join_type,join_id,inquiry_patient_type,inquiry_patient_img,inquiry_patient_name,inquiry_patient_idcard,inquiry_patient_sex,inquiry_patient_birthday,inquiry_patient_phone,inquiry_patient_marital_status,inquiry_patient_weight,inquiry_patient_profession_code,inquiry_patient_profession,inquiry_patient_address,is_drug_allergy,iinquiry_patient_allergy_details");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:join_type,:join_id,:inquiry_patient_type,:inquiry_patient_img,:inquiry_patient_name,:inquiry_patient_idcard,:inquiry_patient_sex,:inquiry_patient_birthday,:inquiry_patient_phone,:inquiry_patient_marital_status,:inquiry_patient_weight,:inquiry_patient_profession_code,:inquiry_patient_profession,:inquiry_patient_address,:is_drug_allergy,:iinquiry_patient_allergy_details");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("join_type", mapStr.get("join_type"));
		mapSQLParameter.put("join_id", mapStr.get("join_id"));
		mapSQLParameter.put("inquiry_patient_type", mapStr.get("inquiry_patient_type"));
		mapSQLParameter.put("inquiry_patient_img", mapStr.get("inquiry_patient_img"));
		mapSQLParameter.put("inquiry_patient_name", mapStr.get("inquiry_patient_name"));
		mapSQLParameter.put("inquiry_patient_idcard", mapStr.get("inquiry_patient_idcard"));
		mapSQLParameter.put("inquiry_patient_sex", mapStr.get("inquiry_patient_sex"));
		mapSQLParameter.put("inquiry_patient_birthday", mapStr.get("inquiry_patient_birthday"));
		mapSQLParameter.put("inquiry_patient_phone", mapStr.get("inquiry_patient_phone"));
		mapSQLParameter.put("inquiry_patient_marital_status", mapStr.get("inquiry_patient_marital_status"));
		mapSQLParameter.put("inquiry_patient_weight", mapStr.get("inquiry_patient_weight"));
		mapSQLParameter.put("inquiry_patient_profession_code", mapStr.get("inquiry_patient_profession_code"));
		mapSQLParameter.put("inquiry_patient_profession", mapStr.get("inquiry_patient_profession"));
		mapSQLParameter.put("inquiry_patient_address", mapStr.get("inquiry_patient_address"));
		mapSQLParameter.put("is_drug_allergy", mapStr.get("is_drug_allergy"));
		mapSQLParameter.put("iinquiry_patient_allergy_details", mapStr.get("iinquiry_patient_allergy_details"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("inquiry_patient_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改网络医院问诊患者信息操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update inquiry_patient_info set gxsj=:gxsj");
		if(null!=mapStr.get("join_type")){
			sql.append(",join_type=:join_type");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		if(null!=mapStr.get("join_id")){
			sql.append(",join_id=:join_id");
			mapSQLParameter.put("join_id", mapStr.get("join_id"));
		}
		if(null!=mapStr.get("inquiry_patient_type")){
			sql.append(",inquiry_patient_type=:inquiry_patient_type");
			mapSQLParameter.put("inquiry_patient_type", mapStr.get("inquiry_patient_type"));
		}
		if(null!=mapStr.get("inquiry_patient_img")){
			sql.append(",inquiry_patient_img=:inquiry_patient_img");
			mapSQLParameter.put("inquiry_patient_img", mapStr.get("inquiry_patient_img"));
		}
		if(null!=mapStr.get("inquiry_patient_name")){
			sql.append(",inquiry_patient_name=:inquiry_patient_name");
			mapSQLParameter.put("inquiry_patient_name", mapStr.get("inquiry_patient_name"));
		}
		if(null!=mapStr.get("inquiry_patient_idcard")){
			sql.append(",inquiry_patient_idcard=:inquiry_patient_idcard");
			mapSQLParameter.put("inquiry_patient_idcard", mapStr.get("inquiry_patient_idcard"));
		}
		if(null!=mapStr.get("inquiry_patient_sex")){
			sql.append(",inquiry_patient_sex=:inquiry_patient_sex");
			mapSQLParameter.put("inquiry_patient_sex", mapStr.get("inquiry_patient_sex"));
		}
		if(null!=mapStr.get("inquiry_patient_birthday")){
			sql.append(",inquiry_patient_birthday=:inquiry_patient_birthday");
			mapSQLParameter.put("inquiry_patient_birthday", mapStr.get("inquiry_patient_birthday"));
		}
		if(null!=mapStr.get("inquiry_patient_phone")){
			sql.append(",inquiry_patient_phone=:inquiry_patient_phone");
			mapSQLParameter.put("inquiry_patient_phone", mapStr.get("inquiry_patient_phone"));
		}
		if(null!=mapStr.get("inquiry_patient_marital_status")){
			sql.append(",inquiry_patient_marital_status=:inquiry_patient_marital_status");
			mapSQLParameter.put("inquiry_patient_marital_status", mapStr.get("inquiry_patient_marital_status"));
		}
		if(null!=mapStr.get("inquiry_patient_weight")){
			sql.append(",inquiry_patient_weight=:inquiry_patient_weight");
			mapSQLParameter.put("inquiry_patient_weight", mapStr.get("inquiry_patient_weight"));
		}
		if(null!=mapStr.get("inquiry_patient_profession_code")){
			sql.append(",inquiry_patient_profession_code=:inquiry_patient_profession_code");
			mapSQLParameter.put("inquiry_patient_profession_code", mapStr.get("inquiry_patient_profession_code"));
		}
		if(null!=mapStr.get("inquiry_patient_profession")){
			sql.append(",inquiry_patient_profession=:inquiry_patient_profession");
			mapSQLParameter.put("inquiry_patient_profession", mapStr.get("inquiry_patient_profession"));
		}
		if(null!=mapStr.get("inquiry_patient_address")){
			sql.append(",inquiry_patient_address=:inquiry_patient_address");
			mapSQLParameter.put("inquiry_patient_address", mapStr.get("inquiry_patient_address"));
		}
		if(null!=mapStr.get("is_drug_allergy")){
			sql.append(",is_drug_allergy=:is_drug_allergy");
			mapSQLParameter.put("is_drug_allergy", mapStr.get("is_drug_allergy"));
		}
		if(null!=mapStr.get("iinquiry_patient_allergy_details")){
			sql.append(",iinquiry_patient_allergy_details=:iinquiry_patient_allergy_details");
			mapSQLParameter.put("iinquiry_patient_allergy_details", mapStr.get("iinquiry_patient_allergy_details"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where inquiry_patient_id=:inquiry_patient_id");
		mapSQLParameter.put("inquiry_patient_id", mapStr.get("inquiry_patient_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除网络医院问诊患者信息操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from inquiry_patient_info where inquiry_patient_id=:inquiry_patient_id");
		mapSQLParameter.put("inquiry_patient_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}
	
	/**
	 *获取问诊患者list
	 */
	public List<Map<String, Object>> patientList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.inquiry_patient_id,t.hospital_id,t.join_type,t.join_id,t.inquiry_patient_type,t.inquiry_patient_img,t.inquiry_patient_name,t.inquiry_patient_idcard,t.inquiry_patient_sex,t.inquiry_patient_birthday,t.inquiry_patient_phone,t.inquiry_patient_marital_status,t.inquiry_patient_weight,t.inquiry_patient_profession_code,t.inquiry_patient_profession,t.inquiry_patient_address,t.is_drug_allergy,t.iinquiry_patient_allergy_details,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from inquiry_patient_info t where 1=1");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}

	/************************系统生成方法完毕******************************/
}