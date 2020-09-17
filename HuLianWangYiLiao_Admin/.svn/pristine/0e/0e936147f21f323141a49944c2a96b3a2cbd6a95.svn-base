/****** 平台消息 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryAdminNotice(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_user_type = $("#query_user_type").val();
	var query_notice_title = $("#query_notice_title").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"notice_title" : query_notice_title,
		"user_type" : query_user_type,
 		 "notice_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "adminNotice_addPage.do",
		"jsonData" : null,
		"title" : "平台消息添加",
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
	var update_notice_type = $("input[name=update_notice_type]:checked").val();
	var update_user_type = $("input[name=update_user_type]:checked").val();
	var update_user_id = $("#update_user_id").val();
	var update_notice_title = $("#update_notice_title").val();
	var update_notice_content = $("#update_notice_content").val();
	var update_notice_join = $("#update_notice_join").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"notice_type" : update_notice_type,
		"user_type" : update_user_type,
		"user_id" : update_user_id,
		"notice_title" : update_notice_title,
		"notice_content" : update_notice_content,
		"notice_join" : update_notice_join,
		"notice_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "adminNotice_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"notice_id" : id};
	var jsonAjax = {
		"url" : "adminNotice_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "平台消息编辑",
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
		"url" : "adminNotice_updateData.do",
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
			'url' : 'adminNotice_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/