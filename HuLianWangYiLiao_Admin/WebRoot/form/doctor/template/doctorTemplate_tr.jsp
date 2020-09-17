<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.template_id}">
<input id="updateBackInfo" style="display: none;" value="${map.backInfo}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.template_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${map.doctor_name}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.template_type=='1'}">主诉</c:if>
			<c:if test="${map.template_type=='2'}">现病史</c:if>
			<c:if test="${map.template_type=='3'}">既往史</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.template_name}
		</td>
		<td style="vertical-align: middle;">
			${map.template_details}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.template_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.template_id}','${map.template_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
