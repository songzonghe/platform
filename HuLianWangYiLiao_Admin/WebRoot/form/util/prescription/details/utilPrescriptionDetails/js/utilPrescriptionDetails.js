/************************问诊记录处方模板详情操作JS******************************/
function load_utilPrescriptionDetailsData(prescription_id,this_){
	if($(this_).attr('isOpen')=='n'){
		var jsonAjax = {
			'url' : 'utilPrescriptionDetails_index.do',
			'jsonData' : {'mapStr':jsonToStr({'prescription_id':prescription_id})},
			'methodName' : 'load_utilPrescriptionDetailsData_back',
			'id':prescription_id
		};
		getAjaxData(jsonAjax);
		$(this_).attr('isOpen','y');
	}
}

function load_utilPrescriptionDetailsData_back(jsonObj){
	$('#dataTbody_utilPrescriptionDetails'+jsonObj.id).html(jsonObj.data);
}

function add_utilPrescriptionDetailsPage(prescription_id,find_drug_type){
	var jsonTemp ={
		'prescription_id':prescription_id,
		'find_drug_type':find_drug_type,
	};
	var jsonAjax = {
		'url' : 'utilPrescriptionDetails_addPage.do',
		'jsonData' : {'mapStr':jsonToStr(jsonTemp)},
		'title' : '处方详情',
		'icon' : 'plus',
		'methodName' : 'page_back'
	};
	getAjaxData(jsonAjax);
}

function getUpdateJson_utilPrescriptionDetails(id,prescription_id) {
	var update_prescription_id = $("#update_prescription_id").val();
	var update_drug_id = $("#update_drug_id").val();
	var update_details_consumption = $("#update_details_consumption").val();
	var update_details_frequency_str = $("#update_details_frequency_str").val();
	var update_details_frequency = $("#update_details_frequency").val();
	var update_details_day = $("#update_details_day").val();
	var update_details_num = $("#update_details_num").val();
	var update_details_usage = $("#update_details_usage").val();
	var update_details_entrust = $("#update_details_entrust").val();
	var jsonObj = {
		"drug_id" : update_drug_id,
		"details_consumption" : update_details_consumption,
		"details_frequency_str" : update_details_frequency_str,
		"details_frequency" : update_details_frequency,
		"details_day" : update_details_day,
		"details_num" : update_details_num,
		"details_usage" : update_details_usage,
		"details_entrust" : update_details_entrust,
		"prescription_id" : prescription_id,
		"prescription_details_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addDataValidate_utilPrescriptionDetails(prescription_id) {
	var jsonObj={
		'methodName':'addutilPrescriptionDetails',
		'prescription_id':prescription_id
	};
	jsonValidate = jsonObj;
}

function addutilPrescriptionDetails(jsonObj) {
	var jsonAjax = {
		'url' : 'utilPrescriptionDetails_updateData.do',
		'jsonData' : getUpdateJson_utilPrescriptionDetails('',jsonObj.prescription_id),
		'methodName' : 'update_add',
		'toID' : 'dataTbody_utilPrescriptionDetails'+jsonObj.prescription_id
	};
	getAjaxData(jsonAjax);
}

function openEditPage_utilPrescriptionDetails(id,prescription_id) {
	var jsonObj = {'prescription_details_id' : id,'prescription_id':prescription_id};
	var jsonAjax = {
		'url' : 'utilPrescriptionDetails_editPage.do',
		'jsonData' : {'mapStr':jsonToStr(jsonObj)},
		'title' : '问诊记录处方模板详情编辑',
		'icon' : 'edit',
		'methodName' : 'page_back'
	};
	getAjaxData(jsonAjax);
}

function editDataValidate_utilPrescriptionDetails(id,prescription_id) {
	var jsonObj={
		'methodName':'editutilPrescriptionDetails',
		'prescription_details_id':id,
		'prescription_id':prescription_id
	};
	jsonValidate = jsonObj;
}

function editutilPrescriptionDetails(jsonObj) {
	var jsonAjax = {
		'url' : 'utilPrescriptionDetails_updateData.do',
		'jsonData' : getUpdateJson_utilPrescriptionDetails(jsonObj.prescription_details_id,''),
		'methodName' : 'update_edit',
		'toID' : 'dataTbody_utilPrescriptionDetails'+jsonObj.prescription_id
	};
	getAjaxData(jsonAjax);
}

function confirmDeleteDate_utilPrescriptionDetails(id,name,prescription_id) {
	var jsonObj = {
		'title':'操作提示',
		"info":'确认删除 <span class="red">'+name+'</span> ?',
		'id':id,
		'toID':prescription_id
	};
	adminJS.confirm(jsonObj,function(e,id,toID){
		if(e==0){
			return ;
		}
		var jsonPar = {
			'id' : getStr(id)
		};
		var jsonAjax = {
			'url' : 'utilPrescriptionDetails_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'dataTbody_utilPrescriptionDetails'+toID
		};
		getAjaxData(jsonAjax);
	});
}

