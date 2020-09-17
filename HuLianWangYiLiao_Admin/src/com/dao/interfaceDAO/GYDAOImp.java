package com.dao.interfaceDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.util.SysFinal;
import com.util.UtilStr;
import org.apache.log4j.Logger;

	
/**
 * oracle 数据库操作DAO抽象类 将一些共性操作抽出实现
 * 
 * @author 李飞 2015年7月1日0:11:02
 */
public abstract class GYDAOImp extends NamedParameterJdbcDaoSupport implements GYDAO {
	@Resource
	public DriverManagerDataSource dataSource;

	/**
	 *是否查询到记录 返回值 boolean 返回值 true 表示查询到 false 没有查询到数据
	 * 
	 * @author 李飞
	 * 
	 * @param sql
	 *            sql语句
	 * @param mapSQLParameter
	 *            传入查询时所有参数
	 * @return boolean
	 * @throws Exception
	 */
	public boolean findSqlBool(StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		return super.getNamedParameterJdbcTemplate().queryForList(UtilStr.getStr(sql), mapSQLParameter).size() > 0 ? true
				: false;
	}

	/**
	 * @author 李飞 根据条件得到所有指定记录 返回值 List<Map<String, Object>>
	 * @param sql
	 *            sql语句
	 * @param mapSQLParameter
	 *            传入查询时所有参数
	 * @return List<Map<String, String>>
	 * @throws Exception
	 */
	public List<Map<String, Object>> findSqlList(StringBuffer sql,
			Map<String, Object> mapSQLParameter) throws Exception {
		return super.getNamedParameterJdbcTemplate().queryForList(
				UtilStr.getStr(sql), mapSQLParameter);
	}



	/**
	 * 根据条件得到一条记录 返回值 Map<String, Object>
	 * 
	 * @author 李飞
	 * @param sql
	 *            sql语句
	 * @param mapSQLParameter
	 *            传入查询时所有参数
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object> findSqlMap(StringBuffer sql,
			Map<String, Object> mapSQLParameter) throws Exception {
		List<Map<String, Object>> list_map = this.getNamedParameterJdbcTemplate()
				.queryForList(UtilStr.getStr(sql), mapSQLParameter);
		if (list_map.size() < 1) {
			return new HashMap<String, Object>();
		}
		return list_map.get(0);
	}

	/**
	 * 数据修改操作 当前操作成功数据 返回true 否则false 返回值 boolean
	 * 
	 * @author 李飞
	 * @param mapSQLParameter
	 *            传入查询时所有参数
	 * @param pss
	 *            传入一个PreparedStatement类参数
	 * @return boolean
	 * @throws Exception
	 */
	public boolean exeSqlBool(StringBuffer sql,
			Map<String, Object> mapSQLParameter) throws Exception {
		//String strSql=UtilStr.getStr(sql);
		//    if(strSql.contains("zt=1"))
		//   	System.out.print(strSql);
		return this.getNamedParameterJdbcTemplate().update(UtilStr.getStr(sql),
				mapSQLParameter) > 0 ? true : false;
	}
	/**
	 * 数据新增时获取自增长主键id
	 */
	public String exeSqlGetId(StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		KeyHolder keyHolder=new GeneratedKeyHolder();
		SqlParameterSource paramSource = new MapSqlParameterSource(mapSQLParameter);
		this.getNamedParameterJdbcTemplate().update(UtilStr.getStr(sql), paramSource, keyHolder);
		return keyHolder.getKey().intValue()+"";
	}

	/**
	 * 根据条统计查到的总数 返回值 long
	 * 
	 * @author 李飞
	 * @param sql
	 *            sql语句
	 * @param mapSQLParameter
	 *            传入查询时所有参数
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public Map<String, Object> findSqlCount(StringBuffer sql,
			Map<String, Object> mapSQLParameter) throws Exception {
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append("select ");
		sqlBuf.append(" count(*)  ");
		sqlBuf.append(SysFinal.TJ);
		sqlBuf.append(" from (");
		sqlBuf.append(sql);
		sqlBuf.append(") tj");
		return this.getNamedParameterJdbcTemplate().queryForList(UtilStr.getStr(sqlBuf), mapSQLParameter).get(0);
	}
}
