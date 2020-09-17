<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tr pid="tr${map.checklist_id}" style="display: none;">
	<td colspan="100">
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li class="active">
					<a data-toggle="tab" href="#divl${map.checklist_id}" aria-expanded="false">问诊记录检验检查单详情</a>
				</li>
			</ul>
			<div class="tab-content">
				<div id="divl${map.checklist_id}" class="tab-pane fade  active in ">
					<table id="sample-table-1" class="table  table-bordered">
						<thead>
							<tr>
								<th width="50px"></th>
								<th>医院</th>
								<th>检验单</th>
								<th>检验单类型</th>
								<th>检验单名称</th>
								<th>操作时间</th>
								<th>备注</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="dataTbody_inquiryLogChecklistDetails${map.checklist_id}">
							<c:if test="${empty listMap}">
								<tr align="center">
									<td colspan="100">
										没有查询到数据
									</td>
								</tr>
							</c:if>
							<c:forEach items="${listMap}" varStatus="i" var="map">
								<tr id="tr${map.checklist_details_id}">
									<td index="tdIndex" style="vertical-align: middle;">
										${i.index+1}
									</td>
									<td style="vertical-align: middle;">
										${map.hospital_id}
									</td>
									<td style="vertical-align: middle;">
										${map.checklist_id}
									</td>
									<td style="vertical-align: middle;">
										${map.checklist_type}
									</td>
									<td style="vertical-align: middle;">
										${map.checklist_name}
									</td>
									<td style="vertical-align: middle;">
										${map.gxsj}
									</td>
									<td style="vertical-align: middle;">
										${map.bz}
									</td>
									<td style="vertical-align: middle;">
										<div class="hidden-sm hidden-xs btn-group">
											<button class="btn btn-xs btn-info" onclick="openEditPage_inquiryLogChecklistDetails('${map.checklist_details_id}')" title="编辑">
												编辑
											</button>
											<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate_inquiryLogChecklistDetails('${map.checklist_details_id}','${map.checklist_details_id}','${map.checklist_id}')" title="删除">
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