<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.log_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.log_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${info.log_type=='1'}">视频问诊</c:if>
			<c:if test="${info.log_type=='2'}">图文问诊</c:if>
		</td>
		<td style="vertical-align: middle;">
			类型：<c:if test="${info.join_type=='1'}">个人</c:if>
				<c:if test="${info.join_type=='2'}">门店</c:if><br>
			关联：${info.join_id}
		</td>
		<td style="vertical-align: middle;">
			患者：${info.inquiry_patient_name}<br>
			医生：${info.doctor_name}
		</td>
		<td style="vertical-align: middle;">
			记录来源：${info.log_source}<br>
			主诉：${info.log_main_suit}
		</td>
		<td style="vertical-align: middle;">
			现病史:${info.log_present_illness}<br>
			既往史:${info.log_history_present_illness}
		</td>
		<td style="vertical-align: middle;">
			${info.lof_diagnosis}
		</td>
		<td style="vertical-align: middle;">
			${info.unprescribed_reasons}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.log_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.log_id}','${map.log_id}')" title="删除">
				删除
			</button>
		</td>
	</tr>
</table>
