<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 550px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong>系统检验检查录入</strong> </font>
		</div>
			<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				检查类型
			</label>
			<div class="col-sm-8">
				<span class="block input-icon input-icon-right">
				<input style="margin-top: 10px;" type="radio" checked="checked" name="update_checklist_type" value="1">检验&nbsp;&nbsp;
				<input type="radio" name="update_checklist_type" value="2">检查&nbsp;&nbsp;
				<input type="radio" name="update_checklist_type" value="3">心电检验&nbsp;&nbsp;
				<input type="radio" name="update_checklist_type" value="4">普通检验
				</span>
			</div>
		</div>
			<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				检查名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
				<input type="text" placeholder="检查名称" id="update_checklist_name" class="col-xs-12" data-validate="required:检查名称不能为空哦！">
				</span>
			</div>
		</div>
			<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				排序
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
				<input type="text" id="update_checklist_sort" class="col-xs-12" data-validate="required:排序不能为空哦！,number:只能是数字哦！">
				</span>
			</div>
		</div>
			<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-5">
				<textarea class="col-xs-12" id="beiZhu" placeholder="备注"></textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="addDataValidate_utilChecklist('${map.checklist_class_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
