<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 550px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		
		<input type="hidden"  id="update_checklist_up_class_id" class="col-xs-12" value="${info.checklist_class_id}">
		<c:if test="${info.checklist_class_id!=0}">
			<div class="form-group field">
				<label class="col-sm-3 control-label no-padding-right">
					上级名称
				</label>
				<div class="col-sm-5">
					<span class="block input-icon input-icon-right">
						<input type="text" readonly="readonly" class="col-xs-12" value="${upmap.checklist_class_name}" >
					</span>
				</div>
			</div>
		</c:if>
		
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				分类名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="" id="update_checklist_class_name" class="col-xs-12" data-validate="required:检查分类名称不能为空哦！">
				</span>
			</div>
		</div>
		
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				分类排序
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_checklist_class_sort" class="col-xs-12" data-validate="required:检查分类排序不能为空哦！,number:只能是数字哦！">
				</span>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="addDataValidate('${info.findType}')">
				提交
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
