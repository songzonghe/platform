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
				<label class="col-sm-4 control-label no-padding-right">
					医生名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="医生名称" id="update_doctor_id" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="药品名称" id="update_drug_id" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					药品l类型
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input style="margin-top: 10px;" type="radio" data-validate="required:不能为空哦！" checked="checked" name="update_drug_type" value="1">中药&nbsp;&nbsp;
					<input type="radio" name="update_drug_type" data-validate="required:不能为空哦！" value="2">西药
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					用量
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="用量" id="update_doctor_drug_consumption" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					频率文字
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="频率文字" id="update_doctor_drug_frequency_str" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					频率
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="频率" id="update_doctor_drug_frequency" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					天数
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="天数" id="update_doctor_drug_day" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					数量
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="数量" id="update_doctor_drug_num" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					用法
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="用法" id="update_doctor_drug_usage" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					嘱托
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" value="饭后服用" placeholder="嘱托" id="update_doctor_drug_entrust" class="col-xs-12" data-validate="required:不能为空哦！">
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
