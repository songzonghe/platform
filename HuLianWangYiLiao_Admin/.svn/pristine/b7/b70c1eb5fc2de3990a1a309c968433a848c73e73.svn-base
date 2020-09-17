<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/form_util/page/root.jsp"%>
<c:if test="${empty listMap}">
	<tr align="center">
		<td colspan="5">
			没有查询到数据
		</td>
	</tr>
</c:if>
<c:forEach items="${listMap}" varStatus="i" var="info">
	<tr id="tr${data.findType+1}${info.checklist_class_id}" class="" data-id="${info.checklist_class_id}">
		<td index="tdIndex" style="vertical-align: middle;" <c:if test="${data.findType !=2}"> onclick="selectData('${data.findType+1}','${info.checklist_class_id}')"</c:if>>
			${i.index+1}
		</td>
		<td style="vertical-align: middle;" <c:if test="${data.findType !=2}"> onclick="selectData('${data.findType+1}','${info.checklist_class_id}')"</c:if>>
			${info.checklist_class_name}
		</td>
		<td style="vertical-align: middle;" <c:if test="${data.findType !=2}"> onclick="selectData('${data.findType+1}','${info.checklist_class_id}')"</c:if>>
			${info.checklist_class_sort}
		</td>
		<td style="vertical-align: middle; text-align: center;">
			<i class="fa fa-eye" style="font-size: 18px;color: #1a83de;" onclick="openlookInfo('${info.checklist_class_id}','${info.checklist_class_name}')"></i>&nbsp;&nbsp;
		</td>
		<td style="vertical-align: middle;">
			<i class="fa fa-pencil-square-o" style="font-size: 18px;color: #1a83de;" onclick="openEditPage('${data.findType+1}','${info.checklist_class_id}')"></i>&nbsp;&nbsp;
			<i class="fa fa-trash-o" style="font-size: 18px;color: red" onclick="confirmDeleteDate('${data.findType+1}','${info.checklist_class_id}')"></i>
		</td>
	</tr>
</c:forEach>
