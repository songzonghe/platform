<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 800px;min-height:400px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
		</div>
		<div class="form-group field">
			<label class="col-sm-2 control-label no-padding-right">
				医生
			</label>
			<div class="col-sm-8">
				<span class="block input-icon input-icon-right">
					<select id="update_doctor_id" class="select" data-find="find" data-show-title="2" data-title="科室:20%;手机:20%;名称:20%;拼音:20%;五笔:20%" data-validate="required:医生不能为空哦！">
						<option value="">请选择</option>
						<c:forEach var="doctors" items="${doctorList}">
							<option value="${doctors.doctor_id}">${doctors.department_name};;${doctors.doctor_phone};;${doctors.doctor_name};;${doctors.doctor_name_pinyin};;${doctors.doctor_name_wubi}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-4 control-label no-padding-right">
				日期
			</label>
			<div class="col-sm-4">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="日期" id="update_scheduling_date" oninput="alert(22)" class="col-xs-12 Wdate" data-validate="required:日期不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});">
				</span>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-3 field">
				<label class="col-sm-9 control-label no-padding-right">
					班次
				</label>
			</div>
			<div class="form-group col-sm-3 field">
				<label class="col-sm-6 control-label no-padding-right">
						<input style="margin-top: 10px;" type="checkbox" id="update_is_morning" checked="checked" value="1">
					上午
				</label>
			</div>
			<div class="form-group col-sm-3 field">
				<label class="col-sm-6 control-label no-padding-right">
						<input style="margin-top: 10px;" type="checkbox" id="update_is_afternoon" checked="checked" value="1">
					下午
				</label>
			</div>
			<div class="form-group col-sm-3 field">
				<label class="col-sm-6 control-label no-padding-right">
					<input style="margin-top: 10px;" type="checkbox" id="update_is_night" checked="checked" value="1">
					晚上
				</label>
			</div>
		</div>
		<!-- <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-5">
				<textarea class="col-xs-12" id="beiZhu" placeholder="备注"></textarea>
			</div>
		</div> -->
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
	initValidate(true);
</script>
