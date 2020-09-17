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
					通知类型
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input style="margin-top: 10px;" type="radio" checked="checked" name="update_notice_type" value="1">系统消息&nbsp;&nbsp;
					<input type="radio" name="update_notice_type" value="2">处方消息
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					发送人类型
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input style="margin-top: 10px;" type="radio" checked="checked" name="update_user_type" value="1">用户&nbsp;&nbsp;
					<input type="radio" name="update_user_type" value="2">门店
					<input type="radio" name="update_user_type" value="3">医生
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					发送人名字
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="发送人名字" id="update_user_id" class="col-xs-12" data-validate="">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					通知标题
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="通知标题" id="update_notice_title" class="col-xs-12" data-validate="">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					通知内容
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="通知内容" id="update_notice_content" class="col-xs-12" data-validate="">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					关联
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="关联" id="update_notice_join" class="col-xs-12" data-validate="">
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
