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
						系统医院设备管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilHospitalEquipment_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										设备代号
									</label>
									<input type="text" id="query_equipment_sbdh" placeholder="设备代号" value="${map.equipment_sbdh}">
									
									<label>
										设备名称
									</label>
									<input type="text" id="query_equipment_sbmc" placeholder="设备名称" value="${map.equipment_sbmc}">
									<button type="submit" onclick="queryUtilHospitalEquipment(0)" class="btn btn-sm btn-success">
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
					<th field="equipment_sbdh"   onclick="querySort(this,'queryUtilHospitalEquipment')"  >
						设备代号
					</th>
					<th field="equipment_sbmc"   onclick="querySort(this,'queryUtilHospitalEquipment')"  >
						设备名称
					</th>
					<th field="equipment_tpsbts"   onclick="querySort(this,'queryUtilHospitalEquipment')"  >
						设备台数
					</th>
					<th field="equipment_yt"   onclick="querySort(this,'queryUtilHospitalEquipment')"  >
						用途
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryUtilHospitalEquipment')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryUtilHospitalEquipment')">
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
						<td colspan="154">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.equipment_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							设备代号：${info.equipment_id}<br>
							设备名称：${info.equipment_sbmc}<br>
							设备台数：${info.equipment_tpsbts}<br>
							产地：
							<c:if test="${info.equipment_cd=='1'}">进口</c:if>
							<c:if test="${info.equipment_cd=='2'}">国产</c:if>
							<c:if test="${info.equipment_cd=='3'}">合资</c:if>
							<c:if test="${info.equipment_cd=='9'}">未知</c:if>
							<br>
							生产厂家：${info.equipment_sccj}
						</td>
						<td style="vertical-align: middle;">
							设备型号：${info.equipment_sbxh}<br>
							设备参数：${info.equipment_sbcs}<br>
							设备类型：${info.equipment_sblx}
						</td>
						<td style="vertical-align: middle;">
							购买日期：${info.equipment_gmrq}<br>
							用途：${info.equipment_yt}<br>
							设备价值金额：${info.equipment_sbjzje}<br>
							购进时新旧情况:${info.equipment_gjsxqk}
						</td>
						<td style="vertical-align: middle;">
							理论设计寿命：${info.equipment_llsjsm}<br>
							使用情况：
							<c:if test="${info.equipment_syqk=='1'}">启用</c:if>
							<c:if test="${info.equipment_syqk=='2'}">未启用</c:if>
							<c:if test="${info.equipment_syqk=='3'}">报废</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.equipment_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.equipment_id}','${info.equipment_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryUtilHospitalEquipment" />
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
<script src="${root}/form/util/hospital/equipment/js/utilhospitalequipment_main.js?<%=Math.random()%>"></script>
</body>
</html>