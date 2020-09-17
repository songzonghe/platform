package com.servicesAdmin.inquiry.log.img;
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
 * 问诊记录上传图片 service 实现类
 * 操作人： 曾晓
 */ 
@Service("inquiryLogImgServiceImp")
public class InquiryLogImgServiceImp implements InquiryLogImgService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取问诊记录上传图片查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.img_id,t.hospital_id,t.log_id,t.img_src,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from inquiry_log_img t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("img_id"))) {
			sql.append(" and t.img_id=:img_id ");
			mapSQLParameter.put("img_id", mapStr.get("img_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("log_id"))) {
				sql.append(" and t.log_id like :log_id");
				mapSQLParameter.put("log_id", "%" + mapStr.get("log_id") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("img_src"))) {
				sql.append(" and t.img_src = :img_src");
				mapSQLParameter.put("img_src",  mapStr.get("img_src"));
			}
		}
	}

	/**
	 *获取问诊记录上传图片信息列表
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
	 *获取一条问诊记录上传图片信息
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
		sql.append("insert into inquiry_log_img");
		sql.append("( hospital_id,log_id,img_src");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:log_id,:img_src");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("log_id", mapStr.get("log_id"));
		mapSQLParameter.put("img_src", mapStr.get("img_src"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("img_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改问诊记录上传图片操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update inquiry_log_img set gxsj=:gxsj");
		if(null!=mapStr.get("log_id")){
			sql.append(",log_id=:log_id");
			mapSQLParameter.put("log_id", mapStr.get("log_id"));
		}
		if(null!=mapStr.get("img_src")){
			sql.append(",img_src=:img_src");
			mapSQLParameter.put("img_src", mapStr.get("img_src"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where img_id=:img_id");
		mapSQLParameter.put("img_id", mapStr.get("img_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除问诊记录上传图片操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from inquiry_log_img where img_id=:img_id");
		mapSQLParameter.put("img_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}