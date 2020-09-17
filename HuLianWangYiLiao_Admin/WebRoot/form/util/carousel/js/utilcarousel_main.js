/****** 轮播图 操作JS  *********/
$(function(){
	//父窗口关闭加载层
	$("#dialodIndex", window.parent.document).remove();
	//本窗口关闭加载层
	closeLoadingDiv();
	//进行页面处理 如：排序 或其他之内
	initPage();
})
/************************系统生成方法开始******************************/
function queryUtilCarousel(page){
	loadingDiv();
	var query_carousel_way = $("#query_carousel_way").val();
	var query_carousel_name = $("#query_carousel_name").val();
	var query_carousel_type = $("#query_carousel_type").val();
	var json = {
		"carousel_way" : query_carousel_way,
		"carousel_name" : query_carousel_name,
		"carousel_type" : query_carousel_type,
 		 "carousel_id" : ""
	 }	
	var jsonObj = getPageParameter(json, page, "y","selectPageMain");
	$("#mapStr").val(jsonToStr(jsonObj));
	$("#queryForm").submit();
}

function openAddPage(){
	locationUrl('utilCarousel_addPage.do');
}

function openEditPage(id){
	locationUrl('utilCarousel_editPage.do?carousel_id='+id);
}

function confirmDeleteDate(id,name){
	var jsonObj = {
		'title':'操作提示',
		"info":'确认删除 <span class="red">'+name+'</span> ?',
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
			'url' : 'utilCarousel_deleteData.do',
			'jsonData' : {'mapStr':jsonToStr(jsonPar)},
			'methodName' : 'update_delete',
			'toID' : 'tbodyData'
		};
		getAjaxData(jsonAjax);
	});
}

/**
 * 查看详情
 */
function openCarouselPage(id,name){
	var jsonPar = {
			'carousel_id' : getStr(id)
		};
	var jsonAjax = {
		"url" : "utilCarousel_findById.do",
		"jsonData" : {'mapStr':jsonToStr(jsonPar)},
		"title" : name+"详情",
		"icon" : "plus",
		"methodName" : "page_back"
	};
	getAjaxData(jsonAjax);
}