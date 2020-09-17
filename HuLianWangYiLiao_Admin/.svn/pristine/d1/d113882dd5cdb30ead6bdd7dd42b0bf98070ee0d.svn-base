package com.servicesAdmin.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.MD5;
import com.util.UtilValiDate;

/**
 * 登录 
 */
@Service("loginServerImp")
public class LoginServerImp implements LoginServer{
	@Resource
	private GYDAO gyDAOimp;// dao操作类
	/**
	 * 验证医院id是否存在
	 */
	public boolean islogin(String id,String type) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select hospital_id,hospital_number from util_hospital where hospital_id=:hospital_id");
		mapSQLParameter.put("hospital_id",id);
		return this.gyDAOimp.findSqlBool(sql, mapSQLParameter);
	}
	
	
	/**
	 * 用户登录
	 */
	public Map<String, Object> login(Map<String,String> mapStr) throws Exception{
		Map<String, Object> mapObj = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.account_id,t.account_number,t.account_pwd,t.account_name,t.functions_id,t.account_type,t.other_id,t.hospital_id,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
		sql.append(",f.class_id,f.functions_name,f.functions_addr ");
		sql.append(" from system_account t left join system_functions f on t.functions_id=f.functions_id "); 
		sql.append(" where t.account_number=:login_name and t.account_pwd=:login_pwd and t.hospital_id=:hospital_id");
		mapSQLParameter.put("login_name", mapStr.get("login_name"));
		mapSQLParameter.put("login_pwd", MD5.EncoderByMd5(mapStr.get("login_pwd")));
		mapSQLParameter.put("account_type", MD5.numberDecoder(mapStr.get("hosid")).substring(0,1));
		mapSQLParameter.put("hospital_id", MD5.numberDecoder(mapStr.get("hosid")).substring(2));
		Map<String, Object> mapLogin = this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
		if(mapLogin.size()!=0){
			//禁用
			if("0".equals(mapLogin.get("zt"))){
				return mapLogin;
			}
			//根据账户去匹配赋予的权限
			mapObj.put("mapLogin", mapLogin);
			mapObj.put("gongNengJson", this.getGN(mapLogin));
		}
		return mapObj;
	}
	
	
	/**
	 * 根据账户加载出所有的功能
	 */
	public StringBuffer getGN(Map<String, Object> mapLogin)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//得到账户的所有功能地址
		if("0".equals(mapLogin.get("account_id")+"")){
			sql.append("select t.functions_id,t.class_id,t.functions_name,t.functions_addr,t.functions_icon,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
			sql.append(" from system_functions t  where t.zt=0  order by functions_id "); 
		}else if("1".equals(mapLogin.get("account_type")+"")&& "0".equals(mapLogin.get("other_id")+"")){
			sql.append("select t.functions_id,t.class_id,t.functions_name,t.functions_addr,t.functions_icon,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
			sql.append(" from system_functions t  where t.zt=1  order by functions_id "); 
		}else if("2".equals(mapLogin.get("account_type")+"")){
			sql.append("select t.functions_id,t.class_id,t.functions_name,t.functions_addr,t.functions_icon,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
			sql.append(" from system_functions t  where t.zt=2  order by functions_id "); 
		}else{
			sql.append("select t.functions_id,t.class_id,t.functions_name,t.functions_addr,t.functions_icon,t.lrsj,t.lrzh,t.zt,t.bz,t.gxsj");
			sql.append(" from system_functions t,system_join j  "); 
			sql.append(" where t.functions_id=j.functions_id and j.account_id =:account_id and t.zt=:account_type order by functions_id ");
			mapSQLParameter.put("account_id", mapLogin.get("account_id"));
			mapSQLParameter.put("account_type", mapLogin.get("account_type"));
		}
		List<Map<String,Object>> functionsList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		//获取所有功能分类
		List<Map<String,Object>> classList = getFunctionsClassList(functionsList);
		//拼接所有分类的目录
		List<Map<String,Object>> catalogList=getFunctionsCatalog(functionsList, classList);
		StringBuffer sb = new StringBuffer();
		//以replaceCatalog_（上级id） 为替换字段    
		sb.append("{'data':[replaceCatalog0end]}");
		//拼接目录
		while(sb.indexOf("replaceCatalog")!=-1){
			int bool=0;
			for (Map<String, Object> map : catalogList){
				if(sb.indexOf("replaceCatalog"+map.get("replaceId")+"end")!=-1){
					bool=1;
					String str2=sb.toString().replaceAll("replaceCatalog"+map.get("replaceId")+"end", map.get("replaceVal")+"");
					sb.delete(0, sb.length());
					sb.append(str2);
				}
			}
			if(bool==0){//没有发生替换则退出
				String str=sb.toString().replaceAll("replaceCatalog", "replaceError");//替换发送错误
				sb.delete(0, sb.length());
				sb.append(str);
				break;
			}
		}
		if(sb.indexOf("replaceError0end")!=-1){
			return new StringBuffer();
		}
		return sb;
	}
	
	/**
	 * 获取功能分类
	 */
	public List<Map<String, Object>> getFunctionsClassList(List<Map<String, Object>> functionsList)throws Exception {
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.class_id ,t.class_name ,t.class_icon ,t.class_up_id");
		sql.append(" from system_class t ");
		List<Map<String, Object>> allList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		StringBuffer classIds=new StringBuffer();//账户拥有的功能分类id集合
		for (Map<String, Object> classMap : functionsList) {
			this.getFunctionsClassMap(classIds, classMap.get("class_id")+"", allList);
		}
		List<Map<String, Object>> getClassData=new ArrayList<Map<String,Object>>();
		if(UtilValiDate.isEmpty(classIds)){
			//获取账户拥有的所有功能分类
			sql.delete(0, sql.length());
			sql.append("select t.class_id ,t.class_name ,t.class_icon ,t.class_up_id ");
			sql.append(" from system_class t where t.class_id in ("+classIds.substring(1)+") group by t.class_id  order by class_sort,class_id ");
			getClassData=this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		}
		return getClassData;
	}
	/**
	 *拼接功能目录/地址
	 *type  1 目录  0 地址
	 */
	public List<Map<String,Object>> getFunctionsCatalog(List<Map<String, Object>> functionsList,List<Map<String, Object>> functionsClassList)throws Exception {
		List<Map<String,Object>> backlist = new ArrayList<Map<String,Object>>();
		//获取一级
		StringBuffer onestr = new StringBuffer();
		for (Map<String, Object> map2 : functionsClassList){
			if("0".equals(map2.get("class_up_id")+"")){
				onestr.append(",{'id':'");
				onestr.append(map2.get("class_id")+"");
				onestr.append("','text':'");
				onestr.append(map2.get("class_name"));
				onestr.append("','icon':'");
				onestr.append(map2.get("class_icon"));
				onestr.append("','data':[replaceCatalog"+map2.get("class_id")+"end]}");
			}
		}
		if(UtilValiDate.isEmpty(onestr)){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("replaceId","0");
			map.put("replaceVal",onestr.substring(1));
			backlist.add(map);
		}
		
		//获取所有功能分类集合
		for (Map<String, Object> map1 : functionsClassList){
			StringBuffer str = new StringBuffer();
			for (Map<String, Object> map2 : functionsClassList){
				if((map1.get("class_id")+"").equals(map2.get("class_up_id")+"")){
					str.append(",{'id':'");
					str.append(map2.get("class_id")+"");
					str.append("','text':'");
					str.append(map2.get("class_name"));
					str.append("','icon':'");
					str.append(map2.get("class_icon"));
					str.append("','data':[replaceCatalog"+map2.get("class_id")+"end]}");
				}
			}
			//拼接地址
			for (Map<String, Object> functionsMap : functionsList) {
				if((map1.get("class_id")+"").equals(functionsMap.get("class_id")+"")){
					str.append(",{'id':'");
					str.append(functionsMap.get("functions_id"));
					str.append("','parentID':'");
					str.append(functionsMap.get("class_id")+"");
					str.append("','text':'");
					str.append(functionsMap.get("functions_name"));
					str.append("','icon':'");
					str.append(functionsMap.get("functions_icon"));
					str.append("','url':'");
					str.append(functionsMap.get("functions_addr"));
					str.append("'}");
				}
			}
			if(UtilValiDate.isEmpty(str)){
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("replaceId",map1.get("class_id")+"");
				map.put("replaceVal",str.substring(1));
				backlist.add(map);
			}
		}
		return backlist;
	}
	/**
	 * 获取单个功能分类
	 */
	public void getFunctionsClassMap(StringBuffer classIds,String classId,List<Map<String, Object>> allList)throws Exception {
		for (Map<String, Object> classMap : allList) {
			if(classId.equals(classMap.get("class_id")+"")){
				classIds.append(","+classMap.get("class_id"));
			}
			if(classId.equals(classMap.get("class_id")+"")&&!"0".equals(classMap.get("class_up_id")+"")){
				getFunctionsClassMap(classIds, classMap.get("class_up_id")+"", allList);
			}
		}
	}
}
