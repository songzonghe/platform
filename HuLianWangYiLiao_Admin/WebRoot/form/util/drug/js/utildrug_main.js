/****** 药品信息 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})

/************************系统生成方法开始******************************/
function queryUtilDrug(page){
	if(isUndefinedAndEmpty(page)){
		page=0;
	}
	loadingDiv();
	var query_class_name = $("#query_class_name").val();
	var query_drug_number = $("#query_drug_number").val();
	var query_drug_name = $("#query_drug_name").val();
	var query_drug_usname = $("#query_drug_usname").val();
	var query_drug_company = $("#query_drug_company").val();
	var json = {
		"class_name" : query_class_name,
		"drug_number" : query_drug_number,
		"drug_name" : query_drug_name,
		"drug_usname" : query_drug_usname,
		"drug_company" : query_drug_company,
 		"drug_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilDrug_addPage.do",
		"jsonData" : null,
		"title" : "药品信息添加",
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
	var update_class_id = $("#update_class_id").val();
	var update_usage_id = $("#update_usage_id").val();
	var update_frequency_id = $("#update_frequency_id").val();
	var update_drug_number = $("#update_drug_number").val();
	var update_drug_name = $("#update_drug_name").val();
	var update_drug_usname = $("#update_drug_usname").val();
	var update_drug_company = $("#update_drug_company").val();
	var update_drug_img = $("#update_drug_img").attr("src");
	var update_drug_unit = $("#update_drug_unit").val();
	var update_drug_weight_unit = $("#update_drug_weight_unit").val();
	var update_drug_volume_unit = $("#update_drug_volume_unit").val();
	var update_drug_smallest_unit = $("#update_drug_smallest_unit").val();
	var update_drug_packaging_unit = $("#update_drug_packaging_unit").val();
	var update_drug_weight_num = $("#update_drug_weight_num").val();
	var update_drug_volume_num = $("#update_drug_volume_num").val();
	var update_drug_packaging_num = $("#update_drug_packaging_num").val();
	var update_drug_price = $("#update_drug_price").val();
	var update_drug_maxdosage = $("#update_drug_maxdosage").val();
	var update_drug_instructions = $("#update_drug_instructions").val();
	var update_drug_type = $("#update_drug_type").val();
	var update_drug_is_rx = $("input[name=update_drug_is_rx]:checked").val();
	var update_drug_maxdosage2 = $("#update_drug_maxdosage2").val();
	var update_drug_maxdosage3 = $("#update_drug_maxdosage3").val();
	var update_drug_maxfrequency = $("#update_drug_maxfrequency").val();
	var update_drug_maxday = $("#update_drug_maxday").val();
	var update_drug_tagging = $("#update_drug_tagging").val();
	var update_drug_age_limit = $("#update_drug_age_limit").val();
	var update_drug_number=$("#update_drug_number").val();
	var update_yb_limit_cate=$("#update_yb_limit_cate").val();
	var update_yb_limit_range=$("#update_yb_limit_range").val();
	var update_drug_agen=$("#update_drug_agen").val();
	//规格
	if(isUndefinedAndEmpty(update_drug_weight_num)&&isUndefinedAndEmpty(update_drug_weight_unit)){
		var update_drug_specifications = update_drug_volume_num+update_drug_volume_unit+"*"+update_drug_packaging_num+update_drug_smallest_unit+"/"+update_drug_packaging_unit;
	}
	if(isUndefinedAndEmpty(update_drug_volume_num)&&isUndefinedAndEmpty(update_drug_volume_unit)){
		var update_drug_specifications = update_drug_weight_num+update_drug_weight_unit+"*"+update_drug_packaging_num+update_drug_smallest_unit+"/"+update_drug_packaging_unit;
	}
	if(!isUndefinedAndEmpty(update_drug_volume_num)&&!isUndefinedAndEmpty(update_drug_volume_unit)&&!isUndefinedAndEmpty(update_drug_weight_num)&&!isUndefinedAndEmpty(update_drug_weight_unit)){
		var update_drug_specifications = update_drug_weight_num+update_drug_weight_unit+update_drug_volume_num+update_drug_volume_unit+"*"+update_drug_packaging_num+update_drug_smallest_unit+"/"+update_drug_packaging_unit;
	}
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"class_id" : update_class_id,
		"usage_id" : update_usage_id,
		"frequency_id" : update_frequency_id,
		"drug_number" : update_drug_number,
		"drug_name" : update_drug_name,
		"drug_usname" : update_drug_usname,
		"drug_company" : update_drug_company,
		"drug_specifications" : update_drug_specifications,
		"drug_img" : update_drug_img,
		"drug_unit" : update_drug_unit,
		"drug_weight_unit" : update_drug_weight_unit,
		"drug_volume_unit" : update_drug_volume_unit,
		"drug_smallest_unit" : update_drug_smallest_unit,
		"drug_packaging_unit" : update_drug_packaging_unit,
		"drug_weight_num" : update_drug_weight_num,
		"drug_volume_num" : update_drug_volume_num,
		"drug_packaging_num" : update_drug_packaging_num,
		"drug_price" : update_drug_price,
		"drug_maxdosage" : update_drug_maxdosage,
		"drug_instructions" : update_drug_instructions,
		"drug_type" : update_drug_type,
		"drug_is_rx" : update_drug_is_rx,
		"drug_maxdosage2" : update_drug_maxdosage2,
		"drug_maxdosage3" : update_drug_maxdosage3,
		"drug_maxfrequency" : update_drug_maxfrequency,
		"drug_maxday" : update_drug_maxday,
		"drug_tagging" : update_drug_tagging,
		"drug_age_limit" : update_drug_age_limit,
		"drug_id" : id,
		"yb_limit_cate":update_yb_limit_cate,
		"yb_limit_range":update_yb_limit_range,
		"drug_agen":update_drug_agen
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilDrug_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"drug_id" : id};
	var jsonAjax = {
		"url" : "utilDrug_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "药品信息编辑",
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
		"url" : "utilDrug_updateData.do",
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
			'url' : 'utilDrug_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/


/**
 * 根据根据一级分类查二级
 */
function find_uplist(){
	var usage_type=$("#update_usage_type").find("option:selected").val();
	var jsonObj = {"usage_type" : usage_type};
	var jsonAjax = {
		"url" : "utilDrug_up_list.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"methodName" : "find_uplist_back"
	};
	getAjaxData(jsonAjax);
}
/**
 * 返回 数据
 * @param jsonObj
 * @return
 */

function find_uplist_back(jsonObj){
	var jsonDatas = strToJson(jsonObj.data);
	var list=strToJson(jsonDatas.list);
	var update_usage_id ='';
	var flag = true;
	update_usage_id += '<option value="">请选择</option>';
	$.each(list,function(e,obj){
		update_usage_id += '<option value="'+obj.usage_id+'" >'+obj.usage_name+'</option>';
	});
	$("#update_usage_id").html(update_usage_id);
	$("#update_usage_id").searchableSelect();
}


function find_usage_type(){
	var drug_type=$("#update_drug_type").find("option:selected").val();
	var update_usage_type ='';
	update_usage_type += '<option value="">请选择</option>';
	if(parseInt(drug_type)!=1){
		update_usage_type += '<option value="1">西药用法</option>';
	}else{
		update_usage_type += '<option value="2">中药特殊服用用法</option>';
		update_usage_type += '<option value="3">中药服用方法</option>';
		update_usage_type += '<option value="4">中药服用要求</option>';
	}
	$("#update_usage_type").html(update_usage_type);
	$("#update_usage_type").searchableSelect();
}


function getAgen(){
	debugger;
	var input_select = $("#update_drug_agen").val();//获取填写框内容
    var after_value = input_select.substring(0,2);//处理填写框内容
    
	var option_length = $("#dataListForSelect").find("option").length;
    var data_value = '';
    for(var i = 0; i < option_length; i++){//找到点选的option
        var option_id = $("#dataListForSelect").find("option").eq(i).attr('data-id');
        if(after_value == option_id){
        	data_value = $("#dataListForSelect").find("option").eq(i).attr('data-value');
            break;
        }
    }
    $("#update_drug_agen").val(data_value);//回写到填写框
}



								
