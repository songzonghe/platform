	<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="widget-main no-padding" style="width: 800px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				医院logo
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<div class="field">
						<a href="javascript:;" class="file">
							<c:if test="${empty map.hospital_logo}">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_hospital_logo" class="radius" width="80px" height="80px">
							</c:if>
							<c:if test="${!empty map.hospital_logo}"><img src="${map.hospital_logo}" name="uploadNameImg" id="update_hospital_logo" class="radius" width="80px" height="80px">
							</c:if>
							<input type="file" id="update_hospital_logo_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_hospital_logo',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_hospital_logo');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label no-padding-right">
				-
			</label>
			<div class="col-sm-10 field">
				<span class="block input-icon input-icon-right">
					<input type="text" readonly="readonly" id="showUrl" class="col-xs-10" value="${map.showUrl}">
				</span>
				<button type="button" class="btn btn-sm btn-success" onclick="Copy()">
					复制
				</button>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				帐号
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" readonly="readonly" class="col-xs-12" value="${map.hospital_number}">
				</span>
			</div>
		</div>
		<div class="form-group field ">
			<label class="col-sm-3 control-label no-padding-right">
				<input type="checkbox" id="is_edit" value="1">密码
			</label>
			<div class="col-sm-7 field pass">
				<span class="block input-icon input-icon-right">
					<input type="password"  id="update_hospital_pwd" name="hospital_pwd" class="col-xs-12" data-validate="required:请输入密码！" value="" >
				</span>
			</div>
		</div>
		
		<div class="form-group field pass">
			<label class="col-sm-3 control-label no-padding-right">
				确认密码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="password" id="hospital_pwd" class="col-xs-12" data-validate="required:请输入确认密码！,repeat#hospital_pwd:两次输入的密码不一致">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				医院名称
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_hospital_name" class="col-xs-12" data-validate="required:请输入医院名称！" value="${map.hospital_name}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				机构标识
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_hospital_jgdm" class="col-xs-12" data-validate="required:请输入机构标识！" value="${map.hospital_jgdm}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				统一社会信用代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_hospital_zzjgdm" class="col-xs-12" data-validate="required:请输入统一社会信用代码！" value="${map.hospital_zzjgdm}" >
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				行政区划代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_hospital_xzqhdm" class="col-xs-12" data-validate="required:请输入行政区划代码！" value="${map.hospital_xzqhdm}" >
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				机构类型
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right"> 
					<input style="margin-top: 10px;"  type="radio" <c:if test="${empty map.hospital_jglx or map.hospital_jglx=='01' }">checked="checked"</c:if>  name="update_hospital_jglx" value="01">互联网医院诊疗&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_jglx=='02' }">checked="checked"</c:if>  name="update_hospital_jglx" value="02">健康管理服务&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_jglx=='03' }">checked="checked"</c:if>  name="update_hospital_jglx" value="03">药事服务机构&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_jglx=='04' }">checked="checked"</c:if> name="update_hospital_jglx" value="04">药房&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_jglx=='05' }">checked="checked"</c:if> name="update_hospital_jglx" value="05">其他
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				机构成立日期
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_hospital_jgclrq" class="col-xs-12" data-validate="required:请选择机构成立日期！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${map.hospital_jgclrq}" >
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				单位隶属关系代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<select id="update_hospital_dwlsgxdm" class="col-xs-12" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach var="datas" items="${allList.list005}">
							<option value="${datas.code}" <c:if test="${map.hospital_dwlsgxdm==datas.code}">selected="selected"</c:if>>${datas.name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				机构分类管理类别代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;"  type="radio" <c:if test="${empty map.hospital_jgflgllbdm or map.hospital_jgflgllbdm=='1' }">checked="checked"</c:if>  name="update_hospital_jgflgllbdm" value="1">非盈利性医疗机构&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_jgflgllbdm=='2' }">checked="checked"</c:if>  name="update_hospital_jgflgllbdm" value="2">盈利性医疗机构&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_jgflgllbdm=='9' }">checked="checked"</c:if>  name="update_hospital_jgflgllbdm" value="9">其他
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				机构分类代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<select id="update_hospital_jgfldm" class="col-xs-12" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach var="datas" items="${allList.list007}">
							<option value="${datas.code}" <c:if test="${map.hospital_jgfldm==datas.code}">selected="selected"</c:if>>${datas.name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				经济类型代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<select id="update_hospital_jjlxdm" class="col-xs-12" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach var="datas" items="${allList.list008}">
							<option value="${datas.code}" <c:if test="${map.hospital_jjlxdm==datas.code}">selected="selected"</c:if>>${datas.name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				地址
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_hospital_dz" class="col-xs-12" data-validate="required:请输入地址！" value="${map.hospital_dz}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				实体医院医疗组织机构代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_hospital_styyzzjgdm" class="col-xs-12" data-validate="required:请输入实体医院医疗组织机构代码！" value="${map.hospital_styyzzjgdm}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				实体医院名称
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_hospital_styymc" class="col-xs-12" data-validate="required:请输入实体医院名称！"  value="${map.hospital_styymc}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				实体医疗机构级别
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;"  type="radio" <c:if test="${empty map.hospital_styljgjb or map.hospital_styljgjb=='0' }">checked="checked"</c:if>  name="update_hospital_styljgjb" value="0">基层卫生服务站&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_styljgjb=='1' }">checked="checked"</c:if>  name="update_hospital_styljgjb" value="1">一级医院&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_styljgjb=='2' }">checked="checked"</c:if>  name="update_hospital_styljgjb" value="2">二级医院&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_styljgjb=='3' }">checked="checked"</c:if>  name="update_hospital_styljgjb" value="3">三级医院&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_styljgjb=='4' }">checked="checked"</c:if>  name="update_hospital_styljgjb" value="4">其他
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				实体医院机构等级
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;"  type="radio" <c:if test="${empty map.hospital_styljgdj or map.hospital_styljgdj=='0' }">checked="checked"</c:if>  name="update_hospital_styljgdj" value="0">甲等&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_styljgdj=='1' }">checked="checked"</c:if>  name="update_hospital_styljgdj" value="1">乙等&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_styljgdj=='2' }">checked="checked"</c:if>  name="update_hospital_styljgdj" value="2">丙等&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_styljgdj=='3' }">checked="checked"</c:if>  name="update_hospital_styljgdj" value="3">未定&nbsp;&nbsp;
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				互联网医院网址
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_hospital_hlwyywz" class="col-xs-12" data-validate="required:请输入互联网医院网址！" value="${map.hospital_hlwyywz}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				许可证号码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_hospital_xkzhm" class="col-xs-12" data-validate="required:请输入许可证号码！" value="${map.hospital_xkzhm}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				许可项目名称
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_hospital_xkxmmc" class="col-xs-12" data-validate="required:请输入许可项目名称！" value="${map.hospital_xkxmmc}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				许可证有效期
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_hospital_xkzyxq" class="col-xs-12" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" data-validate="required:请输入许可证有效期！" value="${map.hospital_xkzyxq}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				信息安全等级保护
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
				<input style="margin-top: 10px;"  type="radio" <c:if test="${empty map.hospital_xxaqdjbh or map.hospital_xxaqdjbh=='1' }">checked="checked"</c:if>  name="update_hospital_xxaqdjbh" value="1">第一级&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_xxaqdjbh=='2' }">checked="checked"</c:if>  name="update_hospital_xxaqdjbh" value="2">第二级&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_xxaqdjbh=='3' }">checked="checked"</c:if>  name="update_hospital_xxaqdjbh" value="3">第三级&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_xxaqdjbh=='4' }">checked="checked"</c:if>  name="update_hospital_xxaqdjbh" value="4">第四级&nbsp;&nbsp;
					<input type="radio" <c:if test="${map.hospital_xxaqdjbh=='99' }">checked="checked"</c:if>  name="update_hospital_xxaqdjbh" value="99">无
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				信息安全等级保护证书编号
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_hospital_xxaqdjbhbh" class="col-xs-12" data-validate="" value="${map.hospital_xxaqdjbhbh}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				开办资金金额数
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_hospital_kbzjjes" class="col-xs-12" data-validate="required:请输入开办资金金额数！,double:请输入数字！" value="${map.hospital_kbzjjes}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				法人代表/负责人
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_hospital_frdb" class="col-xs-12" data-validate="required:请输入法人代表/负责人！" value="${map.hospital_frdb}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				机构所在地民族自治地方标志
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right"> 
					<input style="margin-top: 10px;" type="radio" <c:if test="${empty map.hospital_jgszdmzzzdfbz or map.hospital_jgszdmzzzdfbz=='2' }">checked="checked"</c:if>   name="update_hospital_jgszdmzzzdfbz" value="2">否
					<input type="radio" name="update_hospital_jgszdmzzzdfbz" value="1" <c:if test="${map.hospital_jgszdmzzzdfbz=='2' }">checked="checked"</c:if>>是&nbsp;&nbsp;
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				是否分支机构
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right"> 
				<input style="margin-top: 10px;" type="radio" <c:if test="${empty map.hospital_sffzjg or map.hospital_sffzjg=='2' }">checked="checked"</c:if>   name="update_hospital_sffzjg" value="2">否
					<input type="radio" name="update_hospital_sffzjg" value="1" <c:if test="${map.hospital_sffzjg=='1' }">checked="checked"</c:if>>是
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				机构第二名称
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_hospital_jgdemc" class="col-xs-12"  value="${map.hospital_jgdemc}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				撤销标志
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<select id="update_hospital_cxbz" class="col-xs-12" data-validate="required:不能为空哦！" >
						<option value="">请选择</option>
						<option value="1" <c:if test="${map.hospital_cxbz=='1'}">selected="selected"</c:if>>正常</option>
						<option value="2" <c:if test="${map.hospital_cxbz=='2'}">selected="selected"</c:if>>已撤销</option>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				电话号码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_hospital_dhhm" class="col-xs-12" data-validate="" value="${map.hospital_dhhm}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				电子信箱
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_hospital_dwdzyx" class="col-xs-12" data-validate="" value="${map.hospital_dwdzyx}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				邮政编码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_hospital_yzbm" class="col-xs-12" data-validate="" value="${map.hospital_yzbm}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				机构描述
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<textarea class="col-xs-12" id="update_hospital_jgms" >${map.hospital_jgms}</textarea>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-7 field">
				<textarea class="col-xs-12" id="beiZhu"  >${map.bz}</textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.hospital_id}')">
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
			$('#update_hospital_pwd').attr('data-validate','required:密码不能为空哦！');
			$('#hospital_pwd').attr('data-validate','required:确认密码不能为空哦！,repeat#hospital_pwd:两次输入的密码不一致');
		}else{
			$('.pass').find('input').attr('data-validate','backTrue:');
			$('.pass').find('input').val('');
			$('.pass').hide();
		}
	});
	function Copy(){
		var str=$('#showUrl').val();
	    var save = function(e){
	        e.clipboardData.setData('text/plain',str);
	        e.preventDefault();
	    }
	    document.addEventListener('copy',save);
	    document.execCommand('copy');
	    document.removeEventListener('copy',save);
	    adminJS.alert({'title':'操作提示','info':'复制成功!'});
	} 
</script>
