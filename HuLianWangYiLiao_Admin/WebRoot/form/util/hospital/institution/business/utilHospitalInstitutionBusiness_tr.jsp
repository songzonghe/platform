<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.business_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.business_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.business_nf}
						</td>
						<td style="vertical-align: middle;">
							机构数量：${info.business_pcjgsl}<br>
							部署平台：
							<c:if test="${info.business_bspt=='01'}">自建</c:if>
							<c:if test="${info.business_bspt=='02'}">阿里云</c:if>
							<c:if test="${info.business_bspt=='03'}">腾讯云</c:if>
							<c:if test="${info.business_bspt=='04'}">天翼云</c:if>
							<c:if test="${info.business_bspt=='05'}">沃云</c:if>
							<c:if test="${info.business_bspt=='90'}">其他</c:if><br>
							架构图地址：${info.business_wljgtdz}<br>
							架构描述：${info.business_jgmsxx}
						</td>
						<td style="vertical-align: middle;">
							机房面积：${info.business_jfmj}<br>
							职工总数：${info.business_zgzs}<br>
							人员总数：${info.business_khffryzs}<br>
							用房面积：${info.business_ywyfmj}
						</td>
						<td style="vertical-align: middle;">
							总收入：${info.business_zsr}<br>
							总支出：${info.business_zzc}<br>
							总资产：${info.business_zzch}<br>
							流动资产：${info.business_ldzc}
						</td>
						<td style="vertical-align: middle;">
							对外投资：${info.business_dwtz}<br>
							固定资产：${info.business_gdzc}<br>
							无形资产：${info.business_wxzcjkbf}<br>
							负债：${info.business_fz}<br>
							净资产${info.business_jzc}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.business_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.business_id}','${info.business_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
</table>
