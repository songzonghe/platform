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
						问诊记录检验单管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="inquiryLogChecklist_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										问诊患者
									</label>
									<input type="text" id="query_inquiry_patient_id" placeholder="问诊患者" value="${map.inquiry_patient_id}">
									
									<label>
										医生
									</label>
									<input type="text" id="query_doctor_id" placeholder="医生" value="${map.doctor_id}">
									
									<label>
										检验单名称
									</label>
									<input type="text" id="query_checklist_name" placeholder="检验单名称" value="${map.checklist_name}">
									
									<label>
										检验单号
									</label>
									<input type="text" id="query_checklist_code" placeholder="检验单号" value="${map.checklist_code}">
									<button type="submit" onclick="queryInquiryLogChecklist(0)" class="btn btn-sm btn-success">
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
					<th width="50px">
						
					</th>
					<th field="hospital_id"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						医院
					</th>
					<th field="log_id"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						问诊记录
					</th>
					<th field="join_type"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						类型
					</th>
					<!-- <th field="join_id"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						关联
					</th> 
					<th field="inquiry_patient_id"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						问诊患者
					</th>-->
					<th field="doctor_id"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						名字
					</th>
					<th field="checklist_name"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						名称
					</th>
					<!-- <th field="checklist_code"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						检验单号
					</th> 
					<th field="checklist_type"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						检验类型
					</th>-->
					<th field="checklist_last_code"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						上次单号
					</th>
					<th field="checklist_abstract"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						摘要
					</th>
					<th field="checklist_sbp"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						压
					</th>
					<!-- <th field="checklist_dbp"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						舒张压
					</th> -->
					<th field="is_digitalization"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						是否使用过洋地黄
					</th>
					<!-- <th field="checklist_digitalization_num"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						使用洋地黄用量
					</th>
					<th field="checklist_digitalization_start"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						使用洋地黄开始时间
					</th>
					<th field="checklist_digitalization_end"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						使用洋地黄结束时间
					</th> -->
					<th field="is_other_drugs"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						有关药物
					</th>
					<!--<th field="checklist_other_drugs_name"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						有关药物名称
					</th>
					 <th field="checklist_other_drugs_start"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						有关药物开始时间
					</th>
					<th field="checklist_other_drugs_end"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						有关药物结束时间
					</th> -->
					<th field="checklist_other_drugs_num"   onclick="querySort(this,'queryInquiryLogChecklist')"  >
						有关药物
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryInquiryLogChecklist')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryInquiryLogChecklist')">
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
						<td colspan="235">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.checklist_id}"  isOpen="n">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							<img style="cursor: pointer;" id="img${info.checklist_id}"
								onclick="mainDetail('${info.checklist_id}')" isOpen="n"
								src="${root}/form_util/util/images/nolines_plus.gif">
							
						</td>
						<td style="vertical-align: middle;">
							${info.log_id}
						</td>
						<td style="vertical-align: middle;">
							类型：${info.join_type}<br>
							关联：${info.join_id}
						</td>
						<td style="vertical-align: middle;">
							问诊者：${info.inquiry_patient_id}<br>
							医生名字：${info.doctor_id}
						</td>
						<td style="vertical-align: middle;">
							检验单名称：${info.checklist_name}<br>
							检验单号：${info.checklist_code}<br>
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.checklist_type=='1'}">普通建议单</c:if>
							<c:if test="${info.checklist_type=='2'}">心电检验单</c:if>
							<c:if test="${info.checklist_type=='3'}">普通检验单</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.checklist_last_code}
						</td>
						<td style="vertical-align: middle;">
							${info.checklist_abstract}
						</td>
						<td style="vertical-align: middle;">
							收缩压：${info.checklist_sbp}<br>
							舒张压：${info.checklist_dbp}
						</td>
						<td style="vertical-align: middle;">
							是否使用过洋地黄：<c:if test="${info.is_digitalization=='0'}">否</c:if>
							<c:if test="${info.is_digitalization=='1'}">是</c:if><br>
							使用过洋地黄用量：${info.checklist_digitalization_num}
						</td>
						<%-- <td style="vertical-align: middle;">
							开始时间：${info.checklist_digitalization_start}<br>
							结束时间：${info.checklist_digitalization_end}
						</td> --%>
						<td style="vertical-align: middle;">
							是否使用有关药物：<c:if test="${info.is_other_drugs=='0'}">否</c:if>
							<c:if test="${info.is_other_drugs=='1'}">是</c:if><br>
							药物名称：${info.checklist_other_drugs_name}
						</td>
						<%-- <td style="vertical-align: middle;">
							${info.checklist_other_drugs_start}
						</td>
						<td style="vertical-align: middle;">
							${info.checklist_other_drugs_end}
						</td> --%>
						<td style="vertical-align: middle;">
							有关药物用量：${info.checklist_other_drugs_num}<br>
							有关检验结果：${info.checklist_inspection_result}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.checklist_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.checklist_id}','${info.checklist_id}')" title="删除">
								删除
							</button>
							<button class="btn btn-xs btn-primary" title="问诊记录检验检查单详情" onclick="add_inquiryLogChecklistDetailsPage('${info.checklist_id}')" >
								<i class="ace-icon fa fa-plus bigger-120"></i>
							</button>
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
<script src="${root}/form/inquiry/log/checklist/js/inquirylogchecklist_main.js?<%=Math.random()%>"></script>
<script src="${root}/form/inquiry/log/checklist/details/inquiryLogChecklistDetails/js/inquiryLogChecklistDetails.js?<%=Math.random()%>"></script>
</body>
</html>