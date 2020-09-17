<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.data_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.data_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_id}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.join_type=='1'}">个人</c:if>
			<c:if test="${map.join_type=='2'}">门店</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.join_id}
		</td>
		<td style="vertical-align: middle;">
			${map.data_animal_heat}
		</td>
		<td style="vertical-align: middle;">
			${map.data_sbp}
		</td>
		<td style="vertical-align: middle;">
			${map.data_dbp}
		</td>
		<td style="vertical-align: middle;">
			${map.data_heart_rate}
		</td>
		<td style="vertical-align: middle;">
			${map.data_rr}
		</td>
		<td style="vertical-align: middle;">
			${map.data_glu}
		</td>
		<td style="vertical-align: middle;">
			${map.data_condition}
		</td>
		<td style="vertical-align: middle;">
			${map.data_parameter}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.data_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.data_id}','${map.data_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
