package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 时间处理类
 * 
 * @author 李飞
 * 
 */
public class UtilTime {
	/**
	 * 默认得到当前时间 传入时间格式
	 * 
	 * @param timeFormat
	 *            格式
	 * @return String 返回值
	 * @throws Exception
	 */
	public static String getTime(String timeFormat) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat(timeFormat);
		return sf.format(new Date());
	}
	
	
	/**
	 * 默认得到当前时间 YYYY_MM_DD
	 * @return String 返回值
	 * @throws Exception
	 */
	public static String getTimeYYYY_MM_DD() throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat(SysFinal.YYYY_MM_DD);
		return sf.format(new Date());
	}

	/**
	 * 得到两个时间相减的毫秒数
	 * 
	 * @param startDate
	 * @param endDate
	 * @param timeFormat
	 * @return long
	 * @throws Exception
	 */
	private static long getTime(String startDate, String endDate,
			String timeFormat) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat(timeFormat);
		Date endTime = sf.parse(endDate);
		Date startTime = sf.parse(startDate);
		return endTime.getTime() - startTime.getTime();
	}

	/**
	 * 得到两个时间相减
	 * 
	 * @param startDate
	 * @param endDate
	 * @param timeFormat
	 * @return 格式 X天X小时
	 */
	public static String getJianDay(String startDate, String endDate,
			String timeFormat) throws Exception {
		if (!UtilValiDate.isEmpty(endDate)) {
			return "0天0小时";
		}
		long different = getTime(startDate, endDate, timeFormat);
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;
		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;
		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;
		return elapsedDays + "天" + elapsedHours + "小时";
	}

	/**
	 * 给入时间间隔参数 得到间隔之后的时间
	 * 
	 * @param timeFormat
	 *            格式化参数
	 * @param tiemNum
	 *            间隔参数 毫秒
	 * @return String
	 */
	public static String getAgoTime(String timeFormat, long tiemNum) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(cal.getTime().getTime() - tiemNum));
		return new SimpleDateFormat(timeFormat).format(cal.getTime());// 获取到完整的时间
	}

	
	/**
	 * 获取时间
	 * @param time 时间
	 * @param dayNum
	 *            负数为今天之后的时间 正数为今天之前的时间
	 * @return String yyyy-MM-dd
	 * @throws Exception
	 */
	public static String getDayData(String time,int dayNum) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date times = sf.parse(time);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(times);
		calendar.add(Calendar.DATE, dayNum);// 把日期往后增加一天.整数往后推,负数往前移动
		Date date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	/**
	 * 获取时间
	 * 
	 * @param dayNum
	 *           正数为今天之后的时间  负数为今天之前的时间
	 * @return String yyyy-MM-dd
	 * @throws Exception
	 */
	public static String getDayData(int dayNum) throws Exception {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, dayNum);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	
	
	/**
	 * 比较两个时间是否相等 (比较格式 yyyyMMdd)  结束时间大于当前时间返回true 小于当前时间返回false
	 * @param yyyy_mm_dd 结束时间
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean timeCompare(Object yyyy_mm_dd)throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String startTime = formatter.format(new Date());
		String stopTime = UtilStr.getStr(yyyy_mm_dd).replaceAll("-", "");
		return UtilStr.getInt(stopTime)>=UtilStr.getInt(startTime);
	}
	
	
	/**
	 * 比较两个时间是否相等 (比较格式 yyyy_mm_dd_hh_mm_ss)  结束时间大于当前时间返回true 小于当前时间返回false
	 * @param yyyy_mm_dd 结束时间
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean timeCompare1(Object yyyy_mm_dd_hh_mm_ss)throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime = formatter.format(new Date());
		String stopTime = UtilStr.getStr(yyyy_mm_dd_hh_mm_ss).replaceAll("-", "").replace(":", "").replace(" ", "");
		return UtilStr.getStrToFloat(stopTime)>=UtilStr.getStrToFloat(startTime);
	}
	
	
	/**
	 * 根据时间得到周几和日期
	 * @param time
	 * @param prefixStr
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	public static Map<String,Object> getWeekOrDateDay(String time,String prefixStr)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat(SysFinal.YYYY_MM_DDHH_MM_SS);
		Calendar calendar = new GregorianCalendar();
		Date date = null;
		date = sdf.parse(time);
		calendar.setTime(date);
		int week_index = calendar.get(Calendar.DAY_OF_WEEK) ;
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		String weekDay = null;
		if(week_index==1){
			weekDay="日";
		}else if(week_index==2){
			weekDay="一";
		}else if(week_index==3){
			weekDay="二";
		}else if(week_index==4){
			weekDay="三";
		}else if(week_index==5){
			weekDay="四";
		}else if(week_index==6){
			weekDay="五";
		}else if(week_index==7){
			weekDay="六";
		}
		String dateDay = month+"-"+day;	
		map.put("date",dateDay);
		map.put("weekDay", prefixStr+weekDay);
		return map;
	}
	
	/**
	 * 得到当前月份
	 * @return int
	 * @throws Exception
	 */
	public static int getMonth()throws Exception{
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 获取一个连续的日期集合
	 * @throws Exception 
	 */
	public static List<String> getListDate(Map<String, String> mapStr) throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int dayNum = 7;//默认为最近7天
		String beginTime = mapStr.get("beginTime");
		String endTime = mapStr.get("endTime");
		if (!UtilValiDate.isEmpty(endTime)) {
			Date endDate = new Date();// 取时间
			endTime=formatter.format(endDate);
		}
		if (UtilValiDate.isEmpty(beginTime)) {
			Date beginDate = formatter.parse(beginTime);
			Date endDate = formatter.parse(endTime);
	        dayNum=(int) ((endDate.getTime()-beginDate.getTime())/(1000*3600*24));
	        if(dayNum<=0){
	        	dayNum=7;
	        }
		}else if (UtilValiDate.isEmpty(mapStr.get("dayNum"))){
			dayNum=UtilStr.getInt(mapStr.get("dayNum"))-1;
		}
		List<String>dateList=new LinkedList<String>();
		for (int i=dayNum;i>=0;i--) {
			Date endDate = formatter.parse(endTime);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(endDate);
			calendar.add(Calendar.DATE, -i);// 把日期往后增加一天.整数往后推,负数往前移动
			endDate = calendar.getTime(); // 这个时间就是日期往后推一天的结果
			String date=formatter.format(endDate);
		    dateList.add(date);
		}
		return dateList;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(getDayData(0));
		System.out.println(getDayData(1));
		System.out.println(getDayData(2));
	}
}
