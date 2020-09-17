package com.servicesAdmin.util.checklist.checklistClass.details.utilChecklist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.SysFinal;
import com.util.UtilSql;
import com.util.UtilStr;
import com.util.UtilValiDate;

/**
 * 系统检验检查表 service 实现类 操作人： 曾晓
 */
@Service("utilChecklistServiceImp ")
public class UtilChecklistServiceImp implements UtilChecklistService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************ 系统生成方法开始 ******************************/

	/**
	 * 获取查询系统检验检查表的sql
	 */
	private void getSQL(Map<String, String> mapStr, StringBuffer sql, Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.checklist_id,t.hospital_id,t.checklist_class_id,p.checklist_class_name,t.checklist_type,t.checklist_name,t.checklist_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_checklist t, util_checklist_class p");
		sql.append(" where t.checklist_class_id=p.checklist_class_id and t.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("checklist_id"))) {
			sql.append(" and t.checklist_id=:checklist_id ");
			mapSQLParameter.put("checklist_id", mapStr.get("checklist_id"));
		} else {
			if (UtilValiDate.isEmpty(mapStr.get("checklist_class_id"))) {
				sql.append(" and t.checklist_class_id=:checklist_class_id ");
				mapSQLParameter.put("checklist_class_id", mapStr.get("checklist_class_id"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("checklist_name"))) {
				sql.append(" and t.checklist_name like :checklist_name ");
				mapSQLParameter.put("checklist_name","%"+ mapStr.get("checklist_name")+"%");
			}
		}
	}

	/**
	 * 获取系统检验检查表数据列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		if (!UtilValiDate.isEmpty(mapStr.get(SysFinal.ISSORT_KEY))) { // 由于从菜单进入没有带入参数，这里给入判断进行开启排序
			mapStr.put(SysFinal.ISSORT_KEY, "y");
		}
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	/**
	 * 获取单个系统检验检查表数据
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		return this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
	}

	/**
	 * 添加系统检验检查表
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into util_checklist");
		sql.append("( hospital_id,checklist_class_id,checklist_type,checklist_name,checklist_sort");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values(:hospital_id,:checklist_class_id,:checklist_type,:checklist_name,:checklist_sort");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("checklist_class_id", mapStr.get("checklist_class_id"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("checklist_class_id", mapStr.get("checklist_class_id"));
		mapSQLParameter.put("checklist_type", mapStr.get("checklist_type"));
		mapSQLParameter.put("checklist_name", mapStr.get("checklist_name"));
		mapSQLParameter.put("checklist_sort", mapStr.get("checklist_sort"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("checklist_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
		
	}

	/**
	 * 修改系统检验检查表
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception {
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_checklist set gxsj=:gxsj");
		sql.append(
				" ,hospital_id=:hospital_id,checklist_type=:checklist_type,checklist_name=:checklist_name,checklist_sort=:checklist_sort, bz=:bz ");
		sql.append(" where checklist_id=:checklist_id");
		mapStr.put(SysFinal.BZ_KEY, UtilStr.codeUTF_8(mapStr.get(SysFinal.BZ_KEY)));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("checklist_class_id", mapStr.get("checklist_class_id"));
		mapSQLParameter.put("checklist_type", mapStr.get("checklist_type"));
		mapSQLParameter.put("checklist_name", mapStr.get("checklist_name"));
		mapSQLParameter.put("checklist_sort", mapStr.get("checklist_sort"));
		mapSQLParameter.put("bz", mapStr.get(SysFinal.BZ_KEY));
		mapSQLParameter.put("checklist_id", mapStr.get("checklist_id"));
		mapSQLParameter.put("gxsj", UtilSql.getGXSJ());
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 * 删除系统检验检查表
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_checklist where checklist_id=:checklist_id");
		mapSQLParameter.put("checklist_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
	}

	/************************ 系统生成方法完毕 ******************************/
}