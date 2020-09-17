package com.servicesAdmin.pharmacist.info;
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
 * 药师管理 service 实现类
 * 操作人： 张龙
 */ 
@Service("pharmacistInfoServiceImp")
public class PharmacistInfoServiceImp implements PharmacistInfoService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取药师管理查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.pharmacist_id,t.hospital_id,t.pharmacist_number,t.pharmacist_paw,t.pharmacist_name,t.pharmacist_phone,t.pharmacist_img,t.pharmacist_autograph,t.pharmacist_sex,t.pharmacist_document_number,t.pharmacist_document_img1,t.pharmacist_document_img2,t.pharmacist_medical_practitioner_certificate,t.pharmacist_medical_licence,t.pharmacist_synopsis,t.pharmacist_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from pharmacist_info t where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		
		if (UtilValiDate.isEmpty(mapStr.get("pharmacist_id"))) {
			sql.append(" and t.pharmacist_id=:pharmacist_id ");
			mapSQLParameter.put("pharmacist_id", mapStr.get("pharmacist_id"));
		}else{
			if (UtilValiDate.isEmpty(mapStr.get("find_number"))) {//验证判断
				sql.append(" and t.pharmacist_number = :find_number");
				mapSQLParameter.put("find_number",mapStr.get("find_number"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("pharmacist_number"))) {
				sql.append(" and t.pharmacist_number like :pharmacist_number");
				mapSQLParameter.put("pharmacist_number", "%" + mapStr.get("pharmacist_number") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("pharmacist_name"))) {
				sql.append(" and t.pharmacist_name like :pharmacist_name");
				mapSQLParameter.put("pharmacist_name", "%" + mapStr.get("pharmacist_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("zTai"))) {
				sql.append(" and t.zt = :zt");
				mapSQLParameter.put("zt",mapStr.get("zTai"));
			}
			
		}
	}

	/**
	 *获取药师管理信息列表
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
	 *获取一条药师管理信息
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
		sql.append("insert into pharmacist_info");
		sql.append("( hospital_id,pharmacist_number,pharmacist_paw,pharmacist_name,pharmacist_phone,pharmacist_img,pharmacist_autograph,pharmacist_sex,pharmacist_document_number,pharmacist_document_img1,pharmacist_document_img2,pharmacist_medical_practitioner_certificate,pharmacist_medical_licence,pharmacist_synopsis,pharmacist_sort");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:pharmacist_number,:pharmacist_paw,:pharmacist_name,:pharmacist_phone,:pharmacist_img,:pharmacist_autograph,:pharmacist_sex,:pharmacist_document_number,:pharmacist_document_img1,:pharmacist_document_img2,:pharmacist_medical_practitioner_certificate,:pharmacist_medical_licence,:pharmacist_synopsis,:pharmacist_sort");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("pharmacist_number", mapStr.get("pharmacist_number"));
		mapSQLParameter.put("pharmacist_paw", MD5.EncoderByMd5(mapStr.get("pharmacist_paw")));
		mapSQLParameter.put("pharmacist_name", mapStr.get("pharmacist_name"));
		mapSQLParameter.put("pharmacist_phone", mapStr.get("pharmacist_phone"));
		mapSQLParameter.put("pharmacist_img", mapStr.get("pharmacist_img"));
		mapSQLParameter.put("pharmacist_autograph", mapStr.get("pharmacist_autograph"));
		mapSQLParameter.put("pharmacist_sex", mapStr.get("pharmacist_sex"));
		mapSQLParameter.put("pharmacist_document_number", mapStr.get("pharmacist_document_number"));
		mapSQLParameter.put("pharmacist_document_img1", mapStr.get("pharmacist_document_img1"));
		mapSQLParameter.put("pharmacist_document_img2", mapStr.get("pharmacist_document_img2"));
		mapSQLParameter.put("pharmacist_medical_practitioner_certificate", mapStr.get("pharmacist_medical_practitioner_certificate"));
		mapSQLParameter.put("pharmacist_medical_licence", mapStr.get("pharmacist_medical_licence"));
		mapSQLParameter.put("pharmacist_synopsis", mapStr.get("pharmacist_synopsis"));
		mapSQLParameter.put("pharmacist_sort", mapStr.get("pharmacist_sort"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("pharmacist_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		Map<String, Object> find_Map = this.find_Map(mapStr);
		//添加登录账号
		sql.delete(0, sql.length());
		sql.append("insert into system_account");
		sql.append("( hospital_id,account_type,account_number,account_pwd,account_name,functions_id,other_id");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:account_type,:pharmacist_number,:pharmacist_paw,:pharmacist_name,'',:other_id");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("other_id", mapStr.get("pharmacist_id"));
		mapSQLParameter.put("account_type", "2");
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return find_Map;
	}

	/**
	 *修改药师管理操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update pharmacist_info set gxsj=:gxsj");
		if(UtilValiDate.isEmpty(mapStr.get("pharmacist_paw"))){
			sql.append(",pharmacist_paw=:pharmacist_paw");
			mapSQLParameter.put("pharmacist_paw", MD5.EncoderByMd5(mapStr.get("pharmacist_paw")));
		}
		if(null!=mapStr.get("pharmacist_name")){
			sql.append(",pharmacist_name=:pharmacist_name");
			mapSQLParameter.put("pharmacist_name", mapStr.get("pharmacist_name"));
		}
		if(null!=mapStr.get("pharmacist_phone")){
			sql.append(",pharmacist_phone=:pharmacist_phone");
			mapSQLParameter.put("pharmacist_phone", mapStr.get("pharmacist_phone"));
		}
		if(null!=mapStr.get("pharmacist_img")){
			sql.append(",pharmacist_img=:pharmacist_img");
			mapSQLParameter.put("pharmacist_img", mapStr.get("pharmacist_img"));
		}
		if(null!=mapStr.get("pharmacist_autograph")){
			sql.append(",pharmacist_autograph=:pharmacist_autograph");
			mapSQLParameter.put("pharmacist_autograph", mapStr.get("pharmacist_autograph"));
		}
		if(null!=mapStr.get("pharmacist_sex")){
			sql.append(",pharmacist_sex=:pharmacist_sex");
			mapSQLParameter.put("pharmacist_sex", mapStr.get("pharmacist_sex"));
		}
		if(null!=mapStr.get("pharmacist_document_number")){
			sql.append(",pharmacist_document_number=:pharmacist_document_number");
			mapSQLParameter.put("pharmacist_document_number", mapStr.get("pharmacist_document_number"));
		}
		if(null!=mapStr.get("pharmacist_document_img1")){
			sql.append(",pharmacist_document_img1=:pharmacist_document_img1");
			mapSQLParameter.put("pharmacist_document_img1", mapStr.get("pharmacist_document_img1"));
		}
		if(null!=mapStr.get("pharmacist_document_img2")){
			sql.append(",pharmacist_document_img2=:pharmacist_document_img2");
			mapSQLParameter.put("pharmacist_document_img2", mapStr.get("pharmacist_document_img2"));
		}
		if(null!=mapStr.get("pharmacist_medical_practitioner_certificate")){
			sql.append(",pharmacist_medical_practitioner_certificate=:pharmacist_medical_practitioner_certificate");
			mapSQLParameter.put("pharmacist_medical_practitioner_certificate", mapStr.get("pharmacist_medical_practitioner_certificate"));
		}
		if(null!=mapStr.get("pharmacist_medical_licence")){
			sql.append(",pharmacist_medical_licence=:pharmacist_medical_licence");
			mapSQLParameter.put("pharmacist_medical_licence", mapStr.get("pharmacist_medical_licence"));
		}
		if(null!=mapStr.get("pharmacist_synopsis")){
			sql.append(",pharmacist_synopsis=:pharmacist_synopsis");
			mapSQLParameter.put("pharmacist_synopsis", mapStr.get("pharmacist_synopsis"));
		}
		if(null!=mapStr.get("pharmacist_sort")){
			sql.append(",pharmacist_sort=:pharmacist_sort");
			mapSQLParameter.put("pharmacist_sort", mapStr.get("pharmacist_sort"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where pharmacist_id=:pharmacist_id");
		mapSQLParameter.put("pharmacist_id", mapStr.get("pharmacist_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		Map<String, Object> find_Map = this.find_Map(mapStr);
		
		//修改登录信息
		sql.delete(0,sql.length());
		sql.append("update system_account set gxsj=:gxsj,account_pwd=:account_pwd,account_name=:account_name,zt=:zt where account_type=2 and other_id=:pharmacist_id");
		mapSQLParameter.put("account_pwd", find_Map.get("pharmacist_paw"));
		mapSQLParameter.put("account_name", find_Map.get("pharmacist_name"));
		mapSQLParameter.put("zt", find_Map.get("zt"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
		return find_Map;
	}

	/**
	 *删除药师管理操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from pharmacist_info where pharmacist_id=:pharmacist_id");
		mapSQLParameter.put("pharmacist_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		//删除登录账号
		sql.append("delete from system_account where account_type=2 and other_id=:pharmacist_id");
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
	}

	/************************系统生成方法完毕******************************/
}