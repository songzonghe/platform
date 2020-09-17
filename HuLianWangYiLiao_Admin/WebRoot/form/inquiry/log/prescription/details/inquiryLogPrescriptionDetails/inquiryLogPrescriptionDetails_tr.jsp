<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.prescription_details_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.prescription_details_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			处方：${map.prescription_id}<br>
			药品：${map.drug_id}<br>
			用量：${map.details_consumption}
		</td>
		<td style="vertical-align: middle;">
			频率文字：${map.details_frequency_str}<br>
			频率：${map.details_frequency}
		</td>
		<td style="vertical-align: middle;">
			天数：${map.details_day}<br>
			数量：${map.details_num}<br>
			用法：${map.details_usage}<br>
			嘱咐：${map.details_entrust}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<div class="hidden-sm hidden-xs btn-group">
				<button class="btn btn-xs btn-info" onclick="openEditPage_inquiryLogPrescriptionDetails('${map.prescription_details_id}')" title="编辑">
					编辑
				</button>
				<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate_inquiryLogPrescriptionDetails('${map.prescription_details_id}','${map.prescription_details_id}','${map.prescription_id}')" title="删除">
					删除
				</button>
			</div>
		</td>
	</tr>
</table>
