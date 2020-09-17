package com.servicesAdmin.util.drug.usage;
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
 * 药品用法 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilDrugUsageServiceImp")
public class UtilDrugUsageServiceImp implements UtilDrugUsageService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取药品用法查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.usage_id,t.hospital_id,t.usage_type,t.usage_name,t.usage_printing_name,t.usage_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_drug_usage t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id",  mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("usage_id"))) {
			sql.append(" and t.usage_id=:usage_id ");
			mapSQLParameter.put("usage_id", mapStr.get("usage_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				sql.append(" and t.hospital_id = :hospital_id");
				mapSQLParameter.put("hospital_id", mapStr.get("hospital_id"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("usage_name"))) {
				sql.append(" and t.usage_name like :usage_name");
				mapSQLParameter.put("usage_name", "%" + mapStr.get("usage_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("usage_type"))) {
				sql.append(" and t.usage_type = :usage_type");
				mapSQLParameter.put("usage_type",  mapStr.get("usage_type"));
			}
		}
	}

	/**
	 *获取药品用法信息列表
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
	 *获取一条药品用法信息
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
		sql.append("insert into util_drug_usage");
		sql.append("( hospital_id,usage_type,usage_name,usage_printing_name,usage_sort");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:usage_type,:usage_name,:usage_printing_name,:usage_sort");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("usage_type", mapStr.get("usage_type"));
		mapSQLParameter.put("usage_name", mapStr.get("usage_name"));
		mapSQLParameter.put("usage_printing_name", mapStr.get("usage_printing_name"));
		mapSQLParameter.put("usage_sort", mapStr.get("usage_sort"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("usage_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改药品用法操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_drug_usage set gxsj=:gxsj");
		if(null!=mapStr.get("usage_type")){
			sql.append(",usage_type=:usage_type");
			mapSQLParameter.put("usage_type", mapStr.get("usage_type"));
		}
		if(null!=mapStr.get("usage_name")){
			sql.append(",usage_name=:usage_name");
			mapSQLParameter.put("usage_name", mapStr.get("usage_name"));
		}
		if(null!=mapStr.get("usage_printing_name")){
			sql.append(",usage_printing_name=:usage_printing_name");
			mapSQLParameter.put("usage_printing_name", mapStr.get("usage_printing_name"));
		}
		if(null!=mapStr.get("usage_sort")){
			sql.append(",usage_sort=:usage_sort");
			mapSQLParameter.put("usage_sort", mapStr.get("usage_sort"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where usage_id=:usage_id");
		mapSQLParameter.put("usage_id", mapStr.get("usage_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除药品用法操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_drug_usage where usage_id=:usage_id");
		mapSQLParameter.put("usage_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}