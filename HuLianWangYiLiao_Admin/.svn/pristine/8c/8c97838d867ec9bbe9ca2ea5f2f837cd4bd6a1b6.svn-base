<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 550px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				医生
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="医生" id="update_doctor_id" class="col-xs-12" data-validate="required:医生不能为空哦！" value="${map.doctor_id}" >
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				日期
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="日期" id="update_scheduling_date" class="col-xs-12 Wdate" data-validate="required:日期不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${map.scheduling_date}" >
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				上午
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;" type="radio" <c:if test="${map.is_morning=='0'}">checked="checked"</c:if> name="update_is_morning" value="0" >否&nbsp;&nbsp;
					<input type="radio" name="update_is_morning" value="1" <c:if test="${map.is_morning=='1'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">是
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				下午
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;" type="radio" <c:if test="${map.is_afternoon=='0'}">checked="checked"</c:if> name="update_is_afternoon" value="0" >否&nbsp;&nbsp;
					<input type="radio" name="update_is_afternoon" value="1" <c:if test="${map.is_afternoon=='1'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">是
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				晚上
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;" type="radio" <c:if test="${map.is_night=='0'}">checked="checked"</c:if> name="update_is_night" value="0" >否&nbsp;&nbsp;
					<input type="radio" name="update_is_night" value="1" <c:if test="${map.is_night=='1'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">是
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-5">
				<textarea class="col-xs-12" id="beiZhu" placeholder="备注" >${map.bz}</textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.scheduling_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
