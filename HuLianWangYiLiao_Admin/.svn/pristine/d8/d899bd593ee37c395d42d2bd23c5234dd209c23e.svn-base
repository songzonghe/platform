/****** 我的用药 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryDoctorDrug(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_doctor_id = $("#query_doctor_id").val();
	var query_drug_id = $("#query_drug_id").val();
	var query_drug_type = $("#query_drug_type").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"doctor_id" : query_doctor_id,
		"drug_id" : query_drug_id,
		"drug_type" : query_drug_type,
 		 "doctor_drug_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "doctorDrug_addPage.do",
		"jsonData" : null,
		"title" : "我的用药添加",
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
	var update_doctor_id = $("#update_doctor_id").val();
	var update_drug_id = $("#update_drug_id").val();
	var update_drug_type = $("input[name=update_drug_type]:checked").val();
	var update_doctor_drug_consumption = $("#update_doctor_drug_consumption").val();
	var update_doctor_drug_frequency_str = $("#update_doctor_drug_frequency_str").val();
	var update_doctor_drug_frequency = $("#update_doctor_drug_frequency").val();
	var update_doctor_drug_day = $("#update_doctor_drug_day").val();
	var update_doctor_drug_num = $("#update_doctor_drug_num").val();
	var update_doctor_drug_usage = $("#update_doctor_drug_usage").val();
	var update_doctor_drug_entrust = $("#update_doctor_drug_entrust").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"doctor_id" : update_doctor_id,
		"drug_id" : update_drug_id,
		"drug_type" : update_drug_type,
		"doctor_drug_consumption" : update_doctor_drug_consumption,
		"doctor_drug_frequency_str" : update_doctor_drug_frequency_str,
		"doctor_drug_frequency" : update_doctor_drug_frequency,
		"doctor_drug_day" : update_doctor_drug_day,
		"doctor_drug_num" : update_doctor_drug_num,
		"doctor_drug_usage" : update_doctor_drug_usage,
		"doctor_drug_entrust" : update_doctor_drug_entrust,
		"doctor_drug_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "doctorDrug_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"doctor_drug_id" : id};
	var jsonAjax = {
		"url" : "doctorDrug_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "我的用药编辑",
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
		"url" : "doctorDrug_updateData.do",
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
			'url' : 'doctorDrug_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/