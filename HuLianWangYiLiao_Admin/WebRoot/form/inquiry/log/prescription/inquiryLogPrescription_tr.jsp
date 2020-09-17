<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<input id="updateID" style="display: none;" value="${map.prescription_id}">
<input id="updateBackInfo" style="display: none;" value="${map.backInfo}">
<%@include file="/form_util/page/root.jsp"%>
<table>
		<tr id="tr${info.prescription_id}"  isOpen="n">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.join_type=='1'}">个人</c:if>
							<c:if test="${info.join_type=='2'}">门店</c:if>
						</td>
						<td style="vertical-align: middle;">
							问诊名字：${info.inquiry_patient_name}<br>
							医生名字：${info.doctor_name}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.prescription_type=='1'}">中药</c:if>
							<c:if test="${info.prescription_type=='2'}">西药</c:if>
							<c:if test="${info.prescription_type=='3'}">中成药</c:if>
						</td>
						<td style="vertical-align: middle;">
							处方金额：${info.prescription_price}<br>
							付数：${info.prescription_num}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.zt=='1'}">已查看</c:if>
							<c:if test="${info.zt=='0'}">审核成功</c:if>
							<c:if test="${info.zt=='2'}">审核中</c:if>
							<c:if test="${info.zt=='5'}"><span style="color:red">不通过  </span>
					    	<br>药师:${info.prescription_audited_doctor}<br>
							原因:${info.prescription_reasons_invalidation}<br>
							时间:${info.prescription_audited_data}<br>
							</c:if>
							<c:if test="${info.zt=='6'}">已作废<br>
								原因:${info.prescription_reasons_invalidation}<br>
							</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.zt==2}">
								<button class="btn btn-xs btn-info" onclick="openEditPage('${info.prescription_id}','edit')" title="审核">
									审核
								</button>
							</c:if>
							<c:if test="${info.zt==0 or info.zt==1}">
								 <button class="btn btn-xs btn-info" onclick="openEditPage('${info.prescription_id}','look')" title="查看">
									查看
								</button>
							</c:if>
						</td>
					</tr>
</table>
