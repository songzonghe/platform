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
						医院管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilHospital_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									
									<label>
										帐号
									</label>
									<input type="text" id="query_hospital_number" placeholder="帐号" value="${map.hospital_number}">
									<c:if test="${map.login_account_type!='1'}">
										<label>
											医院名称
										</label>
										<input type="text" id="query_hospital_name" placeholder="医院名称" value="${map.hospital_name}">
									</c:if>
										<button type="submit" onclick="queryUtilHospital(0)" class="btn btn-sm btn-success">
											搜索
										</button>
									<c:if test="${map.login_account_type!='1'}">
										<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
											添加
										</button>
									</c:if>
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
					<th>
						logo
					</th>
					<th field="hospital_number"   onclick="querySort(this,'queryUtilHospital')"  >
						帐号
					</th>
					<th field="hospital_name"   onclick="querySort(this,'queryUtilHospital')"  >
						名称
					</th>
					<th field="hospital_jglx"   onclick="querySort(this,'queryUtilHospital')"  >
						机构类型
					</th>
					<th field="hospital_frdb"   onclick="querySort(this,'queryUtilHospital')"  >
						法人代表/负责人
					</th>
					<th field="hospital_dhhm"   onclick="querySort(this,'queryUtilHospital')"  >
						电话号码
					</th>
					<th field="hospital_jgclrq"   onclick="querySort(this,'queryUtilHospital')"  >
						成立日期
					</th>
					<th field="hospital_dz"   onclick="querySort(this,'queryUtilHospital')"  >
						地址
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryUtilHospital')">
						创建时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryUtilHospital')">
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
						<td colspan="44">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.hospital_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.hospital_logo}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							${info.hospital_number}
						</td>
						<td style="vertical-align: middle;">
							${info.hospital_name}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.hospital_jglx=='01'}">互联网医院诊疗</c:if><br>
							<c:if test="${info.hospital_jglx=='02'}">健康管理服务</c:if>
							<c:if test="${info.hospital_jglx=='03'}">药事服务机构</c:if>
							<c:if test="${info.hospital_jglx=='04'}">药房</c:if>
							<c:if test="${info.hospital_jglx=='05'}">其他</c:if><br>
						</td>
						<td style="vertical-align: middle;">
							${info.hospital_frdb}
						</td>
						<td style="vertical-align: middle;">
							${info.hospital_dhhm}
						</td>
						<td style="vertical-align: middle;">
							${info.hospital_jgclrq}
						</td>
						<td style="vertical-align: middle;">
							${info.hospital_dz}
						</td>
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.hospital_id}')" title="编辑">
								编辑
							</button>
							<c:if test="${info.login_account_type!='1'}">
								<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.hospital_id}','${info.hospital_id}')" title="删除">
									删除
								</button>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryUtilHospital" />
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
<script src="${root}/form/util/hospital/js/utilhospital_main.js?<%=Math.random()%>"></script>
</body>
</html>