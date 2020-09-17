package com.servicesAdmin.util.dictionaries.type;
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
 * 字典表类型 service 实现类
 * 操作人： 张龙
 */ 
@Service("utilDictionariesTypeServiceImp")
public class UtilDictionariesTypeServiceImp implements UtilDictionariesTypeService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取字典表类型查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.dictionaries_type_id,t.dictionaries_type_code,t.dictionaries_type_name,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_dictionaries_type t where 1=1");
		if (UtilValiDate.isEmpty(mapStr.get("dictionaries_type_id"))) {
			sql.append(" and t.dictionaries_type_id=:dictionaries_type_id ");
			mapSQLParameter.put("dictionaries_type_id", mapStr.get("dictionaries_type_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("dictionaries_type_code"))) {
				sql.append(" and t.dictionaries_type_code like :dictionaries_type_code");
				mapSQLParameter.put("dictionaries_type_code", "%" + mapStr.get("dictionaries_type_code") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("dictionaries_type_name"))) {
				sql.append(" and t.dictionaries_type_name like :dictionaries_type_name");
				mapSQLParameter.put("dictionaries_type_name", "%" + mapStr.get("dictionaries_type_name") + "%");
			}
		}
	}

	/**
	 *获取字典表类型信息列表
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
	 *获取一条字典表类型信息
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
		sql.append("insert into util_dictionaries_type");
		sql.append("( dictionaries_type_code,dictionaries_type_name");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :dictionaries_type_code,:dictionaries_type_name");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("dictionaries_type_code", mapStr.get("dictionaries_type_code"));
		mapSQLParameter.put("dictionaries_type_name", mapStr.get("dictionaries_type_name"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		
		mapStr.put("dictionaries_type_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改字典表类型操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_dictionaries_type set gxsj=:gxsj");
		if(null!=mapStr.get("dictionaries_type_code")){
			sql.append(",dictionaries_type_code=:dictionaries_type_code");
			mapSQLParameter.put("dictionaries_type_code", mapStr.get("dictionaries_type_code"));
		}
		if(null!=mapStr.get("dictionaries_type_name")){
			sql.append(",dictionaries_type_name=:dictionaries_type_name");
			mapSQLParameter.put("dictionaries_type_name", mapStr.get("dictionaries_type_name"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where dictionaries_type_id=:dictionaries_type_id");
		mapSQLParameter.put("dictionaries_type_id", mapStr.get("dictionaries_type_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除字典表类型操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//先判断是否有数据
		sql.append("select dictionaries_data_id from util_dictionaries_data where dictionaries_type_id=:dictionaries_type_id");
		mapSQLParameter.put("dictionaries_type_id", mapStr.get("id"));
		if(this.gyDAOimp.findSqlBool(sql, mapSQLParameter)) {
			mapStr.put("code", "300");
			mapStr.put("info", "请先移除对应的字典数据！");
		}else {
			sql.delete(0, sql.length());
			sql.append("delete from util_dictionaries_type where dictionaries_type_id=:dictionaries_type_id");
			this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		}
	}

	/************************系统生成方法完毕******************************/
}