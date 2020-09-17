<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${root}/form_util/util/util_css/jquery.searchableSelect.css" />
<div class="widget-main no-padding" style="width: 550px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				疾病分类
			</label>
			<div class="col-sm-5">
				<select class="col-xs-12 select" data-find="find" id="update_icd_id" data-validate="required:分类名称不能为空哦！">
					<option value="">--请选择--</option>
					<c:forEach var="info" items="${listIcdDoctor.icdList}">
						<option value="${info.icd_id}">${info.icd_name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				诊段名称
			</label>
			<div class="col-sm-5">
				<select class="col-xs-12 select" data-find="find" id="update_diagnosis_id" data-validate="required:诊段名称不能为空哦！">
						<option value="">--请选择--</option>
						<c:forEach var="info" items="${listIcdDoctor.diagnosisList}">
							<option value="${info.diagnosis_id}">${info.diagnosis_name}</option>
						</c:forEach>
					</select>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				医生名称
			</label>
			<div class="col-sm-5">
				<select class="col-xs-12 select" data-find="find" id="update_doctor_id" data-validate="required:医生名称不能为空哦！">
						<option value="">--请选择--</option>
						<c:forEach var="info" items="${listIcdDoctor.doctorList}">
							<option value="${info.doctor_id}">${info.doctor_name}</option>
						</c:forEach>
					</select>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				指导名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="指导名称" id="update_guidance_name" class="col-xs-12" data-validate="required:指导名称不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				指导内容
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="指导内容" id="update_guidance_content" class="col-xs-12" data-validate="required:指导内容不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-5">
				<textarea class="col-xs-12" id="beiZhu" placeholder="备注"></textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="addDataValidate()">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
<script type="text/javascript" src="${root}/form_util/util/sys_js/jquery.searchableSelect.js?<%=Math.random()%>">