/**********主页面JS操作 李飞  2016年4月12日 22:24:42*************/
var topPx = 150;
var leftPx = 200;
$(function () {
	zhover($(".video"));
    zhover($(".zPhone"));
    zhover($(".zCode"));
    zhover($(".header .right"));
    zhover($(".ddd"));
    zhover($(".navbar-buttons .light-blue"));
    $(".tab-pane").find("iframe").css("height",($(window).height()-151)+"px");
	$(window).resize(function() {
		$(".tab-pane").find("iframe").css("height",($(window).height()-151)+"px");
		$(".tab-pane").find("iframe").css("width",'100%');
		$("#indexPage").css("height",getBodyHeight()-topPx);
	});
});
/**
 * 头部菜单滚动
 */
$(".nav-left-btn").click(function(){
	var oldLeft =$('.nav-tabs').position().left;
	if(oldLeft < 0){
		var newLeft =oldLeft+100;
		$('.nav-right-btn').removeClass('nav-unBtn');
		if(newLeft > 0){
			newLeft = 0;
			$('.nav-left-btn').addClass('nav-unBtn');
		}
		$('.nav-tabs').css('left',newLeft+'px');
	}
})
$(".nav-right-btn").click(function(){
	var oldLeft =$('.nav-tabs').position().left;
	var newWidth = $('.nav-tabs')[0].childElementCount*100;
	if($('.nav-tabs').width() < newWidth && oldLeft*(-1) < (newWidth-$('.nav-tabs').width())){
		$('.nav-left-btn').removeClass('nav-unBtn');
		var newLeft =oldLeft-100;
		$('.nav-tabs').css('left',newLeft+'px');
		if(newLeft*(-1) > (newWidth-$('.nav-tabs').width())){
			$('.nav-right-btn').addClass('nav-unBtn');
		}
	}
})
/*头部下拉菜单*/
function zhover(that){
    that.hover(
        function(){
            that.children("ul").show();
        },
        function(){
            that.children("ul").hide();
        }
    )
}

/*******************修改密码*************************/
/**
 * 打开修改密码页面
 */
function openUpdatePasswordPage(){
	var jsonAjax = {
		"url" : "systemAccount_editUserPwdPage.do",
		"jsonData" : null,
		"title" : "修改密码",
		"icon" : "plus",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}

/**
 * 修改密码验证
 * @param zh_id
 */
function updatePasswordValidate(account_id){
	var jsonObj={
		"methodName":"updatePassword",
		"account_id":account_id
	};
	jsonValidate = jsonObj;
}
/**
 * 修改密码
 * @param account_id
 */
function updatePassword(jsonObj){
	var update_account_pwd = $("#update_account_pwd").val();
	var jsonObj = {
		"account_id":jsonObj.account_id,
		"account_pwd":update_account_pwd
	};
	var jsonAjax = {
		"url" : "systemAccount_updateData.do",
		"jsonData" : {"mapStr":jsonToStr(jsonObj)},
		"methodName" : "updatePassword_back"
	};
	getAjaxData(jsonAjax);
}



/**
 * 修改密码操作回调函数
 * @param jsonObj
 */
function updatePassword_back(jsonObj){
	if(ajaxReceipt(jsonObj.data)){
		adminJS.alert({"title":"修改提示","info":"密码修改成功"});
	}else{
		errorInfo();
	}
	closeShowDiv();
	closeShowDiv();
}


/**
 *退出
 */
function confirmResult(){
	var title="退出提示";
	var info='确认退出?';
	var jsonObj = {
			'title':title,
			"info":info,
			"id":'0'
	};
	adminJS.confirm(jsonObj,function(e,id){
		if(e==0){
			return ;
		}
		window.location='login.do?hi='+getCookie('hlwyl_hosid');
	});
}

function getCookie(name){
  var reg = RegExp(name+'=([^;]+)');
  var arr = document.cookie.match(reg);
  if(arr){
    return arr[1];
  }else{
    return '';
  }
};

