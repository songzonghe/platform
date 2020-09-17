<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.usage_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.usage_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${info.usage_type=='1'}">西药用法</c:if>
			<c:if test="${info.usage_type=='2'}">中药特殊服用用法</c:if>
			<c:if test="${info.usage_type=='3'}">中药服用方法</c:if>
			<c:if test="${info.usage_type=='4'}">中药服用要求</c:if>
		</td>
		<td style="vertical-align: middle;">
			${info.usage_name}
		</td>
		<td style="vertical-align: middle;">
			${info.usage_printing_name}
		</td>
		<td style="vertical-align: middle;">
			${info.usage_sort}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.usage_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.usage_id}','${map.usage_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
