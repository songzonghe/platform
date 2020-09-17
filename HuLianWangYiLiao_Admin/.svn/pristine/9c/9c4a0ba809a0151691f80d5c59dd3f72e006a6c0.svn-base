<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.hospital_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.hospital_id}">
		<td index="tdIndex" style="vertical-align: middle;">
			${i.index+1}
		</td>
		<td style="vertical-align: middle;">
			<img src="${info.hospital_logo}" style="height: 60px;">
		</td>
		<td style="vertical-align: middle;">
			${info.hospital_number}
		</td>
		<td style="vertical-align: middle;">
			${info.hospital_name}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${info.hospital_jglx=='01'}">互联网医院诊疗</c:if><br>
			<c:if test="${info.hospital_jglx=='02'}">健康管理服务</c:if>
			<c:if test="${info.hospital_jglx=='03'}">药事服务机构</c:if>
			<c:if test="${info.hospital_jglx=='04'}">药房</c:if>
			<c:if test="${info.hospital_jglx=='05'}">其他</c:if><br>
		</td>
		<td style="vertical-align: middle;">
			${info.hospital_frdb}
		</td>
		<td style="vertical-align: middle;">
			${info.hospital_dhhm}
		</td>
		<td style="vertical-align: middle;">
			${info.hospital_jgclrq}
		</td>
		<td style="vertical-align: middle;">
			${info.hospital_dz}
		</td>
		<td style="vertical-align: middle;">
			${info.lrsj}
		</td>
		<td style="vertical-align: middle;">
			${info.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" onclick="openEditPage('${info.hospital_id}')" title="编辑">
				编辑
			</button>
			<c:if test="${info.login_account_type!='1'}">
				<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.hospital_id}','${info.hospital_id}')" title="删除">
					删除
				</button>
			</c:if>
		</td>
	</tr>
</table>
