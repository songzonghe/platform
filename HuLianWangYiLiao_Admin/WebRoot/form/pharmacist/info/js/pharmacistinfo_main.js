/****** 药师管理 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
	clickShowUrl();
})
/************************系统生成方法开始******************************/

function clickShowUrl(){
	if($('#isshow').prop('checked')){
		$('#showurl').show();
		$('#hideurl').hide();
	}else{
		$('#showurl').hide();
		$('#hideurl').show();
	}
}

function queryPharmacistInfo(page){
	loadingDiv();
	var query_pharmacist_number = $("#query_pharmacist_number").val();
	var query_pharmacist_name = $("#query_pharmacist_name").val();
	var query_zTai = $("#query_zTai").val();
	var isshow = $('#isshow').prop('checked')?1:0;
	var json = {
		"pharmacist_number" : query_pharmacist_number,
		"pharmacist_name" : query_pharmacist_name,
		"zTai" : query_zTai,
		"isshow" : isshow,
 		 "pharmacist_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "pharmacistInfo_addPage.do",
		"jsonData" : null,
		"title" : "药师添加",
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
	var update_pharmacist_paw = $("#update_pharmacist_paw").val();
	var update_pharmacist_number = $("#update_pharmacist_number").val();
	var update_pharmacist_name = $("#update_pharmacist_name").val();
	var update_pharmacist_phone = $("#update_pharmacist_phone").val();
	var update_pharmacist_img = $("#update_pharmacist_img").attr("src");
	var update_pharmacist_autograph = $("#update_pharmacist_autograph").attr("src");
	var update_pharmacist_sex = $("input[name=update_pharmacist_sex]:checked").val();
	var update_pharmacist_document_number = $("#update_pharmacist_document_number").val();
	var update_pharmacist_document_img1 = $("#update_pharmacist_document_img1").attr("src");
	var update_pharmacist_document_img2 = $("#update_pharmacist_document_img2").attr("src");
	var update_pharmacist_medical_practitioner_certificate = $("#update_pharmacist_medical_practitioner_certificate").attr("src");
	var update_pharmacist_medical_licence = $("#update_pharmacist_medical_licence").attr("src");
	var update_pharmacist_synopsis = $("#update_pharmacist_synopsis").val();
	var update_pharmacist_sort = $("#update_pharmacist_sort").val();
	var update_zt = $("input[name=update_zt]:checked").val();
	var jsonObj = {
		"pharmacist_number" : update_pharmacist_number,
		"pharmacist_paw" : update_pharmacist_paw,
		"pharmacist_name" : update_pharmacist_name,
		"pharmacist_phone" : update_pharmacist_phone,
		"pharmacist_img" : update_pharmacist_img,
		"pharmacist_autograph" : update_pharmacist_autograph,
		"pharmacist_sex" : update_pharmacist_sex,
		"pharmacist_document_number" : update_pharmacist_document_number,
		"pharmacist_document_img1" : update_pharmacist_document_img1,
		"pharmacist_document_img2" : update_pharmacist_document_img2,
		"pharmacist_medical_practitioner_certificate" : update_pharmacist_medical_practitioner_certificate,
		"pharmacist_medical_licence" : update_pharmacist_medical_licence,
		"pharmacist_synopsis" : update_pharmacist_synopsis,
		"pharmacist_sort" : update_pharmacist_sort,
		"edit_zt" : update_zt,
		"pharmacist_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "pharmacistInfo_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"pharmacist_id" : id};
	var jsonAjax = {
		"url" : "pharmacistInfo_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "药师编辑",
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
		"url" : "pharmacistInfo_updateData.do",
		"jsonData" : getUpdateMainJson(jsonObj.id),
		"methodName" : "update_edit",
		"toID" :"tbodyData"
	};
	getAjaxData(jsonAjax);
}

/**
 * type 0 禁用  1启用  del 删除
 */
function confirmDeleteDate(id,type){
	var info="删除";
	if(type=='0'){
		info="禁用";
	}else if(type=='1'){
		info="启用";
	}
	var jsonObj = {
		'title':'操作提示',
		"info":' <span class="red">确认'+info+' ?</span>',
		'id':id,
		'type':type
	};
	adminJS.confirm(jsonObj,function(e,id,type){
		if(e==0){return ;}
		var jsonPar = {
			'id' : getStr(id),
			'pharmacist_id' : getStr(id),
			'edit_zt':type
		};
		var methodName='update_edit';
		var url='pharmacistInfo_updateData.do';
		if(type=='del'){
			methodName='update_delete';
			url='pharmacistInfo_deleteData.do';
		}
		var jsonAjax = {
			'url' : url,
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : methodName,
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/