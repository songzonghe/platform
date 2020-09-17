<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 800px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				显示位置
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="radio" name="update_questions_type" checked="checked" value="1">用户端&nbsp;&nbsp;
					<input style="margin-top: 10px;" type="radio" name="update_questions_type" value="2">医生端
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				问题
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<textarea class="col-xs-12" id="update_questions" data-validate="required:问题不能为空哦！" placeholder="问题"></textarea>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				答案
			</label>
			<div class="col-sm-5">
				<textarea class="col-xs-12" id="update_frequently" data-validate="required:答案不能为空哦！" placeholder="答案"></textarea>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				显示排序
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="显示序号" id="update_sort" class="col-xs-12" data-validate="required:显示序号不能为空哦！,number:请输入整数">
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
			<button type="submit" class="btn btn-sm btn-success" onclick="addDataValidate()">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
