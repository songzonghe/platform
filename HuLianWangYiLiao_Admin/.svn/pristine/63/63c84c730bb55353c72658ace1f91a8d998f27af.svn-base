package com.servicesAdmin.admin.notice;
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
 * 平台消息 service 实现类
 * 操作人： 曾晓
 */ 
@Service("adminNoticeServiceImp")
public class AdminNoticeServiceImp implements AdminNoticeService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取平台消息查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select case when t.user_type=1 then (select u.user_name from user_info u where t.user_id=u.user_id)");
		sql.append("when t.user_type=2 then (select s.store_name from store_info s where t.user_id=s.store_id)");
		sql.append(" when t.user_type=3 then (select d.doctor_name from doctor_info d where t.user_id=d.doctor_id)end as name,");
		sql.append("t.hospital_id,t.notice_type,t.user_type,t.user_id,t.notice_title,t.notice_content,t.notice_join,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh  from admin_notice t where 1=1 ");
		if (UtilValiDate.isEmpty(mapStr.get("notice_id"))) {
			sql.append(" and t.notice_id=:notice_id ");
			mapSQLParameter.put("notice_id", mapStr.get("notice_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("notice_title"))) {
				sql.append(" and t.notice_title like :notice_title");
				mapSQLParameter.put("notice_title", "%" + mapStr.get("notice_title") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("user_type"))) {
				sql.append(" and t.user_type = :user_type");
				mapSQLParameter.put("user_type",  mapStr.get("user_type"));
			}
		}
	}

	/**
	 *获取平台消息信息列表
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
	 *获取一条平台消息信息
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
		sql.append("insert into admin_notice");
		sql.append("( hospital_id,notice_type,user_type,user_id,notice_title,notice_content,notice_join");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:notice_type,:user_type,:user_id,:notice_title,:notice_content,:notice_join");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("hospital_id"));
		mapSQLParameter.put("notice_type", mapStr.get("notice_type"));
		mapSQLParameter.put("user_type", mapStr.get("user_type"));
		mapSQLParameter.put("user_id", mapStr.get("user_id"));
		mapSQLParameter.put("notice_title", mapStr.get("notice_title"));
		mapSQLParameter.put("notice_content", mapStr.get("notice_content"));
		mapSQLParameter.put("notice_join", mapStr.get("notice_join"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("notice_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改平台消息操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update admin_notice set gxsj=:gxsj");
		if(null!=mapStr.get("hospital_id")){
			sql.append(",hospital_id=:hospital_id");
			mapSQLParameter.put("hospital_id", mapStr.get("hospital_id"));
		}
		if(null!=mapStr.get("notice_type")){
			sql.append(",notice_type=:notice_type");
			mapSQLParameter.put("notice_type", mapStr.get("notice_type"));
		}
		if(null!=mapStr.get("user_type")){
			sql.append(",user_type=:user_type");
			mapSQLParameter.put("user_type", mapStr.get("user_type"));
		}
		if(null!=mapStr.get("user_id")){
			sql.append(",user_id=:user_id");
			mapSQLParameter.put("user_id", mapStr.get("user_id"));
		}
		if(null!=mapStr.get("notice_title")){
			sql.append(",notice_title=:notice_title");
			mapSQLParameter.put("notice_title", mapStr.get("notice_title"));
		}
		if(null!=mapStr.get("notice_content")){
			sql.append(",notice_content=:notice_content");
			mapSQLParameter.put("notice_content", mapStr.get("notice_content"));
		}
		if(null!=mapStr.get("notice_join")){
			sql.append(",notice_join=:notice_join");
			mapSQLParameter.put("notice_join", mapStr.get("notice_join"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where notice_id=:notice_id");
		mapSQLParameter.put("notice_id", mapStr.get("notice_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除平台消息操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from admin_notice where notice_id=:notice_id");
		mapSQLParameter.put("notice_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}