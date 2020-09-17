	<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 750px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				属性类型
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;" type="radio" <c:if test="${map.option_type=='1'}">checked="checked"</c:if> name="update_option_type" value="1" >最小单位&nbsp;&nbsp;
					<input type="radio" name="update_option_type" value="2" <c:if test="${map.option_type=='2'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">包装单位
					<input type="radio" name="update_option_type" value="3" <c:if test="${map.option_type=='3'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">重量单位
					<input type="radio" name="update_option_type" value="4" <c:if test="${map.option_type=='4'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">体积单位 
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				属性名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="属性名称" id="update_usage_name" data-id="${map.option_id}" class="col-xs-12" data-validate="required:属性名称不能为空哦！,ajax#utilDrugAttributeOption_findById.do?id=${map.option_id}&type=${map.option_type}&name=:已存在属性名称" value="${map.usage_name}" >
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				排序
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="排序" id="update_usage_sort" class="col-xs-12" data-validate="required:排序不能为空哦！" value="${map.usage_sort}" >
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
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.option_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
	$('input[name=update_option_type]').click(function (){
		$('#update_usage_name').attr('data-validate','required:属性名称不能为空哦！,ajax#utilDrugAttributeOption_findById.do?id='+$('#update_usage_name').attr('data-id')+'&type='+$(this).val()+'&name=:已存在属性名称')
	});
</script>
