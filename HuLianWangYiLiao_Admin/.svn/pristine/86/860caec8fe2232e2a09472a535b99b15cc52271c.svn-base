package com.util;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @sm 处理一些常规操作的类
 * @author 李飞
 */
public class UtilStr {
	// 定义日志方法
	private static Logger logger = Logger.getLogger(UtilStr.class);

	/**
	 * @sm 从头向后截取
	 * @param str
	 *            需要操作的字符串
	 * @param indexStr
	 *            从0开始截取 到传来的参数那里结束
	 * @return String
	 * @throws Exception
	 */
	public static String strIndex(String str, String indexStr) throws Exception {
		return str.substring(0, indexStr.length());
	}

	/**
	 * 从头向后截取
	 * 
	 * @param str
	 *            需要操作的字符串
	 * @param 从indexStr开始到本字符串最后
	 * @return String
	 * @throws Exception
	 */
	public static String strindexStr(String str, String indexStr)
			throws Exception {
		return str.substring(str.indexOf(indexStr), str.length());
	}

	/**
	 * 给入一个Object 返回一个字符串
	 * 
	 * @param obj
	 * @return String
	 */
	public static String getStr(Object obj) {
		if (null == obj || "null".equals(obj))
			return "";
		else
			return obj.toString().trim();
	}

	/**
	 * 给入一个Object 返回一个float
	 * 
	 * @param obj
	 * @return String
	 */
	public static float getStrToFloat(Object obj) {
		try {
			if (null == obj || "null".equals(obj) || "".equals(obj))
				return 0.00f;
			else
				return Float.parseFloat(obj.toString().trim().replace(",", ""));
		} catch (Exception e) {
			return 0f;
		}
	}
	
	
	/**
	 * 给入一个Object 返回一个int
	 * 
	 * @param obj  int 或    double  类型
	 * @return String
	 */
	public static int getInt(Object obj) {
		try {
			if (null == obj || "null".equals(obj) || "".equals(obj)){
				return 0;
			}else{
				String str=obj+"";
				int num=0;
				if(str.indexOf(".")!=-1){
					 num=Integer.parseInt(str.substring(0,str.indexOf(".")));
				}else{
					num=Integer.parseInt(str);
				}
				return num;
			}
		} catch (Exception e) {
			System.out.println("数字转换错误，传入类型不正确！！");
			return 0;
		}
	}
	
	/**
	 * 给入一个Object 返回一个int
	 * 
	 * @param obj  int 或    double  类型
	 * @param type  存在就是  四舍五入
	 * @return String
	 */
	public static int getInt(Object obj,String type) {
		try {
			if (null == obj || "null".equals(obj) || "".equals(obj)){
				return 0;
			}else{
				String str=obj+"";
				int num=0;
				if(str.indexOf(".")!=-1){
					num=Integer.parseInt(str.substring(0,str.indexOf(".")));
				}else{
					num=Integer.parseInt(str);
				}
				if(str.indexOf(".")!=-1 && Integer.parseInt(str.substring(str.indexOf("."),str.indexOf(".")+1))>4){
					return num+1;
				}
				return num;
			}
		} catch (Exception e) {
			System.out.println("数字转换错误，传入类型不正确！！");
			return 0;
		}
	}
	
	
	
