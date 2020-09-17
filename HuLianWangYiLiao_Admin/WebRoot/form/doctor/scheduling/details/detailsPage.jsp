<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="myTag"%>
<div class="widget-main no-padding" style="min-width: 1150px">
	<div class="page-content">
		<div class="row">
			<div class="widget-box">
				<div class="widget-body">
					<div class="widget-main no-padding">
						<form class="form-horizontal" isValidate="y" onsubmit="return false;">
							<fieldset>
								<input type="hidden" id="find_date" value="${info.find_date}">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-left: 10px; margin-top: 10px">
		<div class="bs-example"
			style="height: 430px; padding: 5px; overflow: auto;">
			<table class="table table-hover dataTable" id="sortData">
				<thead>
					<tr>
						<th>
							序号
						</th>
						<th>
							头像
						</th>
						<th>
							科室
						</th>
						<th>
							名称
						</th>
						<th>
							手机号
						</th>
						<th>
							班次
						</th>
					</tr>
				</thead>
				<tbody id="dataInfo">

				</tbody>
			</table>
		</div>
		<br />
		<div class="form-actions center" style=" margin-bottom: 0;padding: 10px;">
			<button type="button" class="btn btn-sm btn-lg" onclick="closeShowDiv();">
				返回
			</button>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		searchOpenPage('sortData', 0);
	});
</script>