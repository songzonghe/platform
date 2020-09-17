package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @sm 得到一个DAO 2016年3月8日 17:56:08
 * @author 李飞
 * 
 */
public class UtilDAO<T> {
	// 创建一个ApplicationContext 对象 用于创建spring对象
	private static ApplicationContext ctx = null;
	private static boolean fal = true;

	/**
	 * 由于这里是工具类 里面全是static (静态方法 ) 这里就不能去创建实体
	 */
	private UtilDAO() {
	}

	/**
	 * @sm 从spring中得到一个gydao对象 来操作数据库 注：在定时器中由于不使用action调用 这里就得直接加载spring
	 *     来创建spring JDBC来操作数据库
	 * @return GYDAO
	 */
	public static Object getGydaOimp(String beanName) {
		if (fal) {
			ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext_*.xml");
		}
		fal = false;
		return (Object) ctx.getBean(beanName);
	}
}
