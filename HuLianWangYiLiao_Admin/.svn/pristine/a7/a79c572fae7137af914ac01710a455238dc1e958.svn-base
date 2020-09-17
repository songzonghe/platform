<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 550px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				名称
			</label>
			<div class="col-sm-6">
				<span class="block input-icon input-icon-right">
					<input type="text" readonly="readonly" placeholder="名称" id="update_init_name" class="col-xs-12" data-validate="请填写名称" value="${map.init_name}" onchange="$('#isUpdate').attr('value','y')">
				</span>
			</div>
		</div>
		<c:if test="${map.zt=='2'}">
			<div class="form-group field">
				<label class="col-sm-3 control-label no-padding-right">
					图片
				</label>
				<div class="col-sm-6">
					<span class="block input-icon input-icon-right">
		                 <div class="field">
						<a href="javascript:;" class="file">
							<img src="${map.init_key}" name="uploadNameImg" id="update_init_key" class="radius" width="80px" height="80px">
							<input type="file" id="update_init_key_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_init_key',0,0)">
						</a>
					</div>
				</span>
				</div>
			</div>
		</c:if>
		<c:if test="${map.zt==3}">
			<div class="form-group field">
				<label class="col-sm-3 control-label no-padding-right">
					内容
				</label>
				<div class="col-sm-6">
					<span class="block input-icon input-icon-right">
		                 <input type="text" placeholder="内容" id="update_init_key" class="col-xs-12" data-validate="请填写内容" value="${map.init_key}" onchange="$('#isUpdate').attr('value','y')">
	                </span>
				</div>
			</div>
		</c:if>
		<c:if test="${map.zt==4}">
			<div class="form-group field">
				<label class="col-sm-3 control-label no-padding-right">
					内容
				</label>
				<div class="col-sm-6">
					<span class="block input-icon input-icon-right">
		                <textarea class="col-xs-12" id="update_init_key" placeholder="内容" onchange="$('#isUpdate').attr('value','y')">${map.init_key}</textarea>
	                </span>
				</div>
			</div>
		</c:if>
		<c:if test="${map.zt=='6'}">
			<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				视频
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right"> 
				    <video style="display:${empty map.init_key?'none':'block'}" height="200px" src="${map.init_key}" controls="controls" width="140px;" name="update_init_key" id="update_init_key" >
						您的浏览器不支持 video 标签。
					</video>
					<a href="javascript:;" class="file upload">
						<button class="btn btn-xs btn-info btn-white file">选择视频</button>
						<input type="file" id="update_init_key_file" name="uploadName" onchange="uploadVideo('update_init_key')">
					</a>
					<span class="file upload">
						<button type="button" class="btn btn-xs btn-white file" onclick="videoClear('update_init_key');">
							<i class="ace-icon fa fa-times red2"></i> 清&nbsp;除&nbsp;
						</button>
					</span>
				</span>
			</div>
		</div>
		</c:if>
			<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-6">
				<textarea class="col-xs-12" id="beiZhu" placeholder="备注" onchange="$('#isUpdate').attr('value','y')">${map.bz}</textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.init_id}','${map.zt}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
