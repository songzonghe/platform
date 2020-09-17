package com.servicesAdmin.doctor.template;
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
 * 常用模板 service 实现类
 * 操作人： 刘杰
 */ 
@Service("doctorTemplateServiceImp")
public class DoctorTemplateServiceImp implements DoctorTemplateService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取常用模板查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.template_id,i.doctor_name,t.hospital_id,t.doctor_id,t.template_type,t.template_name,t.template_details,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from doctor_template t,doctor_info i where 1=1 and t.doctor_id=i.doctor_id and t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("template_id"))) {
			sql.append(" and t.template_id=:template_id ");
			mapSQLParameter.put("template_id", mapStr.get("template_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				sql.append(" and t.hospital_id like :hospital_id");
				mapSQLParameter.put("hospital_id", "%" + mapStr.get("hospital_id") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("doctor_name"))) {
				sql.append(" and i.doctor_name like :doctor_name");
				mapSQLParameter.put("doctor_name", "%" + mapStr.get("doctor_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("template_type"))) {
				sql.append(" and t.template_type = :template_type");
				mapSQLParameter.put("template_type",  mapStr.get("template_type"));
			}
		}
	}

	/**
	 *获取常用模板信息列表
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
	 *获取一条常用模板信息
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
		//查询是否存在相同的
		sql.append("select template_id from doctor_template where hospital_id=:hospital_id and doctor_id=:doctor_id and template_type=:template_type and template_name=:template_name and template_details=:template_details ");
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("template_type", mapStr.get("template_type"));
		mapSQLParameter.put("template_name", mapStr.get("template_name"));
		mapSQLParameter.put("template_details", mapStr.get("template_details"));
		if(this.gyDAOimp.findSqlBool(sql, mapSQLParameter)) {
			mapSQLParameter.clear();
			mapSQLParameter.put("backInfo", "已存在相同的模板数据！！");
			return mapSQLParameter;
		}
		sql.delete(0, sql.length());
		
		sql.append("insert into doctor_template");
		sql.append("( hospital_id,doctor_id,template_type,template_name,template_details");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:doctor_id,:template_type,:template_name,:template_details");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("template_type", mapStr.get("template_type"));
		mapSQLParameter.put("template_name", mapStr.get("template_name"));
		mapSQLParameter.put("template_details", mapStr.get("template_details"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("template_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改常用模板操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//查询是否存在相同的
		sql.append("select template_id from doctor_template where hospital_id=:hospital_id and doctor_id=:doctor_id and template_type=:template_type and template_name=:template_name and template_details=:template_details and template_id!=:template_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("template_type", mapStr.get("template_type"));
		mapSQLParameter.put("template_name", mapStr.get("template_name"));
		mapSQLParameter.put("template_details", mapStr.get("template_details"));
		mapSQLParameter.put("template_id", mapStr.get("template_id"));
		if(this.gyDAOimp.findSqlBool(sql, mapSQLParameter)) {
			mapSQLParameter.clear();
			mapSQLParameter.put("backInfo", "已存在相同的模板数据！！");
			return mapSQLParameter;
		}
		sql.delete(0, sql.length());
		sql.append("update doctor_template set gxsj=:gxsj");
		if(null!=mapStr.get("doctor_id")){
			sql.append(",doctor_id=:doctor_id");
			mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		}
		if(null!=mapStr.get("template_type")){
			sql.append(",template_type=:template_type");
			mapSQLParameter.put("template_type", mapStr.get("template_type"));
		}
		if(null!=mapStr.get("template_name")){
			sql.append(",template_name=:template_name");
			mapSQLParameter.put("template_name", mapStr.get("template_name"));
		}
		if(null!=mapStr.get("template_details")){
			sql.append(",template_details=:template_details");
			mapSQLParameter.put("template_details", mapStr.get("template_details"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where template_id=:template_id");
		mapSQLParameter.put("template_id", mapStr.get("template_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除常用模板操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from doctor_template where template_id=:template_id");
		mapSQLParameter.put("template_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}