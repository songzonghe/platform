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
					问诊记录
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="问诊记录" id="update_log_id" class="col-xs-12" data-validate="required:问诊记录不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					个人/门店
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" type="radio" checked="checked" name="update_join_type" value="1">个人&nbsp;&nbsp;
					<input type="radio" name="update_join_type" value="2">门店
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					关联主键
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="关联主键" id="update_join_id" class="col-xs-12" data-validate="required:关联主键不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field patientList">
				<label class="col-sm-4 control-label no-padding-right" onchange="patientList()">
					问诊患者名字
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right">
						<select  id="update_inquiry_patient_id" class="col-xs-6" data-validate="required:不能为空哦！">
							<option value="">请选择</option>
							<c:forEach items="${patientList}" var="info">
								<option value="${info.inquiry_patient_id}">${info.inquiry_patient_name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field doctorList">
			<label class="col-sm-2 control-label no-padding-right" onchange="doctorList()">
				医生名字
			</label>
			<div class="col-sm-6 field">
				<span class="block input-icon input-icon-right">
					<select  id="update_doctor_id" class="col-xs-6" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach items="${doctorList}" var="info">
							<option value="${info.doctor_id}">${info.doctor_name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
			
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					处方类型
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input style="margin-top: 10px;" type="radio" checked="checked" name="update_prescription_type" value="1">中药&nbsp;&nbsp;
					<input type="radio" name="update_prescription_type" value="2">西药
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					处方金额
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="处方金额" id="update_prescription_price" class="col-xs-12" data-validate="required:处方金额不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					付数
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input class="col-xs-12" id="update_prescription_num" placeholder="付数" data-validate="required:付数不能为空哦！"/>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					服用方法
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<textarea class="col-xs-12" id="update_prescription_taking" placeholder="服用方法" data-validate="required:服用方法不能为空哦！"></textarea>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					服用要求
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<textarea type="text" placeholder="服用要求" id="update_prescription_requirements" class="col-xs-12" data-validate="required:服用要求不能为空哦！"></textarea>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					作废理由
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<textarea type="text" placeholder="作废理由" id="update_prescription_reasons_invalidation" class="col-xs-12"></textarea>
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
	$(function(){
		doctorList();
		patientList();
		})
		
	function doctorList(){
		var val=$('#update_doctor_id').val();
		$('#update_doctor_id').attr('data-validate','required:请选择');
		}
	function patientList(){
		var val=$('#update_inquiry_patient_id').val();
		$('#update_inquiry_patient_id').attr('data-validate','required:请选择');
		}
	
	
</script>
