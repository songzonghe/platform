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
						平台消息管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="adminNotice_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									
									<label>
										发送人类型
									</label>
									<select id="query_user_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.user_type=='1'}">selected="selected"</c:if> value="1">用户</option>
										<option <c:if test="${map.user_type=='2'}">selected="selected"</c:if> value="2">门店</option>
										<option <c:if test="${map.user_type=='3'}">selected="selected"</c:if> value="3">医生</option>
									</select>
									<label>
										通知标题
									</label>
									<input type="text" id="query_notice_title" placeholder="通知标题" value="${map.notice_title}">
									<button type="submit" onclick="queryAdminNotice(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
										<i class="ace-icon fa fa-plus icon-on-right bigger-110"></i>
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
					<th field="notice_type"   onclick="querySort(this,'queryAdminNotice')"  >
						通知类型
					</th>
					<th field="user_type"   onclick="querySort(this,'queryAdminNotice')"  >
						发送人类型
					</th>
					<th field="user_id"   onclick="querySort(this,'queryAdminNotice')"  >
						发送人名字
					</th>
					<th field="notice_title"   onclick="querySort(this,'queryAdminNotice')"  >
						通知标题
					</th>
					<th field="notice_content"   onclick="querySort(this,'queryAdminNotice')"  >
						通知内容
					</th>
					<th field="notice_join"   onclick="querySort(this,'queryAdminNotice')"  >
						关联
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryAdminNotice')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryAdminNotice')">
						备注
					</th>
					<th width="180">
						操作
					</th>
				</tr>
			</thead>
			<tbody id="tbodyData">
				<c:if test="${empty listMap}">
					<tr align="center">
						<td colspan="74">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.notice_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.notice_type=='1'}">系统消息</c:if>
							<c:if test="${info.notice_type=='2'}">处方消息</c:if>
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.user_type=='1'}">用户</c:if>
							<c:if test="${info.user_type=='2'}">门店</c:if>
							<c:if test="${info.user_type=='3'}">医生</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.name}
						</td>
						<td style="vertical-align: middle;">
							${info.notice_title}
						</td>
						<td style="vertical-align: middle;">
							${info.notice_content}
						</td>
						<td style="vertical-align: middle;">
							${info.notice_join}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.notice_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.notice_id}','${info.notice_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryAdminNotice" />
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
<script src="${root}/form/admin/notice/js/adminnotice_main.js?<%=Math.random()%>"></script>
</body>
</html>