<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="widget-main no-padding" style="width: 880px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
			<label class="col-sm-4 control-label no-padding-right">
				处方编号
			</label>
			<div class="col-sm-8 field">
				<span class="block input-icon input-icon-right"> 
					<input type="text" disabled="disabled"   class="col-xs-12" data-validate="" value="${fn:replace(fn:substring(map.lrsj,0,10),'-','')}${map.prescription_id}" >
				</span>
			</div>
		</div>
		<div class="form-group col-sm-6 field">
			<label class="col-sm-2 control-label no-padding-right">
				门诊号
			</label>
			<div class="col-sm-8 field">
				<span class="block input-icon input-icon-right"> 
					<input type="text" disabled="disabled"   class="col-xs-12" data-validate="" value="${fn:replace(fn:substring(map.log_lrsj,0,10),'-','')}${map.log_id}" >
				</span>
			</div>
		</div>
		</div>
		
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					患者名字
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="问诊患者名字" disabled="disabled" id="update_inquiry_patient_name" class="col-xs-12" data-validate="" value="${map.inquiry_patient_name}" >
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					医生名字
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="问诊患者名字" disabled="disabled" id="update_doctor_name" class="col-xs-12" data-validate="" value="${map.doctor_name}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					处方类型
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" disabled="disabled" type="radio" <c:if test="${map.prescription_type=='1'}">checked="checked"</c:if> name="update_prescription_type" value="1" >中药&nbsp;&nbsp;
						<input type="radio" disabled="disabled" name="update_prescription_type" value="2" <c:if test="${map.prescription_type=='2'}">checked="checked"</c:if>>西药&nbsp;&nbsp;
						<input type="radio" disabled="disabled" name="update_prescription_type" value="3" <c:if test="${map.prescription_type=='3'}">checked="checked"</c:if>>中成药
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					处方金额
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" disabled="disabled" placeholder="处方金额" id="update_prescription_price" class="col-xs-12" data-validate="" value="${map.prescription_price}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-12 field">
				<label class="col-sm-2 control-label no-padding-right">
					临床诊断
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<textarea class="col-xs-12" disabled="disabled"  placeholder="服用方法" data-validate="" >${map.lof_diagnosis}</textarea>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-12 field">
				<label class="col-sm-2 control-label no-padding-right">
					服用提醒
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<textarea type="text" disabled="disabled" placeholder="服用要求" id="update_prescription_requirements" class="col-xs-12" >${map.prescription_requirements}  ${map.prescription_taking}<c:if test="${map.prescription_type=='1'}">  ${map.prescription_num}付</c:if></textarea>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
				<div class="form-group col-sm-12">
					<label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;">
						药品详情
					</label>
					<div class="col-sm-10">
					<div style="width: 81%;min-height: 100px !important;border: 1px #d5d5d5 solid;border-radius: 5px;">
						<c:forEach var="details" items="${map.detailsList}" varStatus="i">
							<c:if test="${details.drug_type=='1'}">
								${i.index+1}、${details.drug_name}  ${details.details_consumption}${details.details_consumption_util}  ${details.details_usage}<br>
							</c:if>
							<c:if test="${details.drug_type=='2' or details.drug_type=='3'}">
								${i.index+1}、${details.drug_name}  ${details.details_num}${details.drug_packaging_unit}(${details.drug_specifications})
								<br>&nbsp;&nbsp;&nbsp;&nbsp;Sig:${details.details_usage} ${details.details_frequency_str} 每次${details.details_consumption}${details.details_consumption_util} 用药${details.details_day}天<br>
							</c:if>
						</c:forEach>
					</div>
					</div>
				</div>
			</div>
		
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					审核状态
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<c:if test="${map.zt=='0'}">
							<input type="text" disabled="disabled"  id="" value="审核通过" class="col-xs-12" data-validate="">
						</c:if>
						<c:if test="${map.zt=='2'}">
							<input type="text" disabled="disabled"  id="" value="审核中" class="col-xs-12" data-validate="">
						</c:if>
						<c:if test="${map.zt=='1'}">
							<input type="text" disabled="disabled"  id="" value="已查看 "  class="col-xs-12" data-validate="">
						</c:if>
						<c:if test="${map.zt=='5'}">
							<input type="text" disabled="disabled"  id="" value="已作废 "  class="col-xs-12" data-validate="">
						</c:if>
					</span>
				</div>
			</div>
		</div>
		<c:if test="${map.zt=='5' or map.zt=='2'}">
			<div class="row requirements" <c:if test="${map.zt=='2'}">style="display: none"</c:if>>
				<div class="form-group col-sm-12">
					<label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;">
						作废理由
					</label>
					<div class="col-sm-10">
						<textarea style="width: 81%;" <c:if test="${info.pagetype=='look' or map.zt=='5' }"> disabled="disabled"</c:if> id="update_prescription_reasons_invalidation" data-validate="" placeholder="作废理由" >${map.prescription_reasons_invalidation}</textarea>
					</div>
				</div>
			</div>
		</c:if>
		<div class="row">
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;">
					备注
				</label>
				<div class="col-sm-10">
					<textarea style="width: 81%;"<c:if test="${info.pagetype=='look'}"> disabled="disabled"</c:if> id="beiZhu" placeholder="备注" >${map.bz}</textarea>
				</div>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<c:if test="${info.pagetype=='edit' &&  map.zt!='2'}">
				<button type="button" disabled="disabled" class="btn btn-sm btn-success">
					已审核
				</button>
				<button type="button" disabled="disabled" class="btn btn-sm btn-success">
					已审核
				</button>
			</c:if>
			<c:if test="${info.pagetype=='edit' &&  map.zt=='2'}">
				<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.prescription_id}','0')">
					审核通过
				</button>
				<button type="submit" class="btn btn-sm btn-danger" onclick="editDataValidate('${map.prescription_id}','5')">
					审核不通过
				</button>
			</c:if>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
