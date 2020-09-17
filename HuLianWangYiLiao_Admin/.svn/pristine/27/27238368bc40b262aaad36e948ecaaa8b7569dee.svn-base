<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.option_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.option_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.option_type=='1'}">最小单位</c:if>
			<c:if test="${map.option_type=='2'}">包装单位</c:if>
			<c:if test="${map.option_type=='3'}">重量单位</c:if>
			<c:if test="${map.option_type=='4'}">体积单位 </c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.usage_name}
		</td>
		<td style="vertical-align: middle;">
			${map.usage_sort}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.option_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.option_id}','${map.option_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
