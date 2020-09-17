package com.servicesAdmin.util.checklist.checklistClass;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.UtilSql;
import com.util.UtilValiDate;
/**
 * 检验检查分类表 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilChecklistClassServiceImp")
public class UtilChecklistClassServiceImp implements UtilChecklistClassService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取检验检查分类表查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.checklist_class_id,t.hospital_id,t.checklist_class_name,t.checklist_up_class_id ,");
		sql.append(" t.checklist_class_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh from util_checklist_class t  where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id",  mapStr.get("login_hospital_id") );
		if (UtilValiDate.isEmpty(mapStr.get("checklist_class_id"))) {
			sql.append(" and t.checklist_class_id=:checklist_class_id ");
			mapSQLParameter.put("checklist_class_id", mapStr.get("checklist_class_id"));
		}else {
			sql.append(" and t.checklist_up_class_id = :checklist_up_class_id");
			if (UtilValiDate.isEmpty(mapStr.get("checklist_up_class_id"))) {
				mapSQLParameter.put("checklist_up_class_id",  mapStr.get("checklist_up_class_id") );
			}else {
				mapSQLParameter.put("checklist_up_class_id","0");
			}
			if (UtilValiDate.isEmpty(mapStr.get("checklist_class_name"))) {
				sql.append(" and t.checklist_class_name like :checklist_class_name");
				mapSQLParameter.put("checklist_class_name", "%" + mapStr.get("checklist_class_name") + "%");
			}
		}
	}

	/**
	 *获取检验检查分类表信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		sql.append(" order by lrsj desc");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}

	/**
	 *获取一条检验检查分类表信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		Map<String, Object> findSqlMap = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		if(findSqlMap.size()>0){
			sql.delete(0, sql.length());
			sql.append("select checklist_class_name as checklist_up_class_name from util_checklist_class where hospital_id=:hospital_id and checklist_class_id=:checklist_class_id ");
			mapSQLParameter.put("hospital_id",  mapStr.get("login_hospital_id") );
			mapSQLParameter.put("checklist_class_id",  findSqlMap.get("checklist_up_class_id") );
			findSqlMap.putAll(this.gyDAOimp.findSqlMap(sql, mapSQLParameter));
		}
		return findSqlMap;
	}

	/**
	 *新增操作
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into util_checklist_class");
		sql.append("( hospital_id,checklist_class_name,checklist_up_class_id,checklist_class_sort");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:checklist_class_name,:checklist_up_class_id,:checklist_class_sort");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("checklist_class_name", mapStr.get("checklist_class_name"));
		mapSQLParameter.put("checklist_up_class_id", mapStr.get("checklist_up_class_id"));
		mapSQLParameter.put("checklist_class_sort", mapStr.get("checklist_class_sort"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("checklist_class_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改检验检查分类表操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_checklist_class set gxsj=:gxsj");
		if(null!=mapStr.get("checklist_class_name")){
			sql.append(",checklist_class_name=:checklist_class_name");
			mapSQLParameter.put("checklist_class_name", mapStr.get("checklist_class_name"));
		}
		if(null!=mapStr.get("checklist_up_class_id")){
			sql.append(",checklist_up_class_id=:checklist_up_class_id");
			mapSQLParameter.put("checklist_up_class_id", mapStr.get("checklist_up_class_id"));
		}
		if(null!=mapStr.get("checklist_class_sort")){
			sql.append(",checklist_class_sort=:checklist_class_sort");
			mapSQLParameter.put("checklist_class_sort", mapStr.get("checklist_class_sort"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where checklist_class_id=:checklist_class_id");
		mapSQLParameter.put("checklist_class_id", mapStr.get("checklist_class_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除检验检查分类表操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select checklist_class_id from util_checklist_class where checklist_up_class_id=:checklist_class_id");
		mapSQLParameter.put("checklist_class_id", mapStr.get("id"));
		if(this.gyDAOimp.findSqlBool(sql, mapSQLParameter)){
			mapStr.put("info", "请先删除下级！");
		}else {
			sql.delete(0, sql.length());
			sql.append("delete from util_checklist_class where checklist_class_id=:checklist_class_id");
			this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		}
	}

	/************************系统生成方法完毕******************************/
	
	public List<Map<String, Object>> checkListClass() throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select checklist_class_id,checklist_class_name,checklist_up_class_id from util_checklist_class ");
		return this.gyDAOimp.findSqlList(sql, null);
	}
}