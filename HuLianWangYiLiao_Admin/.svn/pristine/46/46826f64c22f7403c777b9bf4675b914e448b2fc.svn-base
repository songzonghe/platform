<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.doctor_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.doctor_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							${info.doctor_phone}
						</td>
						<td style="vertical-align: middle;">
							医生名称：${info.doctor_name}<br>
							医生头像：<img src="${info.doctor_img}" style="height: 60px;"><br>
							性别：<c:if test="${info.doctor_sex=='0'}">男</c:if>
							<c:if test="${info.doctor_sex=='1'}">女</c:if>
							<c:if test="${info.doctor_sex=='2'}">保密</c:if><br>
							医生职称：${info.doctot_job_title}
						</td>
						<td style="vertical-align: middle;">
							执业点：${info.doctor_work_address}<br>
							科室名称：${info.department_name}<br>
							执业日期：${info.doctot_work_day}
						</td>
						<td style="vertical-align: middle;">
							生日：${info.doctot_birthday}<br>
							正面：<img src="${info.doctor_document_img1}" style="height: 60px;"><br>
							反面：<img src="${info.doctor_document_img2}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							医师执业证：<img src="${info.doctor_medical_practitioner_certificate}" style="height: 60px;"><br>
							医师资格证：<img src="${info.doctor_medical_licence}" style="height: 60px;"><br>
							技术资格证：<img src="${info.doctor_technical_certificate}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							医生擅长：${info.doctor_begoodat}<br>
							医生排名：${info.doctor_sort}<br>
							是否在线：<c:if test="${info.is_online=='0'}">否</c:if>
									<c:if test="${info.is_online=='1'}">是</c:if><br>
						</td>
						<td style="vertical-align: middle;">
							职务代码：${info.doctor_zyjszwdm}<br>
							类别代码：${info.doctor_zyjszwlbdm}<br>
							类别名称：${info.doctor_zzlbmc}<br>
							证书编号：${info.doctor_zgzsbh}<br>
							获得时间：${info.doctor_zghdsj}<br>
							证书编码：${info.doctor_zyzsbm}
						</td>
						<td style="vertical-align: middle;">
							<!-- 发证日期：${info.doctor_zyjszwdm}<br> modify by liwenhai -->
							发证日期：${info.doctor_fzrq}<br>
							注册日期：${info.doctor_zcsj}<br>
							<!--  执业范围：${info.doctor_zyjszwlbdm}<br> modifyby liwenhai-->
							执业范围：${info.doctor_zyfw_name}<br>
							医生标志：
							<c:if test="${info.doctor_qkysbz=='T'}">是</c:if>
							<c:if test="${info.doctor_qkysbz=='F'}">否</c:if>
							民族：${info.doctor_zgzsbh}<br>
							学历：${info.doctor_zghdsj}
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button width="180" class="btn btn-xs btn-info" onclick="openEditPage('${info.doctor_id}','1')" title="编辑">
								编辑
							</button>
							<button width="180" class="btn btn-xs btn-info" onclick="openEditPage('${info.doctor_id}','2')" title="重置密码">
								重置密码
							</button>
							<button width="180" class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.doctor_id}','${info.doctor_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
</table>
