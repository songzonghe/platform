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
					问诊
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="问诊" id="update_inquiry_patient_id" class="col-xs-12" data-validate="" value="${map.inquiry_patient_id}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					类型
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" type="radio" <c:if test="${map.join_type=='1'}">checked="checked"</c:if> name="update_join_type" value="1" >个人&nbsp;&nbsp;
					<input type="radio" name="update_join_type" value="2" <c:if test="${map.join_type=='2'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">门店
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					关联
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="关联" id="update_join_id" class="col-xs-12" data-validate="" value="${map.join_id}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					体温
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="体温" id="update_data_animal_heat" class="col-xs-12" data-validate="" value="${map.data_animal_heat}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					收缩压
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="收缩压" id="update_data_sbp" class="col-xs-12" data-validate="" value="${map.data_sbp}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					舒张压
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="舒张压" id="update_data_dbp" class="col-xs-12" data-validate="" value="${map.data_dbp}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					心率
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="心率" id="update_data_heart_rate" class="col-xs-12" data-validate="" value="${map.data_heart_rate}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					呼吸频率
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="呼吸频率" id="update_data_rr" class="col-xs-12" data-validate="" value="${map.data_rr}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					血糖
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="血糖" id="update_data_glu" class="col-xs-12" data-validate="" value="${map.data_glu}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					测量条件
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="测量条件" id="update_data_condition" class="col-xs-12" data-validate="" value="${map.data_condition}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					测量参数
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="测量参数" id="update_data_parameter" class="col-xs-12" data-validate="" value="${map.data_parameter}" >
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
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.data_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
