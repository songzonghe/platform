/****** 药品分类 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilDrugClass(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_class_name = $("#query_class_name").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"class_name" : query_class_name,
 		 "class_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilDrugClass_addPage.do",
		"jsonData" : null,
		"title" : "药品分类添加",
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

function getUpdateMainJson(id,trIsOpen,imgIsOpne, imgSrc) {
	var update_hospital_id = $("#update_hospital_id").val();
	var update_class_name = $("#update_class_name").val();
	var update_class_sort = $("#update_class_sort").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"class_name" : update_class_name,
		"class_sort" : update_class_sort,
		"class_id" : id,
		"imgIsOpne":imgIsOpne,
		"imgSrc":imgSrc,
		"trIsOpen":trIsOpen
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var imgSrc = getRoot() + "/form_util/util/images/nolines_plus.gif";
	var jsonObj = getUpdateMainJson("", "n", "n", imgSrc);
	var jsonAjax = {
		"url" : "utilDrugClass_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"class_id" : id};
	var jsonAjax = {
		"url" : "utilDrugClass_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "药品分类编辑",
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
	var img = $("#img" + jsonObj.id);
	var imgIsOpne = img.attr("isOpen");
	var imgSrc = img.attr("src");
	var trIsOpen = $("#tr"+jsonObj.id).attr("isOpen");
	var jsonAjax = {
		"url" : "utilDrugClass_updateData.do",
		"jsonData" : getUpdateMainJson(jsonObj.id, trIsOpen, imgIsOpne, imgSrc),
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
			'url' : 'utilDrugClass_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
function mainDetail(class_id){
	var url = "utilDrug_index.do";
	showHiddenNode(getNodeUtilJsonData(class_id,getNodeJson(class_id,url)));
}

function getNodeUtilJsonData(class_id,jsonParameter){
	var json = {
		"class_id" : class_id
	};
	return editJson(jsonParameter, "jsonData",{"mapStr":jsonToStr(json)});
}
/************************系统生成方法完毕******************************/