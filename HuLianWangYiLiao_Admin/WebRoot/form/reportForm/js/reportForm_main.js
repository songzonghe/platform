/****** 门店基本资料 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryRegisterUser(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_user_phone = $("#query_user_phone").val();
	var query_beginTime = $("#query_beginTime").val();
	var query_endTime = $("#query_endTime").val();
	
	
	var json = {
		
		"user_phone":query_user_phone,
		"hospital_id" : query_hospital_id,
		"beginTime" : query_beginTime,
		"endTime" : query_endTime
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function queryInquiryUser(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_beginTime = $("#query_beginTime").val();
	var query_endTime = $("#query_endTime").val();
	var query_log_type = $("#query_log_type").val();
	var query_join_type = $("#query_join_type").val();
	
	var json = {
		
		"log_type":query_log_type,
		"join_type":query_join_type,
		"hospital_id" : query_hospital_id,
		"beginTime" : query_beginTime,
		"endTime" : query_endTime
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function queryPrescriptionUser(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_beginTime = $("#query_beginTime").val();
	var query_endTime = $("#query_endTime").val();
	
	var query_log_type = $("#query_log_type").val();
	var query_join_type = $("#query_join_type").val();
	var query_type = $("#query_type").val();
	var query_doctor_name = $("#query_doctor_name").val();
	var query_find_zt = $("#query_find_zt").val();
	
	
	var json = {
		"doctor_name":query_doctor_name,
		"type":query_type,
		"log_type":query_log_type,
		"join_type":query_join_type,
		"hospital_id" : query_hospital_id,
		"beginTime" : query_beginTime,
		"endTime" : query_endTime,
		"find_zt" : query_find_zt
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function queryHealthGuidance(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_beginTime = $("#query_beginTime").val();
	var query_endTime = $("#query_endTime").val();
	
	var query_log_type = $("#query_log_type").val();
	var query_join_type = $("#query_join_type").val();
	var query_type = $("#query_type").val();
	var query_doctor_name = $("#query_doctor_name").val();
	var json = {
		"doctor_name":query_doctor_name,
		"type":query_type,
		"log_type":query_log_type,
		"join_type":query_join_type,
		"hospital_id" : query_hospital_id,
		"beginTime" : query_beginTime,
		"endTime" : query_endTime
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function queryChecklist(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_beginTime = $("#query_beginTime").val();
	var query_endTime = $("#query_endTime").val();
	
	var query_log_type = $("#query_log_type").val();
	var query_join_type = $("#query_join_type").val();
	var query_type = $("#query_type").val();
	var query_doctor_name = $("#query_doctor_name").val();
	var json = {
		"doctor_name":query_doctor_name,
		"type":query_type,
		"log_type":query_log_type,
		"join_type":query_join_type,
		"hospital_id" : query_hospital_id,
		"beginTime" : query_beginTime,
		"endTime" : query_endTime
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function queryHospitalization(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_beginTime = $("#query_beginTime").val();
	var query_endTime = $("#query_endTime").val();
	
	var query_log_type = $("#query_log_type").val();
	var query_join_type = $("#query_join_type").val();
	var query_type = $("#query_type").val();
	var query_doctor_name = $("#query_doctor_name").val();
	var json = {
		"doctor_name":query_doctor_name,
		"type":query_type,
		"log_type":query_log_type,
		"join_type":query_join_type,
		"hospital_id" : query_hospital_id,
		"beginTime" : query_beginTime,
		"endTime" : query_endTime
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function queryAuditPrescription(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_beginTime = $("#query_beginTime").val();
	var query_endTime = $("#query_endTime").val();
	var query_log_type = $("#query_log_type").val();
	var query_join_type = $("#query_join_type").val();
	var query_doctor_name = $("#query_doctor_name").val();
	var query_pharmacist_name = $("#query_pharmacist_name").val();
	var query_find_zt = $("#query_find_zt").val();
	
	
	var json = {
		"pharmacist_name":query_pharmacist_name,
		"doctor_name":query_doctor_name,
		"log_type":query_log_type,
		"join_type":query_join_type,
		"hospital_id" : query_hospital_id,
		"beginTime" : query_beginTime,
		"endTime" : query_endTime,
		"find_zt" : query_find_zt,
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function queryDeanReport(){
	loadingDiv();
	var query_queryDate = $("#query_queryDate").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"queryDate" : query_queryDate,
	 }	
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}


/************************系统生成方法完毕******************************/