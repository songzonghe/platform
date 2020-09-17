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
						药师管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="pharmacistInfo_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									<label>
										账号
									</label>
									<input type="text" id="query_pharmacist_number" placeholder="账号" value="${map.pharmacist_number}">
									
									<label>
										名称
									</label>
									<input type="text" id="query_pharmacist_name" placeholder="名称" value="${map.pharmacist_name}">
									
									<label>
										状态
									</label>
									<select id="query_zTai"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.zTai=='2'}">selected="selected"</c:if> value="2">正常</option>
										<option <c:if test="${map.zTai=='0'}">selected="selected"</c:if> value="0">已禁用</option>
									</select>
									<button type="submit" onclick="queryPharmacistInfo(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
									</button>
									<br>
									<span><input type="checkbox" onclick="clickShowUrl()" <c:if test="${map.isshow=='1'}">checked="checked"</c:if>  id="isshow">登录地址：</span><span style="color: red" id="showurl">${showUrl}</span><span id="hideurl">●●●●●●●</span>
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
						头像
					</th>
					<th field="pharmacist_number"   onclick="querySort(this,'queryPharmacistInfo')"  >
						账号
					</th>
					<th field="pharmacist_name"   onclick="querySort(this,'queryPharmacistInfo')"  >
						名称
					</th>
					<th field="pharmacist_phone"   onclick="querySort(this,'queryPharmacistInfo')"  >
						联系方式
					</th>
					<th>
						签名
					</th>
					<th field="pharmacist_sex"   onclick="querySort(this,'queryPharmacistInfo')"  >
						性别
					</th>
					<th field="pharmacist_sort"   onclick="querySort(this,'queryPharmacistInfo')"  >
						排序
					</th>
					<th field="zt"   onclick="querySort(this,'queryPharmacistInfo')"  >
						状态
					</th>
					<th field="lrsj" width="170" onclick="querySort(this,'queryPharmacistInfo')">
						创建时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryPharmacistInfo')">
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
						<td colspan="164">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.pharmacist_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.pharmacist_img}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							${info.pharmacist_number}
						</td>
						<td style="vertical-align: middle;">
							${info.pharmacist_name}
						</td>
						<td style="vertical-align: middle;">
							${info.pharmacist_phone}
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.pharmacist_autograph}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.pharmacist_sex=='0'}">男</c:if>
							<c:if test="${info.pharmacist_sex=='1'}">女</c:if>
							<c:if test="${info.pharmacist_sex=='2'}">保密</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.pharmacist_sort}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.zt=='2'}">正常</c:if>
							<c:if test="${info.zt=='0'}"><span style="color:red">已禁用</span></c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.pharmacist_id}')" title="编辑">
								编辑
							</button>
							<c:if test="${info.zt=='2'}">
								<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.pharmacist_id}','0')" title="禁用">
									禁用
								</button>
							</c:if>
							<c:if test="${info.zt=='0'}">
								<button class="btn btn-xs btn-success" onclick="confirmDeleteDate('${info.pharmacist_id}','2')" title="启用">
									启用
								</button>
								<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.pharmacist_id}','del')" title="删除">
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
<c:set var="cx" value="queryPharmacistInfo" />
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
<script src="${root}/form/pharmacist/info/js/pharmacistinfo_main.js?<%=Math.random()%>"></script>
</body>
</html>