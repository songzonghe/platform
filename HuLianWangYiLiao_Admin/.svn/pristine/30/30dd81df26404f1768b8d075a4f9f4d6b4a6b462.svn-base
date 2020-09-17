package com.servicesAdmin.util.doctor.title;
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
 * 医生职称字典 service 实现类
 * 操作人： 张龙
 */ 
@Service("utilDoctorTitleServiceImp")
public class UtilDoctorTitleServiceImp implements UtilDoctorTitleService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取医生职称字典查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.title_id,t.title_name,t.title_sort,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(" from util_doctor_title t where 1=1");
		if (UtilValiDate.isEmpty(mapStr.get("title_id"))) {
			sql.append(" and t.title_id=:title_id ");
			mapSQLParameter.put("title_id", mapStr.get("title_id"));
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("title_name"))) {
				sql.append(" and t.title_name like :title_name");
				mapSQLParameter.put("title_name", "%" + mapStr.get("title_name") + "%");
			}
		}
	}

	/**
	 *获取医生职称字典信息列表
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
	 *获取一条医生职称字典信息
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
		sql.append("insert into util_doctor_title");
		sql.append("( title_name,title_sort");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :title_name,:title_sort");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("title_name", mapStr.get("title_name"));
		mapSQLParameter.put("title_sort", mapStr.get("title_sort"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("title_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改医生职称字典操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_doctor_title set gxsj=:gxsj");
		if(null!=mapStr.get("title_name")){
			sql.append(",title_name=:title_name");
			mapSQLParameter.put("title_name", mapStr.get("title_name"));
		}
		if(null!=mapStr.get("title_sort")){
			sql.append(",title_sort=:title_sort");
			mapSQLParameter.put("title_sort", mapStr.get("title_sort"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where title_id=:title_id");
		mapSQLParameter.put("title_id", mapStr.get("title_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除医生职称字典操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_doctor_title where title_id=:title_id");
		mapSQLParameter.put("title_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}
	
	
	

	/************************系统生成方法完毕******************************/
	
	
	public List<Map<String, Object>> doctorTitleList(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); 
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("select t.*  from util_doctor_title t where 1=1 order by  title_sort ");
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		return list_Map;
	}
	
	
}