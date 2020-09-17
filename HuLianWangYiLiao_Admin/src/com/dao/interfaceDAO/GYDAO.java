package com.dao.interfaceDAO;

import java.util.List;
import java.util.Map;

/**
 * oracle 数据库操作DAO接口 里面包括 查询 分页 修改
 */
public interface GYDAO {

	/**
	 *是否查询到记录 返回值 boolean 返回值 true 表示查询到 false 没有查询到数据
	 */
	public boolean findSqlBool(StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception;

	/**
	 *根据条件得到所有指定记录 返回值 List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findSqlList(StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception;

	/**
	 * 根据条件得到一条记录 返回值 Map<String, Object>
	 */
	public Map<String, Object> findSqlMap(StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception;

	/**
	 * 分页查询 返回值List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findSqlPageList(StringBuffer sql,Map<String, Object> mapSQLParameter, Map<String, String> mapUtilStr)throws Exception;

	/**
	 * 数据修改操作 当前操作成功数据 返回true 否则false 返回值 boolean
	 */
	public boolean exeSqlBool(StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception;

	/**
	 * 数据新增时获取自增长主键id
	 */
	public String exeSqlGetId(StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception;
	/**
	 * 根据条统计查到的总数 返回值 long
	 */
	public Map<String, Object> findSqlCount(StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception;
	/**
	 * 分页查询 导出 excel 
	 */
	public String expExcel(StringBuffer sql,Map<String, Object> mapSQLParameter,Map<String,String> mapUtilStr,List<String> list_title,int index,String filePath)throws Exception;
}
