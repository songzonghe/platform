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
				规范名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="规范名称" id="update_specification_name" class="col-xs-12" data-validate="required:规范名称不能为空哦！" value="${map.specification_name}" >
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				规范说明
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<textarea type="text" placeholder="规范说明" id="update_specification_details" class="col-xs-12" data-validate="required:规范说明不能为空哦！" value="${map.specification_details}" >${map.specification_details}</textarea>
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				规范排序
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="规范排序" id="update_specification_sort" class="col-xs-12" data-validate="required:规范排序不能为空哦！" value="${map.specification_sort}" >
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
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.specification_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
