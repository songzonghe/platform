package com.servicesAdmin.util.carousel;
import java.util.List;
import java.util.Map;
/**
 * 轮播图 service 接口
 * 操作人： 张龙
 */ 
public interface UtilCarouselService {

/************************系统生成方法开始******************************/

	/**
	 *获取轮播图信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception;

	/**
	 *获取一条轮播图信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception;

	/**
	 *进行轮播图信息新增
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行轮播图信息修改
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception;

	/**
	 *进行轮播图信息删除
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception;
	
 }

/************************系统生成方法完毕******************************/