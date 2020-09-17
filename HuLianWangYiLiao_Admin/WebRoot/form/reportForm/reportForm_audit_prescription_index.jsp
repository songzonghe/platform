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
							药师审核报表
						</h4>
					</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<form action="reportForm_audit_prescription_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
		 						<fieldset>
									
									<label>咨询时间</label>
									<input type="text" id="query_beginTime" placeholder="起始时间" value="${map.beginTime}" readonly="readonly" onclick="WdatePicker({maxDate:'#F{$dp.$D(\'query_endTime\')}'})">
									~~
									<input type="text" id="query_endTime" placeholder="终止时间" value="${map.endTime}" readonly="readonly" onclick="WdatePicker({minDate:'#F{$dp.$D(\'query_beginTime\')}'})">
									
									<label>
										医生姓名/手机
									</label>
									<input type="text" id="query_doctor_name" placeholder="医生姓名/手机" value="${map.doctor_name}">
									<label>
										咨询类型
									</label>
									<select id="query_log_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.log_type=='1'}">selected="selected"</c:if> value="1">视频问诊</option>
										<option <c:if test="${map.log_type=='2'}">selected="selected"</c:if> value="2">图文问诊</option>
									</select>
									<label>
										用户来源
									</label>
									<select id="query_join_type"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.join_type=='1'}">selected="selected"</c:if> value="1">个人</option>
										<option <c:if test="${map.join_type=='2'}">selected="selected"</c:if> value="2">门店</option>
									</select>
									<label>
										处方状态
									</label>
									<select id="query_find_zt"  style="width: 120px">
									<option value="">请选择</option>
										<option <c:if test="${map.find_zt=='1'}">selected="selected"</c:if> value="1">已查看</option>
										<option <c:if test="${map.find_zt=='0'}">selected="selected"</c:if> value="0">审核通过</option>
										<option <c:if test="${map.find_zt=='5'}">selected="selected"</c:if> value="5">审核失败</option>
									</select>
									<button type="submit" onclick="queryAuditPrescription(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									
									<button  type="button" onclick="confirmExportExcel()" class="btn btn-sm btn-pink">
										导出excel
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
						咨询人
					</th>
					<th>
						性别
					</th>
					<th>
						联系电话
					</th>
					<th>
						用户来源
					</th>
					<th>
						医生信息
					</th>
					<th>
						审核药师
					</th>
					<th>
						咨询类型
					</th>
					<th>
						咨询时间
					</th>
					<th>
						处方类型
					</th>
					<th>
						开处方日期
					</th>
					<th>
						处方状态
					</th>
					<th>
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
					<tr>
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_name}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.inquiry_patient_sex=='0'}">男</c:if>
							<c:if test="${info.inquiry_patient_sex=='1'}">女</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.inquiry_patient_phone}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.join_type=='1'}">个人</c:if>
							<c:if test="${info.join_type=='2'}">门店</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.doctor_name}(${info.doctor_phone})
						</td>
						<td style="vertical-align: middle;">
							${info.prescription_audited_doctor}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.log_type=='1'}">视频问诊</c:if>
							<c:if test="${info.log_type=='2'}">图文问诊</c:if>
						</td>
						
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.prescription_type=='1'}">中药</c:if>
							<c:if test="${info.prescription_type=='2'}">西药</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.kfsj}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.zt=='0'}">审核通过</c:if>
							<c:if test="${info.zt=='1'}">已查看</c:if>
							<c:if test="${info.zt=='2'}">审核中</c:if>
							<c:if test="${info.zt=='5'}"><span style="color:red">不通过</span><br>原因：${info.prescription_reasons_invalidation}</c:if>
							<c:if test="${info.zt=='-1'}">未开处方</c:if>
							<c:if test="${info.zt=='6'}"><span style="color:red">已作废</span><br>原因：${info.prescription_reasons_invalidation}</c:if>
						</td>
						<td class="printing"  style="vertical-align: middle;color: #f9a821;">
							<c:if test="${info.zt!='-1'}">
								<span style="display:block;cursor: pointer;" id="${info.prescription_id}" num="0">用药详情</span>
								<span style="display:block;cursor: pointer;" id="${info.prescription_id}" num="1">打印处方</span>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<!-- 处方详情弹窗 -->
<div class="backgrounde8f3fb PrescriptionDetails" style="position: fixed;background: #fff; z-index: 3341;  top: 30px; left: 50%;  transform: translateX(-50%);width: 600px; border-radius: 0; font-size: 15px; max-height: 86%;overflow: hidden; overflow-y: auto;display:none">
</div>
<!--处方详情-->
<div class="backgrounde8f3fb backgroundfff" style="position: fixed;background: #e8f3fb; z-index: 3341;  top: 30px; left: 50%;  transform: translateX(-50%);width: 600px; border-radius: 0; font-size: 15px; max-height: 86%;overflow: hidden; overflow-y: auto;display:none">
	<div class="testdata_title text_title_img"  style="text-align: right;  margin: 10px 10px 0 0; position: relative; z-index: 11;"><span onclick="closeimg()" style="cursor: pointer;">X</span></div>
	<div class="dy_PrescriptionDetails"></div>
</div>
<div class="detailsmedication bg" style="position: fixed; top: 0;left: 0; bottom: 0;right: 0; background: rgba(0,0,0,0.3);z-index: 3334;display:none"></div>

<c:set var="cx" value="queryAuditPrescription" />
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
<script src="${root}/form/reportForm/js/reportForm_main.js?<%=Math.random()%>"></script>
<script src="${root}/form/reportForm/js/publice.js?<%=Math.random()%>"></script>
<script src="${root}/form/reportForm/js/jquery.print.js?<%=Math.random()%>"></script>
<script type="text/javascript">
jQuery('.printing').on('click','span',function(){
	var id = jQuery(this).attr('id');
	var num = jQuery(this).attr('num');
	printing(num,id);//// 0 历史处方详情  1 历史处方打印 2检验打印  3 建议指导打印 4 住院建议打印
	if(num == 0){
		jQuery('.PrescriptionDetails').show();
	}else{
		jQuery('.backgroundfff').show();
	}
	
	jQuery('.detailsmedication.bg').show();

})
/**
 * 打印
 * @return
 */
function printAll(num,id){// 1 历史处方打印 2检验打印  3 建议指导打印 4 住院建议打印
	if(num == 1){//
		var className = '.dy_PrescriptionDetails';
	}else if(num == 2){//
		var className = '.ChecklistDetails';
	}else if(num == 3){//
		var className = '.HealthGuidanceDetails';
	}else if(num == 4){//
		var className = '.HospitalizationDetails';
	}
	$('.tapBtn').hide();
	$(className).jqprint({  
        debug: false,            
        importCSS: true,         
        printContainer: true,    
        operaSupport: false    
    }) 
	$('.tapBtn').show();
}
//关闭 
function closeimg(){
	jQuery('.backgrounde8f3fb').hide();
	jQuery('.detailsmedication.bg').hide();
	jQuery('body #_ORIGINALIMG').css('display:none');
	closeLoadingDiv();
}
</script>
</body>
</html>