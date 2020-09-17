<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.frequency_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.frequency_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${map.frequency_name}
		</td>
		<td style="vertical-align: middle;">
			${map.frequency_printing_name}
		</td>
		<td style="vertical-align: middle;">
			${map.frequency_num}
		</td>
		<td style="vertical-align: middle;">
			${map.frequency_day_num}
		</td>
		<td style="vertical-align: middle;">
			${map.frequency_sort}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.frequency_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.frequency_id}','${map.frequency_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
