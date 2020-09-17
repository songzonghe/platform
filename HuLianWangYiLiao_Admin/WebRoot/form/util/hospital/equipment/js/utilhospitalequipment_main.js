/****** 系统医院设备 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilHospitalEquipment(page){
	loadingDiv();
	var query_equipment_sbdh = $("#query_equipment_sbdh").val();
	var query_equipment_sbmc = $("#query_equipment_sbmc").val();
	var json = {
		"equipment_sbdh" : query_equipment_sbdh,
		"equipment_sbmc" : query_equipment_sbmc,
 		 "equipment_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilHospitalEquipment_addPage.do",
		"jsonData" : null,
		"title" : "系统医院设备添加",
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
	var update_equipment_jgdm = $("#update_equipment_jgdm").val();
	var update_equipment_sbdh = $("#update_equipment_sbdh").val();
	var update_equipment_sbmc = $("#update_equipment_sbmc").val();
	var update_equipment_tpsbts = $("#update_equipment_tpsbts").val();
	var update_equipment_cd = $("#update_equipment_cd").val();
	var update_equipment_sccj = $("#update_equipment_sccj").val();
	var update_equipment_sbxh = $("#update_equipment_sbxh").val();
	var update_equipment_sbcs = $("#update_equipment_sbcs").val();
	var update_equipment_sblx = $("#update_equipment_sblx").val();
	var update_equipment_gmrq = $("#update_equipment_gmrq").val();
	var update_equipment_yt = $("#update_equipment_yt").val();
	var update_equipment_sbjzje = $("#update_equipment_sbjzje").val();
	var update_equipment_gjsxqk = $("#update_equipment_gjsxqk").val();
	var update_equipment_llsjsm = $("#update_equipment_llsjsm").val();
	var update_equipment_syqk = $("#update_equipment_syqk").val();
	var update_hospital_id = $("#update_hospital_id").val();
	var update_equipment_cxbz = $("#update_equipment_cxbz").val();
	var jsonObj = {
		"equipment_jgdm" : update_equipment_jgdm,
		"equipment_sbdh" : update_equipment_sbdh,
		"equipment_cxbz" : update_equipment_cxbz,
		"equipment_sbmc" : update_equipment_sbmc,
		"equipment_tpsbts" : update_equipment_tpsbts,
		"equipment_cd" : update_equipment_cd,
		"equipment_sccj" : update_equipment_sccj,
		"equipment_sbxh" : update_equipment_sbxh,
		"equipment_sbcs" : update_equipment_sbcs,
		"equipment_sblx" : update_equipment_sblx,
		"equipment_gmrq" : update_equipment_gmrq,
		"equipment_yt" : update_equipment_yt,
		"equipment_sbjzje" : update_equipment_sbjzje,
		"equipment_gjsxqk" : update_equipment_gjsxqk,
		"equipment_llsjsm" : update_equipment_llsjsm,
		"equipment_syqk" : update_equipment_syqk,
		"hospital_id" : update_hospital_id,
		"equipment_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilHospitalEquipment_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"equipment_id" : id};
	var jsonAjax = {
		"url" : "utilHospitalEquipment_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "系统医院设备编辑",
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
		"url" : "utilHospitalEquipment_updateData.do",
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
			'url' : 'utilHospitalEquipment_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/