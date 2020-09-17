<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.questions_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.questions_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${info.questions_type=='1'}">用户端</c:if>
			<c:if test="${info.questions_type=='2'}">医生端</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.questions}
		</td>
		<td style="vertical-align: middle;">
			${map.frequently}
		</td>
		<td style="vertical-align: middle;">
			${map.sort}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.questions_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.questions_id}','${map.questions_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
