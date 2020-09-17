	<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 550px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				企业名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="企业名称" id="update_enterprises_name" class="col-xs-12" data-validate="" value="${map.enterprises_name}" data-validate="required:不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				企业图片
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<div class="field">
						<a href="javascript:;" class="file">
							<c:if test="${empty map.enterprises_img}">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_enterprises_img" class="radius" width="80px" height="80px">
							</c:if>
							<c:if test="${!empty map.enterprises_img}"><img src="${map.enterprises_img}" name="uploadNameImg" id="update_enterprises_img" class="radius" width="80px" height="80px">
							</c:if>
							<input type="file" id="update_enterprises_img_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_enterprises_img',0,0)"data-validate="">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_enterprises_img');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				企业排序
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="企业排序" id="update_enterprises_sort" class="col-xs-12" data-validate="required:不能为空哦！" value="${map.enterprises_sort}" >
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				跳转地址
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="跳转地址" id="update_enterprises_url" class="col-xs-12" data-validate="required:不能为空哦！" value="${map.enterprises_url}" >
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-5">
				<textarea class="col-xs-12" id="beiZhu" placeholder="备注" >${map.bz}</textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.enterprises_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
