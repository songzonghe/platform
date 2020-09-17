package com.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * json操作类 2015年12月11日 15:05:47
 * 
 * @author 李飞
 * 
 */
public class UtilJson {
	/**
	 * 将Json对象转换成Map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> toMap(String jsonString)
			throws JSONException {
		Map<String, String> result = new HashMap<String, String>();
		if (!UtilValiDate.isEmpty(jsonString)) {
			return result;
		}
		JSONObject jsonObject = new JSONObject(jsonString);
		Iterator<String> iterator = jsonObject.keys();
		String key = null;
		String value = null;
		while (iterator.hasNext()) {
			key = (String) iterator.next();
			value = jsonObject.getString(key);
			result.put(key, value);
		}
		return result;
	}

	/**
	 * 将map转换成json字符串
	 */
	@SuppressWarnings("rawtypes")
	public static String mapToJson(Map mapStr) throws JSONException {
		JSONObject jall = new JSONObject();  
		jall.put("map", mapStr);//Map转换成Json 
		String jsonStr =  jall.toString();
		jsonStr = jsonStr.substring(jsonStr.indexOf(":")+1,jsonStr.length()-1);
		return jsonStr;
	}
	
	/**
	 * 将List<Map>map转换成json字符串
	 */
	@SuppressWarnings("rawtypes")
	public static String listToJson(List<Map<String, Object>> listMap)throws JSONException {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Map map : listMap) {
			sb.append(UtilJson.mapToJson(map));
			sb.append(",");
		}
		if(listMap.size()!=0){
			sb.delete(sb.length()-1, sb.length());
		}
		sb.append("]");
		return UtilStr.getStr(sb);
	}
	/**
	 * 将List<int>listInt转换成json字符串
	 */
	public static String listIntToJson(List<Integer> listInt)throws JSONException {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (Integer i : listInt) {
			sb.append(i);
			sb.append(",");
		}
		if(listInt.size()!=0){
			sb.delete(sb.length()-1, sb.length());
		}
		sb.append("]");
		return UtilStr.getStr(sb);
	}
	/**
	 * 将List<String>listStr转换成json字符串
	 */
	public static String listStrToJson(List<String> listStr)throws JSONException {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (String str : listStr) {
			sb.append("'"+str+"'");
			sb.append(",");
		}
		if(listStr.size()!=0){
			sb.delete(sb.length()-1, sb.length());
		}
		sb.append("]");
		return UtilStr.getStr(sb);
	}
	
	/**
	 * 将json字符串转换成List<Map<String,Object>>
	 */
	public static List<Map<String,Object>> strToList(String data)throws JSONException {
		List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
		if(UtilValiDate.isEmpty(data)&&data.length()>6){
			Gson gson = new Gson();
			listMap = gson.fromJson(data, new TypeToken<List<Map<String,Object>>>() {}.getType());
		}
		return listMap;
	}
	
	/**
	 * 将Json对象转换成Map<String, Object>
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> strToMap(String jsonString)throws JSONException {
		Map<String, Object> result = new HashMap<String, Object>();
		if (!UtilValiDate.isEmpty(jsonString)) {
			return result;
		}
		JSONObject jsonObject = new JSONObject(jsonString);
		Iterator<String> iterator = jsonObject.keys();
		String key = null;
		Object value = null;
		while (iterator.hasNext()) {
			key = (String) iterator.next();
			value = jsonObject.getString(key);
			result.put(key, value);
		}
		return result;
	}
	
	/**
	 * 所有类型转换为json
	 */
	public static String toJson(Object Obj){
		try {
			boolIsNull(Obj,1);
		} catch (Exception e) {
			System.out.println("转换错误！！");
		}
		Gson gson=new Gson();
		return gson.toJson(Obj);
	}
	
	/**
	 * json转换为所有类型
	 */
	public static <T> Object fromJson(String str,Type type){
		Gson gson=new Gson();
		Object obj=gson.fromJson(str, type);
		try {
			boolIsNull(obj,2);
		} catch (Exception e) {
			System.out.println("转换错误！！");
		}
		return obj;
	}
	
	
	/**
	 * 转换处理方法   
	 * type作用  1 序列化（ 转成json字符）之前  将null转换为 "  "     
	 *   2 反序列化（将json字符反转）之前  将 int类型转为 String，保证不转化为 double类型     
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Object boolIsNull(Object Obj,int type) {
		try {
			if(Obj.getClass()==HashMap.class){
				HashMap<String, Object>map=(HashMap<String, Object>) Obj;
				for (Entry<String, Object> str : map.entrySet()) {
					map.put(str.getKey(), boolIsNull(str.getValue(),type)) ;
				}
				return map;
			}else
			if(Obj.getClass()==LinkedHashMap.class){
				LinkedHashMap<String, Object>map=(LinkedHashMap<String, Object>) Obj;
				for (Entry<String, Object> str : map.entrySet()) {
					map.put(str.getKey(), boolIsNull(str.getValue(),type)) ;
				}
				return map;
			}else
				if(Obj.getClass()==LinkedCaseInsensitiveMap.class){
					LinkedHashMap<String, Object>map=(LinkedHashMap<String, Object>) Obj;
					for (Entry<String, Object> str : map.entrySet()) {
						map.put(str.getKey(), boolIsNull(str.getValue(),type)) ;
					}
					return map;
			}else
			if(Obj.getClass()==ArrayList.class){
				ArrayList list=(ArrayList) Obj;
				for (int i = 0; i < list.size(); i++) {
					list.set(i,boolIsNull(list.get(i),type));
				}
				return list;
			}else
			if(Obj.getClass()==LinkedList.class){
				LinkedList list=(LinkedList) Obj;
				for (int i = 0; i < list.size(); i++) {
					list.set(i,boolIsNull(list.get(i),type));
				}
				return list;
			}else if(Obj.getClass()==Integer.class && type==2){
				return Obj+"";
			}
		} catch (Exception e) {
			return "";
		}
		return Obj;
	}
}
