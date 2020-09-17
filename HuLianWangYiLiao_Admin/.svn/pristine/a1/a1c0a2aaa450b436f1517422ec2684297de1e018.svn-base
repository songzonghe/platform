package com.servicesAdmin.util.carousel;
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
 * 轮播图 service 实现类
 * 操作人： 张龙
 */ 
@Service("utilCarouselServiceImp")
public class UtilCarouselServiceImp implements UtilCarouselService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取轮播图查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.hospital_id,t.carousel_id,t.carousel_type,t.carousel_name,t.carousel_img,t.carousel_url,t.carousel_sort,t.carousel_details,t.carousel_way,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_carousel t where t.hospital_id=:hospital_id ");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("carousel_id"))) {
			sql.append(" and t.carousel_id=:carousel_id ");
			mapSQLParameter.put("carousel_id", mapStr.get("carousel_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("carousel_way"))) {
				sql.append(" and t.carousel_way = :carousel_way");
				mapSQLParameter.put("carousel_way", mapStr.get("carousel_way"));
			}
			if (UtilValiDate.isEmpty(mapStr.get("carousel_name"))) {
				sql.append(" and t.carousel_name like :carousel_name");
				mapSQLParameter.put("carousel_name", "%"+mapStr.get("carousel_name")+"%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("carousel_type"))) {
				sql.append(" and t.carousel_type = :carousel_type");
				mapSQLParameter.put("carousel_type", mapStr.get("carousel_type"));
			}
		}
	}

	/**
	 *获取轮播图信息列表
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
	 *获取一条轮播图信息
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
		sql.append("insert into util_carousel");
		sql.append("( hospital_id,carousel_type,carousel_name,carousel_img,carousel_url,carousel_sort,carousel_details,carousel_way");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:carousel_type,:carousel_name,:carousel_img,:carousel_url,:carousel_sort,:carousel_details,:carousel_way");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("carousel_type", mapStr.get("carousel_type"));
		mapSQLParameter.put("carousel_name", mapStr.get("carousel_name"));
		mapSQLParameter.put("carousel_img", mapStr.get("carousel_img"));
		mapSQLParameter.put("carousel_url", mapStr.get("carousel_url"));
		mapSQLParameter.put("carousel_sort", mapStr.get("carousel_sort"));
		mapSQLParameter.put("carousel_details", mapStr.get("carousel_details"));
		mapSQLParameter.put("carousel_way", mapStr.get("carousel_way"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("carousel_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改轮播图操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_carousel set gxsj=:gxsj");
		if(null!=mapStr.get("carousel_type")){
			sql.append(",carousel_type=:carousel_type");
			mapSQLParameter.put("carousel_type", mapStr.get("carousel_type"));
		}
		if(null!=mapStr.get("carousel_name")){
			sql.append(",carousel_name=:carousel_name");
			mapSQLParameter.put("carousel_name", mapStr.get("carousel_name"));
		}
		if(null!=mapStr.get("carousel_img")){
			sql.append(",carousel_img=:carousel_img");
			mapSQLParameter.put("carousel_img", mapStr.get("carousel_img"));
		}
		if(null!=mapStr.get("carousel_url")){
			sql.append(",carousel_url=:carousel_url");
			mapSQLParameter.put("carousel_url", mapStr.get("carousel_url"));
		}
		if(null!=mapStr.get("carousel_sort")){
			sql.append(",carousel_sort=:carousel_sort");
			mapSQLParameter.put("carousel_sort", mapStr.get("carousel_sort"));
		}
		if(null!=mapStr.get("carousel_details")){
			sql.append(",carousel_details=:carousel_details");
			mapSQLParameter.put("carousel_details", mapStr.get("carousel_details"));
		}
		if(null!=mapStr.get("carousel_way")){
			sql.append(",carousel_way=:carousel_way");
			mapSQLParameter.put("carousel_way", mapStr.get("carousel_way"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		sql.append(" where carousel_id=:carousel_id");
		mapSQLParameter.put("carousel_id", mapStr.get("carousel_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除轮播图操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_carousel where carousel_id=:carousel_id");
		mapSQLParameter.put("carousel_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}
}