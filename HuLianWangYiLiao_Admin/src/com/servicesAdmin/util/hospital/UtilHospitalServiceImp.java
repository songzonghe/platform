package com.servicesAdmin.util.hospital;
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
 * 系统医院 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilHospitalServiceImp")
public class UtilHospitalServiceImp implements UtilHospitalService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取系统医院查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select '"+mapStr.get("login_account_type")+"'as login_account_type, t.hospital_id,t.hospital_logo,t.hospital_number,t.hospital_pwd,t.hospital_name,t.hospital_styymc,t.hospital_jgms,t.hospital_jgdm,t.hospital_zzjgdm,t.hospital_xzqhdm,t.hospital_jglx,t.hospital_jgclrq,t.hospital_dwlsgxdm,t.hospital_jgflgllbdm,t.hospital_jgfldm,t.hospital_jjlxdm,t.hospital_dz,t.hospital_styyzzjgdm,t.hospital_styljgjb,t.hospital_styljgdj,t.hospital_hlwyywz,t.hospital_xkzhm,t.hospital_xkxmmc,t.hospital_xkzyxq,t.hospital_xxaqdjbh,t.hospital_xxaqdjbhbh,t.hospital_kbzjjes,t.hospital_frdb,t.hospital_jgszdmzzzdfbz,t.hospital_sffzjg,t.hospital_jgdemc,t.hospital_dhhm,t.hospital_dwdzyx,t.hospital_yzbm,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" ,t.hospital_cxbz from util_hospital t where 1=1");
		if("1".equals(mapStr.get("login_account_type"))) {
			sql.append(" and t.hospital_id=:hospital_id ");
			mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
			sql.append(" and t.hospital_id=:hospital_id ");
			mapSQLParameter.put("hospital_id", mapStr.get("hospital_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_number"))) {
				sql.append(" and t.hospital_number like :hospital_number");
				mapSQLParameter.put("hospital_number", "%" + mapStr.get("hospital_number") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("hospital_name"))) {
				sql.append(" and t.hospital_name like :hospital_name");
				mapSQLParameter.put("hospital_name", "%" + mapStr.get("hospital_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("find_hospital_number"))) {
				sql.append(" and t.hospital_number = :find_hospital_number");
				mapSQLParameter.put("find_hospital_number", mapStr.get("find_hospital_number"));
			}
		}
	}

	/**
	 *获取系统医院信息列表
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
	 *获取一条系统医院信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		Map<String, Object> findSqlMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		if(findSqlMap.size()>0) {
			findSqlMap.put("showUrl", mapStr.get("showUrl")+MD5.numberEncoder("1-"+findSqlMap.get("hospital_id")));
		}
		return findSqlMap;
	}

	/**
	 *新增操作
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into util_hospital");
		sql.append("( hospital_cxbz,hospital_logo,hospital_number,hospital_pwd,hospital_name,hospital_jgms,hospital_jgdm,hospital_zzjgdm,hospital_xzqhdm,hospital_jglx,hospital_jgclrq,hospital_dwlsgxdm,hospital_jgflgllbdm,hospital_jgfldm,hospital_jjlxdm,hospital_dz,hospital_styyzzjgdm,hospital_styymc,hospital_styljgjb,hospital_styljgdj,hospital_hlwyywz,hospital_xkzhm,hospital_xkxmmc,hospital_xkzyxq,hospital_xxaqdjbh,hospital_xxaqdjbhbh,hospital_kbzjjes,hospital_frdb,hospital_jgszdmzzzdfbz,hospital_sffzjg,hospital_jgdemc,hospital_dhhm,hospital_dwdzyx,hospital_yzbm");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_cxbz,:hospital_logo,:hospital_number,:hospital_pwd,:hospital_name,:hospital_jgms,:hospital_jgdm,:hospital_zzjgdm,:hospital_xzqhdm,:hospital_jglx,:hospital_jgclrq,:hospital_dwlsgxdm,:hospital_jgflgllbdm,:hospital_jgfldm,:hospital_jjlxdm,:hospital_dz,:hospital_styyzzjgdm,:hospital_styymc,:hospital_styljgjb,:hospital_styljgdj,:hospital_hlwyywz,:hospital_xkzhm,:hospital_xkxmmc,:hospital_xkzyxq,:hospital_xxaqdjbh,:hospital_xxaqdjbhbh,:hospital_kbzjjes,:hospital_frdb,:hospital_jgszdmzzzdfbz,:hospital_sffzjg,:hospital_jgdemc,:hospital_dhhm,:hospital_dwdzyx,:hospital_yzbm");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_cxbz", mapStr.get("hospital_cxbz"));
		mapSQLParameter.put("hospital_logo", mapStr.get("hospital_logo"));
		mapSQLParameter.put("hospital_number", mapStr.get("hospital_number"));
		mapSQLParameter.put("hospital_pwd", MD5.EncoderByMd5(mapStr.get("hospital_pwd")));
		mapSQLParameter.put("hospital_name", mapStr.get("hospital_name"));
	
		mapSQLParameter.put("hospital_jgdm", "I"+mapStr.get("hospital_zzjgdm"));//I+实体医院的统一社会信用代码
		mapSQLParameter.put("hospital_zzjgdm", mapStr.get("hospital_zzjgdm"));
		mapSQLParameter.put("hospital_xzqhdm", mapStr.get("hospital_xzqhdm"));
		mapSQLParameter.put("hospital_jglx", mapStr.get("hospital_jglx"));
		mapSQLParameter.put("hospital_jgclrq", mapStr.get("hospital_jgclrq"));
		mapSQLParameter.put("hospital_dwlsgxdm", mapStr.get("hospital_dwlsgxdm"));
		mapSQLParameter.put("hospital_jgflgllbdm", mapStr.get("hospital_jgflgllbdm"));
		mapSQLParameter.put("hospital_jgfldm", mapStr.get("hospital_jgfldm"));
		mapSQLParameter.put("hospital_jjlxdm", mapStr.get("hospital_jjlxdm"));
		mapSQLParameter.put("hospital_dz", mapStr.get("hospital_dz"));
		mapSQLParameter.put("hospital_styyzzjgdm", mapStr.get("hospital_styyzzjgdm"));
		mapSQLParameter.put("hospital_styymc", mapStr.get("hospital_styymc"));
		mapSQLParameter.put("hospital_styljgjb", mapStr.get("hospital_styljgjb"));
		mapSQLParameter.put("hospital_styljgdj", mapStr.get("hospital_styljgdj"));
		mapSQLParameter.put("hospital_hlwyywz", mapStr.get("hospital_hlwyywz"));
		mapSQLParameter.put("hospital_xkzhm", mapStr.get("hospital_xkzhm"));
		mapSQLParameter.put("hospital_xkxmmc", mapStr.get("hospital_xkxmmc"));
		mapSQLParameter.put("hospital_xkzyxq", mapStr.get("hospital_xkzyxq"));
		mapSQLParameter.put("hospital_xxaqdjbh", mapStr.get("hospital_xxaqdjbh"));
		mapSQLParameter.put("hospital_xxaqdjbhbh", mapStr.get("hospital_xxaqdjbhbh"));
		mapSQLParameter.put("hospital_kbzjjes", mapStr.get("hospital_kbzjjes"));
		mapSQLParameter.put("hospital_frdb", mapStr.get("hospital_frdb"));
		mapSQLParameter.put("hospital_jgszdmzzzdfbz", mapStr.get("hospital_jgszdmzzzdfbz"));
		mapSQLParameter.put("hospital_sffzjg", mapStr.get("hospital_sffzjg"));
		mapSQLParameter.put("hospital_jgdemc", mapStr.get("hospital_jgdemc"));
		mapSQLParameter.put("hospital_dhhm", mapStr.get("hospital_dhhm"));
		mapSQLParameter.put("hospital_dwdzyx", mapStr.get("hospital_dwdzyx"));
		mapSQLParameter.put("hospital_yzbm", mapStr.get("hospital_yzbm"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("hospital_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		//新增登录账号
		sql.delete(0, sql.length());
		sql.append("insert into system_account");
		sql.append("( hospital_id,account_type,account_number,account_pwd,account_name,functions_id,other_id");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:account_type,:account_number,:account_pwd,:account_name,:functions_id,:other_id");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("hospital_id"));
		mapSQLParameter.put("account_type", "1");
		mapSQLParameter.put("account_number", mapStr.get("hospital_number"));
		mapSQLParameter.put("account_pwd", MD5.EncoderByMd5(mapStr.get("hospital_pwd")));
		mapSQLParameter.put("account_name", mapStr.get("hospital_name"));
		mapSQLParameter.put("functions_id", "");
		mapSQLParameter.put("other_id", "0");
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *修改系统医院操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_hospital set gxsj=:gxsj");
		if(null!=mapStr.get("hospital_cxbz")){
			sql.append(",hospital_cxbz=:hospital_cxbz");
			mapSQLParameter.put("hospital_cxbz", mapStr.get("hospital_cxbz"));
		}
		if(null!=mapStr.get("hospital_logo")){
			sql.append(",hospital_logo=:hospital_logo");
			mapSQLParameter.put("hospital_logo", mapStr.get("hospital_logo"));
		}
		if(null!=mapStr.get("hospital_pwd")){
			sql.append(",hospital_pwd=:hospital_pwd");
			mapSQLParameter.put("hospital_pwd", MD5.EncoderByMd5(mapStr.get("hospital_pwd")));
		}
		if(null!=mapStr.get("hospital_name")){
			sql.append(",hospital_name=:hospital_name");
			mapSQLParameter.put("hospital_name", mapStr.get("hospital_name"));
		}
		if(null!=mapStr.get("hospital_jgms")){
			sql.append(",hospital_jgms=:hospital_jgms");
			mapSQLParameter.put("hospital_jgms", mapStr.get("hospital_jgms"));
		}
		
//		if(null!=mapStr.get("hospital_zzjgdm")){
//			sql.append(",hospital_zzjgdm=:hospital_zzjgdm,hospital_jgdm=:hospital_jgdm");
//			mapSQLParameter.put("hospital_jgdm", "I"+mapStr.get("hospital_zzjgdm"));//I+实体医院的统一社会信用代码
//			mapSQLParameter.put("hospital_zzjgdm", mapStr.get("hospital_zzjgdm"));
//		}
		
		//modify by liwenhai 2020-03-20		把填写框分开处理
		if(null!=mapStr.get("hospital_jgdm")){
			sql.append(",hospital_jgdm=:hospital_jgdm");
			mapSQLParameter.put("hospital_jgdm", mapStr.get("hospital_jgdm"));
		}
		
		if(null!=mapStr.get("hospital_zzjgdm")){
			sql.append(",hospital_zzjgdm=:hospital_zzjgdm");
			mapSQLParameter.put("hospital_zzjgdm", mapStr.get("hospital_zzjgdm"));
		}
		//modify end
		
		if(null!=mapStr.get("hospital_xzqhdm")){
			sql.append(",hospital_xzqhdm=:hospital_xzqhdm");
			mapSQLParameter.put("hospital_xzqhdm", mapStr.get("hospital_xzqhdm"));
		}
		if(null!=mapStr.get("hospital_jglx")){
			sql.append(",hospital_jglx=:hospital_jglx");
			mapSQLParameter.put("hospital_jglx", mapStr.get("hospital_jglx"));
		}
		if(null!=mapStr.get("hospital_jgclrq")){
			sql.append(",hospital_jgclrq=:hospital_jgclrq");
			mapSQLParameter.put("hospital_jgclrq", mapStr.get("hospital_jgclrq"));
		}
		
		if(null!=mapStr.get("hospital_dwlsgxdm")){
			sql.append(",hospital_dwlsgxdm=:hospital_dwlsgxdm");
			mapSQLParameter.put("hospital_dwlsgxdm", mapStr.get("hospital_dwlsgxdm"));
		}
		if(null!=mapStr.get("hospital_jgflgllbdm")){
			sql.append(",hospital_jgflgllbdm=:hospital_jgflgllbdm");
			mapSQLParameter.put("hospital_jgflgllbdm", mapStr.get("hospital_jgflgllbdm"));
		}
		if(null!=mapStr.get("hospital_jgfldm")){
			sql.append(",hospital_jgfldm=:hospital_jgfldm");
			mapSQLParameter.put("hospital_jgfldm", mapStr.get("hospital_jgfldm"));
		}
		if(null!=mapStr.get("hospital_jjlxdm")){
			sql.append(",hospital_jjlxdm=:hospital_jjlxdm");
			mapSQLParameter.put("hospital_jjlxdm", mapStr.get("hospital_jjlxdm"));
		}
		if(null!=mapStr.get("hospital_dz")){
			sql.append(",hospital_dz=:hospital_dz");
			mapSQLParameter.put("hospital_dz", mapStr.get("hospital_dz"));
		}
		if(null!=mapStr.get("hospital_styyzzjgdm")){
			sql.append(",hospital_styyzzjgdm=:hospital_styyzzjgdm");
			mapSQLParameter.put("hospital_styyzzjgdm", mapStr.get("hospital_styyzzjgdm"));
		}
		if(null!=mapStr.get("hospital_styymc")){
			sql.append(",hospital_styymc=:hospital_styymc");
			mapSQLParameter.put("hospital_styymc", mapStr.get("hospital_styymc"));
		}
		if(null!=mapStr.get("hospital_styljgjb")){
			sql.append(",hospital_styljgjb=:hospital_styljgjb");
			mapSQLParameter.put("hospital_styljgjb", mapStr.get("hospital_styljgjb"));
		}
		if(null!=mapStr.get("hospital_styljgdj")){
			sql.append(",hospital_styljgdj=:hospital_styljgdj");
			mapSQLParameter.put("hospital_styljgdj", mapStr.get("hospital_styljgdj"));
		}
		if(null!=mapStr.get("hospital_hlwyywz")){
			sql.append(",hospital_hlwyywz=:hospital_hlwyywz");
			mapSQLParameter.put("hospital_hlwyywz", mapStr.get("hospital_hlwyywz"));
		}
		if(null!=mapStr.get("hospital_xkzhm")){
			sql.append(",hospital_xkzhm=:hospital_xkzhm");
			mapSQLParameter.put("hospital_xkzhm", mapStr.get("hospital_xkzhm"));
		}
		if(null!=mapStr.get("hospital_xkxmmc")){
			sql.append(",hospital_xkxmmc=:hospital_xkxmmc");
			mapSQLParameter.put("hospital_xkxmmc", mapStr.get("hospital_xkxmmc"));
		}
		if(null!=mapStr.get("hospital_xkzyxq")){
			sql.append(",hospital_xkzyxq=:hospital_xkzyxq");
			mapSQLParameter.put("hospital_xkzyxq", mapStr.get("hospital_xkzyxq"));
		}
		if(null!=mapStr.get("hospital_xxaqdjbh")){
			sql.append(",hospital_xxaqdjbh=:hospital_xxaqdjbh");
			mapSQLParameter.put("hospital_xxaqdjbh", mapStr.get("hospital_xxaqdjbh"));
		}
		if(null!=mapStr.get("hospital_xxaqdjbhbh")){
			sql.append(",hospital_xxaqdjbhbh=:hospital_xxaqdjbhbh");
			mapSQLParameter.put("hospital_xxaqdjbhbh", mapStr.get("hospital_xxaqdjbhbh"));
		}
		if(null!=mapStr.get("hospital_kbzjjes")){
			sql.append(",hospital_kbzjjes=:hospital_kbzjjes");
			mapSQLParameter.put("hospital_kbzjjes", mapStr.get("hospital_kbzjjes"));
		}
		if(null!=mapStr.get("hospital_frdb")){
			sql.append(",hospital_frdb=:hospital_frdb");
			mapSQLParameter.put("hospital_frdb", mapStr.get("hospital_frdb"));
		}
		if(null!=mapStr.get("hospital_jgszdmzzzdfbz")){
			sql.append(",hospital_jgszdmzzzdfbz=:hospital_jgszdmzzzdfbz");
			mapSQLParameter.put("hospital_jgszdmzzzdfbz", mapStr.get("hospital_jgszdmzzzdfbz"));
		}
		if(null!=mapStr.get("hospital_sffzjg")){
			sql.append(",hospital_sffzjg=:hospital_sffzjg");
			mapSQLParameter.put("hospital_sffzjg", mapStr.get("hospital_sffzjg"));
		}
		if(null!=mapStr.get("hospital_jgdemc")){
			sql.append(",hospital_jgdemc=:hospital_jgdemc");
			mapSQLParameter.put("hospital_jgdemc", mapStr.get("hospital_jgdemc"));
		}
		if(null!=mapStr.get("hospital_dhhm")){
			sql.append(",hospital_dhhm=:hospital_dhhm");
			mapSQLParameter.put("hospital_dhhm", mapStr.get("hospital_dhhm"));
		}
		if(null!=mapStr.get("hospital_dwdzyx")){
			sql.append(",hospital_dwdzyx=:hospital_dwdzyx");
			mapSQLParameter.put("hospital_dwdzyx", mapStr.get("hospital_dwdzyx"));
		}
		if(null!=mapStr.get("hospital_yzbm")){
			sql.append(",hospital_yzbm=:hospital_yzbm");
			mapSQLParameter.put("hospital_yzbm", mapStr.get("hospital_yzbm"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("hospital_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除系统医院操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_hospital where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}