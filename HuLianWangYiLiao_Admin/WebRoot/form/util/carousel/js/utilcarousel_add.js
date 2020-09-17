


function addDataValidate(){
	var jsonObj={
		"methodName":"addData"
	};
	jsonValidate = jsonObj;
}

function getUpdateMainJson(id) {
	var update_carousel_img = $("#update_carousel_img").attr("src");
	var update_carousel_name = $("#update_carousel_name").val();
	var update_carousel_url = $("#update_carousel_url").val();
	var update_carousel_sort = $("#update_carousel_sort").val();
	var update_carousel_details = UE.getEditor('update_carousel_details').getContent();
	var update_carousel_way = $("#update_carousel_way").val();
	var update_carousel_type = $("#update_carousel_type").val();
	if(update_carousel_way==1){
		update_carousel_url="";
		update_carousel_details="";
	}else
	if(update_carousel_way==2){
		update_carousel_url="";
	}else
	if(update_carousel_way==3){
		if(isUndefinedAndEmpty(update_carousel_url)){
			adminJS.alert({'title':'操作提示','info':'请输入自定义地址！'})
			return false;
		}
		update_carousel_details="";
	}
	var jsonObj = {
		"carousel_name" : update_carousel_name,
		"carousel_img" : update_carousel_img,
		"carousel_url" : update_carousel_url,
		"carousel_sort" : update_carousel_sort,
		"carousel_details" : update_carousel_details,
		"carousel_way" : update_carousel_way,
		"carousel_type" : update_carousel_type,
		"carousel_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	if(jsonObj!=false){
		var jsonAjax = {
			"url" : "utilCarousel_updateData.do",
			"jsonData" : jsonObj,
			"methodName" : 'openIndex'
		};
		getAjaxData(jsonAjax);
	}
}
function editDataValidate(id){
	var jsonObj={
		"methodName":"editData",
		"id":id
		};
	jsonValidate = jsonObj;
}

function editData(jsonObj){
	var json=getUpdateMainJson(jsonObj.id)
	if(json!=false){
		var jsonAjax = {
			"url" : "utilCarousel_updateData.do",
			"jsonData" : json,
			"methodName" : 'openIndex'
		};
		getAjaxData(jsonAjax);
	}
}

function backIndex(){
	locationUrl('utilCarousel_index.do');
}


/**
 * 切换轮播类型
 */
function changeDiv(){
	var type=$('#update_carousel_way').val();
	if(type==1){
		$("#urlDiv").hide();
		$(".detailsDiv").hide();
	}else if(type==2){
		$("#urlDiv").hide();
		$(".detailsDiv").show();
	}else if(type==3){
		$("#urlDiv").show();
		$(".detailsDiv").hide();
	}
}

function openIndex(){
	locationUrl('utilCarousel_index.do');
}
