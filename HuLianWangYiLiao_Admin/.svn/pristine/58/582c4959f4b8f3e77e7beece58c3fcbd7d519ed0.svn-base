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
						网络医院问诊记录管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="inquiryLog_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										问诊患者
									</label>
									<input type="text" id="query_inquiry_patient_name" placeholder="问诊患者" value="${map.inquiry_patient_name}">
									
									<label>
										医生
									</label>
									<input type="text" id="query_doctor_name" placeholder="医生" value="${map.doctor_name}">
									<button type="submit" onclick="queryInquiryLog(0)" class="btn btn-sm btn-success">
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
					<th field="log_type"   onclick="querySort(this,'queryInquiryLog')"  >
						问诊类型
					</th>
					<th field="join_id" onclick="querySort(this,'queryInquiryLog')"  >
						关联
					</th>
					<th field="inquiry_patient_id"   onclick="querySort(this,'queryInquiryLog')"  >
						人员
					</th>
					<th field="log_main_suit"   onclick="querySort(this,'queryInquiryLog')"  >
						主诉
					</th>
					<th field="log_history_present_illness"   onclick="querySort(this,'queryInquiryLog')"  >
						病史
					</th>
					<th field="lof_diagnosis"   onclick="querySort(this,'queryInquiryLog')"  >
						诊断
					</th>
					<th field="unprescribed_reasons"   onclick="querySort(this,'queryInquiryLog')"  >
						未开原因
					</th>
					
					<th field="gxsj" width="170" onclick="querySort(this,'queryInquiryLog')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryInquiryLog')">
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
					<tr id="tr${info.log_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.log_type=='1'}">视频问诊</c:if>
							<c:if test="${info.log_type=='2'}">图文问诊</c:if>
						</td>
						<td style="vertical-align: middle;">
							类型：<c:if test="${info.join_type=='1'}">个人</c:if>
								<c:if test="${info.join_type=='2'}">门店</c:if><br>
							关联：${info.join_id}
						</td>
						<td style="vertical-align: middle;">
							患者：${info.inquiry_patient_name}<br>
							医生：${info.doctor_name}
						</td>
						<td style="vertical-align: middle;">
							记录来源：${info.log_source}<br>
							主诉：${info.log_main_suit}
						</td>
						<td style="vertical-align: middle;">
							现病史:${info.log_present_illness}<br>
							既往史:${info.log_history_present_illness}
						</td>
						<td style="vertical-align: middle;">
							${info.lof_diagnosis}
						</td>
						<td style="vertical-align: middle;">
							${info.unprescribed_reasons}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
						<button class="btn btn-xs btn-info" onclick="openEditPage('${info.log_id}')" title="编辑">
							编辑
						</button>
						<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.log_id}','${info.log_id}')" title="删除">
							删除
						</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryInquiryLog" />
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
<script src="${root}/form/inquiry/log/js/inquirylog_main.js?<%=Math.random()%>"></script>
</body>
</html>