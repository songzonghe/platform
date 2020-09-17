package com.servicesAdmin.util.questions;
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
 * 常见问题 service 实现类
 * 操作人： 张龙
 */ 
@Service("utilQuestionsServiceImp")
public class UtilQuestionsServiceImp implements UtilQuestionsService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取常见问题查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.questions_id,t.hospital_id,t.questions,t.frequently,t.sort,t.questions_type,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_questions t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("questions_id"))) {
			sql.append(" and t.questions_id=:questions_id ");
			mapSQLParameter.put("questions_id", mapStr.get("questions_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("questions"))) {
				sql.append(" and t.questions like :questions");
				mapSQLParameter.put("questions", "%" + mapStr.get("questions") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("questions_type"))) {
				sql.append(" and t.questions_type = :questions_type");
				mapSQLParameter.put("questions_type", mapStr.get("questions_type"));
			}
		}
	}

	/**
	 *获取常见问题信息列表
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
	 *获取一条常见问题信息
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
		sql.append("insert into util_questions");
		sql.append("( hospital_id,questions,frequently,sort,questions_type");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:questions,:frequently,:sort,:questions_type");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("questions", mapStr.get("questions"));
		mapSQLParameter.put("frequently", mapStr.get("frequently"));
		mapSQLParameter.put("sort", mapStr.get("sort"));
		mapSQLParameter.put("questions_type", mapStr.get("questions_type"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("questions_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改常见问题操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_questions set gxsj=:gxsj");
		if(null!=mapStr.get("questions")){
			sql.append(",questions=:questions");
			mapSQLParameter.put("questions", mapStr.get("questions"));
		}
		if(null!=mapStr.get("frequently")){
			sql.append(",frequently=:frequently");
			mapSQLParameter.put("frequently", mapStr.get("frequently"));
		}
		if(null!=mapStr.get("sort")){
			sql.append(",sort=:sort");
			mapSQLParameter.put("sort", mapStr.get("sort"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",edit_zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		if(null!=mapStr.get("questions_type")){
			sql.append(",questions_type=:questions_type");
			mapSQLParameter.put("questions_type", mapStr.get("questions_type"));
		}
		sql.append(" where questions_id=:questions_id");
		mapSQLParameter.put("questions_id", mapStr.get("questions_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除常见问题操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_questions where questions_id=:questions_id");
		mapSQLParameter.put("questions_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}