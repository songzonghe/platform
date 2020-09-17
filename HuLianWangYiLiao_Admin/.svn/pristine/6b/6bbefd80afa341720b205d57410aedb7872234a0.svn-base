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
					关联类型
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" type="radio" <c:if test="${map.join_type=='1'}">checked="checked"</c:if> name="update_join_type" value="1" >个人&nbsp;&nbsp;
					<input type="radio" name="update_join_type" value="1" <c:if test="${map.join_type=='1'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">门店
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					关联名称
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="关联名称" id="update_join_id" class="col-xs-12" data-validate="required:不能为空哦！"" value="${map.join_id}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					问诊类型
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" data-validate="required:不能为空哦！" type="radio" <c:if test="${map.inquiry_patient_type=='0'}">checked="checked"</c:if> name="update_inquiry_patient_type" value="0" >为自己问诊&nbsp;&nbsp;
						<input type="radio" data-validate="required:不能为空哦！" name="update_inquiry_patient_type" value="1" <c:if test="${map.inquiry_patient_type=='1'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">为别人问诊
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					头像
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<div class="field">
						<a href="javascript:;" class="file">
							<c:if test="${empty map.inquiry_patient_img}">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_inquiry_patient_img" class="radius" width="80px" height="80px">
							</c:if>
							<c:if test="${!empty map.inquiry_patient_img}">
							<img src="${map.inquiry_patient_img}" name="uploadNameImg" id="update_inquiry_patient_img" class="radius" width="80px" height="80px">
							</c:if>
							<input type="file" id="update_inquiry_patient_img_file" data-validate="required:不能为空哦！" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_inquiry_patient_img',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_inquiry_patient_img');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					姓名
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="姓名" id="update_inquiry_patient_name" class="col-xs-12" data-validate="required:不能为空哦！" value="${map.inquiry_patient_name}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					身份证号码
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="身份证号码" id="update_inquiry_patient_idcard" class="col-xs-12" data-validate="required:不能为空哦！" value="${map.inquiry_patient_idcard}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					性别
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" data-validate="required:不能为空哦！" type="radio" <c:if test="${map.inquiry_patient_sex=='0'}">checked="checked"</c:if> name="update_inquiry_patient_sex" value="0" >男&nbsp;&nbsp;
					<input type="radio" name="update_inquiry_patient_sex" data-validate="required:不能为空哦！" value="1" <c:if test="${map.inquiry_patient_sex=='1'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">女
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					出生日期
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="出生日期" data-validate="required:不能为空哦！" id="update_inquiry_patient_birthday" class="col-xs-12 Wdate" data-validate="" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${map.inquiry_patient_birthday}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					手机号
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" data-validate="required:不能为空哦！" placeholder="手机号" id="update_inquiry_patient_phone" class="col-xs-12" value="${map.inquiry_patient_phone}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					籍贯
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="籍贯" id="update_inquiry_patient_marital_status" class="col-xs-12" data-validate="required:不能为空哦！" value="${map.inquiry_patient_marital_status}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					体重
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="体重" id="update_inquiry_patient_weight" class="col-xs-12" data-validate="" value="${map.inquiry_patient_weight}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					体重
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="体重" id="update_inquiry_patient_profession_code" class="col-xs-12" data-validate="" value="${map.inquiry_patient_profession_code}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					职业
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="职业" id="update_inquiry_patient_profession" class="col-xs-12" data-validate="required:不能为空哦！" value="${map.inquiry_patient_profession}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					住址
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="住址" id="update_inquiry_patient_address" class="col-xs-12" data-validate="required:不能为空哦！" value="${map.inquiry_patient_address}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					是否药物过敏
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" data-validate="required:不能为空哦！" type="radio" <c:if test="${map.is_drug_allergy=='0'}">checked="checked"</c:if> name="update_is_drug_allergy" value="0" >否&nbsp;&nbsp;
						<input type="radio" name="update_is_drug_allergy" data-validate="required:不能为空哦！" value="1" <c:if test="${map.is_drug_allergy=='1'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">是
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					药物过敏史
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药物过敏史" id="update_iinquiry_patient_allergy_details" class="col-xs-12" data-validate="required:不能为空哦！" value="${map.iinquiry_patient_allergy_details}" >
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
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.inquiry_patient_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
