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
						账户管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="systemAccount_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										账号
									</label>
									<input type="text" id="query_account_number" placeholder="账号" value="${map.account_number}">
									
									<label>
										账户名称
									</label>
									<input type="text" id="query_account_name" placeholder="账户名称" value="${map.account_name}">
									
									<label>
										状态
									</label>
									<select id="query_zTai"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.zTai=='2'}">selected="selected"</c:if> value="2">正常</option>
										<option <c:if test="${map.zTai=='0'}">selected="selected"</c:if> value="0">禁用</option>
									</select>
									<button type="submit" onclick="querySystemAccount(0)" class="btn btn-sm btn-success">
										查询
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加账户
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
					<th field="account_number"   onclick="querySort(this,'querySystemAccount')"  >
						账号
					</th>
					<th field="account_name"   onclick="querySort(this,'querySystemAccount')"  >
						账户名称
					</th>
					<th>
						首页功能
					</th>
					<th field="zt"   onclick="querySort(this,'querySystemAccount')"  >
						状态
					</th>
					<th field="lrsj" width="170" onclick="querySort(this,'querySystemAccount')">
						创建时间
					</th>
					<th field="bz"  onclick="querySort(this,'querySystemAccount')">
						备注
					</th>
					<th width="100">
						<i class="fa fa-cog"></i>
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
					<tr id="tr${info.account_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.account_number}
						</td>
						<td style="vertical-align: middle;">
							${info.account_name}
						</td>
						<td style="vertical-align: middle;">
							${info.functions_name}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.zt=='2'}"><span class="badge badge-success">正常</span></c:if>
							<c:if test="${info.zt=='0'}"><span class="badge badge-danger">禁用</span></c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
						<span class="handel-box">
						<a>操作</a>
						<ul class="handel-list">
							<li onclick="openEditPage('${info.account_id}','all')" title="编辑">编辑</li>
							<li onclick="openFunctionsPage('${info.account_id}','${info.account_number}')" title="配置权限">配置权限</li>
							<li onclick="openEditPage('${info.account_id}','pwd')" title="重置密码">重置密码</li>
							<c:if test="${info.zt=='2'}">
							<li onclick="confirmUpdateLock('${info.account_id}','${info.account_number}',0)" title="禁用">禁用</li>
							</c:if>
							<c:if test="${info.zt=='0'}">
							<li onclick="confirmUpdateLock('${info.account_id}','${info.account_number}',2)" title="启用">启用</li>
							</c:if>
							<li onclick="confirmDeleteDate('${info.account_id}','${info.account_name}')" title="删除">删除</li>
						</ul>
						</span>						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="querySystemAccount" />
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
<script src="${root}/form/system/account/js/systemaccount_main.js?<%=Math.random()%>"></script>
</body>
</html>