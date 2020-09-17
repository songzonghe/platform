<%@ page language="java"  pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>error</title>
  </head>
  <body>
   	<span id="tips">
   	<c:if test="${empty tips}">error</c:if>
   	<c:if test="${not empty tips}">${tips}</c:if>
   	</span>
  </body>
</html>
