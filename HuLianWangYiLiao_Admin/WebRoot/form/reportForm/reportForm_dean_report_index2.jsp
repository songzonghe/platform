<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@include file="/form_util/page/root.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${root}/form/main/assets/css/bootstrap.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/font-awesome.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/ace-fonts.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/ace.css" />
<link rel="stylesheet" href="${root}/form_util/util/util_css/myPage.css" />
</head>
<body class="no-skin">
<!-- 返回回来参数 -->
<%@include file="/form_util/page/hidden.jsp"%>
<div class="main-container box" id="main-container">
	<div class="page-content">
			<div class="row">
				<div class="widget-box">
					<div class="widget-header">
						<h4 class="widget-title">
							${info.queryDate}月报
						</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="reportForm_dean_report_index.do?type=2" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
		 						<fieldset>
									<label>时间</label>
									<input type="text" id="query_beginTime" placeholder="时间" value="${info.queryDate }" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM'})">
									<button type="submit" onclick="queryDeanReport()" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	<div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline no-footer"> 
		<div class="widget-box">
				<div class="widget-header">
					<h4 class="widget-title">
						${info.queryDate }月报
					</h4>
				</div>
			<div class="widget-body">
				<table class="table  table-bordered dataTable">
					  <tr>
					  	<th width="500">注册人数</th>
					  	<th width="500">${info.num1}人</th>
					  	<th width="500">问诊人数</th>
					  	<th width="500">${info.num2}人</th>
					  	<th width="500">处方单数</th>
					  	<th width="500">${info.num3}单</th>
					  </tr>
				    <tr>
				    	<th >处方审核单数</th>
					  	<th >${info.num4}单</th>
						<th>处方审核不通过单数</th>
						<th>${info.num5}单</th>
					  	<th>健康指导单数</th>
					  	<th>${info.num6}单</th>
					</tr>
					<tr>
						<th>检验检查单数</th>
					  	<th>${info.num7}单</th>
						<th>住院建议单数</th>
						<th>${info.num8}单</th>
					  	<th>转诊人数</th>
					  	<th>${info.num9}人</th>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

<script src="${root}/form_util/util/sys_js/jquery.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/ajaxUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/alertDivUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/bodyUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/adminUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/validateUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/jsonUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/publicJsonUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/strUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/date/WdatePicker.js?<%=Math.random()%>"></script>
<script src="${root}/form/main/assets/js/bootstrap-tab.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/sys_js/ajaxfileupload.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/nodeUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form/reportForm/js/reportForm_main.js?<%=Math.random()%>"></script>
</body>
</html>