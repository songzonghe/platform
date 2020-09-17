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
					<c:if test="${map.init_type=='1'}">图文设置</c:if>
					<c:if test="${map.init_type=='2'}">联系方式</c:if>
					<c:if test="${map.init_type=='3'}">用户基础设置</c:if>
					<c:if test="${map.init_type=='4'}">医生基础设置</c:if>
					<c:if test="${map.init_type=='5'}">拼车基础设置</c:if>
					<c:if test="${map.init_type=='6'}">物流基础设置</c:if>
					<c:if test="${map.init_type=='8'}">项目设置</c:if>
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilInitData_index.do?type=${map.init_type}" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										名称
									</label>
									<input type="text" id="query_init_name" placeholder="名称" value="${map.init_name}">
									<button type="submit" onclick="query_UtilInitData(0)" class="btn btn-sm btn-success">
										查询
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
		<table id="sample-table-1" class="table  table-bordered dataTable" style="table-layout:fixed;WORD-BREAK:break-all;"> 
			<thead>
				<tr>
					<th width="50px">
						序号
					</th>

					<th field="init_name"  onclick="querySort(this,'query_UtilInitData')">
						名称
					</th>
					<th field="init_key"  onclick="querySort(this,'query_UtilInitData')">
						内容
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'query_UtilInitData')">
						更新时间
					</th>
					<th field="bz"  onclick="querySort(this,'query_UtilInitData')">
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
						<td colspan="6">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="map">
					<tr id="tr${map.init_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${map.init_name}
						</td>
						
						<td>
							<c:if test="${map.zt=='1'}">
								<a class="btn btn-xs btn-success" target="init_${map.init_id}" href="utilInitData_findById.do?type=1&&init_id=${map.init_id}" title="预览图文">
								预览图文
								</a>
							</c:if>
							<c:if test="${map.zt=='2'}">
								<img src="${map.init_key}" style="width: 60px;">
							</c:if>
							<c:if test="${map.zt=='3'||map.zt=='4'}">
								${map.init_key}
							</c:if>
							<c:if test="${map.zt=='5'}">
								<input type="checkbox" value="1" name="init_key"
							 <c:if test="${map.init_key=='1'}">checked</c:if>
							  onclick="changeInitKey('${map.init_id}')">
							</c:if>
							<c:if test="${map.zt=='6'}">
								<video src="${map.init_key}" height="200px" controls="controls"></video>
							</c:if>
						</td>
						<td style="vertical-align: middle;">
							${map.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${map.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${map.init_id}')" title="编辑">编辑</button>
							<c:if test="${map.zt==1}">
								<a class="btn btn-xs btn-pink" target="init_${map.init_id}" href="utilInitData_findById.do?type=2&init_id=${map.init_id}" title="编辑图文详情">
									编辑图文
								</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="query_UtilInitData" />
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
<script src="${root}/form/util/init/data/js/utilinitdata_main.js?<%=Math.random()%>"></script>
</body>
</html>