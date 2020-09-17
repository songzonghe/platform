<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.init_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${map.init_id}">
		<td index="tdIndex" style="vertical-align: middle;">
			${i.index+1}
		</td>
		<td style="vertical-align: middle;">
			${map.init_name}
		</td>
		
		<td>
			<c:if test="${map.zt=='1'}">
				<a class="btn btn-xs btn-success" target="init_${map.init_id}" href="utilInitData_findById.do?type=1&&init_id=${map.init_id}" title="预览图文">
				预览图文
				</a>
			</c:if>
			<c:if test="${map.zt=='2'}">
				<img src="${map.init_key}" style="width: 60px;">
			</c:if>
			<c:if test="${map.zt=='3'||map.zt=='4'}">
				${map.init_key}
			</c:if>
			<c:if test="${map.zt=='5'}">
				<input type="checkbox" value="1" name="init_key"
			 <c:if test="${map.init_key=='1'}">checked</c:if>
			  onclick="changeInitKey('${map.init_id}')">
			</c:if>
			<c:if test="${map.zt=='6'}">
				<video src="${map.init_key}" height="200px" controls="controls"></video>
			</c:if>
		</td>
		<td style="vertical-align: middle;">
			${map.gxsj}
		</td>
		<td style="vertical-align: middle;">
			${map.bz}
		</td>
		<td style="vertical-align: middle;">
			<button class="btn btn-xs btn-info" onclick="openEditPage('${map.init_id}')" title="编辑">编辑</button>
			<c:if test="${map.zt==1}">
				<a class="btn btn-xs btn-pink" target="init_${map.init_id}" href="utilInitData_findById.do?type=2&init_id=${map.init_id}" title="编辑图文详情">
					编辑图文
				</a>
			</c:if>
		</td>
	</tr>
</table>
