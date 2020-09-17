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
				医生名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<select class="col-xs-12 select" data-find="find" id="update_doctor_id" data-validate="required:医生名字不能为空哦！">
						<option value="">--请选择--</option>
						<c:forEach items="${doctorList}" var="info">
							<option value="${info.doctor_id}">${info.doctor_name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				模板类型
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<select class="select" id="update_template_type" data-validate="required:模板类型不能为空哦！">
						<option value="">--请选择--</option>
						<option value="1">主诉</option>
						<option value="2">现病史</option>
						<option value="3">既往史</option>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				模板名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="模板名称" id="update_template_name" class="col-xs-12" data-validate="required:模板名称不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				模板内容
			</label>
			<div class="col-sm-5">
				<textarea class="col-xs-12" id="update_template_details" placeholder="模板内容"></textarea>
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