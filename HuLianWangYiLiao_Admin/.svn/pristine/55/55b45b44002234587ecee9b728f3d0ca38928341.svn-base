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
				账号
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="账号" readonly="readonly" class="col-xs-12" value="${map.store_phone}">
				</span>
			</div>
		</div>
		<div class="form-group field ">
			<label class="col-sm-3 control-label no-padding-right">
				<input type="checkbox" id="is_edit" value="1">密码
			</label>
			<div class="col-sm-7 field pass">
				<span class="block input-icon input-icon-right">
					<input type="password"  id="update_store_paw" name="store_paw" class="col-xs-12" data-validate="required:请输入密码！" value="" >
				</span>
			</div>
		</div>
		
		<div class="form-group field pass">
			<label class="col-sm-3 control-label no-padding-right">
				确认密码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="password" id="store_paw" class="col-xs-12" data-validate="required:请输入确认密码！,repeat#store_paw:两次输入的密码不一致">
				</span>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-3 control-label no-padding-right">
				机构标识
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="机构标识" id="update_store_jgdm" class="col-xs-12" data-validate="required:机构标识不能为空哦！" value="${map.store_jgdm}" >
				</span>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-3 control-label no-padding-right">
				门店名称
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="门店名称" id="update_store_name" class="col-xs-12" data-validate="required:门店名称不能为空哦！" value="${map.store_name}" >
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				门店头像
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<div class="field">
						<a href="javascript:;" class="file">
							<c:if test="${empty map.store_img}">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_store_img" class="radius" width="80px" height="80px">
							</c:if>
							<c:if test="${!empty map.store_img}"><img src="${map.store_img}" name="uploadNameImg" id="update_store_img" class="radius" width="80px" height="80px">
							</c:if>
							<input type="file" id="update_store_img_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_store_img',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_store_img');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
				</span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				服务网点代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_store_fwwddm" class="col-xs-12" data-validate="required:服务网点代码不能为空哦！" value="${map.store_fwwddm}" >
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				行政区划代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_store_xzqhdm" class="col-xs-12" data-validate="required:行政区划代码不能为空哦！" value="${map.store_xzqhdm}" >
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				服务点类型
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<select id="update_store_fwdlx" class="col-xs-12" >
						<option value="">请选择</option>
						<option value="01" <c:if test="${map.store_fwdlx=='01'}">selected="selected"</c:if>>互联网医院诊疗</option>
						<option value="02" <c:if test="${map.store_fwdlx=='02'}">selected="selected"</c:if>>健康管理服务</option>
						<option value="03" <c:if test="${map.store_fwdlx=='03'}">selected="selected"</c:if>>药事服务机构</option>
						<option value="04" <c:if test="${map.store_fwdlx=='04'}">selected="selected"</c:if>>药房</option>
						<option value="05" <c:if test="${map.store_fwdlx=='05'}">selected="selected"</c:if>>社区中心</option>
						<option value="06" <c:if test="${map.store_fwdlx=='06'}">selected="selected"</c:if>>其他</option>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				成立日期
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_store_fwdclrq" class="col-xs-12 Wdate" data-validate="required:成立日期不能为空哦！" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${map.store_fwdclrq}" >
				</span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				单位隶属关系代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<select id="update_store_dwlsgxdm" class="col-xs-12" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach var="datas" items="${allList.list005}">
							<option value="${datas.code}" <c:if test="${map.store_dwlsgxdm==datas.code}">selected="selected"</c:if>>${datas.name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				服务点分类管理类别代码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<select id="update_store_fwdflgllbdm" class="col-xs-12">
						<option value="">请选择</option>
						<c:forEach var="datas" items="${allList.list006}">
							<option value="${datas.code}" <c:if test="${map.store_fwdfldm==datas.code}">selected="selected"</c:if>>${datas.name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				服务点分类代码
			</label>
			<div class="col-sm-7 field">
				<select id="update_store_fwdfldm" class="col-xs-12" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach var="datas" items="${allList.list007}">
							<option value="${datas.code}" <c:if test="${map.store_fwdfldm==datas.code}">selected="selected"</c:if>>${datas.name}</option>
						</c:forEach>
					</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				经济类型代码
			</label>
			<div class="col-sm-7 field">
				<select id="update_store_fwdfldm" class="col-xs-12" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach var="datas" items="${allList.list008}">
							<option value="${datas.code}" <c:if test="${map.store_fwdfldm==datas.code}">selected="selected"</c:if>>${datas.name}</option>
						</c:forEach>
					</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				地址
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="地址"  id="update_store_dz" class="col-xs-12" data-validate="required:地址不能为空哦！" value="${map.store_dz}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				服务点医院级别
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<select id="update_store_fwdyyjb" class="class" data-validate="required:服务点医院级别不能为空哦！">
						<option value="">请选择</option>
						<option value="0"  <c:if test="${map.store_fwdyyjb=='0'}">selected="selected"</c:if>>基层卫生服务站</option>
						<option value="1" <c:if test="${map.store_fwdyyjb=='1'}">selected="selected"</c:if>>一级医院</option>
						<option value="2" <c:if test="${map.store_fwdyyjb=='2'}">selected="selected"</c:if>>二级医院</option>
						<option value="3" <c:if test="${map.store_fwdyyjb=='3'}">selected="selected"</c:if>>三级医院</option>
						<option value="4" <c:if test="${map.store_fwdyyjb=='4'}">selected="selected"</c:if>>未定级</option>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				服务点医院等级
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<select id="update_store_fwdyydj" class="class" data-validate="required:服务点医院等级不能为空哦！">
						<option value="">请选择</option>
						<option value="0"  <c:if test="${map.store_fwdyydj=='0'}">selected="selected"</c:if>>甲等</option>
						<option value="1" <c:if test="${map.store_fwdyydj=='1'}">selected="selected"</c:if>>乙等</option>
						<option value="2" <c:if test="${map.store_fwdyydj=='2'}">selected="selected"</c:if>>丙等</option>
						<option value="3" <c:if test="${map.store_fwdyydj=='3'}">selected="selected"</c:if>>未定</option>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				许可证号码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_store_xkzhm" class="col-xs-12" data-validate="required:许可证号码不能为空哦！" value="${map.store_xkzhm}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				许可证名称
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_store_xkxmmc" class="col-xs-12" data-validate="required:许可证名称等级不能为空哦！" value="${map.store_xkxmmc}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				许可证有效期
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_store_xkzyxq" class="col-xs-12" data-validate="required:许可证有效期不能为空哦！" value="${map.store_xkxmmc}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				开办资金金额数
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text" id="update_store_kbzjjes" class="col-xs-12" data-validate="double:请输入数字" value="${map.store_kbzjjes}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				法人代表/负责人
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"  id="update_store_frdb" class="col-xs-12" data-validate="" value="${map.store_frdb}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				服务点所在地民族自治地方标志
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input style="margin-top: 10px;"  type="radio" <c:if test="${map.store_fwdszdmzzzdfbz=='1'}">checked="checked"</c:if> name="update_store_fwdszdmzzzdfbz" value="1">是&nbsp;&nbsp;
					<input type="radio"  name="update_store_fwdszdmzzzdfbz"<c:if test="${map.store_fwdszdmzzzdfbz=='2'}">checked="checked"</c:if> value="2">否
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				是否分支机构
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right"> 
					<input style="margin-top: 10px;" data-validate="required:不能为空哦！" type="radio" <c:if test="${map.store_sffzjg=='0'}">checked="checked"</c:if> name="update_store_sffzjg" value="0">是&nbsp;&nbsp;
					<input type="radio" data-validate="required:不能为空哦！" name="update_store_sffzjg" <c:if test="${map.store_sffzjg=='1'}">checked="checked"</c:if> value="1">否
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				服务点第二名称
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"   id="update_store_fwddemc" class="col-xs-12" data-validate="" value="${map.store_fwddemc}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				服务点描述
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"   id="update_store_fwdms" class="col-xs-12" data-validate="" value="${map.store_fwdms}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				邮政编码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"   id="update_store_yzbm" class="col-xs-12" data-validate="" value="${map.store_yzbm}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				电话号码
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"   id="update_store_dhhm" class="col-xs-12" data-validate="" value="${map.store_dhhm}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				电子信箱
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<input type="text"   id="update_store_dwdzyx" class="col-xs-12" data-validate="" value="${map.store_dwdzyx}">
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				撤销标志
			</label>
			<div class="col-sm-7 field">
				<span class="block input-icon input-icon-right">
					<select id="update_store_cxbz" class="class" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<option value="1" <c:if test="${map.store_cxbz=='1'}">selected="selected"</c:if>>正常</option>
						<option value="2" <c:if test="${map.store_cxbz=='2'}">selected="selected"</c:if>>已撤销</option>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right">
				备注
			</label>
			<div class="col-sm-7 field">
				<textarea class="col-xs-12" id="beiZhu" placeholder="备注" >${map.bz}</textarea>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.store_id}')">
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
			$('#update_store_paw').attr('data-validate','required:密码不能为空哦！');
			$('#store_paw').attr('data-validate','required:确认密码不能为空哦！,repeat#store_paw:两次输入的密码不一致');
		}else{
			$('.pass').find('input').attr('data-validate','backTrue:');
			$('.pass').find('input').val('');
			$('.pass').hide();
		}
	});
</script>
