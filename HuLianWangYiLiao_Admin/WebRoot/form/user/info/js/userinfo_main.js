/****** 用户基本资料 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUserInfo(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_user_phone = $("#query_user_phone").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"user_phone" : query_user_phone,
 		 "user_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "userInfo_addPage.do",
		"jsonData" : null,
		"title" : "用户基本资料添加",
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
	var update_user_phone = $("#update_user_phone").val();
	var update_user_paw = $("#update_user_paw").val();
	var update_user_openid = $("#update_user_openid").val();
	var update_user_nickname = $("#update_user_nickname").val();
	var update_user_img = $("#update_user_img").attr("src");
	var update_user_name = $("#update_user_name").val();
	var update_user_document_number = $("#update_user_document_number").val();
	var update_user_document_img1 = $("#update_user_document_img1").attr("src");
	var update_user_document_img2 = $("#update_user_document_img2").attr("src");
	var update_user_im = $("#update_user_im").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"user_phone" : update_user_phone,
		"user_paw" : update_user_paw,
		"user_openid" : update_user_openid,
		"user_nickname" : update_user_nickname,
		"user_img" : update_user_img,
		"user_name" : update_user_name,
		"user_document_number" : update_user_document_number,
		"user_document_img1" : update_user_document_img1,
		"user_document_img2" : update_user_document_img2,
		"user_im" : update_user_im,
		"user_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "userInfo_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id,type){
	var title="用户基本资料编辑";
	if(type==2){
		title="重置密码";
	}
	var jsonObj = {"user_id" : id,"type":type};
	var jsonAjax = {
		"url" : "userInfo_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : title,
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
		"url" : "userInfo_updateData.do",
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
			'url' : 'userInfo_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/