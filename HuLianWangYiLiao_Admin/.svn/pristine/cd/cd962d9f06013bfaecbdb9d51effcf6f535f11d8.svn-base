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
				机构代码
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="机构代码" id="update_department_jgdm" class="col-xs-12" value="${map.department_jgdm}" data-validate="required:不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				标准科室代码
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<select id="update_department_bzksdm" class="col-xs-12" data-validate="required:不能为空哦！">
						<option value="">请选择</option>
						<c:forEach var="datas" items="${allList.list009}">
							<option value="${datas.code}" <c:if test="${map.department_bzksdm==datas.code}">selected="selected"</c:if>>${datas.name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				医保局代码
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="医保局代码" id="update_department_ybjdm" class="col-xs-12" value="${map.department_ybjdm}" data-validate="required:不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				科室简介
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="科室简介" id="update_department_ksjs" class="col-xs-12" data-validate="required:不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				科室名称
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="科室名称" id="update_department_name" class="col-xs-12" data-validate="required:不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				科室排序
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="科室排序" id="update_department_sort" class="col-xs-12" data-validate="required:不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				科室编码
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<input type="text" placeholder="科室编码" id="update_department_ksmm" class="col-xs-12" data-validate="required:不能为空哦！">
				</span>
			</div>
		</div>
		<div class="form-group field">
			<label class="col-sm-3 control-label no-padding-right">
				撤销标志
			</label>
			<div class="col-sm-5">
				<span class="block input-icon input-icon-right">
					<select id="update_equipment_cxbz" class="col-xs-12" data-validate="required:不能为空哦！" >
							<option value="">请选择</option>
							<option value="1" <c:if test="${map.equipment_cxbz=='1'}">selected="selected"</c:if>>正常</option>
							<option value="2" <c:if test="${map.equipment_cxbz=='2'}">selected="selected"</c:if>>已撤销</option>
						</select> 
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
