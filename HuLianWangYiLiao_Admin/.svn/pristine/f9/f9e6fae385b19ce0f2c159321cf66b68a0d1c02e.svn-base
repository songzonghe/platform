/****** 药品使用频率 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilDrugFrequency(page){
	if(isUndefinedAndEmpty(page)){
		page=0;
	}
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_frequency_name = $("#query_frequency_name").val();
	var query_frequency_num = $("#query_frequency_num").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"frequency_name" : query_frequency_name,
		"frequency_num" : query_frequency_num,
 		 "frequency_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilDrugFrequency_addPage.do",
		"jsonData" : null,
		"title" : "药品使用频率添加",
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
	var update_frequency_name = $("#update_frequency_name").val();
	var update_frequency_printing_name = $("#update_frequency_printing_name").val();
	var update_frequency_num = $("#update_frequency_num").val();
	var update_frequency_day_num = $("#update_frequency_day_num").val();
	var update_frequency_sort = $("#update_frequency_sort").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"frequency_name" : update_frequency_name,
		"frequency_printing_name":update_frequency_printing_name,
		"frequency_num" : update_frequency_num,
		"frequency_day_num":update_frequency_day_num,
		"frequency_sort" : update_frequency_sort,
		"frequency_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilDrugFrequency_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"frequency_id" : id};
	var jsonAjax = {
		"url" : "utilDrugFrequency_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "药品使用频率编辑",
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
		"url" : "utilDrugFrequency_updateData.do",
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
			'url' : 'utilDrugFrequency_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/