/***********body操作JS 李飞  2016年4月3日 23:59:22 *************/

/** ***********************图片上传  2017年2月13日 10:44:45 新加入方法******************************* */

//获取上传地址
function getUploadAddress(){
	var href=window.location.href;
	var num1=href.indexOf($("#root").val());//排除地址后面的参数
	href=href.substring(0,num1);
	return href;
}
/**
 * @param elementId 操作元素的ID
 * @param width 图片上传的宽度 0后台不做处理
 * @param height 图片上传的高度 0后台不做处理
 * @param backUrl 返回地址
 */
function uploadImg(elementId,width,height,backUrl) {
	if(isUndefinedAndEmpty(backUrl)){
		backUrl='uploadImg_back';
	}
	var jsonAjax = {
		'url' : 'otherFile_fileEntityUploadImg.do',
		'fileElementId' : elementId+'_file',
		'jsonData' : {
			"width" : width,
			"height" : height
		},
		'methodName' : backUrl,
		'elementId' : elementId
	}
	getAjaxUpdateData(jsonAjax);
}
/**
 * 上传图片回调
 * 
 * @param jsonObj
 */
function uploadImg_back(jsonObj) {
	var fal = ajaxReceipt(jsonObj.data);
	if (fal) {
		$('#'+jsonObj.elementId).attr("src", getUploadAddress()+jsonObj.data);
		$('#'+jsonObj.elementId).attr("isUpload", "y");
	}
}
/**
 * 清空图片
 * 
 * @param index
 */
function imgCancel(elementId) {
	$('#' + elementId).attr('src',getRoot() + '/form_util/util/images/upload.png');
}
/**
 * 视频格式验证
 */
function isVideo(fileName){
	var patrn = /.(avi|mp4|flv|mov|wmv|3gp|swf|asf)$/;
	if(patrn.test(fileName))
		return true;
	else
		return false;
}
/**
 * mp3验证
 */
function isMp3(fileName){
	var patrn = /.(MP3|mp3)$/;
	if(patrn.test(fileName))
		return true;
	else
		return false;
}

/**
 * 上传map3
 */
function uploadMp3(elementId){
	var fileElementId = elementId+'_file';
	var name = $('#'+fileElementId).val();
	if(!isMp3(name)){
		adminJS.alert({"title":"警告","info":"请上传MP3格式的音频"});
		videoClear(elementId);
		return ;
	}
	$('#'+elementId).slideDown();
	var jsonAjax = {
		'url' : 'otherFile_fileEntityUploadMedia.do',
		'fileElementId' : fileElementId,
		'methodName' : 'uploadVideo_back',
		'elementId' : elementId
	}
	getAjaxUpdateData(jsonAjax);
}
/**
 * 上传map3回调
 * @return
 */
function uploadVideo_back(jsonObj){
	var fal = ajaxReceipt(jsonObj.data);
	if (fal) {
		$('#'+jsonObj.elementId+'_file').val('');
		$('#'+jsonObj.elementId).attr("src", getUploadAddress()+jsonObj.data);
	}else{
		adminJS.alert({"title":"操作提示","info":"操作失败!"});
	}
}
/**
 * 清空视频
 * @param index
 */
function videoClear(elementId) {
	$('#' + elementId).attr('src','');
	$('#'+elementId+'_file').val('');
	$('#'+elementId).slideUp('fast');
}
/***********************获得浏览器高度和宽度*****************************/
/**
 * 得到当前浏览器的可视化高度 不包含滚动条一下的高度
 * @return 高度
 */
function getBodyHeight(){  
    if(window.innerHeight!= undefined){  
        return window.innerHeight;  
    }  
    else{  
        var B= document.body, D= document.documentElement;  
        return Math.min(D.clientHeight, B.clientHeight);  
    }  
}
/**
 * 得到页面高度宽度
 * @return 宽度
 */
