package com.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ResponseMessage extends HashMap<String, Object>{
private static final long serialVersionUID = 1L;
    
    public ResponseMessage() {
        put("code", 200);
        put("msg", "success");
    }
    
    public static ResponseMessage error() {
    	ResponseMessage r=new ResponseMessage();
    	r.put(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "未知异常，请联系管理员");
        return r;
    }
    
    public static ResponseMessage error(String msg) {
    	ResponseMessage r=new ResponseMessage();
    	r.put(HttpStatus.INTERNAL_SERVER_ERROR.toString(), msg);
        return r;
    }
    
    public static ResponseMessage error(String code, String msg) {
    	ResponseMessage r = new ResponseMessage();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }
    

    

    
    public static ResponseMessage ok(String msg) {
    	ResponseMessage r = new ResponseMessage();
        r.put("msg", msg);
        return r;
    }
    public static ResponseMessage error(Map<String, Object> map) {
    	ResponseMessage r = new ResponseMessage();
        r.putAll(map);
        return r;
    }
    
    public static ResponseMessage ok(Map<String, Object> map) {
    	ResponseMessage r = new ResponseMessage();
        r.putAll(map);
        return r;
    }
    
    public static ResponseMessage ok() {
        return new ResponseMessage();
    }

    public ResponseMessage put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
