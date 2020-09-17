/****** 检验检查分类表 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
	//加载一级数据
	var data1=$('#tbodyData1').find('tr:eq(0)').attr('data-id');
	if(!isUndefinedAndEmpty(data1)){
		//存在一级数据选择第一条加载二级
		selectData('1',data1);
	}
})
/************************系统生成方法开始******************************/
function queryUtilChecklistClass(page){
	loadingDiv();
	var query_checklist_class_name = $("#query_checklist_class_name").val();
	var query_checklist_up_class_name = $("#query_checklist_up_class_name").val();
	var query_checklist_class_sort = $("#query_checklist_class_sort").val();
	var json = {
		"checklist_class_name" : query_checklist_class_name,
		"checklist_up_class_name" : query_checklist_up_class_name,
		"checklist_class_sort" : query_checklist_class_sort,
 		 "checklist_class_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

/**
 * 根据上级id获取数据 获取二级和三级数据
 */
function selectData(type,id){
	$('.selected'+type).removeClass('selected'+type);
	$('#tr'+type+id).addClass('selected'+type);
	var jsonObj = {
			"checklist_up_class_id":id,
			"findType":type
		};
	var jsonAjax = {
		"url" : "utilChecklistClass_findData.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"findType" : type,
		"methodName" : "selectData_back"
	};
	getAjaxData(jsonAjax);
}
/**
 * 查询回调
 */
function selectData_back(jsonObj){
	if(jsonObj.data=='error'){
		adminJS.alert({'title':'操作提示','info':'获取数据出错!请重试....'});
		return;
	}
	var html=jsonObj.data;
	var id='tbodyData'+(strToInt(jsonObj.findType)+1);
	$('#'+id).html(html);
	if(jsonObj.findType=='1'){
		var data2=$('#tbodyData2').find('tr:eq(0)').attr('data-id');
		if(!isUndefinedAndEmpty(data2)){
			//存在二级数据选择第一条加载三级数据
			selectData('2',data2);
		}else{
			$('#tbodyData3').html('<tr align="center"><td colspan="5">请选择二级分类</td></tr>');
		}
	}
}

/**
 * 打开新增 
 * type 1 一级分类   2二级分类  3三级分类
 */
function openAddPage(type){
	var id="";
	var title="一级分类";
	if(type=='2'){
		id=$('.selected1').attr('data-id');
		if(isUndefinedAndEmpty(id)){
			adminJS.alert({'title':'操作提示','info':'请选择一级分类!'});
			return ;
		}
		title="二级分类";
	}else if(type=='3'){
		id=$('.selected2').attr('data-id');
		if(isUndefinedAndEmpty(id)){
			adminJS.alert({'title':'操作提示','info':'请选择二级分类!'});
			return ;
		}
		title="三级分类";
	}else{
		id="0";//默认
	}
	var jsonObj = {
			"checklist_class_id":id,
			"findType":type
		};
	var jsonAjax = {
		"url" : "utilChecklistClass_addPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "添加"+title,
		"icon" : "plus",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}
/**
 * 新增验证
 */
function addDataValidate(type){
	var jsonObj={
		"methodName":"addData",
		"type":type
	};
	jsonValidate = jsonObj;
}
/**
 * 获取新增或修改的数据
 */
function getUpdateMainJson(id,type){
	var update_checklist_class_name = $("#update_checklist_class_name").val();
	var update_checklist_up_class_id = $("#update_checklist_up_class_id").val();
	var update_checklist_class_sort = $("#update_checklist_class_sort").val();
	var jsonObj = {
		"checklist_class_name" : update_checklist_class_name,
		"checklist_up_class_id" : update_checklist_up_class_id,
		"checklist_class_sort" : update_checklist_class_sort,
		"checklist_class_id" : id,
		"findType" : type,
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}
/**
 * 进行添加操作
 */
function addData(jsonObj){
	var jsonAjax = {
		"url" : "utilChecklistClass_updateData.do",
		"jsonData" : getUpdateMainJson("",jsonObj.type),
		"methodName" : "update_add_back",
		"findType":jsonObj.type
	};
	getAjaxData(jsonAjax);
}
/**
 * 添加回调
 */
function update_add_back(jsonObj){
	if(jsonObj.data=='error'){
		adminJS.alert({'title':'操作提示','info':'添加出错!请重试....'});
		return;
	}
	var html=jsonObj.data;
	var id='tbodyData'+jsonObj.findType;
	if(!isUndefinedAndEmpty(id)){
		if(isUndefinedAndEmpty($("#"+id +" tr").attr("id"))){
			$("#"+id).html(html);
		}else{
			$("#"+id).prepend(html);
		}
		
		var i=1;
		$("#"+id+" tr td[index=tdIndex]").each(function(){
			$(this).html(i);
			i+=1;
		});
	}
	closeShowDiv();
}
/**
 * 打开修改页面
 */
function openEditPage(type,id){
	var title="一级分类";
	if(type=='2'){
		title="二级分类";
	}else if(type=='3'){
		title="三级分类";
	}
	var jsonObj = {"checklist_class_id" : id,'findType':type};
	var jsonAjax = {
		"url" : "utilChecklistClass_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "修改"+title,
		"icon" : "edit",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}
/**
 * 修改数据验证
 */
function editDataValidate(id,type){
	var jsonObj={
		"methodName":"editData",
		"id":id,
		"type":type
		};
	jsonValidate = jsonObj;
}
/**
 * 进行修改数据操作
 */
function editData(jsonObj){
	var jsonAjax = {
		"url" : "utilChecklistClass_updateData.do",
		"jsonData" : getUpdateMainJson(jsonObj.id,jsonObj.type),
		"editId" : jsonObj.id,
		"findType" : jsonObj.type,
		"methodName" : "update_edit_back",
	};
	getAjaxData(jsonAjax);
}
/**
 * 修改回调操作
 */
function update_edit_back(jsonObj){
	if(jsonObj.data=='error'){
		adminJS.alert({'title':'操作提示','info':'修改出错!请重试....'});
		return;
	}
	var html=jsonObj.data;
	var id='tbodyData'+jsonObj.findType;
	var tbodyTr=$('#tr'+jsonObj.findType+jsonObj.editId);
	var bool=false;
	if(jsonObj.findType!=3 && tbodyTr.attr('class').indexOf('selected')!=-1){
		bool=true;
	}
	tbodyTr.after(html);
	tbodyTr.remove();
	if(bool){
		$('#tr'+jsonObj.findType+jsonObj.editId).addClass('selected'+jsonObj.findType);
	}
	var i=1;
	$("#"+id+" tr td[index=tdIndex]").each(function(){
		$(this).html(i);
		i+=1;
	});
	closeShowDiv();
}
/**
 * 进行删除操作
 */
function confirmDeleteDate(type,id){
	var jsonObj = {
		'title':'操作提示',
		"info":' <span class="red">确认删除</span> ?',
		'id':id,
		'type':type
	};
	adminJS.confirm(jsonObj,function(e,id,type){
		if(e==0){
			return ;
		}
		var jsonPar = {
			'id' : getStr(id),
			'type':type
		};
		var jsonAjax = {
			'url' : 'utilChecklistClass_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'delete_back'
		};
		getAjaxData(jsonAjax);
	});
}
/**
 * 删除回调
 */
function delete_back(jsonObj){
	if(jsonObj.data=='error'){
		adminJS.alert({'title':'操作提示','info':'删除出错!请重试....'});
		return;
	}
	var data=strToJson(jsonObj.data);
	if(!isUndefinedAndEmpty(data.info)){
		adminJS.alert({'title':'操作提示','info':data.info});
		return;
	}
	$('#tr'+data.type+data.id).remove();
	var id='tbodyData'+data.type;
	var i=1;
	$("#"+id+" tr td[index=tdIndex]").each(function(){
		$(this).html(i);
		i+=1;
	});
	adminJS.alert({'title':'操作提示','info':'删除成功!'});
}

