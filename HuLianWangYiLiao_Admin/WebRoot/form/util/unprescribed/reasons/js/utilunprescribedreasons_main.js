/****** 未开方原因 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilUnprescribedReasons(page){
	loadingDiv();
	var query_reasons_name = $("#query_reasons_name").val();
	var json = {
		"reasons_name" : query_reasons_name,
 		 "reasons_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilUnprescribedReasons_addPage.do",
		"jsonData" : null,
		"title" : "未开方原因添加",
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
	var update_reasons_name = $("#update_reasons_name").val();
	var update_reasons_sort = $("#update_reasons_sort").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"reasons_name" : update_reasons_name,
		"reasons_sort" : update_reasons_sort,
		"reasons_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilUnprescribedReasons_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"reasons_id" : id};
	var jsonAjax = {
		"url" : "utilUnprescribedReasons_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "未开方原因编辑",
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
		"url" : "utilUnprescribedReasons_updateData.do",
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
			'url' : 'utilUnprescribedReasons_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/