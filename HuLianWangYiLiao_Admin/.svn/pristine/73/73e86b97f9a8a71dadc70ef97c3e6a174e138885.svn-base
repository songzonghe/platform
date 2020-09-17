<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tr pid="tr${map.prescription_id}" style="display: none;">
	<td colspan="100">
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li class="active">
					<a data-toggle="tab" href="#divl${map.prescription_id}" aria-expanded="false">问诊记录处方模板详情</a>
				</li>
			</ul>
			<div class="tab-content">
				<div id="divl${map.prescription_id}" class="tab-pane fade  active in ">
					<table id="sample-table-1" class="table  table-bordered">
						<thead>
							<tr>
								<th width="50px"></th>
								<th>药品名称</th>
								<th>用量</th>
								<th>频率文字</th>
								<th>频率</th>
								<th>天数</th>
								<th>数量</th>
								<th>用法</th>
								<th>嘱托</th>
								<th>操作时间</th>
								<th>备注</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="dataTbody_utilPrescriptionDetails${map.prescription_id}">
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
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</td>
</tr>