function getBodyWidth(){  
	return $(window).width();
}
/***********************其他JS操作*****************************/
/**
 * 得到当前目录
 * @return root
 */
function getRoot() {
	return $('#root').val();
}


/**
 * 为table中的tr加载Click事件 操作tr颜色
 */
function loadTrClick(){
//	$("tr").unbind("click").click(function(e){
//		var index = 0;
//		$("table tbody tr").each(function(){
//			//余数为0 或 有isOpen 或 有 pid属性的tr不改变其他颜色
//			if(index%2==0 && isUndefinedAndEmpty($(this).attr("isOpen")) && isUndefinedAndEmpty($(this).attr("pid"))){
//				$(this).css("background-color","#f9f9f9");
//			}else{
//				$(this).css("background-color","#fff");
//			}
//			index +=1;
//		});
//		$(this).css("background-color","#F0F0F0");
//	});
}
/**
 * 为table中的tr加载Click事件 操作checkbox
 */
function clickCheckbox(obj,name){
	var checkboxThis=$(obj).find('input[type=checkbox]');
	if(!isUndefinedAndEmpty(name)){
		checkboxThis=$(obj).find('input[name="'+name+'"]');
	}
	if(checkboxThis.prop("checked")){
		checkboxThis.prop("checked",false);
	}else{
		checkboxThis.prop("checked",true);
	}
}
/***
 * 禁用点击复选框改变值 和方法 clickCheckbox 配套使用
 */
$("body").delegate("input","click", function(e){
	var bool=$(this).parents('tr').attr("onclick")
	if(!isUndefinedAndEmpty(bool) && (bool+"").indexOf("clickCheckbox(")!=-1){
		if($(this).is(":checked")){
			$(this).prop("checked",false);
		}else{
			$(this).prop("checked",true);
		}
	}
});
/**
 * 为table中的tr加载Click事件 操作radio
 */
function clickRadio(obj,name){
	if(isUndefinedAndEmpty(name)){
		$(obj).find('input[type=radio]').prop("checked",true);
	}else{
		$(obj).find('input[name="'+name+'"]').prop("checked",true);
	}
}

/***********************页面JS初始化排序操作*****************************/



/**
 * 处理页面排序th
 */
function initPage(){
	loadTrClick();
	initSort();
}

/*********************处理页面排序******************************************/
/**
 * 处理页面排序th
 */
function initSort(){
	var jsonMap = strToJson($("#pageMap").val());
	$(".dataTable").find("thead tr th").each(function(){
		var field = $(this).attr("field");
		if(!isUndefinedAndEmpty(field)){ //拥有排序字段权限
			if(jsonMap.SORTFIELD==field){
				$("#sortField").val(field);
				if("desc" == jsonMap.SORTTYPE){
					$(this).addClass("sorting_desc");
					$("#sortType").val("desc");
				}else if("asc" == jsonMap.SORTTYPE){
					$(this).addClass("sorting_asc");
					$("#sortType").val("asc");
				}
			}else{
				$(this).addClass("sorting");
			}
		}
	});
}

/******************************多层弹框排序********************************/

/**
 * 点击排序
 * sortId 点击位置处于的table的id
 * obj  this
 * backName  搜索方法名
 */
