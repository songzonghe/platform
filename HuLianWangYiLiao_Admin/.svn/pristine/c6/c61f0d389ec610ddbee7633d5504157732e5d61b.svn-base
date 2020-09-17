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
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="问诊记录" id="update_log_id" class="col-xs-12" data-validate="required:问诊记录不能为空哦！" value="${map.log_id}" >
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
					医生名字
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="医生名字" id="update_doctor_id" class="col-xs-12" data-validate="required:医生名字不能为空哦！" value="${map.doctor_id}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					建议医院
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="建议医院" id="update_hospitalization_hospital" class="col-xs-12" data-validate="required:建议医院不能为空哦！" value="${map.hospitalization_hospital}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					建议科室
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="建议科室" id="update_hospitalization_department" class="col-xs-12" data-validate="required:建议科室不能为空哦！" value="${map.hospitalization_department}" >
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
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.hospitalization_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
