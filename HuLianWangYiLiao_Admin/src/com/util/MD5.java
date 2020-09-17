package com.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public  class MD5 {
	private static Logger logger = Logger.getLogger(MD5.class.getName());
	/**
	 * @sm 加密算法
	 */
	public static String EncoderByMd5(String str){
		try {
			// 确定计算方法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			 Base64 base64 = new Base64();
			// 加密后的字符串
			String newstr = base64.encodeToString(md5.digest(str.getBytes("utf-8")));
			return newstr;
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.getMessage();
		}
		return null;
	}
	
	/**
	 * base64加密
	 */
	public static String base64Encoder(String str) {
	    String backInfo = null;
	    try {
	    	byte[] bytes = new Base64().encode(str.getBytes("UTF-8"));
	    	backInfo = new String(bytes, "UTF-8");
	    } catch (Exception e){
	        e.printStackTrace();
	    }
	    return backInfo;
	}
	
	
	/**
	 * base64解密
	 */
	public static String base64Decoder(String str) {
	    String backInfo = null;
	    try {
	    	byte[] decode = new Base64().decode(str);
	    	backInfo = new String(decode,"UTF-8");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return backInfo;
	}
	/***************************自定义只针对数字打乱加密*******************************/
	/**
	 * 数字加密
	 */
	public static String numberEncoder(String num){
		String backInfo = "";
		try {
			StringBuffer str=new StringBuffer();
			num="*@*"+num;//加入乱的标识
			//第一遍 1和2交差
			char[] charArray = num.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if(i%2==1){str.append(charArray[i]+""+charArray[i-1]);};
			}
			if(charArray.length%2==1) {
				str.append(charArray[charArray.length-1]);
			}
			byte[] bytes = new Base64().encode((str+"").getBytes("UTF-8"));
			backInfo = new String(bytes, "UTF-8");
			//第二遍  倒过来
			str.delete(0, str.length());
			char[] infoArray = backInfo.toCharArray();
			for (int i = 1; i <= infoArray.length; i++) {
				str.append(infoArray[infoArray.length-i]);
			}
			byte[] strs = new Base64().encode((str+"").getBytes("UTF-8"));
			backInfo = new String(strs, "UTF-8");
		} catch (Exception e){
			e.printStackTrace();
		}
		return backInfo;
	}
	
	
	/**
	 * 数字解密
	 */
	public static String numberDecoder(String str){
		String backInfo = "";
		StringBuffer backStr=new StringBuffer();
		try {
			byte[] decode = new Base64().decode(str);
			backInfo = new String(decode,"UTF-8");
			char[] charArray = backInfo.toCharArray();
			//第一遍  倒过来 
			for (int i = 1; i <= charArray.length; i++) {
				backStr.append(charArray[charArray.length-i]);
			}
			//第二遍  1和2交差
			byte[] decode2 = new Base64().decode(backStr+"");
			backInfo = new String(decode2,"UTF-8");
			backStr.delete(0, str.length());
			char[] charArray2 = backInfo.toCharArray();
			for (int i = 0; i < charArray2.length; i++) {
				if(i%2==1) {backStr.append(charArray2[i]+""+charArray2[i-1]);};
			}
			if(charArray2.length%2==1){
				backStr.append(charArray2[charArray2.length-1]);
			}
			if(backStr.length()<4) {
				return "";
			}
			return backStr.substring(3);
		} catch (Exception e){
			e.printStackTrace();
			return "";
		}
	}
	public static void main(String[] args){
		String aa=numberEncoder("0-0");
		System.out.println(aa);
		System.out.println(numberDecoder("dElqS3hvQ1E="));
	}
}