function getSort(sortId,obj,backName){
	var sortType=$(obj).attr("sortType");
	//改变排序类型
	if(isUndefinedAndEmpty(sortType)||sortType=="asc"){
		//先移除样式
		$("#"+sortId).find("th").attr("sortType","");
		$("#"+sortId).find(".sorting_desc").attr("class","sorting");
		$("#"+sortId).find(".sorting_asc").attr("class","sorting");
		//再给指定的样式
		$(obj).attr("sortType",'desc');
		$(obj).attr("class",'sorting_desc');
	}else if(sortType=='desc'){
		$("#sortType").val("asc");
		$(obj).attr("sortType",'asc');
		$(obj).attr("class",'sorting_asc');
	}
	doCallback(eval(backName),[sortId,0]);
}
//获取排序所需的信息
function getSortInfo(json,page,sortId){
	var isSort='n';
	var sortField='lrsj';
	var sortType='desc';
	var sortDataType='';
	if(!isUndefinedAndEmpty(sortId)){
		$("#"+sortId).find('th').each(function (e){
			var sort=$(this).attr("sortType");
			if(!isUndefinedAndEmpty(sort)){
				 sortType=$(this).attr("sortType");//排序类型
				 sortField=$(this).attr("name");//字段名
				 isSort="y";//开启排序
				 sortDataType=$(this).attr("type");//数字排序还是字符排序
			}
		});
	}
	var jsonObj={
		"json" : json,
		"pageNum" : page,
		"isSort" : isSort,
		"sortField" : sortField,
		"sortType" : sortType,
		"sortDataType" : sortDataType,
		"pageSelectID" : ""
	}
	return jsonObj;
}

/**
 * 排序查询
 * @param this_ 当前排序th
 */
function querySort(this_,sortMethosName){
	$("#sortField").val($(this_).attr("field"));
	$("#sortDataType").val($(this_).attr("type"));
	var sort = $(this_).attr("class");
	if("sorting" == sort){
		$("#sortType").val("desc");
	}else if("sorting_asc" == sort){
		$("#sortType").val("desc");
	}else if("sorting_desc" == sort){
		$("#sortType").val("asc");
	}
	doCallback(eval(sortMethosName),[0]);
}

/***********************弹出确认框公用操作*****************************/
/**
 * 打开确认页面
 * 
 * @param jsonObj  title 标题 icon图标 
 * 
 */
