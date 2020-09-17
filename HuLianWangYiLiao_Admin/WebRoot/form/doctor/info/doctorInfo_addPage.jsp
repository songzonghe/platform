<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 880px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					账号
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="账号" id="update_doctor_phone" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					医生类型
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<select id="update_doctor_type" class="col-xs-12">
							<option value="">默认</option>
							<option value="01" <c:if test="${map.doctor_type=='01'}">selected="selected"</c:if>>美团</option>
						</select>
					</span>
				</div>
			</div>			
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					密码
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="password" placeholder="密码" id="update_doctor_paw" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					医生名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="医生名称" id="update_doctor_name" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					医生头像
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_doctor_img" class="radius" width="80px" height="80px">
							<input type="file" id="update_doctor_img_file" name="uploadName" onchange="uploadImg('update_doctor_img',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_doctor_img');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					医生签名
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_doctor_autograph" class="radius" width="80px" height="80px">
							<input type="file" id="update_doctor_autograph_file" name="uploadName" onchange="uploadImg('update_doctor_autograph',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_doctor_autograph');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					性别
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input style="margin-top: 10px;" type="radio" checked="checked" name="update_doctor_sex" value="0">男&nbsp;&nbsp;
					<input type="radio" name="update_doctor_sex" value="1">女
					<input type="radio" name="update_doctor_sex" value="2">保密
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					医生职称
				</label>
				<div class="col-sm-6 field">
					<select  id="update_doctot_job_title" class="col-xs-12" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach items="${doctorTitleList}" var="info">
							<option value="${info.title_id}" data-name="${info.title_name}">${info.title_name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					执业点
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="执业点" id="update_doctor_work_address" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 departmentList">
			<label class="col-sm-2 control-label no-padding-right" onchange="departmentList()">
				科室名称
			</label>
			<div class="col-sm-6 field">
				<span class="block input-icon input-icon-right">
					<select  id="update_department_id" class="col-xs-12" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach items="${departmentList}" var="info">
							<option value="${info.department_id}">${info.department_name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					执业日期
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="执业日期" id="update_doctot_work_day" class="col-xs-12 Wdate" data-validate="required:不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					生日
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="生日" id="update_doctot_birthday" class="col-xs-12 Wdate" data-validate="required:不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					证件号码
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="证件号码" id="update_doctor_document_number" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					证件正面
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_doctor_document_img1" class="radius" width="80px" height="80px">
							<input type="file" id="update_doctor_document_img1_file" name="uploadName" onchange="uploadImg('update_doctor_document_img1',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_doctor_document_img1');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					证件反面
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_doctor_document_img2" class="radius" width="80px" height="80px">
							<input type="file" id="update_doctor_document_img2_file" name="uploadName" onchange="uploadImg('update_doctor_document_img2',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_doctor_document_img2');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					医师执业证
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_doctor_medical_practitioner_certificate" class="radius" width="80px" height="80px">
							<input type="file" id="update_doctor_medical_practitioner_certificate_file" name="uploadName" onchange="uploadImg('update_doctor_medical_practitioner_certificate',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_doctor_medical_practitioner_certificate');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					医师资格证
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_doctor_medical_licence" class="radius" width="80px" height="80px">
							<input type="file" id="update_doctor_medical_licence_file" name="uploadName" onchange="uploadImg('update_doctor_medical_licence',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_doctor_medical_licence');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					技术资格证
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<div class="field">
						<a href="javascript:;" class="file">
							<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_doctor_technical_certificate" class="radius" width="80px" height="80px">
							<input type="file" id="update_doctor_technical_certificate_file" name="uploadName" onchange="uploadImg('update_doctor_technical_certificate',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_doctor_technical_certificate');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					医生擅长
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<textarea type="text" placeholder="医生擅长" id="update_doctor_begoodat" class="col-xs-12" data-validate="required:不能为空哦！"></textarea>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					医生简介
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<textarea type="text" placeholder="医生简介" id="update_doctor_synopsis" class="col-xs-12" data-validate="required:不能为空哦！"></textarea>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					医生排序
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="医生排序" id="update_doctor_sort" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					是否在线
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input style="margin-top: 10px;" type="radio" data-validate="required:不能为空哦！" checked="checked" name="update_is_online" value="0">否&nbsp;&nbsp;
					<input type="radio" name="update_is_online" data-validate="required:不能为空哦！" value="1">是
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					专业技术职务代码
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<select id="update_doctor_zyjszwdm" class="col-xs-12" data-validate="required:不能为空哦！">
							<option value="">请选择</option>
							<c:forEach var="datas" items="${allList.list001}">
								<option value="${datas.code}" <c:if test="${map.doctor_zyjszwdm==datas.code}">selected="selected"</c:if>>${datas.name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
			
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					专业技术职务类别代码
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<select id="update_doctor_zyjszwlbdm" class="col-xs-12" data-validate="required:不能为空哦！">
							<option value="">请选择</option>
							<c:forEach var="datas" items="${allList.list002}">
								<option value="${datas.code}" <c:if test="${map.doctor_zyjszwlbdm==datas.code}">selected="selected"</c:if>>${datas.name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					资质类别名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="资质类别名称" id="update_doctor_zzlbmc" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					资格证书编号
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="资格证书编号" id="update_doctor_zgzsbh" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					资格获得时间
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="资格获得时间" id="update_doctor_zghdsj" class="col-xs-12 Wdate" data-validate="required:日期不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" >
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					执业证书编码
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="执业证书编码" id="update_doctor_zyzsbm" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					发证日期
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="发证日期" id="update_doctor_fzrq" class="col-xs-12 Wdate" data-validate="required:日期不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" >
					</span>
				</div>
			</div>
			
		<!--  	<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					执业范围
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="执业范围" id="update_doctor_zyfw" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
		-->
		
		<div class="form-group col-sm-6">
			<label class="col-sm-2 control-label no-padding-right">
				执业范围
			</label>
			<div class="col-sm-6 field">
				<span class="block input-icon input-icon-right"> 
					<select id="update_doctor_zyfw" class="col-xs-12" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach var="datas" items="${allList.list009}">
							<option value="${datas.code}" data-name="${datas.name}" <c:if test="${map.update_doctor_zyfw==datas.code}">selected="selected"</c:if>>${datas.name}</option>
						</c:forEach>
					</select>
				</span>				
			</div>
		</div>
		</div>
		
		
		
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					全科医生标志
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<select id="update_doctor_qkysbz" class="col-xs-12" data-validate="required:不能为空哦！" >
							<option value="">请选择</option>
							<option value="T" <c:if test="${map.doctor_qkysbz=='T'}">selected="selected"</c:if>>是</option>
							<option value="F" <c:if test="${map.doctor_qkysbz=='F'}">selected="selected"</c:if>>否</option>
						</select>
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					个人照片存放地址
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<select id="update_doctor_grzpcfdz" class="col-xs-12" data-validate="required:不能为空哦！" >
							<option value="">请选择</option>
							<option value="T" <c:if test="${map.doctor_grzpcfdz=='T'}">selected="selected"</c:if>>有</option>
							<option value="F" <c:if test="${map.doctor_grzpcfdz=='F'}">selected="selected"</c:if>>无</option>
						</select>
					</span>
				</div>
			</div>
			
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					民族
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="民族 " id="update_doctor_mz" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
				<label class="col-sm-2 control-label no-padding-right">
					学历
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="学历" id="update_doctor_xl" class="col-xs-12" data-validate="required:不能为空哦！">
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
				撤销标志
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<select id="update_doctor_cxbz" class="col-xs-12" data-validate="required:不能为空哦！" >
							<option value="">请选择</option>
							<option value="1" <c:if test="${map.doctor_cxbz=='1'}">selected="selected"</c:if>>正常</option>
							<option value="2" <c:if test="${map.doctor_cxbz=='2'}">selected="selected"</c:if>>已撤销</option>
						</select> 
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6">
			<label class="col-sm-2 control-label no-padding-right">
				注册日期
			</label>
			<div class="col-sm-6 field">
				<span class="block input-icon input-icon-right"> 
					<input type="text" placeholder="注册日期" id="update_doctor_zcsj" class="col-xs-12 Wdate" data-validate="required:不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${map.doctor_zcsj}" >
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
	$(function(){
		departmentList();
		})
	
	function departmentList(){
		var val=$('#update_department_id').val();
		$('#update_department_id').attr('data-validate','required:请选择');
		}
	
	
</script>
