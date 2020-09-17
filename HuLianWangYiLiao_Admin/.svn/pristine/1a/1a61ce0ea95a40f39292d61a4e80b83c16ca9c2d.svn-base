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
						轮播管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="utilCarousel_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										轮播名称
									</label>
									<input type="text" id="query_carousel_name" placeholder="轮播名称" value="${map.carousel_name}">
									<label>
										轮播位置
									</label>
									<select id="query_carousel_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.carousel_type=='1'}">selected="selected"</c:if> value="1">用户首页</option>
										<option <c:if test="${map.carousel_type=='2'}">selected="selected"</c:if> value="2">门店首页</option>
										<option <c:if test="${map.carousel_type=='3'}">selected="selected"</c:if> value="3">医生首页</option>
									</select>
									<label>
										轮播类型
									</label>
									<select id="query_carousel_way"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.carousel_way=='1'}">selected="selected"</c:if> value="1">无效果</option>
										<option <c:if test="${map.carousel_way=='2'}">selected="selected"</c:if> value="2">详情</option>
										<option <c:if test="${map.carousel_way=='3'}">selected="selected"</c:if> value="3">跳转链接</option>
									</select>
									<button type="submit" onclick="queryUtilCarousel(0)" class="btn btn-sm btn-success">
										查询
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加轮播图
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
					<th>
						轮播名称
					</th>
					<th>
						轮播图片
					</th>
					<th field="carousel_type"   onclick="querySort(this,'queryUtilCarousel')"  >
						轮播位置
					</th>
					<th field="carousel_way"   onclick="querySort(this,'queryUtilCarousel')"  >
						轮播类型
					</th>
					<th>
						轮播内容
					</th>
					<th field="carousel_sort"  type="num"   onclick="querySort(this,'queryUtilCarousel')"  >
						显示序号
					</th>
					<th field="lrsj" width="170" onclick="querySort(this,'queryUtilCarousel')">
						创建时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryUtilCarousel')">
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
					<tr id="tr${info.carousel_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.carousel_name}
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.carousel_img}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.carousel_type=='1'}">用户首页</c:if>
							<c:if test="${info.carousel_type=='2'}">门店首页</c:if>
							<c:if test="${info.carousel_type=='3'}">医生首页</c:if>
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.carousel_way=='1'}">无效果</c:if>
							<c:if test="${info.carousel_way=='2'}">详情</c:if>
							<c:if test="${info.carousel_way=='3'}">跳转链接</c:if>
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.carousel_way=='1'}"><span style="color:red">无</span></c:if>
							<c:if test="${info.carousel_way=='2'}">
								<button class="btn btn-xs btn-info" onclick="openCarouselPage('${info.carousel_id}','${info.carousel_name}')" title="查看详情">
									查看详情
								</button>
							</c:if>
							<c:if test="${info.carousel_way=='3'}">${info.carousel_url}</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.carousel_sort}
						</td>
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.carousel_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.carousel_id}','${info.carousel_name}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryUtilCarousel" />
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
<script src="${root}/form/util/carousel/js/utilcarousel_main.js?<%=Math.random()%>"></script>
</body>
</html>