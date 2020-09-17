<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 880px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					账号
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="账号" id="update_user_phone" class="col-xs-12" data-validate="required:账号不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					密码
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="password" placeholder="密码" id="update_user_paw" class="col-xs-12" data-validate="required:密码不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					用户昵称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="用户昵称" id="update_user_nickname" class="col-xs-12" data-validate="required:用户昵称不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					用户头像
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_user_img" class="radius" width="80px" height="80px">
							<input type="file" id="update_user_img_file" name="uploadName" onchange="uploadImg('update_user_img',0,0)" data-validate="required:用户头像不能为空哦！">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_user_img');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					真实名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="真实名称" id="update_user_name" class="col-xs-12" data-validate="required:真实名称不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					证件号码
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="证件号码" id="update_user_document_number" class="col-xs-12" data-validate="required:证件号码不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					证件正面
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_user_document_img1" class="radius" width="80px" height="80px">
							<input type="file" id="update_user_document_img1_file" name="uploadName" onchange="uploadImg('update_user_document_img1',0,0)" data-validate="required:证件正面不能为空哦！">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_user_document_img1');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					证件反面
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_user_document_img2" class="radius" width="80px" height="80px">
							<input type="file" id="update_user_document_img2_file" name="uploadName" onchange="uploadImg('update_user_document_img2',0,0)" data-validate="required:证件反面不能为空哦！">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_user_document_img2');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;">
					备注
				</label>
				<div class="col-sm-10">
					<textarea style="width: 81%;" id="beiZhu" placeholder="备注"></textarea>
				</div>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="addDataValidate()">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
</script>
