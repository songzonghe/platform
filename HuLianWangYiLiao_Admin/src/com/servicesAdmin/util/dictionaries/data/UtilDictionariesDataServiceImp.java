package com.servicesAdmin.util.dictionaries.data;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
 * 字典数据 service 实现类
 * 操作人： 张龙
 */ 
@Service("utilDictionariesDataServiceImp")
public class UtilDictionariesDataServiceImp implements UtilDictionariesDataService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取字典数据查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.dictionaries_data_id,t.dictionaries_type_id,t.dictionaries_data_code,t.dictionaries_data_name,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_dictionaries_data t where 1=1");
		if (UtilValiDate.isEmpty(mapStr.get("dictionaries_data_id"))) {
			sql.append(" and t.dictionaries_data_id=:dictionaries_data_id ");
			mapSQLParameter.put("dictionaries_data_id", mapStr.get("dictionaries_data_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("dictionaries_type_id"))) {
				sql.append(" and t.dictionaries_type_id = :dictionaries_type_id");
				mapSQLParameter.put("dictionaries_type_id", mapStr.get("dictionaries_type_id"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("dictionaries_data_code"))) {
				sql.append(" and t.dictionaries_data_code like :dictionaries_data_code");
				mapSQLParameter.put("dictionaries_data_code", "%" + mapStr.get("dictionaries_data_code") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("dictionaries_data_name"))) {
				sql.append(" and t.dictionaries_data_name like :dictionaries_data_name");
				mapSQLParameter.put("dictionaries_data_name", "%" + mapStr.get("dictionaries_data_name") + "%");
			}
		}
	}

	/**
	 *获取字典数据信息列表
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
	 *获取字典数据所有的数据
	 */
	public Map<String, Object> findAllData(String str)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		Map<String, Object> backMap=new LinkedHashMap<String, Object>();
		List<String> stringToList = UtilStr.getStringToList(str, ",");
		sql.append("select t.dictionaries_data_id,t.dictionaries_type_id,t.dictionaries_data_code as code,t.dictionaries_data_name as name ");
		sql.append(" from util_dictionaries_data t,util_dictionaries_type as ty where ty.dictionaries_type_id=t.dictionaries_type_id and dictionaries_type_code=:dictionaries_type_code");
		for (String strs : stringToList) {
			mapSQLParameter.put("dictionaries_type_code", strs);
			List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
			backMap.put("list"+strs, list_Map);
		}
		return backMap;
	}

	/**
	 *获取一条字典数据信息
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
		sql.append("insert into util_dictionaries_data");
		sql.append("( dictionaries_type_id,dictionaries_data_code,dictionaries_data_name");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :dictionaries_type_id,:dictionaries_data_code,:dictionaries_data_name");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("dictionaries_type_id", mapStr.get("dictionaries_type_id"));
		mapSQLParameter.put("dictionaries_data_code", mapStr.get("dictionaries_data_code"));
		mapSQLParameter.put("dictionaries_data_name", mapStr.get("dictionaries_data_name"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		
		mapStr.put("dictionaries_data_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改字典数据操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_dictionaries_data set gxsj=:gxsj");
		if(null!=mapStr.get("dictionaries_type_id")){
			sql.append(",dictionaries_type_id=:dictionaries_type_id");
			mapSQLParameter.put("dictionaries_type_id", mapStr.get("dictionaries_type_id"));
		}
		if(null!=mapStr.get("dictionaries_data_code")){
			sql.append(",dictionaries_data_code=:dictionaries_data_code");
			mapSQLParameter.put("dictionaries_data_code", mapStr.get("dictionaries_data_code"));
		}
		if(null!=mapStr.get("dictionaries_data_name")){
			sql.append(",dictionaries_data_name=:dictionaries_data_name");
			mapSQLParameter.put("dictionaries_data_name", mapStr.get("dictionaries_data_name"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where dictionaries_data_id=:dictionaries_data_id");
		mapSQLParameter.put("dictionaries_data_id", mapStr.get("dictionaries_data_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除字典数据操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_dictionaries_data where dictionaries_data_id=:dictionaries_data_id");
		mapSQLParameter.put("dictionaries_data_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}