/****** 门店基本资料 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryStoreInfo(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_store_phone = $("#query_store_phone").val();
	var query_store_name = $("#query_store_name").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"store_phone" : query_store_phone,
		"store_name" : query_store_name,
 		 "store_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "storeInfo_addPage.do",
		"jsonData" : {"mapStr":jsonToStr({'getStr':'005,006,007,008'})},
		"title" : "门店基本资料添加",
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
	
	var update_store_jgdm = $("#update_store_jgdm").val();
	var update_store_paw = $("#update_store_paw").val();
	var update_store_phone = $("#update_store_phone").val();
	var update_store_name = $("#update_store_name").val();
	var update_store_img = $("#update_store_img").attr("src");
	var update_store_im = $("#update_store_im").val();
	var update_store_fwwddm = $("#update_store_fwwddm").val();
	var update_store_xzqhdm = $("#update_store_xzqhdm").val();
	var update_store_fwdlx = $("#update_store_fwdlx").val();
	var update_store_fwdclrq = $("#update_store_fwdclrq").val();
	var update_store_dwlsgxdm = $("#update_store_dwlsgxdm").val();
	var update_store_fwdflgllbdm = $("#update_store_fwdflgllbdm").val();
	var update_store_fwdfldm = $("#update_store_fwdfldm").val();
	var update_store_jjlxdm = $("#update_store_jjlxdm").val();
	var update_store_dz = $("#update_store_dz").val();
	var update_store_fwdyyjb = $("#update_store_fwdyyjb").val();
	var update_store_fwdyydj = $("#update_store_fwdyydj").val();
	var update_store_xkzhm = $("#update_store_xkzhm").val();
	var update_store_xkxmmc = $("#update_store_xkxmmc").val();
	var update_store_xkzyxq = $("#update_store_xkzyxq").val();
	var update_store_kbzjjes = $("#update_store_kbzjjes").val();
	var update_store_frdb = $("#update_store_frdb").val();
	var update_store_fwdszdmzzzdfbz = $("input[name=update_store_fwdszdmzzzdfbz]:checked").val();
	var update_store_sffzjg = $("input[name=update_store_sffzjg]:checked").val();
	var update_store_fwddemc = $("#update_store_fwddemc").val();
	var update_store_fwdms = $("#update_store_fwdms").val();
	var update_store_yzbm = $("#update_store_yzbm").val();
	var update_store_dhhm = $("#update_store_dhhm").val();
	var update_store_dwdzyx = $("#update_store_dwdzyx").val();
	var update_store_cxbz = $("#update_store_cxbz").val();
	
	var jsonObj = {
		"store_cxbz" : update_store_cxbz,
		"store_jgdm" : update_store_jgdm,
		"store_phone" : update_store_phone,
		"store_paw" : update_store_paw,
		"store_name" : update_store_name,
		"store_img" : update_store_img,
		"store_im" : update_store_im,
		"store_fwwddm" : update_store_fwwddm,
		"store_xzqhdm" : update_store_xzqhdm,
		"store_fwdlx" : update_store_fwdlx,
		"store_fwdclrq" : update_store_fwdclrq,
		"store_dwlsgxdm" : update_store_dwlsgxdm,
		"store_fwdflgllbdm" : update_store_fwdflgllbdm,
		"store_fwdfldm" : update_store_fwdfldm,
		"store_jjlxdm" : update_store_jjlxdm,
		"store_dz" : update_store_dz,
		"store_fwdyyjb" : update_store_fwdyyjb,
		"store_fwdyydj" : update_store_fwdyydj,
		"store_xkzhm" : update_store_xkzhm,
		"store_xkxmmc" : update_store_xkxmmc,
		"store_xkzyxq" : update_store_xkzyxq,
		"store_kbzjjes" : update_store_kbzjjes,
		"store_frdb" : update_store_frdb,
		"store_fwdszdmzzzdfbz" : update_store_fwdszdmzzzdfbz,
		"store_sffzjg" : update_store_sffzjg,
		"store_fwddemc" : update_store_fwddemc,
		"store_fwdms" : update_store_fwdms,
		"store_yzbm" : update_store_yzbm,
		"store_dhhm" : update_store_dhhm,
		"store_dwdzyx" : update_store_dwdzyx,
		
		"store_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "storeInfo_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id,type){
	var title="门店基本资料编辑";
	if(type==2){
		title="重置密码";
	}
	var jsonObj = {"store_id" : id,"type":type,'getStr':'005,006,007,008'};
	var jsonAjax = {
		"url" : "storeInfo_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : title,
		"icon" : "edit",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

function editDataValidate(id,type){
	var jsonObj={
		"methodName":"editData",
		"id":id,
		'type':type
		};
	jsonValidate = jsonObj;
}

function editData(jsonObj){
	var methodName="update_edit";
	if(jsonObj.type=='shop'){
		methodName="update_shop";
	}
	var jsonAjax = {
		"url" : "storeInfo_updateData.do",
		"jsonData" : getUpdateMainJson(jsonObj.id),
		"methodName" : "update_edit",
		"toID" :"tbodyData"
	};
	getAjaxData(jsonAjax);
}
//商家保存信息回调
function update_shop(jsonObj){
	if(jsonObj.data=='error'){
		adminJS.alert({'title':'操作提示','info':'保存失败！请重试...'});
	}else{
		$('.has-error').removeClass("has-error");
		$('.has-success').removeClass("has-success");
		$('.form-group').find(".input-help").remove();
		$('.form-group').find(".input-icon").find(".fa-times-circle").remove();
		$('.form-group').find(".input-icon").find(".fa-check-circle").remove();
		$('.form-group').find(".input-icon").find(".fa-check-circle").remove();
		adminJS.alert({'title':'操作提示','info':'保存成功！'});
	}
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
			'url' : 'storeInfo_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/