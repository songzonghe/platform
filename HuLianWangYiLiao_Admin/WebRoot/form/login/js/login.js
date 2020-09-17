/** *****登录中心控制JS 李飞 2016年4月3日 15:43:56 ******* */

$(function() {
	//加载验证
	initValidate();
	focusOrBlur();
	if(!isUndefinedAndEmpty($('#hosid').val())){
		setCookie ( "hlwyl_hosid", $('#hosid').val(), 15) ;
	}else{
		$('#hosid').val(getCookie("hlwyl_hosid"));
	}
	if(!isUndefinedAndEmpty($('#hosid').val()) && $('#ishosid').val()=='0'){
		$('#infoDiv').html('');
	}
});

function setCookie(name,value,day){
  var date = new Date();
  date.setDate(date.getDate() + day);
  document.cookie = name + '=' + value + ';expires='+ date;
};
/**
 * 密码框得到或失去焦点
 */
function focusOrBlur(){
	// 得到焦点
	$("#login_pwd").focus(function() {
		$("#left_hand").animate( {
			left : "150",
			top : " -38"
		}, {
			step : function() {
				if (parseInt($("#left_hand").css("left")) > 140) {
					$("#left_hand").attr("class", "left_hand");
				}
			}
		}, 2000);
		$("#right_hand").animate( {
			right : "-64",
			top : "-38px"
		}, {
			step : function() {
				if (parseInt($("#right_hand").css("right")) > -70) {
					$("#right_hand").attr("class", "right_hand");
				}
			}
		}, 2000);
	});
	// 失去焦点
	$("#login_pwd").blur(function() {
		$("#left_hand").attr("class", "initial_left_hand");
		$("#left_hand").attr("style", "left:100px;top:-12px;");
		$("#right_hand").attr("class", "initial_right_hand");
		$("#right_hand").attr("style", "right:-112px;top:-12px");
	});
}

/**
 * 登录验证
 */
function loginValidate(){
	var jsonObj={
		"methodName":"login"
	};
	jsonValidate = jsonObj;
}
/**
 * 登录
 * @param jsonObj
 */
function login(jsonObj){
	$("#infoDiv").html("登陆中...");
	var hosid=$("#hosid").val();
	if(isUndefinedAndEmpty(hosid)){
		hosid=getCookie("hlwyl_hosid");
	}
	if(isUndefinedAndEmpty(hosid)){
		adminJS.alert({'title':'操作提示','info':'请求地址发生错误，请联系平台！'});
	}else{
		//刷新时间
		setCookie ( "hlwyl_hosid", hosid, 15) ;
		var jsonObj = {
			"login_name":$("#login_name").val(),
			"login_pwd":$("#login_pwd").val(),
			"hosid":hosid,
		};
		$("#mapStr").val(jsonToStr(jsonObj));
		$("#myLoginForm").submit();
	}
}

//获取cookie
function getCookie(name){
  var reg = RegExp(name+'=([^;]+)');
  var arr = document.cookie.match(reg);
  if(arr){
    return arr[1];
  }else{
    return '';
  }
};