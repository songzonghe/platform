<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty listMap}">
	<tr align="center">
		<td colspan="100">没有查询到数据</td>
	</tr>
</c:if>
<c:forEach items="${listMap}" varStatus="i" var="map">
	<tr id="tr${map.checklist_id}">
		<td index="tdIndex">${i.index+1}</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.checklist_type=='1'}">检验</c:if>
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
</c:forEach>
<tr align="center" id="pageContainer">
	<td colspan="10">
		<c:set var="cx" value="searchOpenPage" />
		<c:set var="data_id" value="sortData" />
		<%@include file="/form_util/page/detailPage.jsp"%>
	</td>
</tr>