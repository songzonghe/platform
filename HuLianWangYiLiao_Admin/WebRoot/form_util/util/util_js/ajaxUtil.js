/*********************ajax操作工具js*********************/


/**
 * 这个方法做了一些操作、然后调用回调函数
 * @param fn 当前需要操作的对象
 * @param args 当前操作的参数
 */
function doCallback(fn,args){
    fn.apply(this, args);  
}
/**
 * 所有与action交涉的ajax请求都都本方法执行
 * @param jsonAjax
 * @url -必须  请求的url
 * @jsonData -可选  json参数数据
 * @methodName -可选 回调方法名 query_back查询 page_back打开页面   update_add、update_edit、update_delete添加、修改、删除  node_back 加载下一级
 * @title -可选  显示打开div标题
 * @jsonParameter -可选 传递过来json参数
 * @toID -可选 当前在那个tbody中操作数据
 * @return dataTemp 返回请求过来的数据
 */
function getAjaxData(jsonAjax,type) {
	if(type!='no'){
		loadingDiv();
	}
	$.ajax({
		type : "post",
		url : jsonAjax.url,
		cache : true,
		async : true,
		data : jsonAjax.jsonData,
		dataType : "html",
		success : function(data) {
			if(!isUndefinedAndEmpty(jsonAjax.methodName)){ //如果有回调方法就进行回调
				var jsonObj = editJson(jsonAjax, "data", data);
				doCallback(eval(jsonAjax.methodName),[jsonObj]);
			}
			closeLoadingDiv();
		},
		error:function(data){ 
			alert("请求出错了!");
			$("#dialodIndex").remove();
			closeLoadingDiv();
	    }
	});
}
/**
 * 文件上传使用ajax
 * @param jsonAjax
 */
function getAjaxUpdateData(jsonAjax) {
	loadingDiv();
	$.ajaxFileUpload( {
		url : jsonAjax.url, // 用于文件上传的服务器端请求地址
		secureuri : false, // 一般设置为false
		fileElementId : jsonAjax.fileElementId, // 文件上传空间的id属性input type="file"
		data : jsonAjax.jsonData, //json格式参数
		dataType : 'text', // 返回值类型 一般设置为json
		success : function(data, status){// 服务器成功响应处理函数
			if(!isUndefinedAndEmpty(jsonAjax.methodName)){ //如果有回调方法就进行回调
				var jsonObj = editJson(jsonAjax, "data", data);
				doCallback(eval(jsonAjax.methodName),[jsonObj]);
			}
			closeLoadingDiv();
		},
		error : function(data, status, e){// 服务器响应失败处理函数
			alert("文件上传出错了!");
			$("#dialodIndex").remove();
			closeLoadingDiv();
		}
	});
}



/**
 * ajax请求之后的回执处理
 * @param ajaxData  回执数据
 * @return boolean 正确返回true  错误返回false
 */
function ajaxReceipt(ajaxData){
	if (ajaxData=="error") {//错误信息输出
		return false ;
	}
	return true;
}
/**
 * 操作完成之后统一调用
 */
function overUpdate(){
	$('#isUpdate').attr('value','n');
	$("#infoupdateData").empty();
}
/**
 * 将返回值存放在div中
 * @param divID 需要存放的DIV ID
 * @param ajaxData  回执数据
 */
function setReturnVal(divID,ajaxData){
	$("#"+divID).html(ajaxData);
}
/**
 * 显示错误信息
 */
function errorInfo(){
	alert("操作失败!");
}
/**
 * 默认打开一个页面回调
 * @param jsonObj json对象
 * 		  包含：data 数据  title 标题
 */
function page_back(jsonObj) {
	var jsonObjDIVTemp = {
		"data_title" : jsonObj.title,
		"data_content" : jsonObj.data,
		"back_function":jsonObj.back_function,
		"icon" : jsonObj.icon,
		"color" : jsonObj.color
	}
	var div_id = openwDiv(jsonObjDIVTemp);
	//页面打开完成  回调
	if(!isUndefinedAndEmpty(jsonObj.openEndMethodName)){
		doCallback(eval(jsonObj.openEndMethodName),[jsonObj]); 
	}
	
	$('#'+div_id+' input[type="text"]').each(function(){
		$(this).parent().append('&nbsp;<font style="color:red" size="5">*</font>');
		$(this).css('width','90%');
	});
	//add by liwenhai 2020-03-23
	$('#'+div_id+' input[type="text"]').each(function(){
		if($(this).hasClass('nonessential')){
			$(this).parent().find("font").remove();
		}
	});
	//end
	$('#'+div_id+' input[type="password"]').each(function(){
		$(this).parent().append('&nbsp;<font style="color:red" size="5">*</font>');
		$(this).css('width','90%');
	});
	
	$('#'+div_id+' input[type="file"]').each(function(){
		$(this).parent().append('&nbsp;<font style="color:red" size="5">*</font>');
		$(this).css('width','90%');
	});
	
	$('#'+div_id+' select').each(function(){
		$(this).css('width','90%');
	});
	
	$('#'+div_id+' textarea').each(function(){
		$(this).css('width','90%');
	});
	
	
	return div_id;
}

/**
 * 默认做具体修改操作的回调
* @param jsonObj json对象
 * 		  包含：data 数据
 */
