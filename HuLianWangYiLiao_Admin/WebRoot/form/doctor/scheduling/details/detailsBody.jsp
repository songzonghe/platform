<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/form_util/page/root.jsp"%>

<c:if test="${empty listMap}">
	<tr align="center">
		<th colspan="100">
			没找到医生排班信息！
		</th>
	</tr>

</c:if>
<c:forEach var="map" items="${listMap}" varStatus="i">
	<tr id="tr${map.scheduling_id}">
		<td style="vertical-align: middle;">
			${pageNum*10+i.index+1}
		</td>
		<td style="vertical-align: middle;">
			<img src="${map.doctor_img}" style="height: 60px;width: 60px">
		</td>
		<td style="vertical-align: middle;">
			${map.department_name}
		</td>
		<td style="vertical-align: middle;">
			${map.doctor_name}
		</td>
		<td style="vertical-align: middle;">
			${map.doctor_phone}
		</td>
		<td style="vertical-align: middle;">
			<input onclick="updateInfo('${map.scheduling_id}','1',this)" <c:if test="${map.is_morning=='1'}">checked="checked"</c:if> type="checkbox" name="find_is_morning" value="1">上午&nbsp;&nbsp;&nbsp;
			<input onclick="updateInfo('${map.scheduling_id}','2',this)" <c:if test="${map.is_afternoon=='1'}">checked="checked"</c:if> type="checkbox" name="find_is_afternoon" value="1">下午&nbsp;&nbsp;&nbsp;
			<input onclick="updateInfo('${map.scheduling_id}','3',this)" <c:if test="${map.is_night=='1'}">checked="checked"</c:if> type="checkbox" name="find_is_night" value="1">晚上
		</td>
	</tr>
</c:forEach>
<tr align="center" id="pageContainer">
	<td colspan="7">
		<c:set var="cx" value="searchOpenPage" />
		<c:set var="data_id" value="sortData" />
		<%@include file="/form_util/page/detailPage.jsp"%>
	</td>
</tr>