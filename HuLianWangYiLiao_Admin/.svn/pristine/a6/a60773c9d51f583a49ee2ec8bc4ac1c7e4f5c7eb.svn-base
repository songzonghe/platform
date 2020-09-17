<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/form_util/page/root.jsp"%>
<tr id="tr${data.findType}${info.checklist_class_id}" class="" data-id="${info.checklist_class_id}">
	<td index="tdIndex" style="vertical-align: middle;" <c:if test="${data.findType !=3}"> onclick="selectData('${data.findType}','${info.checklist_class_id}')"</c:if>>
		
	</td>
	<td style="vertical-align: middle;" <c:if test="${data.findType !=3}"> onclick="selectData('${data.findType}','${info.checklist_class_id}')"</c:if>>
		${info.checklist_class_name}
	</td>
	<td style="vertical-align: middle;" <c:if test="${data.findType !=3}"> onclick="selectData('${data.findType}','${info.checklist_class_id}')"</c:if>>
		${info.checklist_class_sort}
	</td>
	<td style="vertical-align: middle; text-align: center;">
		<i class="fa fa-eye" style="font-size: 18px;color: #1a83de;" onclick="openlookInfo('${info.checklist_class_id}','${info.checklist_class_name}')"></i>&nbsp;&nbsp;
	</td>
	<td style="vertical-align: middle;">
		<i class="fa fa-pencil-square-o" style="font-size: 18px;color: #1a83de;" onclick="openEditPage('${data.findType}','${info.checklist_class_id}')"></i>&nbsp;&nbsp;
		<i class="fa fa-trash-o" style="font-size: 18px;color: red" onclick="selectData('${data.findType}','${info.checklist_class_id}')"></i>
	</td>
</tr>
