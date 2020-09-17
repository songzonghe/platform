<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.notice_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.notice_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${map.notice_type}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.user_type=='1'}">用户</c:if>
			<c:if test="${map.user_type=='2'}">门店</c:if>
			<c:if test="${map.user_type=='3'}">医生</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.user_id}
		</td>
		<td style="vertical-align: middle;">
			${map.notice_title}
		</td>
		<td style="vertical-align: middle;">
			${map.notice_content}
		</td>
		<td style="vertical-align: middle;">
			${map.notice_join}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.notice_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.notice_id}','${map.notice_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
