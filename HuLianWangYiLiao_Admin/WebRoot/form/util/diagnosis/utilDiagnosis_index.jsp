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
						诊断模板
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilDiagnosis_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										分类名称
									</label>
									<input type="text" id="query_icd_id" placeholder="分类名称" value="${map.icd_name}">
									
									<label>
										诊段名称
									</label>
									<input type="text" id="query_diagnosis_name" placeholder="诊段名称" value="${map.diagnosis_name}">
									
									<label>
										医生
									</label>
									<input type="text" id="query_doctor_id" placeholder="医生" value="${map.doctor_name}">
									<button type="submit" onclick="queryUtilDiagnosis(0)" class="btn btn-sm btn-success">
										搜索
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
									</button>
									<button type="button" onclick="openImportBoxPage('util_icd','queryUtilDiagnosis')" class="btn btn-sm btn-info">
										导入
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
					<th field="icd_id"   onclick="querySort(this,'queryUtilDiagnosis')"  >
						分类名称
					</th>
					<th field="diagnosis_name"   onclick="querySort(this,'queryUtilDiagnosis')"  >
						诊段名称
					</th>
					<th field="doctor_id"   onclick="querySort(this,'queryUtilDiagnosis')"  >
						医生
					</th>
					<th field="diagnosis_sex"   onclick="querySort(this,'queryUtilDiagnosis')"  >
						性别限制
					</th>
					<th field="diagnosis_dage"  type="num"   onclick="querySort(this,'queryUtilDiagnosis')"  >
						最低年龄
					</th>
					<th field="diagnosis_tage"  type="num"   onclick="querySort(this,'queryUtilDiagnosis')"  >
						最高年龄
					</th>
					<th field="is_restriction"   onclick="querySort(this,'queryUtilDiagnosis')"  >
						使用限制
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryUtilDiagnosis')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryUtilDiagnosis')">
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
					<tr id="tr${info.diagnosis_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.icd_name}
						</td>
						<td style="vertical-align: middle;">
							${info.diagnosis_name}
						</td>
						<td style="vertical-align: middle;">
							${info.doctor_name}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.diagnosis_sex=='1'}">男</c:if>
							<c:if test="${info.diagnosis_sex=='2'}">女</c:if>
							<c:if test="${info.diagnosis_sex=='3'}">不限制</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.diagnosis_dage}
						</td>
						<td style="vertical-align: middle;">
							${info.diagnosis_tage}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.is_restriction=='0'}">否</c:if>
							<c:if test="${info.is_restriction=='1'}">是</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.diagnosis_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.diagnosis_id}','${info.diagnosis_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryUtilDiagnosis" />
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
<script src="${root}/form/util/diagnosis/js/utildiagnosis_main.js?<%=Math.random()%>"></script>
</body>
</html>