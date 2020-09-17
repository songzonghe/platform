<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.prescription_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.prescription_id}"  isOpen="n">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							<img style="cursor: pointer;" id="img${info.prescription_id}"
								onclick="mainDetail('${info.prescription_id}')" isOpen="n"
								src="${root}/form_util/util/images/nolines_plus.gif">
							
						</td>
						<td style="vertical-align: middle;">
							${info.icd_name}
						</td>
						<td style="vertical-align: middle;">
							${info.diagnosis_name}
						</td>
						<td style="vertical-align: middle;">
							${info.doctor_name}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.prescription_type=='1'}">中药</c:if>
							<c:if test="${info.prescription_type=='2'}">西药</c:if>
							<c:if test="${info.prescription_type=='3'}">中成药</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.prescription_price}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.prescription_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.prescription_id}','${info.prescription_id}')" title="删除">
								删除
							</button>
							<button class="btn btn-xs btn-primary" title="处方详情" onclick="add_utilPrescriptionDetailsPage('${info.prescription_id}')" >
								<i class="ace-icon fa fa-plus bigger-120"></i>
							</button>
						</td>
					</tr>
</table>