function update_add(jsonObj){
	var fal = ajaxReceipt(jsonObj.data);
	if(fal){
		if(!isUndefinedAndEmpty(jsonObj.toID)){
			setReturnVal("infoupdateData",jsonObj.data);
			var id = jsonObj.toID;
			var trThisTemp = jQuery("div[id=infoupdateData] table tbody").html();
			
			var updateBackInfo =$("#updateBackInfo").val();
			if(!isUndefinedAndEmpty(updateBackInfo)){
				adminJS.alert({'title':'操作提示','info':updateBackInfo});
				$('button').blur();
			}else{
				if(isUndefinedAndEmpty($("#"+id +" tr").attr("id"))){
					$("#"+id).html(trThisTemp);
				}else{
					$("#"+id).prepend(trThisTemp);
				}
				getOrderTdIndex(jsonObj.toID);
				loadTrClick();
				overUpdate();
				closeShowDiv();
			}
		}
	}else{
		errorInfo();
	}
}


/**
 * 节点目录添加完成回调
 * @param jsonObj
 */
function update_addNode(jsonObj){
	var fal = ajaxReceipt(jsonObj.data);
	if(fal){
		var fl_id = jsonObj.fl_id;
		var  trThis = $("#tr"+fl_id);
		if(trThis.attr("isOpen")=='n'){
			doCallback(eval(jsonObj.tbodyMethodName),[fl_id]);
		}else{
			setReturnVal("infoupdateData",jsonObj.data);
			var trThisTemp = jQuery("div[id=infoupdateData] table tbody").html();
			trThis.after(trThisTemp);
		}
		loadTrClick();
		overUpdate();
	}else{
		errorInfo();
	}
	closeShowDiv();
}

/**
 * 默认做具体修改操作的回调
* @param jsonObj json对象
 * 		  包含：data 数据
 */
function update_edit(jsonObj){
	var fal = ajaxReceipt(jsonObj.data);
	if(fal){
		setReturnVal("infoupdateData",jsonObj.data);
		var id =  $("#updateID").val();
		var updateBackInfo =$("#updateBackInfo").val();
		
		if(!isUndefinedAndEmpty(updateBackInfo)){
			adminJS.alert({'title':'操作提示','info':updateBackInfo});
		}else{
			var dataTr = $("div[id=infoupdateData] table tbody");
			if(dataTr.length!=0){
				var tbodyTr = $("#"+jsonObj.toID).find("#tr"+id);
				tbodyTr.after(dataTr.html());
				tbodyTr.remove();
			}
			overUpdate();
			getOrderTdIndex(jsonObj.toID);
			loadTrClick();
			$("#"+jsonObj.toID).find("#tr"+id).css("background-color","#f0f0f0");
			var nextpid=$("#"+jsonObj.toID).find("#tr"+id).next().attr('pid');
			if(!isUndefinedAndEmpty(nextpid) && nextpid=='tr'+id){
				$("#"+jsonObj.toID).find("#tr"+id).next().remove();
			}
			closeShowDiv();
		}
	}else{
		errorInfo();
	}
}
/**
 * 默认做具体修改操作的回调
* @param jsonObj json对象
 * 		  包含：data 数据
 */
function update_editNode(jsonObj){
	var fal = ajaxReceipt(jsonObj.data);
	if(fal){
		setReturnVal("infoupdateData",jsonObj.data);

		var id =  $("#updateID").val();
		var dataTr = $("div[id=infoupdateData] table tbody");
		if(dataTr.length!=0){
			var tbodyTr = $("#"+jsonObj.toID).find("#tr"+id);
			tbodyTr.after(dataTr.html());
			tbodyTr.remove();
		}
		loadTrClick();
		$("#"+jsonObj.toID).find("#tr"+id).css("background-color","#f0f0f0");
	}else{
		errorInfo();
	}
	closeShowDiv();
}

/**
 * 操作完成调用
 * @param jsonObj
 */
function updateOver_back(jsonObj){
	if(!ajaxReceipt(jsonObj.data)){
		errorInfo();
	}
	$('#isUpdate').attr('value','n');
	closeShowDiv();
}


/**
 * 默认做具体修改操作的回调
* @param jsonObj json对象
 * 		  包含：data 数据
 */
function update_delete(jsonObj){
	var fal = ajaxReceipt(jsonObj.data);
	if(fal){
		var jsonData=strToJson(jsonObj.data);
		if(jsonData.code=='300'){
			adminJS.alert({'title':'操作提示','info':jsonData.info});
			return;
		}
		//判断是否存在子分类
		var $pid=$("#tr"+jsonData.id).next().attr("pid"); 
		if(typeof($pid)!="undefined"){  
			  $("#tr"+jsonData.id).next().remove();
			 } 
		$("#tr"+jsonData.id).remove();
		getOrderTdIndex(jsonObj.toID);
	}else{
		errorInfo();
	}
}

/**
 * 添加或删除一条数据重新排序  使用自带tdIndex排序
 * @param tbodyID 当前的tbodyID
 */
function getOrderTdIndex(tbodyID){
	var i = 1 ;
	if(tbodyID=='tbodyData' && !isUndefinedAndEmpty($("#"+tbodyID+" tr").attr('isOpen'))){
		$("#"+tbodyID+" tr td[index=tdIndex]").each(function(){
			if(!isUndefinedAndEmpty($(this).parent("tr").attr('isOpen'))){
				$(this).html(i);
				i+=1;
			}
		});
	}else{
		$("#"+tbodyID+" tr td[index=tdIndex]").each(function(){
			$(this).html(i);
			i+=1;
		});
	}
}


/**
 * 详情记录分页加载
 * @param jsonObj
 */
function moblieQuery_back(jsonObj){
	var jsonTemp = strToJson(jsonObj.jsonData.mapStr);
	$("#"+jsonObj.targetContainer).find("#pageContainer").remove();
	if(jsonTemp.pageNum==0){
		$("#"+jsonObj.targetContainer).html(jsonObj.data);
	}else{
		$("#"+jsonObj.targetContainer).append(jsonObj.data);
	}
}