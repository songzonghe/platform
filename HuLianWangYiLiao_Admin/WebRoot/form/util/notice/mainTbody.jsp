<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/form_util/page/root.jsp"%>
<c:forEach items="${listMap}" varStatus="i" var="map">
	<tr>
		<th scope="row">
			<input type="checkbox" id="checkbox${map.id}"
				name="typeCheckBox" value="${map.id}" name="${map.name}" >
		</th>
		<td>
			${pageNum*10+i.index+1}
		</td>
		<td>
			${map.name}
		</td>
		<td>
			${map.phone}
		</td>
		<td>
			${map.lrsj}
		</td>
	</tr>
</c:forEach>
<tr align="center" id="pageContainer">
	<td colspan="7">
		<c:set var="cx" value="searchUser" />
		<c:set var="data_id" value="sort" />
		<%@include file="/form_util/page/detailPage.jsp"%>
	</td>
</tr>


