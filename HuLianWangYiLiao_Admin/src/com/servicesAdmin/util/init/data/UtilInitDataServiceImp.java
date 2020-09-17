package com.servicesAdmin.util.init.data;
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
 * 数据初始化 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilInitDataServiceImp")
public class UtilInitDataServiceImp implements UtilInitDataService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取基本数据查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.init_id,t.init_name,t.hospital_id,t.init_key,t.init_type,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_init_data t where t.hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("init_id"))) {
			sql.append(" and t.init_id=:init_id ");
			mapSQLParameter.put("init_id", mapStr.get("init_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("init_name"))) {
				sql.append(" and t.init_name like :init_name");
				mapSQLParameter.put("init_name", "%" + mapStr.get("init_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("init_type"))) {
				sql.append(" and t.init_type = :init_type");
				mapSQLParameter.put("init_type", mapStr.get("init_type"));
			}
		}
	}

	/**
	 *获取基本数据信息列表
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
	 *获取一条基本数据信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		Map<String, Object> map = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		return map;
	}

	/**
	 *修改基本数据操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_init_data set gxsj=:gxsj");
		if(null!=mapStr.get("init_name")){
			sql.append(",init_name=:init_name");
			mapSQLParameter.put("init_name", mapStr.get("init_name"));
		}
		if(null!=mapStr.get("init_key")){
			sql.append(",init_key=:init_key");
			mapSQLParameter.put("init_key", mapStr.get("init_key"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		sql.append(" where init_id=:init_id");
		mapSQLParameter.put("init_id", mapStr.get("init_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/************************系统生成方法完毕******************************/
}