package com.dao.mysql;

import java.util.List;
import java.util.Map;

import com.dao.interfaceDAO.GYDAOImp;
import com.util.SysFinal;
import com.util.UtilExcel;
import com.util.UtilSql;
import com.util.UtilStr;

/**
 * mysql 数据库操作DAO类 并实现了GYDAO接口 里面包括 查询 分页 修改
 * 
 * @author 李飞 2015年6月22日17:07:28
 */
public class GYDAOimp_Mysql extends GYDAOImp {

	/**
	 * 分页查询 返回值List<Map<String, Object>>
	 * 
	 * @author 李飞
	 * @param sql  sql语句
	 * @param mapSQLParameter  传入查询时所有参数
	 * @param mapUtilStr  公用操作map 参数
	 * @return List<Map<String, String>>
	 * @throws Exception
	 */
	public List<Map<String, Object>> findSqlPageList(StringBuffer sql,Map<String, Object> mapSQLParameter,Map<String,String> mapUtilStr)
			throws Exception {
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append("select t.* from (");
		sqlBuf.append(sql);
		sqlBuf.append(") t ");
		sqlBuf.append(UtilSql.getPaiXuSQL(mapUtilStr));
		sqlBuf.append(" limit :pageIndex,:pagelast");
		//每页显示多少条
		SysFinal.PAGENUM_VAL = UtilStr.getInt(mapUtilStr.get(SysFinal.PAGENUMSELECT_KEY));
		if(SysFinal.PAGENUM_VAL==0){
			SysFinal.PAGENUM_VAL = 10;
		}
		mapSQLParameter.put("pagelast", SysFinal.PAGENUM_VAL);
		// 从那里开始
		int pageNum = UtilStr.getInt(mapUtilStr.get(SysFinal.PAGENUM_KEY))*SysFinal.PAGENUM_VAL;
		mapSQLParameter.put("pageIndex", pageNum);
		// 得到当前sql查询出所有的记录
		List<Map<String, Object>> list_mapAll = this.findSqlList(sqlBuf,
				mapSQLParameter);
		return list_mapAll;
	}


	/**
	 * 分页查询 导出 excel 
	 * @param sql sql语句
	 * @param mapSQLParameter  传入查询时所有参数
	 * @param mapUtilStr 公用操作map 参数
	 * @param list_title 现实title 标题
	 * @param index 开始序号 默认以开始传入0
	 * @param filePath 当前文件夹的路径
	 * @return String
	 * @throws Exception
	 */
	public String expExcel(StringBuffer sql,Map<String, Object> mapSQLParameter,Map<String,String> mapUtilStr,List<String> list_title,int index,String filePath)
			throws Exception {
		List<Map<String, Object>> listMap = this.findSqlList(sql, mapSQLParameter);
		UtilExcel.writeExcle(list_title, listMap, index, filePath);
		return filePath;
	}

}
