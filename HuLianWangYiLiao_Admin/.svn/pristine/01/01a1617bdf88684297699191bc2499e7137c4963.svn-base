package com.servicesAdmin.util.department;
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
 * 系统科室 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilDepartmentServiceImp")
public class UtilDepartmentServiceImp implements UtilDepartmentService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取系统科室查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.department_id,t.hospital_id,t.department_bzksdm,t.department_ybjdm,t.department_ksjs,t.department_name,t.department_sort,department_ksmm,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(",department_cxbz,department_jgdm from util_department t where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("department_id"))) {
			sql.append(" and t.department_id=:department_id ");
			mapSQLParameter.put("department_id", mapStr.get("department_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("department_name"))) {
				sql.append(" and t.department_name like :department_name");
				mapSQLParameter.put("department_name", "%" + mapStr.get("department_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("department_sort"))) {
				sql.append(" and t.department_sort = :department_sort");
				mapSQLParameter.put("department_sort",  mapStr.get("department_sort") );
			}
		}
	}

	/**
	 *获取系统科室信息列表
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
	 *获取一条系统科室信息
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
		sql.append("insert into util_department");
		sql.append("( department_cxbz,department_jgdm,hospital_id,department_bzksdm,department_ybjdm,department_ksjs,department_name,department_sort,department_ksmm");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :department_cxbz,:department_jgdm,:hospital_id,:department_bzksdm,:department_ybjdm,:department_ksjs,:department_name,:department_sort,:department_ksmm");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("department_cxbz", mapStr.get("department_cxbz"));
		mapSQLParameter.put("department_jgdm", mapStr.get("department_jgdm"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("department_bzksdm", mapStr.get("department_bzksdm"));
		mapSQLParameter.put("department_ybjdm", mapStr.get("department_ybjdm"));
		mapSQLParameter.put("department_ksjs", mapStr.get("department_ksjs"));
		mapSQLParameter.put("department_name", mapStr.get("department_name"));
		mapSQLParameter.put("department_sort", mapStr.get("department_sort"));
		mapSQLParameter.put("department_ksmm", mapStr.get("department_ksmm"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("department_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改系统科室操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_department set gxsj=:gxsj");
		
		if(null!=mapStr.get("department_cxbz")){
			sql.append(",department_cxbz=:department_cxbz");
			mapSQLParameter.put("department_cxbz", mapStr.get("department_cxbz"));
		}
		if(null!=mapStr.get("department_jgdm")){
			sql.append(",department_jgdm=:department_jgdm");
			mapSQLParameter.put("department_jgdm", mapStr.get("department_jgdm"));
		}
		if(null!=mapStr.get("department_bzksdm")){
			sql.append(",department_bzksdm=:department_bzksdm");
			mapSQLParameter.put("department_bzksdm", mapStr.get("department_bzksdm"));
		}
		if(null!=mapStr.get("department_ybjdm")){
			sql.append(",department_ybjdm=:department_ybjdm");
			mapSQLParameter.put("department_ybjdm", mapStr.get("department_ybjdm"));
		}
		if(null!=mapStr.get("department_ksjs")){
			sql.append(",department_ksjs=:department_ksjs");
			mapSQLParameter.put("department_ksjs", mapStr.get("department_ksjs"));
		}
		if(null!=mapStr.get("department_name")){
			sql.append(",department_name=:department_name");
			mapSQLParameter.put("department_name", mapStr.get("department_name"));
		}
		if(null!=mapStr.get("department_sort")){
			sql.append(",department_sort=:department_sort");
			mapSQLParameter.put("department_sort", mapStr.get("department_sort"));
		}
		if(null!=mapStr.get("department_ksmm")){
			sql.append(",department_ksmm=:department_ksmm");
			mapSQLParameter.put("department_ksmm", mapStr.get("department_ksmm"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where department_id=:department_id");
		mapSQLParameter.put("department_id", mapStr.get("department_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除系统科室操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_department where department_id=:department_id");
		mapSQLParameter.put("department_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}
	
	/**
	 *获取科室list
	 */
	public List<Map<String, Object>> departmentList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.department_id,t.hospital_id,t.department_name,t.department_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_department t where 1=1");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}


	/************************系统生成方法完毕******************************/
}