/****** 初始化设置 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function query_UtilInitData(page){
	loadingDiv();
	var query_init_name = $("#query_init_name").val();
	var json = {
		"init_name" : query_init_name,
 		 "init_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function getUpdateMainJson(id,zt) {
	var update_init_name = $("#update_init_name").val();
	var update_init_key=$("#update_init_key").val();
	if(zt==2){
		update_init_key=$("#update_init_key").attr("src");
		if(isUndefinedAndEmpty(update_init_key)){
			alert("请选择图片");
			return false;
		}
	}else if(zt==6){
		update_init_key=$("#update_init_key").attr("src");
		if(isUndefinedAndEmpty(update_init_key)){
			alert("请选择视频");
			return false;
		}
	}
	var jsonObj = {
		"init_name" : update_init_name,
		"init_key" : update_init_key,
		"init_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}


function openEditPage(id){ 
	var jsonObj = {"init_id" : id};
	var jsonAjax = {
		"url" : "utilInitData_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "修改",
		"icon" : "edit",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

function editDataValidate(id,zt){
	var jsonObj={
		"methodName":"editData",
		"id":id,
		"zt":zt
		};
	jsonValidate = jsonObj;
}

function editData(jsonObj){
	var json=getUpdateMainJson(jsonObj.id,jsonObj.zt);
	if(json!=false){
		var jsonAjax = {
			"url" : "utilInitData_updateData.do",
			"jsonData" : json,
			"methodName" : "update_edit",
			"toID" :"tbodyData"
		};
		getAjaxData(jsonAjax);
	}
}
/**
 * 勾选
 */
function changeInitKey(id){
	var init_key=$("#tr"+id+" input[name='init_key']:checked").val();
	if(isUndefinedAndEmpty(init_key)){
		init_key='0';
	}
		var jsonPar = {
			'init_key' : init_key,
			'init_id' : id
		};
		var jsonAjax = {
				'url' : 'utilInitData_updateData.do',
				'jsonData' : {'mapStr':jsonToStr(jsonPar)},
				"methodName" : "update_edit",
				"toID" :"tbodyData"
		};
		getAjaxData(jsonAjax);
}
/************************系统生成方法完毕******************************/