package com.servicesAdmin.util.drug.frequency;
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
 * 药品使用频率 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilDrugFrequencyServiceImp")
public class UtilDrugFrequencyServiceImp implements UtilDrugFrequencyService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取药品使用频率查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.frequency_id,t.hospital_id,t.frequency_name,t.frequency_printing_name,t.frequency_num,t.frequency_day_num,t.frequency_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_drug_frequency t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id",  mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("frequency_id"))) {
			sql.append(" and t.frequency_id=:frequency_id ");
			mapSQLParameter.put("frequency_id", mapStr.get("frequency_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				sql.append(" and t.hospital_id = :hospital_id");
				mapSQLParameter.put("hospital_id",  mapStr.get("hospital_id") );
			}
			if (UtilValiDate.isEmpty(mapStr.get("frequency_name"))) {
				sql.append(" and t.frequency_name like :frequency_name");
				mapSQLParameter.put("frequency_name", "%" + mapStr.get("frequency_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("frequency_num"))) {
				sql.append(" and t.frequency_num like :frequency_num");
				mapSQLParameter.put("frequency_num", "%" + mapStr.get("frequency_num") + "%");
			}
		}
	}

	/**
	 *获取药品使用频率信息列表
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
	 *获取一条药品使用频率信息
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
		sql.append("insert into util_drug_frequency");
		sql.append("( hospital_id,frequency_name,frequency_printing_name,frequency_num,frequency_day_num,frequency_sort");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:frequency_name,:frequency_printing_name,:frequency_num,:frequency_day_num,:frequency_sort");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("frequency_name", mapStr.get("frequency_name"));
		mapSQLParameter.put("frequency_printing_name", mapStr.get("frequency_printing_name"));
		mapSQLParameter.put("frequency_num", mapStr.get("frequency_num"));
		mapSQLParameter.put("frequency_day_num", mapStr.get("frequency_day_num"));
		mapSQLParameter.put("frequency_sort", mapStr.get("frequency_sort"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("frequency_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改药品使用频率操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_drug_frequency set gxsj=:gxsj");
		if(null!=mapStr.get("frequency_name")){
			sql.append(",frequency_name=:frequency_name");
			mapSQLParameter.put("frequency_name", mapStr.get("frequency_name"));
		}
		if(null!=mapStr.get("frequency_printing_name")){
			sql.append(",frequency_printing_name=:frequency_printing_name");
			mapSQLParameter.put("frequency_printing_name", mapStr.get("frequency_printing_name"));
		}
		if(null!=mapStr.get("frequency_num")){
			sql.append(",frequency_num=:frequency_num");
			mapSQLParameter.put("frequency_num", mapStr.get("frequency_num"));
		}
		if(null!=mapStr.get("frequency_day_num")){
			sql.append(",frequency_day_num=:frequency_day_num");
			mapSQLParameter.put("frequency_day_num", mapStr.get("frequency_day_num"));
		}
		if(null!=mapStr.get("frequency_sort")){
			sql.append(",frequency_sort=:frequency_sort");
			mapSQLParameter.put("frequency_sort", mapStr.get("frequency_sort"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where frequency_id=:frequency_id");
		mapSQLParameter.put("frequency_id", mapStr.get("frequency_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除药品使用频率操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_drug_frequency where frequency_id=:frequency_id");
		mapSQLParameter.put("frequency_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}