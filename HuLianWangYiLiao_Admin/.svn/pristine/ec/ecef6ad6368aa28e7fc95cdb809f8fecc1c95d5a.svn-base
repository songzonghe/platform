<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.user_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.user_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${info.user_phone}
		</td>
<!--		
		<td style="vertical-align: middle;">
			${info.user_openid}
		</td>
 -->		
		<td style="vertical-align: middle;">
			${info.user_nickname}
		</td>
		<td style="vertical-align: middle;">
			<img src="${info.user_img}" style="height: 60px;">
		</td>
		<td style="vertical-align: middle;">
			${info.user_name}
		</td>
		<td style="vertical-align: middle;">
			正面：<img src="${info.user_document_img1}" style="height: 60px;"><br>
			反面：<img src="${info.user_document_img2}" style="height: 60px;">
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.user_id}','1')">
				编辑
			</button>
			<button class="btn btn-xs btn-info" onclick="openEditPage('${info.user_id}','2')" title="重置密码">
				重置密码
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.user_id}','${map.user_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
