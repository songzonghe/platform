<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.dictionaries_data_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.dictionaries_data_id}">
		<td index="tdIndex" style="vertical-align: middle;">
			${i.index+1}
		</td>
		<td style="vertical-align: middle;">
			${info.dictionaries_data_code}
		</td>
		<td style="vertical-align: middle;">
			${info.dictionaries_data_name}
		</td>
		<td style="vertical-align: middle;">
			${info.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${info.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" onclick="openEditPage('${info.dictionaries_data_id}')" title="编辑">
				编辑
			</button>
			<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.dictionaries_data_id}','${info.dictionaries_data_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
