/****** app功能图标 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilIcon(page){
	loadingDiv();
	var query_icon_name = $("#query_icon_name").val();
	var query_is_show = $("#query_is_show").val();
	var query_is_outer_chain = $("#query_is_outer_chain").val();
	var json = {
		"icon_name" : query_icon_name,
		"is_show" : query_is_show,
		"is_outer_chain" : query_is_outer_chain,
 		 "icon_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilIcon_addPage.do",
		"jsonData" : null,
		"title" : "app功能图标添加",
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
	var update_icon_name = $("#update_icon_name").val();
	var update_icon_img = $("#update_icon_img").attr("src");
	var update_is_show = $("input[name=update_is_show]:checked").val();
	var update_is_outer_chain = $("input[name=update_is_outer_chain]:checked").val();
	var update_icon_link = $("#update_icon_link").val();
	var jsonObj = {
		"icon_name" : update_icon_name,
		"icon_img" : update_icon_img,
		"is_show" : update_is_show,
		"is_outer_chain" : update_is_outer_chain,
		"icon_link" : update_icon_link,
		"icon_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilIcon_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"icon_id" : id};
	var jsonAjax = {
		"url" : "utilIcon_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "app功能图标编辑",
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
		"url" : "utilIcon_updateData.do",
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
			'url' : 'utilIcon_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/