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
						医生基本资料管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="doctorInfo_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<fieldset>
									
									<label>
										账号
									</label>
									<input type="text" id="query_doctor_phone" placeholder="账号" value="${map.doctor_phone}">
									
									<label>
										医生名称
									</label>
									<input type="text" id="query_doctor_name" placeholder="医生名称" value="${map.doctor_name}">
									
									<label>
										科室名称
									</label>
									<input type="text" id="query_department_name" placeholder="科室名称" value="${map.department_name}">
									<button type="submit" onclick="queryDoctorInfo(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
										<i class="ace-icon fa fa-plus icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPages('3')" class="btn btn-sm btn-success">
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
					<th width="100" field="doctor_phone"   onclick="querySort(this,'queryDoctorInfo')"  >
						账号
					</th>
					<th width="280" field="doctor_openid"   onclick="querySort(this,'queryDoctorInfo')"  >
						医生
					</th>
					<th width="280" field="doctor_work_address"   onclick="querySort(this,'queryDoctorInfo')"  >
						执业点
					</th>
					<th width="200" field="doctor_document_img2"   onclick="querySort(this,'queryDoctorInfo')"  >
						证件正反面
					</th>
					<th width="180" field="doctor_medical_practitioner_certificate"   onclick="querySort(this,'queryDoctorInfo')"  >
						医师证件
					</th>
					
					<th width="180">
						医生资料
					</th>
					<th width="180">
						医生代称
					</th>
					<th width="180">
						医生标志
					</th>
					<th field="gxsj" width="180" onclick="querySort(this,'queryDoctorInfo')">
						修改时间
					</th>
					<th field="bz" width="80" onclick="querySort(this,'queryDoctorInfo')">
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
						<td colspan="234">
							没有查询到数据
						</td>
					</tr>
				</c:if>
				<c:forEach items="${listMap}" varStatus="i" var="info">
					<tr id="tr${info.doctor_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.doctor_phone}
						</td>
						<td style="vertical-align: middle;">
							医生名称：${info.doctor_name}<br>
							医生头像：<img src="${info.doctor_img}" style="height: 60px;"><br>
							性别：<c:if test="${info.doctor_sex=='0'}">男</c:if>
							<c:if test="${info.doctor_sex=='1'}">女</c:if>
							<c:if test="${info.doctor_sex=='2'}">保密</c:if><br>
							医生职称：${info.doctot_job_title}
						</td>
						<td style="vertical-align: middle;">
							执业点：${info.doctor_work_address}<br>
							科室名称：${info.department_name}<br>
							执业日期：${info.doctot_work_day}
						</td>
						<td style="vertical-align: middle;">
							生日：${info.doctot_birthday}<br>
							正面：<img src="${info.doctor_document_img1}" style="height: 60px;"><br>
							反面：<img src="${info.doctor_document_img2}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							医师执业证：<img src="${info.doctor_medical_practitioner_certificate}" style="height: 60px;"><br>
							医师资格证：<img src="${info.doctor_medical_licence}" style="height: 60px;"><br>
							技术资格证：<img src="${info.doctor_technical_certificate}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							医生擅长：${info.doctor_begoodat}<br>
							医生排名：${info.doctor_sort}<br>
							是否在线：<c:if test="${info.is_online=='0'}">否</c:if>
									<c:if test="${info.is_online=='1'}">是</c:if><br>
						</td>
						<td style="vertical-align: middle;">
							职务代码：${info.doctor_zyjszwdm}<br>
							类别代码：${info.doctor_zyjszwlbdm}<br>
							类别名称：${info.doctor_zzlbmc}<br>
							证书编号：${info.doctor_zgzsbh}<br>
							获得时间：${info.doctor_zghdsj}<br>
							证书编码：${info.doctor_zyzsbm}
						</td>
						<td style="vertical-align: middle;">
							<!-- 发证日期：${info.doctor_zyjszwdm}<br> modify by liwenhai -->
							发证日期：${info.doctor_fzrq}<br>
							注册日期：${info.doctor_zcsj}<br>
							执业范围：${info.doctor_zyfw_name}<br>
							医生标志：
							<c:if test="${info.doctor_qkysbz=='T'}">是</c:if>
							<c:if test="${info.doctor_qkysbz=='F'}">否</c:if><br>
							民族：${info.doctor_mz}<br>
							学历：${info.doctor_zghdsj}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button width="180" class="btn btn-xs btn-info" onclick="openEditPage('${info.doctor_id}','1')" title="编辑">
								编辑
							</button>
							<button width="180" class="btn btn-xs btn-info" onclick="openEditPage('${info.doctor_id}','2')" title="重置密码">
								重置密码
							</button>
							<button width="180" class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.doctor_id}','${info.doctor_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:set var="cx" value="queryDoctorInfo" />
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
<script src="${root}/form/doctor/info/js/doctorinfo_main.js?<%=Math.random()%>"></script>
<script src="${root}/form/util/notice/user_notice.js?<%=Math.random()%>"></script>
</body>
</html>