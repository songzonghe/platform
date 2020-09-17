<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.note_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.note_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${info.old_doctor_name}
		</td>
		<td style="vertical-align: middle;">
			${info.doctor_name}
		</td>
		<td style="vertical-align: middle;">
			${info.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${info.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.note_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.note_id}','${map.note_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
