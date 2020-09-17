<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/form_util/page/root.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
		<title>互联网医疗平台登录</title>
		<link rel="stylesheet" href="${root}/form/main/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="${root}/form/main/assets/css/font-awesome.css" />
		<link rel="stylesheet" href="${root}/form/main/assets/css/ace-fonts.css" />
		<link rel="stylesheet" href="${root}/form/main/assets/css/ace.css" />
		<link rel="stylesheet" href="${root}/form/login/css/login.css" />
	</head>
	<body>
		<div class="top-content">
			<div class="top-title">互联网医疗平台登录</div>
		</div>
		
		<form  class="input-list" autocomplete="off" isValidate="y" onsubmit="return false;">
			<div class="input-border input-hover form-group field">
				<img class="input-icon" src="${root}/form/login/images/User-Icon.png"/><img src="${root}/form/login/images/buttonLeft.png"/>
				<input class="form-control" id="login_name" type="text" placeholder="请输入账号" data-validate="required:请输入账号"/>
			</div>
			<div class="input-border input-hover form-group field">
				<img class="input-icon" src="${root}/form/login/images/key.png"/><img src="${root}/form/login/images/buttonLeft.png"/>
				<input  class="form-control " id="login_pwd" type="password" placeholder="请输入密码" data-validate="required:请输入密码"/>
			</div>
			<div style="color: red;float: left;margin-left: 100px;" id="infoDiv">${infoError}</div>
			<div class="input-border border-none">
				<input class="input-leftBtn input-hover" onclick="loginValidate()" type="submit" value="登录"/>
			</div>
		</form>
		<!-- 提交数据 -->
		<form action="${root}/login_valiDate.do" id="myLoginForm" method="post">
			<input style="display: none;" id="ishosid" value="${ishosid}">
			<input style="display: none;" id="hosid" value="${hosid}">
			<!-- 参数隐藏 用于页面传值-->
			<input style="display: none;" id="mapStr" name="mapStr">
		</form>
		<script src="${root}/form_util/util/sys_js/jquery.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/validateUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/bodyUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/jsonUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/ajaxUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/adminUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/alertDivUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form/login/js/login.js?<%=Math.random()%>"></script>
	</body>
</html>