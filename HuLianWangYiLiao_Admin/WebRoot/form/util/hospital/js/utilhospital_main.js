/****** 系统医院 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilHospital(page){
	loadingDiv();
	var query_hospital_logo = $("#query_hospital_logo").val();
	var query_hospital_number = $("#query_hospital_number").val();
	var query_hospital_name = $("#query_hospital_name").val();
	var json = {
		"hospital_logo" : query_hospital_logo,
		"hospital_number" : query_hospital_number,
		"hospital_name" : query_hospital_name,
 		 "hospital_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	var jsonAjax = {
		"url" : "utilHospital_addPage.do",
		"jsonData" : {"mapStr":jsonToStr({'getStr':'005,007,008,013'})},
		"title" : "系统医院添加",
		"icon" : "plus",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

function addDataValidate(){
	if(strToInt($("input[name=update_hospital_xxaqdjbh]:checked").val())<=4){
		$("#update_hospital_xxaqdjbhbh").attr('data-validate','required:请输入信息安全等级保护证书编号！');
	}else{
		$("#update_hospital_xxaqdjbhbh").attr('data-validate','backTrue:');
	}
	var jsonObj={
		"methodName":"addData"
	};
	jsonValidate = jsonObj;
}

function getUpdateMainJson(id) {
	var update_hospital_cxbz = $("#update_hospital_cxbz").val();
	var update_hospital_pwd = $("#update_hospital_pwd").val();
	if(!isUndefinedAndEmpty(id) && !$('#is_edit').prop('checked')){
		update_hospital_pwd="";
	}
	var update_hospital_logo = $("#update_hospital_logo").attr("src");
	var update_hospital_number = $("#update_hospital_number").val();
	var update_hospital_name = $("#update_hospital_name").val();
	var update_hospital_jgms = $("#update_hospital_jgms").val();
	var update_hospital_jgdm = $("#update_hospital_jgdm").val();
	var update_hospital_zzjgdm = $("#update_hospital_zzjgdm").val();
	var update_hospital_xzqhdm = $("#update_hospital_xzqhdm").val();
	var update_hospital_jglx =  $("input[name=update_hospital_jglx]:checked").val();
	var update_hospital_jgclrq = $("#update_hospital_jgclrq").val();
	var update_hospital_dwlsgxdm = $("#update_hospital_dwlsgxdm").val();
	var update_hospital_jgflgllbdm = $("input[name=update_hospital_jgflgllbdm]:checked").val();
	var update_hospital_jgfldm = $("#update_hospital_jgfldm").val();
	var update_hospital_jjlxdm = $("#update_hospital_jjlxdm").val();
	var update_hospital_dz = $("#update_hospital_dz").val();
	var update_hospital_styyzzjgdm = $("#update_hospital_styyzzjgdm").val();
	var update_hospital_styymc = $("#update_hospital_styymc").val();
	var update_hospital_styljgjb = $("input[name=update_hospital_styljgjb]:checked").val();
	var update_hospital_styljgdj = $("input[name=update_hospital_styljgdj]:checked").val();
	var update_hospital_hlwyywz = $("#update_hospital_hlwyywz").val();
	var update_hospital_xkzhm = $("#update_hospital_xkzhm").val();
	var update_hospital_xkxmmc = $("#update_hospital_xkxmmc").val();
	var update_hospital_xkzyxq = $("#update_hospital_xkzyxq").val();
	var update_hospital_xxaqdjbh = $("input[name=update_hospital_xxaqdjbh]:checked").val();
	var update_hospital_xxaqdjbhbh = $("#update_hospital_xxaqdjbhbh").val();
	
	var update_hospital_kbzjjes = $("#update_hospital_kbzjjes").val();
	var update_hospital_frdb = $("#update_hospital_frdb").val();
	var update_hospital_jgszdmzzzdfbz = $("input[name=update_hospital_jgszdmzzzdfbz]:checked").val();
	var update_hospital_sffzjg = $("input[name=update_hospital_sffzjg]:checked").val();
	var update_hospital_jgdemc = $("#update_hospital_jgdemc").val();
	var update_hospital_dhhm = $("#update_hospital_dhhm").val();
	var update_hospital_dwdzyx = $("#update_hospital_dwdzyx").val();
	var update_hospital_yzbm = $("#update_hospital_yzbm").val();
	var jsonObj = {
		"hospital_cxbz" : update_hospital_cxbz,
		"hospital_logo" : update_hospital_logo,
		"hospital_number" : update_hospital_number,
		"hospital_pwd" : update_hospital_pwd,
		"hospital_name" : update_hospital_name,
		"hospital_jgms" : update_hospital_jgms,
		"hospital_jgdm" : update_hospital_jgdm,
		"hospital_zzjgdm" : update_hospital_zzjgdm,
		"hospital_xzqhdm" : update_hospital_xzqhdm,
		"hospital_jglx" : update_hospital_jglx,
		"hospital_jgclrq" : update_hospital_jgclrq,
		"hospital_dwlsgxdm" : update_hospital_dwlsgxdm,
		"hospital_jgflgllbdm" : update_hospital_jgflgllbdm,
		"hospital_jgfldm" : update_hospital_jgfldm,
		"hospital_jjlxdm" : update_hospital_jjlxdm,
		"hospital_dz" : update_hospital_dz,
		"hospital_styyzzjgdm" : update_hospital_styyzzjgdm,
		"hospital_styymc" : update_hospital_styymc,
		"hospital_styljgjb" : update_hospital_styljgjb,
		"hospital_styljgdj" : update_hospital_styljgdj,
		"hospital_hlwyywz" : update_hospital_hlwyywz,
		"hospital_xkzhm" : update_hospital_xkzhm,
		"hospital_xkxmmc" : update_hospital_xkxmmc,
		"hospital_xkzyxq" : update_hospital_xkzyxq,
		"hospital_xxaqdjbh" : update_hospital_xxaqdjbh,
		"hospital_xxaqdjbhbh" : update_hospital_xxaqdjbhbh,
		"hospital_kbzjjes" : update_hospital_kbzjjes,
		"hospital_frdb" : update_hospital_frdb,
		"hospital_jgszdmzzzdfbz" : update_hospital_jgszdmzzzdfbz,
		"hospital_sffzjg" : update_hospital_sffzjg,
		"hospital_jgdemc" : update_hospital_jgdemc,
		"hospital_dhhm" : update_hospital_dhhm,
		"hospital_dwdzyx" : update_hospital_dwdzyx,
		"hospital_yzbm" : update_hospital_yzbm,
		"hospital_id" : id
	};
	var jsonTemp = publicFieldsnJSON(jsonObj);
	return {"mapStr":jsonToStr(jsonTemp)};
}

function addData(jsonObj){
	var jsonObj = getUpdateMainJson("");
	var jsonAjax = {
		"url" : "utilHospital_updateData.do",
		"jsonData" : jsonObj,
		"methodName" : "update_add",
		"toID" : "tbodyData"
	};
	getAjaxData(jsonAjax);
}

function openEditPage(id){
	var jsonObj = {"hospital_id" : id,'getStr':'005,007,008,013'};
	var jsonAjax = {
		"url" : "utilHospital_editPage.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"title" : "系统医院编辑",
		"icon" : "edit",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

function editDataValidate(id){
	if(strToInt($("input[name=update_hospital_xxaqdjbh]:checked").val())<=4){
		$("#update_hospital_xxaqdjbhbh").attr('data-validate','required:请输入信息安全等级保护证书编号！');
	}else{
		$("#update_hospital_xxaqdjbhbh").attr('data-validate','backTrue:');
	}
	var jsonObj={
		"methodName":"editData",
		"id":id
		};
	jsonValidate = jsonObj;
}

function editData(jsonObj){
	var jsonAjax = {
		"url" : "utilHospital_updateData.do",
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
			'url' : 'utilHospital_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}
/************************系统生成方法完毕******************************/