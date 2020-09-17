package com.servicesAdmin.doctor.scheduling;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.PinYin;
import com.util.PinyinToWubi;
import com.util.UtilSql;
import com.util.UtilValiDate;
/**
 * 医生排班 service 实现类
 * 操作人： 张龙
 */ 
@Service("doctorSchedulingServiceImp")
public class DoctorSchedulingServiceImp implements DoctorSchedulingService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取医生排班查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select '"+ mapStr.get("login_account_type")+"'as login_account_type, t.scheduling_id,t.doctor_id,t.scheduling_date,t.is_morning,t.is_afternoon,t.is_night,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" ,d.doctor_phone,d.doctor_img, d.doctor_name,d.doctor_document_number,ud.department_name ");
		sql.append(" from doctor_scheduling t,doctor_info d,util_department ud where ud.department_id=d.department_id and t.doctor_id=d.doctor_id and d.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id",  mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("scheduling_id"))) {
			sql.append(" and t.scheduling_id=:scheduling_id ");
			mapSQLParameter.put("scheduling_id", mapStr.get("scheduling_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("doctor_id"))) {
				sql.append(" and t.doctor_id = :doctor_id");
				mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("scheduling_date"))){
				sql.append(" and date_format(t.scheduling_date, '%Y%m%') = date_format(:scheduling_date, '%Y%m%')");
				mapSQLParameter.put("scheduling_date",  mapStr.get("scheduling_date"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("find_date"))) {
				sql.append(" and to_days(t.scheduling_date) = to_days(:find_date)");
				mapSQLParameter.put("find_date",  mapStr.get("find_date"));
			}
		}
	}

	/**
	 *获取医生排班信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		
		if("findData".equals(mapStr.get("pageType"))) {
			List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
			list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
			return list_Map;
		}
		
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	/**
	 *获取医生信息
	 */
	public List<Map<String, Object>> findDoctor(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.doctor_id,t.doctor_phone,t.doctor_name,d.department_name");
		sql.append(" from doctor_info t,util_department d where t.department_id=d.department_id and t.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id",  mapStr.get("login_hospital_id"));
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(list_Map.size()>0) {
			for (Map<String, Object> map : list_Map) {
				map.put("doctor_name_pinyin", PinYin.getPinYinHeadChar(map.get("doctor_name")+""));
				map.put("doctor_name_wubi", PinyinToWubi.getWBCode(map.get("doctor_name")+""));
			}
		}
		
		return list_Map;
	}

	/**
	 *获取一条医生排班信息
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
		sql.append("insert into doctor_scheduling");
		sql.append("( doctor_id,scheduling_date,is_morning,is_afternoon,is_night");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :doctor_id,:scheduling_date,:is_morning,:is_afternoon,:is_night");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		mapSQLParameter.put("scheduling_date", mapStr.get("scheduling_date"));
		mapSQLParameter.put("is_morning", mapStr.get("is_morning"));
		mapSQLParameter.put("is_afternoon", mapStr.get("is_afternoon"));
		mapSQLParameter.put("is_night", mapStr.get("is_night"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("scheduling_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改医生排班操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update doctor_scheduling set gxsj=:gxsj");
		if(null!=mapStr.get("doctor_id")){
			sql.append(",doctor_id=:doctor_id");
			mapSQLParameter.put("doctor_id", mapStr.get("doctor_id"));
		}
		if(null!=mapStr.get("scheduling_date")){
			sql.append(",scheduling_date=:scheduling_date");
			mapSQLParameter.put("scheduling_date", mapStr.get("scheduling_date"));
		}
		if(null!=mapStr.get("is_morning")){
			sql.append(",is_morning=:is_morning");
			mapSQLParameter.put("is_morning", mapStr.get("is_morning"));
		}
		if(null!=mapStr.get("is_afternoon")){
			sql.append(",is_afternoon=:is_afternoon");
			mapSQLParameter.put("is_afternoon", mapStr.get("is_afternoon"));
		}
		if(null!=mapStr.get("is_night")){
			sql.append(",is_night=:is_night");
			mapSQLParameter.put("is_night", mapStr.get("is_night"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where scheduling_id=:scheduling_id");
		mapSQLParameter.put("scheduling_id", mapStr.get("scheduling_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除医生排班操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from doctor_scheduling where scheduling_id=:scheduling_id");
		mapSQLParameter.put("scheduling_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}