/****** 问诊记录处方 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryInquiryLogPrescription(page){
	loadingDiv();
	var query_inquiry_patient_name = $("#query_inquiry_patient_name").val();
	var query_doctor_name = $("#query_doctor_name").val();
	var query_find_zt = $("#query_find_zt").val();
	var is_examine = $("#is_examine").prop('checked')?1:0;
	var json = {
		"inquiry_patient_name" : query_inquiry_patient_name,
		"doctor_name" : query_doctor_name,
		"find_zt" : query_find_zt,
		"is_examine" : is_examine,
 		"prescription_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "inquiryLogPrescription_addPage.do",
		"jsonData" : null,
		"title" : "问诊记录处方添加",
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

function getUpdateMainJson(id,edit_zt) {
	
	var prescription_reasons_invalidation = $("#update_prescription_reasons_invalidation").val();
	var update_prescription_requirements = $("#update_prescription_requirements").val();
	var jsonObj = {
		"prescription_id" : id,
		"prescription_requirements" : update_prescription_requirements,
		"prescription_reasons_invalidation":prescription_reasons_invalidation,
		"edit_zt":edit_zt,
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("","");
	var jsonAjax = {
		"url" : "inquiryLogPrescription_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id,type){
	var jsonObj = {"prescription_id" : id,'pagetype':type};
	var jsonAjax = {
		"url" : "inquiryLogPrescription_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "处方记录",
		"icon" : "edit",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

function editDataValidate(id,edit_zt){
	if(edit_zt=='5'){//作废
		$('.requirements').show();
		$('#update_prescription_reasons_invalidation').attr('data-validate','required:请输入作废理由！');
	}else{
		$('#update_prescription_reasons_invalidation').attr('data-validate','backTrue:');
	}
	
	var jsonObj={
		"methodName":"editData",
		"id":id,
		"edit_zt":edit_zt
		};
	jsonValidate = jsonObj;
}

function editData(jsonObj){
	var jsonAjax = {
		"url" : "inquiryLogPrescription_updateData.do",
		"jsonData" : getUpdateMainJson(jsonObj.id,jsonObj.edit_zt),
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
			'url' : 'inquiryLogPrescription_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