function openConfirmPage(jsonObj) {
	$("#jsonConfirm").val(jsonToStr(jsonObj));
	var jsonAjax = {
		"url" : "globalInfo_confirmBox.do",
		"title" : jsonObj.title,
		"icon" : jsonObj.icon,
		"color" : jsonObj.color,
		"jsonData":{"info":jsonObj.info},
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}
/**
 * 点击确认按钮 回调自己方法
 */
function confirmOk() {
	var jsonStr = $("#jsonConfirm").val();
	var jsonObj = strToJson(jsonStr);
	if(!isUndefinedAndEmpty(jsonObj.methodName)){
		doCallback(eval(jsonObj.methodName), [ jsonObj ]);
	}
	closeShowDiv();
}

/***********************checkbox公用操作*****************************/
/**
 * 根据IDS将对应的checkbox选中
 * @param ids 已选中的checkbox的ID集合
 */
function checkboxChecked(ids){
	if(isUndefinedAndEmpty(ids)){
		return ;
	}
	var idArray = ids.split(",");
	for (var i in idArray) {
		$("#checkbox"+idArray[i]).attr("checked",true);
	}
}


/**
 * 选择与全部选 
 * @param obj
 * @param checkboxName
 */
function selectAll(obj,checkboxName){
	var fal = obj.checked ;
	$('input[name=' + checkboxName + ']').each(function(){
		if(isUndefinedAndEmpty($(this).attr('disabled'))){
			//如果使用attr("checked",fal) 第一次正常  第二次就不顶用了
			$(this).prop("checked",fal);
		}
	});
}

/**
 * 得到所有选中的checkbox值 返回一个由id组成的字符串
 * 
 * @param checkboxName
 *            checkbox
 * @return str
 */
function getCheckboxVal(checkboxName) {
	var chk_values = null;
	$('input[name=' + checkboxName + ']:checked').each(function() {
		var val = $(this).val();
		if (val != "" && val != null) {
			if(null==chk_values){
				chk_values = val;
			}else{
				chk_values += ","+val;
			}
		}
	});
	return chk_values;
}

/**
 * 页面显示滚动条
 */
$(function(){
	var h = getBodyHeight()-190;
	$("#sample-table-2_wrapper").css("max-height",h+"px");
	$("#sample-table-2_wrapper").css("overflow","auto");
})

/**
 * 获取需导出excel页面的地址
 * @return
 */
function getExcelPageAddress(){
	var href=window.location.href;
	var num1=href.lastIndexOf('.do');//排除地址后面的参数
	href=href.substring(0,num1);
	var num2=href.lastIndexOf('/')+1;//截取页面名称
	var num3=href.lastIndexOf('_');
	href=href.substring(num2,num3);
	return href;
}

/**
 * 判断页面是否有数据并确认导出Excel
 * @param url 导出Excel信息的地址
 * @param pageName 界面名
 */
function confirmExportExcel(){
	if(getStr($("table tbody tr:first td").text())=='没有查询到数据'||isUndefinedAndEmpty($("table tbody tr:first td").text())){
		adminJS.alert({"title":"提示","info":"当前没有数据导出！"});
		return ;
	}
		var jsonObj = {
			'title':'操作提示',
			"info":'确认导出excel表格吗 ?',
			'id':'',
		};
		adminJS.confirm(jsonObj,function(e,id){
			if(e==0){
				return ;
			}
			//确认导出
			exportExcel_getInfo(getExcelPageAddress()+'_getExcelSql.do',getExcelPageAddress());
		});
}
function confirmExportExcelTK(id,name){
	if($("#dataInfo").find('tr').length<=2){
		adminJS.alert({"title":"提示","info":"当前没有数据导出！"});
		return ;
	}
	var jsonObj = {
			'title':'操作提示',
			"info":'确认导出excel表格吗 ?',
			'id':id,
			'type':name
	};
	adminJS.confirm(jsonObj,function(e,id,type){
		if(e==0){
			return ;
		}
		//确认导出
		exportExcel_getInfo(type+'_getExcelSql.do',type,'tk',id);
	});
}
/**
 * 获取导出Excel的信息
 * @param url 导出Excel信息的地址
 * @param pageName 界面名
 */
function exportExcel_getInfo(url,pageName,type,id){
	if("tk"!=type){
		//1.获取查询条件
		var str ='';
		//获取文本框条件
		$("form fieldset input").each(function(){
			if($(this).attr('id').substring(0,6)=='query_'){
				str+='"'+$(this).attr('id').substring(6)+'":"'+$(this).val()+'",';
			}
		});
		//获取下拉框条件
		$("form fieldset select").each(function(){
			if($(this).attr('id').substring(0,6)=='query_'){
				str+='"'+$(this).attr('id').substring(6)+'":"'+$(this).val()+'",';
			}
		});
		if(''==str){
			str='{"pageName":"'+pageName+'"}';
		}else{
		 str='{'+str+'"pageName":"'+pageName+'"}';
		}
		var jsonObj=strToJson(str);
		var jsonAjax = {
				"url" : url,
				"jsonData" : {"mapStr":jsonToStr(jsonObj)},
				"methodName" : "exportExcel_getName"
			};
			getAjaxData(jsonAjax);
	}else{
		var jsonAjax = {
			"url" : url,
			"jsonData" : {"mapStr":jsonToStr({'id':id})},
			"methodName" : "exportExcel_getName"
		};
		getAjaxData(jsonAjax);
	}
}
/**
 * 导出excel
 */
function exportExcel_getName(jsonObj){
	//2.获取需要显示的信息（头部标题和导出的字段名）
	var titleList = '';
	var counts = '';
	$("table thead tr").find('th').each(function(){
		//fiel存在且excel不存在   则获取该字段名
		if(!isUndefinedAndEmpty($(this).attr('field'))&&isUndefinedAndEmpty($(this).attr('excel'))){
			var title=$(this).text().replace(/(^\s*)|(\s*$)/g, "");
			titleList+='"'+title+'",';
			var count=$(this).attr('field').replace(/(^\s*)|(\s*$)/g, "");
			if(counts==''){
				counts+="a."+count;
			}else{
				counts+=",a."+count;
			}
		}
	});
	titleList='['+titleList.substring(0,titleList.length - 1)+']';
	var jsonObj = {
			"info" : getStr(jsonObj.data),
			"titleList" : getStr(titleList),
			"counts" : getStr(counts),
	};
	
	var jsonAjax = {
			"url" : "excelExport_getExportExcel.do",
			"jsonData" : {"mapStr":jsonToStr(jsonObj)},
			"methodName" : "exportExcel_back"
	};
	getAjaxData(jsonAjax);
}
/**
 * 导出Excel回调
 * 
 * @param jsonObj
 */
function exportExcel_back(jsonObj){
	if(jsonObj.data=='error'){
		adminJS.alert({"title":"提示","info":"导出Excel失败"});
	}else{
		var jsonData = strToJson(jsonObj.data);
		if(jsonData.code=='200'){
			window.location="excelExport_download.do?filePath="+jsonData.data+"";
		}else{
			adminJS.alert({"title":"提示","info":jsonData.info});
		}
	}
}



/**
 * 打开excel导入框
 */
function openImportBoxPage(name,backFuntion){
	var back_function="closeShowDiv";
	if(!isUndefinedAndEmpty(backFuntion)){
		back_function=backFuntion;
	}
	var jsonObj = {"dataBaseName" : name};
	var jsonAjax = {
		"url" : "excelImports_importBoxPage.do",
		"jsonData" : jsonObj,
		"title" : "数据导入",
		"back_function" : back_function,
		"methodName" : "page_back",
	};
	getAjaxData(jsonAjax);
}


/**
 * 下载导入模板
 */
function importGetDataPage(name){
	var jsonObj = {"dataBaseName" : name};
	var jsonAjax = {
			"url" : "excelImports_importGetDataPage.do",
			"jsonData" : jsonObj,
			"methodName" : "exportExcel_back",
	};
	getAjaxData(jsonAjax);
}


/**
 * excel导入
 * dataBaseName 数据表名称
 */
function uploadExcel(elementId,dataBaseName,backUrl) {
	if(!isExcel($('#'+elementId+'_file').val())){
		adminJS.alert({"title":"警告","info":"请上传excel格式的文件，如：.xls为后缀的文件"});
		return ;
	}
	if(isUndefinedAndEmpty(backUrl)){
		backUrl='uploadExcel_back';//默认回调方法
	}
	var jsonObj={
			"dataBaseName" : dataBaseName
		};
	var jsonAjax = {
		'url' : 'excelImports_excelFileImport.do',
		'fileElementId' : elementId+'_file',
		'jsonData' : jsonObj,
		'methodName' : backUrl,
		'elementId' : elementId
	}
	getAjaxUpdateData(jsonAjax);
}


/**
 *Excel格式验证
 */
function isExcel(fileName){
	var patrn = /.(xls)$/;
	if(patrn.test(fileName))
		return true;
	else
		return false;
}

/**
 * 上传excel回调
 * @return
 */
function uploadExcel_back(jsonObj){
	var fal = ajaxReceipt(jsonObj.data);
	if (fal) {
		var jsonData=strToJson(jsonObj.data);
		//code  1  导入完全正常 200   2导入格式错误  210   3导入标题不正确   220   4导入内容为空 230    5导入存在部分错误 240    6未指定数据表 250 
		if(jsonData.code=='200'){
			adminJS.alert({"title":"操作提示","info":"全部导入成功！总"+jsonData.total+"条数据！"},'excelClear');
		}else {
			adminJS.alert({"title":"操作提示","info":jsonData.info});
		}
	}else{
		adminJS.alert({"title":"操作提示","info":"导入失败，请重试！"});
	}
}

/**
 * 清空excel
 */
function excelClear(elementId){
	$('#excels_file').val('');
	$('#lookFiles').val('');
}