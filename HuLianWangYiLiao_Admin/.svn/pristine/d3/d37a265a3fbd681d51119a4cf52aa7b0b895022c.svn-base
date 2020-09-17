/****** 字典表类型 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilDictionariesType(page){
	loadingDiv();
	var query_dictionaries_type_code = $("#query_dictionaries_type_code").val();
	var query_dictionaries_type_name = $("#query_dictionaries_type_name").val();
	var json = {
		"dictionaries_type_code" : query_dictionaries_type_code,
		"dictionaries_type_name" : query_dictionaries_type_name,
 		 "dictionaries_type_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilDictionariesType_addPage.do",
		"jsonData" : null,
		"title" : "字典表类型添加",
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
	var update_dictionaries_type_code = $("#update_dictionaries_type_code").val();
	var update_dictionaries_type_name = $("#update_dictionaries_type_name").val();
	var jsonObj = {
		"dictionaries_type_code" : update_dictionaries_type_code,
		"dictionaries_type_name" : update_dictionaries_type_name,
		"dictionaries_type_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonData = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilDictionariesType_updateData.do",
		"jsonData" : jsonData,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"dictionaries_type_id" : id};
	var jsonAjax = {
		"url" : "utilDictionariesType_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "字典表类型编辑",
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
		"url" : "utilDictionariesType_updateData.do",
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
			'url' : 'utilDictionariesType_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/**
 * 获得字典数据
 */
function openDataPage(dictionaries_type_id,name){
	var title='字典数据('+name+')';
	var jsonObj = {
			"dictionaries_type_id":dictionaries_type_id,
			"openType":"openIframe"
			};
	var jsonAjax = {
		"url" : "utilDictionariesData_index.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : title,
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}
