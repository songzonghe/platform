<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.icon_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.icon_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${map.icon_name}
		</td>
		<td style="vertical-align: middle;">
			<img src="${map.icon_img}" style="height: 60px;">
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.is_show=='0'}">隐藏</c:if>
			<c:if test="${map.is_show=='1'}">显示</c:if>
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${info.is_outer_chain=='0'}">无链接</c:if>
			<c:if test="${info.is_outer_chain=='1'}">
			<span style="color:red">${info.icon_link}</span>
			</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.icon_id}')">
				编辑
			</button>
		</td>
	</tr>
</table>
