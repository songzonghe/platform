/**
 * 
 */
package com.servicesAdmin.reportForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.util.SysFinal;
import com.util.UtilJson;
import com.util.UtilStr;
import com.util.UtilTime;
import com.util.UtilValiDate;

/**
 * 报表管理
 * @author 李裕国
 * @date 2019年10月24日 下午6:02:42
 */
@Service("reportFormServerImp")
public class ReportFormServerImp implements ReportFormServer{
	
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/**
	 *分页获取注册患者信息
	 * @throws Exception 
	 */
	public List<Map<String, Object>> tRegisterUserBody(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.delete(0, sql.length());
		sql.append("select t.user_id,t.hospital_id,t.user_phone,t.user_paw,t.user_openid,t.user_nickname,t.user_img,t.user_name,t.user_document_type,t.user_document_number,t.user_document_img1,t.user_document_img2,t.user_im,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj,t.is_online,t.last_refresh_time");
		sql.append(" from user_info t "); 
		sql.append(" where t.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and t.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("user_phone"))) {
			sql.append(" and t.user_phone like :user_phone ");
			mapSQLParameter.put("user_phone", "%"+mapStr.get("user_phone")+"%");
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(t.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(t.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append("order by t.lrsj desc ");
		mapStr.put(SysFinal.ISSORT_KEY,"n");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		
		return list_Map;
	}

	/**
	 *分页获取问诊患者信息
	 * @throws Exception 
	 */
	public List<Map<String, Object>> tInquiryUserBody(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.delete(0, sql.length());
		sql.append("select t.inquiry_patient_id,t.join_type,t.inquiry_patient_type,t.inquiry_patient_img,t.inquiry_patient_name,t.inquiry_patient_idcard,t.inquiry_patient_sex,t.inquiry_patient_phone");
		sql.append(",ifnull(year(now())-year(t.inquiry_patient_birthday),0) as patientAge,l.log_source ");
		sql.append(",l.log_type,l.lrsj,l.gxsj ");
		sql.append(" from inquiry_patient_info t ,inquiry_log l"); 
		sql.append(" where 1=1 and l.zt not in ('2','-1') and t.inquiry_patient_id=l.inquiry_patient_id ");
		
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and t.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}

		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and l.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and t.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(l.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(l.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append("order by l.lrsj desc ");
		mapStr.put(SysFinal.ISSORT_KEY,"n");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	/**
	 * 分页获取处方报表
	 * @throws Exception 
	 */
	public List<Map<String, Object>> tPrescriptionBody(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		
		sql.append("select t.* from (");
		sql.append("select l.hospital_id,l.log_type,l.join_type,p.prescription_id,p.prescription_type,i.inquiry_patient_name,i.inquiry_patient_phone,i.inquiry_patient_sex,l.lof_diagnosis,p.lrsj as kfsj,l.lrsj,p.prescription_reasons_invalidation,l.unprescribed_reasons,p.zt ");
		sql.append(",d.doctor_name,d.doctor_phone");
		sql.append(" from inquiry_log l,inquiry_log_prescription p,inquiry_patient_info i,doctor_info d where d.doctor_id=l.doctor_id and l.log_id=p.log_id and l.inquiry_patient_id=i.inquiry_patient_id ");
		sql.append(" union all");
		sql.append(" select l.hospital_id,l.log_type,l.join_type,'','',i.inquiry_patient_name,i.inquiry_patient_phone,i.inquiry_patient_sex,l.lof_diagnosis,'',l.lrsj,'',l.unprescribed_reasons,'-1' ");
		sql.append(",d.doctor_name,d.doctor_phone");
		sql.append(" from inquiry_log l,inquiry_patient_info i,doctor_info d  where d.doctor_id=l.doctor_id and l.zt not in ('2','-1') and l.unprescribed_reasons is not null and l.unprescribed_reasons !='' and l.inquiry_patient_id=i.inquiry_patient_id ) t where 1=1 ");

		
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and t.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}

		if(UtilValiDate.isEmpty(mapStr.get("type"))) {
			sql.append(" and t.type =:type ");
			mapSQLParameter.put("type", mapStr.get("type"));
		}
		if(UtilValiDate.isEmpty(mapStr.get("find_zt"))) {
			sql.append(" and t.zt =:find_zt ");
			mapSQLParameter.put("find_zt", mapStr.get("find_zt"));
		}
		if(UtilValiDate.isEmpty(mapStr.get("type"))) {
			sql.append(" and t.type =:type ");
			mapSQLParameter.put("type", mapStr.get("type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and t.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		
		if(UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
			sql.append(" and (t.doctor_name like :doctor_name or t.doctor_phone like :doctor_name) ");
			mapSQLParameter.put("doctor_name", "%"+mapStr.get("doctor_name")+"%");
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and t.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(t.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(t.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append(" order by t.lrsj desc ");
		mapStr.put(SysFinal.ISSORT_KEY,"n");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	/**
	 *分页获取健康指导报表
	 */
	public List<Map<String, Object>> tHealthGuidanceBody(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		
		sql.append("select t.guidance_id,t.join_type,t.join_id,t.guidance_content,t.reasons_invalidation,t.lrsj as jlsj,l.lrsj");
		sql.append(",l.log_type,l.lof_diagnosis,l.log_source,i.inquiry_patient_name,i.inquiry_patient_sex,i.inquiry_patient_phone,case t.zt when '5' then '2' else '1' end as type ");
		sql.append(",d.doctor_name,d.doctor_phone");
		sql.append(" from inquiry_log_health_guidance t,inquiry_log l,inquiry_patient_info i,doctor_info d  ");
		sql.append(" where 1=1 and d.doctor_id=l.doctor_id and t.log_id=l.log_id and t.inquiry_patient_id=l.inquiry_patient_id and t.inquiry_patient_id=i.inquiry_patient_id ");

		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and t.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("type"))) {
			if("2".equals(mapStr.get("type"))) {
				sql.append(" and t.zt ='5' ");
			}else {
				sql.append(" and t.zt !='5' ");
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and l.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
			sql.append(" and (d.doctor_name like :doctor_name or d.doctor_phone like :doctor_name) ");
			mapSQLParameter.put("doctor_name", "%"+mapStr.get("doctor_name")+"%");
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and l.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(l.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(l.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append(" order by t.lrsj desc ");
		mapStr.put(SysFinal.ISSORT_KEY,"n");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	@Override
	public List<Map<String, Object>> tChecklistBody(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.delete(0, sql.length());
		sql.append("select t.checklist_id,l.lrsj,l.log_type,l.join_type,l.lof_diagnosis,l.log_source,i.inquiry_patient_name,i.inquiry_patient_sex,i.inquiry_patient_phone");
		sql.append(",case t.zt when '5' then '2' else '1' end as type");
		sql.append(",d.doctor_name,d.doctor_phone");
		sql.append(" from  inquiry_log_checklist t,inquiry_log l,inquiry_patient_info i,doctor_info d  "); 
		sql.append(" where 1=1 and d.doctor_id=l.doctor_id  and t.log_id=l.log_id and t.inquiry_patient_id=i.inquiry_patient_id ");

		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and l.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("type"))) {
			if("2".equals(mapStr.get("type"))) {
				sql.append(" and t.zt ='5' ");
			}else {
				sql.append(" and t.zt !='5' ");
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and l.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
			sql.append(" and (d.doctor_name like :doctor_name or d.doctor_phone like :doctor_name) ");
			mapSQLParameter.put("doctor_name", "%"+mapStr.get("doctor_name")+"%");
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and l.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(l.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(l.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append(" order by t.lrsj desc ");
		mapStr.put(SysFinal.ISSORT_KEY,"n");
		
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}
	
	/**
	 *分页获取药住院建议报表
	 */
	public List<Map<String, Object>> tHospitalizationBody(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		
		sql.delete(0, sql.length());
		sql.append("select t.hospitalization_id,t.doctor_id,t.hospitalization_hospital,t.hospitalization_department,t.reasons_invalidation,t.lrsj as jlsj");
		sql.append(",l.lrsj,l.log_type,l.join_type,l.lof_diagnosis,l.log_source,i.inquiry_patient_name,i.inquiry_patient_sex,i.inquiry_patient_phone");
		sql.append(",case t.zt when '5' then '2' else '1' end as type");
		sql.append(",d.doctor_work_address,d.doctor_name,d.doctor_phone");
		sql.append(" from inquiry_log_hospitalization t,inquiry_log l,inquiry_patient_info i,doctor_info d "); 
		sql.append(" where 1=1 and t.log_id=l.log_id and d.doctor_id=l.doctor_id and t.inquiry_patient_id=l.inquiry_patient_id and t.inquiry_patient_id=i.inquiry_patient_id");
		
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and l.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("type"))) {
			if("2".equals(mapStr.get("type"))) {
				sql.append(" and t.zt ='5' ");
			}else {
				sql.append(" and t.zt !='5' ");
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and l.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
			sql.append(" and (d.doctor_name like :doctor_name or d.doctor_phone like :doctor_name) ");
			mapSQLParameter.put("doctor_name", "%"+mapStr.get("doctor_name")+"%");
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and l.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(l.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(l.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append(" order by t.lrsj desc ");
		mapStr.put(SysFinal.ISSORT_KEY,"n");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	/**
	 *分页获取药师审核处方统计报表
	 */
	public List<Map<String, Object>> tAuditPrescriptionBody(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		
		sql.append("select l.hospital_id,l.log_type,l.join_type,p.prescription_id,p.prescription_type,p.prescription_audited_doctor,p.prescription_audited_data,i.inquiry_patient_name,i.inquiry_patient_phone,i.inquiry_patient_sex,l.lof_diagnosis,p.lrsj as kfsj,l.lrsj,p.prescription_reasons_invalidation,l.unprescribed_reasons,p.zt ");
		sql.append(",d.doctor_name,d.doctor_phone,pi.pharmacist_name ");
		sql.append(" from inquiry_log l,inquiry_log_prescription p,inquiry_patient_info i,doctor_info d,pharmacist_info pi ");
		sql.append(" where d.doctor_id=l.doctor_id  and l.log_id=p.log_id and l.inquiry_patient_id=i.inquiry_patient_id ");
		sql.append(" and p.prescription_audited_doctor_id =pi.pharmacist_id ");
		
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and l.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		if("2".equals(mapStr.get("login_account_type"))){
			sql.append(" and p.prescription_audited_doctor_id =:prescription_audited_doctor_id ");
			mapSQLParameter.put("prescription_audited_doctor_id", mapStr.get("other_id"));
		}
		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and l.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and l.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		if(UtilValiDate.isEmpty(mapStr.get("find_zt"))) {
			sql.append(" and p.zt =:find_zt ");
			mapSQLParameter.put("find_zt", mapStr.get("find_zt"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
			sql.append(" and (d.doctor_name like :doctor_name or d.doctor_phone like :doctor_name) ");
			mapSQLParameter.put("doctor_name", "%"+mapStr.get("doctor_name")+"%");
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("pharmacist_name"))) {
			sql.append(" and p.prescription_audited_doctor like :pharmacist_name ");
			mapSQLParameter.put("pharmacist_name", "%"+mapStr.get("pharmacist_name")+"%");
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(p.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(p.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append(" order by p.lrsj desc ");
		mapStr.put(SysFinal.ISSORT_KEY,"n");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}
	
	/**
	 *分页获取院长统计报表
	 */
	public Map<String, String> tDeanReport(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		
		String queryDate=mapStr.get("queryDate");
		if("1".equals(mapStr.get("type"))) {
			queryDate=UtilTime.getDayData(-1);
		}else if("2".equals(mapStr.get("type"))) {
			if(!UtilValiDate.isEmpty(queryDate)) {
				queryDate=UtilTime.getTime("yyyy-MM");
			}
		}else if("3".equals(mapStr.get("type"))) {
			if(!UtilValiDate.isEmpty(queryDate)) {
				queryDate=UtilTime.getTime("yyyy");
			}
		}
		
		String hospitalSql="";
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				hospitalSql=" and hospital_id =:hospital_id ";
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		mapSQLParameter.put("lrsj","%"+queryDate+"%");
		
		sql.delete(0, sql.length());
		sql.append("select count(user_id) as num from user_info where lrsj like :lrsj "+hospitalSql);
		sql.append(" union all ");
		sql.append(" select count(log_id) from inquiry_log where zt not in ('2','-1') and lrsj like :lrsj"+hospitalSql);
		sql.append(" union all");
		sql.append(" select count(prescription_id) from inquiry_log_prescription where lrsj like :lrsj "+hospitalSql);
		sql.append(" union all");
		sql.append(" select count(prescription_id) from inquiry_log_prescription where prescription_audited_doctor_id is not null and prescription_audited_doctor_id !='' and lrsj like :lrsj"+hospitalSql);
		sql.append(" union all");
		sql.append(" select count(prescription_id) from inquiry_log_prescription where zt='3' and lrsj like :lrsj"+hospitalSql);
		sql.append(" union all");
		sql.append(" select count(guidance_id) from inquiry_log_health_guidance where lrsj like :lrsj"+hospitalSql);
		sql.append(" union all");
		sql.append(" select count(checklist_id) from inquiry_log_checklist where lrsj like :lrsj"+hospitalSql);
		sql.append(" union all");
		sql.append(" select count(hospitalization_id) from inquiry_log_hospitalization where lrsj like :lrsj"+hospitalSql);
		sql.append(" union all");
		sql.append(" select 0");
		List<Map<String, Object>> list = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		mapStr.put("num1",list.get(0).get("num").toString());
		mapStr.put("num2",list.get(1).get("num").toString());
		mapStr.put("num3",list.get(2).get("num").toString());
		mapStr.put("num4",list.get(3).get("num").toString());
		mapStr.put("num5",list.get(4).get("num").toString());
		mapStr.put("num6",list.get(5).get("num").toString());
		mapStr.put("num7",list.get(6).get("num").toString());
		mapStr.put("num8",list.get(7).get("num").toString());
		mapStr.put("num9",list.get(8).get("num").toString());
		
		mapStr.put("queryDate", queryDate);
		
		return mapStr;
	}
	
	/**
	* 问诊记录详情
	* @param mapStr
	* @throws Exception
	*/
	public String updateInquiryLogDetails(Map<String, String> mapStr)throws Exception{
		Map<String, Object> mapJson=new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();

		//问诊详情
		sql.delete(0, sql.length());
		sql.append("select t.log_id,t.hospital_id,t.log_type,t.join_type,t.join_id,t.inquiry_patient_id,t.doctor_id,t.log_source,t.log_main_suit,t.log_present_illness,t.log_history_present_illness,t.lof_diagnosis,t.lof_proposal,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(",i.inquiry_patient_img,i.inquiry_patient_idcard,i.inquiry_patient_weight,i.inquiry_patient_profession,i.inquiry_patient_address,i.is_drug_allergy,i.inquiry_patient_phone,i.is_married,i.inquiry_patient_marital_status,i.inquiry_patient_name,i.iinquiry_patient_allergy_details,i.inquiry_patient_sex,i.inquiry_patient_birthday,ifnull(year(now())-year(i.inquiry_patient_birthday),0) as patientAge");
		sql.append(" from inquiry_log t,inquiry_patient_info i "); 
		sql.append(" where 1=1 and t.inquiry_patient_id=i.inquiry_patient_id ");
		sql.append(" and t.log_id=:log_id");
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		Map<String, Object> inquiryMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		mapJson.put("inquiryMap", inquiryMap);
		
		//处方列表
		sql.delete(0, sql.length()); 
		sql.append("select t.prescription_id,t.prescription_type,t.prescription_reasons_invalidation,t.zt ");
		sql.append(" from inquiry_log_prescription t "); 
		sql.append(" where 1=1 and t.log_id=:log_id");
		sql.append(" order by t.lrsj desc ");
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		List<Map<String, Object>> prescriptionList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		mapJson.put("prescriptionList", prescriptionList);
		
		//医生信息
		Map<String, Object> doctorMap = getDoctorInfo(inquiryMap.get("doctor_id")+"");
		mapJson.put("doctorMap", doctorMap);
		
		//住院建议列表
		sql.delete(0, sql.length());
		sql.append("select t.hospitalization_id");
		sql.append(" from inquiry_log_hospitalization t "); 
		sql.append(" where 1=1 and t.log_id=:log_id");
		sql.append(" order by t.lrsj desc ");
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		List<Map<String, Object>> hospitalizationList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		mapJson.put("hospitalizationList", hospitalizationList);
		//健康指导列表
		sql.delete(0, sql.length());
		sql.append("select t.guidance_id, t.guidance_content,t.zt");
		sql.append(" from inquiry_log_health_guidance t "); 
		sql.append(" where 1=1 and t.log_id=:log_id"); 
		sql.append(" order by t.lrsj desc ");
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		List<Map<String, Object>> guidanceList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		mapJson.put("guidanceList", guidanceList);
		//检验单
		sql.delete(0, sql.length());
		sql.append("select t.checklist_id,t.checklist_name,t.checklist_type");
		sql.append(" from inquiry_log_checklist t "); 
		sql.append(" where 1=1 and t.log_id=:log_id"); 
		sql.append(" order by t.lrsj desc "); 
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		List<Map<String, Object>> checklistList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		mapJson.put("checklistList", checklistList);
		
		sql.delete(0, sql.length());
		sql.append("select t.data_id,t.hospital_id,t.log_id,t.inquiry_patient_id,t.join_type,t.join_id,t.data_animal_heat,t.data_sbp,t.data_dbp,t.data_heart_rate,t.data_rr,t.data_glu,t.data_condition,t.data_parameter,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(" from inquiry_patient_measured_data t "); 
		sql.append(" where 1=1 and t.log_id=:log_id");
		sql.append(" order by t.data_id");
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		Map<String, Object> measuredDataMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		mapJson.put("isMeasured", "0");
		if(measuredDataMap.size()>0) {
			mapJson.put("isMeasured", "1");
		}
		mapJson.put("measuredDataMap", measuredDataMap);
		return UtilStr.return_success("查询成功",mapJson);
	}
	
	/**
	* 住院建议详情
	* @param mapStr
	* @throws Exception
	*/
	public String getInquiryLogHospitalizationDetails(Map<String, String> mapStr)throws Exception{
		Map<String, Object> mapJson=new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.delete(0, sql.length());
		sql.append("select t.hospitalization_id,t.hospital_id,t.log_id,t.join_type,t.join_id,t.inquiry_patient_id,t.doctor_id,t.hospitalization_hospital,t.hospitalization_department,t.reasons_invalidation,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(" from inquiry_log_hospitalization t "); 
		sql.append(" where 1=1 and t.hospitalization_id=:hospitalization_id");
		mapSQLParameter.put("hospitalization_id", mapStr.get("hospitalization_id"));
		Map<String, Object> hospitalizationMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		mapJson.put("hospitalizationMap", hospitalizationMap);
		
		//诊断信息
		sql.delete(0, sql.length());
		sql.append("select t.log_id,t.hospital_id,t.log_type,t.join_type,t.join_id,t.inquiry_patient_id,t.doctor_id,t.log_source,t.log_main_suit,t.log_present_illness,t.log_history_present_illness,t.lof_diagnosis,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(",i.inquiry_patient_img,i.inquiry_patient_name,i.inquiry_patient_sex,i.inquiry_patient_phone,i.inquiry_patient_idcard,ifnull(year(now())-year(i.inquiry_patient_birthday),0) as patientAge");
		sql.append(" from inquiry_log t,inquiry_patient_info i "); 
		sql.append(" where 1=1 and t.inquiry_patient_id=i.inquiry_patient_id and t.log_id=:log_id");
		mapSQLParameter.put("log_id", hospitalizationMap.get("log_id"));
		Map<String, Object> inquiryMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		mapJson.put("inquiryMap", inquiryMap);
		
		//医生信息
		Map<String, Object> doctorMap = getDoctorInfo(hospitalizationMap.get("doctor_id")+"");
		mapJson.put("doctorMap", doctorMap);
		
		return UtilStr.return_success("查询成功",mapJson);
	}
	
	/**
	* 健康指导详情
	* @param mapStr
	* @throws Exception
	*/
	public String getInquiryLogHealthGuidanceDetails(Map<String, String> mapStr)throws Exception{
		Map<String, Object> mapJson=new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.delete(0, sql.length());
		sql.append("select t.guidance_id,t.hospital_id,t.log_id,t.join_type,t.join_id,t.inquiry_patient_id,t.doctor_id,t.guidance_content,t.reasons_invalidation,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(" from inquiry_log_health_guidance t "); 
		sql.append(" where 1=1 and t.guidance_id=:guidance_id");
		mapSQLParameter.put("guidance_id", mapStr.get("guidance_id"));
		Map<String, Object> guidanceMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		mapJson.put("guidanceMap", guidanceMap);
		
		//诊断信息
		sql.delete(0, sql.length());
		sql.append("select t.log_id,t.hospital_id,t.log_type,t.join_type,t.join_id,t.inquiry_patient_id,t.doctor_id,t.log_source,t.log_main_suit,t.log_present_illness,t.log_history_present_illness,t.lof_diagnosis,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(",i.inquiry_patient_img,i.inquiry_patient_name,i.inquiry_patient_sex,i.inquiry_patient_phone,ifnull(year(now())-year(i.inquiry_patient_birthday),0) as patientAge");
		sql.append(" from inquiry_log t,inquiry_patient_info i "); 
		sql.append(" where 1=1 and t.inquiry_patient_id=i.inquiry_patient_id and t.log_id=:log_id");
		mapSQLParameter.put("log_id", guidanceMap.get("log_id"));
		Map<String, Object> inquiryMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		mapJson.put("inquiryMap", inquiryMap);
		
		//医生信息
		Map<String, Object> doctorMap = getDoctorInfo(guidanceMap.get("doctor_id")+"");
		mapJson.put("doctorMap", doctorMap);
		return UtilStr.return_success("查询成功",mapJson);
	}
	
	/**
	* 检验单详情
	* @param mapStr
	* @throws Exception
	*/
	public String getInquiryLogChecklistDetails(Map<String, String> mapStr)throws Exception{
		Map<String, Object> mapJson=new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.delete(0, sql.length());
		sql.append("select t.* ");
		sql.append(" from inquiry_log_checklist t "); 
		sql.append(" where 1=1 and t.checklist_id=:checklist_id");
		mapSQLParameter.put("checklist_id", mapStr.get("checklist_id"));
		Map<String, Object> checklistMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		
		sql.delete(0, sql.length());
		sql.append("select t.checklist_details_id,t.hospital_id,t.checklist_id,t.checklist_type,t.checklist_name,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(" from inquiry_log_checklist_details t "); 
		sql.append(" where 1=1 and t.checklist_id=:checklist_id");
		sql.append(" order by t.lrsj desc ");
		mapSQLParameter.put("checklist_id", mapStr.get("checklist_id"));
		List<Map<String, Object>> checklistDetailsList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		checklistMap.put("checklistDetailsList", checklistDetailsList);
		mapJson.put("checklistMap", checklistMap);
		
		//诊断信息
		sql.delete(0, sql.length());
		sql.append("select t.log_id,t.hospital_id,t.log_type,t.join_type,t.join_id,t.inquiry_patient_id,t.doctor_id,t.log_source,t.log_main_suit,t.log_present_illness,t.log_history_present_illness,t.lof_diagnosis,t.lof_proposal,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(",i.inquiry_patient_img,i.inquiry_patient_name,i.inquiry_patient_sex,i.inquiry_patient_phone,ifnull(year(now())-year(i.inquiry_patient_birthday),0) as patientAge");
		sql.append(" from inquiry_log t,inquiry_patient_info i "); 
		sql.append(" where 1=1 and t.inquiry_patient_id=i.inquiry_patient_id and t.log_id=:log_id");
		mapSQLParameter.put("log_id", checklistMap.get("log_id"));
		Map<String, Object> inquiryMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		mapJson.put("inquiryMap", inquiryMap);
		
		//医生信息
		Map<String, Object> doctorMap = getDoctorInfo(checklistMap.get("doctor_id")+"");
		mapJson.put("doctorMap", doctorMap);
		
		return UtilStr.return_success("查询成功",mapJson);
	}
	
	
	/**
	* 获取用户信息
	* @param mapStr
	* @throws Exception
	*/
	public Map<String, Object> getDoctorInfo(String doctor_id)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.delete(0, sql.length());
		sql.append("select t.doctor_id,t.hospital_id,t.doctor_phone,t.doctor_paw,t.doctor_openid,t.doctor_name,t.doctor_img,t.doctor_sex,t.doctot_job_title,t.doctor_work_address,t.department_id,t.doctot_work_day,t.doctot_birthday,t.doctor_document_number,t.doctor_document_img1,t.doctor_document_img2,t.doctor_medical_practitioner_certificate,t.doctor_medical_licence,t.doctor_technical_certificate,t.doctor_begoodat,t.doctor_synopsis,t.doctor_sort,t.is_online,t.doctor_im,t.doctor_autograph,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(",d.department_name,ifnull(year(NOW())-year(t.doctot_work_day),0) as workAge,ifnull(year(NOW())-year(t.doctot_birthday),0) as doctorAge ");
		sql.append(" from doctor_info t,util_department d "); 
		sql.append(" where 1=1 and d.department_id=t.department_id and t.doctor_id=:doctor_id ");
		mapSQLParameter.put("doctor_id", doctor_id);
		Map<String, Object> doctor = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		
		//1接诊患者数量
		sql.delete(0, sql.length());
		sql.append("select t.log_id");
		sql.append(" from inquiry_log t "); 
		sql.append(" where 1=1 and t.doctor_id=:doctor_id and t.zt in (0,1,5)");
		String inquiryCount = this.gyDAOimp.findSqlCount(sql, mapSQLParameter).get("TJ")+"";
		doctor.put("inquiryCount", inquiryCount);
		
		//2我的处方
		sql.delete(0, sql.length()); 
		sql.append("select t.prescription_id");
		sql.append(" from inquiry_log_prescription t "); 
		sql.append(" where 1=1 and t.doctor_id=:doctor_id  ");
		String prescriptionCount = this.gyDAOimp.findSqlCount(sql, mapSQLParameter).get("TJ")+"";
		doctor.put("prescriptionCount", prescriptionCount);
		
		return doctor;
	}
	
	/**
	* 处方详情
	* @param mapStr
	* @throws Exception
	*/
	public String updateInquiryLogPrescriptionDetails(Map<String, String> mapStr)throws Exception{
		Map<String, Object> mapJson=new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		
		//处方主表
		sql.delete(0, sql.length());
		sql.append("select t.* ");
		sql.append(" from inquiry_log_prescription t ");  
		sql.append(" where 1=1 and t.prescription_id=:prescription_id");
		mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
		Map<String, Object> prescriptionMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		
		
		prescriptionMap.put("prescription_audited_doctor_img", "");
		if(UtilValiDate.isEmpty(prescriptionMap.get("prescription_audited_doctor_id"))) {
			sql.delete(0, sql.length());
			sql.append("select t.pharmacist_id,t.hospital_id,t.pharmacist_number,t.pharmacist_paw,t.pharmacist_name,t.pharmacist_phone,t.pharmacist_img,t.pharmacist_autograph,t.pharmacist_sex,t.pharmacist_document_number,t.pharmacist_document_img1,t.pharmacist_document_img2,t.pharmacist_medical_practitioner_certificate,t.pharmacist_medical_licence,t.pharmacist_synopsis,t.pharmacist_sort,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
			sql.append(" from pharmacist_info t "); 
			sql.append(" where 1=1 and t.pharmacist_id=:pharmacist_id");
			mapSQLParameter.put("pharmacist_id", prescriptionMap.get("prescription_audited_doctor_id"));
			Map<String, Object> pharmacist = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
			if(pharmacist.size()>0) {
				prescriptionMap.put("prescription_audited_doctor_img", pharmacist.get("pharmacist_autograph"));
			}
		}
		
		//处方内容
		sql.delete(0, sql.length());
		sql.append("select t.prescription_details_id,t.hospital_id,t.prescription_id,t.drug_id,t.details_consumption,t.details_consumption_util,t.details_frequency_str,t.details_frequency,t.details_day,t.details_num,t.details_usage,t.details_entrust,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(",d.drug_name,d.drug_specifications,d.drug_price,d.drug_unit,d.drug_packaging_unit");
		sql.append(" from inquiry_log_prescription_details t,util_drug d "); 
		sql.append(" where 1=1 and t.drug_id=d.drug_id and t.prescription_id=:prescription_id");
		mapSQLParameter.put("prescription_id", mapStr.get("prescription_id"));
		List<Map<String, Object>> prescriptionList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		prescriptionMap.put("prescriptionList", prescriptionList);
		mapJson.put("prescriptionMap", prescriptionMap);
		
		//诊断信息
		sql.delete(0, sql.length());
		sql.append("select t.log_id,t.hospital_id,t.log_type,t.join_type,t.join_id,t.inquiry_patient_id,t.doctor_id,t.log_source,t.log_main_suit,t.log_present_illness,t.log_history_present_illness,t.lof_diagnosis,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(",ifnull(year(now())-year(i.inquiry_patient_birthday),0) as patientAge");
		sql.append(",i.inquiry_patient_img,i.inquiry_patient_name,i.inquiry_patient_idcard,i.inquiry_patient_sex,i.inquiry_patient_phone,i.is_married,i.inquiry_patient_marital_status,i.inquiry_patient_weight,i.inquiry_patient_profession,i.inquiry_patient_address,i.is_drug_allergy,i.iinquiry_patient_allergy_details");
		sql.append(" from inquiry_log t,inquiry_patient_info i "); 
		sql.append(" where 1=1 and t.inquiry_patient_id=i.inquiry_patient_id and t.log_id=:log_id");
		mapSQLParameter.put("log_id", prescriptionMap.get("log_id"));
		Map<String, Object> inquiryMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		mapJson.put("inquiryMap", inquiryMap);
		
		
		Map<String, Object> doctorMap = getDoctorInfo(prescriptionMap.get("doctor_id")+"");
		mapJson.put("doctorMap", doctorMap);
		
		return UtilStr.return_success("查询成功",mapJson);
	}

	/**
	 *分页获取大数据图
	 * @throws Exception 
	 */
	public Map<String, String> tBigDataIndex(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		
		//累计服务人数（注册人数）
		sql.delete(0, sql.length());
		sql.append("select t.user_id ");
		sql.append(" from user_info t "); 
		sql.append(" where 1=1 ");
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		String userCount = this.gyDAOimp.findSqlCount(sql, mapSQLParameter).get("TJ")+"";
		
		//累计处方数
		sql.delete(0, sql.length());
		sql.append("select t.prescription_id ");
		sql.append(" from inquiry_log_prescription t "); 
		sql.append(" where 1=1 ");
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		String prescriptionCount = this.gyDAOimp.findSqlCount(sql, mapSQLParameter).get("TJ")+"";
		//当前在线医生人数
		sql.delete(0, sql.length());
		sql.append("select t.doctor_id ");
		sql.append(" from doctor_info t "); 
		sql.append(" where 1=1 ");
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		String doctorCount = this.gyDAOimp.findSqlCount(sql, mapSQLParameter).get("TJ")+"";
		//当前累计问诊人数
		sql.delete(0, sql.length());
		sql.append("select t.log_id ");
		sql.append(" from inquiry_log t "); 
		sql.append(" where 1=1 and t.zt not in ('2','-1') ");
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		String inquiryCount = this.gyDAOimp.findSqlCount(sql, mapSQLParameter).get("TJ")+"";
		//当天累计开处方数
		String today=UtilTime.getTimeYYYY_MM_DD();
		sql.delete(0, sql.length());
		sql.append("select t.prescription_id ");
		sql.append(" from inquiry_log_prescription t "); 
		sql.append(" where 1=1 and t.lrsj like :lrsj ");
		mapSQLParameter.put("lrsj", "%"+today+"%");
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		String todayPrescriptionCount = this.gyDAOimp.findSqlCount(sql, mapSQLParameter).get("TJ")+"";
		
		//累计服务人数（注册人数）
		mapStr.put("userCount", userCount);
		//累计处方数
		mapStr.put("prescriptionCount", prescriptionCount);
		//当前在线医生人数
		mapStr.put("doctorCount", doctorCount);
		//当前累计问诊人数
		mapStr.put("inquiryCount", inquiryCount);
		//当天累计开处方数
		mapStr.put("todayPrescriptionCount", todayPrescriptionCount);
		
		//按照地址查询全部问诊点
		sql.delete(0, sql.length());
		sql.append("select a.name,count(t.store_id) as num ,a.longitude,a.latitude from store_info t ,util_area a ");
		sql.append(" where 1=1 and t.store_xzqhdm=a.id");
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and t.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		sql.append(" group by t.store_xzqhdm");
		List<Map<String, Object>> storeList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		//var data [ {name: '海门', value: 9},
		//var geoCoordMap = {'海门':[121.15,31.89]
		
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		Map<String, Object> geoCoordMap = new LinkedHashMap<String, Object>();
		
		for (Map<String, Object> map : storeList) {
			map.put("value", UtilStr.getInt(map.get("num")));
			dataList.add(map);
			
			List<Double> list=new ArrayList<Double>();
			list.add(UtilStr.getAsDouble(map.get("longitude")));
			list.add(UtilStr.getAsDouble(map.get("latitude")));
			geoCoordMap.put(map.get("name")+"", list);
		}
		
		Gson gosn = new GsonBuilder().serializeNulls().create();
   	  	String dataListString = gosn.toJson(dataList);
   	  	String geoCoordMapString = gosn.toJson(geoCoordMap);

   		mapStr.put("dataListString", dataListString);
   		mapStr.put("geoCoordMapString", geoCoordMapString);
		return mapStr;
	}

	@Override
	public Map<String, Object> registerUserIndexExcelSql(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.delete(0, sql.length());
		sql.append("select t.user_phone,ifnull(t.user_nickname,''),t.user_name,t.lrsj,t.bz");
		sql.append(" from user_info t "); 
		sql.append(" where t.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and t.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("user_phone"))) {
			sql.append(" and t.user_phone like :user_phone ");
			mapSQLParameter.put("user_phone", "%"+mapStr.get("user_phone")+"%");
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(t.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(t.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append("order by t.lrsj desc ");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		//导出类型2
		//获取头部信息
		List<String>titleList=new ArrayList<String>();
		titleList.add("账户");
		titleList.add("用户名称");
		titleList.add("真实名称");
		titleList.add("注册时间");
		titleList.add("备注");
		
		
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("exportType", "2");//导出类型  1 正常导出  2自定义导出  
		map.put("title", titleList);//导出类型 为1 放sql语句   2放自定义的头部信息
		map.put("info",UtilJson.toJson(list_Map));//导出类型 为1 放搜索参数   2放得到的数据 信息
		return map;
	}

	@Override
	public Map<String, Object> inquiryUserIndexExcelSql(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.inquiry_patient_name,case t.inquiry_patient_sex when '0' then '男' else '女' end,ifnull( year ( now( ) ) - year ( t.inquiry_patient_birthday ), 0 ) as patientage,t.lrsj,t.inquiry_patient_phone,t.inquiry_patient_idcard,case l.log_type when '1' then '视频问诊' else '图文问诊' end,case t.join_type when '1' then '个人' else '门店' end,l.lrsj as zxsj");
		sql.append(" from inquiry_patient_info t,inquiry_log l ");
		sql.append(" where 1 = 1 and l.zt not in ( '2', '-1' )and t.inquiry_patient_id = l.inquiry_patient_id");
		
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and t.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}

		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and l.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and t.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(l.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(l.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append("order by l.lrsj desc ");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		//导出类型2
		//获取头部信息
		List<String>titleList=new ArrayList<String>();
		titleList.add("用户姓名");
		titleList.add("性别");
		titleList.add("年龄");
		titleList.add("注册时间");
		titleList.add("联系电话");
		titleList.add("证件号码");
		titleList.add("问诊类型");
		titleList.add("用户来源");
		titleList.add("咨询时间");

		Map<String, Object>map=new HashMap<String, Object>();
		map.put("exportType", "2");//导出类型  1 正常导出  2自定义导出  
		map.put("title", titleList);//导出类型 为1 放sql语句   2放自定义的头部信息
		map.put("info",UtilJson.toJson(list_Map));//导出类型 为1 放搜索参数   2放得到的数据 信息
		return map;
	}

	@Override
	public Map<String, Object> prescriptionExcelSql(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.* from (");
		sql.append(" select i.inquiry_patient_name,case i.inquiry_patient_sex when '0' then '男' else '女' end,i.inquiry_patient_phone,case l.join_type when '1' then '个人' else '门店' end,concat(d.doctor_name,'(',d.doctor_phone,')'),");
		sql.append(" case l.log_type when '1' then '视频问诊' else '图文问诊' end,l.lrsj,case p.prescription_type  when '1' then '中药' else '西药' end,p.lrsj as kfsj,'已开处方',l.hospital_id,l.join_type,l.log_type,d.doctor_name,d.doctor_phone");
		sql.append(" from inquiry_log l,inquiry_log_prescription p,inquiry_patient_info i,doctor_info d where d.doctor_id=l.doctor_id and l.log_id=p.log_id and l.inquiry_patient_id=i.inquiry_patient_id and p.zt in ('2','0','1','3')");
		sql.append(" union all");
		sql.append(" select i.inquiry_patient_name,case i.inquiry_patient_sex when '0' then '男' else '女' end,i.inquiry_patient_phone,case l.join_type when '1' then '个人' else '门店' end,concat(d.doctor_name,'(',d.doctor_phone,')'),");
		sql.append(" case l.log_type when '1' then '视频问诊' else '图文问诊' end,l.lrsj,'' as prescription_type,'' as kfsj,'未开处方',l.hospital_id,l.join_type,l.log_type,d.doctor_name,d.doctor_phone");
		sql.append(" from inquiry_log l,inquiry_patient_info i,doctor_info d  where d.doctor_id=l.doctor_id and l.zt not in ('2','-1') and l.unprescribed_reasons is not null and l.unprescribed_reasons !='' and l.inquiry_patient_id=i.inquiry_patient_id");
		sql.append(" union all");
		sql.append(" select i.inquiry_patient_name,case i.inquiry_patient_sex when '0' then '男' else '女' end,i.inquiry_patient_phone,case l.join_type when '1' then '个人' else '门店' end,concat(d.doctor_name,'(',d.doctor_phone,')'),");
		sql.append(" case l.log_type when '1' then '视频问诊' else '图文问诊' end,l.lrsj,case p.prescription_type  when '1' then '中药' else '西药' end,p.lrsj as kfsj,'撤销处方',l.hospital_id,l.join_type,l.log_type,d.doctor_name,d.doctor_phone");
		sql.append(" from inquiry_log l,inquiry_log_prescription p,inquiry_patient_info i,doctor_info d where d.doctor_id=l.doctor_id and  l.log_id=p.log_id and l.inquiry_patient_id=i.inquiry_patient_id and p.zt ='5'");
		sql.append(") t where 1=1 ");
		
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and t.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}

		if(UtilValiDate.isEmpty(mapStr.get("type"))) {
			sql.append(" and t.type =:type ");
			mapSQLParameter.put("type", mapStr.get("type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and t.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		
		if(UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
			sql.append(" and (t.doctor_name like :doctor_name or t.doctor_phone like :doctor_name) ");
			mapSQLParameter.put("doctor_name", "%"+mapStr.get("doctor_name")+"%");
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and t.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(t.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(t.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append(" order by t.lrsj desc ");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		for (Map<String, Object> map : list_Map) {
			map.remove("hospital_id");
			map.remove("join_type");
			map.remove("log_type");
			map.remove("doctor_name");
			map.remove("doctor_phone");
		}
		
		
		//导出类型2
		//获取头部信息
		List<String>titleList=new ArrayList<String>();
		titleList.add("咨询人");
		titleList.add("性别");
		titleList.add("联系电话");
		titleList.add("用户来源");
		titleList.add("医生信息");
		titleList.add("咨询类型");
		titleList.add("咨询时间");
		titleList.add("处方类型");
		titleList.add("开处方日期");
		titleList.add("记录类型");

		Map<String, Object>map=new HashMap<String, Object>();
		map.put("exportType", "2");//导出类型  1 正常导出  2自定义导出  
		map.put("title", titleList);//导出类型 为1 放sql语句   2放自定义的头部信息
		map.put("info",UtilJson.toJson(list_Map));//导出类型 为1 放搜索参数   2放得到的数据 信息
		return map;
	}

	@Override
	public Map<String, Object> healthHuidanceExcelSql(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
	
		sql.append("select i.inquiry_patient_name,case i.inquiry_patient_sex when '0' then '男' else '女' end,i.inquiry_patient_phone,");
		sql.append(" case l.join_type when '1' then '个人' else '门店' end,");
		sql.append(" concat(d.doctor_name,'(',d.doctor_phone,')'),");
		sql.append(" case l.log_type when '1' then '视频问诊' else '图文问诊' end,");
		sql.append(" l.lrsj,");
		sql.append(" t.guidance_content,");
		sql.append(" t.lrsj as jlsj, ");
		sql.append(" case t.zt when '5' then '撤销健康指导' else '已开健康指导' end as type");
		sql.append(" from inquiry_log_health_guidance t,inquiry_log l,inquiry_patient_info i,doctor_info d  ");
		sql.append(" where 1=1 and d.doctor_id=l.doctor_id and t.log_id=l.log_id and t.inquiry_patient_id=l.inquiry_patient_id and t.inquiry_patient_id=i.inquiry_patient_id ");
		
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and t.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("type"))) {
			if("2".equals(mapStr.get("type"))) {
				sql.append(" and t.zt ='5' ");
			}else {
				sql.append(" and t.zt !='5' ");
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and l.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
			sql.append(" and (d.doctor_name like :doctor_name or d.doctor_phone like :doctor_name) ");
			mapSQLParameter.put("doctor_name", "%"+mapStr.get("doctor_name")+"%");
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and l.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(l.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(l.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append(" order by t.lrsj desc ");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		
		//导出类型2
		//获取头部信息
		List<String>titleList=new ArrayList<String>();
		titleList.add("咨询人");
		titleList.add("性别");
		titleList.add("联系电话");
		titleList.add("用户来源");
		titleList.add("医生信息");
		titleList.add("咨询类型");
		titleList.add("咨询时间");
		titleList.add("指导内容");
		titleList.add("记录时间");
		titleList.add("记录类型");

		Map<String, Object>map=new HashMap<String, Object>();
		map.put("exportType", "2");//导出类型  1 正常导出  2自定义导出  
		map.put("title", titleList);//导出类型 为1 放sql语句   2放自定义的头部信息
		map.put("info",UtilJson.toJson(list_Map));//导出类型 为1 放搜索参数   2放得到的数据 信息
		return map;
	}

	@Override
	public Map<String, Object> checklistExcelSql(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		
		sql.append("select ");
		sql.append(" i.inquiry_patient_name,case i.inquiry_patient_sex when '0' then '男' else '女' end,i.inquiry_patient_phone,");
		sql.append(" case l.join_type when '1' then '个人' else '门店' end,");
		sql.append(" concat(d.doctor_name,'(',d.doctor_phone,')'),");
		sql.append(" case l.log_type when '1' then '视频问诊' else '图文问诊' end,");
		sql.append(" l.lrsj,");
		sql.append(" t.lrsj as jlsj, ");
		sql.append(" case t.zt when '5' then '撤销检验检查' else '已开检验检查' end as type ");
		sql.append(" from  inquiry_log_checklist t,inquiry_log l,inquiry_patient_info i,doctor_info d   ");
		sql.append(" where 1=1 and d.doctor_id=l.doctor_id  and t.log_id=l.log_id and t.inquiry_patient_id=i.inquiry_patient_id ");

		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and l.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("type"))) {
			if("2".equals(mapStr.get("type"))) {
				sql.append(" and t.zt ='5' ");
			}else {
				sql.append(" and t.zt !='5' ");
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and l.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
			sql.append(" and (d.doctor_name like :doctor_name or d.doctor_phone like :doctor_name) ");
			mapSQLParameter.put("doctor_name", "%"+mapStr.get("doctor_name")+"%");
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and l.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(l.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(l.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append(" order by t.lrsj desc ");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		
		//导出类型2
		//获取头部信息
		List<String>titleList=new ArrayList<String>();
		titleList.add("咨询人");
		titleList.add("性别");
		titleList.add("联系电话");
		titleList.add("用户来源");
		titleList.add("医生信息");
		titleList.add("咨询类型");
		titleList.add("咨询时间");
		titleList.add("记录时间");
		titleList.add("记录类型");

		Map<String, Object>map=new HashMap<String, Object>();
		map.put("exportType", "2");//导出类型  1 正常导出  2自定义导出  
		map.put("title", titleList);//导出类型 为1 放sql语句   2放自定义的头部信息
		map.put("info",UtilJson.toJson(list_Map));//导出类型 为1 放搜索参数   2放得到的数据 信息
		return map;
	}

	@Override
	public Map<String, Object> auditPrescriptionExcelSql(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		
		sql.append("select ");
		sql.append(" i.inquiry_patient_name,case i.inquiry_patient_sex when '0' then '男' else '女' end,i.inquiry_patient_phone,");
		sql.append(" case l.join_type when '1' then '个人' else '门店' end,");
		sql.append(" concat(d.doctor_name,'(',d.doctor_phone,')'),");
		sql.append(" case l.log_type when '1' then '视频问诊' else '图文问诊' end,");
		sql.append(" l.lrsj,p.prescription_audited_doctor,p.prescription_audited_data ");
		sql.append(" from inquiry_log l,inquiry_log_prescription p,inquiry_patient_info i,doctor_info d ");
		sql.append(" where d.doctor_id=l.doctor_id  and l.log_id=p.log_id and l.inquiry_patient_id=i.inquiry_patient_id ");
		sql.append(" and p.prescription_audited_doctor_id is not null and p.prescription_audited_doctor_id != '' ");

		
		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and l.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and l.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and l.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
			sql.append(" and (d.doctor_name like :doctor_name or d.doctor_phone like :doctor_name) ");
			mapSQLParameter.put("doctor_name", "%"+mapStr.get("doctor_name")+"%");
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("pharmacist_name"))) {
			sql.append(" and p.prescription_audited_doctor like :pharmacist_name ");
			mapSQLParameter.put("pharmacist_name", "%"+mapStr.get("pharmacist_name")+"%");
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(p.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(p.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append(" order by p.lrsj desc ");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		
		//导出类型2
		//获取头部信息
		List<String>titleList=new ArrayList<String>();
		titleList.add("咨询人");
		titleList.add("性别");
		titleList.add("联系电话");
		titleList.add("用户来源");
		titleList.add("医生信息");
		titleList.add("咨询类型");
		titleList.add("咨询时间");
		titleList.add("药师姓名");
		titleList.add("审核时间");
		
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("exportType", "2");//导出类型  1 正常导出  2自定义导出  
		map.put("title", titleList);//导出类型 为1 放sql语句   2放自定义的头部信息
		map.put("info",UtilJson.toJson(list_Map));//导出类型 为1 放搜索参数   2放得到的数据 信息
		return map;
	}

	@Override
	public Map<String, Object> hospitalizationExcelSql(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		
		sql.append("select ");
		sql.append(" i.inquiry_patient_name,case i.inquiry_patient_sex when '0' then '男' else '女' end,i.inquiry_patient_phone,");
		sql.append(" case l.join_type when '1' then '个人' else '门店' end,");
		sql.append(" concat(d.doctor_name,'(',d.doctor_phone,')'),");
		sql.append(" case l.log_type when '1' then '视频问诊' else '图文问诊' end,");
		sql.append(" l.lrsj,");
		sql.append(" d.doctor_work_address,");
		sql.append(" t.hospitalization_department,");
		sql.append(" case t.zt when '5' then '撤销住院建议' else '已开住院建议' end as type");
		sql.append(" from inquiry_log_hospitalization t,inquiry_log l,inquiry_patient_info i,doctor_info d ");
		sql.append(" where 1=1 and t.log_id=l.log_id and d.doctor_id=l.doctor_id and t.inquiry_patient_id=l.inquiry_patient_id and t.inquiry_patient_id=i.inquiry_patient_id");

		if(UtilValiDate.isEmpty(mapStr.get("login_hospital_id"))) {
			if(!"0".equals(mapStr.get("login_hospital_id"))) {
				sql.append(" and l.hospital_id =:hospital_id ");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("type"))) {
			if("2".equals(mapStr.get("type"))) {
				sql.append(" and t.zt ='5' ");
			}else {
				sql.append(" and t.zt !='5' ");
			}
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("log_type"))) {
			sql.append(" and l.log_type =:log_type ");
			mapSQLParameter.put("log_type", mapStr.get("log_type"));
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
			sql.append(" and (d.doctor_name like :doctor_name or d.doctor_phone like :doctor_name) ");
			mapSQLParameter.put("doctor_name", "%"+mapStr.get("doctor_name")+"%");
		}
		
		if(UtilValiDate.isEmpty(mapStr.get("join_type"))) {
			sql.append(" and l.join_type =:join_type ");
			mapSQLParameter.put("join_type", mapStr.get("join_type"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("beginTime"))) {
			sql.append(" and to_days(l.lrsj) >= to_days(:beginTime)");
			mapSQLParameter.put("beginTime",mapStr.get("beginTime"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("endTime"))) {
			sql.append(" and to_days(l.lrsj) <= to_days(:endTime)");
			mapSQLParameter.put("endTime",mapStr.get("endTime"));
		}
		
		sql.append(" order by t.lrsj desc ");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		
		//导出类型2
		//获取头部信息
		List<String>titleList=new ArrayList<String>();
		titleList.add("咨询人");
		titleList.add("性别");
		titleList.add("联系电话");
		titleList.add("用户来源");
		titleList.add("医生信息");
		titleList.add("咨询类型");
		titleList.add("咨询时间");
		titleList.add("申请入住医院");
		titleList.add("申请科室");
		titleList.add("记录类型");
		
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("exportType", "2");//导出类型  1 正常导出  2自定义导出  
		map.put("title", titleList);//导出类型 为1 放sql语句   2放自定义的头部信息
		map.put("info",UtilJson.toJson(list_Map));//导出类型 为1 放搜索参数   2放得到的数据 信息
		return map;
	}
	
}
