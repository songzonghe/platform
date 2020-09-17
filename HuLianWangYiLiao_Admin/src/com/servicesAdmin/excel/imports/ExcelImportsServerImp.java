package com.servicesAdmin.excel.imports;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.PinYin;
import com.util.PinyinToWubi;
import com.util.UtilSql;
import com.util.UtilStr;
import com.util.UtilValiDate;

/**
 * 导入
 * @author 张龙
 */
@Service("excelImportsServerImp")
public class ExcelImportsServerImp implements ExcelImportsServer{
	 @Resource 
	 private GYDAO gyDAOimp;// dao操作类
	
	
	/**
	 * 数据导入  
	 */
	public Map<String, Object> addImportDataBaseData(List<Map<String, Object>>listContent,Map<String,String> mapStr)throws Exception{
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<String>list_title=new LinkedList<String>();
		//获取导入的标题名称
		for (Entry<String, Object> data : listContent.get(0).entrySet()) {
			list_title.add(data.getKey());
		}
		//药品数据导入
		if("util_drug".equals(mapStr.get("dataBaseName"))) {
			return addImportUtil_drug(list_title, listContent,mapStr,mapStr.get("dataBaseName"));
		}
		//国际疾病导入
		if("util_icd".equals(mapStr.get("dataBaseName"))) {
			return addImportUtil_icd(list_title, listContent,mapStr,mapStr.get("dataBaseName"));
		}
		//医嘱数据导入
		if("util_medical_advice".equals(mapStr.get("dataBaseName"))) {
			return addImportUtil_medical_advice(list_title, listContent,mapStr,mapStr.get("dataBaseName"));
		}
		//频率数据导入
		if("util_drug_frequency".equals(mapStr.get("dataBaseName"))) {
			return addImportUtil_drug_frequency(list_title, listContent,mapStr,mapStr.get("dataBaseName"));
		}
		//用法数据导入
		if("util_drug_usage".equals(mapStr.get("dataBaseName"))) {
			return addImportUtil_drug_usage(list_title, listContent,mapStr,mapStr.get("dataBaseName"));
		}
		//属性导入模板
		if("util_drug_attribute_option".equals(mapStr.get("dataBaseName"))) {
			return addImportUtil_drug_attribute_option(list_title, listContent,mapStr,mapStr.get("dataBaseName"));
		}
		//批号数据导入
		if("util_batch_number".equals(mapStr.get("dataBaseName"))) {
			return addImportUtil_batch_number(list_title, listContent,mapStr,mapStr.get("dataBaseName"));
		}
		//厂家数据导入
		if("util_company".equals(mapStr.get("dataBaseName"))) {
			return addImportUtil_company(list_title, listContent,mapStr,mapStr.get("dataBaseName"));
		}
		
		// 门店导入模板
		if("store_info".equals(mapStr.get("dataBaseName"))) {
			return addImportstore_info_attribute_option(list_title, listContent,mapStr,mapStr.get("dataBaseName"));
		}
		//字典导入
		if("util_dictionaries".equals(mapStr.get("dataBaseName"))) {
			return addImportUtilDictionaries(list_title, listContent,mapStr,mapStr.get("dataBaseName"));
		}
		
		return backmap;
	}
	
