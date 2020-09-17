package com.servicesAdmin.util.cooperative.enterprises;
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
 * 合作企业 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilCooperativeEnterprisesServiceImp")
public class UtilCooperativeEnterprisesServiceImp implements UtilCooperativeEnterprisesService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取合作企业查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.enterprises_id,t.hospital_id,t.enterprises_name,t.enterprises_img,t.enterprises_sort,t.enterprises_url,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_cooperative_enterprises t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("enterprises_id"))) {
			sql.append(" and t.enterprises_id=:enterprises_id ");
			mapSQLParameter.put("enterprises_id", mapStr.get("enterprises_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("enterprises_name"))) {
				sql.append(" and t.enterprises_name like :enterprises_name");
				mapSQLParameter.put("enterprises_name", "%" + mapStr.get("enterprises_name") + "%");
			}
		}
	}

	/**
	 *获取合作企业信息列表
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
	 *获取一条合作企业信息
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
		sql.append("insert into util_cooperative_enterprises");
		sql.append("( hospital_id,enterprises_name,enterprises_img,enterprises_sort,enterprises_url");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:enterprises_name,:enterprises_img,:enterprises_sort,:enterprises_url");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("enterprises_name", mapStr.get("enterprises_name"));
		mapSQLParameter.put("enterprises_img", mapStr.get("enterprises_img"));
		mapSQLParameter.put("enterprises_sort", mapStr.get("enterprises_sort"));
		mapSQLParameter.put("enterprises_url", mapStr.get("enterprises_url"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("enterprises_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改合作企业操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_cooperative_enterprises set gxsj=:gxsj");
		if(null!=mapStr.get("hospital_id")){
			sql.append(",hospital_id=:login_hospital_id");
			mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		}
		if(null!=mapStr.get("hospital_id")){
			sql.append(",hospital_id=:hospital_id");
			mapSQLParameter.put("hospital_id", mapStr.get("hospital_id"));
		}
		if(null!=mapStr.get("enterprises_name")){
			sql.append(",enterprises_name=:enterprises_name");
			mapSQLParameter.put("enterprises_name", mapStr.get("enterprises_name"));
		}
		if(null!=mapStr.get("enterprises_img")){
			sql.append(",enterprises_img=:enterprises_img");
			mapSQLParameter.put("enterprises_img", mapStr.get("enterprises_img"));
		}
		if(null!=mapStr.get("enterprises_sort")){
			sql.append(",enterprises_sort=:enterprises_sort");
			mapSQLParameter.put("enterprises_sort", mapStr.get("enterprises_sort"));
		}
		if(null!=mapStr.get("enterprises_url")){
			sql.append(",enterprises_url=:enterprises_url");
			mapSQLParameter.put("enterprises_url", mapStr.get("enterprises_url"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where enterprises_id=:enterprises_id");
		mapSQLParameter.put("enterprises_id", mapStr.get("enterprises_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除合作企业操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_cooperative_enterprises where enterprises_id=:enterprises_id");
		mapSQLParameter.put("enterprises_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}