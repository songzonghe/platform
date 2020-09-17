package com.servicesAdmin.inquiry.log.checklist.details.inquiryLogChecklistDetails;
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
 * 问诊记录检验检查单详情 service 实现类
 *  操作人： 苏洪伟
 */ 
@Service("inquiryLogChecklistDetailsServiceImp ")
public class InquiryLogChecklistDetailsServiceImp implements InquiryLogChecklistDetailsService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取查询问诊记录检验检查单详情的sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.checklist_details_id,t.hospital_id,t.checklist_id,t.checklist_type,t.checklist_name,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from inquiry_log_checklist_details t, inquiry_log_checklist p");
		sql.append(" where t.checklist_id=p.checklist_id and t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("checklist_details_id"))) {
			sql.append(" and t.checklist_details_id=:checklist_details_id ");
			mapSQLParameter.put("checklist_details_id", mapStr.get("checklist_details_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("checklist_id"))) {
				sql.append(" and t.checklist_id=:checklist_id ");
				mapSQLParameter.put("checklist_id", mapStr.get("checklist_id"));
			}
		}
	}
	

	/**
	 *获取问诊记录检验检查单详情数据列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		if (!UtilValiDate.isEmpty(mapStr.get(SysFinal.ISSORT_KEY))){ //由于从菜单进入没有带入参数，这里给入判断进行开启排序
			mapStr.put(SysFinal.ISSORT_KEY,"y");
		}
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	/**
	 *获取单个问诊记录检验检查单详情数据
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		return this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
	}

	/**
	 *添加问诊记录检验检查单详情
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into inquiry_log_checklist_details");
		sql.append("( hospital_id,checklist_id,checklist_type,checklist_name");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values(:hospital_id,:checklist_id,:checklist_type,:checklist_name");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("checklist_id", mapStr.get("checklist_id"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("checklist_id", mapStr.get("checklist_id"));
		mapSQLParameter.put("checklist_type", mapStr.get("checklist_type"));
		mapSQLParameter.put("checklist_name", mapStr.get("checklist_name"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapSQLParameter.put("checklist_details_id",this.gyDAOimp.exeSqlBool(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改问诊记录检验检查单详情
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update inquiry_log_checklist_details set gxsj=:gxsj");
		sql.append(" ,hospital_id=:hospital_id,checklist_type=:checklist_type,checklist_name=:checklist_name, bz=:bz ");
		sql.append(" where checklist_details_id=:checklist_details_id");
		mapStr.put(SysFinal.BZ_KEY, UtilStr.codeUTF_8(mapStr.get(SysFinal.BZ_KEY)));
		mapSQLParameter.put("checklist_id", mapStr.get("checklist_id"));
		mapSQLParameter.put("checklist_type", mapStr.get("checklist_type"));
		mapSQLParameter.put("checklist_name", mapStr.get("checklist_name"));
		mapSQLParameter.put("bz", mapStr.get(SysFinal.BZ_KEY));
		mapSQLParameter.put("checklist_details_id", mapStr.get("checklist_details_id"));
		mapSQLParameter.put("gxsj", UtilSql.getGXSJ());
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除问诊记录检验检查单详情
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from inquiry_log_checklist_details where checklist_details_id=:checklist_details_id");
		mapSQLParameter.put("checklist_details_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
	}

	/************************系统生成方法完毕******************************/
}