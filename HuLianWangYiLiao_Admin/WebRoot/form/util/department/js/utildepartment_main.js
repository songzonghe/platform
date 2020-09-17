/****** 系统科室 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilDepartment(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_department_name = $("#query_department_name").val();
	var query_department_sort = $("#query_department_sort").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"department_name" : query_department_name,
		"department_sort" : query_department_sort,
 		 "department_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilDepartment_addPage.do",
		"jsonData" : {"mapStr":jsonToStr({'getStr':'009'})},
		"title" : "系统科室添加",
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
	var update_department_jgdm = $("#update_department_jgdm").val();
	var update_department_bzksdm = $("#update_department_bzksdm").val();
	var update_department_ybjdm = $("#update_department_ybjdm").val();
	var update_department_ksjs = $("#update_department_ksjs").val();
	var update_department_name = $("#update_department_name").val();
	var update_department_sort = $("#update_department_sort").val();
	var update_department_ksmm = $("#update_department_ksmm").val();
	var update_department_cxbz = $("#update_department_cxbz").val();
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"department_jgdm" : update_department_jgdm,
		"department_bzksdm" : update_department_bzksdm,
		"department_ybjdm" : update_department_ybjdm,
		"department_ksjs" : update_department_ksjs,
		"department_name" : update_department_name,
		"department_sort" : update_department_sort,
		"department_ksmm" : update_department_ksmm,
		"department_cxbz" : update_department_cxbz,
		"department_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilDepartment_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"department_id" : id,'getStr':'009'};
	var jsonAjax = {
		"url" : "utilDepartment_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "系统科室编辑",
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
		"url" : "utilDepartment_updateData.do",
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
			'url' : 'utilDepartment_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/