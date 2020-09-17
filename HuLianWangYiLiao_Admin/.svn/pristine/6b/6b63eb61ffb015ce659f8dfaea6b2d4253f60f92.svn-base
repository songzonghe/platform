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
						问诊患者测量数据管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="inquiryPatientMeasuredData_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									
									<label>
										问诊
									</label>
									<input type="text" id="query_inquiry_patient_id" placeholder="问诊" value="${map.inquiry_patient_id}">
									
									<label>
										类型
									</label>
									<select id="query_join_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.join_type=='1'}">selected="selected"</c:if> value="1">个人</option>
										<option <c:if test="${map.join_type=='2'}">selected="selected"</c:if> value="2">门店</option>
									</select>
									
									<label>
										关联
									</label>
									<input type="text" id="query_join_id" placeholder="关联" value="${map.join_id}">
									<button type="submit" onclick="queryInquiryPatientMeasuredData(0)" class="btn btn-sm btn-success">
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
					<th field="inquiry_patient_id"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						问诊
					</th>
					<th field="join_type"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						类型
					</th>
					<th field="join_id"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						关联
					</th>
					<th field="data_animal_heat"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						体温
					</th>
					<th field="data_sbp"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						收缩压
					</th>
					<th field="data_dbp"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						舒张压
					</th>
					<th field="data_heart_rate"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						心率
					</th>
					<th field="data_rr"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						呼吸频率
					</th>
					<th field="data_glu"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						血糖
					</th>
					<th field="data_condition"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						测量条件
					</th>
					<th field="data_parameter"   onclick="querySort(this,'queryInquiryPatientMeasuredData')"  >
						测量参数
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryInquiryPatientMeasuredData')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryInquiryPatientMeasuredData')">
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
						<td colspan="124">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.data_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_id}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.join_type=='1'}">个人</c:if>
							<c:if test="${info.join_type=='2'}">门店</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.join_id}
						</td>
						<td style="vertical-align: middle;">
							${info.data_animal_heat}
						</td>
						<td style="vertical-align: middle;">
							${info.data_sbp}
						</td>
						<td style="vertical-align: middle;">
							${info.data_dbp}
						</td>
						<td style="vertical-align: middle;">
							${info.data_heart_rate}
						</td>
						<td style="vertical-align: middle;">
							${info.data_rr}
						</td>
						<td style="vertical-align: middle;">
							${info.data_glu}
						</td>
						<td style="vertical-align: middle;">
							${info.data_condition}
						</td>
						<td style="vertical-align: middle;">
							${info.data_parameter}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.data_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.data_id}','${info.data_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryInquiryPatientMeasuredData" />
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
<script src="${root}/form/inquiry/patient/measured/data/js/inquirypatientmeasureddata_main.js?<%=Math.random()%>"></script>
</body>
</html>