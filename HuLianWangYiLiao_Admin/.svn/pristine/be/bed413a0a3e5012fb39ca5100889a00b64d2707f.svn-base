/** ***************固定json格式模板 李飞 2015年7月12日20:18:30******************** */
/**
 * 返回请求page参数
 * 
 * @param json
 *            当前条件参数
 * @param page
 *            当前页
 * @param isSort
 *            是否开启排序
 * @param pageSelectID
 *            分页条数选择 select元素ID
 * @return JSON
 */
function getPageParameter(json, page, isSort, pageSelectID) {
	if(isUndefinedAndEmpty(page)){
		page=0;
	}
	var sortDataType=$('table').find('th[field='+$("#sortField").val()+']').attr('type');
	var jsonObj = {
		"json" : json,
		"pageNum" : page,
		"isSort" : isSort,
		"sortField" : $("#sortField").val(),
		"sortType" : $("#sortType").val(),
		"sortDataType" : sortDataType,
		"pageSelectID" : pageSelectID
	}
	return publicFieldsnJSON(queryJson(jsonObj));
}

/**
 * 私有方法 共有处理分页参数 其中包含：页面数 并加入了每页条数 开启排序 排序字段 排序方式
 * 
 * @param jsonObj
 *            包含： jsonObj.json 当前需要操作的json对象 jsonObj.page 当前页码 如果不需要分页参数
 *            只需随便给入一个值 建议给 "" jsonObj.isSort 是否开启排序 jsonObj.sortField
 *            排序字段 jsonObj.sortType 排序方式 jsonObj.pageSelectID 分页条数选择
 *            select元素ID
 * @return JSON
 */
function queryJson(jsonObj) {
	var pageNumSelect = $("#"+jsonObj.pageSelectID+"SelectPageNum").val();
	if(isUndefinedAndEmpty(jsonObj.pageSelectID) || isUndefinedAndEmpty(pageNumSelect)){
		pageNumSelect = 10 ;
	}
	// 如果为空就给默认值y
	if(isUndefinedAndEmpty(jsonObj.isSort)){
		jsonObj.isSort = "y";
	}
	// 如果为空就给默认值t.lrsj
	if(isUndefinedAndEmpty(jsonObj.sortField)){
		jsonObj.sortField = "t.lrsj";
	}
	// 如果为空就给默认值desc
	if(isUndefinedAndEmpty(jsonObj.sortType)){
		jsonObj.sortType = "desc";
	}
	var jsonTarget = '[{"pageNum":"' + jsonObj.pageNum
			+ '","pageNumSelect":"' + pageNumSelect
			+ '","isSort":"' + jsonObj.isSort
			+ '","sortField":"' + jsonObj.sortField
			+ '","sortType":"' + jsonObj.sortType
			+ '","sortDataType":"' + jsonObj.sortDataType
			+ '"}]';
	return copyJson(strToJson(jsonTarget), jsonObj.json);
}
/**
 * 加入公用的参数 录入时间 录入人 注册id 返回json对象
 * 
 * @param jsonObj
 *            json 请求到后台参数
 * @return JSON
 */
function publicFieldsnJSON(jsonObj){
	var lrzhm = $("#lrzhm").val(); // 帐户名称
	var lrzh = $("#zh_id").val(); // 帐户ID
	var lrsj = $("#editLrsj").val(); // 录入时间
	if(isUndefinedAndEmpty(lrsj)){
		lrsj = "";
	}
	var zt = 2; // 状态
	var bz = $("#beiZhu").val();// 备注
	var jsonTarget = '[{"lrzhm":"' + lrzhm
	+ '","lrzh":"' + lrzh
	+ '","lrsj":"' + lrsj
	+ '","zt":"' + zt
	+ '","bz":"' + bz
	+ '","isUpdate":"' + $("#isUpdate").attr("value")
	+ '"}]';
	return copyJson(strToJson(jsonTarget), jsonObj);
}
/**
 * 触发浏览器返回
 * @return
 */
function historyBack(){
	history.back();
}
/**
 * 浏览器跳转到指定页面
 * @return
 */
function locationUrl(url){
	window.location.href=url;
}
/**
 * 打开新的页面
 */
function openNewPage(url){
	window.open(url);
}

/**
 * 拼接图片
 */
function getImgList(name){
	var count='[';
	$("img[name='"+name+"']").each(function(i,item){
		var img=$(this).attr("src");
		if(!isUndefinedAndEmpty(img)&&img.indexOf('images/upload.png')==-1){
			if(count=='['){
				count+='{"img":"'+img+'"}';
			}else{
				count+=',{"img":"'+img+'"}';
			}
		}
	});
	return count+']';
}

/**
 * 添加多张图片
 */
function addImg(jsonObj){
	$('#'+jsonObj.elementId+"_file").val('');
	var html='<div>';
		html+='<img src="'+getUploadAddress()+jsonObj.data+'" name="'+jsonObj.elementId+'" width="80px" height="80px">';
		html+='<i class="del" onclick="delImg(this)">×</i>';
		html+='</div>';
	$('#'+jsonObj.elementId).append(html);
}

function delImg(obj){
	$(obj).parent("div").remove();
	
}

/**
 * 打印
 * @return
 */
function printAll(id){
	$('#'+id).jqprint({
        debug: false,            
        importCSS: true,         
        printContainer: true,    
        operaSupport: false    
    })
}

/**
 * table点击操作，弹框
 */
$("body .table").delegate(".handel-box","click", function(e){
	if($(this).children('ul').is(":hidden")){
		$(this).children('ul').show();
		$(this).parents('tr').siblings().find('ul').hide();
	}else{
		$(this).children('ul').hide();
	}
    $(document).one("click", function(){
        $(".handel-list").hide();
    });
    e.stopPropagation();
})
$(".handel-list").on("click", function(e){
    e.stopPropagation();
});
$(".handel-list li").on("click", function(e){
    $(this).parent('ul').hide();
});


jQuery('body').on('click' ,'.more', function() {
	$(this).children('ul').toggle();
	$(this).parents('tr').siblings().find('ul').hide();
})
jQuery('body').on('click', '.more-list li', function() {
	$(this).parent(".more-list li").css("display","none");     
})