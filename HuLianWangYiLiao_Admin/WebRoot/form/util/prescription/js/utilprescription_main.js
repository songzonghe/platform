/****** 处方模板 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilPrescription(page){
	loadingDiv();
	var query_icd_name = $("#query_icd_name").val();
	var query_diagnosis_name = $("#query_diagnosis_name").val();
	var query_doctor_name = $("#query_doctor_name").val();
	var json = {
		"icd_name" : query_icd_name,
		"diagnosis_name" : query_diagnosis_name,
		"doctor_name" : query_doctor_name,
 		 "prescription_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilPrescription_addPage.do",
		"jsonData" : null,
		"title" : "处方模板添加",
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
	var update_icd_id = $("#update_icd_id").val();
	var update_diagnosis_id = $("#update_diagnosis_id").val();
	var update_doctor_id = $("#update_doctor_id").val();
	var update_prescription_type = $("input[name=update_prescription_type]:checked").val();
	var update_prescription_price = $("#update_prescription_price").val();
	var jsonObj = {
		"icd_id" : update_icd_id,
		"diagnosis_id" : update_diagnosis_id,
		"doctor_id" : update_doctor_id,
		"prescription_type" : update_prescription_type,
		"prescription_price" : update_prescription_price,
		"prescription_id" : id,
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
		"url" : "utilPrescription_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"prescription_id" : id};
	var jsonAjax = {
		"url" : "utilPrescription_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "处方模板编辑",
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
		"url" : "utilPrescription_updateData.do",
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
			'url' : 'utilPrescription_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
function mainDetail(prescription_id){
	var url = "utilPrescriptionDetails_index.do";
	showHiddenNode(getNodeUtilJsonData(prescription_id,getNodeJson(prescription_id,url)));
}

function getNodeUtilJsonData(prescription_id,jsonParameter){
	var json = {
		"prescription_id" : prescription_id
	};
	return editJson(jsonParameter, "jsonData",{"mapStr":jsonToStr(json)});
}
/************************系统生成方法完毕******************************/