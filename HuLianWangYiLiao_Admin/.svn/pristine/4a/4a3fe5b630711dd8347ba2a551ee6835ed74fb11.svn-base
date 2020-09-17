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
						业务开展情况管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilHospitalInstitutionBusiness_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										月份
									</label>
									<input type="text" id="query_business_nf" placeholder="月份" value="${map.business_nf}">
									<button type="submit" onclick="queryUtilHospitalInstitutionBusiness(0)" class="btn btn-sm btn-success">
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
					<th field="business_nf"   onclick="querySort(this,'queryUtilHospitalInstitutionBusiness')"  >
						月份
					</th>
					<th field="business_pcjgsl"   onclick="querySort(this,'queryUtilHospitalInstitutionBusiness')"  >
						机构数量
					</th>
					<th field="business_zgzs"   onclick="querySort(this,'queryUtilHospitalInstitutionBusiness')"  >
						职工总数
					</th>
					<th field="business_khffryzs"   onclick="querySort(this,'queryUtilHospitalInstitutionBusiness')"  >
						人员总数
					</th>
					<th field="business_zzch"   onclick="querySort(this,'queryUtilHospitalInstitutionBusiness')"  >
						总资产
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryUtilHospitalInstitutionBusiness')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryUtilHospitalInstitutionBusiness')">
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
						<td colspan="194">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.business_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.business_nf}
						</td>
						<td style="vertical-align: middle;">
							机构数量：${info.business_pcjgsl}<br>
							部署平台：
							<c:if test="${info.business_bspt=='01'}">自建</c:if>
							<c:if test="${info.business_bspt=='02'}">阿里云</c:if>
							<c:if test="${info.business_bspt=='03'}">腾讯云</c:if>
							<c:if test="${info.business_bspt=='04'}">天翼云</c:if>
							<c:if test="${info.business_bspt=='05'}">沃云</c:if>
							<c:if test="${info.business_bspt=='90'}">其他</c:if><br>
							架构图地址：${info.business_wljgtdz}<br>
							架构描述：${info.business_jgmsxx}
						</td>
						<td style="vertical-align: middle;">
							机房面积：${info.business_jfmj}<br>
							职工总数：${info.business_zgzs}<br>
							人员总数：${info.business_khffryzs}<br>
							用房面积：${info.business_ywyfmj}
						</td>
						<td style="vertical-align: middle;">
							总收入：${info.business_zsr}<br>
							总支出：${info.business_zzc}<br>
							总资产：${info.business_zzch}<br>
							流动资产：${info.business_ldzc}
						</td>
						<td style="vertical-align: middle;">
							对外投资：${info.business_dwtz}<br>
							固定资产：${info.business_gdzc}<br>
							无形资产：${info.business_wxzcjkbf}<br>
							负债：${info.business_fz}<br>
							净资产${info.business_jzc}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.business_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.business_id}','${info.business_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryUtilHospitalInstitutionBusiness" />
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
<script src="${root}/form/util/hospital/institution/business/js/utilhospitalinstitutionbusiness_main.js?<%=Math.random()%>"></script>
</body>
</html>