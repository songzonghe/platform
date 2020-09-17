<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 550px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong>问诊记录检验检查单详情编辑</strong> </font>
		</div>
		
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				医院
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="医院" id="update_hospital_id" class="col-xs-12" data-validate="required:医院必填" value="${map.hospital_id}" onchange="$('#isUpdate').attr('value','y')">
				</span>
			</div>
		</div>
			<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				检验单类型
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="检验单类型" id="update_checklist_type" class="col-xs-12" data-validate="required:检验单类型必填" value="${map.checklist_type}" onchange="$('#isUpdate').attr('value','y')">
				</span>
			</div>
		</div>
			<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				检验单名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="检验单名称" id="update_checklist_name" class="col-xs-12" data-validate="required:检验单名称必填" value="${map.checklist_name}" onchange="$('#isUpdate').attr('value','y')">
				</span>
			</div>
		</div>
			<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-5">
				<textarea class="col-xs-12" id="beiZhu" placeholder="备注" onchange="$('#isUpdate').attr('value','y')">${map.bz}</textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate_inquiryLogChecklistDetails('${map.checklist_details_id}','${map.checklist_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
