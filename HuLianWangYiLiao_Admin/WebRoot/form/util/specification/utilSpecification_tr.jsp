<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.specification_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.specification_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${map.specification_name}
		</td>
		<td style="vertical-align: middle;">
			${map.specification_details}
		</td>
		<td style="vertical-align: middle;">
			${map.specification_sort}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.specification_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.specification_id}','${map.specification_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
