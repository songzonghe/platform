<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@include file="/form_util/page/root.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${root}/form/main/assets/css/bootstrap.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/font-awesome.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/ace-fonts.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/ace.css" />
<link rel="stylesheet" href="${root}/form_util/util/util_css/myPage.css" />
</head>
<body class="no-skin">
<!-- 返回回来参数 -->
<%@include file="/form_util/page/hidden.jsp"%>
<div class="widget-main no-padding" style="width: 100%;height:100%;overflow-y: auto;">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong>添加轮播图</strong> </font>
		</div>
		<div class="form-group field" >
			<label class="col-sm-3 control-label no-padding-right">
				轮播位置
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<select id="update_carousel_type" class="col-xs-12" onchange="changeDiv()">
						<option  value="1">用户首页</option>
						<option  value="2">门店首页</option>
						<option  value="3">医生首页</option>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group field" >
			<label class="col-sm-3 control-label no-padding-right">
				轮播名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="轮播名称" id="update_carousel_name" class="col-xs-12" data-validate="required:轮播名称不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				轮播图片
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_carousel_img" class="radius" width="80px" height="80px">
							<input type="file" id="update_carousel_img_file" name="uploadName" onchange="uploadImg('update_carousel_img',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_carousel_img');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				轮播类型
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<select id="update_carousel_way" class="col-xs-12" onchange="changeDiv()">
						<option  value="1">无效果</option>
						<option  value="2">查看详情</option>
						<option  value="3">跳转链接</option>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group field" id="urlDiv" style="display: none" >
			<label class="col-sm-3 control-label no-padding-right">
				跳转地址
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="跳转地址" id="update_carousel_url" class="col-xs-12" >
				</span>
			</div>
		</div>
		<div class="form-group field detailsDiv" style="display: none" >
			<label class="col-sm-3 control-label no-padding-right" style="margin-left: -5px;">
				详情
			</label>
		</div>
		<div class="form-group field detailsDiv" style="display: none" >
			<div style="margin-left: 25%;">
				<script id="update_carousel_details" type="text/plain" style="width: 75%;height:700px;"></script>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				轮播序号
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="轮播序号" id="update_carousel_sort" class="col-xs-12" data-validate="required:轮播序号不能为空哦！,number:只能是数字哦！">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-5">
				<textarea class="col-xs-12" id="beiZhu" placeholder="备注"></textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="historyBack()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="addDataValidate()">
				确认
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script src="${root}/form_util/util/sys_js/jquery.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/ajaxUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/alertDivUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/bodyUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/adminUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/validateUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/jsonUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/publicJsonUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/strUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/date/WdatePicker.js?<%=Math.random()%>"></script>
<script src="${root}/form/main/assets/js/bootstrap-tab.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/sys_js/ajaxfileupload.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/nodeUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form/util/carousel/js/utilcarousel_add.js?<%=Math.random()%>"></script>
<script type="text/javascript" charset="utf-8" src="${root}/form_util/ueditor14/ueditor.config.js?<%=Math.random()%>"></script>
<script type="text/javascript" charset="utf-8" src="${root}/form_util/ueditor14/ueditor.all.js?<%=Math.random()%>"> </script>
<script type="text/javascript" charset="utf-8" src="${root}/form_util/ueditor14/lang/zh-cn/zh-cn.js?<%=Math.random()%>"></script>
<script>
	$(function() {
		//加载百度ue控件
		var ue = UE.getEditor('update_carousel_details',{enterTag:'',initialFrameWidth: null , autoHeightEnabled: false,autoFloatEnabled:false});
	});
	initValidate();
</script>
</body>
</html>
