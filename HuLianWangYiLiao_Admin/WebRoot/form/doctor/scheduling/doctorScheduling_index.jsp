<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@include file="/form_util/page/root.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${root}/form/main/assets/css/bootstrap.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/font-awesome.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/ace-fonts.css" />
<link rel="stylesheet" href="${root}/form/main/assets/css/ace.css" />
<link rel="stylesheet" href="${root}/form_util/util/util_css/myPage.css" />
<link rel="stylesheet" href="${root}/form_util/util/util_css/jquery.searchableSelect.css" />
<style type="text/css">
.selected{
cursor: pointer;
color: red;
}
.showtext{
color: red;
}
</style>
<script src="${root}/form_util/util/sys_js/jquery.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/ajaxUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/alertDivUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/bodyUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/adminUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/validateUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/jsonUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/publicJsonUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/strUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/date/WdatePicker.js?<%=Math.random()%>"></script>
<script src="${root}/form/main/assets/js/bootstrap-tab.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/sys_js/ajaxfileupload.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/util_js/nodeUtil.js?<%=Math.random()%>"></script>
<script src="${root}/form/doctor/scheduling/js/doctorscheduling_main.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/sys_js/jquery.searchableSelect.js?<%=Math.random()%>"></script>
</head>
<body class="no-skin">
<!-- 返回回来参数 -->
<%@include file="/form_util/page/hidden.jsp"%>
<div class="main-container box" id="main-container">
	<div class="page-content">
		<div class="row">
			<div class="widget-box">
				<div class="widget-header">
					<h4 class="widget-title">
						医生排班管理
					</h4>
				</div>
					<div class="widget-body">
						<div class="widget-main no-padding" >
							<form action="doctorScheduling_index.do" id="queryForm" method="post">
								<!-- 参数隐藏 用于页面传值-->
								<input style="display: none;" id="mapStr" name="mapStr">
								<input style="display: none;" id="find_doctor_id" value="${map.doctor_id}">
								<fieldset>
									<label>
										医生
									</label>
									<select id="query_doctor_id" class="select" data-width="200px" data-select-width="800px" data-find="find" data-show-title="2" data-title="科室:20%;手机:20%;名称:20%;拼音:20%;五笔:20%" data-validate="required:医生不能为空哦！">
										<option value="">全部医生</option>
										<c:forEach var="doctors" items="${doctorList}">
											<option  value="${doctors.doctor_id}"<c:if test="${map.doctor_id==doctors.doctor_id}">selected="selected"</c:if>>${doctors.department_name};;${doctors.doctor_phone};;${doctors.doctor_name};;${doctors.doctor_name_pinyin};;${doctors.doctor_name_wubi}</option>
										</c:forEach>
									</select>
									<label>
										日期
									</label>
									<input type="text" id="query_scheduling_date" placeholder="日期" value="${map.scheduling_date}" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
									<button type="submit" onclick="queryDoctorScheduling(0)" class="btn btn-sm btn-success">
										搜索
									<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
									</button>
									<button type="button" onclick="openAddPage()" class="btn btn-sm btn-info">
										添加
									</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<textarea style="display: none" id="listData">${listMap}</textarea>
	<div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline no-footer" style="text-align: -webkit-center"> 
