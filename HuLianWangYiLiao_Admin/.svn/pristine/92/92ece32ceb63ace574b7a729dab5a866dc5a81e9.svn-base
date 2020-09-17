/****** 药品关联属性选项 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilDrugAttributeOption(page){
	if(isUndefinedAndEmpty(page)){
		page=0;
	}
	loadingDiv();
	var query_option_type = $("#query_option_type").val();
	var query_usage_name = $("#query_usage_name").val();
	var json = {
		"option_type" : query_option_type,
		"usage_name" : query_usage_name,
 		 "option_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilDrugAttributeOption_addPage.do",
		"jsonData" : null,
		"title" : "药品关联属性选项添加",
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
	var update_option_type = $("input[name=update_option_type]:checked").val();
	var update_usage_name = $("#update_usage_name").val();
	var update_usage_sort = $("#update_usage_sort").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"option_type" : update_option_type,
		"usage_name" : update_usage_name,
		"usage_sort" : update_usage_sort,
		"option_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilDrugAttributeOption_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"option_id" : id};
	var jsonAjax = {
		"url" : "utilDrugAttributeOption_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "药品关联属性选项编辑",
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
		"url" : "utilDrugAttributeOption_updateData.do",
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
			'url' : 'utilDrugAttributeOption_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/