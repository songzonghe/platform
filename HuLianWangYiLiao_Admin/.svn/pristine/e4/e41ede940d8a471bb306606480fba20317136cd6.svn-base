package com.servicesAdmin.doctor.info;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.MD5;
import com.util.SysFinal;
import com.util.UtilSql;
import com.util.UtilValiDate;
/**
 * 医生基本资料 service 实现类
 * 操作人： 曾晓
 */ 
@Service("doctorInfoServiceImp")
public class DoctorInfoServiceImp implements DoctorInfoService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取医生基本资料查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.doctor_id,t.doctor_autograph,t.hospital_id,t.doctor_phone,t.doctor_paw,t.doctor_openid,t.doctor_name,t.doctor_img,t.doctor_sex,t.doctot_job_title,t.doctor_work_address,t.department_id,t.doctot_work_day,t.doctot_birthday,t.doctor_document_number,t.doctor_document_img1,t.doctor_document_img2,t.doctor_medical_practitioner_certificate,t.doctor_medical_licence,t.doctor_technical_certificate,t.doctor_begoodat,t.doctor_synopsis,t.doctor_sort,t.is_online,t.doctor_im,t.doctor_zyjszwdm,t.doctor_zyjszwlbdm,t.doctor_zzlbmc,t.doctor_zgzsbh,t.doctor_zghdsj,t.doctor_zyzsbm,t.doctor_fzrq,t.doctor_zyfw,t.doctor_qkysbz,t.doctor_mz,t.doctor_xl,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh,d.department_name");
		sql.append(" ,t.doctor_grzpcfdz,t.doctor_cxbz,t.doctor_zcsj,t.doctor_zyfw_name from doctor_info t,util_department d where t.department_id=d.department_id and t.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("doctor_id"))) {
			sql.append(" and t.doctor_id=:doctor_id ");
			mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				sql.append(" and t.hospital_id = :hospital_id");
				mapSQLParameter.put("hospital_id",  mapStr.get("hospital_id") );
			}
			if (UtilValiDate.isEmpty(mapStr.get("doctor_phone"))) {
				sql.append(" and t.doctor_phone like :doctor_phone");
				mapSQLParameter.put("doctor_phone", "%" + mapStr.get("doctor_phone") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
				sql.append(" and t.doctor_name like :doctor_name");
				mapSQLParameter.put("doctor_name", "%" + mapStr.get("doctor_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("department_name"))) {
				sql.append(" and d.department_name = :department_name");
				mapSQLParameter.put("department_name", mapStr.get("department_name"));
			}
		}
	}

	/**
	 *获取医生基本资料信息列表
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
	 *获取一条医生基本资料信息
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
		sql.append("insert into doctor_info");
		sql.append("( doctor_grzpcfdz,doctor_zcsj,doctor_cxbz,hospital_id,doctor_phone,doctor_paw,doctor_name,doctor_img,doctor_sex,doctot_job_title,doctor_work_address,department_id,doctot_work_day,doctot_birthday,doctor_document_number,doctor_document_img1,doctor_document_img2,doctor_medical_practitioner_certificate,doctor_medical_licence,doctor_technical_certificate,doctor_begoodat,doctor_synopsis,doctor_sort,is_online,doctor_autograph,doctor_zyjszwdm,doctor_zyjszwlbdm,doctor_zzlbmc,doctor_zgzsbh,doctor_zghdsj,doctor_zyzsbm,doctor_fzrq,doctor_zyfw,doctor_qkysbz,doctor_mz,doctor_xl,doctor_zyfw_name");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :doctor_grzpcfdz,:doctor_zcsj,:doctor_cxbz,:hospital_id,:doctor_phone,:doctor_paw,:doctor_name,:doctor_img,:doctor_sex,:doctot_job_title,:doctor_work_address,:department_id,:doctot_work_day,:doctot_birthday,:doctor_document_number,:doctor_document_img1,:doctor_document_img2,:doctor_medical_practitioner_certificate,:doctor_medical_licence,:doctor_technical_certificate,:doctor_begoodat,:doctor_synopsis,:doctor_sort,:is_online,:doctor_autograph,:doctor_zyjszwdm,:doctor_zyjszwlbdm,:doctor_zzlbmc,:doctor_zgzsbh,:doctor_zghdsj,:doctor_zyzsbm,:doctor_fzrq,:doctor_zyfw,:doctor_qkysbz,:doctor_mz,:doctor_xl,:doctor_zyfw_name");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("doctor_cxbz", mapStr.get("doctor_cxbz"));
		mapSQLParameter.put("doctor_zcsj", mapStr.get("doctor_zcsj"));
		mapSQLParameter.put("doctor_grzpcfdz", mapStr.get("doctor_grzpcfdz"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("doctor_phone", mapStr.get("doctor_phone"));
		mapSQLParameter.put("doctor_paw", MD5.EncoderByMd5(mapStr.get("doctor_paw")));
		mapSQLParameter.put("doctor_name", mapStr.get("doctor_name"));
		mapSQLParameter.put("doctor_img", mapStr.get("doctor_img"));
		mapSQLParameter.put("doctor_sex", mapStr.get("doctor_sex"));
		mapSQLParameter.put("doctot_job_title", mapStr.get("doctot_job_title"));
		mapSQLParameter.put("doctor_work_address", mapStr.get("doctor_work_address"));
		mapSQLParameter.put("department_id", mapStr.get("department_id"));
		mapSQLParameter.put("doctot_work_day", mapStr.get("doctot_work_day"));
		mapSQLParameter.put("doctot_birthday", mapStr.get("doctot_birthday"));
		mapSQLParameter.put("doctor_document_number", mapStr.get("doctor_document_number"));
		mapSQLParameter.put("doctor_document_img1", mapStr.get("doctor_document_img1"));
		mapSQLParameter.put("doctor_document_img2", mapStr.get("doctor_document_img2"));
		mapSQLParameter.put("doctor_medical_practitioner_certificate", mapStr.get("doctor_medical_practitioner_certificate"));
		mapSQLParameter.put("doctor_medical_licence", mapStr.get("doctor_medical_licence"));
		mapSQLParameter.put("doctor_technical_certificate", mapStr.get("doctor_technical_certificate"));
		mapSQLParameter.put("doctor_begoodat", mapStr.get("doctor_begoodat"));
		mapSQLParameter.put("doctor_synopsis", mapStr.get("doctor_synopsis"));
		mapSQLParameter.put("doctor_sort", mapStr.get("doctor_sort"));
		mapSQLParameter.put("is_online", mapStr.get("is_online"));
		mapSQLParameter.put("doctor_autograph", mapStr.get("doctor_autograph"));
		mapSQLParameter.put("doctor_zyjszwdm", mapStr.get("doctor_zyjszwdm"));
		mapSQLParameter.put("doctor_zyjszwlbdm", mapStr.get("doctor_zyjszwlbdm"));
		mapSQLParameter.put("doctor_zzlbmc", mapStr.get("doctor_zzlbmc"));
		mapSQLParameter.put("doctor_zgzsbh", mapStr.get("doctor_zgzsbh"));
		mapSQLParameter.put("doctor_zghdsj", mapStr.get("doctor_zghdsj"));
		mapSQLParameter.put("doctor_zyzsbm", mapStr.get("doctor_zyzsbm"));
		mapSQLParameter.put("doctor_fzrq", mapStr.get("doctor_fzrq"));
		mapSQLParameter.put("doctor_zyfw", mapStr.get("doctor_zyfw"));
		mapSQLParameter.put("doctor_qkysbz", mapStr.get("doctor_qkysbz"));
		mapSQLParameter.put("doctor_mz", mapStr.get("doctor_mz"));
		mapSQLParameter.put("doctor_xl", mapStr.get("doctor_xl"));
		mapSQLParameter.put("doctor_zyfw_name", mapStr.get("doctor_zyfw_name"));//增加执业范围名称保存到数据库
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("doctor_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改医生基本资料操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update doctor_info set gxsj=:gxsj");
		if(null!=mapStr.get("doctor_phone")){
			sql.append(",doctor_phone=:doctor_phone");
			mapSQLParameter.put("doctor_phone", mapStr.get("doctor_phone"));
		}
		if(null!=mapStr.get("doctor_zcsj")){
			sql.append(",doctor_zcsj=:doctor_zcsj");
			mapSQLParameter.put("doctor_zcsj", mapStr.get("doctor_zcsj"));
		}
		if(null!=mapStr.get("doctor_cxbz")){
			sql.append(",doctor_cxbz=:doctor_cxbz");
			mapSQLParameter.put("doctor_cxbz",mapStr.get("doctor_cxbz"));
		}
		if(null!=mapStr.get("doctor_grzpcfdz")){
			sql.append(",doctor_grzpcfdz=:doctor_grzpcfdz");
			mapSQLParameter.put("doctor_grzpcfdz",mapStr.get("doctor_grzpcfdz"));
		}
		if(null!=mapStr.get("doctor_paw")){
			sql.append(",doctor_paw=:doctor_paw");
			mapSQLParameter.put("doctor_paw", MD5.EncoderByMd5(mapStr.get("doctor_paw")));
		}
		if(null!=mapStr.get("doctor_openid")){
			sql.append(",doctor_openid=:doctor_openid");
			mapSQLParameter.put("doctor_openid", mapStr.get("doctor_openid"));
		}
		if(null!=mapStr.get("doctor_name")){
			sql.append(",doctor_name=:doctor_name");
			mapSQLParameter.put("doctor_name", mapStr.get("doctor_name"));
		}
		if(null!=mapStr.get("doctor_img")){
			sql.append(",doctor_img=:doctor_img");
			mapSQLParameter.put("doctor_img", mapStr.get("doctor_img"));
		}
		if(null!=mapStr.get("doctor_autograph")){
			sql.append(",doctor_autograph=:doctor_autograph");
			mapSQLParameter.put("doctor_autograph", mapStr.get("doctor_autograph"));
		}
		if(null!=mapStr.get("doctor_sex")){
			sql.append(",doctor_sex=:doctor_sex");
			mapSQLParameter.put("doctor_sex", mapStr.get("doctor_sex"));
		}
		if(null!=mapStr.get("doctot_job_title")){
			sql.append(",doctot_job_title=:doctot_job_title");
			mapSQLParameter.put("doctot_job_title", mapStr.get("doctot_job_title"));
		}
		if(null!=mapStr.get("doctor_work_address")){
			sql.append(",doctor_work_address=:doctor_work_address");
			mapSQLParameter.put("doctor_work_address", mapStr.get("doctor_work_address"));
		}
		if(null!=mapStr.get("department_id")){
			sql.append(",department_id=:department_id");
			mapSQLParameter.put("department_id", mapStr.get("department_id"));
		}
		if(null!=mapStr.get("doctot_work_day")){
			sql.append(",doctot_work_day=:doctot_work_day");
			mapSQLParameter.put("doctot_work_day", mapStr.get("doctot_work_day"));
		}
		if(null!=mapStr.get("doctot_birthday")){
			sql.append(",doctot_birthday=:doctot_birthday");
			mapSQLParameter.put("doctot_birthday", mapStr.get("doctot_birthday"));
		}
		if(null!=mapStr.get("doctor_document_number")){
			sql.append(",doctor_document_number=:doctor_document_number");
			mapSQLParameter.put("doctor_document_number", mapStr.get("doctor_document_number"));
		}
		if(null!=mapStr.get("doctor_document_img1")){
			sql.append(",doctor_document_img1=:doctor_document_img1");
			mapSQLParameter.put("doctor_document_img1", mapStr.get("doctor_document_img1"));
		}
		if(null!=mapStr.get("doctor_document_img2")){
			sql.append(",doctor_document_img2=:doctor_document_img2");
			mapSQLParameter.put("doctor_document_img2", mapStr.get("doctor_document_img2"));
		}
		if(null!=mapStr.get("doctor_medical_practitioner_certificate")){
			sql.append(",doctor_medical_practitioner_certificate=:doctor_medical_practitioner_certificate");
			mapSQLParameter.put("doctor_medical_practitioner_certificate", mapStr.get("doctor_medical_practitioner_certificate"));
		}
		if(null!=mapStr.get("doctor_medical_licence")){
			sql.append(",doctor_medical_licence=:doctor_medical_licence");
			mapSQLParameter.put("doctor_medical_licence", mapStr.get("doctor_medical_licence"));
		}
		if(null!=mapStr.get("doctor_technical_certificate")){
			sql.append(",doctor_technical_certificate=:doctor_technical_certificate");
			mapSQLParameter.put("doctor_technical_certificate", mapStr.get("doctor_technical_certificate"));
		}
		if(null!=mapStr.get("doctor_begoodat")){
			sql.append(",doctor_begoodat=:doctor_begoodat");
			mapSQLParameter.put("doctor_begoodat", mapStr.get("doctor_begoodat"));
		}
		if(null!=mapStr.get("doctor_synopsis")){
			sql.append(",doctor_synopsis=:doctor_synopsis");
			mapSQLParameter.put("doctor_synopsis", mapStr.get("doctor_synopsis"));
		}
		if(null!=mapStr.get("doctor_sort")){
			sql.append(",doctor_sort=:doctor_sort");
			mapSQLParameter.put("doctor_sort", mapStr.get("doctor_sort"));
		}
		if(null!=mapStr.get("is_online")){
			sql.append(",is_online=:is_online");
			mapSQLParameter.put("is_online", mapStr.get("is_online"));
		}
		if(null!=mapStr.get("doctor_zyjszwdm")){
			sql.append(",doctor_zyjszwdm=:doctor_zyjszwdm");
			mapSQLParameter.put("doctor_zyjszwdm", mapStr.get("doctor_zyjszwdm"));
		}
		if(null!=mapStr.get("doctor_zyjszwlbdm")){
			sql.append(",doctor_zyjszwlbdm=:doctor_zyjszwlbdm");
			mapSQLParameter.put("doctor_zyjszwlbdm", mapStr.get("doctor_zyjszwlbdm"));
		}
		if(null!=mapStr.get("doctor_zzlbmc")){
			sql.append(",doctor_zzlbmc=:doctor_zzlbmc");
			mapSQLParameter.put("doctor_zzlbmc", mapStr.get("doctor_zzlbmc"));
		}
		if(null!=mapStr.get("doctor_zgzsbh")){
			sql.append(",doctor_zgzsbh=:doctor_zgzsbh");
			mapSQLParameter.put("doctor_zgzsbh", mapStr.get("doctor_zgzsbh"));
		}
		if(null!=mapStr.get("doctor_zghdsj")){
			sql.append(",doctor_zghdsj=:doctor_zghdsj");
			mapSQLParameter.put("doctor_zghdsj", mapStr.get("doctor_zghdsj"));
		}
		if(null!=mapStr.get("doctor_zyzsbm")){
			sql.append(",doctor_zyzsbm=:doctor_zyzsbm");
			mapSQLParameter.put("doctor_zyzsbm", mapStr.get("doctor_zyzsbm"));
		}
		if(null!=mapStr.get("doctor_fzrq")){
			sql.append(",doctor_fzrq=:doctor_fzrq");
			mapSQLParameter.put("doctor_fzrq", mapStr.get("doctor_fzrq"));
		}
		if(null!=mapStr.get("doctor_zyfw")){
			sql.append(",doctor_zyfw=:doctor_zyfw");
			mapSQLParameter.put("doctor_zyfw", mapStr.get("doctor_zyfw"));
		}
		if(null!=mapStr.get("doctor_qkysbz")){
			sql.append(",doctor_qkysbz=:doctor_qkysbz");
			mapSQLParameter.put("doctor_qkysbz", mapStr.get("doctor_qkysbz"));
		}
		if(null!=mapStr.get("doctor_mz")){
			sql.append(",doctor_mz=:doctor_mz");
			mapSQLParameter.put("doctor_mz", mapStr.get("doctor_mz"));
		}
		if(null!=mapStr.get("doctor_xl")){
			sql.append(",doctor_xl=:doctor_xl");
			mapSQLParameter.put("doctor_xl", mapStr.get("doctor_xl"));
		}
		//保存执业范围名称 2020-03-20 modifyby liwenhai
		if(null!=mapStr.get("doctor_zyfw_name")){
			sql.append(",doctor_zyfw_name=:doctor_zyfw_name");
			mapSQLParameter.put("doctor_zyfw_name", mapStr.get("doctor_zyfw_name"));
		}
		//end
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}

		
		sql.append(" where doctor_id=:doctor_id");
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除医生基本资料操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from doctor_info where doctor_id=:doctor_id");
		mapSQLParameter.put("doctor_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}
	/**
	 *获取医生list
	 */
	public List<Map<String, Object>> doctorList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.doctor_id,t.hospital_id,t.doctor_phone,t.doctor_paw,t.doctor_openid,t.doctor_name,t.doctor_img,t.doctor_sex,t.doctot_job_title,t.doctor_work_address,t.department_id,t.doctot_work_day,t.doctot_birthday,t.doctor_document_number,t.doctor_document_img1,t.doctor_document_img2,t.doctor_medical_practitioner_certificate,t.doctor_medical_licence,t.doctor_technical_certificate,t.doctor_begoodat,t.doctor_synopsis,t.doctor_sort,t.is_online,t.doctor_im,t.doctor_zyfw_name,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from doctor_info t where 1=1");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	
	
	

	/************************系统生成方法完毕******************************/
}