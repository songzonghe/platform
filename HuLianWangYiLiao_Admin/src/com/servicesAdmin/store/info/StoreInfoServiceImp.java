package com.servicesAdmin.store.info;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.MD5;
import com.util.SysFinal;
import com.util.UtilSql;
import com.util.UtilValiDate;
/**
 * 门店基本资料 service 实现类
 * 操作人： 曾晓
 */ 
@Service("storeInfoServiceImp")
public class StoreInfoServiceImp implements StoreInfoService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取门店基本资料查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.store_id,t.hospital_id,t.store_phone,t.store_paw,t.store_name,t.store_img,t.store_im,t.store_fwwddm,t.store_xzqhdm,t.store_fwdlx,t.store_fwdclrq,t.store_dwlsgxdm,t.store_fwdflgllbdm,t.store_fwdfldm,t.store_jjlxdm,t.store_dz,t.store_fwdyyjb,t.store_fwdyydj,t.store_xkzhm,t.store_xkxmmc,t.store_xkzyxq,t.store_kbzjjes,t.store_frdb,t.store_fwdszdmzzzdfbz,t.store_sffzjg,t.store_fwddemc,t.store_fwdms,t.store_yzbm,t.store_dhhm,t.store_dwdzyx,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" ,t.store_cxbz,t.store_jgdm from store_info t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("store_id"))) {
			sql.append(" and t.store_id=:store_id ");
			mapSQLParameter.put("store_id", mapStr.get("store_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("hospital_id"))) {
				sql.append(" and t.hospital_id = :hospital_id");
				mapSQLParameter.put("hospital_id",  mapStr.get("hospital_id") );
			}
			if (UtilValiDate.isEmpty(mapStr.get("store_phone"))) {
				sql.append(" and t.store_phone like :store_phone");
				mapSQLParameter.put("store_phone", "%" + mapStr.get("store_phone") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("store_name"))) {
				sql.append(" and t.store_name like :store_name");
				mapSQLParameter.put("store_name", "%" + mapStr.get("store_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("find_store_phone"))) {
				sql.append(" and t.store_phone = :store_phone");
				mapSQLParameter.put("store_phone", mapStr.get("find_store_phone"));
			}
		}
	}

	/**
	 *获取门店基本资料信息列表
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
	 *获取一条门店基本资料信息
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
		sql.append("insert into store_info");
		sql.append("( store_cxbz,store_jgdm,hospital_id,store_phone,store_paw,store_name,store_img,store_fwwddm,store_xzqhdm,store_fwdlx,store_fwdclrq,store_dwlsgxdm,store_fwdflgllbdm,store_fwdfldm,store_jjlxdm,store_dz,store_fwdyyjb,store_fwdyydj,store_xkzhm,store_xkxmmc,store_xkzyxq,store_kbzjjes,store_frdb,store_fwdszdmzzzdfbz,store_sffzjg,store_fwddemc,store_fwdms,store_yzbm,store_dhhm,store_dwdzyx");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :store_cxbz,:store_jgdm,:hospital_id,:store_phone,:store_paw,:store_name,:store_img,:store_fwwddm,:store_xzqhdm,:store_fwdlx,:store_fwdclrq,:store_dwlsgxdm,:store_fwdflgllbdm,:store_fwdfldm,:store_jjlxdm,:store_dz,:store_fwdyyjb,:store_fwdyydj,:store_xkzhm,:store_xkxmmc,:store_xkzyxq,:store_kbzjjes,:store_frdb,:store_fwdszdmzzzdfbz,:store_sffzjg,:store_fwddemc,:store_fwdms,store_yzbm,:store_dhhm,store_dwdzyx");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("store_cxbz", mapStr.get("store_cxbz"));
		mapSQLParameter.put("store_jgdm", mapStr.get("store_jgdm"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("store_phone", mapStr.get("store_phone"));
		mapSQLParameter.put("store_paw", MD5.EncoderByMd5(mapStr.get("store_paw")));
		mapSQLParameter.put("store_name", mapStr.get("store_name"));
		mapSQLParameter.put("store_img", mapStr.get("store_img"));
		mapSQLParameter.put("store_fwwddm", mapStr.get("store_fwwddm"));
		mapSQLParameter.put("store_xzqhdm", mapStr.get("store_xzqhdm"));
		mapSQLParameter.put("store_fwdlx", mapStr.get("store_fwdlx"));
		mapSQLParameter.put("store_fwdclrq", mapStr.get("store_fwdclrq"));
		mapSQLParameter.put("store_dwlsgxdm", mapStr.get("store_dwlsgxdm"));
		mapSQLParameter.put("store_fwdflgllbdm", mapStr.get("store_fwdflgllbdm"));
		mapSQLParameter.put("store_fwdfldm", mapStr.get("store_fwdfldm"));
		mapSQLParameter.put("store_jjlxdm", mapStr.get("store_jjlxdm"));
		mapSQLParameter.put("store_dz", mapStr.get("store_dz"));
		mapSQLParameter.put("store_fwdyyjb", mapStr.get("store_fwdyyjb"));
		mapSQLParameter.put("store_fwdyydj", mapStr.get("store_fwdyydj"));
		mapSQLParameter.put("store_xkzhm", mapStr.get("store_xkzhm"));
		mapSQLParameter.put("store_xkxmmc", mapStr.get("store_xkxmmc"));
		mapSQLParameter.put("store_xkzyxq", mapStr.get("store_xkzyxq"));
		mapSQLParameter.put("store_kbzjjes", mapStr.get("store_kbzjjes"));
		mapSQLParameter.put("store_frdb", mapStr.get("store_frdb"));
		mapSQLParameter.put("store_fwdszdmzzzdfbz", mapStr.get("store_fwdszdmzzzdfbz"));
		mapSQLParameter.put("store_sffzjg", mapStr.get("store_sffzjg"));
		mapSQLParameter.put("store_fwddemc", mapStr.get("store_fwddemc"));
		mapSQLParameter.put("store_fwdms", mapStr.get("store_fwdms"));
		mapSQLParameter.put("store_yzbm", mapStr.get("store_yzbm"));
		mapSQLParameter.put("store_dhhm", mapStr.get("store_dhhm"));
		mapSQLParameter.put("store_dwdzyx", mapStr.get("store_dwdzyx"));
		
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("store_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改门店基本资料操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update store_info set gxsj=:gxsj");
		if(null!=mapStr.get("store_cxbz")){
			sql.append(",store_cxbz=:store_cxbz");
			mapSQLParameter.put("store_cxbz", mapStr.get("store_cxbz"));
		}
		if(null!=mapStr.get("store_jgdm")){
			sql.append(",store_jgdm=:store_jgdm");
			mapSQLParameter.put("store_jgdm", mapStr.get("store_jgdm"));
		}
		if(null!=mapStr.get("store_phone")){
			sql.append(",store_phone=:store_phone");
			mapSQLParameter.put("store_phone", mapStr.get("store_phone"));
		}
		if(UtilValiDate.isEmpty(mapStr.get("store_paw"))){
			sql.append(",store_paw=:store_paw");
			mapSQLParameter.put("store_paw", MD5.EncoderByMd5(mapStr.get("store_paw")));
		}
		if(null!=mapStr.get("store_name")){
			sql.append(",store_name=:store_name");
			mapSQLParameter.put("store_name", mapStr.get("store_name"));
		}
		if(null!=mapStr.get("store_img")){
			sql.append(",store_img=:store_img");
			mapSQLParameter.put("store_img", mapStr.get("store_img"));
		}
		if(null!=mapStr.get("store_im")){
			sql.append(",store_im=:store_im");
			mapSQLParameter.put("store_im", mapStr.get("store_im"));
		}
		if(null!=mapStr.get("store_fwwddm")){
			sql.append(",store_fwwddm=:store_fwwddm");
			mapSQLParameter.put("store_fwwddm", mapStr.get("store_fwwddm"));
		}
		if(null!=mapStr.get("store_xzqhdm")){
			sql.append(",store_xzqhdm=:store_xzqhdm");
			mapSQLParameter.put("store_xzqhdm", mapStr.get("store_xzqhdm"));
		}
		if(null!=mapStr.get("store_fwdlx")){
			sql.append(",store_fwdlx=:store_fwdlx");
			mapSQLParameter.put("store_fwdlx", mapStr.get("store_fwdlx"));
		}
		if(null!=mapStr.get("store_fwdclrq")){
			sql.append(",store_fwdclrq=:store_fwdclrq");
			mapSQLParameter.put("store_fwdclrq", mapStr.get("store_fwdclrq"));
		}
		if(null!=mapStr.get("store_dwlsgxdm")){
			sql.append(",store_dwlsgxdm=:store_dwlsgxdm");
			mapSQLParameter.put("store_dwlsgxdm", mapStr.get("store_dwlsgxdm"));
		}
		if(null!=mapStr.get("store_fwdflgllbdm")){
			sql.append(",store_fwdflgllbdm=:store_fwdflgllbdm");
			mapSQLParameter.put("store_fwdflgllbdm", mapStr.get("store_fwdflgllbdm"));
		}
		if(null!=mapStr.get("store_fwdfldm")){
			sql.append(",store_fwdfldm=:store_fwdfldm");
			mapSQLParameter.put("store_fwdfldm", mapStr.get("store_fwdfldm"));
		}
		if(null!=mapStr.get("store_jjlxdm")){
			sql.append(",store_jjlxdm=:store_jjlxdm");
			mapSQLParameter.put("store_jjlxdm", mapStr.get("store_jjlxdm"));
		}
		if(null!=mapStr.get("store_dz")){
			sql.append(",store_dz=:store_dz");
			mapSQLParameter.put("store_dz", mapStr.get("store_dz"));
		}
		if(null!=mapStr.get("store_fwdyyjb")){
			sql.append(",store_fwdyyjb=:store_fwdyyjb");
			mapSQLParameter.put("store_fwdyyjb", mapStr.get("store_fwdyyjb"));
		}
		if(null!=mapStr.get("store_fwdyydj")){
			sql.append(",store_fwdyydj=:store_fwdyydj");
			mapSQLParameter.put("store_fwdyydj", mapStr.get("store_fwdyydj"));
		}
		if(null!=mapStr.get("store_xkzhm")){
			sql.append(",store_xkzhm=:store_xkzhm");
			mapSQLParameter.put("store_xkzhm", mapStr.get("store_xkzhm"));
		}
		if(null!=mapStr.get("store_xkxmmc")){
			sql.append(",store_xkxmmc=:store_xkxmmc");
			mapSQLParameter.put("store_xkxmmc", mapStr.get("store_xkxmmc"));
		}
		if(null!=mapStr.get("store_xkzyxq")){
			sql.append(",store_xkzyxq=:store_xkzyxq");
			mapSQLParameter.put("store_xkzyxq", mapStr.get("store_xkzyxq"));
		}
		if(null!=mapStr.get("store_kbzjjes")){
			sql.append(",store_kbzjjes=:store_kbzjjes");
			mapSQLParameter.put("store_kbzjjes", mapStr.get("store_kbzjjes"));
		}
		if(null!=mapStr.get("store_frdb")){
			sql.append(",store_frdb=:store_frdb");
			mapSQLParameter.put("store_frdb", mapStr.get("store_frdb"));
		}
		if(null!=mapStr.get("store_fwdszdmzzzdfbz")){
			sql.append(",store_fwdszdmzzzdfbz=:store_fwdszdmzzzdfbz");
			mapSQLParameter.put("store_fwdszdmzzzdfbz", mapStr.get("store_fwdszdmzzzdfbz"));
		}
		if(null!=mapStr.get("store_sffzjg")){
			sql.append(",store_sffzjg=:store_sffzjg");
			mapSQLParameter.put("store_sffzjg", mapStr.get("store_sffzjg"));
		}
		if(null!=mapStr.get("store_fwddemc")){
			sql.append(",store_fwddemc=:store_fwddemc");
			mapSQLParameter.put("store_fwddemc", mapStr.get("store_fwddemc"));
		}
		if(null!=mapStr.get("store_fwdms")){
			sql.append(",store_fwdms=:store_fwdms");
			mapSQLParameter.put("store_fwdms", mapStr.get("store_fwdms"));
		}
		if(null!=mapStr.get("store_yzbm")){
			sql.append(",store_yzbm=:store_yzbm");
			mapSQLParameter.put("store_yzbm", mapStr.get("store_yzbm"));
		}
		if(null!=mapStr.get("store_dhhm")){
			sql.append(",store_dhhm=:store_dhhm");
			mapSQLParameter.put("store_dhhm", mapStr.get("store_dhhm"));
		}
		if(null!=mapStr.get("store_dwdzyx")){
			sql.append(",store_dwdzyx=:store_dwdzyx");
			mapSQLParameter.put("store_dwdzyx", mapStr.get("store_dwdzyx"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where store_id=:store_id");
		mapSQLParameter.put("store_id", mapStr.get("store_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除门店基本资料操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from store_info where store_id=:store_id");
		mapSQLParameter.put("store_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}
	
	/**
	 *获取门店list
	 */
	public List<Map<String, Object>> shopList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.store_id,t.hospital_id,t.store_phone,t.store_paw,t.store_name,t.store_img,t.store_im,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from store_info t where 1=1");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	
	
	

	/************************系统生成方法完毕******************************/
}