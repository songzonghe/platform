/****** 问诊患者测量数据 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryInquiryPatientMeasuredData(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_inquiry_patient_id = $("#query_inquiry_patient_id").val();
	var query_join_type = $("#query_join_type").val();
	var query_join_id = $("#query_join_id").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"inquiry_patient_id" : query_inquiry_patient_id,
		"join_type" : query_join_type,
		"join_id" : query_join_id,
 		 "data_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "inquiryPatientMeasuredData_addPage.do",
		"jsonData" : null,
		"title" : "问诊患者测量数据添加",
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
	var update_inquiry_patient_id = $("#update_inquiry_patient_id").val();
	var update_join_type = $("input[name=update_join_type]:checked").val();
	var update_join_id = $("#update_join_id").val();
	var update_data_animal_heat = $("#update_data_animal_heat").val();
	var update_data_sbp = $("#update_data_sbp").val();
	var update_data_dbp = $("#update_data_dbp").val();
	var update_data_heart_rate = $("#update_data_heart_rate").val();
	var update_data_rr = $("#update_data_rr").val();
	var update_data_glu = $("#update_data_glu").val();
	var update_data_condition = $("#update_data_condition").val();
	var update_data_parameter = $("#update_data_parameter").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"inquiry_patient_id" : update_inquiry_patient_id,
		"join_type" : update_join_type,
		"join_id" : update_join_id,
		"data_animal_heat" : update_data_animal_heat,
		"data_sbp" : update_data_sbp,
		"data_dbp" : update_data_dbp,
		"data_heart_rate" : update_data_heart_rate,
		"data_rr" : update_data_rr,
		"data_glu" : update_data_glu,
		"data_condition" : update_data_condition,
		"data_parameter" : update_data_parameter,
		"data_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "inquiryPatientMeasuredData_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"data_id" : id};
	var jsonAjax = {
		"url" : "inquiryPatientMeasuredData_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "问诊患者测量数据编辑",
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
		"url" : "inquiryPatientMeasuredData_updateData.do",
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
			'url' : 'inquiryPatientMeasuredData_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/