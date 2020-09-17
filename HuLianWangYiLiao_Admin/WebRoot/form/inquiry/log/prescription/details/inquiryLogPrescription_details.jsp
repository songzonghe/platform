<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tr pid="tr${map.prescription_id}" style="display: none;">
	<td colspan="100">
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li class="active">
					<a data-toggle="tab" href="#divl${map.prescription_id}" aria-expanded="false">问诊记录处方详情</a>
				</li>
			</ul>
			<div class="tab-content">
				<div id="divl${map.prescription_id}" class="tab-pane fade  active in ">
					<table id="sample-table-1" class="table  table-bordered">
						<thead>
							<tr>
								<th width="50px"></th>
								<th>处方</th>
								<th>频率</th>
								<th>天数</th>
								<th>操作时间</th>
								<th>备注</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="dataTbody_inquiryLogPrescriptionDetails${map.prescription_id}">
							<c:if test="${empty listMap}">
								<tr align="center">
									<td colspan="100">
										没有查询到数据
									</td>
								</tr>
							</c:if>
							<c:forEach items="${listMap}" varStatus="i" var="map">
								<tr id="tr${map.prescription_details_id}">
									<td index="tdIndex" style="vertical-align: middle;">
										${i.index+1}
									</td>
									<td style="vertical-align: middle;">
										处方：${map.prescription_id}<br>
										药品：${map.drug_name}<br>
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
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</td>
</tr>