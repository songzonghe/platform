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
<link rel="stylesheet" href="${root}/form_util/util/util_css/jquery.searchableSelect.css" />
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
						处方模板管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilPrescription_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										分类名称
									</label>
									<input type="text" id="query_icd_name" placeholder="分类名称" value="${map.icd_name}">
									
									<label>
										诊段名称
									</label>
									<input type="text" id="query_diagnosis_name" placeholder="诊段名称" value="${map.diagnosis_name}">
									
									<label>
										医生名称
									</label>
									<input type="text" id="query_doctor_name" placeholder="医生名称" value="${map.doctor_name}">
									<button type="submit" onclick="queryUtilPrescription(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
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
					<th width="50px">
						
					</th>
					<th field="icd_id"   onclick="querySort(this,'queryUtilPrescription')"  >
						分类名称
					</th>
					<th field="diagnosis_id"   onclick="querySort(this,'queryUtilPrescription')"  >
						诊段名称
					</th>
					<th field="doctor_id"   onclick="querySort(this,'queryUtilPrescription')"  >
						医生名称
					</th>
					<th field="prescription_type"   onclick="querySort(this,'queryUtilPrescription')"  >
						处方类型
					</th>
					<th field="prescription_price" type="num"  onclick="querySort(this,'queryUtilPrescription')"  >
						处方金额
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryUtilPrescription')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryUtilPrescription')">
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
						<td colspan="55">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.prescription_id}"  isOpen="n">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							<img style="cursor: pointer;" id="img${info.prescription_id}"
								onclick="mainDetail('${info.prescription_id}')" isOpen="n"
								src="${root}/form_util/util/images/nolines_plus.gif">
							
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
							<c:if test="${info.prescription_type=='1'}">中药</c:if>
							<c:if test="${info.prescription_type=='2'}">西药</c:if>
							<c:if test="${info.prescription_type=='3'}">中成药</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.prescription_price}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.prescription_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.prescription_id}','${info.prescription_id}')" title="删除">
								删除
							</button>
							<button class="btn btn-xs btn-primary" title="处方详情" onclick="add_utilPrescriptionDetailsPage('${info.prescription_id}','${info.prescription_type}')" >
								<i class="ace-icon fa fa-plus bigger-120"></i>
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryUtilPrescription" />
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
<script src="${root}/form/util/prescription/js/utilprescription_main.js?<%=Math.random()%>"></script>
<script src="${root}/form/util/prescription/details/utilPrescriptionDetails/js/utilPrescriptionDetails.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/sys_js/jquery.searchableSelect.js?<%=Math.random()%>"></script>
</body>
</html>