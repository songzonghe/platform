<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.prescription_details_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.prescription_details_id}">
		<td index="tdIndex" style="vertical-align: middle;">
			${i.index+1}
		</td>
		<td style="vertical-align: middle;">
			${map.drug_name}
		</td>
		<td style="vertical-align: middle;">
			${map.details_consumption}
		</td>
		<td style="vertical-align: middle;">
			${map.details_frequency_str}
		</td>
		<td style="vertical-align: middle;">
			${map.details_frequency}
		</td>
		<td style="vertical-align: middle;">
			${map.details_day}
		</td>
		<td style="vertical-align: middle;">
			${map.details_num}
		</td>
		<td style="vertical-align: middle;">
			${map.details_usage}
		</td>
		<td style="vertical-align: middle;">
			${map.details_entrust}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<div class="hidden-sm hidden-xs btn-group">
				<button class="btn btn-xs btn-info" onclick="openEditPage_utilPrescriptionDetails('${map.prescription_details_id}','${map.prescription_id}')" title="编辑">
					编辑
				</button>
				<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate_utilPrescriptionDetails('${map.prescription_details_id}','${map.prescription_details_id}','${map.prescription_id}')" title="删除">
					删除
				</button>
			</div>
		</td>
	</tr>
</table>
