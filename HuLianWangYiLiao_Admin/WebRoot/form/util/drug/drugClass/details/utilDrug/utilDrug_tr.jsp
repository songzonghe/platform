<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.drug_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.drug_id}">
			<td index="tdIndex" style="vertical-align: middle;">
				${i.index+1}
			</td>
			<td style="vertical-align: middle;">
				药品名称：${map.drug_name}<br>
				英文名称：${map.drug_usname}<br>
				药品公司：${map.drug_company}
			</td>
			<td style="vertical-align: middle;">
				${map.class_name}
			</td>
			<td style="vertical-align: middle;">
				<img src="${map.drug_img}" style="width: 60px;">
			</td>
			<td style="vertical-align: middle;">
				药品规格：${map.drug_specifications}<br>
				药品单位：${map.drug_unit}<br>
				药品价格：${map.drug_price}<br>
				药品用法：${map.usage_name}<br>
				药品频率：${map.frequency_name}
			</td>
			<td style="vertical-align: middle;">
				${map.drug_instructions}
			</td>
			<td style="vertical-align: middle;">
				计量单位：${map.drug_maxdosage}<br>
				最小单位：${map.drug_maxdosage2}<br>
				补充单位：${map.drug_maxdosage3}
			</td>
			<td style="vertical-align: middle;">
				<c:if test="${map.drug_is_rx==0}">非处方药</c:if><c:if test="${map.drug_is_rx!=0}">处方药</c:if>
			</td>
			<td style="vertical-align: middle;">
				<c:if test="${map.drug_type==1}">中药</c:if><c:if test="${map.drug_type==2}">西药</c:if>
			</td>
			<td style="vertical-align: middle;">
				${map.gxsj}
			</td>
			<td style="vertical-align: middle;">
				${map.bz}
			</td>
			<td style="vertical-align: middle;">
				<div class="hidden-sm hidden-xs btn-group">
					<button class="btn btn-xs btn-info" onclick="openEditPage_utilDrug('${map.drug_id}')" title="编辑">
						编辑
					</button>
					<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate_utilDrug('${map.drug_id}','${map.drug_id}','${map.class_id}')" title="删除">
						删除
					</button>
				</div>
			</td>
		</tr>
</table>
