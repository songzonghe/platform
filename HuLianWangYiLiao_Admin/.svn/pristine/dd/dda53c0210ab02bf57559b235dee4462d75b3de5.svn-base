<%@ page language="java" pageEncoding="utf-8"%> 
<%@include file="/form_util/page/root.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tr pid="tr${map.class_id}" style="display: none;">
	<td colspan="100">
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li class="active">
					<a data-toggle="tab" href="#divl${map.class_id}" aria-expanded="false">药品</a>
				</li>
			</ul>
			<div class="tab-content">
				<div id="divl${map.class_id}" class="tab-pane fade  active in ">
					<table id="sample-table-1" class="table  table-bordered">
						<thead>
							<tr>
								<th width="50px"></th>
								<th>药品基本信息</th>
								<th>药品分类</th>
								<th>药品主图</th>
								<th>药品规格</th>
								<th>药品说明书</th>
								<th>最大用量</th>
								<th>是否处方</th>
								<th>药品类型</th>
								<th>操作时间</th>
								<th>备注</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="dataTbody_utilDrug${map.class_id}">
							<c:if test="${empty listMap}">
								<tr align="center">
									<td colspan="100">
										没有查询到数据
									</td>
								</tr>
							</c:if>
							<c:forEach items="${listMap}" varStatus="i" var="map">
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
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</td>
</tr>