<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>互联网医疗平台</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet"
			href="${root}/form/main/assets/css/bootstrap.css" />
		<link rel="stylesheet"
			href="${root}/form/main/assets/css/font-awesome.css" />
		<link rel="stylesheet" href="${root}/form/main/assets/css/ace-fonts.css" />
		<link rel="stylesheet" href="${root}/form/main/assets/css/ace.css" />
		<link rel="stylesheet" href="${root}/form/main/assets/css/main.css" />
	</head>

	<body class="no-skin">
		<!-- 存放菜单数据临时元素 -->
		<input style="display: none;" id="menuData" value="${menuData}">
		<input id="root" style="display: none;" value="${root}">
		<div id="navbar" class="navbar navbar-default">
			<!-- 头部 -->
			<div class="navbar-container" id="navbar-container">
				<span class="pull-left" style="line-height: 50px; color: #fff; font-size:25px;letter-spacing: 3px;text-indent: 22px;">
					互联网医疗平台
				</span>
				<div class="navbar-buttons navbar-header pull-right"
					role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue">
							<a class="dropdown-toggle">
								<span class="user-info"> <small>欢迎您,</small>
									${feiMaChuXingLoginInfo.account_number} </span>
							</a>
							<ul>
								<li onclick="openUpdatePasswordPage();">
									<em></em>
									修改登录密码
								</li>
								<li onclick="confirmResult();">
									安全退出
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<!-- 菜单 -->
			<div id="sidebar" class="sidebar menu-min">
				<ul class="nav nav-list" id="menu"></ul>
			</div>
			<!-- 显示内容区 -->
			<div class="main-content">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12 widget-box"style="width: 99%; margin-left: 5px;border: 0px solid;white-space: nowrap;" id="showMenuDiv">
						<div style="overflow: auto">
							<div class="nav-left-btn nav-unBtn"><</div>
								<div class="nav-content">
									<ul class="nav nav-tabs" role="tablist" style="background-color: rgb(215, 215, 215); top: 3px; z-index: 1;  transform: translate3d(0px, 0px, 0px); transition-duration: 0ms;margin-top: -5px;" id="tabsMenu">
										<li class="active" style="border-left: 0px solid;">
											<a href="#indexPage" role="tab" data-toggle="tab">
												<c:if test="${empty feiMaChuXingLoginInfo.functions_name}">
													暂无首页
												</c:if>
												<c:if test="${!empty feiMaChuXingLoginInfo.functions_name}">
													${feiMaChuXingLoginInfo.functions_name}
												</c:if>
											</a>
										</li>
									</ul>
								</div>
								<div class="nav-right-btn nav-unBtn">></div>
							</div>
							<div class="tab-content" style="border: 0px;">
								<div role="tabpanel" class="tab-pane active" id="indexPage">
									<c:if test="${empty feiMaChuXingLoginInfo.functions_name}">
										<div style="margin-top: 180px;text-align: center;">
											<h2>请联系管理员设置首页功能</h2>
										</div>
									</c:if>
									<c:if test="${!empty feiMaChuXingLoginInfo.functions_name}">
										<iframe src="${feiMaChuXingLoginInfo.functions_addr}" frameborder="no" border="0" marginwidth="0" 
											marginheight="0" scrolling="no" style="width:100%" allowtransparency="yes">
										</iframe>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%-- <center><a href="http://www.lekainet.com" target="lekai">技术支持：广州乐开互联网服务有限公司</a></center> --%>
			</div>
		</div>
		<script src="${root}/form_util/util/sys_js/jquery.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/bodyUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form/main/assets/js/bootstrap.js?<%=Math.random()%>"></script>
		<script src="${root}/form/main/assets/js/ace/ace.js?<%=Math.random()%>"></script>
		<script src="${root}/form/main/assets/js/ace/ace.sidebar.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/jsonUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form/main/js/sidebar-menu.js?<%=Math.random()%>"></script>
		<script src="${root}/form/main/assets/js/bootstrap-tab.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/ajaxUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/validateUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/strUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/alertDivUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form_util/util/util_js/adminUtil.js?<%=Math.random()%>"></script>
		<script src="${root}/form/main/js/main.js?<%=Math.random()%>"></script>
	</body>
</html>