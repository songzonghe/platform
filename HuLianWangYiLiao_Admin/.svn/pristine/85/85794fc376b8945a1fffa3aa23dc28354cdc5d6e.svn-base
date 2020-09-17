<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.inquiry_patient_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.inquiry_patient_id}" >
		<td index="tdIndex" style="vertical-align: middle;">
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.join_type=='1'}">个人</c:if>
			<c:if test="${map.join_type=='2'}">门店</c:if>
		</td>
		<%-- <td style="vertical-align: middle;">
			${map.join_id}
		</td> --%>
		<td style="vertical-align: middle;">
			<c:if test="${map.inquiry_patient_type=='0'}">为自己问诊</c:if>
			<c:if test="${map.inquiry_patient_type=='1'}">为别人问诊</c:if>
		</td>
		<td style="vertical-align: middle;">
			<img src="${map.inquiry_patient_img}" style="height: 60px;">
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_name}
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_idcard}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.inquiry_patient_sex=='0'}">男</c:if>
			<c:if test="${map.inquiry_patient_sex=='1'}">女</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_birthday}
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_phone}
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_marital_status}
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_weight}
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_profession_code}
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_profession}
		</td>
		<td style="vertical-align: middle;">
			${map.inquiry_patient_address}
		</td>
		<td style="vertical-align: middle;">
			<c:if test="${map.is_drug_allergy=='0'}">否</c:if>
			<c:if test="${map.is_drug_allergy=='1'}">是</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.iinquiry_patient_allergy_details}
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<%-- <td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" title="编辑" onclick="openEditPage('${map.inquiry_patient_id}')">
				编辑
			</button>
			<button class="btn btn-xs btn-danger"  onclick="confirmDeleteDate('${map.inquiry_patient_id}','${map.inquiry_patient_id}')" title="删除">
				删除
			</button>
		</td> --%>
	</tr>
</table>
