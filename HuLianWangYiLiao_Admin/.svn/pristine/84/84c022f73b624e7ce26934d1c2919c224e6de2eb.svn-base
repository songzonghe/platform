package com.servicesAdmin.util.incompatibility;
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
 * 配伍禁忌 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilIncompatibilityServiceImp")
public class UtilIncompatibilityServiceImp implements UtilIncompatibilityService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取配伍禁忌查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append(" select t.incompatibility_id,t.hospital_id,t.drug_id,t.drug_id2,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(",d1.drug_name as drug_name1 ,d2.drug_name as drug_name2" );
		sql.append(" from util_incompatibility t,util_drug d1 ,util_drug d2");
		sql.append(" where t.drug_id=d1.drug_id and t.drug_id2=d2.drug_id and t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		
		if (UtilValiDate.isEmpty(mapStr.get("incompatibility_id"))) {
			sql.append(" and t.incompatibility_id=:incompatibility_id ");
			mapSQLParameter.put("incompatibility_id", mapStr.get("incompatibility_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("drug_name"))) {
				sql.append(" and d1.drug_name like :drug_name");
				mapSQLParameter.put("drug_name", "%" + mapStr.get("drug_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("drug_name2"))) {
				sql.append(" and d2.drug_name like :drug_name2");
				mapSQLParameter.put("drug_name2", "%" + mapStr.get("drug_name2") + "%");
			}
		}
	}

	/**
	 *获取配伍禁忌信息列表
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
	 *获取一条配伍禁忌信息
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
		sql.append("insert into util_incompatibility");
		sql.append("( hospital_id,drug_id,drug_id2");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:drug_id,:drug_id2");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("drug_id", mapStr.get("drug_id"));
		mapSQLParameter.put("drug_id2", mapStr.get("drug_id2"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("incompatibility_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改配伍禁忌操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_incompatibility set gxsj=:gxsj");
		if(null!=mapStr.get("drug_id")){
			sql.append(",drug_id=:drug_id");
			mapSQLParameter.put("drug_id", mapStr.get("drug_id"));
		}
		if(null!=mapStr.get("drug_id2")){
			sql.append(",drug_id2=:drug_id2");
			mapSQLParameter.put("drug_id2", mapStr.get("drug_id2"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where incompatibility_id=:incompatibility_id");
		mapSQLParameter.put("incompatibility_id", mapStr.get("incompatibility_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除配伍禁忌操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_incompatibility where incompatibility_id=:incompatibility_id");
		mapSQLParameter.put("incompatibility_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/**
	 *判断重复
	 */
	public boolean find_boolMap(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append(" select incompatibility_id,drug_id,drug_id2 from util_incompatibility where 1=1");
		if (UtilValiDate.isEmpty(mapStr.get("drug_id")) && UtilValiDate.isEmpty(mapStr.get("drug_id2"))) {
			sql.append(" and  (drug_id=:drug_id and drug_id2=:drug_id2) or (drug_id2=:drug_id and drug_id=:drug_id2) ");
			mapSQLParameter.put("drug_id", mapStr.get("drug_id"));
			mapSQLParameter.put("drug_id2", mapStr.get("drug_id2"));
		}
		return !this.gyDAOimp.findSqlBool(sql, mapSQLParameter);
	}
	/************************系统生成方法完毕******************************/
}