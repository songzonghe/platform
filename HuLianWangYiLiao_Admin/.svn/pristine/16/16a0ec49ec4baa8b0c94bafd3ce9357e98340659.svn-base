/****** 业务开展情况 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilHospitalInstitutionBusiness(page){
	loadingDiv();
	var query_business_nf = $("#query_business_nf").val();
	var json = {
		"business_nf" : query_business_nf,
 		 "business_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilHospitalInstitutionBusiness_addPage.do",
		"jsonData" : null,
		"title" : "业务开展情况添加",
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
	var update_business_nf = $("#update_business_nf").val();
	var update_business_pcjgsl = $("#update_business_pcjgsl").val();
	var update_business_bspt = $("#update_business_bspt").val();
	var update_business_wljgtdz = $("#update_business_wljgtdz").val();
	var update_business_jgmsxx = $("#update_business_jgmsxx").val();
	var update_business_jfmj = $("#update_business_jfmj").val();
	var update_business_zgzs = $("#update_business_zgzs").val();
	var update_business_khffryzs = $("#update_business_khffryzs").val();
	var update_business_ywyfmj = $("#update_business_ywyfmj").val();
	var update_business_zsr = $("#update_business_zsr").val();
	var update_business_zzc = $("#update_business_zzc").val();
	var update_business_zzch = $("#update_business_zzch").val();
	var update_business_ldzc = $("#update_business_ldzc").val();
	var update_business_dwtz = $("#update_business_dwtz").val();
	var update_business_gdzc = $("#update_business_gdzc").val();
	var update_business_wxzcjkbf = $("#update_business_wxzcjkbf").val();
	var update_business_fz = $("#update_business_fz").val();
	var update_business_jzc = $("#update_business_jzc").val();
	var update_business_cxbz = $("#update_business_cxbz").val();
	var jsonObj = {
		"business_cxbz" : update_business_cxbz,
		"hospital_id" : update_hospital_id,
		"business_nf" : update_business_nf,
		"business_pcjgsl" : update_business_pcjgsl,
		"business_bspt" : update_business_bspt,
		"business_wljgtdz" : update_business_wljgtdz,
		"business_jgmsxx" : update_business_jgmsxx,
		"business_jfmj" : update_business_jfmj,
		"business_zgzs" : update_business_zgzs,
		"business_khffryzs" : update_business_khffryzs,
		"business_ywyfmj" : update_business_ywyfmj,
		"business_zsr" : update_business_zsr,
		"business_zzc" : update_business_zzc,
		"business_zzch" : update_business_zzch,
		"business_ldzc" : update_business_ldzc,
		"business_dwtz" : update_business_dwtz,
		"business_gdzc" : update_business_gdzc,
		"business_wxzcjkbf" : update_business_wxzcjkbf,
		"business_fz" : update_business_fz,
		"business_jzc" : update_business_jzc,
		"business_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilHospitalInstitutionBusiness_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"business_id" : id};
	var jsonAjax = {
		"url" : "utilHospitalInstitutionBusiness_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "业务开展情况编辑",
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
		"url" : "utilHospitalInstitutionBusiness_updateData.do",
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
			'url' : 'utilHospitalInstitutionBusiness_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/