	/******************************************获取导入的数据模板*************************************************/
	/**
	 * 药品导入模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	@SuppressWarnings("serial")
	public Map<String, Object> addImportUtil_drug(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception {
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<Map<String, String>>newtitle=new LinkedList<Map<String,String>>();
		
		//需导入模板名称
		newtitle.add(new HashMap<String, String>() {{ put("name", "序号"); put("code", "num");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "编号"); put("code", "num1");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "药理分类"); put("code", "class_id");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "类型"); put("code", "drug_type");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "药品名称"); put("code", "drug_name");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "药品规格"); put("code", "drug_specifications");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "包装量"); put("code", "drug_packaging_num");put("type", "num");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "最小单位"); put("code", "drug_smallest_unit");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "包装单位"); put("code", "drug_packaging_unit");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "重量"); put("code", "drug_weight_num");put("type", "num");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "重量单位"); put("code", "drug_weight_unit");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "体积"); put("code", "drug_volume_num");put("type", "num");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "体积单位"); put("code", "drug_volume_unit");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "价格"); put("code", "drug_price");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "药品说明书"); put("code", "drug_instructions");}});
	
		
		if("showName".equals(type)) {//获取导入模板 在页面提示用到
			for (Map<String, String> map : newtitle) {
				list_title.add(map.get("name"));
			}
			return null;
		}
		
		//比较导入的名称 和 模板名称是否一致
		//先比较参数个数
		if(newtitle.size()!=(list_title.size())) {//减去序号的数
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确缺少数量！");
			return backmap;
		}
		//比较名称是否正确
		boolean backTitle=false;
		for (Map<String, String> newmap : newtitle){
			boolean boolTitle=true;
			for (String str2 : list_title) {
				if((newmap.get("name").trim()).equals(str2.trim())){
					boolTitle=false;
					break;
				}
			}
			if(boolTitle){
				backTitle=true;
				break;
			}
		}
		if(backTitle) {//名称有差异
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		
		//获取所有的数据库中的数据  用于校验 
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select class_id,hospital_id,drug_name,drug_specifications  from util_drug where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		List<Map<String, Object>> utilDrug = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		//查药品分类
		sql.delete(0, sql.length());
		sql.append("select class_id,hospital_id,class_name from util_drug_class where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		List<Map<String, Object>> dataList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		sql.delete(0, sql.length());
		sql.append("select usage_name,option_type from util_drug_attribute_option where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		List<Map<String, Object>> optionList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		int num=0;
		for (Map<String, Object> map : ListMapData){
			num++;
			if(num<10) {
				System.out.println(	optionList);
				System.out.println(	optionList.size());
			}
			
			if(!UtilValiDate.isEmpty(map.get("药品名称"))) {
				backmap.put("code", "240");
				backmap.put("info", "导入失败！导入的药品名称未填写！<br>编号>> "+map.get("编号"));
				return backmap;
			}
			map.put("isUpdate", "0");
			for (Map<String, Object> map2 : utilDrug){
				//序号不一致   类型和名称一样则返回
				if(map.get("药品名称").equals(map2.get("drug_number")+"") && map.get("药品规格").equals(map2.get("drug_specifications")+"") ) {
					map.put("isUpdate", "1");
				}
			}
			
			//验证分类是否存在
			boolean boolTitle=true;
			for (Map<String, Object> map2 : dataList){
				if((map.get("药理分类")+"").trim().equalsIgnoreCase((map2.get("class_name")+"").trim())) {
					map.put("药理分类", map2.get("class_id"));
					boolTitle=false;
					break;
				}
			}
			if(boolTitle) {//导入分类不存在
				sql.delete(0, sql.length());
				sql.append("insert into util_drug_class");
				sql.append("( hospital_id,class_name,class_sort");
				sql.append(UtilSql.getFieldInsertKey());
				sql.append("values( :hospital_id,:class_name,:class_sort");
				sql.append(UtilSql.getFieldInsertVal());
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
				mapSQLParameter.put("class_name", (map.get("药理分类")+"").trim());
				mapSQLParameter.put("class_sort", "1");
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				map.put("药理分类", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
				
				sql.delete(0, sql.length());
				sql.append("select class_id,hospital_id,class_name from util_drug_class where hospital_id=:hospital_id");
				mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
				dataList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
			}
			
			//导入前 将数据进行转换  将文字 转为 对应的 标识数字
			//转药品类型
			if("中药".equals(map.get("类型")+"")){
				map.put("类型", "1");
			}else if("西药".equals(map.get("类型")+"")) {
				map.put("类型", "2");
			}else if("中成药".equals(map.get("类型")+"")) {
				map.put("类型", "3");
			}else {
				backmap.put("code", "240");
				backmap.put("info", "导入失败！导入的药品类型没有找到！<br>编号>> "+map.get("编号"));
				return backmap;
			}
			
			//验证  1最小单位 2包装单位 3重量单位  4体积单位 
			boolean backtype1=true;
			boolean backtype2=true;
			boolean backtype3=true;
			boolean backtype4=true;
			
			//查药品属性
			for (Map<String, Object> map2 : optionList){
				//最小单位
				if(backtype1 && "1".equals(map2.get("option_type")+"")&&((map.get("最小单位")+"").trim().equals((map2.get("usage_name")+"").trim()))){
					backtype1=false;
				}
				//包装单位
				if(backtype2 && "2".equals(map2.get("option_type")+"")&&((map.get("包装单位")+"").trim().equals((map2.get("usage_name")+"").trim()))){
					backtype2=false;
				}
				//重量单位
				if(backtype3 && "3".equals(map2.get("option_type")+"")&&((map.get("重量单位")+"").trim().equals((map2.get("usage_name")+"").trim()))){
					backtype3=false;
				}
				//体积单位 
				if(backtype4 && "4".equals(map2.get("option_type")+"")&&((map.get("体积单位")+"").trim().equals((map2.get("usage_name")+"").trim()))){
					backtype4=false;
				}
			}
			if(backtype1&&UtilValiDate.isEmpty((map.get("最小单位")+"").trim())) {//导入最小单位不存在
				sql.delete(0, sql.length());
				Map<String, Object>mapstr=new LinkedHashMap<String, Object>();
				sql.append("insert into util_drug_attribute_option");
				sql.append("( hospital_id,option_type,usage_name,usage_sort");
				sql.append(UtilSql.getFieldInsertKey());
				sql.append("values( :hospital_id,:option_type,:usage_name,:usage_sort");
				sql.append(UtilSql.getFieldInsertVal());
				mapstr.put("hospital_id", mapStr.get("login_hospital_id"));
				mapstr.put("option_type", "1");
				mapstr.put("usage_name", (map.get("最小单位")+"").trim());
				mapstr.put("usage_sort", "1");
				UtilSql.setMapVal(mapstr, mapStr);
				this.gyDAOimp.exeSqlGetId(sql, mapstr);
				optionList.add(mapstr);
			}
			if(backtype2&&UtilValiDate.isEmpty((map.get("包装单位")+"").trim())) {//导入包装单位不存在
				sql.delete(0, sql.length());
				Map<String, Object>mapstr=new LinkedHashMap<String, Object>();
				sql.append("insert into util_drug_attribute_option");
				sql.append("( hospital_id,option_type,usage_name,usage_sort");
				sql.append(UtilSql.getFieldInsertKey());
				sql.append("values( :hospital_id,:option_type,:usage_name,:usage_sort");
				sql.append(UtilSql.getFieldInsertVal());
				mapstr.put("hospital_id", mapStr.get("login_hospital_id"));
				mapstr.put("option_type", "2");
				mapstr.put("usage_name", (map.get("包装单位")+"").trim());
				mapstr.put("usage_sort", "1");
				UtilSql.setMapVal(mapstr, mapStr);
				this.gyDAOimp.exeSqlGetId(sql, mapstr);
				optionList.add(mapstr);
			}
			if(backtype3&&UtilValiDate.isEmpty((map.get("重量单位")+"").trim())) {//导入重量单位不存在
				sql.delete(0, sql.length());
				Map<String, Object>mapstr=new LinkedHashMap<String, Object>();
				sql.append("insert into util_drug_attribute_option");
				sql.append("( hospital_id,option_type,usage_name,usage_sort");
				sql.append(UtilSql.getFieldInsertKey());
				sql.append("values( :hospital_id,:option_type,:usage_name,:usage_sort");
				sql.append(UtilSql.getFieldInsertVal());
				mapstr.put("hospital_id", mapStr.get("login_hospital_id"));
				mapstr.put("option_type", "3");
				mapstr.put("usage_name", (map.get("重量单位")+"").trim());
				mapstr.put("usage_sort", "1");
				UtilSql.setMapVal(mapstr, mapStr);
				this.gyDAOimp.exeSqlGetId(sql, mapstr);
				optionList.add(mapstr);
			}
			if(backtype4&&UtilValiDate.isEmpty((map.get("体积单位")+"").trim())) {//导入体积单位 不存在
				sql.delete(0, sql.length());
				Map<String, Object>mapstr=new LinkedHashMap<String, Object>();
				sql.append("insert into util_drug_attribute_option");
				sql.append("( hospital_id,option_type,usage_name,usage_sort");
				sql.append(UtilSql.getFieldInsertKey());
				sql.append("values( :hospital_id,:option_type,:usage_name,:usage_sort");
				sql.append(UtilSql.getFieldInsertVal());
				mapstr.put("hospital_id", mapStr.get("login_hospital_id"));
				mapstr.put("option_type", "4");
				mapstr.put("usage_name", (map.get("体积单位")+"").trim());
				mapstr.put("usage_sort", "1");
				UtilSql.setMapVal(mapstr, mapStr);
				this.gyDAOimp.exeSqlGetId(sql, mapstr);
				optionList.add(mapstr);
			}

		}
		//导出的标题正确 开始写入数据
		//拼接sql
		
		/***新增sqk***/
		StringBuffer addSql = new StringBuffer();//新增sqk
		addSql.append("insert into "+type+"(lrsj,lrzh,zt,bz,gxsj,hospital_id,drug_unit,drug_pinyin,drug_wubi");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		StringBuffer valText = new StringBuffer();
		for (Map<String, String> newmap : newtitle){
			if(!"num".equals(newmap.get("code").trim())&&!"num1".equals(newmap.get("code").trim())){
				addSql.append(","+newmap.get("code"));
				valText.append(",:"+newmap.get("code"));
			}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		}
		addSql.append(")values( :lrsj,:lrzh,:zt,:bz,:gxsj,:hospital_id,:drug_unit,:drug_pinyin,:drug_wubi"+valText+");");

