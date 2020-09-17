<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 880px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong>药品表录入</strong> </font>
		</div>
		
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品名称
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品名称" id="update_drug_name" class="col-xs-12" data-validate="required:药品名称不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					药品英文名称
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品英文名称" id="update_drug_usname" class="col-xs-12" data-validate="required:药品英文名称不能为空哦！">
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
						<input type="text" placeholder="药品公司" id="update_drug_company" class="col-xs-12" data-validate="required:药品公司不能为空哦！">
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
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_drug_img" class="radius" width="80px" height="80px">
							<input type="file" id="update_drug_img_file" name="uploadName" onchange="uploadImg('update_drug_img',0,0)">
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
						<input type="text" placeholder="药品单位" id="update_drug_unit" class="col-xs-12" data-validate="required:药品单位不能为空哦！">
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
						<input type="text" placeholder="药品价格" id="update_drug_price" class="col-xs-12" data-validate="required:药品价格不能为空哦！,double:只能是数字哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					药品说明书
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品说明书" id="update_drug_instructions" class="col-xs-12" data-validate="required:药品说明书不能为空哦！">
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
						<input style="margin-top: 10px;" type="radio" checked="checked" name="update_drug_is_rx" value="0">非处方药&nbsp;&nbsp;
					<input type="radio" name="update_drug_is_rx" value="1">处方药
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					药品类型
				</label>
				<div class="col-sm-8 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" type="radio" checked="checked" name="update_drug_type" value="1">中药&nbsp;&nbsp;
					<input type="radio" name="update_drug_type" value="2">西药
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
							<option value="1">西药用法</option>
							<option value="2">中药特殊服用用法</option>
							<option value="3">中药服用方法</option>
							<option value="4">中药服用要求</option>
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
							<option value="">请选择</option>
							<c:forEach items="${frequencyList}" var="frequencyList">
								<option value="${frequencyList.frequency_id}">${frequencyList.frequency_name}</option>
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
							<option value="">请选择</option>
							<c:forEach items="${frequencyList}" var="frequencyList">
								<option value="${frequencyList.frequency_id}">${frequencyList.frequency_name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
		</div>
		
		<div class="row">
		<div class="form-group  col-sm-12 field">
				<label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;">
					药品规格
				</label>
				<div class="col-sm-10 field">
					<span class="block input-icon input-icon-right col-xs-12">
						<input type="text" placeholder="重量" id="update_drug_weight_num" class="col-xs-1">
						<select class="select col-xs-2" id="update_drug_weight_unit">
							<option value="">请选择</option>
							<c:forEach items="${weightList}" var="weightList">
								<option value="${weightList.usage_name}">${weightList.usage_name}</option>
							</c:forEach>
						</select>
						<input type="text" placeholder="体积" id="update_drug_volume_num" class="col-xs-1">
						<select class="select col-xs-2" id="update_drug_volume_unit">
							<option value="">请选择</option>
							<c:forEach items="${volumeList}" var="volumeList">
								<option value="${volumeList.usage_name}">${volumeList.usage_name}</option>
							</c:forEach>
						</select>
						<span style="float:left;width: 15px;text-align: center;display: inline-block;">*</span>
						
						<input type="text" placeholder="包装量" id="update_drug_packaging_num" class="col-xs-1" data-validate="required:包装量不能为空哦！">
						<select class="select col-xs-2" id="update_drug_smallest_unit"  data-validate="required:最小单位不能为空哦！">
							<option value="">请选择</option>
							<c:forEach items="${smallestList}" var="smallestList">
								<option value="${smallestList.usage_name}">${smallestList.usage_name}</option>
							</c:forEach>
						</select>
						<span  style="float:left;width: 15px;text-align: center;display: inline-block;">/</span>
						
						<select class="select col-xs-2" id="update_drug_packaging_unit"  data-validate="required:包装单位不能为空哦！">
							<option value="">请选择</option>
							<c:forEach items="${packagingList}" var="packagingList">
								<option value="${packagingList.usage_name}">${packagingList.usage_name}</option>
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
					<textarea style="width: 81%;" id="beiZhu" placeholder="备注"></textarea>
				</div>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="addDataValidate_utilDrug('${map.class_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
