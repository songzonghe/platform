/****** 医生排班 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryDoctorScheduling(page){
	loadingDiv();
	var query_doctor_id = $("#query_doctor_id").val();
	var query_scheduling_date = $("#query_scheduling_date").val();
	var json = {
		"doctor_id" : query_doctor_id,
		"scheduling_date" : query_scheduling_date,
 		 "scheduling_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "doctorScheduling_addPage.do",
		"jsonData" : null,
		"title" : "医生排班添加",
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
	var update_doctor_id = $("#update_doctor_id").val();
	var update_scheduling_date = $("#update_scheduling_date").val();
	var update_is_morning ="0";
	if($('#update_is_morning').prop('checked')){update_is_morning ="1"};
	var update_is_afternoon = '0';
	if($('#update_is_afternoon').prop('checked')){update_is_afternoon ="1"};
	var update_is_night = '0';
	if($('#update_is_night').prop('checked')){update_is_night ="1"};
	if(update_is_morning=='0' && update_is_afternoon=='0' && update_is_night=='0'){
		adminJS.alert({'title':'操作提示','info':'请至少选择一个班次！'});
		return 'false';
	}
	var jsonObj = {
		"doctor_id" : update_doctor_id,
		"scheduling_date" : update_scheduling_date,
		"is_morning" : update_is_morning,
		"is_afternoon" : update_is_afternoon,
		"is_night" : update_is_night,
		"scheduling_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonData = getUpdateMainJson("");
	if(jsonData!='false'){
		var jsonAjax = {
			"url" : "doctorScheduling_updateData.do",
			"jsonData" : jsonData,
			"methodName" : "update_add",
			"toID" : "tbodyData"
		};
		getAjaxData(jsonAjax);
	}
}

function openEditPage(id){
	var jsonObj = {"scheduling_id" : id};
	var jsonAjax = {
		"url" : "doctorScheduling_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "医生排班编辑",
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
	var jsonData = getUpdateMainJson(jsonObj.id);
	if(jsonData!='false'){
		var jsonAjax = {
			"url" : "doctorScheduling_updateData.do",
			"jsonData" : jsonData,
			"methodName" : "update_edit",
			"toID" :"tbodyData"
		};
		getAjaxData(jsonAjax);
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
			'url' : 'doctorScheduling_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/
function openlookInfo(date){
	var title='医生排班列表';
	var jsonObj = {
			"find_date":date,
			"pageType":"open"
			};
	var jsonAjax = {
		"url" : "doctorScheduling_findData.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : title,
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

/**
* 获取弹框信息
*/
function searchOpenPage(sortId,page){
	var find_date = $("#find_date").val();
	var json = {
		"find_date":find_date,
		"pageType":'findData',
	};
	var jsonObj = getSortInfo(json, page, sortId);
	var jsons= publicFieldsnJSON(queryJson(jsonObj));
	var jsonAjax = {
		"url" : "doctorScheduling_findData.do",
		"jsonData" : {"mapStr":jsonToStr(jsons)},
		"methodName" : "moblieQuery_back",
		"targetContainer" : "dataInfo",
	};
	// 调用显示函数
	getAjaxData(jsonAjax);
}

function updateInfo(id,type,this_){
	var is_morning='0';var is_afternoon='0';var is_night='0';
	if($(this_).parent('td').find('input[name=find_is_morning]').prop('checked')){is_morning='1';}
	if($(this_).parent('td').find('input[name=find_is_afternoon]').prop('checked')){is_afternoon='1';}
	if($(this_).parent('td').find('input[name=find_is_night]').prop('checked')){is_night='1';}
	if(is_morning=='0' && is_afternoon=='0' && is_night=='0' ){
		$(this_).attr('id','delVal');
		var jsonObj = {
				'title':'操作提示',
				"info":' <span class="red">确认删除</span> ?',
				'id':id
			};
			adminJS.confirm(jsonObj,function(e,id){
				if(e==0){
					if($('#delVal').prop('checked')){
						$('#delVal').prop('checked',false);
					}else{
						$('#delVal').prop('checked',true);
					}
					$('#delVal').attr('id','');
					return ;
				}
				var jsonObj = {
						'id' :id,
						'scheduling_id' :id,
					};
				updateData(jsonObj,'del');
			});
	}else{
		var jsonObj = {
				"id" :id,
				"scheduling_id" :id,
				"is_morning" : is_morning,
				"is_afternoon" : is_afternoon,
				"is_night" : is_night
			};
		updateData(jsonObj,'edit');
	}
}
	
function updateData(jsonObj,type){
	var url="doctorScheduling_updateData.do";
	if(type=='del'){
		url="doctorScheduling_deleteData.do";
	}
	var jsonAjax = {
			"url" : url,
			"jsonData" : {"mapStr":jsonToStr(jsonObj)},
			"methodName" : "updateData_back",
			"dataType" : type,
			"toID" :"tbodyData"
		};
		getAjaxData(jsonAjax);

}

function updateData_back(jsonObj){
	if(jsonObj.data=='error'){
		adminJS.alert({'title':'操作提示','info':'修改失败，请重新打开窗口进行修改！'});
	}else if(jsonObj.dataType=='del'){
		var text=strToInt($('#pageContainer').find('strong').text())-1;
		$('#pageContainer').find('strong').html("&nbsp;"+text+"&nbsp;");
		
		$('#delVal').parents('tr').remove();
		$('#showDiv0').find('.widget-toolbar').find('a').attr('onclick','queryDoctorScheduling(0)');
		adminJS.alert({'title':'操作提示','info':'删除成功！！'});
	}else{
		adminJS.alert({'title':'操作提示','info':'修改成功！！'});
	}
}



