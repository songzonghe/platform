/****** 医生基本资料 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryDoctorInfo(page){
	loadingDiv();
	var query_hospital_id = $("#query_hospital_id").val();
	var query_doctor_phone = $("#query_doctor_phone").val();
	var query_doctor_name = $("#query_doctor_name").val();
	var query_department_name = $("#query_department_name").val();
	var json = {
		"hospital_id" : query_hospital_id,
		"doctor_phone" : query_doctor_phone,
		"doctor_name" : query_doctor_name,
		"department_name" : query_department_name,
 		 "doctor_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "doctorInfo_addPage.do",
		"jsonData" : {"mapStr":jsonToStr({'getStr':'001,002,009'})},
		"title" : "医生基本资料添加",
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
	var update_doctor_phone = $("#update_doctor_phone").val();
	var update_doctor_paw = $("#update_doctor_paw").val();
	var update_doctor_openid = $("#update_doctor_openid").val();
	var update_doctor_name = $("#update_doctor_name").val();
	var update_doctor_img = $("#update_doctor_img").attr("src");
	var update_doctor_autograph = $("#update_doctor_autograph").attr("src");
	var update_doctor_sex = $("input[name=update_doctor_sex]:checked").val();
	
	//var update_doctot_job_title = $("#update_doctot_job_title").val();modify by 黎文海
	var update_doctot_job_title=$("#update_doctot_job_title").find("option:selected").attr("data-name");//存名字
	
	var update_doctor_work_address = $("#update_doctor_work_address").val();
	var update_department_id = $("#update_department_id").val();
	var update_doctot_work_day = $("#update_doctot_work_day").val();
	var update_doctot_birthday = $("#update_doctot_birthday").val();
	var update_doctor_document_number = $("#update_doctor_document_number").val();
	var update_doctor_document_img1 = $("#update_doctor_document_img1").attr("src");
	var update_doctor_document_img2 = $("#update_doctor_document_img2").attr("src");
	var update_doctor_medical_practitioner_certificate = $("#update_doctor_medical_practitioner_certificate").attr("src");
	var update_doctor_medical_licence = $("#update_doctor_medical_licence").attr("src");
	var update_doctor_technical_certificate = $("#update_doctor_technical_certificate").attr("src");
	var update_doctor_begoodat = $("#update_doctor_begoodat").val();
	var update_doctor_synopsis = $("#update_doctor_synopsis").val();
	var update_doctor_sort = $("#update_doctor_sort").val();
	var update_is_online = $("input[name=update_is_online]:checked").val();
	var update_doctor_im = $("#update_doctor_im").val();
	var update_doctor_zyjszwdm = $("#update_doctor_zyjszwdm").val();
	var update_doctor_zyjszwlbdm = $("#update_doctor_zyjszwlbdm").val();
	var update_doctor_zzlbmc = $("#update_doctor_zzlbmc").val();
	var update_doctor_zgzsbh = $("#update_doctor_zgzsbh").val();
	var update_doctor_zghdsj = $("#update_doctor_zghdsj").val();
	var update_doctor_zyzsbm = $("#update_doctor_zyzsbm").val();
	var update_doctor_fzrq = $("#update_doctor_fzrq").val();
	var update_doctor_zyfw = $("#update_doctor_zyfw").val();
	var update_doctor_qkysbz = $("#update_doctor_qkysbz").val();
	var update_doctor_mz = $("#update_doctor_mz").val();
	var update_doctor_xl = $("#update_doctor_xl").val();
	var update_doctor_grzpcfdz = $("#update_doctor_grzpcfdz").val();
	var update_doctor_cxbz = $("#update_doctor_cxbz").val();
	var update_doctor_zcsj = $("#update_doctor_zcsj").val();
	var update_doctor_zyfw_name= $("#update_doctor_zyfw").find("option:selected").attr("data-name");
	var jsonObj = {
		"hospital_id" : update_hospital_id,
		"doctor_phone" : update_doctor_phone,
		"doctor_paw" : update_doctor_paw,
		"doctor_openid" : update_doctor_openid,
		"doctor_name" : update_doctor_name,
		"doctor_img" : update_doctor_img,
		"doctor_autograph":update_doctor_autograph,
		"doctor_sex" : update_doctor_sex,
		"doctot_job_title" : update_doctot_job_title,
		"doctor_work_address" : update_doctor_work_address,
		"department_id" : update_department_id,
		"doctot_work_day" : update_doctot_work_day,
		"doctot_birthday" : update_doctot_birthday,
		"doctor_document_number" : update_doctor_document_number,
		"doctor_document_img1" : update_doctor_document_img1,
		"doctor_document_img2" : update_doctor_document_img2,
		"doctor_medical_practitioner_certificate" : update_doctor_medical_practitioner_certificate,
		"doctor_medical_licence" : update_doctor_medical_licence,
		"doctor_technical_certificate" : update_doctor_technical_certificate,
		"doctor_begoodat" : update_doctor_begoodat,
		"doctor_synopsis" : update_doctor_synopsis,
		"doctor_sort" : update_doctor_sort,
		"is_online" : update_is_online,
		"doctor_im" : update_doctor_im,
		"doctor_zyjszwdm" : update_doctor_zyjszwdm,
		"doctor_zyjszwlbdm" : update_doctor_zyjszwlbdm,
		"doctor_zzlbmc" : update_doctor_zzlbmc,
		"doctor_zgzsbh" : update_doctor_zgzsbh,
		"doctor_zghdsj" : update_doctor_zghdsj,
		"doctor_zyzsbm" : update_doctor_zyzsbm,
		"doctor_fzrq" : update_doctor_fzrq,
		"doctor_zyfw" : update_doctor_zyfw,
		"doctor_qkysbz" : update_doctor_qkysbz,
		"doctor_mz" : update_doctor_mz,
		"doctor_xl" : update_doctor_xl,
		"doctor_grzpcfdz" : update_doctor_grzpcfdz,
		"doctor_cxbz" : update_doctor_cxbz,
		"doctor_zcsj" : update_doctor_zcsj,
		"doctor_zyfw_name":update_doctor_zyfw_name,
		"doctor_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "doctorInfo_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id,type){
	var title="医生基本资料编辑";
	if(type==2){
		title="重置密码";
	}
	var jsonObj = {"doctor_id" : id,"type":type,'getStr':'001,002,009'};
	var jsonAjax = {
		"url" : "doctorInfo_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : title,
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
		"url" : "doctorInfo_updateData.do",
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
			'url' : 'doctorInfo_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/