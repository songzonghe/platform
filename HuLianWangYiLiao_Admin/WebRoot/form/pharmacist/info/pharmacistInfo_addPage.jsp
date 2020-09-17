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
						<input type="text" placeholder="账号" id="update_pharmacist_number" class="col-xs-12" data-validate="required:账号不能为空哦！,ajax#pharmacistInfo_findByNumber.do?number=:账号已存在！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="名称" id="update_pharmacist_name" class="col-xs-12" data-validate="required:名称不能为空哦！">
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
						<input type="password" placeholder="密码" id="update_pharmacist_paw" name="pharmacist_paw" class="col-xs-12" data-validate="required:密码不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					确认密码
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="password" placeholder="确认密码" class="col-xs-12" data-validate="required:请输入确认密码！,repeat#pharmacist_paw:两次输入的密码不一致">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					联系方式
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="联系方式" id="update_pharmacist_phone" class="col-xs-12" data-validate="required:联系方式不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					性别
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" type="radio" checked="checked" name="update_pharmacist_sex" value="2">保密&nbsp;&nbsp;
						<input type="radio"  name="update_pharmacist_sex" value="0">男&nbsp;&nbsp;
						<input type="radio" name="update_pharmacist_sex" value="1">女
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					头像
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<div class="field">
							<a href="javascript:;" class="file">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_img" class="radius" width="80px" height="80px">
								<input type="file" id="update_pharmacist_img_file" name="uploadName" onchange="uploadImg('update_pharmacist_img',0,0)">
							</a>
							<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_pharmacist_img');">
								<i class="ace-icon fa fa-times red2"></i> 清除
							</button>
						</div>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					签名
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<div class="field">
							<a href="javascript:;" class="file">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_autograph" class="radius" width="80px" height="80px">
								<input type="file" id="update_pharmacist_autograph_file" name="uploadName" onchange="uploadImg('update_pharmacist_autograph',0,0)">
							</a>
							<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_pharmacist_autograph');">
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
					身份证号
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="身份证号" id="update_pharmacist_document_number" class="col-xs-12" data-validate="required:身份证号不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					排序
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="排序" id="update_pharmacist_sort" class="col-xs-12" data-validate="required:排序不能为空哦！">
					</span>
				</div>
			</div>
			
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					身份证正面
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<div class="field">
							<a href="javascript:;" class="file">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_document_img1" class="radius" width="80px" height="80px">
								<input type="file" id="update_pharmacist_document_img1_file" name="uploadName" onchange="uploadImg('update_pharmacist_document_img1',0,0)">
							</a>
							<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_pharmacist_document_img1');">
								<i class="ace-icon fa fa-times red2"></i> 清除
							</button>
						</div>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					身份证反面
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<div class="field">
							<a href="javascript:;" class="file">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_document_img2" class="radius" width="80px" height="80px">
								<input type="file" id="update_pharmacist_document_img2_file" name="uploadName" onchange="uploadImg('update_pharmacist_document_img2',0,0)">
							</a>
							<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_pharmacist_document_img2');">
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
					执业证
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<div class="field">
							<a href="javascript:;" class="file">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_medical_practitioner_certificate" class="radius" width="80px" height="80px">
								<input type="file" id="update_pharmacist_medical_practitioner_certificate_file" name="uploadName" onchange="uploadImg('update_pharmacist_medical_practitioner_certificate',0,0)">
							</a>
							<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_pharmacist_medical_practitioner_certificate');">
								<i class="ace-icon fa fa-times red2"></i> 清除
							</button>
						</div>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					资格证
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<div class="field">
							<a href="javascript:;" class="file">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_medical_licence" class="radius" width="80px" height="80px">
								<input type="file" id="update_pharmacist_medical_licence_file" name="uploadName" onchange="uploadImg('update_pharmacist_medical_licence',0,0)">
							</a>
							<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_pharmacist_medical_licence');">
								<i class="ace-icon fa fa-times red2"></i> 清除
							</button>
						</div>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right" >
					简介
				</label>
				<div class="col-sm-9">
					<textarea  id="update_pharmacist_synopsis" style="height: 200px !important;"  class="col-xs-12" placeholder="简介" data-validate="required:简介不能为空哦！"></textarea>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right">
					备注
				</label>
				<div class="col-sm-9">
					<textarea  id="beiZhu"  class="col-xs-12" placeholder="备注"></textarea>
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
