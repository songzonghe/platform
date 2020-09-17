/****** 配伍禁忌 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilIncompatibility(page){
	loadingDiv();
	var query_drug_name = $("#query_drug_name").val();
	var query_drug_name2 = $("#query_drug_name2").val();
	var json = {
		"drug_name" : query_drug_name,
		"drug_name2" : query_drug_name2,
 		 "incompatibility_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilIncompatibility_addPage.do",
		"jsonData" : null,
		"title" : "配伍禁忌添加",
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
	var update_drug_id = $("#update_drug_id").val();
	var update_drug_id2 = $("#update_drug_id2").val();
	if(update_drug_id==update_drug_id2){
		adminJS.alert({'title':'提示','info':'药品重复！'});
		return 'false';
	}
	var jsonObj = {
		"drug_id" : update_drug_id,
		"drug_id2" : update_drug_id2,
		"incompatibility_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	if(jsonObj!='false'){
		var jsonAjax = {
			"url" : "utilIncompatibility_updateData.do",
			"jsonData" : jsonObj,
			"methodName" : "update_add",
			"toID" : "tbodyData"
		};
		getAjaxData(jsonAjax);
	}
}

function openEditPage(id){
	var jsonObj = {"incompatibility_id" : id};
	var jsonAjax = {
		"url" : "utilIncompatibility_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "配伍禁忌编辑",
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
	var jsonObj = getUpdateMainJson(jsonObj.id);
	if(jsonObj!='false'){
		var jsonAjax = {
			"url" : "utilIncompatibility_updateData.do",
			"jsonData" : jsonObj,
			"methodName" : "update_edit",
			"toID" :"tbodyData"
		};
		getAjaxData(jsonAjax);
	}
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
			'url' : 'utilIncompatibility_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/