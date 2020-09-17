/****** 网络医院问诊患者信息 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryInquiryPatientInfo(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_join_type = $("#query_join_type").val();
	var query_join_id = $("#query_join_id").val();
	var query_inquiry_patient_type = $("#query_inquiry_patient_type").val();
	var query_inquiry_patient_name = $("#query_inquiry_patient_name").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"join_type" : query_join_type,
		"join_id" : query_join_id,
		"inquiry_patient_type" : query_inquiry_patient_type,
		"inquiry_patient_name" : query_inquiry_patient_name,
 		 "inquiry_patient_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "inquiryPatientInfo_addPage.do",
		"jsonData" : null,
		"title" : "网络医院问诊患者信息添加",
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
	var update_join_type = $("input[name=update_join_type]:checked").val();
	var update_join_id = $("#update_join_id").val();
	var update_inquiry_patient_type = $("input[name=update_inquiry_patient_type]:checked").val();
	var update_inquiry_patient_img = $("#update_inquiry_patient_img").attr("src");
	var update_inquiry_patient_name = $("#update_inquiry_patient_name").val();
	var update_inquiry_patient_idcard = $("#update_inquiry_patient_idcard").val();
	var update_inquiry_patient_sex = $("input[name=update_inquiry_patient_sex]:checked").val();
	var update_inquiry_patient_birthday = $("#update_inquiry_patient_birthday").val();
	var update_inquiry_patient_phone = $("#update_inquiry_patient_phone").val();
	var update_inquiry_patient_marital_status = $("#update_inquiry_patient_marital_status").val();
	var update_inquiry_patient_weight = $("#update_inquiry_patient_weight").val();
	var update_inquiry_patient_profession_code = $("#update_inquiry_patient_profession_code").val();
	var update_inquiry_patient_profession = $("#update_inquiry_patient_profession").val();
	var update_inquiry_patient_address = $("#update_inquiry_patient_address").val();
	var update_is_drug_allergy = $("input[name=update_is_drug_allergy]:checked").val();
	var update_iinquiry_patient_allergy_details = $("#update_iinquiry_patient_allergy_details").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"join_type" : update_join_type,
		"join_id" : update_join_id,
		"inquiry_patient_type" : update_inquiry_patient_type,
		"inquiry_patient_img" : update_inquiry_patient_img,
		"inquiry_patient_name" : update_inquiry_patient_name,
		"inquiry_patient_idcard" : update_inquiry_patient_idcard,
		"inquiry_patient_sex" : update_inquiry_patient_sex,
		"inquiry_patient_birthday" : update_inquiry_patient_birthday,
		"inquiry_patient_phone" : update_inquiry_patient_phone,
		"inquiry_patient_marital_status" : update_inquiry_patient_marital_status,
		"inquiry_patient_weight" : update_inquiry_patient_weight,
		"inquiry_patient_profession_code" : update_inquiry_patient_profession_code,
		"inquiry_patient_profession" : update_inquiry_patient_profession,
		"inquiry_patient_address" : update_inquiry_patient_address,
		"is_drug_allergy" : update_is_drug_allergy,
		"iinquiry_patient_allergy_details" : update_iinquiry_patient_allergy_details,
		"inquiry_patient_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "inquiryPatientInfo_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"inquiry_patient_id" : id};
	var jsonAjax = {
		"url" : "inquiryPatientInfo_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "网络医院问诊患者信息编辑",
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
		"url" : "inquiryPatientInfo_updateData.do",
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
			'url' : 'inquiryPatientInfo_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/