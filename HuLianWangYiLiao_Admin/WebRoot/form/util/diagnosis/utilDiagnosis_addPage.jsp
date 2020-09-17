<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${root}/form_util/util/util_css/jquery.searchableSelect.css" />
<div class="widget-main no-padding" style="width: 880px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		
		
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					疾病分类
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
					<select class="select" id="update_icd_id" data-find="find" data-validate="required:分类名称不能为空哦！">
						<option value="">--请选择--</option>
						<c:forEach var="info" items="${listIcdDoctor.icdList}">
							<option value="${info.icd_id}">${info.icd_name}</option>
						</c:forEach>
					</select>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					诊段名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
					<select class="select" data-find="find" id="update_diagnosis_name" data-validate="required:诊段名称不能为空哦！">
						<option value="">--请选择--</option>
						<c:forEach var="info" items="${listIcdDoctor.icdList}">
							<option value="${info.icd_name}">${info.icd_name}</option>
						</c:forEach>
					</select>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					医生
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
					<select class="col-xs-12 select" data-find="find" id="update_doctor_id" data-validate="required:医生名称不能为空哦！">
						<option value="">--请选择--</option>
						<c:forEach var="info" items="${listIcdDoctor.doctorList}">
							<option value="${info.doctor_id}">${info.doctor_name}</option>
						</c:forEach>
					</select>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					性别限制
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<select class="select" id="update_diagnosis_sex" data-validate="required:性别限制不能为空哦！">
						<option value="">--请选择--</option>
						<option value="1">男</option>
						<option value="2">女</option>
						<option value="3">不限制</option>
					</select>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					最低年龄
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="最低年龄" id="update_diagnosis_dage" class="col-xs-12" data-validate="required:最低年龄不能为空哦！,number:只能是整数哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					最高年龄
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="最高年龄" id="update_diagnosis_tage" class="col-xs-12" data-validate="required:最高年龄不能为空哦！,number:只能是整数哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					使用限制
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<select class="select" id="update_is_restriction" data-validate="required:使用限制不能为空哦！">
						<option value="">--请选择--</option>
						<option value="0">否</option>
						<option value="1">是</option>
					</select>
					</span>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;">
					备注
				</label>
				<div class="col-sm-10">
					<textarea style="width: 81%;" id="beiZhu" placeholder="备注"></textarea>
				</div>
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
