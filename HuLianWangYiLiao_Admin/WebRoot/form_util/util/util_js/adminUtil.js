/****************************公共操作JS 李飞 2017年2月9日 15:42:41**********************************/
var adminJS = {
	/**
	 * 确认弹出框  ---操作实例  返回0表示点击取消  返回1表示点击提交
	   var jsonObj = {
		   "title":"删除角色", //显示title 名称
		   "icon" : "fa-comment", //显示title(非必填) icon --默认为fa-comment
		   "color":"blue",//显示title icon颜色(非必填)  --默认为 blue
		   "info":'确认提交 <span class="red">角色</span> ?' //提示内容
	   };
	 * 
	 */
	confirm: function(jsonObj,e) {
		var comfirmHtml = '<div class="widget-main no-padding" style="min-width:300px">';
		comfirmHtml += '<form class="form-horizontal">';
		comfirmHtml += '<p class="bigger-110 bolder center grey" style="height: 66px;padding-top: 30px">';
		comfirmHtml += '<i class="ace-icon fa fa-hand-o-right blue bigger-120"></i>&nbsp;&nbsp;';
		comfirmHtml += jsonObj.info;
		comfirmHtml += '</p>';
		comfirmHtml += '<div class="form-actions center">';
		if(isUndefinedAndEmpty(jsonObj.type)){
			comfirmHtml += '<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv();doCallback(eval('+e+'),[0,\''+jsonObj.id+'\'])">';
			comfirmHtml += '<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>&nbsp;';
			comfirmHtml += '取消&nbsp;';
			comfirmHtml += '</button>&nbsp;&nbsp;';
			comfirmHtml += '<button type="button" class="btn btn-sm btn-success" onclick="closeShowDiv();doCallback(eval('+e+'),[1,\''+jsonObj.id+'\']);">';
			comfirmHtml += '&nbsp;确认';
			comfirmHtml += '&nbsp;<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>';
			comfirmHtml += '</button>';
		}else{
			comfirmHtml += '<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv();doCallback(eval('+e+'),[0,\''+jsonObj.id+'\',\''+jsonObj.type+'\'])">';
			comfirmHtml += '<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>&nbsp;';
			comfirmHtml += '取消&nbsp;';
			comfirmHtml += '</button>&nbsp;&nbsp;';
			comfirmHtml += '<button type="button" class="btn btn-sm btn-success" onclick="closeShowDiv();doCallback(eval('+e+'),[1,\''+jsonObj.id+'\',\''+jsonObj.type+'\']);">';
			comfirmHtml += '&nbsp;确认';
			comfirmHtml += '&nbsp;<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>';
			comfirmHtml += '</button>';
		}
		
		
		
		comfirmHtml += '</div>';
		comfirmHtml += '</form>';
		comfirmHtml += '</div>';
		jsonObj = editJson(jsonObj, "data", comfirmHtml);
		page_back(jsonObj);
    },
    /**
	 * 弹出框  ---操作实例
	   var jsonObj = {
		   "title":"删除角色", //显示title 名称
		   "icon" : "fa-comment", //显示title(非必填) icon --默认为fa-comment
		   "color":"blue",//显示title icon颜色(非必填)  --默认为 blue
		   "info":'确认提交 <span class="red">角色</span> ?' //提示内容
	   };
	 * 
	 */
    alert: function(jsonObj,e) {
    	var alertHtml = '<div class="widget-main no-padding" style="min-width: 300px">';
		alertHtml += '<form class="form-horizontal">';
		alertHtml += '<p class="bigger-110 bolder center grey" style="height: 66px;padding-top: 30px">';
		alertHtml += '<i class="ace-icon fa fa-hand-o-right blue bigger-120"></i>&nbsp;&nbsp;';
		alertHtml += jsonObj.info;
		alertHtml += '</p>';
		alertHtml += '<div class="form-actions center">';
		if(isUndefinedAndEmpty(e)){
			alertHtml += '<button type="button" class="btn btn-sm btn-success" style="width: 80px" onclick="closeShowDiv();">';
			alertHtml += '&nbsp;确认';
			alertHtml += '&nbsp;<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>';
			alertHtml += '</button>';
		}else{
			alertHtml += '<button type="button" class="btn btn-sm btn-success" style="width: 80px" onclick="doCallback(eval('+e+'),[1]);closeShowDiv();">';
			alertHtml += '&nbsp;确认';
			alertHtml += '&nbsp;<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>';
			alertHtml += '</button>';
		}
		alertHtml += '</div>';
		alertHtml += '</form>';
		alertHtml += '</div>';
		jsonObj = editJson(jsonObj, "data", alertHtml);
		page_back(jsonObj);
    }
};
