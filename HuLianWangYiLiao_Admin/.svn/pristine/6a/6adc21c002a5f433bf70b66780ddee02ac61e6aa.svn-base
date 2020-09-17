<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.account_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.account_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.account_number}
						</td>
						<td style="vertical-align: middle;">
							${info.account_name}
						</td>
						<td style="vertical-align: middle;">
							${info.functions_name}
						</td>
						<td style="vertical-align: middle;">
							<c:if test="${info.zt=='2'}"><span class="badge badge-success">正常</span></c:if>
							<c:if test="${info.zt=='0'}"><span class="badge badge-danger">禁用</span></c:if>
						</td>
						<td style="vertical-align: middle;">
							${info.lrsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
						<span class="handel-box">
						<a>操作</a>
						<ul class="handel-list">
							<li onclick="openEditPage('${info.account_id}','all')" title="编辑">编辑</li>
							<li onclick="openFunctionsPage('${info.account_id}','${info.account_number}')" title="配置权限">配置权限</li>
							<li onclick="openEditPage('${info.account_id}','pwd')" title="重置密码">重置密码</li>
							<c:if test="${info.zt=='2'}">
							<li onclick="confirmUpdateLock('${info.account_id}','${info.account_number}',0)" title="禁用">禁用</li>
							</c:if>
							<c:if test="${info.zt=='0'}">
							<li onclick="confirmUpdateLock('${info.account_id}','${info.account_number}',2)" title="启用">启用</li>
							</c:if>
							<li onclick="confirmDeleteDate('${info.account_id}','${info.account_name}')" title="删除">删除</li>
						</ul>
						</span>						
						</td>
					</tr>
</table>
