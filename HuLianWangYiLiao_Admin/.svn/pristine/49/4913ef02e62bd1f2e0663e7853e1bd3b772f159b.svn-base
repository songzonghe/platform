<%@ page language="java"  pageEncoding="utf-8"%>
<%@include file="/form_util/page/root.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录验证</title>
    <script src="${root}/form_util/util/sys_js/jquery.js"></script>
  </head>
  <body>
   	<span id="tips">正在跳转...</span>
  </body>
  <script type="text/javascript">
    	$(function(){
    		if (/MicroMessenger/.test(window.navigator.userAgent)) {
    			$("#tips").html('该链接不支持微信打开，请用浏览器打开');
	        }else{
    			window.parent.parent.location="login.do?hi="+getCookie("hlwyl_hosid");
	        }
    	});
    	function getCookie(name){
    	  var reg = RegExp(name+'=([^;]+)');
    	  var arr = document.cookie.match(reg);
    	  if(arr){
    	    return arr[1];
    	  }else{
    	    return '';
    	  }
    	};
    </script>
</html>
