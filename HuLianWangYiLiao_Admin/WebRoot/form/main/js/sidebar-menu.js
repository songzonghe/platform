(function($) {
	$.fn.sidebarMenu = function(options) {
		options = $.extend( {}, $.fn.sidebarMenu.defaults, options || {});
		var target = $(this);
		target.addClass('nav');
		target.addClass('nav-list');
		if (options.data) {
			init(target, options.data);
		} else {
			if (!options.url)
				return;
			$.getJSON(options.url, options.param, function(data) {
				init(target, data);
			});
		}
		var url = window.location.pathname;
		function init(target, data) {
			$.each(data, function(i, item) {
				var li = null;
				if (isUndefinedAndEmpty(item.parentID)) {
					li = $('<li></li>');
				} else {
					li = $('<li id="parentli' + item.parentID + '"></li>');
				}
				var a = $('<a></a>');
				var icon = $('<i></i>');
				icon.addClass(item.icon);
				var text = $('<span></span>');
				text.addClass('menu-text').text(item.text);
				//a.append(icon);
				if (!isUndefinedAndEmpty(item.parentID)) {
					a.append("&nbsp;");
				}
				var classId = item.id;
				li.attr('id', classId);
				a.append(text);
				
				if (item.data && item.data.length > 0) {
					a.attr('href', '#');
					a.addClass('dropdown-toggle');
					var arrow = $('<b></b>');
					arrow.addClass('arrow').addClass('arrow fa fa-angle-down');
					a.append(arrow);
					li.append(a);
					var menus = $('<ul></ul>');
					menus.addClass('submenu');
					init(menus, item.data);
					li.append(menus);
				} else {
					var url = getRoot()+"/"+item.url;
					var href = 'javascript:addTabs({id:\'' + item.id
							+ '\',title: \'' + item.text
							+ '\',close: true,url: \'' + url
							+ '\',parentID: \'' + item.parentID + '\'});';
					a.attr('href', href);
					
					a.append('<i class="menu-icon fa fa-caret-right"></i>');
					li.append(a);
					li.attr("onclick", "selectMenu(this)");
				}
				target.append(li);
			});
		}
	}

	$.fn.sidebarMenu.defaults = {
		url : null,
		param : null,
		data : null
	};
})(jQuery);

var addTabs = function(options) {
	// var rand = Math.random().toString();
	// var id = rand.substring(rand.indexOf('.') + 1);
	var url = window.location.protocol + '//' + window.location.host;
	options.url = url + options.url;
	id = "tab_" + options.id;
	$("#showMenuDiv .active").removeClass("active");
	// 如果TAB不存在，创建一个新的TAB
	if (!$("#" + id)[0]) {
		loadingDiv();
		// 固定TAB中IFRAME高度
		var mainHeight = getBodyHeight() - topPx;
		// 创建新TAB的title
		title = '<li role="presentation" id="tab_' + id
				+ '" onclick="selectliMenu(' + options.parentID +','+id
				+ ')"><a href="#' + id + '" aria-controls="' + id
				+ '" role="tab" data-toggle="tab">' + options.title;
		// 是否允许关闭
		if (options.close) {
			title += '&nbsp;<i class="fa fa-remove" tabclose="' + id + '" style="cursor: pointer;"></i>';
		}
		title += '</a></li>';
		// 是否指定TAB内容
		if (options.content) {
			content = '<div role="tabpanel" class="tab-pane" id="' + id + '">'
					+ options.content + '</div>';
		} else {// 没有内容，使用IFRAME打开链接
			content = '<div role="tabpanel" class="tab-pane" id="'
					+ id
					+ '"><iframe src="'
					+ options.url
					+ '" height="'
					+ ($(window).height()-128)+"px"
					+ '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" style="width:100%" allowtransparency="yes"></iframe></div>';
		}
		// 加入TABS
		$(".nav-tabs").append(title);
		$(".tab-content").append(content);
	}
	// 激活TAB
	$("#tab_" + id).addClass('active');
	$("#" + id).addClass("active");
//	头部导航条定位
	var oldLeft =$('.nav-tabs').position().left;
	var newWidth = $('.nav-tabs')[0].childElementCount*100;
	if($('.nav-tabs').width() < newWidth && oldLeft*(-1) < (newWidth-$('.nav-tabs').width())){
		$('.nav-left-btn').removeClass('nav-unBtn');
		var din = -$("#tab_" + id).position().left + $('.nav-tabs').width()-100;
		console.log($("#tab_" + id));
		if(din > 0){din=0}
		$('.nav-tabs').css('left',din+'px');
	}
};
var closeTab = function(id) {
	// 如果关闭的是当前激活的TAB，激活他的前一个TAB
	if ($("#tabsMenu li.active").attr('id') == "tab_" + id) {
		$("#tab_" + id).prev().addClass('active');
		$("#" + id).prev().addClass('active');
	}
	// 关闭TAB
	$("#tab_" + id).remove();
	$("#" + id).remove();
};
$(function() {
	//mainHeight = $(document.body).height() - 45;
	//$('.main-left,.main-right').height(mainHeight);
	$("[addtabs]").click(function() {
		addTabs( {
			id : $(this).attr("id"),
			title : $(this).attr('title'),
			close : true
		});
	});

	$(".nav-tabs").on("click", "[tabclose]", function(e) {
		id = $(this).attr("tabclose");
		closeTab(id);
	});
});
/**
 * 选中li菜单 左边
 * 
 * @param this_
 */
function selectMenu(this_) {
	//$("iframe").css("height",($(window).height()-150)+"px");
	$("#menu .active").removeClass("active");
	$(this_).addClass("active");
	// 父元素
	$(this_).parent().parent().addClass("active");
	
//	刷新iframe
	var numId ="#tab_" + $(this_).attr('id');
	$(''+numId+' iframe').attr('src', $(''+numId+' iframe').attr('src'));
	
}

/**
 * 选中li菜单 右边
 * 
 * @param parentID
 */
function selectliMenu(parentID,id) {
	var this_ = $("#parentli" + parentID);
	$("#menu .active").removeClass("active");
	$("#menu .open").removeClass("open");
	$(this_).addClass("active");
	// 父元素
	$(this_).parent().parent().addClass("active").addClass("open");
	$(this_).parent().show();
}

$(function() {
	var root = $("#root").val();
	// 设置首页高度
	$("#indexPage").css("height", getBodyHeight() - topPx-40);
	
	var menuData=$("#menuData").val();
	if(!isUndefinedAndEmpty(menuData)){
		var jsonData = strToJson(menuData);
		// 设置菜单数据
		$('#menu').sidebarMenu(jsonData);
	}
});