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
						app功能图标管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilIcon_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										图标名称
									</label>
									<input type="text" id="query_icon_name" placeholder="图标名称" value="${map.icon_name}">
									
									<label>
										显示状态
									</label>
									<select id="query_is_show"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.is_show=='0'}">selected="selected"</c:if> value="0">隐藏</option>
										<option <c:if test="${map.is_show=='1'}">selected="selected"</c:if> value="1">显示</option>
									</select>
									
									<label>
										外链状态
									</label>
									<select id="query_is_outer_chain"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.is_outer_chain=='0'}">selected="selected"</c:if> value="0">无</option>
										<option <c:if test="${map.is_outer_chain=='1'}">selected="selected"</c:if> value="1">存在</option>
									</select>
									<button type="submit" onclick="queryUtilIcon(0)" class="btn btn-sm btn-success">
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
					<th field="icon_name"   onclick="querySort(this,'queryUtilIcon')"  >
						图标名称
					</th>
					<th field="icon_img"   onclick="querySort(this,'queryUtilIcon')"  >
						图标
					</th>
					<th field="is_show"   onclick="querySort(this,'queryUtilIcon')"  >
						显示状态
					</th>
					<th field="is_outer_chain"   onclick="querySort(this,'queryUtilIcon')"  >
						外链状态
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryUtilIcon')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryUtilIcon')">
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
						<td colspan="54">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.icon_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.icon_name}
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.icon_img}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.is_show=='0'}">隐藏</c:if>
							<c:if test="${info.is_show=='1'}">显示</c:if>
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.is_outer_chain=='0'}">无链接</c:if>
							<c:if test="${info.is_outer_chain=='1'}">
							<span style="color:red">${info.icon_link}</span>
							</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.icon_id}')" title="编辑">
								编辑
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryUtilIcon" />
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
<script src="${root}/form/util/icon/js/utilicon_main.js?<%=Math.random()%>"></script>
</body>
</html>