/************************药品表操作JS******************************/
function load_utilDrugData(class_id,this_){
	if($(this_).attr('isOpen')=='n'){
		var jsonAjax = {
			'url' : 'utilDrug_index.do',
			'jsonData' : {'mapStr':jsonToStr({'class_id':class_id})},
			'methodName' : 'load_utilDrugData_back',
			'id':class_id
		};
		getAjaxData(jsonAjax);
		$(this_).attr('isOpen','y');
	}
}

function load_utilDrugData_back(jsonObj){
	$('#dataTbody_utilDrug'+jsonObj.id).html(jsonObj.data);
}

function add_utilDrugPage(class_id){
	var jsonTemp ={
		'class_id':class_id
	};
	var jsonAjax = {
		'url' : 'utilDrug_addPage.do',
		'jsonData' : {'mapStr':jsonToStr(jsonTemp)},
		'title' : '药品表',
		'icon' : 'plus',
		'methodName' : 'page_back'
	};
	getAjaxData(jsonAjax);
}

function getUpdateJson_utilDrug(id,class_id) {
	var update_drug_name = $("#update_drug_name").val();
	var update_usage_id = $("#update_usage_id").val();
	var update_frequency_id = $("#update_frequency_id").val();
	var update_drug_usname = $("#update_drug_usname").val();
	var update_drug_company = $("#update_drug_company").val();
	var update_drug_img = $("#update_drug_img").attr("src");
	var update_drug_unit = $("#update_drug_unit").val();
	var update_drug_price = $("#update_drug_price").val();
	var update_drug_instructions = $("#update_drug_instructions").val();
	var update_drug_is_rx = $("input[name=update_drug_is_rx]:checked").val();
	var update_drug_type = $("input[name=update_drug_type]:checked").val();
	//新增规格
	var update_drug_weight_unit = $("#update_drug_weight_unit").val();
	var update_drug_volume_unit = $("#update_drug_volume_unit").val();
	var update_drug_smallest_unit = $("#update_drug_smallest_unit").val();
	var update_drug_packaging_unit = $("#update_drug_packaging_unit").val();
	var update_drug_weight_num = $("#update_drug_weight_num").val();
	var update_drug_volume_num = $("#update_drug_volume_num").val();
	var update_drug_packaging_num = $("#update_drug_packaging_num").val();
	//规格
	var update_drug_specifications = update_drug_weight_num+update_drug_weight_unit+update_drug_volume_num+update_drug_volume_unit+"*"+update_drug_packaging_num+update_drug_smallest_unit+"/"+update_drug_packaging_unit;
	var jsonObj = {
		"drug_name" : update_drug_name,
		"usage_id":update_usage_id,
		"frequency_id":update_frequency_id,
		"drug_usname" : update_drug_usname,
		"drug_company" : update_drug_company,
		"drug_specifications" : update_drug_specifications,
		"drug_img" : update_drug_img,
		"drug_unit" : update_drug_unit,
		"drug_price" : update_drug_price,
		"drug_instructions" : update_drug_instructions,
		"drug_is_rx" : update_drug_is_rx,
		"drug_type" : update_drug_type,
		"drug_weight_unit":update_drug_weight_unit,
		"drug_volume_unit":update_drug_volume_unit,
		"drug_smallest_unit":update_drug_smallest_unit,
		"drug_packaging_unit":update_drug_packaging_unit,
		"drug_weight_num":update_drug_weight_num,
		"drug_volume_num":update_drug_volume_num,
		"drug_packaging_num":update_drug_packaging_num,
		"class_id" : class_id,
		"drug_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addDataValidate_utilDrug(class_id) {
	var jsonObj={
		'methodName':'addutilDrug',
		'class_id':class_id
	};
	jsonValidate = jsonObj;
}

function addutilDrug(jsonObj) {
	var jsonAjax = {
		'url' : 'utilDrug_updateData.do',
		'jsonData' : getUpdateJson_utilDrug('',jsonObj.class_id),
		'methodName' : 'update_add',
		'toID' : 'dataTbody_utilDrug'+jsonObj.class_id
	};
	getAjaxData(jsonAjax);
}

function openEditPage_utilDrug(id) {
	var jsonObj = {'drug_id' : id};
	var jsonAjax = {
		'url' : 'utilDrug_editPage.do',
		'jsonData' : {'mapStr':jsonToStr(jsonObj)},
		'title' : '药品表编辑',
		'icon' : 'edit',
		'methodName' : 'page_back'
	};
	getAjaxData(jsonAjax);
}

function editDataValidate_utilDrug(id,class_id) {
	var jsonObj={
		'methodName':'editutilDrug',
		'drug_id':id,
		'class_id':class_id
	};
	jsonValidate = jsonObj;
}

function editutilDrug(jsonObj) {
	var jsonAjax = {
		'url' : 'utilDrug_updateData.do',
		'jsonData' : getUpdateJson_utilDrug(jsonObj.drug_id,''),
		'methodName' : 'update_edit',
		'toID' : 'dataTbody_utilDrug'+jsonObj.class_id
	};
	getAjaxData(jsonAjax);
}

function confirmDeleteDate_utilDrug(id,name,class_id) {
	var jsonObj = {
		'title':'操作提示',
		"info":' <span class="red">确认删除</span> ?',
		'id':id,
		'toID':class_id
	};
	adminJS.confirm(jsonObj,function(e,id,toID){
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
			'toID' : 'dataTbody_utilDrug'+toID
		};
		getAjaxData(jsonAjax);
	});
}



