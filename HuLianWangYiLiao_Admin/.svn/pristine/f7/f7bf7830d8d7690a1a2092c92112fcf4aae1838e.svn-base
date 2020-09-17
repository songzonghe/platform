package com.servicesAdmin.util.specification;
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
 * 问诊规范 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilSpecificationServiceImp")
public class UtilSpecificationServiceImp implements UtilSpecificationService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取问诊规范查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.specification_id,t.hospital_id,t.specification_name,t.specification_details,t.specification_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_specification t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("specification_id"))) {
			sql.append(" and t.specification_id=:specification_id ");
			mapSQLParameter.put("specification_id", mapStr.get("specification_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				sql.append(" and t.hospital_id = :hospital_id");
				mapSQLParameter.put("hospital_id",  mapStr.get("hospital_id") );
			}
			if (UtilValiDate.isEmpty(mapStr.get("specification_name"))) {
				sql.append(" and t.specification_name like :specification_name");
				mapSQLParameter.put("specification_name", "%" + mapStr.get("specification_name") + "%");
			}
		}
	}

	/**
	 *获取问诊规范信息列表
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
	 *获取一条问诊规范信息
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
		sql.append("insert into util_specification");
		sql.append("( hospital_id,specification_name,specification_details,specification_sort");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:specification_name,:specification_details,:specification_sort");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("specification_name", mapStr.get("specification_name"));
		mapSQLParameter.put("specification_details", mapStr.get("specification_details"));
		mapSQLParameter.put("specification_sort", mapStr.get("specification_sort"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("specification_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改问诊规范操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_specification set gxsj=:gxsj");
		if(null!=mapStr.get("specification_name")){
			sql.append(",specification_name=:specification_name");
			mapSQLParameter.put("specification_name", mapStr.get("specification_name"));
		}
		if(null!=mapStr.get("specification_details")){
			sql.append(",specification_details=:specification_details");
			mapSQLParameter.put("specification_details", mapStr.get("specification_details"));
		}
		if(null!=mapStr.get("specification_sort")){
			sql.append(",specification_sort=:specification_sort");
			mapSQLParameter.put("specification_sort", mapStr.get("specification_sort"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where specification_id=:specification_id");
		mapSQLParameter.put("specification_id", mapStr.get("specification_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除问诊规范操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_specification where specification_id=:specification_id");
		mapSQLParameter.put("specification_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}