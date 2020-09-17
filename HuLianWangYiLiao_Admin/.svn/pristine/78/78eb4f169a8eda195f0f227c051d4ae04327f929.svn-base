/****** 字典数据 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilDictionariesData(page){
	loadingDiv();
	var query_dictionaries_data_code = $("#query_dictionaries_data_code").val();
	var query_dictionaries_data_name = $("#query_dictionaries_data_name").val();
	var json = {
		"dictionaries_data_code" : query_dictionaries_data_code,
		"dictionaries_data_name" : query_dictionaries_data_name,
 		 "dictionaries_data_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(dictionaries_type_id){
	var jsonAjax = {
		"url" : "utilDictionariesData_addPage.do",
		"jsonData" : {"mapStr":jsonToStr({'dictionaries_type_id':dictionaries_type_id})},
		"title" : "字典数据添加",
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
	var update_dictionaries_type_id = $("#update_dictionaries_type_id").val();
	var update_dictionaries_data_code = $("#update_dictionaries_data_code").val();
	var update_dictionaries_data_name = $("#update_dictionaries_data_name").val();
	var jsonObj = {
		"dictionaries_type_id" : update_dictionaries_type_id,
		"dictionaries_data_code" : update_dictionaries_data_code,
		"dictionaries_data_name" : update_dictionaries_data_name,
		"dictionaries_data_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonData = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilDictionariesData_updateData.do",
		"jsonData" : jsonData,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"dictionaries_data_id" : id};
	var jsonAjax = {
		"url" : "utilDictionariesData_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "字典数据编辑",
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
	var jsonData = getUpdateMainJson(jsonObj.id);
	var jsonAjax = {
		"url" : "utilDictionariesData_updateData.do",
		"jsonData" : jsonData,
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
			'url' : 'utilDictionariesData_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/