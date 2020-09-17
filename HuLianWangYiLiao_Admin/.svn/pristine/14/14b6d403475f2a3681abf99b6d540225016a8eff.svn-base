package com.util;

 import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * Jedis 工具类 2016年2月26日 15:06:33
 * 
 * @author 李飞
 * 
 */
public class MemCachedUtil {
	// 定义日志方法
	private static Logger logger = Logger.getLogger(MemCachedUtil.class);
	/**
	 * server=127.0.0.1:11211 
	 * conn_init=100　　　　　　　　初始化空间大小kb
	 * conn_minspare=100　　　　　　最小分配空间kb 
	 * conn_maxspare=1000　　　　　　cache空间kb
	 * conn_maxideltime=1800000　　 最大处理时间
	 * conn_maxbusytime=300000　　最长连接数量
	 * conn_timeout=1000　　　　　　连接最长时限
	 */
	private final static MemCachedClient client = new MemCachedClient();
	private static String _memcache_config = "/memcached.properties";

	/**
	 * 得到一个MemCachedClient实例
	 * @return MemCachedClient
	 */
	static {
		try {
			logger.info("初始化MemCached开始...");
			Properties config = new Properties();
			InputStream in = MemCachedUtil.class.getResourceAsStream(_memcache_config);
			config.load(in);
			String serverGroup = config.getProperty("server");
			String[] servers = serverGroup.split(";");
			SockIOPool pool = SockIOPool.getInstance();
			int init_conns = Integer.valueOf(config.getProperty("conn_init"));
			int min_spare = Integer.valueOf(config.getProperty("conn_minspare"));
			int max_spare = Integer.valueOf(config.getProperty("conn_maxspare"));
			long idel_time = Long.valueOf(config.getProperty("conn_maxideltime"));
			long busy_time = Long.valueOf(config.getProperty("conn_maxbusytime"));
			int timeout = Integer.valueOf(config.getProperty("conn_timeout"));
			pool.setServers(servers);
			pool.setInitConn(init_conns);
			pool.setMinConn(min_spare);
			pool.setMaxConn(max_spare);
			pool.setMaxIdle(idel_time);
			pool.setMaxBusyTime(busy_time);
			pool.setSocketTO(timeout);
			pool.setFailover(true);
			pool.initialize();
			logger.info("初始化MemCached完成...");
		} catch (Exception e) {
			logger.error("初始化MemCached错误...");
			e.printStackTrace();
		}
	}
	
	/**
	 * 加入一个key
	 * @param key key
	 * @param value value
	 * @param timeOut 过时时间  时间为毫秒   -1为永不过期
	 */
	public static void setKey(String key,Object value,long timeOut) {
		if(UtilValiDate.isEmpty(value) && UtilValiDate.isEmpty(key)){
			client.set(key, value,new Date(timeOut));
		}
	}

	/**
	 * 得到一个key
	 * @param key
	 * @return String
	 */
	public static Object getKey(String key) {
		if(!UtilValiDate.isEmpty(key)){
			return "";
		}
		return client.get(key);
	}
	/**
	 * 删除一个key
	 * @param key
	 */
	public static void delKey(String key) {
		if(UtilValiDate.isEmpty(MemCachedUtil.getKey(key))){
			client.delete(key);
		}
	}
	
}
