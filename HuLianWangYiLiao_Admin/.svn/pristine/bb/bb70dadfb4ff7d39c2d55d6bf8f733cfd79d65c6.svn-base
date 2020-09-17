package com.controllerAdmin;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;

import com.util.SysFinal;
import com.util.UtilJson;
import com.util.UtilStr;
import com.util.UtilValiDate;

/**
 * Action 工具类，处理 公用分页 （使用request存储）处理错误信息
 * 
 * @author 李飞
 * 
 */
public  class  ControllerUtil{
	// 定义日志方法
	protected Logger logger = Logger.getLogger(ControllerUtil.class);
	/**
	 * 系统返回指定页面
	 * @param page 返回页面参数
	 * @return String
	 */
	protected String returnPage(String page,HttpServletRequest req,HttpServletResponse resp) {
		try {
			this.setResp_UTF_8(resp);
			return page;
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 * 将得到的分页数据进行request 处理
	 * @param list_map
	 * @param tbodyPage 返回页面参数
	 * @param mapStr
	 * @return String
	 */
	protected String tBodyUtil(List<Map<String, Object>> list_map,Map<String,String> mapStr,String tbodyPage,HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setAttribute("map", mapStr);
			this.pageReq(list_map,mapStr,req);
			return tbodyPage;
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 * 添加 数据之后跳转到指定页面
	 * @param mapStr Map<String,Object>
	 * @param publicZiDuanBean 
	 * @param updatePage 返回页面参数
	 * @return String
	 */
	protected String updateDataAdd(Map<String,String> mapStr ,String updatePage,HttpServletRequest req,HttpServletResponse resp) {
		try {
			//保存当前字段Bean
			req.setAttribute("map", mapStr);
			return updatePage;
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 * 修改 数据之后跳转到指定页面
	 * @param mapStr Map<String,Object>
	 * @param publicZiDuanBean 
	 * @param updatePage 返回页面参数
	 * @return String
	 */
	protected String updateDataUpdate(Map<String,Object> mapStr ,String updatePage,HttpServletRequest req,HttpServletResponse resp) {
		try {
			//保存当前字段Bean
			req.setAttribute("map", mapStr);
			req.setAttribute("info", mapStr);
			return updatePage;
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 * 跳转到编辑页面
	 * @param editPage 编辑也参数
	 * @param mapObj
	 * @return String
	 */
	protected String editPageUtil(Map<String, Object> mapObj,String editPage,HttpServletRequest req,HttpServletResponse resp) {
		try {
			this.setMap(req, mapObj);
			return editPage;
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 * 返回error信息提示页面
	 * @return String
	 */
	protected String returnError() {
		return "form_util/page/error.jsp";
	}
	
	/**
	 * 方法执行完毕  进行回执
	 * @param objInfo
	 */
	protected void respBack(Object objInfo,HttpServletResponse resp){
		PrintWriter out = null;
		try {
			this.setResp_UTF_8(resp);
			out = resp.getWriter();
			out.print(objInfo);
		} catch (Exception ioe) {
			logger.error(ioe.getMessage());
		} finally {
			try {
				out.close();
			} catch (Exception closeE) {
				logger.info(closeE.getMessage());
			}
		}
	}
	
	/**
	 * 查询一条数据
	 * 
	 * @param findById
	 * @param mapObj
	 * @return String
	 */
	protected String findByIdUtil(Map<String, Object> mapObj,String findById,HttpServletRequest req,HttpServletResponse resp) {
		try {
			this.setMap(req, mapObj);
			return findById;
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 * 分页公用使用request保存 存储数据有：统计(tj) 数据(listMap) 当前页码(page) 当前显示条数(pageNum)
	 * @param list_map
	 * @param mapStr
	 * @throws Exception
	 */
	protected void pageReq(List<Map<String, Object>> list_map,Map<String,String> mapStr,HttpServletRequest req)throws Exception {
		Object objTJ = list_map.get(list_map.size() - 1).get(SysFinal.TJ);
		if(UtilValiDate.isEmpty(objTJ)){
			// 保存统计出来总条数
			req.setAttribute("tj", list_map.get(list_map.size() - 1).get(SysFinal.TJ));
		}else{
			// 保存统计出来总条数
			req.setAttribute("tj", "0");
		}
		// 将List集合中tj map数据移除
		list_map.remove(list_map.size() - 1);
		// 保存查询出来map数据
		req.setAttribute("listMap", list_map);
		// 保存当前页数
		if(!UtilValiDate.isEmpty(mapStr.get(SysFinal.PAGENUM_KEY))){
			req.setAttribute("pageNum","0");
		}else{
			req.setAttribute("pageNum", mapStr.get(SysFinal.PAGENUM_KEY));
		}
		// 保存当前每页显示条数
		req.setAttribute("pageNumSelects", mapStr.get(SysFinal.PAGENUMSELECT_KEY));
	}

	/**
	 * 将查询出来的一个map存放在request中
	 * @param req
	 * @param mapObj
	 * @throws Exception
	 */
	protected void setMap(HttpServletRequest req, Map<String, Object> mapObj)
			throws Exception {
		// 将mapObj存放在request对象中
		req.setAttribute("map", mapObj);
	}

	/**
	 * 实现统一错误信息回传
	 * @param e 当前的exception对象
	 */
	protected void errorResp(Exception e,HttpServletResponse resp) {
		PrintWriter out = null;
		try {
			this.setResp_UTF_8(resp);
			out = resp.getWriter();
			out.print(UtilStr.return_error());// 程序出错
			// 在控制台输入错误信息
			e.printStackTrace();
			logger.error("执行错误消息:"+e.getMessage());
		} catch (Exception ioe) {
			logger.error("输出流错误消息:"+ioe);
		} finally {
			try {
				out.close();
			} catch (Exception closeE) {
				logger.error(closeE);
			}
		}
	}

	/**
	 * 设置response对象返回为utf-8 格式
	 *@throws Exception
	 */
	protected void setResp_UTF_8(HttpServletResponse resp) throws Exception {
		// 这句话的意思，是让浏览器用utf8来解析返回的数据
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		// 这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
		resp.setCharacterEncoding("UTF-8");
	}
	/**
	* 文件下载
	* @param resp
	*/
	public void downloadUtil(HttpServletRequest req,HttpServletResponse resp,String fileName){
		try {
			File file =  new File(fileName);
			logger.error("正在下载文件:"+file);
			String fileDownloadName="";
			//文件名编码，解决中文乱码问题  
	        String userAgent = req.getHeader("User-Agent").toLowerCase();  
	        if(userAgent.contains("msie")|| userAgent.contains("trident")){//IE浏览器  
	            fileDownloadName = URLEncoder.encode(file.getName(), "UTF-8");  
	        }else{//其它浏览器  
	            fileDownloadName = new String(file.getName().getBytes("UTF-8"), "ISO-8859-1");  
	        }
			String mimeType= URLConnection.guessContentTypeFromName(file.getName());
	        resp.setContentType(mimeType);
	        resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + fileDownloadName +"\""));
	        resp.setContentLength((int)file.length());
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
	        FileCopyUtils.copy(inputStream, resp.getOutputStream());
	        logger.error("下载文件完成!!");
	        //下载完毕删除文件
	        if(file.exists()) {
	        	file.delete();
	        }
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
	
	/**
	 * 得到当前登录的seesion用户数据
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected Map<String,String> getMapStr(HttpServletRequest req) throws Exception {
		Map<String, String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
		Map<String, Object> feiMaChuXingLoginInfo = (Map<String, Object>) req.getSession().getAttribute("feiMaChuXingLoginInfo");
		if(null!=feiMaChuXingLoginInfo){
			mapStr.put("login_id", feiMaChuXingLoginInfo.get("account_id")+"");
			mapStr.put("lrzh", feiMaChuXingLoginInfo.get("account_number")+"");
			mapStr.put("login_account_type", feiMaChuXingLoginInfo.get("account_type")+"");
			mapStr.put("login_name", feiMaChuXingLoginInfo.get("account_name")+"");
			mapStr.put("other_id", feiMaChuXingLoginInfo.get("other_id")+"");
			mapStr.put("login_hospital_id",feiMaChuXingLoginInfo.get("hospital_id")+"");
		}
		return mapStr;
	}
	
	/**
	* 文件下载
	* @param resp
	*/
	public void downloadUtil(HttpServletResponse resp,String fileName){
		try {
			File file =  new File(fileName);
			logger.error("正在下载文件:"+file);
			String mimeType= URLConnection.guessContentTypeFromName(file.getName());
	        resp.setContentType(mimeType);
	        resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
	        resp.setContentLength((int)file.length());
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
	        FileCopyUtils.copy(inputStream, resp.getOutputStream());
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
	}
}
