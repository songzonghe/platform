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
<style type="text/css">
.selected1,.selected2{
	color: red;
}

</style>

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
						检验检查分类管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilChecklistClass_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										分类名称
									</label>
									<input type="text" id="query_checklist_class_name" placeholder="检查分类名称" value="${map.checklist_class_name}">
									<button type="submit" onclick="queryUtilChecklistClass(0)" class="btn btn-sm btn-success">
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
	<div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline no-footer" style="display:flex;"> 
		<table id="sample-table-1" class="table  table-bordered dataTable" style="width: 33%;"> 
			<thead>
				<tr>
					<th style="text-align: center;" colspan="5">
						一级分类
					</th>
				</tr>
				<tr>
					<th width="10%">
						序号
					</th>
					<th width="30%">
						名称
					</th>
					<th width="20%">
						排序
					</th>
					<th width="20%" style="vertical-align: middle; text-align: center;">
						检查详情
					</th>
					<th width="20%">
						<i class="fa fa-plus" style="font-size: 20px;color: #1a83de;" onclick="openAddPage(1)"></i>
					</th>
				</tr>
			</thead>
			<tbody id="tbodyData1">
				<c:if test="${empty listMap}">
					<tr align="center">
						<td colspan="4">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr1${info.checklist_class_id}" class="" data-id="${info.checklist_class_id}">
						<td index="tdIndex" style="vertical-align: middle;" onclick="selectData('1','${info.checklist_class_id}')">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;" onclick="selectData('1','${info.checklist_class_id}')">
							${info.checklist_class_name}
						</td>
						<td style="vertical-align: middle;" onclick="selectData('1','${info.checklist_class_id}')">
							${info.checklist_class_sort}
						</td>
						<td style="vertical-align: middle; text-align: center;">
							<i class="fa fa-eye" style="font-size: 18px;color: #1a83de;" onclick="openlookInfo('${info.checklist_class_id}','${info.checklist_class_name}')"></i>&nbsp;&nbsp;
						</td>
						<td style="vertical-align: middle;">
							<i class="fa fa-pencil-square-o" style="font-size: 18px;color: #1a83de;" onclick="openEditPage('1','${info.checklist_class_id}')"></i>&nbsp;&nbsp;
							<i class="fa fa-trash-o" style="font-size: 18px;color: red" onclick="confirmDeleteDate('1','${info.checklist_class_id}')"></i>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table id="sample-table-1" class="table  table-bordered dataTable" style="width: 33.3%;"> 
			<thead>
				<tr>
					<th style="text-align: center;" colspan="5">
						二级分类
					</th>
				</tr>
				<tr>
					<th width="10%">
						序号
					</th>
					<th width="30%">
						名称
					</th>
					<th width="20%">
						排序
					</th>
					<th width="20%" style="vertical-align: middle; text-align: center;">
						检查详情
					</th>
					<th width="20%">
						<i class="fa fa-plus" style="font-size: 20px;color: #1a83de;" onclick="openAddPage(2)" ></i>
					</th>
				</tr>
			</thead>
			<tbody id="tbodyData2">
					<tr align="center">
						<td colspan="5">
							请选择一级分类
						</td>
					</tr>
			</tbody>
		</table>
		<table id="sample-table-1" class="table  table-bordered dataTable" style="width: 33.3%;"> 
			<thead>
				<tr>
					<th style="text-align: center;" colspan="5">
						三级分类
					</th>
				</tr>
				<tr>
					<th width="10%">
						序号
					</th>
					<th width="30%">
						名称
					</th>
					<th width="20%">
						排序
					</th>
					<th width="20%" style="vertical-align: middle; text-align: center;">
						检查详情
					</th>
					<th width="20%">
						<i class="fa fa-plus" style="font-size: 20px;color: #1a83de;" onclick="openAddPage(3)"></i>
					</th>
				</tr>
			</thead>
			<tbody id="tbodyData3">
				<tr align="center">
						<td colspan="5">
							请选择二级分类
						</td>
					</tr>
			</tbody>
		</table>
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
<script src="${root}/form/util/checklist/checklistClass/js/utilchecklistclass_main.js?<%=Math.random()%>"></script>
<script src="${root}/form/util/checklist/checklistClass/details/utilChecklist/js/utilChecklist.js?<%=Math.random()%>"></script>
</body>
</html>