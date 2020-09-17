<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.checklist_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.checklist_id}">
		<td index="tdIndex">${i.index+1}</td>
		<td style="vertical-align: middle;">
			<<c:if test="${map.checklist_type=='1'}">检验</c:if>
			<c:if test="${map.checklist_type=='2'}">检查</c:if>
			<c:if test="${map.checklist_type=='3'}">心电检验</c:if>
			<c:if test="${map.checklist_type=='4'}">普通检验</c:if>
		</td>
		<td style="vertical-align: middle;">${map.checklist_name}</td>
		<td style="vertical-align: middle;">${map.checklist_sort}</td>
		<td style="vertical-align: middle;">${map.gxsj}</td>
		<td style="vertical-align: middle;">${map.bz}</td>
		<td style="vertical-align: middle;"><div
				class="hidden-sm hidden-xs btn-group">
				<button class="btn btn-xs btn-info"
					onclick="openEditPage_utilChecklist('${map.checklist_id}')"
					title="编辑">编辑</button>
				<button class="btn btn-xs btn-danger"
					onclick="confirmDeleteDate_utilChecklist('${map.checklist_id}','${map.checklist_class_id}')"
					title="删除">删除</button>
			</div></td>
	</tr>
</table>
