/************************问诊记录检验检查单详情操作JS******************************/
function load_inquiryLogChecklistDetailsData(checklist_id,this_){
	if($(this_).attr('isOpen')=='n'){
		var jsonAjax = {
			'url' : 'inquiryLogChecklistDetails_index.do',
			'jsonData' : {'mapStr':jsonToStr({'checklist_id':checklist_id})},
			'methodName' : 'load_inquiryLogChecklistDetailsData_back',
			'id':checklist_id
		};
		getAjaxData(jsonAjax);
		$(this_).attr('isOpen','y');
	}
}

function load_inquiryLogChecklistDetailsData_back(jsonObj){
	$('#dataTbody_inquiryLogChecklistDetails'+jsonObj.id).html(jsonObj.data);
}

function add_inquiryLogChecklistDetailsPage(checklist_id){
	var jsonTemp ={
		'checklist_id':checklist_id
	};
	var jsonAjax = {
		'url' : 'inquiryLogChecklistDetails_addPage.do',
		'jsonData' : {'mapStr':jsonToStr(jsonTemp)},
		'title' : '问诊记录检验检查单详情',
		'icon' : 'plus',
		'methodName' : 'page_back'
	};
	getAjaxData(jsonAjax);
}

function getUpdateJson_inquiryLogChecklistDetails(id,checklist_id) {
	var update_hospital_id = $("#update_hospital_id").val();
	var update_checklist_id = $("#update_checklist_id").val();
	var update_checklist_type = $("#update_checklist_type").val();
	var update_checklist_name = $("#update_checklist_name").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"checklist_type" : update_checklist_type,
		"checklist_name" : update_checklist_name,
		"checklist_id" : checklist_id,
		"checklist_details_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addDataValidate_inquiryLogChecklistDetails(checklist_id) {
	var jsonObj={
		'methodName':'addinquiryLogChecklistDetails',
		'checklist_id':checklist_id
	};
	jsonValidate = jsonObj;
}

function addinquiryLogChecklistDetails(jsonObj) {
	var jsonAjax = {
		'url' : 'inquiryLogChecklistDetails_updateData.do',
		'jsonData' : getUpdateJson_inquiryLogChecklistDetails('',jsonObj.checklist_id),
		'methodName' : 'update_add',
		'toID' : 'dataTbody_inquiryLogChecklistDetails'+jsonObj.checklist_id
	};
	getAjaxData(jsonAjax);
}

function openEditPage_inquiryLogChecklistDetails(id) {
	var jsonObj = {'checklist_details_id' : id};
	var jsonAjax = {
		'url' : 'inquiryLogChecklistDetails_editPage.do',
		'jsonData' : {'mapStr':jsonToStr(jsonObj)},
		'title' : '问诊记录检验检查单详情编辑',
		'icon' : 'edit',
		'methodName' : 'page_back'
	};
	getAjaxData(jsonAjax);
}

function editDataValidate_inquiryLogChecklistDetails(id,checklist_id) {
	var jsonObj={
		'methodName':'editinquiryLogChecklistDetails',
		'checklist_details_id':id,
		'checklist_id':checklist_id
	};
	jsonValidate = jsonObj;
}

function editinquiryLogChecklistDetails(jsonObj) {
	var jsonAjax = {
		'url' : 'inquiryLogChecklistDetails_updateData.do',
		'jsonData' : getUpdateJson_inquiryLogChecklistDetails(jsonObj.checklist_details_id,''),
		'methodName' : 'update_edit',
		'toID' : 'dataTbody_inquiryLogChecklistDetails'+jsonObj.checklist_id
	};
	getAjaxData(jsonAjax);
}

function confirmDeleteDate_inquiryLogChecklistDetails(id,name,checklist_id) {
	var jsonObj = {
		'title':'操作提示',
		"info":'确认删除 <span class="red">'+name+'</span> ?',
		'id':id,
		'toID':checklist_id
	};
	adminJS.confirm(jsonObj,function(e,id,toID){
		if(e==0){
			return ;
		}
		var jsonPar = {
			'id' : getStr(id)
		};
		var jsonAjax = {
			'url' : 'inquiryLogChecklistDetails_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'dataTbody_inquiryLogChecklistDetails'+toID
		};
		getAjaxData(jsonAjax);
	});
}

