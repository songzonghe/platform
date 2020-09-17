package com.servicesAdmin.util.hospital.institution.business;
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
 * 业务开展情况 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilHospitalInstitutionBusinessServiceImp")
public class UtilHospitalInstitutionBusinessServiceImp implements UtilHospitalInstitutionBusinessService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取业务开展情况查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.business_id,t.hospital_id,t.business_nf,t.business_pcjgsl,t.business_bspt,t.business_wljgtdz,t.business_jgmsxx,t.business_jfmj,t.business_zgzs,t.business_khffryzs,t.business_ywyfmj,t.business_zsr,t.business_zzc,t.business_zzch,t.business_ldzc,t.business_dwtz,t.business_gdzc,t.business_wxzcjkbf,t.business_fz,t.business_jzc,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" ,business_cxbz,business_jgdm from util_hospital_institution_business t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("business_id"))) {
			sql.append(" and t.business_id=:business_id ");
			mapSQLParameter.put("business_id", mapStr.get("business_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("business_nf"))) {
				sql.append(" and t.business_nf like :business_nf");
				mapSQLParameter.put("business_nf", "%" + mapStr.get("business_nf") + "%");
			}
		}
	}

	/**
	 *获取业务开展情况信息列表
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
	 *获取一条业务开展情况信息
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
		sql.append("insert into util_hospital_institution_business");
		sql.append("( business_cxbz,business_jgdm,hospital_id,business_nf,business_pcjgsl,business_bspt,business_wljgtdz,business_jgmsxx,business_jfmj,business_zgzs,business_khffryzs,business_ywyfmj,business_zsr,business_zzc,business_zzch,business_ldzc,business_dwtz,business_gdzc,business_wxzcjkbf,business_fz,business_jzc");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :business_cxbz,:business_jgdm,:hospital_id,:business_nf,:business_pcjgsl,:business_bspt,:business_wljgtdz,:business_jgmsxx,:business_jfmj,:business_zgzs,:business_khffryzs,:business_ywyfmj,:business_zsr,:business_zzc,:business_zzch,:business_ldzc,:business_dwtz,:business_gdzc,:business_wxzcjkbf,:business_fz,:business_jzc");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("business_jgdm", mapStr.get("business_jgdm"));
		mapSQLParameter.put("business_cxbz", mapStr.get("business_cxbz"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("business_nf", mapStr.get("business_nf"));
		mapSQLParameter.put("business_pcjgsl", mapStr.get("business_pcjgsl"));
		mapSQLParameter.put("business_bspt", mapStr.get("business_bspt"));
		mapSQLParameter.put("business_wljgtdz", mapStr.get("business_wljgtdz"));
		mapSQLParameter.put("business_jgmsxx", mapStr.get("business_jgmsxx"));
		mapSQLParameter.put("business_jfmj", mapStr.get("business_jfmj"));
		mapSQLParameter.put("business_zgzs", mapStr.get("business_zgzs"));
		mapSQLParameter.put("business_khffryzs", mapStr.get("business_khffryzs"));
		mapSQLParameter.put("business_ywyfmj", mapStr.get("business_ywyfmj"));
		mapSQLParameter.put("business_zsr", mapStr.get("business_zsr"));
		mapSQLParameter.put("business_zzc", mapStr.get("business_zzc"));
		mapSQLParameter.put("business_zzch", mapStr.get("business_zzch"));
		mapSQLParameter.put("business_ldzc", mapStr.get("business_ldzc"));
		mapSQLParameter.put("business_dwtz", mapStr.get("business_dwtz"));
		mapSQLParameter.put("business_gdzc", mapStr.get("business_gdzc"));
		mapSQLParameter.put("business_wxzcjkbf", mapStr.get("business_wxzcjkbf"));
		mapSQLParameter.put("business_fz", mapStr.get("business_fz"));
		mapSQLParameter.put("business_jzc", mapStr.get("business_jzc"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("business_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改业务开展情况操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_hospital_institution_business set gxsj=:gxsj");
		if(null!=mapStr.get("business_jgdm")){
			sql.append(",business_jgdm=:business_jgdm");
			mapSQLParameter.put("business_jgdm", mapStr.get("business_jgdm"));
		}
		if(null!=mapStr.get("business_cxbz")){
			sql.append(",business_cxbz=:business_cxbz");
			mapSQLParameter.put("business_cxbz", mapStr.get("business_cxbz"));
		}
		if(null!=mapStr.get("business_nf")){
			sql.append(",business_nf=:business_nf");
			mapSQLParameter.put("business_nf", mapStr.get("business_nf"));
		}
		if(null!=mapStr.get("business_cxbz")){
			sql.append(",business_cxbz=:business_cxbz");
			mapSQLParameter.put("business_cxbz", mapStr.get("business_cxbz"));
		}
		if(null!=mapStr.get("business_pcjgsl")){
			sql.append(",business_pcjgsl=:business_pcjgsl");
			mapSQLParameter.put("business_pcjgsl", mapStr.get("business_pcjgsl"));
		}
		if(null!=mapStr.get("business_bspt")){
			sql.append(",business_bspt=:business_bspt");
			mapSQLParameter.put("business_bspt", mapStr.get("business_bspt"));
		}
		if(null!=mapStr.get("business_wljgtdz")){
			sql.append(",business_wljgtdz=:business_wljgtdz");
			mapSQLParameter.put("business_wljgtdz", mapStr.get("business_wljgtdz"));
		}
		if(null!=mapStr.get("business_jgmsxx")){
			sql.append(",business_jgmsxx=:business_jgmsxx");
			mapSQLParameter.put("business_jgmsxx", mapStr.get("business_jgmsxx"));
		}
		if(null!=mapStr.get("business_jfmj")){
			sql.append(",business_jfmj=:business_jfmj");
			mapSQLParameter.put("business_jfmj", mapStr.get("business_jfmj"));
		}
		if(null!=mapStr.get("business_zgzs")){
			sql.append(",business_zgzs=:business_zgzs");
			mapSQLParameter.put("business_zgzs", mapStr.get("business_zgzs"));
		}
		if(null!=mapStr.get("business_khffryzs")){
			sql.append(",business_khffryzs=:business_khffryzs");
			mapSQLParameter.put("business_khffryzs", mapStr.get("business_khffryzs"));
		}
		if(null!=mapStr.get("business_ywyfmj")){
			sql.append(",business_ywyfmj=:business_ywyfmj");
			mapSQLParameter.put("business_ywyfmj", mapStr.get("business_ywyfmj"));
		}
		if(null!=mapStr.get("business_zsr")){
			sql.append(",business_zsr=:business_zsr");
			mapSQLParameter.put("business_zsr", mapStr.get("business_zsr"));
		}
		if(null!=mapStr.get("business_zzc")){
			sql.append(",business_zzc=:business_zzc");
			mapSQLParameter.put("business_zzc", mapStr.get("business_zzc"));
		}
		if(null!=mapStr.get("business_zzch")){
			sql.append(",business_zzch=:business_zzch");
			mapSQLParameter.put("business_zzch", mapStr.get("business_zzch"));
		}
		if(null!=mapStr.get("business_ldzc")){
			sql.append(",business_ldzc=:business_ldzc");
			mapSQLParameter.put("business_ldzc", mapStr.get("business_ldzc"));
		}
		if(null!=mapStr.get("business_dwtz")){
			sql.append(",business_dwtz=:business_dwtz");
			mapSQLParameter.put("business_dwtz", mapStr.get("business_dwtz"));
		}
		if(null!=mapStr.get("business_gdzc")){
			sql.append(",business_gdzc=:business_gdzc");
			mapSQLParameter.put("business_gdzc", mapStr.get("business_gdzc"));
		}
		if(null!=mapStr.get("business_wxzcjkbf")){
			sql.append(",business_wxzcjkbf=:business_wxzcjkbf");
			mapSQLParameter.put("business_wxzcjkbf", mapStr.get("business_wxzcjkbf"));
		}
		if(null!=mapStr.get("business_fz")){
			sql.append(",business_fz=:business_fz");
			mapSQLParameter.put("business_fz", mapStr.get("business_fz"));
		}
		if(null!=mapStr.get("business_jzc")){
			sql.append(",business_jzc=:business_jzc");
			mapSQLParameter.put("business_jzc", mapStr.get("business_jzc"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where business_id=:business_id");
		mapSQLParameter.put("business_id", mapStr.get("business_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除业务开展情况操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_hospital_institution_business where business_id=:business_id");
		mapSQLParameter.put("business_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}