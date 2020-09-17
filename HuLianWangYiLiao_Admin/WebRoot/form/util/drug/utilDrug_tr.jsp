<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.drug_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.drug_id}">
		<td index="tdIndex" style="vertical-align: middle;">
			${i.index+1}
		</td>
		<td style="vertical-align: middle;">
			批准文号：${info.drug_number}<br>
			药品名称：${info.drug_name}<br>
			英文名称：${info.drug_usname}<br>
			药品公司：${info.drug_company}<br>
		</td>
		<td style="vertical-align: middle;">
			分类名称：${info.class_name}<br>
			药品规格：${info.drug_specifications}<br>
			药品类型：
			<c:if test="${info.drug_type=='1'}">中药</c:if>
			<c:if test="${info.drug_type=='2'}">西药</c:if>
			<c:if test="${info.drug_type=='3'}">中成药</c:if><br>
			是否处方：
			<c:if test="${info.drug_is_rx=='0'}">非处方药</c:if>
			<c:if test="${info.drug_is_rx=='1'}">处方药</c:if><br>
		</td>
		<td style="vertical-align: middle;">
			<img src="${info.drug_img}" style="height: 60px;">
		</td>
		<td style="vertical-align: middle;">
			计量单位：${info.drug_maxdosage}<br>
			最小单位：${info.drug_maxdosage2}<br>
			补充单位：${info.drug_maxdosage3}
		</td>
		<td style="vertical-align: middle;">
			拼音码：${info.drug_pinyin}<br>
			五笔码：${info.drug_wubi}<br>
		</td>
		<td style="vertical-align: middle;">
			${info.gxsj}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" onclick="openEditPage('${info.drug_id}')" title="编辑">
				编辑
			</button>
			<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.drug_id}','${info.drug_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
