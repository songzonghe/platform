/****** 诊段模板以及规范 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilDiagnosis(page){
	if(isUndefinedAndEmpty(page)){
		page=0;
	}
	loadingDiv();
	var query_icd_id = $("#query_icd_id").val();
	var query_diagnosis_name = $("#query_diagnosis_name").val();
	var query_doctor_id = $("#query_doctor_id").val();
	var json = {
		"icd_name" : query_icd_id,
		"diagnosis_name" : query_diagnosis_name,
		"doctor_name" : query_doctor_id,
 		 "diagnosis_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilDiagnosis_addPage.do",
		"jsonData" : null,
		"title" : "诊段模板以及规范添加",
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
	var update_diagnosis_name = $("#update_diagnosis_name").val();
	var update_doctor_id = $("#update_doctor_id").val();
	var update_diagnosis_sex = $("#update_diagnosis_sex").val();
	var update_diagnosis_dage = $("#update_diagnosis_dage").val();
	var update_diagnosis_tage = $("#update_diagnosis_tage").val();
	var update_is_restriction = $("#update_is_restriction").val();
	var jsonObj = {
		"icd_id" : update_icd_id,
		"diagnosis_name" : update_diagnosis_name,
		"doctor_id" : update_doctor_id,
		"diagnosis_sex" : update_diagnosis_sex,
		"diagnosis_dage" : update_diagnosis_dage,
		"diagnosis_tage" : update_diagnosis_tage,
		"is_restriction" : update_is_restriction,
		"diagnosis_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilDiagnosis_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"diagnosis_id" : id};
	var jsonAjax = {
		"url" : "utilDiagnosis_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "诊段模板以及规范编辑",
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
		"url" : "utilDiagnosis_updateData.do",
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
			'url' : 'utilDiagnosis_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/