<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/form_util/page/root.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${root}/form/main/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="${root}/form/main/assets/css/font-awesome.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/ace-fonts.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/ace.css" />
<link rel="stylesheet" href="${root}/form_util/util/util_css/myPage.css" />
</head>
<body class="no-skin">
	<!-- 返回回来参数 处方详情  -->
<%@include file="/form_util/page/hidden.jsp"%>
<div class="main-container box" id="main-container">
	<div class="page-content">
		<div class="row">
			<div class="widget-box">
				<div class="widget-header">
					<ul class="tab-list">
						<li onclick="changeDataType('1')">健康指导管理</li>
						<li onclick="changeDataType('2')">问诊检验单</li>
						<li onclick="changeDataType('3')">检查单详情</li>
						<li onclick="changeDataType('4')">问诊处方</li>
						<li class="active" onclick="changeDataType('5')">处方详情</li>
						<li onclick="changeDataType('6')">住院建议</li>
						<li onclick="changeDataType('7')">上传图片</li>
					</ul>
				</div>
				<div class="widget-body">
					<div class="widget-main no-padding">
						<form action="inquiryLog_getInquiryLogDetailsPage.do" id="findForm" method="post">
							<!-- 参数隐藏 用于页面传值-->
							<input style="display: none;" id="findMapStr" name="mapStr">
							<input style="display: none;" id="data_type" value="${map.data_type}">
							
							<fieldset>
							<input type="hidden" id="find_log_id" value="${map.log_id}">
							<input type="hidden" id="find_data_type" value="${map.data_type}">
								<label>
									药品
								</label>
								<input type="text" id="query_drug_name" placeholder="药品" value="${map.drug_name}">
								<button type="submit" onclick="findInquiryInfo(0)" class="btn btn-sm btn-success">
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
	<div id="sample-table-2_wrapper"
		class="dataTables_wrapper form-inline no-footer">
		<table id="sample-table-1" class="table  table-bordered dataTable">
			<thead>
				<tr>
					<th width="50px"></th>
					<th>处方</th>
					<th>药品</th>
					<th>用量</th>
					<th>频率文字</th>
					<th>频率</th>
					<th>天数</th>
					<th>数量</th>
					<th>用法</th>
					<th>嘱托</th>
					<th>修改时间</th>
				</tr>
			</thead>
			<tbody id="dataTbody_inquiryLogPrescriptionDetails${map.prescription_id}">
				<c:if test="${empty listMap}">
					<tr align="center">
						<td colspan="100">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="map">
					<tr id="tr${map.prescription_details_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${map.prescription_id}
						</td>
						<td style="vertical-align: middle;">
							${map.drug_name}
						</td>
						<td style="vertical-align: middle;">
							${map.details_consumption}
						</td>
						<td style="vertical-align: middle;">
							${map.details_frequency_str}
						</td>
						<td style="vertical-align: middle;">
							${map.details_frequency}
						</td>
						<td style="vertical-align: middle;">
							${map.details_day}
						</td>
						<td style="vertical-align: middle;">
							${map.details_num}
						</td>
						<td style="vertical-align: middle;">
							${map.details_usage}
						</td>
						<td style="vertical-align: middle;">
							${map.details_entrust}
						</td>
						<td style="vertical-align: middle;">
							${map.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${map.bz}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryInquiryLogChecklist" />
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
<script src="${root}/form/inquiryLogs/page/inquiryLog.js?<%=Math.random()%>"></script>
</body>
</html>