<script>
var weekday=new Array("星期一","星期二","星期三","星期四","星期五","星期六","星期天");
var monthname=new Array("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
var monthdays=new Array(31,28,31,30,31,30,31,31,30,31,30,31);
var datestr = '';
if($('#query_scheduling_date').val()==''){
	var date=new Date();
	datestr=date.getFullYear()+"-"+(date.getMonth()+1);
}else{
	datestr=$('#query_scheduling_date').val().substring(0,7);
}

var mydate = new Date(datestr.replace(/-/g, '/'));
var myyear=mydate.getFullYear();
var mymouth=mydate.getMonth();
var myday=mydate.getDate();//获取当前日期
var myweek=mydate.getDay();//获取当前星期几

if(myyear%4==0&&myyear%100!=0||myyear%400==0){
	monthdays[1]=29;
}
mydate.setDate(1);
var m=mydate.getDay();//获取当前月一号星期几

if(m==0){m=7;}

//document.write(mydate);
//document.write(m);
document.write("<table  style='text-align: center; vertical-align: middle;height: 500px;width:1000px;cursor: default;' border='1'>");
document.write("<tr align='center' style='height: 40px;font-weight: bold;' >");
document.write("<td style='font-size: 25px;color: #1c82e0;background-color: #f5ecbf;cursor: pointer;' onclick=\"changeDate("+myyear+","+mymouth+")\"><</td>");
document.write("<td colspan='5' >"+myyear+"年"+(++mymouth)+"月"+" </td>");
document.write("<td style='font-size: 25px;color: #1c82e0;background-color: #f5ecbf;cursor: pointer;' onclick=\"changeDate("+myyear+","+(mymouth+1)+")\">></td>");
document.write("</tr>");
var n=1;
//var l=0
mymouth--;
document.write("<tr style='height: 40px;font-weight: bold;'>");
for(var i=0;i<7;i++)
{
	document.write("<td>");
	document.write(weekday[i]);
	document.write("</td>");		
}
document.write("</tr>");

for(var i=0;i<5;i++){	
	if(m>0){
		document.write("<tr>");
		for(var j=1;j<m;j++){
			document.write("<td>");
			document.write("&nbsp;");
			document.write("</td>");	
		}
		for(var k=m;k<=7;k++){
			if(n==myday){
				if(n<10){
					document.write("<td id='"+datestr+"-0"+n+"'>");
				}else{
					document.write("<td id='"+datestr+"-"+n+"'>");
				}
				document.write(n);
				document.write("</td>");
			}
			else{
				if(n<10){
					document.write("<td id='"+datestr+"-0"+n+"'>");
				}else{
					document.write("<td id='"+datestr+"-"+n+"'>");
				}
				document.write(n);
				document.write("</td>");
			}
			n++	
		}
		document.write("</tr>");
		m=0;
	}
	if(m==0){
		document.write("<tr>");
		for(var k=1;k<=7;k++){
			if(n>monthdays[mymouth]){
				document.write("<td>");
				document.write("&nbsp;");
				document.write("</td>");
			}
			else{
				if(n==myday){
					if(n<10){
						document.write("<td id='"+datestr+"-0"+n+"'>");
					}else{
						document.write("<td id='"+datestr+"-"+n+"'>");
					}
					document.write(n);
					document.write("</td>");
				}
				else{
					if(n<10){
						document.write("<td id='"+datestr+"-0"+n+"'>");
					}else{
						document.write("<td id='"+datestr+"-"+n+"'>");
					}
					document.write(n);
					document.write("</td>");
				}
				n++;
			}		
		}
		document.write("</tr>");
	}
}
document.write("</table>");

if($('#query_scheduling_date').val()!=''){
	$('#'+$('#query_scheduling_date').val()).attr('style','color:#0dec0b');
}
var list=strToJson($('#listData').val());
 $('.selected').removeClass('selected');
 for (var i = 0; i < list.length; i++){
	 var this_=$('#'+(list[i].scheduling_date).substring(0,10));
	 if(!isUndefinedAndEmpty($('#find_doctor_id').val())){
		 var text=this_.text();
		 var addText="";
		 if(list[i].is_morning=='1'){addText+="上午;";}
		 if(list[i].is_afternoon=='1'){addText+="下午;";}
		 if(list[i].is_night=='1'){addText+="晚上;";}
		 this_.html(text+"<br>"+addText);
	 	 this_.addClass('showtext');
	 }else if(!isUndefinedAndEmpty(this_.find('span').attr('data'))){
	 	var datanum=strToInt(this_.find('span').attr('data'))+1;
		 this_.find('span').html("("+datanum+"人)");
		 this_.find('span').attr('data',datanum);
	 }else{
		 var text=this_.text();
		 this_.html(text+"<br><span data='1'>(1人)</span>");
	 	 this_.addClass('selected');
	 }
}
 //切换月份
 function changeDate(year,month){
	 if(month==0){
		 month=12;
	 	year=year-1;
	 }else if(month==13){
		 month=1;
		 year=year+1;
	 }
	 if(month<10){
		 month="0"+month
	 }
	 $('#query_scheduling_date').val(year+"-"+month+"-01");
 	queryDoctorScheduling(0);
 }
 
 
 //单击有数据的行 获取具体的医生列表
 $('.selected').click(function(){
		var id=$(this).attr('id');
		var text=$(this).text();
		openlookInfo(id);
	});
 
</script>
	</div>
</div>
</body>
</html>