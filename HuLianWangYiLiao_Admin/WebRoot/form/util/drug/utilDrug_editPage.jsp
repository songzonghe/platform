<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  
<link rel="stylesheet" href="${root}/form_util/util/util_css/jquery.searchableSelect.css" />
<style type="text/css">
	.m_w1{
	width: 69px !important;
	margin-right: 10px !important;
	}
	.m_w2{
 width: 85px !important;
 margin-right: 10px !important;
	}
</style>
<div class="widget-main no-padding" style="width: 880px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong></strong> </font>
		</div>
		
		<div class="row">
		   <div class="form-group col-sm-6">
				<label class="col-sm-4 control-label no-padding-right">
					药品名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="药品名称" id="update_drug_name" class="col-xs-12" data-validate="required:药品名称不能为空哦！" value="${map.drug_name}" >
					</span>
				</div>
			</div>
		<div class="form-group col-sm-6">
			<label class="col-sm-2 control-label no-padding-right">
					药品类型
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right" style="width:90%"> 
						<select class="select col-xs-12" id="update_drug_type" onchange="find_uplist()" data-validate="required:用法类型不能为空哦！">
							<option value="">--请选择--</option>
							<option <c:if test="${map.drug_type=='1'}">selected="selected"</c:if> value="1">中药</option>
							<option <c:if test="${map.drug_type=='2'}">selected="selected"</c:if> value="2">西药</option>
							<option <c:if test="${map.drug_type=='3'}">selected="selected"</c:if> value="3">中成药</option>
						</select>
					</span>
				</div>
			</div>
		
		
			<%-- <div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					分类名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<select class="select" id="update_class_id"  data-validate="required:分类名称不能为空哦！">
							<option value="">请选择</option>
							<c:forEach items="${classList}" var="classList">
								<option value="${classList.class_id}">${classList.class_name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div> --%>
			<%-- 	<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					药品频率
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<select class="select" id="update_frequency_id"  data-validate="required:频率名称不能为空哦！">
							<option value="">请选择</option>
							<c:forEach items="${frequencyList}" var="frequencyList">
								<option value="${frequencyList.frequency_id}">${frequencyList.frequency_name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
			 --%>
		</div>
		<div class="row">
		<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					分类名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right" style="width:90%"> 				
						<select class="select" id="update_class_id"  data-validate="required:分类名称不能为空哦！">
							<c:forEach items="${classList}" var="classList">
								<option <c:if test="${map.class_id==classList.class_id}">selected="selected"</c:if> value="${classList.class_id}">${classList.class_name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
			
		<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					药品频率
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"style="width:90%"> 					
						<select class="select" id="update_frequency_id"  data-validate="required:频率名称不能为空哦！">
							<c:forEach items="${frequencyList}" var="frequencyList">
								<option <c:if test="${map.frequency_id==frequencyList.frequency_id}">selected="selected"</c:if> value="${frequencyList.frequency_id}">${frequencyList.frequency_name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
			<!-- <div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品l类型
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<select class="select" id="update_drug_type" onchange="find_usage_type()" data-validate="required:用法类型不能为空哦！">
							<option value="">--请选择--</option>
								<option value="1">中药</option>
								<option value="2">西药</option>
								<option value="3">中成药</option>
						</select>
					</span>
				</div>
			</div> -->
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					用法类型
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right" style="width:90%"> 
						<select class="select" id="update_usage_type" onchange="find_uplist()" data-validate="required:用法类型不能为空哦！">
							<option value="">--请选择--</option>
							<option <c:if test="${map.usage_type=='1'}">selected="selected"</c:if> value="1">西药用法</option>
							<option <c:if test="${map.usage_type=='2'}">selected="selected"</c:if> value="2">中药特殊服用用法</option>
							<option <c:if test="${map.usage_type=='3'}">selected="selected"</c:if> value="3">中药服用方法</option>
							<option <c:if test="${map.usage_type=='4'}">selected="selected"</c:if> value="4">中药服用要求</option>
						</select>
					</span>
				</div>
			</div>
			
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					药品用法
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right" style="width:90%"> 
						<select class="select" id="update_usage_id"  data-validate="required:用法名称不能为空哦！">
							<c:forEach items="${usageList}" var="usageList">
								<option <c:if test="${map.usage_id==usageList.usage_id}">selected="selected"</c:if> value="${usageList.usage_id}">${usageList.usage_name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
			
		</div>
		<div class="row">
		<div class="form-group  col-sm-12 field">
				<!-- <label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;">
					药品规格
				</label> -->
				
				<div class="col-sm-12 field" style="padding-left: 0px !important;">
				<label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;">
					重量：
				</label>
					<span class="block input-icon input-icon-right col-xs-10" style="padding-left: 3px !important;">
					<span class="col-xs-4">
					
						<input type="text" placeholder="重量" id="update_drug_weight_num" class="col-xs-2 m_w1">
						<select class=" col-xs-1 m_w2"  id="update_drug_weight_unit">
							<option value="">请选择</option>
							<c:forEach items="${weightList}" var="weightList">
								<option <c:if test="${map.drug_weight_unit==weightList.usage_name}">selected="selected"</c:if> value="${weightList.usage_name}">${weightList.usage_name}</option>
							</c:forEach>
						</select>
					</span>
					<span class="col-xs-8" style="padding-left: 29px !important;">
					<label class="col-sm-3 control-label no-padding-right" style="margin-left: -5px;">
					体积：
				   </label>
						<input type="text" placeholder="体积" id="update_drug_volume_num" class="col-xs-2 m_w1">
						<select class=" col-xs-1 m_w2"  id="update_drug_volume_unit">
							<option value="">请选择</option>
							<c:forEach items="${volumeList}" var="volumeList">
								<option <c:if test="${map.drug_volume_unit==volumeList.usage_name}">selected="selected"</c:if> value="${volumeList.usage_name}">${volumeList.usage_name}</option>
							</c:forEach>
						</select>
					</span>
				
					</span>
					
		       <span class="col-xs-12" style="margin-top: 10px;">
				   <label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;">
					包装量：
				   </label>
						<span style="float:left;width: 15px;text-align: center;display: inline-block;">*</span>
						<input type="text" placeholder="包装量" id="update_drug_packaging_num" class="col-xs-2 m_w1" data-validate="required:包装量不能为空哦！" value="${map.drug_packaging_num}">
					<label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;width: 80px">
					包装单位：
				   </label>
						<select class=" col-xs-1 m_w2"  id="update_drug_smallest_unit"  data-validate="required:最小单位不能为空哦！">
							<option value="">请选择</option>
							<c:forEach items="${smallestList}" var="smallestList">
								<option <c:if test="${map.drug_smallest_unit==smallestList.usage_name}">selected="selected"</c:if> value="${smallestList.usage_name}">${smallestList.usage_name}</option>
							</c:forEach>
						</select>
					<!-- 	<span  style="float:left;width: 15px;text-align: center;display: inline-block;">/</span> -->
					<label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;width: 80px">
					最小单位：
				   </label>	
						<select class=" col-xs-1 m_w2"  id="update_drug_packaging_unit"  data-validate="required:包装单位不能为空哦！">
							<option value="">请选择</option>
							<c:forEach items="${packagingList}" var="packagingList">
								<option <c:if test="${map.drug_packaging_unit==packagingList.usage_name}">selected="selected"</c:if> value="${packagingList.usage_name}">${packagingList.usage_name}</option>
							</c:forEach>
						</select>
					</span>			
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药监码
				</label>
				<div class="col-sm-6 field">
					<input type="text" placeholder="药监码" id="update_drug_number" class="col-xs-12 nonessential" value="${map.drug_number}">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品英文名称
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="药品英文名称" id="update_drug_usname" class="col-xs-12 nonessential" >
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					药品公司
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right" style="width:90%"> 
						<select class="select" id="update_drug_company">
							<option value="">请选择</option>
							<c:forEach items="${companyList}" var="companyList">
								<option <c:if test="${map.drug_company==companyList.log_name}">selected="selected"</c:if> value="${companyList.log_name}">${companyList.log_name}</option>
							</c:forEach>
						</select>
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品主图
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<div class="field">
						<a href="javascript:;" class="file">
							<c:if test="${empty map.drug_img}">
								<img src="${root}/form_util/util/images/upload.png" name="uploadNameImg" id="update_drug_img" class="radius" width="80px" height="80px">
							</c:if>
							<c:if test="${!empty map.drug_img}"><img src="${map.drug_img}" name="uploadNameImg" id="update_drug_img" class="radius" width="80px" height="80px">
							</c:if>
							<input type="file" id="update_drug_img_file" name="uploadName" onclick="$('#isUpdate').attr('value','y');" onchange="uploadImg('update_drug_img',0,0)">
						</a>
						<button style="margin: -30px 0px 0px 10px;" type="button" class="btn btn-white btn-default btn-round" onclick="imgCancel('update_drug_img');">
							<i class="ace-icon fa fa-times red2"></i> 清除
						</button>
					</div>
					</span>
				</div>
			</div>
			
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					药品单位
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						<input type="text" placeholder="药品单位" id="update_drug_unit" class="col-xs-12 " data-validate="required:药品单位不能为空哦！" value="${map.drug_unit}" >
					</span>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					药品价格
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="药品价格" id="update_drug_price" class="col-xs-12 nonessential" data-validate="required:药品价格不能为空哦！" value="${map.drug_price}" >
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					计量单位
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="计量单位" id="update_drug_maxdosage" class="col-xs-12" data-validate="required:最大用量 计量单位不能为空哦！" value="${map.drug_maxdosage}" >
					</span>
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					是否处方
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
					<input style="margin-top: 10px;" type="radio" <c:if test="${map.drug_is_rx=='0'}">checked="checked"</c:if> name="update_drug_is_rx" value="0" >非处方药&nbsp;&nbsp;
					<input type="radio" name="update_drug_is_rx" value="1" <c:if test="${map.drug_is_rx=='1'}">checked="checked"</c:if> onclick="$('#isUpdate').attr('value','y')">处方药
					</span>
				</div>
			</div>
			
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					最小单位
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="最小单位" id="update_drug_maxdosage2" class="col-xs-12 nonessential" value="${map.drug_maxdosage2}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					补充单位
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="补充单位" id="update_drug_maxdosage3" class="col-xs-12 nonessential" value="${map.drug_maxdosage3}" >
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					最大频率
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="最大频率" id="update_drug_maxfrequency" class="col-xs-12 nonessential"  value="${map.drug_maxfrequency}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					最大天数
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="最大天数" id="update_drug_maxday" class="col-xs-12 nonessential"  value="${map.drug_maxday}" >
					</span>
				</div>
			</div>
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					标注
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="标注" id="update_drug_tagging" class="col-xs-12 nonessential"  value="${map.drug_tagging}" >
					</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					使用年龄限制
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="使用年龄限制" id="update_drug_age_limit" class="col-xs-12 nonessential" data-validate="required:使用年龄限制不能为空哦！" value="${map.drug_age_limit}" >
					</span>
				</div>
			</div>
			
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					剂型
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="剂型" id="update_drug_agen" class="col-xs-12" list="dataListForSelect" onchange="getAgen()" value="${map.drug_agen}">
							<dataList  id="dataListForSelect">
								<c:forEach items="${agenList}" var="agenList">
									<option class="datalist"  value="${agenList.agen_id}-${agenList.code_e_name}" data-id="${agenList.agen_id}"  data-value="${agenList.agen_name}">${agenList.agen_name}</option>
								</c:forEach>  
	                       </dataList>                       
					</span>
				</div>
			</div>
			
		</div>
		
		<div class="row">
			<div class="form-group col-sm-6 field">
				<label class="col-sm-4 control-label no-padding-right">
					限制类别
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
						  <input type="hidden" placeholder="限制类别" id="update_yb_limit_cate1" class="col-xs-12 nonessential" value="${map.yb_limit_cate}">
							<select  id="update_yb_limit_cate" class="col-xs-12 nonessential">
								<option value="">---</option>
								<option value="限二级及以上医院">限二级及以上医院</option>
        						<option value="限二级及以上医院+限支付范围">限二级及以上医院+限支付范围</option>
						        <option value="限制门诊和药店">限制门诊和药店</option>
						        <option value="限制门诊药店">限制门诊药店</option>
						        <option value="限支付范围">限支付范围</option>
						        <option value="限住院">限住院</option>
							</select>	
					</span>
				</div>
			</div>
			
			<div class="form-group col-sm-6 field">
				<label class="col-sm-2 control-label no-padding-right">
					限制范围
				</label>
				<div class="col-sm-6 field">
					<span class="block input-icon input-icon-right"> 
							<input type="text" placeholder="限制范围" id="update_yb_limit_range" class="col-xs-12 nonessential" value="${map.yb_limit_range}">
					</span>
				</div>
			</div>	
			
		</div>
		
		
		

		<div class="row">
			<div class="form-group col-sm-12">
				<label class="col-sm-2 control-label no-padding-right" style="margin-left: -5px;">
					药品说明书
				</label>
				<div class="col-sm-10">
					<span class="block input-icon input-icon-right"> 
							<!--  <textarea class="col-xs-12" id="update_drug_instructions" placeholder="药品说明书" ></textarea>-->
							<textarea class="col-xs-12" id="update_drug_instructions" placeholder="药品说明书" >${map.drug_instructions}</textarea>
					</span>
				</div>
			</div>
		</div>
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv()">
				返回
				<i class="ace-icon fa fa-arrow-left icon-on-right bigger-110"></i>
			</button>
			<button type="submit" class="btn btn-sm btn-success" onclick="editDataValidate('${map.drug_id}')">
				提交
				<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
			</button>
		</div>
	</form>
</div>
<script>
	initValidate();
	 var update_yb_limit_cate=$("#update_yb_limit_cate1").val();
	 if(update_yb_limit_cate!=null&&update_yb_limit_cate.trim()!=''){
	        $("#update_yb_limit_cate option[value='"+update_yb_limit_cate+"']").attr("selected", true);
	    }
</script>
<script type="text/javascript" src="${root}/form_util/util/sys_js/jquery.searchableSelect.js?<%=Math.random()%>"></script>
