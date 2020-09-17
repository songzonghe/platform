<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.img_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.img_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${info.log_id}
		</td>
		<td style="vertical-align: middle;">
			<img src="${info.img_src}" style="height: 60px;">
		</td>
		<td style="vertical-align: middle;">
			${info.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${info.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.img_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.img_id}','${map.img_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
