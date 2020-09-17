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
							咨询用户报表
						</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="reportForm_inquiry_user_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
		 						<fieldset>
									<label>问诊时间</label>
									<input type="text" id="query_beginTime" placeholder="起始时间" value="${map.beginTime}" readonly="readonly" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'query_endTime\')}'})">
									~~
									<input type="text" id="query_endTime" placeholder="终止时间" value="${map.endTime}" readonly="readonly" onclick="WdatePicker({minDate:'#F{$dp.$D(\'query_beginTime\')}'})">
									
									<label>
										问诊类型
									</label>
									<select id="query_log_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.log_type=='1'}">selected="selected"</c:if> value="1">视频问诊</option>
										<option <c:if test="${map.log_type=='2'}">selected="selected"</c:if> value="2">图文问诊</option>
									</select>
									
									<label>
										用户来源
									</label>
									<select id="query_join_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.join_type=='1'}">selected="selected"</c:if> value="1">个人</option>
										<option <c:if test="${map.join_type=='2'}">selected="selected"</c:if> value="2">门店</option>
									</select>
									
									<button type="submit" onclick="queryInquiryUser(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									
									<button  type="button" onclick="confirmExportExcel()" class="btn btn-sm btn-pink">
										导出excel
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
					<th  >
						用户姓名
					</th>
					<th   >
						性别
					</th>
					<th   >
						年龄
					</th>
					<th  >
						联系电话
					</th>
					<th >
						证件号码
					</th>
					<th  >
						问诊类型
					</th>
					<th >
						用户来源
					</th>
					<th >
						咨询时间
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
					<tr id="tr${info.inquiry_patient_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						
						<td style="vertical-align: middle;">
							${info.inquiry_patient_name}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.inquiry_patient_sex=='0'}">男</c:if>
							<c:if test="${info.inquiry_patient_sex=='1'}">女</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.patientAge}
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_phone}
						</td>
						
						<td style="vertical-align: middle;">
							${info.inquiry_patient_idcard}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.log_type=='1'}">视频问诊</c:if>
							<c:if test="${info.log_type=='2'}">图文问诊</c:if>
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.join_type=='1'}">个人</c:if>
							<c:if test="${info.join_type=='2'}">门店</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryInquiryUser" />
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
<script src="${root}/form/reportForm/js/reportForm_main.js?<%=Math.random()%>"></script>
</body>
</html>