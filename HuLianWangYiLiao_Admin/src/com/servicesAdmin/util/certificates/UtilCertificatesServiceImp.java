package com.servicesAdmin.util.certificates;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import com.dao.interfaceDAO.GYDAO;
import com.util.UtilValiDate;
import com.util.SysFinal;
import org.springframework.stereotype.Service;
import com.util.UtilSql;
/**
 * 系统初始化证件 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilCertificatesServiceImp")
public class UtilCertificatesServiceImp implements UtilCertificatesService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取系统初始化证件查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.certificates_id,t.certificates_number,t.certificates_name,t.certificates_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_certificates t where 1=1");
		if (UtilValiDate.isEmpty(mapStr.get("certificates_id"))) {
			sql.append(" and t.certificates_id=:certificates_id ");
			mapSQLParameter.put("certificates_id", mapStr.get("certificates_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("certificates_number"))) {
				sql.append(" and t.certificates_number like :certificates_number");
				mapSQLParameter.put("certificates_number", "%" + mapStr.get("certificates_number") + "%");
			}
		}
	}

	/**
	 *获取系统初始化证件信息列表
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
	 *获取一条系统初始化证件信息
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
		sql.append("insert into util_certificates");
		sql.append("( certificates_number,certificates_name,certificates_sort");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :certificates_number,:certificates_name,:certificates_sort");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("certificates_number", mapStr.get("certificates_number"));
		mapSQLParameter.put("certificates_name", mapStr.get("certificates_name"));
		mapSQLParameter.put("certificates_sort", mapStr.get("certificates_sort"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("certificates_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改系统初始化证件操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_certificates set gxsj=:gxsj");
		if(null!=mapStr.get("certificates_number")){
			sql.append(",certificates_number=:certificates_number");
			mapSQLParameter.put("certificates_number", mapStr.get("certificates_number"));
		}
		if(null!=mapStr.get("certificates_name")){
			sql.append(",certificates_name=:certificates_name");
			mapSQLParameter.put("certificates_name", mapStr.get("certificates_name"));
		}
		if(null!=mapStr.get("certificates_sort")){
			sql.append(",certificates_sort=:certificates_sort");
			mapSQLParameter.put("certificates_sort", mapStr.get("certificates_sort"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where certificates_id=:certificates_id");
		mapSQLParameter.put("certificates_id", mapStr.get("certificates_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除系统初始化证件操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_certificates where certificates_id=:certificates_id");
		mapSQLParameter.put("certificates_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}