	/**
	 * @sm utf-8转码
	 * @param code
	 * @return String
	 */
	public static String codeUTF_8(String code) {
		try {
			if(UtilValiDate.isEmpty(code)){
				code = java.net.URLDecoder.decode(code, "UTF-8").trim();
			}else{
				return "";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}

	/**
	 * @sm utf-8转码
	 * @param code
	 * @return String
	 */
	public static String iso_8859_1ToUtf_8(String code) {
		try {
			if(UtilValiDate.isEmpty(code)){
				code = new String(code.getBytes("ISO-8859-1"),"utf-8");
			}else{
				return "";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}
	
	/**
	 * @sm 解析字符串 如(1-2-3-4) 变成一个list集合
	 * @author 李飞
	 * @param str
	 *            需要进行分割的字符串
	 * @param fgf
	 *            分隔符
	 * @return List<String>
	 */
	public static List<String> getStringToList(String str, String fgf)
			throws Exception {
		List<String> listString = new ArrayList<String>();
		if (!UtilValiDate.isEmpty(str)) {
			return listString;
		}
		if(str.indexOf(fgf)==-1){
			listString.add(str);
			return listString;
		}
		StringTokenizer st = new StringTokenizer(str, fgf);
		while (st.hasMoreTokens()) {
			String nt = st.nextToken();
			listString.add(nt);
		}
		return listString;
	}

	/**
	 * 得到两个数的百分比  精确两位小数点
	 * @param divisor 除数
	 * @param dividend 被除数
	 * @return str
	 */
	public static String getPerDouble(double divisor,double dividend) {
		if(!UtilValiDate.isEmpty(dividend) || dividend==0){
			dividend = 1.0 ;
		}
		if(!UtilValiDate.isEmpty(divisor)){
			divisor = 0.0 ;
		}
		String tempStr = (divisor*100/dividend)+"00000";
		return tempStr.substring(0,tempStr.indexOf(".")+3)+"%";
	}

	/**
	 * 将一个对象强制转换成double
	 * @param str
	 * @return double
	 */
	public static double getAsDouble(Object obj) {
		try {
			if (!UtilValiDate.isEmpty(obj)) {
				return 0d;
			}
			return Double.parseDouble(getStr(obj));
		} catch (Exception e) {
			return 0d;
		}
	}
	
	
	

	/**
	 * 得到一串随机数
	 * @return String
	 */
	public static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}
	/**
	 * 得到一个时间戳
	 * @return String
	 */
	public static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
	
	/**
	 * 得到一串sha1加密数据
	 * @param hash 字节
	 * @return String
	 */
	public static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
	
	
	/**
	 * 获得一个两位小数
	 * @param str
	 * @return String
	 */
	public static String getNumberDot2(Object obj) {
		try {
			if (!UtilValiDate.isEmpty(obj)) {
				return "0.00";
			}
			String str = getStr(obj);
			if(str.indexOf(".")==-1){
				return obj+".00";
			}else{
				int length = str.substring(str.indexOf(".")+1).length();
				if(length>2){
					return str.substring(0,str.indexOf(".")+3);
				}else if(length<2){
					return str+"0";
				}else{
					return str;
				}
			}
		} catch (Exception e) {
			logger.error("获得一个两位小数错误"+e.getMessage());
			return "0.00";
		}
	}
	
	/**
	 * 截取小数点
	 * @param num 需要截取的数字
	 * @param length 需要截取的长度
	 * @return String
	 */
	public static String getStrSub(Object num,int length){
		if(UtilValiDate.isEmpty(num)){
			String numTemp = UtilStr.getStr(num);
			if(numTemp.indexOf(".")!=-1){
				numTemp = numTemp+"00000";
				return numTemp.substring(0,numTemp.indexOf(".")+length+1);
			}else{
				return numTemp+".00";
			}
		}
		return "";
	}

	/**
	 * 返回成功消息  
	 * @param info 返回消息
	 * @param mapObj 返回数据
	 * @return String
	 * @throws Exception
	 */
	public static String return_success(String info,Object data) throws Exception{
		  Map<String,Object> mapInfo = new HashMap<String, Object>();
		  mapInfo.put("code", "200");
		  mapInfo.put("info", info);
		  mapInfo.put("data", data);
		  
    	  Gson gosn = new GsonBuilder().serializeNulls().create();
    	  String info_data = gosn.toJson(mapInfo);
	    	
		  return info_data;
		 }
	
	/**
	 * 返回失败消息
	 * @param info 返回消息
	 * @param mapObj 返回数据
	 * @return String
	 * @throws Exception
	 */
	public static String return_fail(String info,Map<String, Object> mapObj) throws Exception{
		Map<String,Object> mapInfo = new HashMap<String, Object>();
		mapInfo.put("code", "600");
		mapInfo.put("info", info);
		mapInfo.putAll(mapObj);
		Gson gosn = new GsonBuilder().serializeNulls().create();
   	  	String info_data = gosn.toJson(mapInfo);
		return info_data;
	}
	
	/**
	 * 返回失败消息 系统错误
	 */
	public static String return_error(){
		Map<String,Object> mapInfo = new HashMap<String, Object>();
		mapInfo.put("code", "500");
		mapInfo.put("info", "系统出错！");
		mapInfo.put("data", "");
		Gson gson=new Gson();
		return gson.toJson(mapInfo);
	}
	
}
