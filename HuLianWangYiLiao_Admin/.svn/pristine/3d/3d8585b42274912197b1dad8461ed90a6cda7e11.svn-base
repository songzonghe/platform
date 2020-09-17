<%@ page language="java" pageEncoding="utf-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="updateID" style="display: none;" value="${map.store_id}">
<%@include file="/form_util/page/root.jsp"%>
<table>
	<tr id="tr${info.store_id}">
						<td index="tdIndex" style="vertical-align: middle;">
							${i.index+1}
						</td>
						<td style="vertical-align: middle;">
							账号：${info.store_phone}<br>
<!-- 						
						<td style="vertical-align: middle;">
							${info.store_paw}
						</td>
 -->						
							名称：${info.store_name}
						</td>
						<td style="vertical-align: middle;">
							<img src="${info.store_img}" style="height: 60px;">
						</td>
						<td style="vertical-align: middle;">
							网点代码：${info.store_fwwddm}<br>
							区划代码：${info.store_xzqhdm}<br>
							服务点类型：
							<c:if test="${info.store_fwdlx=='01'}">互联网医院诊疗</c:if>
							<c:if test="${info.store_fwdlx=='02'}">健康管理服务</c:if>
							<c:if test="${info.store_fwdlx=='03'}">药事服务机构</c:if>
							<c:if test="${info.store_fwdlx=='04'}">药房</c:if>
							<c:if test="${info.store_fwdlx=='05'}">其他</c:if><br>
							成立日期：${info.store_fwdclrq}
							</td>
						<td style="vertical-align: middle;">
							关系代码：${info.store_dwlsgxdm}<br>
							类别代码：${info.store_fwdflgllbdm}<br>
							分类代码：${info.store_fwdfldm}<br>
							类型代码：${info.store_jjlxdm}
							</td>
						<td style="vertical-align: middle;">
							地址：${info.store_dz}<br>
							医院级别：${info.store_fwdyyjb}<br>
							医院等级：${info.store_fwdyydj}<br>
							许可证号码：${info.store_xkzhm}
						</td>
						<td style="vertical-align: middle;">
							项目名称：${info.store_xkxmmc}<br>
							有效期：${info.store_xkzyxq}<br>
							金额数：${info.store_kbzjjes}<br>
							负责人：${info.store_frdb}
						</td>
						<td style="vertical-align: middle;">
							地方标志：
							<c:if test="${info.store_fwdszdmzzzdfbz=='0'}">是</c:if><br>
							<c:if test="${info.store_fwdszdmzzzdfbz=='1'}">否</c:if>
							是否分支机构：
							<c:if test="${info.store_sffzjg=='0'}">是</c:if><br>
							<c:if test="${info.store_sffzjg=='1'}">否</c:if>
							第二名称：${info.store_fwddemc}<br>
							服务点描述：${info.store_fwdms}
						</td>
						<td style="vertical-align: middle;">
							邮政编码：${info.store_yzbm}<br>
							电话号码：${info.store_dhhm}<br>
							电子信箱：${info.store_dwdzyx}<br>
						</td>
						<td style="vertical-align: middle;">
							${info.gxsj}
						</td>
						<td style="vertical-align: middle;">
							${info.bz}
						</td>
						<td style="vertical-align: middle;">
							<button class="btn btn-xs btn-info" onclick="openEditPage('${info.store_id}','1')" title="编辑">
								编辑
							</button>
							<button class="btn btn-xs btn-danger" onclick="confirmDeleteDate('${info.store_id}','${info.store_id}')" title="删除">
								删除
							</button>
						</td>
					</tr>
</table>
