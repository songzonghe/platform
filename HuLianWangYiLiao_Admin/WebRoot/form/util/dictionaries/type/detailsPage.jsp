<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="myTag"%>
<div class="widget-main no-padding" style="width: 1100px">
	<iframe src="utilDictionariesData_index.do?id=${map.dictionaries_type_id}&type=1" id="userIframe" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" style="width: 100%;min-height: 700px" allowtransparency="yes">
	
	</iframe>
	<div class="center" style="border-top: 1px solid #E5E5E5;padding: 10px 0px 10px 0px;">
	<button type="button" onclick="closeShowDiv()" class="btn btn-sm btn-lg" style="width: 100px">
		返&nbsp;&nbsp;回
	</button>
	</div>
</div>

	

