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
						门店基本资料管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="storeInfo_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									
									<label>
										账号
									</label>
									<input type="text" id="query_store_phone" placeholder="账号" value="${map.store_phone}">
									
									<label>
										门店名称
									</label>
									<input type="text" id="query_store_name" placeholder="门店名称" value="${map.store_name}">
									<button type="submit" onclick="queryStoreInfo(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
									</button>
									<button type="button" onclick="openAddPages('2')" class="btn btn-sm btn-success">
										发送消息
									</button>
									<button type="button" onclick="openImportBoxPage('store_info','queryStoreInfo')" class="btn btn-sm btn-info">
										导入
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
					<th field="store_phone"   onclick="querySort(this,'queryStoreInfo')"  >
						账号
					</th>					
					<th>
						门店头像
					</th>
					<th field="store_name"   onclick="querySort(this,'queryStoreInfo')"  >
						服务
					</th>
					<th colspan="5">
						门店资料
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryStoreInfo')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryStoreInfo')">
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
						<td colspan="64">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.store_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							账号：${info.store_phone}<br>						
							名称：${info.store_name}
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.store_img}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							网点代码：${info.store_fwwddm}<br>
							区划代码：${info.store_xzqhdm}<br>
							服务点类型：
							<c:if test="${info.store_fwdlx=='01'}">互联网医院诊疗</c:if>
							<c:if test="${info.store_fwdlx=='02'}">健康管理服务</c:if>
							<c:if test="${info.store_fwdlx=='03'}">药事服务机构</c:if>
							<c:if test="${info.store_fwdlx=='04'}">药房</c:if>
							<c:if test="${info.store_fwdlx=='05'}">其他</c:if><br>
							成立日期：${info.store_fwdclrq}
							</td>
						<td style="vertical-align: middle;">
							关系代码：${info.store_dwlsgxdm}<br>
							类别代码：${info.store_fwdflgllbdm}<br>
							分类代码：${info.store_fwdfldm}<br>
							类型代码：${info.store_jjlxdm}
							</td>
						<td style="vertical-align: middle;">
							地址：${info.store_dz}<br>
							医院级别：${info.store_fwdyyjb}<br>
							医院等级：${info.store_fwdyydj}<br>
							许可证号码：${info.store_xkzhm}
						</td>
						<td style="vertical-align: middle;">
							项目名称：${info.store_xkxmmc}<br>
							有效期：${info.store_xkzyxq}<br>
							金额数：${info.store_kbzjjes}<br>
							负责人：${info.store_frdb}
						</td>
						<td style="vertical-align: middle;">
							地方标志：
							<c:if test="${info.store_fwdszdmzzzdfbz=='0'}">是</c:if><br>
							<c:if test="${info.store_fwdszdmzzzdfbz=='1'}">否</c:if>
							是否分支机构：
							<c:if test="${info.store_sffzjg=='0'}">是</c:if><br>
							<c:if test="${info.store_sffzjg=='1'}">否</c:if>
							第二名称：${info.store_fwddemc}<br>
							服务点描述：${info.store_fwdms}
						</td>
						<td style="vertical-align: middle;">
							邮政编码：${info.store_yzbm}<br>
							电话号码：${info.store_dhhm}<br>
							电子信箱：${info.store_dwdzyx}<br>
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.store_id}','1')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.store_id}','${info.store_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryStoreInfo" />
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
<script src="${root}/form/store/info/js/storeinfo_main.js?<%=Math.random()%>"></script>
<script src="${root}/form/util/notice/user_notice.js?<%=Math.random()%>"></script>
</body>
</html>