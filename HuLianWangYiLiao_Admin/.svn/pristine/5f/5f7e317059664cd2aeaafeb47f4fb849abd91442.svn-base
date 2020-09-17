<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.checklist_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.checklist_id}" isOpen="${map.trIsOpen}">
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			<img style="cursor: pointer;" id="img${map.checklist_id}"
				onclick="mainDetail('${map.checklist_id}')" isOpen="${map.imgIsOpne}"
				src="${map.imgSrc}">
		</td>
		
		<td style="vertical-align: middle;">
			${map.hospital_id}
		</td>
		<td style="vertical-align: middle;">
			${map.log_id}
		</td>
		<td style="vertical-align: middle;">
			${map.join_type}
		</td>
		<td style="vertical-align: middle;">
			${map.join_id}
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_id}
		</td>
		<td style="vertical-align: middle;">
			${map.doctor_id}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_name}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_code}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.checklist_type=='1'}">普通建议单</c:if>
			<c:if test="${map.checklist_type=='2'}">心电检验单</c:if>
			<c:if test="${map.checklist_type=='3'}">普通检验单</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_last_code}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_abstract}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_sbp}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_dbp}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.is_digitalization=='0'}">否</c:if>
			<c:if test="${map.is_digitalization=='1'}">是</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_digitalization_num}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_digitalization_start}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_digitalization_end}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.is_other_drugs=='0'}">否</c:if>
			<c:if test="${map.is_other_drugs=='1'}">是</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_other_drugs_name}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_other_drugs_start}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_other_drugs_end}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_other_drugs_num}
		</td>
		<td style="vertical-align: middle;">
			${map.checklist_inspection_result}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.checklist_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.checklist_id}','${map.checklist_id}')" title="删除">
				删除
			</button>
			<button class="btn btn-xs btn-primary" title="问诊记录检验检查单详情" onclick="add_inquiryLogChecklistDetailsPage('${map.checklist_id}')" ><i class="ace-icon fa fa-plus bigger-120"></i>
			</button>
		</td>
	</tr>
</table>
