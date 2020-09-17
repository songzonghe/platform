/****** 健康指导模板 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilHealthGuidance(page){
	loadingDiv();
	var query_icd_id = $("#query_icd_id").val();
	var query_diagnosis_id = $("#query_diagnosis_id").val();
	var query_guidance_id = $("#query_guidance_id").val();
	var json = {
		"icd_name" : query_icd_id,
		"diagnosis_name" : query_diagnosis_id,
		"guidance_name" : query_guidance_id,
 		 "guidance_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilHealthGuidance_addPage.do",
		"jsonData" : null,
		"title" : "健康指导模板添加",
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
	var update_icd_id = $("#update_icd_id").val();
	var update_diagnosis_id = $("#update_diagnosis_id").val();
	var update_doctor_id = $("#update_doctor_id").val();
	var update_guidance_name = $("#update_guidance_name").val();
	var update_guidance_content = $("#update_guidance_content").val();
	var jsonObj = {
		"icd_id" : update_icd_id,
		"diagnosis_id" : update_diagnosis_id,
		"doctor_id" : update_doctor_id,
		"guidance_content" : update_guidance_content,
		"guidance_name" : update_guidance_name,
		"guidance_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilHealthGuidance_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"guidance_id" : id};
	var jsonAjax = {
		"url" : "utilHealthGuidance_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "健康指导模板编辑",
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
		"url" : "utilHealthGuidance_updateData.do",
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
			'url' : 'utilHealthGuidance_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/