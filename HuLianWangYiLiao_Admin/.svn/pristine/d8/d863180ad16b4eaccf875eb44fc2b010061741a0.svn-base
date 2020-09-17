/****** 账户 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function querySystemAccount(page){
	loadingDiv();
	var query_account_number = $("#query_account_number").val();
	var query_account_name = $("#query_account_name").val();
	var query_zTai = $("#query_zTai").val();
	var json = {
		"account_number" : query_account_number,
		"account_name" : query_account_name,
		"zTai" : query_zTai,
 		 "account_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "systemAccount_addPage.do",
		"jsonData" : null,
		"title" : "账户添加",
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
	var update_account_number = $("#update_account_number").val();
	var update_account_pwd = $("#update_account_pwd").val();
	var update_account_name = $("#update_account_name").val();
	var update_functions_id = $("#update_functions_id").val();
	var jsonObj = {
		"account_number" : update_account_number,
		"account_pwd" : update_account_pwd,
		"account_name" : update_account_name,
		"functions_id" : update_functions_id,
		"account_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "systemAccount_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id,type){
	var jsonObj = {"account_id" : id,'openType':type};
	var title="账户修改";
	if(type=='pwd'){
		var title="重置账户密码";
	}
	var jsonAjax = {
		"url" : "systemAccount_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : title,
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
		"url" : "systemAccount_updateData.do",
		"jsonData" : getUpdateMainJson(jsonObj.id),
		"methodName" : "update_edit",
		"toID" :"tbodyData"
	};
	getAjaxData(jsonAjax);
}

function confirmDeleteDate(id,name){
	var jsonObj = {
		'title':'操作提示',
		"info":'确认删除账号<span class="red">'+name+'</span> ?',
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
			'url' : 'systemAccount_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/**
 * 禁用/启用
 */
function confirmUpdateLock(id,name,type){
	var title="禁用提示";
	var info='确认禁用账号 <span class="red">'+name+'</span> ?';
	if('2'==type){
		title="启用提示";
		info='确认启用账号 <span class="red">'+name+'</span> ?';
	}
	var jsonObj = {
			'title':title,
			"info":info,
			'id':id,
			'type':type
	};
	adminJS.confirm(jsonObj,function(e,id,type){
		if(e==0){
			return ;
		}
		var jsonPar = {
				'id' : getStr(id),
				'account_id' : getStr(id),
				'edit_zt':type
		};
		var jsonAjax = {
			'url' : 'systemAccount_updateData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_edit',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/**
 * 打开权限窗口
 */
function openFunctionsPage(id,num){
	var jsonPar = {
			'account_id' : getStr(id)
	};
	var jsonAjax = {
			"url" : "systemAccount_getAllfunctionData.do",
			"jsonData" : {'mapStr':jsonToStr(jsonPar)},
			"title" : "正在为"+num+"配置权限",
			"icon" : "plus",
			"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

/**
 * 修改权限
 */
function addFunctionData(id){
	var jsonPar = {
		'account_id' : getStr(id),
		'zhuPage' : $('input[name="zhuPage"]:checked').val(),
		'functionsDatas':getFunctionsDatas(id)
	};
	var jsonAjax = {
			"url" : "systemAccount_editFunctionData.do",
			"jsonData" : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_edit',
			'toID' : 'tbodyData'
	};
	getAjaxData(jsonAjax);
}
/**
 * 获取账户的权限地址
 */
function getFunctionsDatas(id){
	var list=new Array();
	$('input[name="cid"]:checked').each(function(){
		var texts='val'+$(this).val();
		var jsonPar={
			'account_id' : getStr(id),
			'functions_id':$(this).val()
		}
		list.push(jsonPar);
	});
	if(!isUndefinedAndEmpty(list)){
		return jsonToStr(list);
	}
	return null
}

/************************系统生成方法完毕******************************/