	<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 550px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> </font>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				账号
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="账号" readonly="readonly" class="col-xs-12"  value="${map.account_number}" onchange="$('#isUpdate').attr('value','y')">
				</span>
			</div>
		</div>
		<c:if test="${info.openType=='pwd' }">
			<div class="form-group field">
				<label class="col-sm-3 control-label no-padding-right">
					新密码
				</label>
				<div class="col-sm-5">
					<span class="block input-icon input-icon-right">
						<input type="password" placeholder="新密码" id="password" name="password" class="col-xs-12" data-validate="required:密码不能为空哦！" value="" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
			<div class="form-group field">
				<label class="col-sm-3 control-label no-padding-right">
					确认密码
				</label>
				<div class="col-sm-5">
					<span class="block input-icon input-icon-right">
						<input type="password" placeholder="确认密码" id="update_account_pwd" class="col-xs-12" data-validate="required:密码不能为空哦！,repeat#password:两次输入的密码不一致" value="" >
					</span>
				</div>
			</div>
		</c:if>
		<c:if test="${info.openType=='all' }">
			<div class="form-group field">
				<label class="col-sm-3 control-label no-padding-right">
					账户名称
				</label>
				<div class="col-sm-5">
					<span class="block input-icon input-icon-right">
						<input type="text" placeholder="账户名称" id="update_account_name" class="col-xs-12" data-validate="required:账户名称不能为空哦！" value="${map.account_name}" onchange="$('#isUpdate').attr('value','y')">
					</span>
				</div>
			</div>
		</c:if>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-5">
				<textarea class="col-xs-12" id="beiZhu" placeholder="备注" onchange="$('#isUpdate').attr('value','y')">${map.bz}</textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.account_id}')">
				确认
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
