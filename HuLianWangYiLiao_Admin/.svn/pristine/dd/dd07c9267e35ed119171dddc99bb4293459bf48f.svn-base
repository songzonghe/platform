/****** 问诊记录住院建议 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryInquiryLogHospitalization(page){
	loadingDiv();
	var query_inquiry_patient_id = $("#query_inquiry_patient_id").val();
	var query_doctor_id = $("#query_doctor_id").val();
	var json = {
		"inquiry_patient_id" : query_inquiry_patient_id,
		"doctor_id" : query_doctor_id,
 		 "hospitalization_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "inquiryLogHospitalization_addPage.do",
		"jsonData" : null,
		"title" : "问诊记录住院建议添加",
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
	var update_log_id = $("#update_log_id").val();
	var update_join_type = $("input[name=update_join_type]:checked").val();
	var update_join_id = $("#update_join_id").val();
	var update_inquiry_patient_id = $("#update_inquiry_patient_id").val();
	var update_doctor_id = $("#update_doctor_id").val();
	var update_hospitalization_hospital = $("#update_hospitalization_hospital").val();
	var update_hospitalization_department = $("#update_hospitalization_department").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"log_id" : update_log_id,
		"join_type" : update_join_type,
		"join_id" : update_join_id,
		"inquiry_patient_id" : update_inquiry_patient_id,
		"doctor_id" : update_doctor_id,
		"hospitalization_hospital" : update_hospitalization_hospital,
		"hospitalization_department" : update_hospitalization_department,
		"hospitalization_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "inquiryLogHospitalization_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"hospitalization_id" : id};
	var jsonAjax = {
		"url" : "inquiryLogHospitalization_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "问诊记录住院建议编辑",
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
		"url" : "inquiryLogHospitalization_updateData.do",
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
			'url' : 'inquiryLogHospitalization_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/