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
					医院
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="医院" id="update_hospital_id" class="col-xs-12" data-validate="required:医院不能为空哦！" value="${map.hospital_id}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
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
					检验单名称
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="检验单名称" id="update_checklist_name" class="col-xs-12" data-validate="required:检验单名称不能为空哦！" value="${map.checklist_name}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					检验单号
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="检验单号" id="update_checklist_code" class="col-xs-12" data-validate="required:检验单号不能为空哦！" value="${map.checklist_code}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					检验单类型
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<select class="select" id="update_checklist_type" data-validate="required:检验单类型不能为空哦！">
						<option value="">--请选择--</option>
						<option <c:if test="${map.checklist_type=='1'}">selected="selected"</c:if> value="1">普通建议单</option>
						<option <c:if test="${map.checklist_type=='2'}">selected="selected"</c:if> value="2">心电检验单</option>
						<option <c:if test="${map.checklist_type=='3'}">selected="selected"</c:if> value="3">普通检验单</option>
					</select>
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					上次单号
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="上次单号" id="update_checklist_last_code" class="col-xs-12" data-validate="required:上次单号不能为空哦！" value="${map.checklist_last_code}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					摘要
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="摘要" id="update_checklist_abstract" class="col-xs-12" data-validate="required:摘要不能为空哦！" value="${map.checklist_abstract}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					收缩压
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="收缩压" id="update_checklist_sbp" class="col-xs-12" data-validate="required:收缩压不能为空哦！" value="${map.checklist_sbp}" >
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
						<input type="text" placeholder="舒张压" id="update_checklist_dbp" class="col-xs-12" data-validate="required:舒张压不能为空哦！" value="${map.checklist_dbp}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					是否使用过洋地黄
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<select class="select" id="update_is_digitalization" data-validate="required:是否使用过洋地黄不能为空哦！">
						<option value="">--请选择--</option>
						<option <c:if test="${map.is_digitalization=='0'}">selected="selected"</c:if> value="0">否</option>
						<option <c:if test="${map.is_digitalization=='1'}">selected="selected"</c:if> value="1">是</option>
					</select>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					使用洋地黄用量
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="使用洋地黄用量" id="update_checklist_digitalization_num" class="col-xs-12" data-validate="required:使用洋地黄用量不能为空哦！" value="${map.checklist_digitalization_num}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					使用洋地黄开始时间
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="使用洋地黄开始时间" id="update_checklist_digitalization_start" class="col-xs-12 Wdate" data-validate="required:使用洋地黄开始时间不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${map.checklist_digitalization_start}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					使用洋地黄结束时间
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="使用洋地黄结束时间" id="update_checklist_digitalization_end" class="col-xs-12 Wdate" data-validate="required:使用洋地黄结束时间不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${map.checklist_digitalization_end}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					是否使用有关药物
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<select class="select" id="update_is_other_drugs" data-validate="required:是否使用有关药物不能为空哦！">
						<option value="">--请选择--</option>
						<option <c:if test="${map.is_other_drugs=='0'}">selected="selected"</c:if> value="0">否</option>
						<option <c:if test="${map.is_other_drugs=='1'}">selected="selected"</c:if> value="1">是</option>
					</select>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					有关药物名称
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="有关药物名称" id="update_checklist_other_drugs_name" class="col-xs-12" data-validate="required:有关药物名称不能为空哦！" value="${map.checklist_other_drugs_name}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					有关药物开始时间
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="有关药物开始时间" id="update_checklist_other_drugs_start" class="col-xs-12 Wdate" data-validate="required:有关药物开始时间不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${map.checklist_other_drugs_start}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					有关药物结束时间
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="有关药物结束时间" id="update_checklist_other_drugs_end" class="col-xs-12 Wdate" data-validate="required:有关药物结束时间不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${map.checklist_other_drugs_end}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					有关药物用量
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="有关药物用量" id="update_checklist_other_drugs_num" class="col-xs-12" data-validate="required:有关药物用量不能为空哦！" value="${map.checklist_other_drugs_num}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					有关检验结果
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="有关检验结果" id="update_checklist_inspection_result" class="col-xs-12" data-validate="required:有关检验结果不能为空哦！" value="${map.checklist_inspection_result}" >
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
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.checklist_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
