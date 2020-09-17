<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
						处方审核管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="inquiryLogPrescription_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										患者名字
									</label>
									<input type="text" id="query_inquiry_patient_name" placeholder="患者名字" value="${map.inquiry_patient_name}">
									<label>
										医生名字
									</label>
									<input type="text" id="query_doctor_name" placeholder="医生名字" value="${map.doctor_name}">
									<label>
										状态
									</label>
									<select id="query_find_zt" >
										<option value="">请选择</option>
										<option <c:if test="${map.find_zt=='1'}">selected="selected"</c:if> value="1">已查看</option>
										<option <c:if test="${map.find_zt=='0'}">selected="selected"</c:if> value="0">审核成功</option>
										<option <c:if test="${map.find_zt=='2'}">selected="selected"</c:if> value="2">审核中</option>
										<option <c:if test="${map.find_zt=='5'}">selected="selected"</c:if> value="5">不通过</option>
										<option <c:if test="${map.find_zt=='6'}">selected="selected"</c:if> value="6">已作废</option>
									</select>
									<button type="submit" onclick="queryInquiryLogPrescription(0)" class="btn btn-sm btn-success">
										搜索
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
					<th field="join_type"   onclick="querySort(this,'queryInquiryLogPrescription')"  >
						个人/门店
					</th>
					<th field="inquiry_patient_id"   onclick="querySort(this,'queryInquiryLogPrescription')"  >
						名字
					</th>
					<th field="prescription_type"   onclick="querySort(this,'queryInquiryLogPrescription')"  >
						处方类型
					</th>
					<th field="prescription_price"  type="num"   onclick="querySort(this,'queryInquiryLogPrescription')"  >
						处方金额
					</th>
					<th field="zt"   onclick="querySort(this,'queryInquiryLogPrescription')"  >
						审核状态
					</th>
					<th field="lrsj" width="170" onclick="querySort(this,'queryInquiryLogPrescription')">
						开方时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryInquiryLogPrescription')">
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
						<td colspan="115">
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
							<c:if test="${info.join_type=='1'}">个人</c:if>
							<c:if test="${info.join_type=='2'}">门店</c:if>
						</td>
						<td style="vertical-align: middle;">
							问诊名字：${info.inquiry_patient_name}<br>
							医生名字：${info.doctor_name}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.prescription_type=='1'}">中药</c:if>
							<c:if test="${info.prescription_type=='2'}">西药</c:if>
							<c:if test="${info.prescription_type=='3'}">中成药</c:if>
						</td>
						<td style="vertical-align: middle;">
							处方金额：${info.prescription_price}<br>
							付数：${info.prescription_num}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.zt=='1'}">已查看</c:if>
							<c:if test="${info.zt=='0'}">审核通过</c:if>
							<c:if test="${info.zt=='2'}">审核中</c:if>
							<c:if test="${info.zt=='5'}"><span style="color:red">不通过</span>
					    	<br>药师:${info.prescription_audited_doctor}<br>
							原因:${info.prescription_reasons_invalidation}<br>
							时间:${info.prescription_audited_data}<br>
							</c:if>
							<c:if test="${info.zt=='6'}">已作废<br>
								原因:${info.prescription_reasons_invalidation}<br>
							</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.zt==2}">
								<button class="btn btn-xs btn-info" onclick="openEditPage('${info.prescription_id}','edit')" title="审核">
									审核
								</button>
							</c:if>
							<c:if test="${info.zt==0 or info.zt==1}">
								 <button class="btn btn-xs btn-info" onclick="openEditPage('${info.prescription_id}','look')" title="查看">
									查看
								</button>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryInquiryLogPrescription" />
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
<script src="${root}/form/inquiry/log/prescription/js/inquirylogprescription_main.js?<%=Math.random()%>"></script>
<script src="${root}/form/inquiry/log/prescription/details/inquiryLogPrescriptionDetails/js/inquiryLogPrescriptionDetails.js?<%=Math.random()%>"></script>
</body>
</html>