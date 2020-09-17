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
						网络医院问诊患者信息管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="inquiryPatientInfo_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									
									<label>
										关联类型
									</label>
									<select id="query_join_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.join_type=='1'}">selected="selected"</c:if> value="1">个人</option>
										<option <c:if test="${map.join_type=='1'}">selected="selected"</c:if> value="1">个人</option>
									</select>
									
									<%-- <label>
										关联名称
									</label>
									<input type="text" id="query_join_id" placeholder="关联名称" value="${map.join_id}">
									 --%>
									<label>
										问诊类型
									</label>
									<select id="query_inquiry_patient_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.inquiry_patient_type=='0'}">selected="selected"</c:if> value="0">为自己问诊</option>
										<option <c:if test="${map.inquiry_patient_type=='1'}">selected="selected"</c:if> value="1">为别人问诊</option>
									</select>
									
									<label>
										姓名
									</label>
									<input type="text" id="query_inquiry_patient_name" placeholder="姓名" value="${map.inquiry_patient_name}">
									<button type="submit" onclick="queryInquiryPatientInfo(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<!-- <button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
										<i class="ace-icon fa fa-plus icon-on-right bigger-110"></i>
									</button> -->
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
					<th field="join_type"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						关联类型
					</th>
					<!-- <th field="join_id"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						关联名称
					</th> -->
					<th field="inquiry_patient_type"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						问诊类型
					</th>
					<th field="inquiry_patient_img"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						头像
					</th>
					<th field="inquiry_patient_name"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						姓名
					</th>
					<th field="inquiry_patient_idcard"  type="num"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						身份证号码
					</th>
					<th field="inquiry_patient_sex"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						性别
					</th>
					<th field="inquiry_patient_birthday"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						出生日期
					</th>
					<th field="inquiry_patient_phone"  type="num"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						手机号
					</th>
					<th field="inquiry_patient_marital_status"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						籍贯
					</th>
					<th field="inquiry_patient_weight"  type="num"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						体重
					</th>
					<th field="inquiry_patient_profession_code"  type="num"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						职业编号
					</th>
					<th field="inquiry_patient_profession"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						职业
					</th>
					<th field="inquiry_patient_address"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						住址
					</th>
					<th field="is_drug_allergy"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						是否药物过敏
					</th>
					<th field="iinquiry_patient_allergy_details"   onclick="querySort(this,'queryInquiryPatientInfo')"  >
						药物过敏史
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryInquiryPatientInfo')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryInquiryPatientInfo')">
						备注
					</th>
					<!-- <th width="180">
						操作
					</th> -->
				</tr>
			</thead>
			<tbody id="tbodyData">
				<c:if test="${empty listMap}">
					<tr align="center">
						<td colspan="164">
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
							<c:if test="${info.join_type=='1'}">个人</c:if>
							<c:if test="${info.join_type=='2'}">门店</c:if>
						</td>
						<%-- <td style="vertical-align: middle;">
							${info.join_id}
						</td> --%>
						<td style="vertical-align: middle;">
							<c:if test="${info.inquiry_patient_type=='0'}">为自己问诊</c:if>
							<c:if test="${info.inquiry_patient_type=='1'}">为别人问诊</c:if>
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.inquiry_patient_img}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_name}
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_idcard}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.inquiry_patient_sex=='0'}">男</c:if>
							<c:if test="${info.inquiry_patient_sex=='1'}">女</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_birthday}
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_phone}
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_marital_status}
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_weight}
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_profession_code}
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_profession}
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_address}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.is_drug_allergy=='0'}">否</c:if>
							<c:if test="${info.is_drug_allergy=='1'}">是</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.iinquiry_patient_allergy_details}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<%-- <td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.inquiry_patient_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.inquiry_patient_id}','${info.inquiry_patient_id}')" title="删除">
								删除
							</button>
						</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryInquiryPatientInfo" />
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
<script src="${root}/form/inquiry/patient/info/js/inquirypatientinfo_main.js?<%=Math.random()%>"></script>
</body>
</html>