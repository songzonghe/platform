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
						<input type="text" placeholder="账号" readonly="readonly" class="col-xs-12" value="${map.pharmacist_number}">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="名称" id="update_pharmacist_name" value="${map.pharmacist_name}" class="col-xs-12" data-validate="required:名称不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row" >
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					<input type="checkbox" id="is_edit" value="1">密码
				</label>
				<div class="col-sm-6 field pass" >
					<span class="block input-icon input-icon-right"> 
						<input type="password" placeholder="密码" id="update_pharmacist_paw" name="pharmacist_paw" class="col-xs-12" data-validate="required:密码不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field pass">
				<label class="col-sm-3 control-label no-padding-right">
					确认密码
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="password" placeholder="确认密码" id="pharmacist_paw" class="col-xs-12" data-validate="required:确认密码不能为空哦！,repeat#pharmacist_paw:两次输入的密码不一致">
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
						<input type="text" placeholder="联系方式" id="update_pharmacist_phone" value="${map.pharmacist_phone}" class="col-xs-12" data-validate="required:联系方式不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					性别
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input style="margin-top: 10px;" type="radio" <c:if test="${map.pharmacist_sex=='2'}">checked="checked"</c:if> name="update_pharmacist_sex" value="2">保密&nbsp;&nbsp;
						<input type="radio" <c:if test="${map.pharmacist_sex=='0'}">checked="checked"</c:if> name="update_pharmacist_sex" value="0">男&nbsp;&nbsp;
						<input type="radio" <c:if test="${map.pharmacist_sex=='1'}">checked="checked"</c:if> name="update_pharmacist_sex" value="1">女
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
								<c:if test="${empty map.pharmacist_img}">
									<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_img" class="radius" width="80px" height="80px">
								</c:if>
								<c:if test="${!empty map.pharmacist_img}"><img src="${map.pharmacist_img}" name="uploadNameImg" id="update_pharmacist_img" class="radius" width="80px" height="80px">
								</c:if>
								<input type="file" id="update_pharmacist_img_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_pharmacist_img',0,0)">
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
								<c:if test="${empty map.pharmacist_autograph}">
									<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_autograph" class="radius" width="80px" height="80px">
								</c:if>
								<c:if test="${!empty map.pharmacist_autograph}"><img src="${map.pharmacist_autograph}" name="uploadNameImg" id="update_pharmacist_autograph" class="radius" width="80px" height="80px">
								</c:if>
								<input type="file" id="update_pharmacist_autograph_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_pharmacist_autograph',0,0)">
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
						<input type="text" placeholder="身份证号" id="update_pharmacist_document_number" value="${map.pharmacist_document_number}" class="col-xs-12" data-validate="required:身份证号不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-3 control-label no-padding-right">
					排序
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="排序" id="update_pharmacist_sort" value="${map.pharmacist_sort}" class="col-xs-12" data-validate="required:排序不能为空哦！">
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
								<c:if test="${empty map.pharmacist_document_img1}">
									<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_document_img1" class="radius" width="80px" height="80px">
								</c:if>
								<c:if test="${!empty map.pharmacist_document_img1}"><img src="${map.pharmacist_document_img1}" name="uploadNameImg" id="update_pharmacist_document_img1" class="radius" width="80px" height="80px">
								</c:if>
								<input type="file" id="update_pharmacist_document_img1_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_pharmacist_document_img1',0,0)">
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
								<c:if test="${empty map.pharmacist_document_img2}">
									<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_document_img2" class="radius" width="80px" height="80px">
								</c:if>
								<c:if test="${!empty map.pharmacist_document_img2}"><img src="${map.pharmacist_document_img2}" name="uploadNameImg" id="update_pharmacist_document_img2" class="radius" width="80px" height="80px">
								</c:if>
								<input type="file" id="update_pharmacist_document_img2_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_pharmacist_document_img2',0,0)">
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
								<c:if test="${empty map.pharmacist_medical_practitioner_certificate}">
									<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_medical_practitioner_certificate" class="radius" width="80px" height="80px">
								</c:if>
								<c:if test="${!empty map.pharmacist_medical_practitioner_certificate}"><img src="${map.pharmacist_medical_practitioner_certificate}" name="uploadNameImg" id="update_pharmacist_medical_practitioner_certificate" class="radius" width="80px" height="80px">
								</c:if>
								<input type="file" id="update_pharmacist_medical_practitioner_certificate_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_pharmacist_medical_practitioner_certificate',0,0)">
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
								<c:if test="${empty map.pharmacist_medical_licence}">
									<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_pharmacist_medical_licence" class="radius" width="80px" height="80px">
								</c:if>
								<c:if test="${!empty map.pharmacist_medical_licence}"><img src="${map.pharmacist_medical_licence}" name="uploadNameImg" id="update_pharmacist_medical_licence" class="radius" width="80px" height="80px">
								</c:if>
								<input type="file" id="update_pharmacist_medical_licence_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_pharmacist_medical_licence',0,0)">
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
					<textarea  id="update_pharmacist_synopsis" style="height: 200px !important;"  class="col-xs-12" placeholder="简介" data-validate="required:简介不能为空哦！">${map.pharmacist_synopsis}</textarea>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right">
					备注
				</label>
				<div class="col-sm-9">
					<textarea  id="beiZhu"  class="col-xs-12" placeholder="备注">${map.bz}</textarea>
				</div>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.pharmacist_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
	$(function(){
		$('.pass').find('input').attr('data-validate','backTrue:');
		$('.pass').find('input').val('');
		$('.pass').hide();
	})
	
	$('#is_edit').click(function(){
		if($(this).prop('checked')){
			$('.pass').show();
			$('#update_pharmacist_paw').attr('data-validate','required:密码不能为空哦！');
			$('#pharmacist_paw').attr('data-validate','required:确认密码不能为空哦！,repeat#pharmacist_paw:两次输入的密码不一致');
		}else{
			$('.pass').find('input').attr('data-validate','backTrue:');
			$('.pass').find('input').val('');
			$('.pass').hide();
		}
	});
</script>
