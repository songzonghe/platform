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
					记录类型
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" type="radio" checked="checked" name="update_log_type" value="1">视频问诊&nbsp;&nbsp;
					<input type="radio" name="update_log_type" value="2">图片问诊
					</span>
				</div>
			</div>
		</div>
	<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<select  id="update_join_type" class="col-xs-6" onchange="activityList()">
							<option value="0">门店</option>
							<option value="1">个人</option>
						</select>
					</span>
				</div>
			</div>
		
		<div class="form-group col-sm-6 field shop">
			<label class="col-sm-4 control-label no-padding-right">
				门店
			</label>
			<div class="col-sm-8 field">
				<span class="block input-icon input-icon-right">
					<select  id="update_store_id" class="col-xs-6" data-validate="">
						<option value="">请选择</option>
						<c:forEach items="${shopList}" var="info">
							<option value="${info.store_id}">${info.store_name}(${info.pro_batch_number})</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group col-sm-6 field person">
			<label class="col-sm-4 control-label no-padding-right">
				个人
			</label>
			<div class="col-sm-8 field">
				<span class="block input-icon input-icon-right">
					<select  id="update_user_id" class="col-xs-6" data-validate="">
						<option value="">请选择</option>
						<c:forEach items="${personList}" var="info">
							<option value="${info.user_id}">${info.user_name}</option>
						</c:forEach>

					</select>
				</span>
			</div>
		</div>
		</div>	
		<div class="row">
		<div class="form-group col-sm-6 field">
			<label class="col-sm-4 control-label no-padding-right">
				关联
			</label>
			<div class="col-sm-6 field">
				<span class="block input-icon input-icon-right"> 
					<input type="text" placeholder="关联" id="update_join_id" class="col-xs-12" data-validate="required:关联不能为空哦！,number:只能是数字哦!">
				</span>
			</div>
		</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field patient">
			<label class="col-sm-4 control-label no-padding-right" onchange="patientList()">
				问诊患者
			</label>
			<div class="col-sm-6 field">
				<span class="block input-icon input-icon-right">
					<select  id="update_inquiry_patient_id" class="col-xs-12" data-validate="">
						<option value="">请选择</option>
						<c:forEach items="${patientList}" var="info">
							<option value="${info.inquiry_patient_id}">${info.inquiry_patient_name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
			
		<div class="form-group col-sm-6 field doctor">
			<label class="col-sm-2 control-label no-padding-right" onchange="doctorList()">
				医生
			</label>
			<div class="col-sm-6 field">
				<span class="block input-icon input-icon-right">
					<select  id="update_doctor_id" class="col-xs-12" data-validate="">
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
					记录
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="记录" id="update_log_source" class="col-xs-12" data-validate="required:记录不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					主诉
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="主诉" id="update_log_main_suit" class="col-xs-12" data-validate="required:主诉不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					现病史
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<textarea type="text" placeholder="现病史" id="update_log_present_illness" class="col-xs-12" data-validate="required:现病史不能为空哦！"></textarea>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					既往史
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<textarea type="text" placeholder="既往史" id="update_log_history_present_illness" class="col-xs-12" data-validate="required:既往史不能为空哦！"></textarea>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					诊断
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<textarea type="text" placeholder="诊断" id="update_lof_diagnosis" class="col-xs-12" data-validate="required:诊断不能为空哦！"></textarea>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					检验建议
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<textarea class="col-xs-12" id="update_lof_proposal" placeholder="检验建议" data-validate="required:检验建议不能为空哦！"></textarea>
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
		activityList();
		doctorList();
		patientList();
	})
	
	function activityList(){
		var val=$('#update_join_type').val();
		if(val=='0'){
			$('.shop').show();
			$('.person').hide();
			$('#update_store_id').attr('data-validate','required:请选择！');
			$('#update_user_id').attr('data-validate','backTrue:');

		}else{
			$('.shop').hide();
			$('.person').show();
			$('#update_store_id').attr('data-validate','backTrue:');
			$('#update_user_id').attr('data-validate','required:请选择门店！');
		}
	}
	function doctorList(){
		var val=$('#update_doctor_id').val();
		$('#update_doctor_id').attr('data-validate','required:请选择！');
		}
	
	function patientList(){
		var val=$('#update_inquiry_patient_id').val();
		$('#update_inquiry_patient_id').attr('data-validate','required:请选择！');

		}
</script>
