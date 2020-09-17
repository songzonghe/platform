<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 880px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong>问诊记录处方详情编辑</strong> </font>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					处方
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="处方" id="update_prescription_id" class="col-xs-12" data-validate="required:处方必填" value="${map.prescription_id}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品" id="update_drug_id" class="col-xs-12" data-validate="required:药品必填" value="${map.drug_id}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					用量
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="用量" id="update_details_consumption" class="col-xs-12" data-validate="required:用量必填" value="${map.details_consumption}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					频率文字
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="频率文字" id="update_details_frequency_str" class="col-xs-12" data-validate="required:频率文字必填" value="${map.details_frequency_str}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					频率
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="频率" id="update_details_frequency" class="col-xs-12" data-validate="required:频率必填" value="${map.details_frequency}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					天数
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="天数" id="update_details_day" class="col-xs-12" data-validate="required:天数必填" value="${map.details_day}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					数量
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="数量" id="update_details_num" class="col-xs-12" data-validate="required:数量必填" value="${map.details_num}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					用法
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="用法" id="update_details_usage" class="col-xs-12" data-validate="required:用法必填" value="${map.details_usage}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					嘱托
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="嘱托" id="update_details_entrust" class="col-xs-12" data-validate="required:嘱托必填" value="${map.details_entrust}" onchange="$('#isUpdate').attr('value','y')">
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
					<textarea style="width: 81%;" id="beiZhu" placeholder="备注" onchange="$('#isUpdate').attr('value','y')">${map.bz}</textarea>
				</div>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate_inquiryLogPrescriptionDetails('${map.prescription_details_id}','${map.prescription_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
