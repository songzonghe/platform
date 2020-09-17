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
<!-- 返回回来参数 健康指导管理-->
<%@include file="/form_util/page/hidden.jsp"%>
<div class="main-container box" id="main-container">
	<div class="page-content">
		<div class="row">
			<div class="widget-box">
			<div class="widget-header">
				<ul class="tab-list">
					<li class="active" onclick="changeDataType('1')">健康指导管理</li>
					<li onclick="changeDataType('2')">问诊检验单</li>
					<li onclick="changeDataType('3')">检查单详情</li>
					<li onclick="changeDataType('4')">问诊处方</li>
					<li onclick="changeDataType('5')">处方详情</li>
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
									医生
								</label>
								<input type="text" id="query_drug_name" placeholder="医生" value="${map.doctor_name}">
								
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
	<div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline no-footer"> 
		<table id="sample-table-1" class="table  table-bordered dataTable"> 
			<thead>
				<tr>
					<th width="50px">
						序号
					</th>
					<th field="log_id"   onclick="querySort(this,'queryInquiryLogHealthGuidance')"  >
						记录
					</th>
					<th field="inquiry_patient_id"   onclick="querySort(this,'queryInquiryLogHealthGuidance')"  >
						问诊患者
					</th>
					<th field="doctor_id"   onclick="querySort(this,'queryInquiryLogHealthGuidance')"  >
						医生
					</th>
					<th field="guidance_content"   onclick="querySort(this,'queryInquiryLogHealthGuidance')"  >
						指导内容
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryInquiryLogHealthGuidance')">
						修改时间
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
					<tr id="tr${info.guidance_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.log_id}
						</td>
						<td style="vertical-align: middle;">
							${info.user_nickname}
						</td>
						<td style="vertical-align: middle;">
							${info.doctor_name}
						</td>
						<td style="vertical-align: middle;">
							${info.guidance_content}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryInquiryLogHealthGuidance" />
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