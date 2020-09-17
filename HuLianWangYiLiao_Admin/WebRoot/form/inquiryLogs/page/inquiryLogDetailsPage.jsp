<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="myTag"%>
<div class="widget-main no-padding" style="width: 1100px">
	<iframe src="inquiryLog_getInquiryLogDetailsPage.do?id=${datas.log_id}&type=1" id="openinquiryLog" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" style="width: 100%; height: 700px" allowtransparency="yes"> </iframe>
	<div class="center" style="border-top: 1px solid #E5E5E5; padding: 10px 0px 10px 0px;">
		<button type="button" onclick="closeShowDiv()" class="btn btn-sm btn-lg" style="width: 100px">返回</button>
	</div>
</div>
<script>
	//获取url加切换类型
	function editIframeSrc(type) {
		$('#openinquiryLog').attr(
				'src',
				'inquiryLog_getInquiryLogDetailsPage.do?id='
						+ $('#find_log_id').val() + '&type=' + type);
	}
</script>