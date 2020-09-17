package com.custom.init;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.controllerAdmin.ControllerUtil;
import com.util.SysFinal;
import com.util.UtilOther;

/**
 * 专门用于系统初始化类 2015年10月23日 13:56:50
 * 
 * @author 李飞
 * 
 */
public class ServletInit extends HttpServlet {
	private static final long serialVersionUID = -750294615921720603L;
	// 定义日志方法
	private Logger logger = Logger.getLogger(ControllerUtil.class);
	
	/**
	 * 系统启动是运行
	 */
	public void init(ServletConfig config) throws ServletException {
		//获得当前运行目录
		SysFinal.file = config.getServletContext().getRealPath("/")+"/";
		//创建日志文件目录
		UtilOther.createFiles("C:/logs/mylog.log");
		//创建temp操作文件目录
		UtilOther.createFile(config.getServletContext().getRealPath("/")+"/"+SysFinal.tempFile);
		
	}
	
	/**
	 * 系统销毁是运行
	 */
	public void destroy() {
	
	}
	
	
}
