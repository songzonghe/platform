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
				图标名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="图标名称" id="update_icon_name" class="col-xs-12" data-validate="required:图标名称不能为空哦！" value="${map.icon_name}" >
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				图标
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<div class="field">
						<a href="javascript:;" class="file">
							<c:if test="${empty map.icon_img}">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_icon_img" class="radius" width="80px" height="80px">
							</c:if>
							<c:if test="${!empty map.icon_img}"><img src="${map.icon_img}" name="uploadNameImg" id="update_icon_img" class="radius" width="80px" height="80px">
							</c:if>
							<input type="file" id="update_icon_img_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_icon_img',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_icon_img');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				显示状态
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;" type="radio" <c:if test="${map.is_show=='0'}">checked="checked"</c:if> name="update_is_show" value="0" >隐藏&nbsp;&nbsp;
					<input type="radio" name="update_is_show" value="1" <c:if test="${map.is_show=='1'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">显示
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				是否外链
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;" type="radio" <c:if test="${map.is_outer_chain=='0'}">checked="checked"</c:if> name="update_is_outer_chain" value="0" onclick="clickDiv(2)">否&nbsp;&nbsp;
					<input type="radio" name="update_is_outer_chain" value="1" <c:if test="${map.is_outer_chain=='1'}">checked="checked"</c:if> onclick="clickDiv(1)">是
				</span>
			</div>
		</div>
		<div class="form-group field" id="update_icon_link_div" <c:if test="${map.is_outer_chain=='0'}">style="display: none"</c:if>>
			<label class="col-sm-3 control-label no-padding-right">
				链接地址
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="链接地址" id="update_icon_link" class="col-xs-12" data-validate="" value="${map.icon_link}" >
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
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.icon_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
	function clickDiv(type){
		if(type==1){
			$('#update_icon_link_div').show();
		}else{
			$('#update_icon_link_div').hide();
			$('#update_icon_link').val('');
		}
	}
</script>
