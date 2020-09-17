/****** 问诊记录检验单 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryInquiryLogChecklist(page){
	loadingDiv();
	var query_inquiry_patient_id = $("#query_inquiry_patient_id").val();
	var query_doctor_id = $("#query_doctor_id").val();
	var query_checklist_name = $("#query_checklist_name").val();
	var query_checklist_code = $("#query_checklist_code").val();
	var json = {
		"inquiry_patient_id" : query_inquiry_patient_id,
		"doctor_id" : query_doctor_id,
		"checklist_name" : query_checklist_name,
		"checklist_code" : query_checklist_code,
 		 "checklist_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "inquiryLogChecklist_addPage.do",
		"jsonData" : null,
		"title" : "问诊记录检验单添加",
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
	var update_log_id = $("#update_log_id").val();
	var update_join_type = $("#update_join_type").val();
	var update_join_id = $("#update_join_id").val();
	var update_inquiry_patient_id = $("#update_inquiry_patient_id").val();
	var update_doctor_id = $("#update_doctor_id").val();
	var update_checklist_name = $("#update_checklist_name").val();
	var update_checklist_code = $("#update_checklist_code").val();
	var update_checklist_type = $("#update_checklist_type").val();
	var update_checklist_last_code = $("#update_checklist_last_code").val();
	var update_checklist_abstract = $("#update_checklist_abstract").val();
	var update_checklist_sbp = $("#update_checklist_sbp").val();
	var update_checklist_dbp = $("#update_checklist_dbp").val();
	var update_is_digitalization = $("#update_is_digitalization").val();
	var update_checklist_digitalization_num = $("#update_checklist_digitalization_num").val();
	var update_checklist_digitalization_start = $("#update_checklist_digitalization_start").val();
	var update_checklist_digitalization_end = $("#update_checklist_digitalization_end").val();
	var update_is_other_drugs = $("#update_is_other_drugs").val();
	var update_checklist_other_drugs_name = $("#update_checklist_other_drugs_name").val();
	var update_checklist_other_drugs_start = $("#update_checklist_other_drugs_start").val();
	var update_checklist_other_drugs_end = $("#update_checklist_other_drugs_end").val();
	var update_checklist_other_drugs_num = $("#update_checklist_other_drugs_num").val();
	var update_checklist_inspection_result = $("#update_checklist_inspection_result").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"log_id" : update_log_id,
		"join_type" : update_join_type,
		"join_id" : update_join_id,
		"inquiry_patient_id" : update_inquiry_patient_id,
		"doctor_id" : update_doctor_id,
		"checklist_name" : update_checklist_name,
		"checklist_code" : update_checklist_code,
		"checklist_type" : update_checklist_type,
		"checklist_last_code" : update_checklist_last_code,
		"checklist_abstract" : update_checklist_abstract,
		"checklist_sbp" : update_checklist_sbp,
		"checklist_dbp" : update_checklist_dbp,
		"is_digitalization" : update_is_digitalization,
		"checklist_digitalization_num" : update_checklist_digitalization_num,
		"checklist_digitalization_start" : update_checklist_digitalization_start,
		"checklist_digitalization_end" : update_checklist_digitalization_end,
		"is_other_drugs" : update_is_other_drugs,
		"checklist_other_drugs_name" : update_checklist_other_drugs_name,
		"checklist_other_drugs_start" : update_checklist_other_drugs_start,
		"checklist_other_drugs_end" : update_checklist_other_drugs_end,
		"checklist_other_drugs_num" : update_checklist_other_drugs_num,
		"checklist_inspection_result" : update_checklist_inspection_result,
		"checklist_id" : id,
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
		"url" : "inquiryLogChecklist_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"checklist_id" : id};
	var jsonAjax = {
		"url" : "inquiryLogChecklist_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "问诊记录检验单编辑",
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
		"url" : "inquiryLogChecklist_updateData.do",
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
			'url' : 'inquiryLogChecklist_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
function mainDetail(checklist_id){
	var url = "inquiryLogChecklistDetails_index.do";
	showHiddenNode(getNodeUtilJsonData(checklist_id,getNodeJson(checklist_id,url)));
}

function getNodeUtilJsonData(checklist_id,jsonParameter){
	var json = {
		"checklist_id" : checklist_id
	};
	return editJson(jsonParameter, "jsonData",{"mapStr":jsonToStr(json)});
}
/************************系统生成方法完毕******************************/