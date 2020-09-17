package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证类
 * @author 李飞
 *
 */
public class UtilValiDate {
	/**
	 * @sm 判断是否为空 非空返回true  空返回false
	 * @param obj
	 * @return boolean
	 */
	public static boolean isEmpty(Object obj) {
		try {
			if (null != obj && !"".equals(obj) && UtilStr.getStr(obj).trim().length()!=0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * @sm 判断是否为null 非null返回true  null返回false
	 * @param obj
	 * @return boolean
	 */
	public static boolean isNull(Object obj) {
		try {
			if (null != obj && !"null".equals(obj) &&  !"".equals(obj))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 判断当前文件是否为图片  true 是图片  false 不是
	 * @param fileName
	 * @return true
	 */
	public static boolean isImg(String fileName){
		try {
			//验证标识符必须由字母、数字、下划线组成 
		    Pattern p = Pattern.compile("(.*)(.gif|.jpg|.jpeg|.GIF|.JPG|.JPEG|.PNG|.png)"); 
		    Matcher m = p.matcher(fileName); 
		    boolean flg = m.matches(); 
		    return flg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 判断当前文件是否为媒体  true 是  false 不是
	 * @param fileName
	 * @return true
	 */
	public static boolean isMedia(String fileName){
		try {
			//验证标识符必须由字母、数字、下划线组成 
		    Pattern p = Pattern.compile("(.*)(.avi|.mp4|.flv|.mov|.wmv|.3gp|.swf|.asf|.mp3|.AVI|.MP4|.FLV|.MOV|.WMV|.3GP|.SWF|.ASF|.MP3)"); 
		    Matcher m = p.matcher(fileName); 
		    boolean flg = m.matches(); 
		    return flg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 判断当前文件是否为excel  true 是  false 不是
	 * @param fileName
	 * @return true
	 */
	public static boolean isExcel (String fileName){
		try {
			//验证标识符必须由字母、数字、下划线组成 
			Pattern p = Pattern.compile("(.*)(.xlsx|.xls)"); 
			Matcher m = p.matcher(fileName); 
			boolean flg = m.matches(); 
			return flg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
