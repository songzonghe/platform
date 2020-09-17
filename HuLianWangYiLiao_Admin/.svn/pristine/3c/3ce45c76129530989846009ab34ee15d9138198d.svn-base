<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.diagnosis_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.diagnosis_id}">
		<td index="tdIndex" style="vertical-align: middle;">
			${i.index+1}
		</td>
		<td style="vertical-align: middle;">
			${info.icd_name}
		</td>
		<td style="vertical-align: middle;">
			${info.diagnosis_name}
		</td>
		<td style="vertical-align: middle;">
			${info.doctor_name}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${info.diagnosis_sex=='1'}">男</c:if>
			<c:if test="${info.diagnosis_sex=='2'}">女</c:if>
			<c:if test="${info.diagnosis_sex=='3'}">不限制</c:if>
		</td>
		<td style="vertical-align: middle;">
			${info.diagnosis_dage}
		</td>
		<td style="vertical-align: middle;">
			${info.diagnosis_tage}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${info.is_restriction=='0'}">否</c:if>
			<c:if test="${info.is_restriction=='1'}">是</c:if>
		</td>
		<td style="vertical-align: middle;">
			${info.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${info.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" onclick="openEditPage('${info.diagnosis_id}')" title="编辑">
				编辑
			</button>
			<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.diagnosis_id}','${info.diagnosis_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
