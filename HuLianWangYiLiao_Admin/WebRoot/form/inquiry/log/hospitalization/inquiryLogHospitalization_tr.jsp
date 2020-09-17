<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.hospitalization_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.hospitalization_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${map.log_id}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.join_type=='1'}">个人</c:if>
			<c:if test="${map.join_type=='2'}">门店</c:if>
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
			${map.hospitalization_hospital}
		</td>
		<td style="vertical-align: middle;">
			${map.hospitalization_department}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.hospitalization_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.hospitalization_id}','${map.hospitalization_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
