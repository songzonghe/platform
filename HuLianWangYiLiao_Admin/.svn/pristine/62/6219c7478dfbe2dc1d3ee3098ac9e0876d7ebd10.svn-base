/***************使用编辑器编辑内容*********************/

$(function() {
	//加载百度ue控件
	var ue = UE.getEditor('editor');
});

/**
 * 返回
 */
function confirmClose(){
	var jsonObj = {
		'title':'操作提示',
		"info":'确认返回 ?',
		'id':0
	};
	adminJS.confirm(jsonObj,function(e,id){
		if(e==0){
			return ;
		}else{
			window.close();//关闭页面
		}
	});
}
/**
 * 打开提交确认框
 */
function confirmSubmitPage() {
	var jsonObj = {
			'title':'操作提示',
			"info":'确认保存吗 ?',
		};
		adminJS.confirm(jsonObj,function(e){
			if(e==0){
				return ;
			}else{
				submitUpdate();
			}
		});
}

/*******************************************************************************
 * 提交更新
 * 
 ******************************************************************************/
function submitUpdate() {
	var jsonObj = {
		"init_id" : $("#init_id").val(),
		"init_key" : UE.getEditor('editor').getContent(),
		"type" : "1",
	};
	
	var jsonAjax = {
		"url" : "utilInitData_updateData.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"methodName" : "submitUpdate_back"
	};
	getAjaxData(jsonAjax);
}

/**
 * 内容编辑完成回调
 * @param jsonObj
 */
function submitUpdate_back(jsonObj){
	if(ajaxReceipt(jsonObj.data)){
		//alert('保存成功');
		window.close();
	}else{
		alert('保存失败');
	}
}
