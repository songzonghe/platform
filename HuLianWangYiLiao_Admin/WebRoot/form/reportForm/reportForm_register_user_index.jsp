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
							注册用户报表
						</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="reportForm_register_user_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
		 						<fieldset>
									<label>
										账号
									</label>
									<input type="text" id="query_user_phone" placeholder="账号" value="${map.user_phone}">
									
									<label>注册时间</label>
									<input type="text" id="query_beginTime" placeholder="起始时间" value="${map.beginTime}" readonly="readonly" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'query_endTime\')}'})">
									~~
									<input type="text" id="query_endTime" placeholder="终止时间" value="${map.endTime}" readonly="readonly" onclick="WdatePicker({minDate:'#F{$dp.$D(\'query_beginTime\')}'})">
									
									
									<button type="submit" onclick="queryRegisterUser(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									
									<button  type="button" onclick="confirmExportExcel()" class="btn btn-sm btn-pink">
										导出excel
									</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	<div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline no-footer"> 
		<table id="sample-table-1" class="table  table-bordered dataTable"> 
			<thead>
				<tr>
					<th width="50px">
						序号
					</th>
					<th  >
						账号
					</th>
					<th  >
						用户名称
					</th>
					<th >
						用户头像
					</th>
					<th  >
						真实名称
					</th>
					<th >
						注册时间
					</th>
					<th >
						备注
					</th>
				</tr>
			</thead>
			<tbody id="tbodyData">
				<c:if test="${empty listMap}">
					<tr align="center">
						<td colspan="64">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.user_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						
						<td style="vertical-align: middle;">
							${info.user_phone}
						</td>
						<td style="vertical-align: middle;">
							${info.user_nickname}
						</td>
						<td style="vertical-align: middle;">
							<img  style="height: 60px;" src="${info.user_img}">
						</td>
						<td style="vertical-align: middle;">
							${info.user_name}
						</td>
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryRegisterUser" />
<c:set var="pageSelectNum" value="selectPageMain" />
<%@include file="/form_util/page/page.jsp"%>

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