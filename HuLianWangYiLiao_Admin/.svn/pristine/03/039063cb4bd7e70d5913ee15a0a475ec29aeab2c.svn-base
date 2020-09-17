<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${root}/form_util/util/util_css/jquery.searchableSelect.css" />
<div class="widget-main no-padding" style="width: 550px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		<div class="form-group col-sm-12 field drug">
			<label class="col-sm-3 control-label no-padding-right">
				药品
			</label>
			<div class="col-sm-5 field">
				<span class="block input-icon input-icon-right">
					<select  id="update_drug_id" class="col-xs-12 select" data-validate="" onchange="drugList()">
						<option value="">请选择</option>
						<c:forEach items="${drugList}" var="info">
							<option value="${info.drug_id}">${info.drug_name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group col-sm-12 field drug2">
			<label class="col-sm-3 control-label no-padding-right">
				药品2
			</label>
			<div class="col-sm-5 field">
				<span class="block input-icon input-icon-right">
					<select  id="update_drug_id2" class="col-xs-12 select" data-validate="" onchange="drugList2()">
						<option value="">请选择</option>
						<c:forEach items="${drugList}" var="info">
							<option value="${info.drug_id}">${info.drug_name}</option>
						</c:forEach>
					</select>
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
	$(function(){
		drugList();
		drugList2();
	});
	initValidate();
	function drugList(){
		var val2=$('#update_drug_id2').val();
		$('#update_drug_id').attr('data-validate','required:请选择药品!,ajax#utilIncompatibility_isBoolData.do?drug_id2='+val2+'&drug_id=:药品已配置！');
		onfrom();
	}
	
	function drugList2(){
		var val=$('#update_drug_id').val();
		$('#update_drug_id2').attr('data-validate','required:请选择药品!,ajax#utilIncompatibility_isBoolData.do?drug_id='+val+'&drug_id2=:药品已配置');
		onfrom();
	}
	
	function onfrom(){
		$('.form-horizontal').find('input[data-validate],textarea[data-validate],select[data-validate]').trigger("blur");
		$('.form-horizontal').find('input[placeholder],textarea[placeholder]').each(function(){hideplaceholder($('.form-horizontal'));});
		var numError = $('.form-horizontal').find('.has-error').length;
		if(numError){
			$('.form-horizontal').find('.has-error').first().find('input[data-validate],textarea[data-validate],select[data-validate]').first().focus().select();
		}
	}
	function hideplaceholder(element){
		if($(element).data("pintuerholder")){
		$(element).val("");
		$(element).css("color", $(element).data("pintuerholder"));		
		$(element).removeData("pintuerholder");
		}
	}
</script>
<script type="text/javascript" src="${root}/form_util/util/sys_js/jquery.searchableSelect.js?<%=Math.random()%>">