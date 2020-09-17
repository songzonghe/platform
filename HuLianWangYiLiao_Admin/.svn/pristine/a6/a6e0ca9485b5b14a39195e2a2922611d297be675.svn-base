<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${info.carousel_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.carousel_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.carousel_name}
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.carousel_img}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.carousel_type=='1'}">用户首页</c:if>
							<c:if test="${info.carousel_type=='2'}">门店首页</c:if>
							<c:if test="${info.carousel_type=='3'}">医生首页</c:if>
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.carousel_way=='1'}">无效果</c:if>
							<c:if test="${info.carousel_way=='2'}">详情</c:if>
							<c:if test="${info.carousel_way=='3'}">跳转链接</c:if>
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.carousel_way=='1'}"><span style="color:red">无</span></c:if>
							<c:if test="${info.carousel_way=='2'}">
								<button class="btn btn-xs btn-info" onclick="openCarouselPage('${info.carousel_id}','${info.carousel_name}')" title="查看详情">
									查看详情
								</button>
							</c:if>
							<c:if test="${info.carousel_way=='3'}">${info.carousel_url}</c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.carousel_sort}
						</td>
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.carousel_id}')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.carousel_id}','${info.carousel_name}')" title="删除">
								删除
							</button>
						</td>
					</tr>
</table>
