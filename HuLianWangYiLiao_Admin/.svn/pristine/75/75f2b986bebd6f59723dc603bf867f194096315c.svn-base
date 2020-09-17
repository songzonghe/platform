package com.util;

public class TokenUtil {
	private static final String private_key ="14f796264f11f6c66db71931e733eba799a9a1b11c17e63a15586699dcb8b886";
	//private static final String private_key = "6077325bd586c68b57a3bb8233f49ab2e3da7e344646e64e6f6fbc4eb20ddd72";

	/**
	 * 获取基数位和偶数位组成新字符串，基数在前，偶数在后
	 */
	public static String getStr(String s) {
		String newStr1 = new String();
		String newStr2 = new String();
		
//	        //获取字符串长度
//	        int temp = s.length();
//	       
//	            for(int i = 0; i <= (temp - 2); i += 2) {
//
//	    	        //获取基数位
//	    	        newStr1 += s.charAt(i);
//	    	
//	    	        }
//		        for(int i = 1; i <= (temp - 1); i += 2) {
//	
//		        //获取偶数位
//		        newStr2 += s.charAt(i);
//		        }
		StringBuffer buffer1 = new StringBuffer();
		StringBuffer buffer2 = new StringBuffer();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			// 因为索引是从0开始，所以索引为偶数的是奇数位字符
			if (i % 2 == 0) {
				buffer1.append(s.charAt(i));
			} else {
				buffer2.append(s.charAt(i));
			}
			
		}
		newStr1 = buffer1.toString();
		newStr2 = buffer2.toString();
		return newStr1 + newStr2;
	}

	/**
	 * 验证token一致性函数
	 * 
	 * @return
	 */
	public static String getToken(String time) {

		String tempstr = null;
		// 1、拆分成两块并加入时间戳
		String prefixtoken = private_key.substring(0, 31);
		String suffixtoken = private_key.substring(31, private_key.length());
		String sercrit = prefixtoken + time + suffixtoken;
		// 2、获取基数位和偶数位组成新字符串
		sercrit = getStr(sercrit);
		// 3、进行三次sha256加密
		tempstr = SHA256Util.getSHA256StrJava(sercrit);
		tempstr = SHA256Util.getSHA256StrJava(tempstr);
		tempstr = SHA256Util.getSHA256StrJava(tempstr);
//		if(tempstr.equals("95543a2654c86de9d7c43169229a99e07027a6eb326ebaf6830577c809c912b0")) {
//			System.out.println("666");
//		}
		return tempstr;
	}

}
