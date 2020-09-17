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
						药品信息管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilDrug_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										分类名称
									</label>
									<input type="text" id="query_class_name" placeholder="分类名称" value="${map.class_name}">
									
									<label>
										批准文号
									</label>
									<input type="text" id="query_drug_number" placeholder="批准文号" value="${map.drug_number}">
									
									<label>
										药品名称
									</label>
									<input type="text" id="query_drug_name" placeholder="药品名称" value="${map.drug_name}">
									
									<label>
										药品英文名称
									</label>
									<input type="text" id="query_drug_usname" placeholder="药品英文名称" value="${map.drug_usname}">
									
									<label>
										药品公司
									</label>
									<input type="text" id="query_drug_company" placeholder="药品公司" value="${map.drug_company}">
									<button type="submit" onclick="queryUtilDrug(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
										<i class="ace-icon fa fa-plus icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openImportBoxPage('util_drug','queryUtilDrug')" class="btn btn-sm btn-info">
										导入
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
					<th field="hospital_id"   onclick="querySort(this,'queryUtilDrug')"  >
						药品基本信息
					</th>
					<th field="class_id"   onclick="querySort(this,'queryUtilDrug')"  >
						规格信息
					</th>
					<th field="drug_img"   onclick="querySort(this,'queryUtilDrug')"  >
						药品主图
					</th>
					<th field="drug_price"   onclick="querySort(this,'queryUtilDrug')"  >
						最大用量
					</th>
					<th field="drug_pinyin"   onclick="querySort(this,'queryUtilDrug')"  >
						拼音/五笔码
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryUtilDrug')">
						修改时间
					</th>
					<th width="180">
						操作
					</th>
				</tr>
			</thead>
			<tbody id="tbodyData">
				<c:if test="${empty listMap}">
					<tr align="center">
						<td colspan="294">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.drug_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							批准文号：${info.drug_number}<br>
							药品名称：${info.drug_name}<br>
							英文名称：${info.drug_usname}<br>
							药品公司：${info.drug_company}<br>
						</td>
						<td style="vertical-align: middle;">
							分类名称：${info.class_name}<br>
							药品规格：${info.drug_specifications}<br>
							药品类型：
							<c:if test="${info.drug_type=='1'}">中药</c:if>
							<c:if test="${info.drug_type=='2'}">西药</c:if>
							<c:if test="${info.drug_type=='3'}">中成药</c:if><br>
							是否处方：
							<c:if test="${info.drug_is_rx=='0'}">非处方药</c:if>
							<c:if test="${info.drug_is_rx=='1'}">处方药</c:if><br>
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.drug_img}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							计量单位：${info.drug_maxdosage}<br>
							最小单位：${info.drug_maxdosage2}<br>
							补充单位：${info.drug_maxdosage3}
						</td>
						<td style="vertical-align: middle;">
							拼音码：${info.drug_pinyin}<br>
							五笔码：${info.drug_wubi}<br>
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.drug_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.drug_id}','${info.drug_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryUtilDrug" />
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
<script src="${root}/form/util/drug/js/utildrug_main.js?<%=Math.random()%>"></script>
</body>
</html>