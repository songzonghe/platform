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
						用户基本资料管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="userInfo_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									
									<label>
										账号
									</label>
									<input type="text" id="query_user_phone" placeholder="账号" value="${map.user_phone}">
									<button type="submit" onclick="queryUserInfo(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
										<i class="ace-icon fa fa-plus icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPages('1')" class="btn btn-sm btn-success">
										发送消息
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
					<th field="user_phone"   onclick="querySort(this,'queryUserInfo')"  >
						账号
					</th>
<!-- 					<th field="user_openid"   onclick="querySort(this,'queryUserInfo')"  >
						用户微信
					</th>
 -->
					<th field="user_nickname"   onclick="querySort(this,'queryUserInfo')"  >
						用户昵称
					</th>
					<th field="user_img" width="180" onclick="querySort(this,'queryUserInfo')"  >
						用户头像
					</th>
					<th field="user_name"   onclick="querySort(this,'queryUserInfo')"  >
						真实名称
					</th>
					<th width="180" field="user_document_img1"   onclick="querySort(this,'queryUserInfo')"  >
						证件正反面
					</th>
					<th field="gxsj" width="170" onclick="querySort(this,'queryUserInfo')">
						修改时间
					</th>
					<th field="bz"  onclick="querySort(this,'queryUserInfo')">
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
						<td colspan="114">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.user_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.user_phone}
						</td>
<!-- 						<td style="vertical-align: middle;">
							${info.user_openid}
						</td>
 -->						
						<td style="vertical-align: middle;">
							${info.user_nickname}
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.user_img}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							${info.user_name}
						</td>
						<td style="vertical-align: middle;">
							正面：<img src="${info.user_document_img1}" style="height: 60px;"><br>
							反面：<img src="${info.user_document_img2}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.user_id}','1')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.user_id}','2')" title="重置密码">
								重置密码
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.user_id}','${info.user_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryUserInfo" />
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
<script src="${root}/form/user/info/js/userinfo_main.js?<%=Math.random()%>"></script>
<script src="${root}/form/util/notice/user_notice.js?<%=Math.random()%>"></script>
</body>
</html>