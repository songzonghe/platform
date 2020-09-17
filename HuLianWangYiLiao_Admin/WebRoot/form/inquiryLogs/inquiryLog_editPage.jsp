	<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 880px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					记录类型
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="记录类型" id="update_log_type" class="col-xs-12" data-validate="required:记录类型不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					关联类型
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="关联类型" id="update_join_type" class="col-xs-12" data-validate="required:关联类型不能为空哦！" value="${map.join_type}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					关联
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="关联" id="update_join_id" class="col-xs-12" data-validate="required:关联不能为空哦！" value="${map.join_id}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					问诊患者
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="问诊患者" id="update_inquiry_patient_id" class="col-xs-12" data-validate="required:问诊患者不能为空哦！" value="${map.inquiry_patient_id}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					医生
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="医生" id="update_doctor_id" class="col-xs-12" data-validate="required:医生不能为空哦！" value="${map.doctor_id}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					记录来源
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="记录来源" id="update_log_source" class="col-xs-12" data-validate="required:记录来源不能为空哦！" value="${map.log_source}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					主诉
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="主诉" id="update_log_main_suit" class="col-xs-12" data-validate="required:主诉不能为空哦！" value="${map.log_main_suit}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					现病史
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<textarea type="text" placeholder="现病史" id="update_log_present_illness" class="col-xs-12" data-validate="required:现病史不能为空哦！" value="${map.log_present_illness}" ></textarea>
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					既往史
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<textarea type="text" placeholder="既往史" id="update_log_history_present_illness" class="col-xs-12" data-validate="required:既往史不能为空哦！" value="${map.log_history_present_illness}" ></textarea>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					诊断
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<textarea type="text" placeholder="诊断" id="update_lof_diagnosis" class="col-xs-12" data-validate="required:诊断不能为空哦！" value="${map.lof_diagnosis}" ></textarea>
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
					<textarea style="width: 81%;" id="beiZhu" placeholder="备注" >${map.bz}</textarea>
				</div>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.log_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
