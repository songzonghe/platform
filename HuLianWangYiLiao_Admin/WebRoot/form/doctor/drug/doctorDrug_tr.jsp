<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.doctor_drug_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.doctor_drug_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			${map.doctor_id}
		</td>
		<td style="vertical-align: middle;">
			药品：${info.drug_id}<br>
			药品类型：<c:if test="${info.drug_type=='1'}">中药</c:if>
					<c:if test="${info.drug_type=='2'}">西药</c:if><br>
			用量：${info.doctor_drug_consumption}<br>
			
		</td>
		<td style="vertical-align: middle;">
			频繁文字：${info.doctor_drug_frequency_str}<br>
			频繁：${info.doctor_drug_frequency}
		</td>
		<td style="vertical-align: middle;">
			天数：${info.doctor_drug_day}<br>
			数量：${info.doctor_drug_num}<br>
			用法：${info.doctor_drug_usage}<br>
			嘱咐：${info.doctor_drug_entrust}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.doctor_drug_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.doctor_drug_id}','${map.doctor_drug_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
