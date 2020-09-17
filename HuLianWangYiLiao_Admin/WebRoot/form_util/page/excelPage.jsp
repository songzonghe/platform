<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.my-flex{
	display: inline-flex;
    padding: 22px;
    margin-left: 0 !important;
    margin-right: 0 !important;
}
.my-input{
	display: none !important;
}
.parameter{
	color: red;
	font-size: 13px;
	padding: 10px 10px 10px 70px;
}
.parameter span{
	margin-right: 10px;
}
button{
	padding: 5px 10px;
	margin: 0px 10px;
	border: none;
	color: #fff;
	background: #9DC8F4;	
	border-radius: 5px;
}
button.active{
	background: #4AA5EF;	
}
</style>
<div class="widget-main no-padding excel" style="min-width: 550px;margin: 15px;">
	<form class="form-horizontal " isValidate="y" onsubmit="return false;">
		<div style="">请选择导入文件<button class="active" onclick="importGetDataPage('${dataBaseName}')">下载导入模板</button></div>
		<div class="form-group field my-flex">
			<input class="my-input" type="file" name="uploadName" id="excels_file" onchange="changeFile(this)"/>
			<div class="col-red" style="font-size: 15px">导入文件:</div>
			<button class="active" onclick="$('#excels_file').click()">浏览</button>
			<input  type="text" id="lookFiles" readonly="readonly" style="background-color: #fff !important;width:300px"/>
			<button  class="" onclick="uploadExcel('excels','${dataBaseName}')">导入</button>
		</div>
	</form>
</div>
<script>
function changeFile(obj){
	var name=$(obj).val();
	if(!isUndefinedAndEmpty(name=$(obj).val())){
		var boolFileName=name.substring(name.lastIndexOf('.')+1);
		if(boolFileName=='xls' || boolFileName=='xlsx'){
			var showname=name.substring(name.lastIndexOf('\\')+1);
			$('#lookFiles').val(showname)
		}else{
			$('#excels_file').val("");
			adminJS.alert({'title':'导入提示','info':'请选择以 .xls结尾的文件！'});
		}
	}
}
</script>
