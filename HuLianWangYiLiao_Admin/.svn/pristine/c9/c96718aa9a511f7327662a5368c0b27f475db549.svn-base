package com.servicesAdmin.util.notice;
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
 * 系统消息 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilNoticeServiceImp")
public class UtilNoticeServiceImp implements UtilNoticeService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取系统消息查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select case when t.user_type=1 then (select u.user_name from user_info u where t.user_id=u.user_id)");
		sql.append("when t.user_type=2 then (select s.store_name from store_info s where t.user_id=s.store_id)");
		sql.append(" when t.user_type=3 then (select d.doctor_name from doctor_info d where t.user_id=d.doctor_id)end as name,");
		sql.append("t.hospital_id,t.notice_type,t.user_type,t.user_id,t.notice_title,t.notice_content,t.notice_join,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh  from util_notice t where t.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		
		if (UtilValiDate.isEmpty(mapStr.get("notice_id"))) {
			sql.append(" and t.notice_id=:notice_id ");
			mapSQLParameter.put("notice_id", mapStr.get("notice_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("user_type"))) {
				sql.append(" and t.user_type = :user_type");
				mapSQLParameter.put("user_type",  mapStr.get("user_type"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("notice_title"))) {
				sql.append(" and t.notice_title like :notice_title");
				mapSQLParameter.put("notice_title", "%" + mapStr.get("notice_title") + "%");
			}
		}
	}

	/**
	 *获取系统消息信息列表
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
	 *获取一条系统消息信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		return this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
	}

	/**
	 *新增操作
	 */
	public String add_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		StringBuffer sql2 = new StringBuffer();
		mapSQLParameter.put("notice_content", mapStr.get("log_content"));
		mapSQLParameter.put("notice_title", mapStr.get("log_title"));
		mapSQLParameter.put("notice_type", "1");
		mapSQLParameter.put("notice_join", "0");
		mapSQLParameter.put("user_type", mapStr.get("user_type"));
		//发送全部
		if("1".equals(mapStr.get("type"))){
			//获取所有用户
			if("1".equals(mapStr.get("user_type"))) {
				sql.append("select user_id as id,hospital_id from user_info ");
			}else if("2".equals(mapStr.get("user_type"))) {
				sql.append("select store_id as id,hospital_id from store_info ");
			}else if("3".equals(mapStr.get("user_type"))) {
				sql.append("select doctor_id as id,hospital_id from doctor_info ");
			}
			List<Map<String, Object>> listMaps=this.gyDAOimp.findSqlList(sql, mapSQLParameter);
			sql.delete(0, sql.length());
			sql.append("insert into util_notice");
			sql.append("( notice_type,user_type,user_id,hospital_id,notice_title,notice_content,notice_join");
			sql.append(UtilSql.getFieldInsertKey());
			sql.append("values(:notice_type,:user_type,:user_id,:hospital_id,:notice_title,:notice_content,:notice_join");
			sql.append(UtilSql.getFieldInsertVal());
			for (Map<String, Object> map : listMaps){
				mapSQLParameter.put("user_id", map.get("id").toString());
				mapSQLParameter.put("hospital_id", map.get("hospital_id").toString());
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				mapSQLParameter.put("zt", 2);
				mapSQLParameter.put("bz", "平台消息");
				this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter);
			}
		}else{//选择发送
			if(!UtilValiDate.isEmpty(mapStr.get("user_id"))){
				return "false";
			}
			String [] users=mapStr.get("user_id").split(",");
			sql.delete(0, sql.length());
			sql.append("insert into util_notice");
			sql.append("( notice_type,user_type,user_id,hospital_id,notice_title,notice_content,notice_join");
			sql.append(UtilSql.getFieldInsertKey());
			sql.append("values(:notice_type,:user_type,:user_id,:hospital_id,:notice_title,:notice_content,:notice_join");
			sql.append(UtilSql.getFieldInsertVal());
			for (String str : users) {
				mapSQLParameter.put("user_id", str);
				if("1".equals(mapStr.get("user_type"))) {
					sql2.append("select user_id as id,hospital_id from user_info where user_id=:user_id");
				}else if("2".equals(mapStr.get("user_type"))) {
					sql2.append("select store_id as id,hospital_id from store_info where store_id=:user_id");
				}else if("3".equals(mapStr.get("user_type"))) {
					sql2.append("select doctor_id as id,hospital_id from doctor_info where doctor_id=:user_id");
				}
				Map<String, Object> map = this.gyDAOimp.findSqlMap(sql2, mapSQLParameter);
				mapSQLParameter.put("hospital_id", map.get("hospital_id").toString());
				sql2.delete(0, sql.length());
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				mapSQLParameter.put("zt", 2);
				mapSQLParameter.put("bz", "平台消息");
				this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
			}
		}
		return "true";
	}


	/**
	 *删除系统消息操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_notice where notice_id=:notice_id");
		mapSQLParameter.put("notice_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
	/**
	 * 获取收件人列表
	 */
	public List<Map<String, Object>> userList(Map<String, String> mapStr) throws Exception {
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		if("1".equals(mapStr.get("user_type"))) {
			sql.append("select user_id as id,user_nickname as name,user_phone as phone,gxsj,bz,lrsj,zt,lrzh from user_info t where 1=1 ");
		}else if("2".equals(mapStr.get("user_type"))) {
			sql.append("select store_id as id,store_name as name,store_phone as phone,gxsj,bz,lrsj,zt,lrzh from store_info t where 1=1 ");
		}else if("3".equals(mapStr.get("user_type"))) {
			sql.append("select doctor_id as id,doctor_name as name,doctor_phone as phone,gxsj,bz,lrsj,zt,lrzh from doctor_info t where 1=1 ");
		}
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter, mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}
	
	

}