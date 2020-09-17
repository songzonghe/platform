<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.class_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.class_id}" isOpen="${map.trIsOpen}">
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<%-- <td style="vertical-align: middle;">
			<img style="cursor: pointer;" id="img${map.class_id}"
				onclick="mainDetail('${map.class_id}')" isOpen="${map.imgIsOpne}"
				src="${map.imgSrc}">
		</td> --%>
		<td style="vertical-align: middle;">
			${map.class_name}
		</td>
		<td style="vertical-align: middle;">
			${map.class_sort}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.class_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.class_id}','${map.class_id}')" title="删除">
				删除
			</button>
			<%-- <button class="btn btn-xs btn-primary" title="药品" onclick="add_utilDrugPage('${map.class_id}')" ><i class="ace-icon fa fa-plus bigger-120"></i>
			</button> --%>
		</td>
	</tr>
</table>
