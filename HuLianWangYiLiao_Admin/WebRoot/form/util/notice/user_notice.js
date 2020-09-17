/****** 消息管理 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function openAddPages(type){
	var jsonObj = {"type" : type};
	var jsonAjax = {
		"url" : "utilNotice_addPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "系统消息添加",
		"icon" : "plus",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}


function addMessageDataValidate(backType){
	var methodName='chooseUser';
	if(backType=='1'){
		methodName='backAllUser';
	}
	var jsonObj={
		"methodName":methodName,
	};
	jsonValidate = jsonObj;
}
function backAllUser(obj){
	addMessageData('1');
}



function getUpdateMessageMainJson(type) {
	var update_user_id = "0";
	if(type=='2'){
		update_user_id=getCheckboxVal("typeCheckBox");
		if(isUndefinedAndEmpty(update_user_id)){
			adminJS.alert({'title':'操作提示','info':'请选择用户！！'})
			return false;
		}
	}
	var update_log_content = $("#update_log_content").val();
	var update_log_title = $("#update_log_title").val();
	var user_type = $("#user_type").val();
	var jsonObj = {
		"user_id" : update_user_id,
		"type" : type,
		"log_content" : update_log_content,
		"user_type":user_type,
		"log_title" : update_log_title,
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addMessageData(type){
	var jsonObj = getUpdateMessageMainJson(type);
	if(jsonObj!=false){
		var jsonAjax = {
			"url" : "userNotice_addData.do",
			"jsonData" : jsonObj,
			"methodName" : "update_addback",
			"toID" : "tbodyData"
		};
		getAjaxData(jsonAjax);
	}
}

function update_addback(jsonObj){
	var fal = ajaxReceipt(jsonObj.data);
	if(fal){
		if(jsonObj.data=='true'){
			alert("发送成功！");
		}else{
			alert("发送失败！");
		}
	}else{
		alert("发送失败！");
	}
	closeShowDiv();closeShowDiv();
}

/**
 * 选择用户页面
 * @param this_
 * @return
 */
function chooseUser(obj){
	var user_type = $("#user_type").val();
	var jsonAjax = {
		"url" : "userNotice_mainPage.do",
		"jsonData" : {"mapStr":jsonToStr({'user_type':user_type})},
		"title" : "选择用户",
		"methodName" : "page_back"
	};
	// 调用显示函数
	getAjaxData(jsonAjax);
}


/**
 * 根据条件查询数据
 * @param value
 * @param page 
 * @return
 */
function searchUser(value,page) {
	var user_nickname = $("#userNickname").val();
	var user_phone = $("#userPhone").val();
	var userzt = $("#userzt").val();
	var user_type = $("#user_type").val();
	var json = {
		"user_name":user_nickname,
		"user_phone":user_phone,
		"userzt":userzt,
		"user_type":user_type
	};
	var jsonObj = getPageParameter(json, page, "n", "");
	var jsonAjax = {
		"url" :"userNotice_getUsersData.do",
		"jsonData" : {"mapStr" : jsonToStr(jsonObj)},
		"title" : "添加消息",
		"methodName" : "moblieQuery_back",
		"targetContainer" : "userList"
	};
	// 调用显示函数
	getAjaxData(jsonAjax);
}

