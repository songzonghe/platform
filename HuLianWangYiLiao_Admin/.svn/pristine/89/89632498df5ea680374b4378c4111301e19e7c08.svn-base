$(function() {
	// 父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	// 本窗口关闭加载层
	closeLoadingDiv();
	// 进行页面处理 如：排序 或其他之内
	initPage();
})
function openlookInfo(id, name, type) {
	var title = '其他消息(' + name + ')';

	var jsonObj = {
		"log_id" : id,
		"data_type" : type,
		"openType" : "openinquiryLog"
	};
	var jsonAjax = {
		"url" : "inquiryLog_getInquiryLogDetailsPage.do",
		"jsonData" : {
			"mapStr" : jsonToStr(jsonObj)
		},
		"title" : title,
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}
/**
 * 获取信息 
 */
function findInquiryInfo(page) {
	loadingDiv();
	var find_log_id = $("#find_log_id").val();
	var find_user_nickname = $("#find_user_nickname").val();
	var find_data_type = $("#find_data_type").val();
	var find_log_type = $("#find_log_type").val();
	var query_inquiry_patient_name = $("#query_inquiry_patient_name").val();
	var query_drug_name = $("#query_drug_name").val();
	var query_checklist_code = $("#query_checklist_code").val();
	var query_img_id = $("#query_img_id").val();
	var json = {
		"log_id" : find_log_id,
		"user_nickname" : find_user_nickname,
		"data_type" : find_data_type,
		"log_type" : find_log_type,
		"inquiry_patient_name" : query_inquiry_patient_name,
		"drug_name" : query_drug_name,
		"checklist_code" : query_checklist_code,
		"img_id" : query_img_id
	}
	var jsonObj = getPageParameter(json, page, "y", "selectPageMain");
	$("#findMapStr").val(jsonToStr(json));
	$("#findForm").submit();
}

/**
 * 切换数据类型
 */
function changeDataType(type) {
	loadingDiv();
	var find_log_id = $("#find_log_id").val();
	var find_data_type = type;
	var json = {
		"log_id" : find_log_id,
		"data_type" : find_data_type
	}
	var jsonObj = getPageParameter(json, '0', "y", "selectPageMain");
	$("#findMapStr").val(jsonToStr(jsonObj));
	$("#findForm").submit();
}