<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.pharmacist_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.pharmacist_id}">
		<td index="tdIndex" style="vertical-align: middle;">
			${i.index+1}
		</td>
		<td style="vertical-align: middle;">
			<img src="${info.pharmacist_img}" style="height: 60px;">
		</td>
		<td style="vertical-align: middle;">
			${info.pharmacist_number}
		</td>
		<td style="vertical-align: middle;">
			${info.pharmacist_name}
		</td>
		<td style="vertical-align: middle;">
			${info.pharmacist_phone}
		</td>
		<td style="vertical-align: middle;">
			<img src="${info.pharmacist_autograph}" style="height: 60px;">
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${info.pharmacist_sex=='0'}">男</c:if>
			<c:if test="${info.pharmacist_sex=='1'}">女</c:if>
			<c:if test="${info.pharmacist_sex=='2'}">保密</c:if>
		</td>
		<td style="vertical-align: middle;">
			${info.pharmacist_sort}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${info.zt=='2'}">正常</c:if>
			<c:if test="${info.zt=='0'}">已禁用</c:if>
		</td>
		<td style="vertical-align: middle;">
			${info.lrsj}
		</td>
		<td style="vertical-align: middle;">
			${info.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" onclick="openEditPage('${info.pharmacist_id}')" title="编辑">
				编辑
			</button>
			<c:if test="${info.zt=='2'}">
				<button class="btn btn-xs btn-pink" onclick="confirmDeleteDate('${info.pharmacist_id}','0')" title="禁用">
					禁用
				</button>
			</c:if>
			<c:if test="${info.zt=='0'}">
				<button class="btn btn-xs btn-info" onclick="confirmDeleteDate('${info.pharmacist_id}','2')" title="启用">
					启用
				</button>
				<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.pharmacist_id}','del')" title="删除">
					删除
				</button>
			</c:if>
		</td>
	</tr>
</table>
