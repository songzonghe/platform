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
				分类
			</label>
			<div class="col-sm-5">
				<select class="col-xs-12 select" data-find="find" id="update_icd_id" data-validate="required:分类名称不能为空哦！">
					<option value="">--请选择--</option>
					<c:forEach items="${icdList}" var="info">
						<option value="${info.icd_id}" <c:if test="${info.icd_id==map.icd_id}">selected</c:if> >${info.icd_name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				诊段名称
			</label>
			<div class="col-sm-5">
					<select class="col-xs-12 select" data-find="find" id="update_diagnosis_id" data-validate="required:诊段名称不能为空哦！">
						<option value="">--请选择--</option>
						<c:forEach items="${diagnosisList}" var="info">
								<option value="${info.diagnosis_id}" <c:if test="${info.diagnosis_id==map.diagnosis_id}">selected</c:if> >${info.diagnosis_name}</option>
							</c:forEach>
					</select>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				医生名字
			</label>
			<div class="col-sm-5">
				<select class="col-xs-12 select" data-find="find" id="update_doctor_id" data-validate="required:医生名字不能为空哦！">
					<option value="">--请选择--</option>
					<c:forEach items="${doctorList}" var="info">
							<option value="${info.doctor_id}" <c:if test="${info.doctor_id==map.doctor_id}">selected</c:if> >${info.doctor_name}</option>
						</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				处方类型
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;" type="radio" <c:if test="${map.prescription_type=='1'}">checked="checked"</c:if> name="update_prescription_type" value="1" >中药&nbsp;&nbsp;
					<input type="radio" name="update_prescription_type" value="2" <c:if test="${map.prescription_type=='2'}">checked="checked"</c:if>>西药
					<input type="radio" name="update_prescription_type" value="3" <c:if test="${map.prescription_type=='3'}">checked="checked"</c:if>>中成药
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				处方金额
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="处方金额" id="update_prescription_price" class="col-xs-12" data-validate="required:处方金额不能为空哦！,double:请输入数字！" value="${map.prescription_price}" >
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
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.prescription_id}')">
				提交
			</button>
		</div>
	</form>
</div>
<script>
	initValidate(true);
</script>
