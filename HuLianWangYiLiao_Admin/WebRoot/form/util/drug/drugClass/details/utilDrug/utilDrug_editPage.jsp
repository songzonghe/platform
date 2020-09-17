<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 880px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong>药品表编辑</strong> </font>
		</div>
		
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品名称
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品名称" id="update_drug_name" class="col-xs-12" data-validate="required:药品名称不能为空哦！" value="${map.drug_name}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					药品英文名称
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品英文名称" id="update_drug_usname" class="col-xs-12" data-validate="required:药品英文名称不能为空哦！" value="${map.drug_usname}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品公司
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品公司" id="update_drug_company" class="col-xs-12" data-validate="required:药品公司不能为空哦！" value="${map.drug_company}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品主图
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<div class="field">
						<a href="javascript:;" class="file">
							<img src="${map.drug_img}" name="uploadNameImg" id="update_drug_img" class="radius" width="80px" height="80px">
							<input type="file" id="update_drug_img_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_drug_img',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_drug_img');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					药品单位
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品单位" id="update_drug_unit" class="col-xs-12" data-validate="required:药品单位不能为空哦！" value="${map.drug_unit}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品价格
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品价格" id="update_drug_price" class="col-xs-12" data-validate="required:药品价格不能为空哦！,double:只能是数字哦!" value="${map.drug_price}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					药品说明书
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品说明书" id="update_drug_instructions" class="col-xs-12" data-validate="required:药品说明书不能为空哦！" value="${map.drug_instructions}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					是否处方
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" type="radio" <c:if test="${map.drug_is_rx==0}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')" name="update_drug_is_rx" value="0">非处方药&nbsp;&nbsp;
					<input type="radio" name="update_drug_is_rx" <c:if test="${map.drug_is_rx==1}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')"  value="1">处方药
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					药品类型
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
					<input style="margin-top: 10px;" type="radio" name="update_drug_type"  <c:if test="${map.drug_type==1}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')" value="1">中药&nbsp;&nbsp;
					<input type="radio" name="update_drug_type"  <c:if test="${map.drug_type==2}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')" value="2">西药
					</span>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					用法类型
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<select class="select" id="update_usage_type" onchange="find_uplist()" data-validate="required:用法类型不能为空哦！">
							<option value="">--请选择--</option>
							<option <c:if test="${map.usage_type=='1'}">selected="selected"</c:if> value="1">西药用法</option>
							<option <c:if test="${map.usage_type=='2'}">selected="selected"</c:if> value="2">中药特殊服用用法</option>
							<option <c:if test="${map.usage_type=='3'}">selected="selected"</c:if> value="3">中药服用方法</option>
							<option <c:if test="${map.usage_type=='4'}">selected="selected"</c:if> value="4">中药服用要求</option>
						</select>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					用法名称
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<select class="select" id="update_usage_id"  data-validate="required:用法名称不能为空哦！">
							<c:forEach items="${usageList}" var="usageList">
								<option <c:if test="${map.usage_id==usageList.usage_id}">selected="selected"</c:if> value="${usageList.usage_id}">${usageList.usage_name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					频率名称
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<select class="select" id="update_frequency_id"  data-validate="required:频率名称不能为空哦！">
							<c:forEach items="${frequencyList}" var="frequencyList">
								<option <c:if test="${map.frequency_id==frequencyList.frequency_id}">selected="selected"</c:if> value="${frequencyList.frequency_id}">${frequencyList.frequency_name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
		</div>
		
		<div class="row">
		<div class="form-group col-sm-12 field">
				<label class="col-sm-2 control-label no-padding-right">
					药品规格
				</label>
				<div class="col-sm-10 field">
					<span class="block input-icon input-icon-right col-xs-12">
						<input type="text" placeholder="重量" id="update_drug_weight_num" class="col-xs-1" value="${map.drug_weight_num}">
						<select class="select col-xs-2" id="update_drug_weight_unit">
							<option value="">请选择</option>
							<c:forEach items="${weightList}" var="weightList">
								<option <c:if test="${map.drug_weight_unit==weightList.usage_name}">selected="selected"</c:if> value="${weightList.usage_name}">${weightList.usage_name}</option>
							</c:forEach>
						</select>
						<input type="text" placeholder="体积" id="update_drug_volume_num" class="col-xs-1" value="${map.drug_volume_num}">
						<select class="select col-xs-2" id="update_drug_volume_unit">
							<option value="">请选择</option>
							<c:forEach items="${volumeList}" var="volumeList">
								<option <c:if test="${map.drug_volume_unit==volumeList.usage_name}">selected="selected"</c:if> value="${volumeList.usage_name}">${volumeList.usage_name}</option>
							</c:forEach>
						</select>
						<span style="float:left;width: 15px;text-align: center;display: inline-block;">*</span>
						<input type="text" placeholder="包装量" id="update_drug_packaging_num" class="col-xs-1" data-validate="required:包装量不能为空哦！" value="${map.drug_packaging_num}">
						<select class="select col-xs-2" id="update_drug_smallest_unit"  data-validate="required:最小单位不能为空哦！">
							<option value="">请选择</option>
							<c:forEach items="${smallestList}" var="smallestList">
								<option <c:if test="${map.drug_smallest_unit==smallestList.usage_name}">selected="selected"</c:if> value="${smallestList.usage_name}">${smallestList.usage_name}</option>
							</c:forEach>
						</select>
						<span  style="float:left;width: 15px;text-align: center;display: inline-block;">/</span>
						<select class="select col-xs-2" id="update_drug_packaging_unit"  data-validate="required:包装单位不能为空哦！">
							<option value="">请选择</option>
							<c:forEach items="${packagingList}" var="packagingList">
								<option <c:if test="${map.drug_packaging_unit==packagingList.usage_name}">selected="selected"</c:if> value="${packagingList.usage_name}">${packagingList.usage_name}</option>
							</c:forEach>
						</select>
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
					<textarea style="width: 81%;" id="beiZhu" placeholder="备注" onchange="$('#isUpdate').attr('value','y')">${map.bz}</textarea>
				</div>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate_utilDrug('${map.drug_id}','${map.class_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
