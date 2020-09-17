/****** 药品用法 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilDrugUsage(page){
	if(isUndefinedAndEmpty(page)){
		page=0;
	}
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_usage_type = $("#query_usage_type").val();
	var query_usage_name = $("#query_usage_name").val();
	var query_usage_sort = $("#query_usage_sort").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"usage_type" : query_usage_type,
		"usage_name" : query_usage_name,
		"usage_sort" : query_usage_sort,
 		 "usage_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilDrugUsage_addPage.do",
		"jsonData" : null,
		"title" : "药品用法添加",
		"icon" : "plus",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

function addDataValidate(){
	var jsonObj={
		"methodName":"addData"
	};
	jsonValidate = jsonObj;
}

function getUpdateMainJson(id) {
	var update_hospital_id = $("#update_hospital_id").val();
	var update_usage_type = $("#update_usage_type").val();
	var update_usage_name = $("#update_usage_name").val();
	var usage_printing_name = $("#update_usage_printing_name").val();
	var update_usage_sort = $("#update_usage_sort").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"usage_type" : update_usage_type,
		"usage_name" : update_usage_name,
		"usage_printing_name":usage_printing_name,
		"usage_sort" : update_usage_sort,
		"usage_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilDrugUsage_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"usage_id" : id};
	var jsonAjax = {
		"url" : "utilDrugUsage_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "药品用法编辑",
		"icon" : "edit",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

function editDataValidate(id){
	var jsonObj={
		"methodName":"editData",
		"id":id
		};
	jsonValidate = jsonObj;
}

function editData(jsonObj){
	var jsonAjax = {
		"url" : "utilDrugUsage_updateData.do",
		"jsonData" : getUpdateMainJson(jsonObj.id),
		"methodName" : "update_edit",
		"toID" :"tbodyData"
	};
	getAjaxData(jsonAjax);
}

function confirmDeleteDate(id,name){
	var jsonObj = {
		'title':'操作提示',
		"info":' <span class="red">确认删除</span> ?',
		'id':id
	};
	adminJS.confirm(jsonObj,function(e,id){
		if(e==0){
			return ;
		}
		var jsonPar = {
			'id' : getStr(id)
		};
		var jsonAjax = {
			'url' : 'utilDrugUsage_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/