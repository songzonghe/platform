<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.equipment_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.equipment_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			设备代号：${info.equipment_id}<br>
			设备名称：${info.equipment_sbmc}<br>
			设备台数：${info.equipment_tpsbts}<br>
			产地：
			<c:if test="${info.equipment_cd=='1'}">进口</c:if>
			<c:if test="${info.equipment_cd=='2'}">国产</c:if>
			<c:if test="${info.equipment_cd=='3'}">合资</c:if>
			<c:if test="${info.equipment_cd=='9'}">未知</c:if>
			<br>
			生产厂家：${info.equipment_sccj}
		</td>
		<td style="vertical-align: middle;">
			设备型号：${info.equipment_sbxh}<br>
			设备参数：${info.equipment_sbcs}<br>
			设备类型：${info.equipment_sblx}
		</td>
		<td style="vertical-align: middle;">
			购买日期：${info.equipment_gmrq}<br>
			用途：${info.equipment_yt}<br>
			设备价值金额：${info.equipment_sbjzje}<br>
			购进时新旧情况:${info.equipment_gjsxqk}
		</td>
		<td style="vertical-align: middle;">
			理论设计寿命：${info.equipment_llsjsm}<br>
			使用情况：
			<c:if test="${info.equipment_syqk=='1'}">启用</c:if>
			<c:if test="${info.equipment_syqk=='2'}">未启用</c:if>
			<c:if test="${info.equipment_syqk=='3'}">报废</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.equipment_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.equipment_id}','${map.equipment_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
