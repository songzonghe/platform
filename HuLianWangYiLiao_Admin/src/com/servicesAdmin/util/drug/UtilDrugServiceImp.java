package com.servicesAdmin.util.drug;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dao.interfaceDAO.GYDAO;
import com.util.PinYin;
import com.util.PinyinToWubi;
import com.util.SysFinal;
import com.util.UtilJson;
import com.util.UtilSql;
import com.util.UtilStr;
import com.util.UtilValiDate;
/**
 * 药品信息 service 实现类
 * 操作人： 刘杰
 */ 
@Service("utilDrugServiceImp")
public class UtilDrugServiceImp implements UtilDrugService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取药品信息查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select c.class_name,t.drug_id,t.hospital_id,t.class_id,t.usage_id,t.frequency_id,t.drug_number,t.drug_name,t.drug_usname,t.drug_company,t.drug_specifications,t.drug_img,t.drug_unit,t.drug_weight_unit,t.drug_volume_unit,t.drug_smallest_unit,t.drug_packaging_unit,t.drug_weight_num,t.drug_volume_num,t.drug_packaging_num,t.drug_price,t.drug_maxdosage,t.drug_instructions,t.drug_type,t.drug_is_rx,t.drug_maxdosage2,t.drug_maxdosage3,t.drug_maxfrequency,t.drug_maxday,t.drug_tagging,t.drug_age_limit,t.drug_pinyin,t.drug_wubi,t.yb_limit_cate,t.yb_limit_range,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_drug t,util_drug_class c where t.class_id=c.class_id and t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id",  mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("drug_id"))) {
			sql.append(" and t.drug_id=:drug_id ");
			mapSQLParameter.put("drug_id", mapStr.get("drug_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("class_name"))) {
				sql.append(" and c.class_name like :class_name");
				mapSQLParameter.put("class_name", "%" + mapStr.get("class_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("drug_number"))) {
				sql.append(" and t.drug_number like :drug_number");
				mapSQLParameter.put("drug_number", "%" + mapStr.get("drug_number") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("drug_name"))) {
				sql.append(" and t.drug_name like :drug_name");
				mapSQLParameter.put("drug_name", "%" + mapStr.get("drug_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("drug_usname"))) {
				sql.append(" and t.drug_usname like :drug_usname");
				mapSQLParameter.put("drug_usname", "%" + mapStr.get("drug_usname") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("drug_company"))) {
				sql.append(" and t.drug_company like :drug_company");
				mapSQLParameter.put("drug_company", "%" + mapStr.get("drug_company") + "%");
			}
		}
	}

	/**
	 *获取药品信息信息列表
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
	 *获取一条药品信息信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		Map<String, Object> map=this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		sql.delete(0, sql.length());
		sql.append("select usage_type from util_drug_usage where usage_id=:usage_id");
		mapSQLParameter.put("usage_id", map.get("usage_id"));
		map.put("usage_type", this.gyDAOimp.findSqlMap(sql, mapSQLParameter).get("usage_type"));
		mapStr.put("usage_type", UtilStr.getStr(this.gyDAOimp.findSqlMap(sql, mapSQLParameter).get("usage_type")));
		return map;
	}

	/**
	 *新增操作
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into util_drug");
		sql.append("( hospital_id,class_id,usage_id,frequency_id,drug_number,drug_name,drug_usname,drug_company,drug_specifications,drug_img,drug_unit,drug_weight_unit,drug_volume_unit,drug_smallest_unit,drug_packaging_unit,drug_weight_num,drug_volume_num,drug_packaging_num,drug_price,drug_maxdosage,drug_instructions,drug_type,drug_is_rx,drug_maxdosage2,drug_maxdosage3,drug_maxfrequency,drug_maxday,drug_tagging,drug_age_limit,yb_limit_range,yb_limit_cate,drug_pinyin,drug_wubi,drug_agen");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :hospital_id,:class_id,:usage_id,:frequency_id,:drug_number,:drug_name,:drug_usname,:drug_company,:drug_specifications,:drug_img,:drug_unit,:drug_weight_unit,:drug_volume_unit,:drug_smallest_unit,:drug_packaging_unit,:drug_weight_num,:drug_volume_num,:drug_packaging_num,:drug_price,:drug_maxdosage,:drug_instructions,:drug_type,:drug_is_rx,:drug_maxdosage2,:drug_maxdosage3,:drug_maxfrequency,:drug_maxday,:drug_tagging,:drug_age_limit,:yb_limit_range,:yb_limit_cate,:drug_pinyin,:drug_wubi,:drug_agen");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("class_id", mapStr.get("class_id"));
		mapSQLParameter.put("usage_id", mapStr.get("usage_id"));
		mapSQLParameter.put("frequency_id", mapStr.get("frequency_id"));
		if(StringUtils.isEmpty(mapStr.get("drug_number"))) {
			mapSQLParameter.put("drug_number", null);
		}else {
			mapSQLParameter.put("drug_number", mapStr.get("drug_number"));
		}
		
		
		
		mapSQLParameter.put("drug_name", mapStr.get("drug_name"));
		
		if(StringUtils.isEmpty(mapStr.get("drug_usname"))) {
			mapSQLParameter.put("drug_usname", null);
		}else {
			mapSQLParameter.put("drug_usname", mapStr.get("drug_usname"));
		}
		if( StringUtils.isEmpty(mapStr.get("drug_company"))) {
			mapSQLParameter.put("drug_company", null);	
		}else {
			mapSQLParameter.put("drug_company", mapStr.get("drug_company"));	
		}
	
		mapSQLParameter.put("drug_specifications", mapStr.get("drug_specifications"));
		mapSQLParameter.put("drug_img", mapStr.get("drug_img"));
		mapSQLParameter.put("drug_unit", mapStr.get("drug_unit"));
		mapSQLParameter.put("drug_weight_unit", mapStr.get("drug_weight_unit"));
		mapSQLParameter.put("drug_volume_unit", mapStr.get("drug_volume_unit"));
		mapSQLParameter.put("drug_smallest_unit", mapStr.get("drug_smallest_unit"));
		mapSQLParameter.put("drug_packaging_unit", mapStr.get("drug_packaging_unit"));
		if (UtilValiDate.isEmpty(mapStr.get("drug_weight_num"))) {
			mapSQLParameter.put("drug_weight_num", mapStr.get("drug_weight_num"));
		}else {
			mapSQLParameter.put("drug_weight_num", "0.00");
		}
		if (UtilValiDate.isEmpty(mapStr.get("drug_volume_num"))) {
			mapSQLParameter.put("drug_volume_num", mapStr.get("drug_volume_num"));
		}else {
			mapSQLParameter.put("drug_volume_num",  "0.00");
		}
		mapSQLParameter.put("drug_packaging_num", mapStr.get("drug_packaging_num"));
		if(StringUtils.isEmpty(mapStr.get("drug_price"))) {
			mapSQLParameter.put("drug_price", "0.00");
		}else {
			mapSQLParameter.put("drug_price", mapStr.get("drug_price"));
		}
		
		
		mapSQLParameter.put("drug_maxdosage", mapStr.get("drug_maxdosage"));
		
		if(StringUtils.isEmpty(mapStr.get("drug_instructions"))) {
			mapSQLParameter.put("drug_instructions", null);
		}else {
			mapSQLParameter.put("drug_instructions", mapStr.get("drug_instructions"));
		}
		
		mapSQLParameter.put("drug_type", mapStr.get("drug_type"));
		mapSQLParameter.put("drug_is_rx", mapStr.get("drug_is_rx"));
		
		if(StringUtils.isEmpty(mapStr.get("drug_maxdosage2"))) {
			mapSQLParameter.put("drug_maxdosage2", "0.00");
		}else {
			mapSQLParameter.put("drug_maxdosage2", mapStr.get("drug_maxdosage2"));
		}
		
		if(StringUtils.isEmpty(mapStr.get("drug_maxdosage3"))) {
			mapSQLParameter.put("drug_maxdosage3", "0.00");
		}else {
			mapSQLParameter.put("drug_maxdosage3", mapStr.get("drug_maxdosage3"));
		}
		if(StringUtils.isEmpty(mapStr.get("drug_maxfrequency"))) {
			mapSQLParameter.put("drug_maxfrequency", null);
		}else {
			mapSQLParameter.put("drug_maxfrequency", mapStr.get("drug_maxfrequency"));
		}
		if(StringUtils.isEmpty(mapStr.get("drug_maxday"))) {
			mapSQLParameter.put("drug_maxday", null);
		}else {
			mapSQLParameter.put("drug_maxday", mapStr.get("drug_maxday"));
		}
		if(StringUtils.isEmpty(mapStr.get("drug_tagging"))) {
			mapSQLParameter.put("drug_tagging", null);
		}else {
			mapSQLParameter.put("drug_tagging", mapStr.get("drug_tagging"));
		}
		
		if(StringUtils.isEmpty(mapStr.get("drug_age_limit"))) {
			mapSQLParameter.put("drug_age_limit", 0);
		}else{
			mapSQLParameter.put("drug_age_limit", mapStr.get("drug_age_limit"));
		}
		
		if(StringUtils.isEmpty(mapStr.get("yb_limit_range"))) {
			mapSQLParameter.put("yb_limit_range", "");
		}else{
			mapSQLParameter.put("yb_limit_range", mapStr.get("yb_limit_range"));
		}
		
		if(StringUtils.isEmpty(mapStr.get("yb_limit_cate"))) {
			mapSQLParameter.put("yb_limit_cate", "");
		}else{
			mapSQLParameter.put("yb_limit_cate", mapStr.get("yb_limit_cate"));
		}
		
		mapSQLParameter.put("drug_pinyin", PinYin.getPinYinHeadChar(mapStr.get("drug_name")));
		mapSQLParameter.put("drug_wubi", PinyinToWubi.getWBCode(mapStr.get("drug_name")));
		
		if(StringUtils.isEmpty(mapStr.get("drug_agen"))) {
			mapSQLParameter.put("drug_agen", "");
		}else{
			mapSQLParameter.put("drug_agen", mapStr.get("drug_agen"));
		}
		
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("drug_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改药品信息操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_drug set gxsj=:gxsj");
	
		if(!StringUtils.isEmpty(mapStr.get("hospital_id"))){
			sql.append(",hospital_id=:hospital_id");
			mapSQLParameter.put("hospital_id", mapStr.get("hospital_id"));
		}
		
		if(!StringUtils.isEmpty(mapStr.get("class_id"))){
			sql.append(",class_id=:class_id");
			mapSQLParameter.put("class_id", mapStr.get("class_id"));
		}
		if(!StringUtils.isEmpty(mapStr.get("usage_id"))){
			sql.append(",usage_id=:usage_id");
			mapSQLParameter.put("usage_id", mapStr.get("usage_id"));
		}
		if(!StringUtils.isEmpty(mapStr.get("frequency_id"))){
			sql.append(",frequency_id=:frequency_id");
			mapSQLParameter.put("frequency_id", mapStr.get("frequency_id"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_number"))){
			sql.append(",drug_number=:drug_number");
			mapSQLParameter.put("drug_number", mapStr.get("drug_number"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_name"))){
			sql.append(",drug_name=:drug_name");
			mapSQLParameter.put("drug_name", mapStr.get("drug_name"));
			sql.append(",drug_pinyin=:drug_pinyin");
			mapSQLParameter.put("drug_pinyin", PinYin.getPinYinHeadChar(mapStr.get("drug_name")));
			sql.append(",drug_wubi=:drug_wubi");
			mapSQLParameter.put("drug_wubi", PinyinToWubi.getWBCode(mapStr.get("drug_name")));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_usname"))){
			sql.append(",drug_usname=:drug_usname");
			mapSQLParameter.put("drug_usname", mapStr.get("drug_usname"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_company"))){
			sql.append(",drug_company=:drug_company");
			mapSQLParameter.put("drug_company", mapStr.get("drug_company"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_specifications"))){
			sql.append(",drug_specifications=:drug_specifications");
			mapSQLParameter.put("drug_specifications", mapStr.get("drug_specifications"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_img"))){
			sql.append(",drug_img=:drug_img");
			mapSQLParameter.put("drug_img", mapStr.get("drug_img"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_unit"))){
			sql.append(",drug_unit=:drug_unit");
			mapSQLParameter.put("drug_unit", mapStr.get("drug_unit"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_weight_unit"))){
			sql.append(",drug_weight_unit=:drug_weight_unit");
			mapSQLParameter.put("drug_weight_unit", mapStr.get("drug_weight_unit"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_volume_unit"))){
			sql.append(",drug_volume_unit=:drug_volume_unit");
			mapSQLParameter.put("drug_volume_unit", mapStr.get("drug_volume_unit"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_smallest_unit"))){
			sql.append(",drug_smallest_unit=:drug_smallest_unit");
			mapSQLParameter.put("drug_smallest_unit", mapStr.get("drug_smallest_unit"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_packaging_unit"))){
			sql.append(",drug_packaging_unit=:drug_packaging_unit");
			mapSQLParameter.put("drug_packaging_unit", mapStr.get("drug_packaging_unit"));
		}
		if (UtilValiDate.isEmpty(mapStr.get("drug_weight_num"))) {
			sql.append(",drug_weight_num=:drug_weight_num");
			mapSQLParameter.put("drug_weight_num", mapStr.get("drug_weight_num"));
		}else {
			sql.append(",drug_weight_num=:drug_weight_num");
			mapSQLParameter.put("drug_weight_num", "0.00");
		}
		if (UtilValiDate.isEmpty(mapStr.get("drug_volume_num"))) {
			sql.append(",drug_volume_num=:drug_volume_num");
			mapSQLParameter.put("drug_volume_num", mapStr.get("drug_volume_num"));
		}else {
			sql.append(",drug_volume_num=:drug_volume_num");
			mapSQLParameter.put("drug_volume_num", "0.00");
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_packaging_num"))){
			sql.append(",drug_packaging_num=:drug_packaging_num");
			mapSQLParameter.put("drug_packaging_num", mapStr.get("drug_packaging_num"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_price"))){
			sql.append(",drug_price=:drug_price");
			mapSQLParameter.put("drug_price", mapStr.get("drug_price"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_maxdosage"))){
			sql.append(",drug_maxdosage=:drug_maxdosage");
			mapSQLParameter.put("drug_maxdosage", mapStr.get("drug_maxdosage"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_instructions"))){
			sql.append(",drug_instructions=:drug_instructions");
			mapSQLParameter.put("drug_instructions", mapStr.get("drug_instructions"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_type"))){
			sql.append(",drug_type=:drug_type");
			mapSQLParameter.put("drug_type", mapStr.get("drug_type"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_is_rx"))){
			sql.append(",drug_is_rx=:drug_is_rx");
			mapSQLParameter.put("drug_is_rx", mapStr.get("drug_is_rx"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_maxdosage2"))){
			sql.append(",drug_maxdosage2=:drug_maxdosage2");
			mapSQLParameter.put("drug_maxdosage2", mapStr.get("drug_maxdosage2"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_maxdosage3"))){
			sql.append(",drug_maxdosage3=:drug_maxdosage3");
			mapSQLParameter.put("drug_maxdosage3", mapStr.get("drug_maxdosage3"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_maxfrequency"))){
			sql.append(",drug_maxfrequency=:drug_maxfrequency");
			mapSQLParameter.put("drug_maxfrequency", mapStr.get("drug_maxfrequency"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_maxday"))){
			sql.append(",drug_maxday=:drug_maxday");
			mapSQLParameter.put("drug_maxday", mapStr.get("drug_maxday"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_tagging"))){
			sql.append(",drug_tagging=:drug_tagging");
			mapSQLParameter.put("drug_tagging", mapStr.get("drug_tagging"));
		}
		if(!StringUtils.isEmpty(mapStr.get("drug_age_limit"))){
			sql.append(",drug_age_limit=:drug_age_limit");
			mapSQLParameter.put("drug_age_limit", mapStr.get("drug_age_limit"));
		}
		if(!StringUtils.isEmpty(mapStr.get("bz"))){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(!StringUtils.isEmpty(mapStr.get("edit_zt"))){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		
		
		if(!StringUtils.isEmpty(mapStr.get("yb_limit_cate"))){
			sql.append(",yb_limit_cate=:yb_limit_cate");
			mapSQLParameter.put("yb_limit_cate", mapStr.get("yb_limit_cate"));
		}
		
		if(!StringUtils.isEmpty(mapStr.get("yb_limit_range"))){
			sql.append(",yb_limit_range=:yb_limit_range");
			mapSQLParameter.put("yb_limit_range", mapStr.get("yb_limit_range"));
		}
		
		if(!StringUtils.isEmpty(mapStr.get("drug_agen"))){
			sql.append(",drug_agen=:drug_agen");
			mapSQLParameter.put("drug_agen", mapStr.get("drug_agen"));
		}
		
		sql.append(" where drug_id=:drug_id");
		mapSQLParameter.put("drug_id", mapStr.get("drug_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除药品信息操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_drug where drug_id=:drug_id");
		mapSQLParameter.put("drug_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
	
	/**
	 *获取药品list
	 */
	public List<Map<String, Object>> drugList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.drug_id,t.hospital_id,t.class_id,t.drug_name,t.drug_usname,t.drug_company,t.drug_specifications,t.drug_maxdosage,t.drug_maxdosage2,t.drug_maxdosage3,t.drug_img,t.drug_unit,t.drug_price,t.drug_instructions,t.drug_is_rx,t.drug_type,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_drug t where t.hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if(UtilValiDate.isEmpty(mapStr.get("find_drug_type"))) {
			sql.append(" and t.drug_type=:find_drug_type");
			mapSQLParameter.put("find_drug_type", mapStr.get("find_drug_type"));
		}
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	/************************系统生成方法完毕******************************/
	
	/**
	 *获取用法分类List
	 */
	public List<Map<String, Object>> usageList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.usage_id,t.usage_type,t.usage_name,t.usage_printing_name,t.usage_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_drug_usage t where 1=1 and t.usage_type=:usage_type");
		mapSQLParameter.put("usage_type", mapStr.get("usage_type"));
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	
	/**
	 *获取频率分类List
	 */
	public List<Map<String, Object>> frequencyList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.frequency_id,t.frequency_name,t.frequency_printing_name,t.frequency_num,t.frequency_day_num,t.frequency_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_drug_frequency t where 1=1");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	
	/**
	 * 根据上级id查询所有分类
	 */
	public String class_up_list(Map<String, String> mapStr)
			throws Exception {
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.usage_id,t.usage_type,t.usage_name,t.usage_printing_name,t.usage_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_drug_usage t where 1=1 and t.usage_type=:usage_type");
		mapSQLParameter.put("usage_type", mapStr.get("usage_type"));
		List<Map<String,Object>> list_map =  this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", UtilJson.listToJson(list_map));
		return UtilJson.mapToJson(map);
	}
	
	/**
	 *获取单位List
	 */
	public List<Map<String, Object>> optionTypeList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.option_id,t.usage_name,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_drug_attribute_option t where 1=1 and t.option_type=:option_type");
		mapSQLParameter.put("option_type", mapStr.get("option_type"));
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	
	/**
	 *获取单位List
	 */
	public List<Map<String, Object>> classList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.class_id,t.hospital_id,t.class_name,t.class_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_drug_class t where 1=1");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	
	/**
	 *获取批号list
	 */
	public List<Map<String, Object>> numberList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.log_id,t.hospital_id,t.log_name,t.log_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_batch_number t where 1=1");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	
	/**
	 * 获取剂型List
	 */
	public List<Map<String,Object>> agenList(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.code_code as agen_id,t.code_name as agen_name,t.foreign_id,t.code_e_name\r\n");
		sql.append(" from util_code t where code_type='agen' AND code_state='1' ");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	
	/**
	 *获取厂家list
	 */
	public List<Map<String, Object>> companyList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.log_id,t.hospital_id,t.log_name,t.log_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_company t where 1=1");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
}