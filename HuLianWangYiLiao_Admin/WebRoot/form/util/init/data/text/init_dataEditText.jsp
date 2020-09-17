<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/form_util/page/root.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>编辑-${map.init_name}</title>
	    <link rel="stylesheet"
			href="${root}/form/main/assets/css/bootstrap.css" />
		<link rel="stylesheet"
			href="${root}/form/main/assets/css/font-awesome.css" />
		<link rel="stylesheet"
			href="${root}/form/main/assets/css/ace-fonts.css" />
		<link rel="stylesheet" href="${root}/form/main/assets/css/ace.css" />
	    <script src="${root}/form_util/util/sys_js/jquery.js?<%=Math.random()%>"></script>
	    <script src="${root}/form_util/util/util_js/ajaxUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/alertDivUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/bodyUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/validateUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/jsonUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/publicJsonUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/findByIdUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/strUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/adminUtil.js?<%=Math.random()%>"></script>
	    <script type="text/javascript" charset="utf-8" src="${root}/form_util/ueditor14/ueditor.config.js?<%=Math.random()%>"></script>
	    <script type="text/javascript" charset="utf-8" src="${root}/form_util/ueditor14/ueditor.all.js?<%=Math.random()%>"> </script>
	    <script type="text/javascript" charset="utf-8" src="${root}/form_util/ueditor14/lang/zh-cn/zh-cn.js?<%=Math.random()%>"></script>
	    <script type="text/javascript" src="${root}/form/util/init/data/text/js/text.js?<%=Math.random()%>"></script>
	</head>
	<body>
		<%@include file="/form_util/page/hidden.jsp"%>
		<center>
			<h1>${map.init_name}</h1>
			<script id="editor" type="text/plain" style="width:80%;height:50%;">${map.init_key}</script>
			<br/>
			<button type="button" class="btn btn-sm btn-lg" onclick="confirmClose()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="confirmSubmitPage()">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</center>
		<input style="display: none;" id="init_id" value="${map.init_id}">
		<input style="display: none;" id="init_name" value="${map.init_name}">
	</body>
</html>