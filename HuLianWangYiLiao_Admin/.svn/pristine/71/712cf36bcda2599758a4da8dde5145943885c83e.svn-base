package com.servicesAdmin.util.company;
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
 * 厂家 service 实现类
 * 操作人： 刘杰
 */ 
@Service("utilCompanyServiceImp")
public class UtilCompanyServiceImp implements UtilCompanyService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取厂家查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.log_id,t.hospital_id,t.log_name,t.log_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_company t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("log_id"))) {
			sql.append(" and t.log_id=:log_id ");
			mapSQLParameter.put("log_id", mapStr.get("log_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("log_name"))) {
				sql.append(" and t.log_name like :log_name");
				mapSQLParameter.put("log_name", "%" + mapStr.get("log_name") + "%");
			}
		}
	}

	/**
	 *获取厂家信息列表
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
	 *获取一条厂家信息
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
		sql.append("insert into util_company");
		sql.append("( hospital_id,log_name,log_sort");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:log_name,:log_sort");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("log_name", mapStr.get("log_name"));
		mapSQLParameter.put("log_sort", mapStr.get("log_sort"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("log_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改厂家操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_company set gxsj=:gxsj");
		if(null!=mapStr.get("hospital_id")){
			sql.append(",hospital_id=:hospital_id");
			mapSQLParameter.put("hospital_id", mapStr.get("hospital_id"));
		}
		if(null!=mapStr.get("log_name")){
			sql.append(",log_name=:log_name");
			mapSQLParameter.put("log_name", mapStr.get("log_name"));
		}
		if(null!=mapStr.get("log_sort")){
			sql.append(",log_sort=:log_sort");
			mapSQLParameter.put("log_sort", mapStr.get("log_sort"));
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
	 *删除厂家操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_company where log_id=:log_id");
		mapSQLParameter.put("log_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}