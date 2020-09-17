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
						药品用法管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilDrugUsage_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										用法类型
									</label>
									<select id="query_usage_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.usage_type=='1'}">selected="selected"</c:if> value="1">西药用法</option>
										<option <c:if test="${map.usage_type=='2'}">selected="selected"</c:if> value="2">中药特殊服用用法</option>
										<option <c:if test="${map.usage_type=='3'}">selected="selected"</c:if> value="3">中药服用方法</option>
										<option <c:if test="${map.usage_type=='4'}">selected="selected"</c:if> value="4">中药服用要求</option>
									</select>
								
									<label>
										用法名称
									</label>
									<input type="text" id="query_usage_name" placeholder="用法名称" value="${map.usage_name}">
									
									<button type="submit" onclick="queryUtilDrugUsage(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
										<i class="ace-icon fa fa-plus icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openImportBoxPage('util_drug_usage','queryUtilDrugUsage')" class="btn btn-sm btn-info">
									导入
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
					<th field="usage_type"   onclick="querySort(this,'queryUtilDrugUsage')"  >
						用法类型
					</th>
					<th field="usage_name"   onclick="querySort(this,'queryUtilDrugUsage')"  >
						用法名称
					</th>
					<th field="usage_printing_name"   onclick="querySort(this,'queryUtilDrugUsage')"  >
						打印名称
					</th>
					<th field="usage_sort"  type="num" onclick="querySort(this,'queryUtilDrugUsage')"  >
						用法排序
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryUtilDrugUsage')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryUtilDrugUsage')">
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
						<td colspan="34">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.usage_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.usage_type=='1'}">西药用法</c:if>
							<c:if test="${info.usage_type=='2'}">中药特殊服用用法</c:if>
							<c:if test="${info.usage_type=='3'}">中药服用方法</c:if>
							<c:if test="${info.usage_type=='4'}">中药服用要求</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.usage_name}
						</td>
						<td style="vertical-align: middle;">
							${info.usage_printing_name}
						</td>
						<td style="vertical-align: middle;">
							${info.usage_sort}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.usage_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.usage_id}','${info.usage_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryUtilDrugUsage" />
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
<script src="${root}/form/util/drug/usage/js/utildrugusage_main.js?<%=Math.random()%>"></script>
</body>
</html>