		/***修改sqk***/
		StringBuffer updateSql = new StringBuffer();//修改sql
		updateSql.append("update "+type+" set gxsj=:gxsj");
		for (Map<String, String> newmap : newtitle){
			if(!"num".equals(newmap.get("code").trim())&&!"num1".equals(newmap.get("code").trim())){
				if("drug_name".equals(newmap.get("code").trim())) {
					updateSql.append(","+newmap.get("code")+"=:"+newmap.get("code"));
					updateSql.append(",drug_pinyin=:drug_pinyin,drug_wubi=:drug_wubi");
				}else {
					updateSql.append(","+newmap.get("code")+"=:"+newmap.get("code"));
				}
			}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		}
		updateSql.append(" where drug_number=:drug_number and hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
	
		int successNum=0;//成功数
		String failNum="";
		for (Map<String, Object> map : ListMapData) {
			mapSQLParameter.put("drug_unit", (map.get("包装单位")+"").trim());
			mapSQLParameter.put("drug_pinyin", PinYin.getPinYinHeadChar((map.get("药品名称")+"").trim()));
			mapSQLParameter.put("drug_wubi", PinYin.getPinYinHeadChar((map.get("药品名称")+"").trim()));
			for (Map<String, String> newmap : newtitle){
				if("num".equals(newmap.get("type")) && !UtilValiDate.isEmpty(map.get(newmap.get("name").trim()))) {
					mapSQLParameter.put(newmap.get("code").trim(), 0);
				}else {
					mapSQLParameter.put(newmap.get("code").trim(), map.get(newmap.get("name").trim()));
				}
			}
			try {
				if("0".equals(map.get("isUpdate"))) {
					UtilSql.setMapVal(mapSQLParameter, mapStr);
					this.gyDAOimp.exeSqlBool(addSql, mapSQLParameter);
				}else {
					this.gyDAOimp.exeSqlBool(updateSql, mapSQLParameter);
				}
				successNum++;
			}catch (Exception e) {
				failNum+="编号"+map.get("编号")+";";
				System.out.println(e);
//				backmap.put("code", "240");
//				backmap.put("info", "导入失败！<br>失败序号>>"+map.get("序号"));
//				return backmap;
			}
		}
		
		if(UtilValiDate.isEmpty(failNum)) {
			backmap.put("code", "240");
			backmap.put("info", "导入失败！<br>失败编号>>"+failNum);
			return backmap;
		}
		
		backmap.put("code", "200");
		backmap.put("total", ListMapData.size());
		backmap.put("success", successNum);
		System.out.println("数据导入=====总条数:"+ListMapData.size()+"=======成功数："+successNum);
		return backmap;
	}
	/**
	 * 国际疾病模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	@SuppressWarnings("serial")
	public Map<String, Object> addImportUtil_icd(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception {
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<Map<String, String>>newtitle=new LinkedList<Map<String,String>>();
		//需导入模板名称
		newtitle.add(new HashMap<String, String>() {{ put("name", "主要编码"); put("code", "icd_code");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "附加编码"); put("code", "icd_add_code");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "疾病名称"); put("code", "icd_name");}});
		if("showName".equals(type)) {//获取导入模板 在页面提示用到
			for (Map<String, String> map : newtitle) {
				list_title.add(map.get("name"));
			}
			return null;
		}
		//比较导入的名称 和 模板名称是否一致
		//先比较参数个数
		if(newtitle.size()!=(list_title.size()-1)) {//减去序号的数
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//比较名称是否正确
		boolean backTitle=false;
		for (Map<String, String> newmap : newtitle){
			boolean boolTitle=true;
			for (String str2 : list_title) {
				if((newmap.get("name").trim()).equals(str2.trim())){
					boolTitle=false;
					break;
				}
			}
			if(boolTitle){
				backTitle=true;
				break;
			}
		}
		if(backTitle) {//名称有差异
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//获取所有的数据库中的数据  用于校验 
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select icd_id,hospital_id,icd_code,icd_add_code,icd_name from util_icd where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		List<Map<String, Object>> utilIcd = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		for (Map<String, Object> map : ListMapData) {
			for (Map<String, Object> map2 : ListMapData){
				if(!map.get("序号").equals(map2.get("序号"))&&(map.get("主要编码")+"").trim().equals((map2.get("主要编码")+"").trim())) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！文件中主要编码重复！<br>序号>> "+map.get("序号")+"=="+map2.get("序号"));
					return backmap;
				}
//				if(!map.get("序号").equals(map2.get("序号"))&&(map.get("疾病名称")+"").trim().equals((map2.get("疾病名称")+"").trim())) {
//					backmap.put("code", "240");
//					backmap.put("info", "导入失败！文件中疾病名称重复！<br>序号>> "+map.get("序号")+"=="+map2.get("序号"));
//					return backmap;
//				}
			}
			if(utilIcd.size()>0) {
				for (Map<String, Object> map2 : utilIcd){
					if((map.get("主要编码")+"").trim().equals((map2.get("icd_code")+"").trim())) {
						backmap.put("code", "240");
						backmap.put("info", "导入失败！主要编码重复！<br>序号>> "+map.get("序号"));
						return backmap;
					}
//					if((map.get("疾病名称")+"").trim().equals((map2.get("icd_name")+"").trim())) {
//						backmap.put("code", "240");
//						backmap.put("info", "导入失败！疾病名称重复！<br>序号>> "+map.get("序号"));
//						return backmap;
//					}
				}
			}
			//获得首字母拼音
			map.put("icd_pinyin", PinYin.getPinYinHeadChar((map.get("疾病名称")+"").trim()));
			//获取的五笔码
			map.put("icd_wubi", PinyinToWubi.getWBCode((map.get("疾病名称")+"").trim()));
		}
		//导出的标题正确 开始写入数据
		//拼接sql
		sql.delete(0, sql.length());
		//新增国际疾病分类
		sql.append("insert into "+type+"(lrsj,lrzh,zt,bz,gxsj,hospital_id,icd_sort,icd_pinyin,icd_wubi");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		StringBuffer valText = new StringBuffer();
		for (Map<String, String> newmap : newtitle){
			if(!"num".equals(newmap.get("code").trim())){
				sql.append(","+newmap.get("code"));
				valText.append(",:"+newmap.get("code"));
			}
		}
		sql.append(")values( :lrsj,:lrzh,:zt,:bz,:gxsj,:hospital_id,:icd_sort,:icd_pinyin,:icd_wubi"+valText+");");
		//新增诊断
		StringBuffer newSql=new StringBuffer();
		newSql.append("insert into util_diagnosis (lrsj,lrzh,zt,bz,gxsj,doctor_id,icd_id,hospital_id,diagnosis_name)");
		newSql.append("values( :lrsj,:lrzh,:zt,:bz,:gxsj,:doctor_id,:icd_id,:hospital_id,:icd_name)");
		int successNum=0;//成功数
		for (Map<String, Object> map : ListMapData){
			for (Map<String, String> newmap : newtitle){
				if("num".equals(newmap.get("type")) && !UtilValiDate.isEmpty(map.get(newmap.get("name").trim()))) {
					mapSQLParameter.put(newmap.get("code").trim(), 0);
				}else {
					mapSQLParameter.put(newmap.get("code").trim(), map.get(newmap.get("name").trim()));
				}
			}
			try {
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				mapSQLParameter.put("icd_sort",1);
				mapSQLParameter.put("icd_pinyin",map.get("icd_pinyin"));
				mapSQLParameter.put("icd_wubi",map.get("icd_wubi"));
				String icd_id=this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter);
				mapSQLParameter.put("doctor_id", "0");
				mapSQLParameter.put("icd_id", icd_id);
				this.gyDAOimp.exeSqlBool(newSql, mapSQLParameter);
				successNum++;
			}catch (Exception e) {
				System.out.println(e);
				backmap.put("code", "240");
				backmap.put("info", "导入失败！<br>失败序号>>"+map.get("序号"));
				return backmap;
			}
		}
		backmap.put("code", "200");
		backmap.put("total", ListMapData.size());
		backmap.put("success", successNum);
		System.out.println("数据导入=====总条数:"+ListMapData.size()+"=======成功数："+successNum);
		return backmap;
	}
	
	
	
	/**
	 * 医嘱导入模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	@SuppressWarnings("serial")
	public Map<String, Object> addImportUtil_medical_advice(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception {
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<Map<String, String>>newtitle=new LinkedList<Map<String,String>>();
		//需导入模板名称
		newtitle.add(new HashMap<String, String>() {{ put("name", "名称"); put("code", "advice_name");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "备注"); put("code", "bz");}});
		
		if("showName".equals(type)) {//获取导入模板 在页面提示用到
			for (Map<String, String> map : newtitle) {
				list_title.add(map.get("name"));
			}
			return null;
		}
		//比较导入的名称 和 模板名称是否一致
		//先比较参数个数
		if(newtitle.size()!=(list_title.size()-1)) {//减去序号的数
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//比较名称是否正确
		boolean backTitle=false;
		for (Map<String, String> newmap : newtitle){
			boolean boolTitle=true;
			for (String str2 : list_title) {
				if((newmap.get("name").trim()).equals(str2.trim())){
					boolTitle=false;
				}
			}
			if(boolTitle){
				backTitle=true;
				break;
			}
		}
		if(backTitle) {//名称有差异
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//获取所有的数据库中的数据  用于校验 
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//查分类
		sql.append("select advice_id,hospital_id,advice_name from util_medical_advice");
		List<Map<String, Object>> dataList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		String failText = "";//失败的id 
		for (Map<String, Object> map : ListMapData) {
			// 校验同一类型中  编号唯一
			//先检测文档中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : ListMapData){
				//序号不一致   类型和名称一样则返回
				if(!map.get("序号").equals(map2.get("序号"))&&(map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("name").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！文档的名称重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
			
			//在检查数据库中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : dataList){
				//数据库存在的弹出
				if((map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("code").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！导入的名称与系统的重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
			
		}
		//导出的标题正确 开始写入数据
		//拼接sql
		sql.delete(0, sql.length());
		sql.append("insert into "+type+"(lrsj,lrzh,zt,bz,gxsj,hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		StringBuffer valText = new StringBuffer();
		for (Map<String, String> newmap : newtitle){
			if(!"bz".equals(UtilStr.getStr(newmap.get("code")))) {
				sql.append(","+newmap.get("code"));
				valText.append(",:"+newmap.get("code"));
			}
		}
		sql.append(")values( :lrsj,:lrzh,:zt,:bz,:gxsj,:hospital_id"+valText+");");
		int successNum=0;//成功数
		int failNum=0;//失败
		failText = "";//失败的id
		for (Map<String, Object> map : ListMapData) {
			for (Map<String, String> newmap : newtitle){
				if("num".equals(newmap.get("type")) && !UtilValiDate.isEmpty(map.get(newmap.get("name").trim()))) {
					mapSQLParameter.put(newmap.get("code").trim(), 0);
				}else {
					mapSQLParameter.put(newmap.get("code").trim(), map.get(newmap.get("name").trim()));
				}
			}
			try {
				mapSQLParameter.put("lrsj",UtilSql.getGXSJ());
				mapSQLParameter.put("lrzh",mapStr.get("lrzh"));
				mapSQLParameter.put("zt","2");
				mapSQLParameter.put("gxsj",UtilSql.getGXSJ());
				this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
				successNum++;
			}catch (Exception e) {
				failNum++;
				failText=map.get("序号")+"";//错误序号
				break;
			}
		}
		backmap.put("code", "200");
		if(failNum!=0) {
			backmap.put("code", "240");
			backmap.put("info", "导入失败！<br>失败序号>>"+failText);
		}
		backmap.put("total", ListMapData.size());
		backmap.put("success", successNum);
		System.out.println("数据导入=====总条数:"+ListMapData.size()+"=======成功数："+successNum+"=======错误序号："+failText);
		return backmap;
	}
	
	
	/**
	 * 频率导入模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	@SuppressWarnings("serial")
	public Map<String, Object> addImportUtil_drug_frequency(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception {
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<Map<String, String>>newtitle=new LinkedList<Map<String,String>>();
		//需导入模板名称
		newtitle.add(new HashMap<String, String>() {{ put("name", "名称"); put("code", "frequency_printing_name");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "备注"); put("code", "frequency_name");}});
		
		if("showName".equals(type)) {//获取导入模板 在页面提示用到
			for (Map<String, String> map : newtitle) {
				list_title.add(map.get("name"));
			}
			return null;
		}
		//比较导入的名称 和 模板名称是否一致
		//先比较参数个数
		if(newtitle.size()!=(list_title.size()-1)) {//减去序号的数
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//比较名称是否正确
		boolean backTitle=false;
		for (Map<String, String> newmap : newtitle){
			boolean boolTitle=true;
			for (String str2 : list_title) {
				if((newmap.get("name").trim()).equals(str2.trim())){
					boolTitle=false;
				}
			}
			if(boolTitle){
				backTitle=true;
				break;
			}
		}
		if(backTitle) {//名称有差异
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//获取所有的数据库中的数据  用于校验 
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//查表数据
		sql.append("select frequency_name,frequency_printing_name from util_drug_frequency");
		List<Map<String, Object>> dataList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		String failText = "";//失败的id 
		for (Map<String, Object> map : ListMapData) {
			// 校验同一类型中  编号唯一
			//先检测文档中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : ListMapData){
				//序号不一致   类型和名称一样则返回
				if(!map.get("序号").equals(map2.get("序号"))&&(map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("name").trim())+"")&&(map.get(newtitle.get(1).get("name").trim())+"").equals(map2.get(newtitle.get(1).get("name").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！文档的名称或备注重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
			
			//在检查数据库中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : dataList){
				//数据库存在的弹出
				if((map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("code").trim())+"")&&(map.get(newtitle.get(1).get("name").trim())+"").equals(map2.get(newtitle.get(1).get("code").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！导入的名称或打印名称与系统的重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
			map.put("frequency_num", "");
			map.put("frequency_day_num", "");
			String frequency_name=(map.get(newtitle.get(1).get("name").trim())+"");
			if((frequency_name).indexOf("/")!=-1) {
				String str1=frequency_name.substring(0, frequency_name.indexOf("/"));
				String str2=frequency_name.substring(str1.length()+1, frequency_name.length());
				map.put("frequency_num", find_Num(str1));
				map.put("frequency_day_num", find_Num(str2));
			}else {
				map.put("frequency_num", "0");
				map.put("frequency_day_num", "0");
//				if("睡前服用".equals(frequency_name)){
//					map.put("frequency_num", "0");
//					map.put("frequency_day_num", "0");
//				}else if("隔天1次".equals(frequency_name)){
//					map.put("frequency_num", "0");
//					map.put("frequency_day_num", "0");
//				}else if("立即服用".equals(frequency_name)){
//					map.put("frequency_num", "0");
//					map.put("frequency_day_num", "0");
//				}else if("每周一次".equals(frequency_name)){
//					map.put("frequency_num", "0");
//					map.put("frequency_day_num", "0");
//				}
			}
			
		}
		//导出的标题正确 开始写入数据
		//拼接sql
		sql.delete(0, sql.length());
		sql.append("insert into "+type+"(lrsj,lrzh,zt,bz,gxsj,frequency_num,frequency_day_num,hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		StringBuffer valText = new StringBuffer();
		for (Map<String, String> newmap : newtitle){
			sql.append(","+newmap.get("code"));
			valText.append(",:"+newmap.get("code"));
		}
		sql.append(")values( :lrsj,:lrzh,:zt,:bz,:gxsj,:frequency_num,:frequency_day_num,:hospital_id"+valText+" );");
		int successNum=0;//成功数
		int failNum=0;//失败
		failText = "";//失败的id
		for (Map<String, Object> map : ListMapData) {
			mapSQLParameter.put("frequency_num", map.get("frequency_num"));
			mapSQLParameter.put("frequency_day_num", map.get("frequency_day_num"));
			for (Map<String, String> newmap : newtitle){
				if("num".equals(newmap.get("type")) && !UtilValiDate.isEmpty(map.get(newmap.get("name").trim()))) {
					mapSQLParameter.put(newmap.get("code").trim(), 0);
				}else {
					mapSQLParameter.put(newmap.get("code").trim(), map.get(newmap.get("name").trim()));
				}
			}
			try {
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
				successNum++;
			}catch (Exception e) {
				failNum++;
				failText=map.get("序号")+"";//错误序号
				break;
			}
		}
		backmap.put("code", "200");
		if(failNum!=0) {
			backmap.put("code", "240");
			backmap.put("info", "导入失败！<br>失败序号>>"+failText);
		}
		backmap.put("total", ListMapData.size());
		backmap.put("success", successNum);
		System.out.println("数据导入=====总条数:"+ListMapData.size()+"=======成功数："+successNum+"=======错误序号："+failText);
		return backmap;
	}
	
	/**
	 *提取数字
	 */
	public String find_Num(String mapStr)throws Exception{
		String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher m = p.matcher(mapStr);  
		return m.replaceAll("").trim();
	}
	
	
	/**
	 * 用法导入模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	@SuppressWarnings("serial")
	public Map<String, Object> addImportUtil_drug_usage(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception {
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<Map<String, String>>newtitle=new LinkedList<Map<String,String>>();
		//需导入模板名称
		newtitle.add(new HashMap<String, String>() {{ put("name", "用法类型"); put("code", "usage_type");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "用法名称"); put("code", "usage_name");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "打印名称"); put("code", "usage_printing_name");}});
		
		if("showName".equals(type)) {//获取导入模板 在页面提示用到
			for (Map<String, String> map : newtitle) {
				list_title.add(map.get("name"));
			}
			return null;
		}
		//比较导入的名称 和 模板名称是否一致
		//先比较参数个数
		if(newtitle.size()!=(list_title.size()-1)) {//减去序号的数
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//比较名称是否正确
		boolean backTitle=false;
		for (Map<String, String> newmap : newtitle){
			boolean boolTitle=true;
			for (String str2 : list_title) {
				if((newmap.get("name").trim()).equals(str2.trim())){
					boolTitle=false;
				}
			}
			if(boolTitle){
				backTitle=true;
				break;
			}
		}
		if(backTitle) {//名称有差异
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//获取所有的数据库中的数据  用于校验 
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//查表数据
		sql.append("select usage_name,usage_printing_name from util_drug_usage");
		List<Map<String, Object>> dataList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		String failText = "";//失败的id 
		for (Map<String, Object> map : ListMapData) {
			// 校验同一类型中  编号唯一
			//先检测文档中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : ListMapData){
				//序号不一致   类型和名称一样则返回
				if(!map.get("序号").equals(map2.get("序号"))&&(map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("name").trim())+"")&&(map.get(newtitle.get(1).get("name").trim())+"").equals(map2.get(newtitle.get(1).get("name").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！文档的名称或备注重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
			
			//在检查数据库中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : dataList){
				//数据库存在的弹出
				if((map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("code").trim())+"")&&(map.get(newtitle.get(1).get("name").trim())+"").equals(map2.get(newtitle.get(1).get("code").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！导入的名称或打印名称与系统的重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
			
			//转用法类型
			boolean bool=true;
			if("西药用法".equals(map.get("用法类型")+"")){
				map.put("用法类型", "1");bool=false;
			}else if("中药特殊服用用法".equals(map.get("用法类型")+"")) {
				map.put("用法类型", "2");bool=false;
			}
			else if("中药服用方法".equals(map.get("用法类型")+"")) {
				map.put("用法类型", "3");bool=false;
			}
			else if("中药服用要求".equals(map.get("用法类型")+"")) {
				map.put("用法类型", "4");bool=false;
			}
			if(bool) {
				backmap.put("code", "240");
				backmap.put("info", "导入失败！导入的用法类型没有找到！<br>序号>> "+map.get("序号"));
				return backmap;
			}
			
		}
		//导出的标题正确 开始写入数据
		//拼接sql
		sql.delete(0, sql.length());
		sql.append("insert into "+type+"(lrsj,lrzh,zt,bz,gxsj,hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		StringBuffer valText = new StringBuffer();
		for (Map<String, String> newmap : newtitle){
			sql.append(","+newmap.get("code"));
			valText.append(",:"+newmap.get("code"));
		}
		sql.append(")values( :lrsj,:lrzh,:zt,:bz,:gxsj,:hospital_id"+valText+");");
		int successNum=0;//成功数
		int failNum=0;//失败
		failText = "";//失败的id
		for (Map<String, Object> map : ListMapData) {
			for (Map<String, String> newmap : newtitle){
				if("num".equals(newmap.get("type")) && !UtilValiDate.isEmpty(map.get(newmap.get("name").trim()))) {
					mapSQLParameter.put(newmap.get("code").trim(), 0);
				}else {
					mapSQLParameter.put(newmap.get("code").trim(), map.get(newmap.get("name").trim()));
				}
			}
			try {
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
				successNum++;
			}catch (Exception e) {
				failNum++;
				failText=map.get("序号")+"";//错误序号
				break;
			}
		}
		backmap.put("code", "200");
		if(failNum!=0) {
			backmap.put("code", "240");
			backmap.put("info", "导入失败！<br>失败序号>>"+failText);
		}
		backmap.put("total", ListMapData.size());
		backmap.put("success", successNum);
		System.out.println("数据导入=====总条数:"+ListMapData.size()+"=======成功数："+successNum+"=======错误序号："+failText);
		return backmap;
	}
	
	
	/**
	 * 属性导入模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	@SuppressWarnings("serial")
	public Map<String, Object> addImportUtil_drug_attribute_option(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception {
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<Map<String, String>>newtitle=new LinkedList<Map<String,String>>();
		//需导入模板名称
		newtitle.add(new HashMap<String, String>() {{ put("name", "属性类型"); put("code", "option_type");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "属性名称"); put("code", "usage_name");}});
		
		if("showName".equals(type)) {//获取导入模板 在页面提示用到
			for (Map<String, String> map : newtitle) {
				list_title.add(map.get("name"));
			}
			return null;
		}
		//比较导入的名称 和 模板名称是否一致
		//先比较参数个数
		if(newtitle.size()!=(list_title.size()-1)) {//减去序号的数
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//比较名称是否正确
		boolean backTitle=false;
		for (Map<String, String> newmap : newtitle){
			boolean boolTitle=true;
			for (String str2 : list_title) {
				if((newmap.get("name").trim()).equals(str2.trim())){
					boolTitle=false;
				}
			}
			if(boolTitle){
				backTitle=true;
				break;
			}
		}
		if(backTitle) {//名称有差异
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//获取所有的数据库中的数据  用于校验 
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//查表数据
		sql.append("select option_type,usage_name from util_drug_attribute_option");
		List<Map<String, Object>> dataList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		for (Map<String, Object> map : ListMapData) {
			// 校验同一类型中  编号唯一
			//先检测文档中的数据  是否存在相同的属性
			for (Map<String, Object> map2 : ListMapData){
				//序号不一致   类型和名称一样则返回
				if(!map.get("序号").equals(map2.get("序号"))&& (map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("name").trim())+"") && (map.get(newtitle.get(1).get("name").trim())+"").equals(map2.get(newtitle.get(1).get("name").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！属性重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
			//转用法类型
			boolean bool=true;
			if("最小单位".equals(map.get("属性类型")+"")){
				map.put("属性类型", "1");bool=false;
			}else if("包装单位".equals(map.get("属性类型")+"")) {
				map.put("属性类型", "2");bool=false;
			}
			else if("重量单位".equals(map.get("属性类型")+"")) {
				map.put("属性类型", "3");bool=false;
			}
			else if("体积单位 ".equals(map.get("属性类型")+"")) {
				map.put("属性类型", "4");bool=false;
			}
			if(bool) {
				backmap.put("code", "240");
				backmap.put("info", "导入失败！导入的属性类型没有找到！<br>序号>> "+map.get("序号"));
				return backmap;
			}
			//在检查数据库中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : dataList){
				//数据库存在的弹出
				if((map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get("option_type")+"") && (map.get(newtitle.get(1).get("name").trim())+"").equals(map2.get("usage_name")+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！导入的属性名称重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
		}
		//导出的标题正确 开始写入数据
		//拼接sql
		sql.delete(0, sql.length());
		sql.append("insert into "+type+"(lrsj,lrzh,zt,bz,gxsj,hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		StringBuffer valText = new StringBuffer();
		for (Map<String, String> newmap : newtitle){
			sql.append(","+newmap.get("code"));
			valText.append(",:"+newmap.get("code"));
		}
		sql.append(")values( :lrsj,:lrzh,:zt,:bz,:gxsj,:hospital_id"+valText+");");
		int successNum=0;//成功数
		for (Map<String, Object> map : ListMapData) {
			for (Map<String, String> newmap : newtitle){
				if("num".equals(newmap.get("type")) && !UtilValiDate.isEmpty(map.get(newmap.get("name").trim()))) {
					mapSQLParameter.put(newmap.get("code").trim(), 0);
				}else {
					mapSQLParameter.put(newmap.get("code").trim(), map.get(newmap.get("name").trim()));
				}
			}
			try {
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
				successNum++;
			}catch (Exception e) {
				System.out.println(e);
				backmap.put("code", "240");
				backmap.put("info", "导入失败！<br>序号>> "+map.get("序号"));
				return backmap;
			}
		}
		backmap.put("code", "200");
		backmap.put("total", ListMapData.size());
		backmap.put("success", successNum);
		System.out.println("数据导入=====总条数:"+ListMapData.size()+"=======成功数："+successNum);
		return backmap;
	}
	
	/**
	 * 批号导入模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	@SuppressWarnings("serial")
	public Map<String, Object> addImportUtil_batch_number(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception {
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<Map<String, String>>newtitle=new LinkedList<Map<String,String>>();
		//需导入模板名称
		newtitle.add(new HashMap<String, String>() {{ put("name", "批号"); put("code", "log_name");}});
		
		if("showName".equals(type)) {//获取导入模板 在页面提示用到
			for (Map<String, String> map : newtitle) {
				list_title.add(map.get("name"));
			}
			return null;
		}
		//比较导入的名称 和 模板名称是否一致
		//先比较参数个数
		if(newtitle.size()!=(list_title.size()-1)) {//减去序号的数
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//比较名称是否正确
		boolean backTitle=false;
		for (Map<String, String> newmap : newtitle){
			boolean boolTitle=true;
			for (String str2 : list_title) {
				if((newmap.get("name").trim()).equals(str2.trim())){
					boolTitle=false;
				}
			}
			if(boolTitle){
				backTitle=true;
				break;
			}
		}
		if(backTitle) {//名称有差异
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//获取所有的数据库中的数据  用于校验 
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//查表数据
		sql.append("select log_name from util_company");
		List<Map<String, Object>> dataList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		String failText = "";//失败的id 
		for (Map<String, Object> map : ListMapData) {
			// 校验同一类型中  编号唯一
			//先检测文档中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : ListMapData){
				//序号不一致   类型和名称一样则返回
				if(!map.get("序号").equals(map2.get("序号"))&&(map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("name").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！文档的批号重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
			
			//在检查数据库中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : dataList){
				//数据库存在的弹出
				if((map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("code").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！导入的批号与系统的重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
		}
		//导出的标题正确 开始写入数据
		//拼接sql
		sql.delete(0, sql.length());
		sql.append("insert into "+type+"(lrsj,lrzh,zt,bz,gxsj,hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		StringBuffer valText = new StringBuffer();
		for (Map<String, String> newmap : newtitle){
			sql.append(","+newmap.get("code"));
			valText.append(",:"+newmap.get("code"));
		}
		sql.append(")values( :lrsj,:lrzh,:zt,:bz,:gxsj,:hospital_id"+valText+");");
		int successNum=0;//成功数
		int failNum=0;//失败
		failText = "";//失败的id
		for (Map<String, Object> map : ListMapData) {
			for (Map<String, String> newmap : newtitle){
				if("num".equals(newmap.get("type")) && !UtilValiDate.isEmpty(map.get(newmap.get("name").trim()))) {
					mapSQLParameter.put(newmap.get("code").trim(), 0);
				}else {
					mapSQLParameter.put(newmap.get("code").trim(), map.get(newmap.get("name").trim()));
				}
			}
			try {
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
				successNum++;
			}catch (Exception e) {
				failNum++;
				failText=map.get("序号")+"";//错误序号
				break;
			}
		}
		backmap.put("code", "200");
		if(failNum!=0) {
			backmap.put("code", "240");
			backmap.put("info", "导入失败！<br>失败序号>>"+failText);
		}
		backmap.put("total", ListMapData.size());
		backmap.put("success", successNum);
		System.out.println("数据导入=====总条数:"+ListMapData.size()+"=======成功数："+successNum+"=======错误序号："+failText);
		return backmap;
	}
	
	/**
	 * 厂家导入模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	@SuppressWarnings("serial")
	public Map<String, Object> addImportUtil_company(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception {
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<Map<String, String>>newtitle=new LinkedList<Map<String,String>>();
		//需导入模板名称
		newtitle.add(new HashMap<String, String>() {{ put("name", "厂家"); put("code", "log_name");}});
		
		if("showName".equals(type)) {//获取导入模板 在页面提示用到
			for (Map<String, String> map : newtitle) {
				list_title.add(map.get("name"));
			}
			return null;
		}
		//比较导入的名称 和 模板名称是否一致
		//先比较参数个数
		if(newtitle.size()!=(list_title.size()-1)) {//减去序号的数
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//比较名称是否正确
		boolean backTitle=false;
		for (Map<String, String> newmap : newtitle){
			boolean boolTitle=true;
			for (String str2 : list_title) {
				if((newmap.get("name").trim()).equals(str2.trim())){
					boolTitle=false;
				}
			}
			if(boolTitle){
				backTitle=true;
				break;
			}
		}
		if(backTitle) {//名称有差异
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//获取所有的数据库中的数据  用于校验 
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//查表数据
		sql.append("select log_name from util_company");
		List<Map<String, Object>> dataList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		String failText = "";//失败的id 
		for (Map<String, Object> map : ListMapData) {
			// 校验同一类型中  编号唯一
			//先检测文档中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : ListMapData){
				//序号不一致   类型和名称一样则返回
				if(!map.get("序号").equals(map2.get("序号"))&&(map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("name").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！文档的厂家重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
			
			//在检查数据库中的数据  是否存在相同的编号
			for (Map<String, Object> map2 : dataList){
				//数据库存在的弹出
				if((map.get(newtitle.get(0).get("name").trim())+"").equals(map2.get(newtitle.get(0).get("code").trim())+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败！导入的厂家与系统的重复！<br>序号>> "+map.get("序号"));
					return backmap;
				}
			}
		}
		//导出的标题正确 开始写入数据
		//拼接sql
		sql.delete(0, sql.length());
		sql.append("insert into "+type+"(lrsj,lrzh,zt,bz,gxsj,hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		StringBuffer valText = new StringBuffer();
		for (Map<String, String> newmap : newtitle){
			sql.append(","+newmap.get("code"));
			valText.append(",:"+newmap.get("code"));
		}
		sql.append(")values( :lrsj,:lrzh,:zt,:bz,:gxsj,:hospital_id"+valText+");");
		int successNum=0;//成功数
		int failNum=0;//失败
		failText = "";//失败的id
		for (Map<String, Object> map : ListMapData) {
			for (Map<String, String> newmap : newtitle){
				if("num".equals(newmap.get("type")) && !UtilValiDate.isEmpty(map.get(newmap.get("name").trim()))) {
					mapSQLParameter.put(newmap.get("code").trim(), 0);
				}else {
					mapSQLParameter.put(newmap.get("code").trim(), map.get(newmap.get("name").trim()));
				}
			}
			try {
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
				successNum++;
			}catch (Exception e) {
				failNum++;
				failText=map.get("序号")+"";//错误序号
				break;
			}
		}
		backmap.put("code", "200");
		if(failNum!=0) {
			backmap.put("code", "240");
			backmap.put("info", "导入失败！<br>失败序号>>"+failText);
		}
		backmap.put("total", ListMapData.size());
		backmap.put("success", successNum);
		System.out.println("数据导入=====总条数:"+ListMapData.size()+"=======成功数："+successNum+"=======错误序号："+failText);
		return backmap;
	}

	/**
	 * 门店导入模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	
	@SuppressWarnings("serial")
	public Map<String, Object> addImportstore_info_attribute_option(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception {
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<Map<String, String>>newtitle=new LinkedList<Map<String,String>>();
		//需导入模板名称
		newtitle.add(new HashMap<String, String>() {{ put("name", "手机号码/账号"); put("code", "store_phone");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "机构标识"); put("code", "store_jgdm");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "统一社会信用代码"); put("code", "store_xhxydm");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "门店名称"); put("code", "store_name");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "服务网点代码"); put("code", "store_fwwddm");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "服务点类型"); put("code", "store_fwdlx");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "服务点成立日期"); put("code", "store_fwdclrq");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "单位隶属关系代码"); put("code", "store_dwlsgxdm");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "服务点分类管理类别代码"); put("code", "store_fwdflgllbdm");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "服务点分类代码"); put("code", "store_fwdfldm");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "经济类型代码"); put("code", "store_jjlxdm");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "地址"); put("code", "store_dz");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "服务点医院级别"); put("code", "store_fwdyyjb");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "服务点医院等级"); put("code", "store_fwdyydj");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "许可证号码"); put("code", "store_xkzhm");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "许可项目名称"); put("code", "store_xkxmmc");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "许可证有效期"); put("code", "store_xkzyxq");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "开办资金金额数"); put("code", "store_kbzjjes");}});//
		newtitle.add(new HashMap<String, String>() {{ put("name", "法人代表/负责人"); put("code", "store_frdb");}});//
		newtitle.add(new HashMap<String, String>() {{ put("name", "服务点所在地民族自治地方标志(1是;2 否)"); put("code", "store_fwdszdmzzzdfbz");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "是否分支机构(1是;2 否)"); put("code", "store_sffzjg");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "服务点第二名称"); put("code", "store_fwddemc");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "服务点描述"); put("code", "store_fwdms");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "邮政编码"); put("code", "store_yzbm");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "电话号码(总机/查询台)"); put("code", "store_dhhm");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "单位电子信箱(E-mail)"); put("code", "store_dwdzyx");}});

		if("showName".equals(type)) {//获取导入模板 在页面提示用到
			for (Map<String, String> map : newtitle) {
				list_title.add(map.get("name"));
			}
			return null;
		}
		
		//先比较参数个数
		if(newtitle.size()!=(list_title.size()-1)) {//减去序号的数
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//比较名称是否正确
		boolean backTitle=false;
		for (Map<String, String> newmap : newtitle){
			boolean boolTitle=true;
			for (String str2 : list_title) {
				if((newmap.get("name").trim()).equals(str2.trim())){
					boolTitle=false;
				}
			}
			if(boolTitle){
				backTitle=true;
				break;
			}
		}
		if(backTitle) {//名称有差异
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
			//获取所有的数据库中的数据  用于校验 
			StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
			sql.append("select store_id,hospital_id,store_phone,store_name  from store_info where hospital_id=:hospital_id");
			mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
			List<Map<String, Object>> listData = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
			for (Map<String, Object> map : ListMapData){
				for (Map<String, Object> map2 : ListMapData){
					//序号不一致   类型和名称一样则返回
					if(UtilStr.getInt(map.get("序号"))!=UtilStr.getInt(map2.get("序号")) && map.get("手机号码/账号").equals(map2.get("手机号码/账号")+"")) {
						backmap.put("code", "240");
						backmap.put("info", "导入失败,文档中账号重复<br>失败序号>>"+map.get("序号"));
						return backmap;
					}
				}
				for (Map<String, Object> map2 : listData){
					//序号不一致   类型和名称一样则返回
					if(map.get("手机号码/账号").equals(map2.get("store_phone")+"")) {
						backmap.put("code", "240");
						backmap.put("info", "导入失败,文档中账号重复<br>失败序号>>"+map.get("序号"));
						return backmap;
					}
				}
		}
		//拼接sql
		sql.delete(0, sql.length());
		sql.append("insert into store_info(lrsj,lrzh,zt,bz,gxsj,hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		StringBuffer valText = new StringBuffer();
		for (Map<String, String> newmap : newtitle){
			sql.append(","+newmap.get("code"));
			valText.append(",:"+newmap.get("code"));
		}
		sql.append(")values( :lrsj,:lrzh,:zt,:bz,:gxsj,:hospital_id"+valText+");");
		int successNum=0;//成功数
		for (Map<String, Object> map : ListMapData) {
			for (Map<String, String> newmap : newtitle){
				if("num".equals(newmap.get("type")) && !UtilValiDate.isEmpty(map.get(newmap.get("name").trim()))) {
					mapSQLParameter.put(newmap.get("code").trim(), 0);
				}else {
					mapSQLParameter.put(newmap.get("code").trim(), map.get(newmap.get("name").trim()));
				}
			}
			try {
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
				successNum++;
			}catch (Exception e) {
				System.out.println(e);
				backmap.put("code", "240");
				backmap.put("info", "导入失败！！<br>失败序号>>"+map.get("序号"));
				return backmap;
			}
		}
		backmap.put("code", "200");
		backmap.put("total", ListMapData.size());
		backmap.put("success", successNum);
		System.out.println("数据导入=====总条数:"+ListMapData.size()+"=======成功数："+successNum);
		return backmap;
	}
	
	/**
	 * 字典导入模板
	 * type=showName 只获取需导入的名称  其他 获取名称和数据
	 */
	@SuppressWarnings("serial")
	public Map<String, Object> addImportUtilDictionaries(List<String>list_title,List<Map<String, Object>>ListMapData,Map<String,String> mapStr,String type) throws Exception {
		Map<String,Object> backmap=new LinkedHashMap<String, Object>();
		List<Map<String, String>>newtitle=new LinkedList<Map<String,String>>();
		//需导入模板名称
		newtitle.add(new HashMap<String, String>() {{ put("name", "类型编号"); put("code", "type_code");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "类型名称"); put("code", "type_name");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "数据编号"); put("code", "data_code");}});
		newtitle.add(new HashMap<String, String>() {{ put("name", "数据名称"); put("code", "data_name");}});
		if("showName".equals(type)) {//获取导入模板 在页面提示用到
			for (Map<String, String> map : newtitle) {
				list_title.add(map.get("name"));
			}
			return null;
		}
		//先比较参数个数
		if(newtitle.size()!=(list_title.size()-1)) {//减去序号的数
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//比较名称是否正确
		boolean backTitle=false;
		for (Map<String, String> newmap : newtitle){
			boolean boolTitle=true;
			for (String str2 : list_title) {
				if((newmap.get("name").trim()).equals(str2.trim())){
					boolTitle=false;
				}
			}
			if(boolTitle){
				backTitle=true;
				break;
			}
		}
		if(backTitle){//名称有差异
			backmap.put("code", "220");
			backmap.put("info", "导入标题不正确！");
			return backmap;
		}
		//获取所有的数据库中的数据  用于校验 
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.dictionaries_type_id,t.dictionaries_type_code,t.dictionaries_type_name  from util_dictionaries_type t ");
		List<Map<String, Object>> getTypes = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		sql.delete(0, sql.length());
		sql.append("select t.dictionaries_type_id,t.dictionaries_type_code,t.dictionaries_type_name,d.dictionaries_data_code,d.dictionaries_data_name  from util_dictionaries_type t,util_dictionaries_data d where t.dictionaries_type_id=d.dictionaries_type_id");
		List<Map<String, Object>> listData = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		for (Map<String, Object> map : ListMapData){
			for (Map<String, Object> map2 : ListMapData){
				//序号不一致   类型和名称一样则返回
				if(UtilStr.getInt(map.get("序号"))!=UtilStr.getInt(map2.get("序号")) && map.get("类型编号").equals(map2.get("类型编号")+"")  && map.get("数据编号").equals(map2.get("数据编号")+"") ) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败<br>行号"+map2.get("序号")+"与行号"+map.get("序号")+"类型编号和数据编号重复");
					return backmap;
				}
			}
			for (Map<String, Object> map2 : listData){
				//序号不一致   类型和名称一样则返回
				if(map.get("类型编号").equals(map2.get("dictionaries_type_code")+"") && map.get("数据编号").equals(map2.get("dictionaries_data_code")+"")) {
					backmap.put("code", "240");
					backmap.put("info", "导入失败,数据编号已存在<br>失败行号>>"+map.get("序号"));
					return backmap;
				}
			}
			//获取类型 不存在则新增 存在则修改
			boolean bools=true;
			for (Map<String, Object> map2 : getTypes){
				//序号不一致   类型和名称一样则返回
				if(map.get("类型编号").equals(map2.get("dictionaries_type_code")+"")) {
					if(!map.get("类型名称").equals(map2.get("dictionaries_type_name")+"")) {
						sql.delete(0, sql.length());
						sql.append("update util_dictionaries_type set dictionaries_type_name=:dictionaries_type_name where dictionaries_type_code=:dictionaries_type_code");
						mapSQLParameter.put("dictionaries_type_code", map.get("类型编号"));
						mapSQLParameter.put("dictionaries_type_name", map.get("类型名称"));
						this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
						map2.put("dictionaries_type_name", map.get("类型名称"));
					}
					map.put("dictionaries_type_id", map2.get("dictionaries_type_id"));
					bools=false;
				}
			}
			//新增
			if(bools){
				Map<String, Object> mapSQLParameters = new HashMap<String, Object>();
				sql.delete(0, sql.length());
				sql.append("insert into util_dictionaries_type(lrsj,lrzh,zt,bz,gxsj,dictionaries_type_code,dictionaries_type_name)");
				sql.append(" values(:lrsj,:lrzh,:zt,:bz,:gxsj,:dictionaries_type_code,:dictionaries_type_name)");
				UtilSql.setMapVal(mapSQLParameters, mapStr);
				mapSQLParameters.put("dictionaries_type_code", map.get("类型编号"));
				mapSQLParameters.put("dictionaries_type_name", map.get("类型名称"));
				String dictionaries_type_id=this.gyDAOimp.exeSqlGetId(sql, mapSQLParameters);
				map.put("dictionaries_type_id", dictionaries_type_id);
				mapSQLParameters.put("dictionaries_type_id", dictionaries_type_id);
				getTypes.add(mapSQLParameters);//加入数据
			}
			
			
		}
		//拼接sql
		sql.delete(0, sql.length());
		sql.append("insert into util_dictionaries_data(lrsj,lrzh,zt,bz,gxsj,dictionaries_type_id,dictionaries_data_code,dictionaries_data_name)");
		sql.append(" values(:lrsj,:lrzh,:zt,:bz,:gxsj,:dictionaries_type_id,:dictionaries_data_code,:dictionaries_data_name)");
		
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		int successNum=0;//成功数
		for (Map<String, Object> map : ListMapData) {
			mapSQLParameter.put("dictionaries_type_id", map.get("dictionaries_type_id"));
			mapSQLParameter.put("dictionaries_data_code", map.get("数据编号"));
			mapSQLParameter.put("dictionaries_data_name", map.get("数据名称"));
			try {
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
				successNum++;
			}catch (Exception e) {
				System.out.println(e);
				backmap.put("code", "240");
				backmap.put("info", "导入失败！！<br>失败行号>>"+map.get("序号"));
				return backmap;
			}
		}
		backmap.put("code", "200");
		backmap.put("total", ListMapData.size());
		backmap.put("success", successNum);
		System.out.println("数据导入=====总条数:"+ListMapData.size()+"=======成功数："+successNum);
		return backmap;
	}
	
	
}
