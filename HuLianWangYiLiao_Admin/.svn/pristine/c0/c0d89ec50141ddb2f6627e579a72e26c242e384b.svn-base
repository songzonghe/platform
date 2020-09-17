<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.util.*"%>
<%
	Logger loggerPage = Logger.getLogger(Object.class);
	int tj = 0;
	try {
		tj = UtilStr.getInt(request.getAttribute("tj"));
	} catch (Exception e) {
		loggerPage.error(e);
	}
	int j = 1;
	if (tj / SysFinal.PAGENUM_VAL != 0) {
		j = tj / SysFinal.PAGENUM_VAL;
		if (tj % SysFinal.PAGENUM_VAL != 0) {
			j += 1;
		}
	}
	request.setAttribute("j", j);
	request.setAttribute("sysPageNum", SysFinal.PAGENUM_VAL);
%>
			<div>
				<div style="position: fixed; bottom: -20px;  height: 50px;  z-index: 1;">
					共
					<span class="badge badge-danger"> ${tj} </span> 条数据 当前为第
					<span class="badge badge-danger"> ${pageNum+1}/${j}</span> 页 每页显示
					<select style="height: 27px !important;border-radius: 3px !important;" class="ui-pg-selbox" id="${pageSelectNum}SelectPageNum" onchange="${cx}(0);">
						<option value="10" <c:if test="${sysPageNum==10}">selected="selected"</c:if>>10
						</option>
						<option value="20" <c:if test="${sysPageNum==20}">selected="selected"</c:if>> 20
						</option>
						<option value="50" <c:if test="${sysPageNum==50}">selected="selected"</c:if>>50
						</option>
						<option value="100" <c:if test="${sysPageNum==100}">selected="selected"</c:if>>100
						</option>
						<option value="200" <c:if test="${sysPageNum==200}">selected="selected"</c:if>>200
						</option>
					</select>
					条
					跳转到第
					<input type="text" id="num" style="width: 60px;height: 27px !important;border-radius: 3px !important;" value="" onkeyup="boolNum()"/> 页   
					<input type="hidden" id="cx" value="${cx}"/>
					<input type="hidden" id="j" value="${j}"/>
					
					<button type="button" id="but" class="btn btn-info btn-xs jump" onclick="${cx}(${pageNum+0})" style="border-radius: 3px;margin-top: -4px;">
						跳转
					</button>
				</div>
				<div class="pages" style="margin-left: 70%;">
					<button type="button" class="btn btn-info btn-xs" style="width: 46px;"
					<c:if test="${pageNum-1<0}" >disabled="disabled"</c:if>
					<c:if test="${pageNum-1>=0}" >onclick="${cx}(${pageNum-1})"</c:if>>
						<i class="fa fa-angle-double-left" ></i>
					</button>
					<c:if test="${pageNum!=0}" >
						<button type="button" class="btn btn-info btn-xs" onclick="${cx}(0)">
							1
						</button>
					</c:if>
					<c:if test="${pageNum-2>0}" >
						<button type="button" class="btn btn-info btn-xs" >
							...
						</button>
					</c:if>
					<c:if test="${pageNum-1>0}" >
						<button type="button" class="btn btn-info btn-xs" onclick="${cx}(${pageNum-1})">
							${pageNum}
						</button>
					</c:if>
					
					<button type="button" class="btn btn-pink" style="border-radius:4px">
						${pageNum+1}
					</button>
					
					<c:if test="${pageNum+2<j}" >
						<button type="button" class="btn btn-info btn-xs" onclick="${cx}(${pageNum+1})">
							${pageNum+2}
						</button>
					</c:if>
					<c:if test="${pageNum+3<j}" >
						<button type="button" class="btn btn-info btn-xs" >
							...
						</button>
					</c:if>
					
					<c:if test="${pageNum!=j-1}" >
						<button type="button" class="btn btn-info btn-xs"  onclick="${cx}(${j-1})">
							${j}
						</button>
					</c:if>
					<button type="button" class="btn btn-info btn-xs" style="width: 46px;"
					<c:if test="${pageNum+1>=j}">disabled="disabled"</c:if>
					<c:if test="${pageNum+1<j}" >onclick="${cx}(${pageNum+1})"</c:if>>
						<i class="fa fa-angle-double-right" ></i>
					</button>
				</div>
			</div>

<script >
function boolNum(){
	var num=Number($('#num').val());
	var j=Number($('#j').val());
	if($('#num').val()==''|| isNaN($('#num').val()) ||num<=0){
		$('#num').val('1');
		$('#but').attr('onclick',$('#cx').val()+'(0)');
	}else if(num>=j){
		$('#num').val(j);
		$('#but').attr('onclick',$('#cx').val()+'('+(j-1)+')');
	}else{
		$('#but').attr('onclick',$('#cx').val()+'('+(num-1)+')');
	}
}

</script>