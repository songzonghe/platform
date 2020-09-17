<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 800px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		<c:forEach items="${mapData.functionslist}" var="info">
			<div class="form-group field">
				<label class="col-sm-12 control-label" style="text-align:left;margin-left: 60px;">
					${info.name}
				</label>
				</div>
			<c:forEach items="${info.data}" var="datas">
				<div class="form-group field">
						<span class="col-sm-4 control-label" style="text-align:left;margin-left: 80px;display: flex;align-items: center;">
							<input type="checkbox" id="cid${datas.functions_id}" name="cid" <c:if test="${datas.is_sel=='1'}"> checked="checked" </c:if> value="${datas.functions_id}">${datas.functions_name}
						</span>
						<div class="col-sm-6">
							<span class="input-icon">
									<input name="zhuPage" <c:if test="${datas.is_zhu=='1'}"> checked="checked" </c:if> type="radio" value="${datas.functions_id}">首页
							</span>
						</div>
				</div> 
			</c:forEach>
		</c:forEach>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-info" onclick="getAllCheckBack()">
				取消全选
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="button" class="btn btn-sm btn-pink" onclick="getAllCheck()">
				全选
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="addFunctionData('${map.account_id}')">
				确认
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	//选中地址或取消
	$('input[name="cid"]').click(function(){
		if(!$(this).prop("checked")){
			var data=$('input[name="zhuPage"]:checked').val();
			if(!isUndefinedAndEmpty(data)&&data==$(this).val()){
				$('input[name="zhuPage"]').prop("checked", false);
			}
		}
	});
	//对主页  选中/取消  权限
	$('input[name="zhuPage"]').click(function(){
		if($(this).prop("checked")){
			if(!$('#cid'+$(this).val()).prop("checked")){
				$('#cid'+$(this).val()).prop("checked", true);
			}
		}
	});
	//全选
	function getAllCheck(){
		$('input[type="checkbox"]').prop("checked", true);
	}
	//全取消选
	function getAllCheckBack(){
		$('input[type="checkbox"]').prop("checked", false);
		$('input[type="radio"]').prop("checked", false);
	}
</script>
