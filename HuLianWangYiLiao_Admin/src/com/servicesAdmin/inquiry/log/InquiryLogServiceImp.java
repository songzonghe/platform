package com.servicesAdmin.inquiry.log;
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
 * 网络医院问诊记录 service 实现类
 * 操作人： 曾晓
 */ 
@Service("inquiryLogServiceImp")
public class InquiryLogServiceImp implements InquiryLogService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取网络医院问诊记录查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.log_id,t.hospital_id,t.log_type,t.join_type,t.join_id,t.inquiry_patient_id,t.doctor_id,t.log_source,t.log_main_suit,t.log_present_illness,t.log_history_present_illness,t.lof_diagnosis,t.lof_proposal,t.unprescribed_reasons,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh,p.inquiry_patient_name,d.doctor_name");
		sql.append(" from inquiry_log t,inquiry_patient_info p,doctor_info d");
		sql.append(" where t.inquiry_patient_id=p.inquiry_patient_id and t.doctor_id=d.doctor_id and t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("log_id"))) {
			sql.append(" and t.log_id=:log_id ");
			mapSQLParameter.put("log_id", mapStr.get("log_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_name"))) {
				sql.append(" and p.inquiry_patient_name like :inquiry_patient_name");
				mapSQLParameter.put("inquiry_patient_name", "%" + mapStr.get("inquiry_patient_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
				sql.append(" and d.doctor_name like :doctor_name");
				mapSQLParameter.put("doctor_name", "%" + mapStr.get("doctor_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("find_zt"))) {
				sql.append(" and t.zt = :find_zt");
				mapSQLParameter.put("find_zt",mapStr.get("find_zt"));
			}
		}
	}

	/**
	 *获取网络医院问诊记录信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		if (!UtilValiDate.isEmpty(mapStr.get(SysFinal.ISSORT_KEY))){ //由于从菜单进入没有带入参数，这里给入判断进行开启排序
			mapStr.put(SysFinal.ISSORT_KEY,"y");
		}
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	/**
	 *获取一条网络医院问诊记录信息
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
		sql.append("insert into inquiry_log");
		sql.append("( hospital_id,log_type,join_type,join_id,inquiry_patient_id,doctor_id,log_source,log_main_suit,log_present_illness,log_history_present_illness,lof_diagnosis,lof_proposal");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:log_type,:join_type,:join_id,:inquiry_patient_id,:doctor_id,:log_source,:log_main_suit,:log_present_illness,:log_history_present_illness,:lof_diagnosis,:lof_proposal");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("log_type", mapStr.get("log_type"));
		mapSQLParameter.put("join_type", mapStr.get("join_type"));
		mapSQLParameter.put("join_id", mapStr.get("join_id"));
		mapSQLParameter.put("inquiry_patient_id", mapStr.get("inquiry_patient_id"));
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("log_source", mapStr.get("log_source"));
		mapSQLParameter.put("log_main_suit", mapStr.get("log_main_suit"));
		mapSQLParameter.put("log_present_illness", mapStr.get("log_present_illness"));
		mapSQLParameter.put("log_history_present_illness", mapStr.get("log_history_present_illness"));
		mapSQLParameter.put("lof_diagnosis", mapStr.get("lof_diagnosis"));
		mapSQLParameter.put("lof_proposal", mapStr.get("lof_proposal"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("log_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改网络医院问诊记录操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update inquiry_log set gxsj=:gxsj");
		if(null!=mapStr.get("log_type")){
			sql.append(",log_type=:log_type");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
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
		if(null!=mapStr.get("log_source")){
			sql.append(",log_source=:log_source");
			mapSQLParameter.put("log_source", mapStr.get("log_source"));
		}
		if(null!=mapStr.get("log_main_suit")){
			sql.append(",log_main_suit=:log_main_suit");
			mapSQLParameter.put("log_main_suit", mapStr.get("log_main_suit"));
		}
		if(null!=mapStr.get("log_present_illness")){
			sql.append(",log_present_illness=:log_present_illness");
			mapSQLParameter.put("log_present_illness", mapStr.get("log_present_illness"));
		}
		if(null!=mapStr.get("log_history_present_illness")){
			sql.append(",log_history_present_illness=:log_history_present_illness");
			mapSQLParameter.put("log_history_present_illness", mapStr.get("log_history_present_illness"));
		}
		if(null!=mapStr.get("lof_diagnosis")){
			sql.append(",lof_diagnosis=:lof_diagnosis");
			mapSQLParameter.put("lof_diagnosis", mapStr.get("lof_diagnosis"));
		}
		if(null!=mapStr.get("lof_proposal")){
			sql.append(",lof_proposal=:lof_proposal");
			mapSQLParameter.put("lof_proposal", mapStr.get("lof_proposal"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where log_id=:log_id");
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除网络医院问诊记录操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from inquiry_log where log_id=:log_id");
		mapSQLParameter.put("log_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}
	
	
	/**
	 * 获取问诊记录的详细信息
	 */
	public List<Map<String, Object>> find_inquiryLogLists(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		// 1.问诊记录健康指导 2.问诊记录检验单 3.问诊记录检验检查单详情 4.问诊记录处方详情5.问诊记录处方6.问诊记录住院建议7.问诊记录上传图片
		sql.append("select t.* from(");
		if (!UtilValiDate.isEmpty(mapStr.get("data_type")) || "1".equals(mapStr.get("data_type"))) {
			sql.append(" SELECT t.* FROM( ");
			sql.append(" select g.guidance_id,g.hospital_id,g.log_id,g.join_type,g.join_id,g.inquiry_patient_id,g.doctor_id,g.guidance_content,g.gxsj,g.bz,g.lrsj,g.zt,g.lrzh,u.user_nickname,d.doctor_name");
			sql.append(" from inquiry_log_health_guidance g,user_info u,doctor_info d ");
			sql.append(" where  g.join_type=1 and g.join_id=u.user_id and g.doctor_id=d.doctor_id");
			sql.append(" union all ");
			sql.append(" select g.guidance_id,g.hospital_id,g.log_id,g.join_type,g.join_id,g.inquiry_patient_id,g.doctor_id,g.guidance_content,g.gxsj,g.bz,g.lrsj,g.zt,g.lrzh,s.store_name,d.doctor_name");
			sql.append(" from inquiry_log_health_guidance g,store_info s,doctor_info d ");
			sql.append(" where  g.join_type=2 and g.join_id=s.store_id and g.doctor_id=d.doctor_id )t  where 1=1 ");
			if (UtilValiDate.isEmpty(mapStr.get("drug_name"))) {
				sql.append(" and  t.doctor_name like:drug_name ");
				mapSQLParameter.put("drug_name", "%" + mapStr.get("drug_name") + "%");
			}
		}/* 检查单 */
		else if ("2".equals(mapStr.get("data_type"))) {
			sql.append("SELECT c.checklist_id,c.log_id,c.inquiry_patient_id,c.doctor_id,c.checklist_other_drugs_name,c.checklist_inspection_result,c.gxsj,c.bz,c.lrsj,c.zt,c.lrzh,d.doctor_name,p.inquiry_patient_name");
			sql.append(" FROM inquiry_log_checklist c,doctor_info d,inquiry_patient_info p");
			sql.append(" WHERE c.doctor_id=d.doctor_id and c.inquiry_patient_id=p.inquiry_patient_id");
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_name"))) {
				sql.append(" and  p.inquiry_patient_name=:inquiry_patient_name ");
				mapSQLParameter.put("inquiry_patient_name", mapStr.get("inquiry_patient_name"));
			}
			
		}/* 检查详情 */
		else if ("3".equals(mapStr.get("data_type"))) {
			sql.append(" SELECT t.* FROM( ");
			sql.append(" SELECT d.checklist_details_id,d.hospital_id,d.checklist_id,d.checklist_type,d.checklist_name,d.lrsj,d.lrzh,d.zt,d.bz,d.gxsj,c.checklist_code");
			sql.append(" FROM inquiry_log_checklist_details d,inquiry_log_checklist c ");
			sql.append(" where  d.checklist_id=c.checklist_id and d.checklist_type=1 ");
			sql.append(" union all ");
			sql.append(" SELECT d.checklist_details_id,d.hospital_id,d.checklist_id,d.checklist_type,d.checklist_name,d.lrsj,d.lrzh,d.zt,d.bz,d.gxsj,c.checklist_code");
			sql.append(" FROM inquiry_log_checklist_details d,inquiry_log_checklist c ");
			sql.append(" where d.checklist_id=c.checklist_id and  d.checklist_type=2  )t where 1=1 ");
			
			if (UtilValiDate.isEmpty(mapStr.get("checklist_code"))) {
				sql.append(" and  t.checklist_code=:checklist_code ");
				mapSQLParameter.put("checklist_code", mapStr.get("checklist_code"));
			}
		}/* 记录处方 */
		else if ("4".equals(mapStr.get("data_type"))) {
			sql.append("select p.prescription_id,p.hospital_id,p.log_id,p.join_type,p.join_id,p.inquiry_patient_id,p.doctor_id,p.prescription_type,p.prescription_price,p.prescription_num,p.prescription_taking,p.prescription_requirements,p.gxsj,p.bz,p.lrsj,p.zt,p.lrzh,f.inquiry_patient_name,d.doctor_name,c.checklist_name");
			sql.append(" from inquiry_log_prescription p,inquiry_patient_info f,doctor_info d,inquiry_log_checklist c");
			sql.append(" where p.inquiry_patient_id=f.inquiry_patient_id and p.doctor_id=d.doctor_id and p.log_id=c.log_id");
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_name"))) {
				sql.append(" and  f.inquiry_patient_name=:inquiry_patient_name ");
				mapSQLParameter.put("inquiry_patient_name", mapStr.get("inquiry_patient_name"));
			}
		}
		/* 处方详情 */
		else if ("5".equals(mapStr.get("data_type"))) {
			sql.append("select d.prescription_details_id,d.hospital_id,d.prescription_id,d.drug_id,details_consumption,d.details_frequency_str,d.details_frequency,d.details_day,d.details_num,d.details_usage,d.details_entrust,d.gxsj,d.bz,d.lrsj,d.zt,d.lrzh,g.drug_name,p.prescription_type");
			sql.append(" from inquiry_log_prescription_details d,util_drug g,inquiry_log_prescription p");
			sql.append(" where d.drug_id=g.drug_id and d.prescription_id=p.prescription_id");
			if (UtilValiDate.isEmpty(mapStr.get("drug_name"))) {
				sql.append(" and  g.drug_name=:drug_name ");
				mapSQLParameter.put("drug_name", mapStr.get("drug_name"));
			}
		}
		/* 住院建议 */
		else if ("6".equals(mapStr.get("data_type"))) {
			sql.append("select h.hospitalization_id,h.hospital_id,h.log_id,h.join_type,h.join_id,h.inquiry_patient_id,h.doctor_id,h.hospitalization_hospital,h.hospitalization_department,h.gxsj,h.bz,h.lrsj,h.zt,h.lrzh,p.inquiry_patient_name,d.doctor_name,g.lof_diagnosis");
			sql.append(" from inquiry_log_hospitalization h,inquiry_patient_info p,doctor_info d,inquiry_log g");
			sql.append(" where h.inquiry_patient_id=p.inquiry_patient_id and h.doctor_id=d.doctor_id and h.log_id=g.log_id");
			if (UtilValiDate.isEmpty(mapStr.get("inquiry_patient_name"))) {
				sql.append(" and  p.inquiry_patient_name=:inquiry_patient_name ");
				mapSQLParameter.put("inquiry_patient_name", mapStr.get("inquiry_patient_name"));
			}
		} /* 上传图片 */
		else if ("7".equals(mapStr.get("data_type"))) {
			sql.append("select g.img_id,g.hospital_id,g.log_id,g.img_src,g.gxsj,g.bz,g.lrsj,g.zt,g.lrzh,q.lof_diagnosis");
			sql.append(" from inquiry_log_img g,inquiry_log q");
			sql.append(" where g.log_id=q.log_id");
			if (UtilValiDate.isEmpty(mapStr.get("img_id"))) {
				sql.append(" and g.img_id = :img_id");
				mapSQLParameter.put("img_id",  mapStr.get("img_id"));
			}
		}
		
		sql.append(" ) t where 1=1 ");
		
		if (!UtilValiDate.isEmpty(mapStr.get(SysFinal.ISSORT_KEY))) { 
			// 由于从菜单进入没有带入参数，这里给入判断进行开启排序
			mapStr.put(SysFinal.ISSORT_KEY, "y");
		}
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter, mapStr);
		
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
		
	}

	/************************系统生成方法完毕******************************/
}