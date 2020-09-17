<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 550px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
		</div>
		<input id="user_type" type="hidden" value="${map.type}">
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				消息标题
			</label>
			<div class="col-sm-8">
				<input type="text" class="col-xs-12" id="update_log_title" placeholder="消息标题" data-validate="required:请填写消息标题！">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				消息内容
			</label>
			<div class="col-sm-8">
				<textarea class="col-xs-12" id="update_log_content" placeholder="消息内容" data-validate="required:请填写消息内容！"></textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
			</button>
			<button type="submit" class="btn btn-sm btn-info" onclick="addMessageDataValidate('1')">
				<c:if test="${map.type=='1'}">发送全部用户</c:if>
				<c:if test="${map.type=='2'}">发送全部门店</c:if>
				<c:if test="${map.type=='3'}">发送全部医生</c:if>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="addMessageDataValidate('2')">
				<c:if test="${map.type=='1'}">选择用户</c:if>
				<c:if test="${map.type=='2'}">选择门店</c:if>
				<c:if test="${map.type=='3'}">选择医生</c:if>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
