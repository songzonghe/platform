/****** 网络医院问诊记录 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryInquiryLog(page){
	loadingDiv();
	var query_inquiry_patient_name = $("#query_inquiry_patient_name").val();
	var query_doctor_name = $("#query_doctor_name").val();
	var json = {
		"inquiry_patient_name" : query_inquiry_patient_name,
		"doctor_name" : query_doctor_name,
 		 "log_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "inquiryLog_addPage.do",
		"jsonData" : null,
		"title" : "网络医院问诊记录添加",
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
	var update_log_type = $("input[name=update_log_type]:checked").val();
	var update_join_type = $("input[name=update_join_type]:checked").val();
	
	var update_user_id = $("#update_user_id").val();
	//个人
	var update_store_id = $("#update_store_id").val();
	//门店
	if (update_user_id == 1){
		update_join_type = update_user_id;
	} else {
		update_join_type = update_store_id;
	}
	
	var update_join_id = $("#update_join_id").val();
	var update_inquiry_patient_id = $("#update_inquiry_patient_id").val();
	var update_doctor_id = $("#update_doctor_id").val();
	var update_log_source = $("#update_log_source").val();
	var update_log_main_suit = $("#update_log_main_suit").val();
	var update_log_present_illness = $("#update_log_present_illness").val();
	var update_log_history_present_illness = $("#update_log_history_present_illness").val();
	var update_lof_diagnosis = $("#update_lof_diagnosis").val();
	var update_lof_proposal = $("#update_lof_proposal").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"log_type" : update_log_type,
		"join_type" : update_join_type,
		"join_id" : update_join_id,
		"inquiry_patient_id" : update_inquiry_patient_id,
		"doctor_id" : update_doctor_id,
		"log_source" : update_log_source,
		"log_main_suit" : update_log_main_suit,
		"log_present_illness" : update_log_present_illness,
		"log_history_present_illness" : update_log_history_present_illness,
		"lof_diagnosis" : update_lof_diagnosis,
		"lof_proposal" : update_lof_proposal,
		"log_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "inquiryLog_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"log_id" : id};
	var jsonAjax = {
		"url" : "inquiryLog_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "网络医院问诊记录编辑",
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
		"url" : "inquiryLog_updateData.do",
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
			'url' : 'inquiryLog_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/