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
						我的用药管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="doctorDrug_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									
									<label>
										医生名称
									</label>
									<input type="text" id="query_doctor_id" placeholder="医生名称" value="${map.doctor_id}">
									
									<label>
										药品名称
									</label>
									<input type="text" id="query_drug_id" placeholder="药品名称" value="${map.drug_id}">
									
									<label>
										药品l类型
									</label>
									<select id="query_drug_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.drug_type=='1'}">selected="selected"</c:if> value="1">中药</option>
										<option <c:if test="${map.drug_type=='2'}">selected="selected"</c:if> value="2">西药</option>
									</select>
									<button type="submit" onclick="queryDoctorDrug(0)" class="btn btn-sm btn-success">
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
					<th width="120" field="doctor_id"   onclick="querySort(this,'queryDoctorDrug')"  >
						医生名称
					</th>
					<th width="280" field="drug_id"   onclick="querySort(this,'queryDoctorDrug')"  >
						药品名称
					</th>
					<th width="280" field="doctor_drug_frequency_str"   onclick="querySort(this,'queryDoctorDrug')"  >
						频率文字
					</th>
					<th width="280" field="doctor_drug_day"   onclick="querySort(this,'queryDoctorDrug')"  >
						天数
					</th>
					<th width="180" field="gxsj" width="170" onclick="querySort(this,'queryDoctorDrug')">
						修改时间
					</th>
					<th width="180" field="bz"  onclick="querySort(this,'queryDoctorDrug')">
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
						<td colspan="114">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.doctor_drug_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.doctor_id}
						</td>
						<td style="vertical-align: middle;">
							药品：${info.drug_id}<br>
							药品类型：<c:if test="${info.drug_type=='1'}">中药</c:if>
									<c:if test="${info.drug_type=='2'}">西药</c:if><br>
							用量：${info.doctor_drug_consumption}<br>
							
						</td>
						<td style="vertical-align: middle;">
							频繁文字：${info.doctor_drug_frequency_str}<br>
							频繁：${info.doctor_drug_frequency}
						</td>
						<td style="vertical-align: middle;">
							天数：${info.doctor_drug_day}<br>
							数量：${info.doctor_drug_num}<br>
							用法：${info.doctor_drug_usage}<br>
							嘱咐：${info.doctor_drug_entrust}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.doctor_drug_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.doctor_drug_id}','${info.doctor_drug_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryDoctorDrug" />
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
<script src="${root}/form/doctor/drug/js/doctordrug_main.js?<%=Math.random()%>"></script>
</body>
</html>