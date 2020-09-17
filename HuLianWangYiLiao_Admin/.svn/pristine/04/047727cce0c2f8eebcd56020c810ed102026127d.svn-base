package com.servicesAdmin.util.icon;
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
 * app功能图标 service 实现类
 * 操作人： 张龙
 */ 
@Service("utilIconServiceImp")
public class UtilIconServiceImp implements UtilIconService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取app功能图标查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.icon_id,t.icon_name,t.icon_img,t.is_show,t.is_outer_chain,t.icon_link,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_icon t where 1=1");
		if (UtilValiDate.isEmpty(mapStr.get("icon_id"))) {
			sql.append(" and t.icon_id=:icon_id ");
			mapSQLParameter.put("icon_id", mapStr.get("icon_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("icon_name"))) {
				sql.append(" and t.icon_name like :icon_name");
				mapSQLParameter.put("icon_name", "%" + mapStr.get("icon_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("is_show"))) {
				sql.append(" and t.is_show like :is_show");
				mapSQLParameter.put("is_show", "%" + mapStr.get("is_show") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("is_outer_chain"))) {
				sql.append(" and t.is_outer_chain like :is_outer_chain");
				mapSQLParameter.put("is_outer_chain", "%" + mapStr.get("is_outer_chain") + "%");
			}
		}
	}

	/**
	 *获取app功能图标信息列表
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
	 *获取一条app功能图标信息
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
		sql.append("insert into util_icon");
		sql.append("( icon_name,icon_img,is_show,is_outer_chain,icon_link");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :icon_name,:icon_img,:is_show,:is_outer_chain,:icon_link");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("icon_name", mapStr.get("icon_name"));
		mapSQLParameter.put("icon_img", mapStr.get("icon_img"));
		mapSQLParameter.put("is_show", mapStr.get("is_show"));
		mapSQLParameter.put("is_outer_chain", mapStr.get("is_outer_chain"));
		mapSQLParameter.put("icon_link", mapStr.get("icon_link"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("icon_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改app功能图标操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_icon set gxsj=:gxsj");
		if(null!=mapStr.get("icon_name")){
			sql.append(",icon_name=:icon_name");
			mapSQLParameter.put("icon_name", mapStr.get("icon_name"));
		}
		if(null!=mapStr.get("icon_img")){
			sql.append(",icon_img=:icon_img");
			mapSQLParameter.put("icon_img", mapStr.get("icon_img"));
		}
		if(null!=mapStr.get("is_show")){
			sql.append(",is_show=:is_show");
			mapSQLParameter.put("is_show", mapStr.get("is_show"));
		}
		if(null!=mapStr.get("is_outer_chain")){
			sql.append(",is_outer_chain=:is_outer_chain");
			mapSQLParameter.put("is_outer_chain", mapStr.get("is_outer_chain"));
		}
		if(null!=mapStr.get("icon_link")){
			sql.append(",icon_link=:icon_link");
			mapSQLParameter.put("icon_link", mapStr.get("icon_link"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where icon_id=:icon_id");
		mapSQLParameter.put("icon_id", mapStr.get("icon_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除app功能图标操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_icon where icon_id=:icon_id");
		mapSQLParameter.put("icon_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}
	
	/**
	 *获取国际疾病分类  list
	 */
	public List<Map<String, Object>> icdList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select icd_id,hospital_id,icd_name,icd_sort,lrsj,lrzh,zt,bz,gxsj");
		sql.append(" FROM util_icd t where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}


	/************************系统生成方法完毕******************************/
}