<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.scheduling_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.scheduling_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${map.doctor_id}
		</td>
		<td style="vertical-align: middle;">
			${map.scheduling_date}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.is_morning=='0'}">否</c:if>
			<c:if test="${map.is_morning=='1'}">是</c:if>
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.is_afternoon=='0'}">否</c:if>
			<c:if test="${map.is_afternoon=='1'}">是</c:if>
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.is_night=='0'}">否</c:if>
			<c:if test="${map.is_night=='1'}">是</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.scheduling_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.scheduling_id}','${map.scheduling_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
