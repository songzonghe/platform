package com.servicesAdmin.user.info;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.MD5;
import com.util.SysFinal;
import com.util.UtilSql;
import com.util.UtilStr;
import com.util.UtilValiDate;
/**
 * 用户基本资料 service 实现类
 * 操作人： 曾晓
 */ 
@Service("userInfoServiceImp")
public class UserInfoServiceImp implements UserInfoService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取用户基本资料查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.user_id,t.hospital_id,t.user_phone,t.user_paw,t.user_openid,t.user_nickname,t.user_img,t.user_name,t.user_document_number,t.user_document_img1,t.user_document_img2,t.user_im,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from user_info t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("user_id"))) {
			sql.append(" and t.user_id=:user_id ");
			mapSQLParameter.put("user_id", mapStr.get("user_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				sql.append(" and t.hospital_id = :hospital_id");
				mapSQLParameter.put("hospital_id",  mapStr.get("hospital_id") );
			}
			if (UtilValiDate.isEmpty(mapStr.get("user_phone"))) {
				sql.append(" and t.user_phone like :user_phone");
				mapSQLParameter.put("user_phone", "%" + mapStr.get("user_phone") + "%");
			}
		}
	}

	/**
	 *获取用户基本资料信息列表
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
	 *获取一条用户基本资料信息
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
		sql.append("insert into user_info");
		sql.append("( hospital_id,user_phone,user_paw,user_nickname,user_img,user_name,user_document_number,user_document_img1,user_document_img2");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:user_phone,:user_paw,:user_nickname,:user_img,:user_name,:user_document_number,:user_document_img1,:user_document_img2");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("user_phone", mapStr.get("user_phone"));
		mapSQLParameter.put("user_paw", MD5.EncoderByMd5(mapStr.get("user_paw")));
		mapSQLParameter.put("user_nickname", mapStr.get("user_nickname"));
		mapSQLParameter.put("user_img", mapStr.get("user_img"));
		mapSQLParameter.put("user_name", mapStr.get("user_name"));
		mapSQLParameter.put("user_document_number", mapStr.get("user_document_number"));
		mapSQLParameter.put("user_document_img1", mapStr.get("user_document_img1"));
		mapSQLParameter.put("user_document_img2", mapStr.get("user_document_img2"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("user_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改用户基本资料操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update user_info set gxsj=:gxsj");
		if(null!=mapStr.get("hospital_id")){
			sql.append(",hospital_id=:hospital_id");
			mapSQLParameter.put("hospital_id", mapStr.get("hospital_id"));
		}
		if(null!=mapStr.get("user_phone")){
			sql.append(",user_phone=:user_phone");
			mapSQLParameter.put("user_phone", mapStr.get("user_phone"));
		}
		if(null!=mapStr.get("user_paw")){
			sql.append(",user_paw=:user_paw");
			mapSQLParameter.put("user_paw", MD5.EncoderByMd5(mapStr.get("user_paw")));
		}
		if(null!=mapStr.get("user_openid")){
			sql.append(",user_openid=:user_openid");
			mapSQLParameter.put("user_openid", mapStr.get("user_openid"));
		}
		if(null!=mapStr.get("user_nickname")){
			sql.append(",user_nickname=:user_nickname");
			mapSQLParameter.put("user_nickname", mapStr.get("user_nickname"));
		}
		if(null!=mapStr.get("user_img")){
			sql.append(",user_img=:user_img");
			mapSQLParameter.put("user_img", mapStr.get("user_img"));
		}
		if(null!=mapStr.get("user_name")){
			sql.append(",user_name=:user_name");
			mapSQLParameter.put("user_name", mapStr.get("user_name"));
		}
		if(null!=mapStr.get("user_document_number")){
			sql.append(",user_document_number=:user_document_number");
			mapSQLParameter.put("user_document_number", mapStr.get("user_document_number"));
		}
		if(null!=mapStr.get("user_document_img1")){
			sql.append(",user_document_img1=:user_document_img1");
			mapSQLParameter.put("user_document_img1", mapStr.get("user_document_img1"));
		}
		if(null!=mapStr.get("user_document_img2")){
			sql.append(",user_document_img2=:user_document_img2");
			mapSQLParameter.put("user_document_img2", mapStr.get("user_document_img2"));
		}
		if(null!=mapStr.get("user_im")){
			sql.append(",user_im=:user_im");
			mapSQLParameter.put("user_im", mapStr.get("user_im"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where user_id=:user_id");
		mapSQLParameter.put("user_id", mapStr.get("user_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除用户基本资料操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from user_info where user_id=:user_id");
		mapSQLParameter.put("user_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}
	
	/**
	 *获取用户list
	 */
	public List<Map<String, Object>> personList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		System.out.println(mapStr.get("type"));
		//接收人类型   1用户  2门店  3医生
		if("1".equals(UtilStr.getStr(mapStr.get("type")))) {
			sql.append("select t.user_id,t.hospital_id,t.user_phone,t.user_paw,t.user_openid,t.user_nickname,t.user_img,t.user_name,t.user_document_number,t.user_document_img1,t.user_document_img2,t.user_im,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
			sql.append(" from user_info t where 1=1");
		}else if("2".equals(UtilStr.getStr(mapStr.get("type")))) {
			sql.append("select t.store_id,t.hospital_id,t.store_phone,t.store_paw,t.store_name,t.store_img,t.store_im,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
			sql.append(" from store_info t where 1=1");
		}else if("3".equals(UtilStr.getStr(mapStr.get("type")))) {
			sql.append("select t.doctor_id,t.hospital_id,t.doctor_phone,t.doctor_paw,t.doctor_openid,t.doctor_name,t.doctor_img,t.doctor_sex,t.doctot_job_title,t.doctor_work_address,t.department_id,t.doctot_work_day,t.doctot_birthday,t.doctor_document_number,t.doctor_document_img1,t.doctor_document_img2,t.doctor_medical_practitioner_certificate,t.doctor_medical_licence,t.doctor_technical_certificate,t.doctor_begoodat,t.doctor_synopsis,t.doctor_sort,t.is_online,t.doctor_im,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh,d.department_name");
			sql.append(" from doctor_info t,util_department d where t.department_id=d.department_id");
		}else {
			sql.append("select t.user_id,t.hospital_id,t.user_phone,t.user_paw,t.user_openid,t.user_nickname,t.user_img,t.user_name,t.user_document_number,t.user_document_img1,t.user_document_img2,t.user_im,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
			sql.append(" from user_info t where 1=1");
		}
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	

	/************************系统生成方法完毕******************************/
}