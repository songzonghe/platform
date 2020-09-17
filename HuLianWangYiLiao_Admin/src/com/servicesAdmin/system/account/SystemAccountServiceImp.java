package com.servicesAdmin.system.account;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.MD5;
import com.util.SysFinal;
import com.util.UtilJson;
import com.util.UtilSql;
import com.util.UtilValiDate;
/**
 * 账户 service 实现类
 * 操作人： 张龙
 */ 
@Service("systemAccountServiceImp")
public class SystemAccountServiceImp implements SystemAccountService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取账户查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.account_id,t.hospital_id,t.account_type,t.account_number,t.account_pwd,t.account_name,t.functions_id,t.other_id,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(",sys.functions_name ");
		sql.append(" from system_account t left join system_functions sys  on sys.functions_id=t.functions_id where 1=1  ");
		sql.append(" and t.account_type =:account_type");
		mapSQLParameter.put("account_type", mapStr.get("login_account_type"));
		if("1".equals(mapStr.get("login_account_type"))) {
			sql.append(" and t.hospital_id =:hospital_id");
			mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		}
		
		if (UtilValiDate.isEmpty(mapStr.get("find_account_number"))) {
			sql.append(" and t.account_number = :account_number");
			mapSQLParameter.put("account_number", mapStr.get("find_account_number"));
		}
		
		if (!"true".equals(mapStr.get("findAll"))) {
			sql.append(" and t.account_id !=0 and t.other_id!=0");
		}
		if (UtilValiDate.isEmpty(mapStr.get("account_id"))) {
			sql.append(" and t.account_id=:account_id ");
			mapSQLParameter.put("account_id", mapStr.get("account_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("account_number"))) {
				sql.append(" and t.account_number like :account_number");
				mapSQLParameter.put("account_number", "%" + mapStr.get("account_number") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("account_name"))) {
				sql.append(" and t.account_name like :account_name");
				mapSQLParameter.put("account_name", "%" + mapStr.get("account_name") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("zTai"))) {
				sql.append(" and t.zt like :zt");
				mapSQLParameter.put("zt", "%" + mapStr.get("zTai") + "%");
			}
		}
	}

	/**
	 *获取账户信息列表
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
	 *获取一条账户信息
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
		if(this.find_Account_numberMap(mapStr)){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("is_Satisfy", "1");
			return map;
		}
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into system_account");
		sql.append("( account_number,hospital_id,account_pwd,account_type,account_name,functions_id,other_id");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :account_number,:hospital_id,:account_pwd,:account_type,:account_name,:functions_id,:other_id");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("account_number", mapStr.get("account_number"));
		mapSQLParameter.put("account_pwd", MD5.EncoderByMd5(mapStr.get("account_pwd")));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		mapSQLParameter.put("account_name", mapStr.get("account_name"));
		mapSQLParameter.put("account_type", mapStr.get("login_account_type"));
		mapSQLParameter.put("functions_id", mapStr.get("functions_id"));
		mapSQLParameter.put("other_id",mapStr.get("login_id"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("account_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改账户操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		if(this.find_Account_numberMap(mapStr)){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("is_Satisfy", "1");
			return map;
		}
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update system_account set gxsj=:gxsj");
		if(null!=mapStr.get("account_pwd")){
			sql.append(",account_pwd=:account_pwd");
			mapSQLParameter.put("account_pwd", MD5.EncoderByMd5(mapStr.get("account_pwd")));
		}
		if(null!=mapStr.get("account_name")){
			sql.append(",account_name=:account_name");
			mapSQLParameter.put("account_name", mapStr.get("account_name"));
		}
		if(null!=mapStr.get("functions_id")){
			sql.append(",functions_id=:functions_id");
			mapSQLParameter.put("functions_id", mapStr.get("functions_id"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where account_id=:account_id");
		mapSQLParameter.put("account_id", mapStr.get("account_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		Map<String, Object> find_Map = this.find_Map(mapStr);
		//修改对应参数
		if("1".equals(find_Map.get("account_type")+"")&& "0".equals(find_Map.get("other_id")+"")){
			sql.delete(0, sql.length());
			sql.append("update util_hospital set gxsj=:gxsj ,hospital_pwd=:hospital_pwd where hospital_id=:hospital_id");
			mapSQLParameter.put("hospital_id", find_Map.get("hospital_id"));
			mapSQLParameter.put("hospital_pwd", find_Map.get("account_pwd"));
			this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		}else if("2".equals(find_Map.get("account_type")+"")){
			sql.delete(0, sql.length());
			sql.append("update pharmacist_info set gxsj=:gxsj ,pharmacist_paw=:pharmacist_paw where hospital_id=:hospital_id and pharmacist_id=:other_id");
			mapSQLParameter.put("hospital_id", find_Map.get("hospital_id"));
			mapSQLParameter.put("pharmacist_paw", find_Map.get("account_pwd"));
			this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		}
		
		
		return find_Map;
	}
	/**
	 *删除账户操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from system_account where account_id=:account_id");
		mapSQLParameter.put("account_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}
	/**
	 * 获取功能分类
	 */
	public Map<String, Object> findAllfunctionData(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取地址权限
		sql.append("select t.functions_id,t.class_id,t.functions_name,t.zt from system_functions t where t.zt=:login_account_type");
		mapSQLParameter.put("login_account_type", mapStr.get("login_account_type"));
		List<Map<String, Object>> functionsList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		//获取账户拥有的权限
		sql.delete(0, sql.length());
		sql.append("select t.join_id,t.functions_id,t.account_id,s.functions_id as zhu_id from system_join t,system_account s where t.account_id=s.account_id and t.account_id=:account_id ");
		mapSQLParameter.put("account_id", mapStr.get("account_id"));
		List<Map<String, Object>> joinList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		
		List<String> forList = new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		for (Map<String, Object> map : functionsList) {
			if(sb.indexOf(map.get("class_id").toString())==-1){
				sb.append(",'"+map.get("class_id")+"'");
				forList.add(map.get("class_id").toString());
			}
			if(joinList.size()>0&&(joinList.get(0).get("zhu_id")+"").equals(map.get("functions_id")+"")){
				map.put("is_zhu", "1");
			}
			//获取账户拥有的权限
			for (Map<String, Object> fmap : joinList) {
				if((map.get("functions_id")+"").equals(fmap.get("functions_id")+"")){
					map.put("is_sel", "1");
				}
			}
		}
		sql.delete(0, sql.length());
		sql.append("select t.class_id,t.class_name,t.class_up_id from system_class t ");
		List<Map<String, Object>> list = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (String ids : forList) {
			Map<String, Object>map=new HashMap<String, Object>();
			StringBuffer str=new StringBuffer();
			getdata(list,ids,str);
			String [] strs=str.toString().substring(1).split(",");
			str.delete(0, str.length());
			for (int i = strs.length; i >0 ; i--) {
				if(UtilValiDate.isEmpty(str)){
					str.append(" >>> "+strs[i-1]);
				}else{
					str.append(strs[i-1]);
				}
				
			}
			map.put("id", ids);
			map.put("name", str);
			dataList.add(map);
		}
		//获取地址权限
		for (Map<String, Object> map1 : dataList){
			List<Map<String, Object>> addrList = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> map2 : functionsList) {
				if((map1.get("id")+"").equals(map2.get("class_id")+"")){
					addrList.add(map2);
				}
			}
			if(addrList.size()>0){
				map1.put("data", addrList);
			}
		}
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("functionslist", dataList);
		return map;
	}
	/**
	 * 拼接分类目录
	 * @param list  除一级目录
	 * @param dataList 保存的目录
	 */
	private void getdata(List<Map<String, Object>> list,String id,StringBuffer str){
		for (Map<String, Object> map : list) {
			if((map.get("class_id")+"").equals(id)){
				str.append(","+map.get("class_name"));
				getdata(list,map.get("class_up_id")+"",str);
			}
		}
	}
	

	/**
	 *修改账户权限
	 */
	public Map<String, Object> updateFunctionData(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//删除以前的数据
		sql.append("delete from  system_join  where account_id=:account_id");
		mapSQLParameter.put("account_id", mapStr.get("account_id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		List<Map<String, Object>> strToList = UtilJson.strToList(mapStr.get("functionsDatas"));
		if(UtilValiDate.isEmpty(strToList)&&strToList.size()>0){
			sql.delete(0, sql.length());
			//新增数据
			sql.append("insert into system_join");
			sql.append("( functions_id,account_id");
			sql.append(UtilSql.getFieldInsertKey());
			sql.append("values(:functions_id,:account_id");
			sql.append(UtilSql.getFieldInsertVal());
			for (Map<String, Object> map : strToList) {
				mapSQLParameter.put("functions_id", map.get("functions_id"));
				mapSQLParameter.put("account_id", map.get("account_id"));
				UtilSql.setMapVal(mapSQLParameter, mapStr);
				mapSQLParameter.put("zt", "2");
				this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
			}
		}
		//修改默认主页
		mapStr.put("functions_id", mapStr.get("zhuPage"));
		if(null==mapStr.get("zhuPage")){
			mapStr.put("functions_id", "");
		}
		return this.update_Data(mapStr);
	}
	
	/**
	 *验证旧密码是否正确
	 */
	public boolean pwdIsTrue(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.account_id from system_account t where t.account_id=:account_id and t.account_pwd=:account_pwd");
		mapSQLParameter.put("account_id", mapStr.get("account_id"));
		mapSQLParameter.put("account_pwd", MD5.EncoderByMd5(mapStr.get("account_pwd")));
		return this.gyDAOimp.findSqlBool(sql, mapSQLParameter);
	}
	
	/**
	 *获取验证账号是否存在
	 */
	public boolean find_Account_numberMap(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.account_id,t.account_number,t.account_pwd,t.account_name,t.functions_id,t.other_id,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(",sys.functions_name ");
		sql.append(" from system_account t left join system_functions sys  on sys.functions_id=t.functions_id where 1=1  ");
		sql.append(" and t.account_number like :account_number");
		mapSQLParameter.put("account_number", "%" + mapStr.get("account_number") + "%");
		return this.gyDAOimp.findSqlBool(sql, mapSQLParameter);
	}
}