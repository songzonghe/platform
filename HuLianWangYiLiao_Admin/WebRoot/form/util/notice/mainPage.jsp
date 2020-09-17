<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/myTag.tld" prefix="myTag"%>
<div class="widget-main no-padding" style="min-width: 850px">
	<form class="form-horizontal" isValidate="y" onsubmit="return false;">
		<div class="form-group text-center">
			<font size="4"> <strong>选择用户</strong> </font>
		</div>
        <div style="margin-left: 5px;">
				<%-- <strong>用户昵称：</strong>
				<input type="text" id="userNickname"  value="${info.user_nickname}">
				<strong>用户手机：</strong>
				<input type="text" id="userPhone"  value="${info.user_phone}">
				<input type="text" id="user_type"  value="${info.user_type}">
				<button class="btn btn-sm btn-success" onclick="searchUser('sort',0)">
					搜索
				</button>	 --%>
		</div>
		<div class="bs-example"
			style="height: 430px; padding: 5px; overflow: auto;">
			<table class="table table-hover" id="sort">
				<thead>
					<tr>
						<th>
							<input type="checkbox" id="checkboxZhong" onclick="selectAll(this,'typeCheckBox')">
						</th>
						<th>
							序号
						</th>
						<th name="user_nickname"   onclick="getSort('sort',this,'searchUser')" class="sorting">
							昵称
						</th>
						<th name="user_phone"   onclick="getSort('sort',this,'searchUser')" class="sorting">
							手机
						</th>
						<th name="lrsj"   onclick="getSort('sort',this,'searchUser')" class="sorting">
							注册时间
						</th>
					</tr>
				</thead>
				<tbody id="userList">
					
				</tbody>
			</table>
		</div>
		<br />	
		<div class="form-actions center">
			<button type="button" class="btn btn-sm btn-lg"
				onclick="closeShowDiv()">
				返回
			</button>
			<button type="submit" class="btn btn-sm btn-success"
				onclick="addMessageData(2);">
				发送
			</button>
		</div>
	</form>
</div>
<script type="text/javascript">
      $(function(){  
            //加载全部用户 
               searchUser('sort',0);
            });
</script>