/****** 合作企业 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilCooperativeEnterprises(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_enterprises_name = $("#query_enterprises_name").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"enterprises_name" : query_enterprises_name,
 		 "enterprises_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilCooperativeEnterprises_addPage.do",
		"jsonData" : null,
		"title" : "合作企业添加",
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
	var update_enterprises_name = $("#update_enterprises_name").val();
	var update_enterprises_img = $("#update_enterprises_img").attr("src");
	var update_enterprises_sort = $("#update_enterprises_sort").val();
	var update_enterprises_url = $("#update_enterprises_url").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"enterprises_name" : update_enterprises_name,
		"enterprises_img" : update_enterprises_img,
		"enterprises_sort" : update_enterprises_sort,
		"enterprises_url" : update_enterprises_url,
		"enterprises_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilCooperativeEnterprises_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"enterprises_id" : id};
	var jsonAjax = {
		"url" : "utilCooperativeEnterprises_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "合作企业编辑",
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
		"url" : "utilCooperativeEnterprises_updateData.do",
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
			'url' : 'utilCooperativeEnterprises_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/