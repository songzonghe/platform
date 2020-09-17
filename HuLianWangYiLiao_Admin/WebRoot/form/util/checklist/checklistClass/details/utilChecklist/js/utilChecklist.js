/************************系统检验检查操作JS******************************/

function openlookInfo(id,name){
	var title='检验模板详情('+name+')';
	var jsonObj = {
			"checklist_class_id":id,
			"pageType":"open"
			};
	var jsonAjax = {
		"url" : "utilChecklist_index.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : title,
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

/**
* 获取弹框信息
*/
function searchOpenPage(sortId,page){
	var find_checklist_class_id = $("#find_checklist_class_id").val();
	var find_checklist_name = $("#find_checklist_name").val();
	var json = {
		"checklist_class_id":find_checklist_class_id,
		"checklist_name":find_checklist_name,
	};
	var jsonObj = getSortInfo(json, page, sortId);
	var jsons= publicFieldsnJSON(queryJson(jsonObj));
	var jsonAjax = {
		"url" : "utilChecklist_index.do",
		"jsonData" : {"mapStr":jsonToStr(jsons)},
		"methodName" : "moblieQuery_back",
		"targetContainer" : "dataInfo",
	};
	// 调用显示函数
	getAjaxData(jsonAjax);
}



function add_utilChecklistPage(checklist_class_id){
	var jsonTemp ={
		'checklist_class_id':checklist_class_id
	};
	var jsonAjax = {
		'url' : 'utilChecklist_addPage.do',
		'jsonData' : {'mapStr':jsonToStr(jsonTemp)},
		'title' : '检验检查',
		'icon' : 'plus',
		'methodName' : 'page_back'
	};
	getAjaxData(jsonAjax);
}

function getUpdateJson_utilChecklist(id,checklist_class_id) {
	var update_hospital_id = $("#update_hospital_id").val();
	var update_checklist_class_id = $("#update_checklist_class_id").val();
	var update_checklist_type = $("input[name=update_checklist_type]:checked").val();
	var update_checklist_name = $("#update_checklist_name").val();
	var update_checklist_sort = $("#update_checklist_sort").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"checklist_type" : update_checklist_type,
		"checklist_name" : update_checklist_name,
		"checklist_sort" : update_checklist_sort,
		"checklist_class_id" : checklist_class_id,
		"checklist_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addDataValidate_utilChecklist(checklist_class_id) {
	var jsonObj={
		'methodName':'addutilChecklist',
		'checklist_class_id':checklist_class_id
	};
	jsonValidate = jsonObj;
}

function addutilChecklist(jsonObj) {
	var jsonAjax = {
		'url' : 'utilChecklist_updateData.do',
		'jsonData' : getUpdateJson_utilChecklist('',jsonObj.checklist_class_id),
		'methodName' : 'update_add',
		'toID' : 'dataInfo'
	};
	getAjaxData(jsonAjax);
}

function openEditPage_utilChecklist(id) {
	var jsonObj = {'checklist_id' : id};
	var jsonAjax = {
		'url' : 'utilChecklist_editPage.do',
		'jsonData' : {'mapStr':jsonToStr(jsonObj)},
		'title' : '系统检验检查编辑',
		'icon' : 'edit',
		'methodName' : 'page_back'
	};
	getAjaxData(jsonAjax);
}

function editDataValidate_utilChecklist(id,checklist_class_id) {
	var jsonObj={
		'methodName':'editutilChecklist',
		'checklist_id':id,
		'checklist_class_id':checklist_class_id
	};
	jsonValidate = jsonObj;
}

function editutilChecklist(jsonObj) {
	var jsonAjax = {
		'url' : 'utilChecklist_updateData.do',
		'jsonData' : getUpdateJson_utilChecklist(jsonObj.checklist_id,''),
		'methodName' : 'update_edit',
		'toID' : 'dataInfo'
	};
	getAjaxData(jsonAjax);
}

function confirmDeleteDate_utilChecklist(id,checklist_class_id) {
	var jsonObj = {
		'title':'操作提示',
		"info":' <span class="red">确认删除</span> ?',
		'id':id,
		'toID':checklist_class_id
	};
	adminJS.confirm(jsonObj,function(e,id,toID){
		if(e==0){
			return ;
		}
		var jsonPar = {
			'id' : getStr(id)
		};
		var jsonAjax = {
			'url' : 'utilChecklist_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'dataInfo'
		};
		getAjaxData(jsonAjax);
	});
}

