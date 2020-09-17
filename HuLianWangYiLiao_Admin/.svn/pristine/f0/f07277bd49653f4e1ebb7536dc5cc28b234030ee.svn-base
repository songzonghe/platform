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
</head>
<body class="no-skin">
<!-- 返回回来参数 -->
<%@include file="/form_util/page/hidden.jsp"%>
<div class="main-container box" id="main-container">

	<input type="hidden" id="dataListString" value='${bigData.dataListString }'>
	<input type="hidden" id="geoCoordMapString" value='${bigData.geoCoordMapString }'>

	<div class="dataTables_wrapper form-inline no-footer"> 
		<div class="widget-box">
			<div class="widget-body">
				<table class="table  table-bordered dataTable">
					  <tr>
					  	<th width="500">累计服务人数（注册人数）</th>
					  	<th width="500">${info.userCount}人</th>
					  	<th width="500">累计处方数</th>
					  	<th width="500">${info.prescriptionCount}单</th>
					  </tr>
				    <tr>
				    	<th >当前在线医生人数</th>
					  	<th >${info.doctorCount}人</th>
						<th>当前累计问诊人数</th>
						<th>${info.inquiryCount}人</th>
					</tr>
					<tr>
						<th>当天累计开处方数</th>
					  	<th>${info.todayPrescriptionCount}单</th>
						<th></th>
						<th></th>
					</tr>
				</table>
			</div>
		</div>
		<div id="coordinate" style="width: 900px;height:700px;"></div>
	</div>
</div>

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
<script src="${root}/form/reportForm/js/reportForm_main.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/sys_js/echarts.js?<%=Math.random()%>"></script>
<script src="${root}/form_util/util/sys_js/bmap.js?<%=Math.random()%>"></script>
<script src="http://api.map.baidu.com/api?v=2.0&ak=up3kc6PmaeATCPgdkv313RwGuTNOSOWI"></script>
</body>

<script type="text/javascript">

var myChart = echarts.init(document.getElementById('coordinate'));

var data =strToJson($("#dataListString").val());
console.log(data)
var geoCoordMap =strToJson($("#geoCoordMapString").val());
console.log(geoCoordMap)

/* var data = [{name: "荔湾区", num: 1, longitude: 113.243, latitude: 23.1249, value: 1},
	 {name: "越秀区", num: 1, longitude: 113.281, latitude: 23.1256, value: 1},
	 {name: "天河区", num: 1, longitude: 113.335, latitude: 23.1356, value: 1}
	];

var geoCoordMap = {"越秀区":[113.281,23.1256],"荔湾区":[113.243,23.1249],"天河区":[113.335,23.1356]}
 */
	var convertData = function (data) {
	    var res = [];
	    for (var i = 0; i < data.length; i++) {
	        var geoCoord = geoCoordMap[data[i].name];
	        if (geoCoord) {
	            res.push({
	                name: data[i].name,
	                value: geoCoord.concat(data[i].value),
	                data : data[i].value
	            });
	        }
	    }
	    console.log(res)
	    return res;
	};



	option = {
	    backgroundColor: 'transparent',
	    tooltip : {
	        trigger: 'item',
	        formatter: function(params) {
	            var res = params.name +'';
	            var myseries = option.series;
	            for (var i = 0; i < myseries.length; i++) {
	                for(var j=0;j<myseries[i].data.length;j++){
	                    if(myseries[i].data[j].name==params.name){
	                        res+='接诊点  : '+myseries[i].data[j].data +'个</br>';
	                    }
	                }
	            }
	            return res;
	        }
	    },
	    bmap: {
	        center: [104.114129, 37.550339],
	        zoom: 5,
	        roam: true,
	        mapStyle: {
	            styleJson: [
	                    {
	                        "featureType": "water",
	                        "elementType": "all",
	                        "stylers": {
	                            "color": "#044161"
	                        }
	                    },
	                    {
	                        "featureType": "land",
	                        "elementType": "all",
	                        "stylers": {
	                            "color": "#004981"
	                        }
	                    },
	                    {
	                        "featureType": "boundary",
	                        "elementType": "geometry",
	                        "stylers": {
	                            "color": "#064f85"
	                        }
	                    },
	                    {
	                        "featureType": "railway",
	                        "elementType": "all",
	                        "stylers": {
	                            "visibility": "off"
	                        }
	                    },
	                    {
	                        "featureType": "highway",
	                        "elementType": "geometry",
	                        "stylers": {
	                            "color": "#004981"
	                        }
	                    },
	                    {
	                        "featureType": "highway",
	                        "elementType": "geometry.fill",
	                        "stylers": {
	                            "color": "#005b96",
	                            "lightness": 1
	                        }
	                    },
	                    {
	                        "featureType": "highway",
	                        "elementType": "labels",
	                        "stylers": {
	                            "visibility": "off"
	                        }
	                    },
	                    {
	                        "featureType": "arterial",
	                        "elementType": "geometry",
	                        "stylers": {
	                            "color": "#004981"
	                        }
	                    },
	                    {
	                        "featureType": "arterial",
	                        "elementType": "geometry.fill",
	                        "stylers": {
	                            "color": "#00508b"
	                        }
	                    },
	                    {
	                        "featureType": "poi",
	                        "elementType": "all",
	                        "stylers": {
	                            "visibility": "off"
	                        }
	                    },
	                    {
	                        "featureType": "green",
	                        "elementType": "all",
	                        "stylers": {
	                            "color": "#056197",
	                            "visibility": "off"
	                        }
	                    },
	                    {
	                        "featureType": "subway",
	                        "elementType": "all",
	                        "stylers": {
	                            "visibility": "off"
	                        }
	                    },
	                    {
	                        "featureType": "manmade",
	                        "elementType": "all",
	                        "stylers": {
	                            "visibility": "off"
	                        }
	                    },
	                    {
	                        "featureType": "local",
	                        "elementType": "all",
	                        "stylers": {
	                            "visibility": "off"
	                        }
	                    },
	                    {
	                        "featureType": "arterial",
	                        "elementType": "labels",
	                        "stylers": {
	                            "visibility": "off"
	                        }
	                    },
	                    {
	                        "featureType": "boundary",
	                        "elementType": "geometry.fill",
	                        "stylers": {
	                            "color": "#029fd4"
	                        }
	                    },
	                    {
	                        "featureType": "building",
	                        "elementType": "all",
	                        "stylers": {
	                            "color": "#1a5787"
	                        }
	                    },
	                    {
	                        "featureType": "label",
	                        "elementType": "all",
	                        "stylers": {
	                            "visibility": "off"
	                        }
	                    }
	            ]
	        }
	    },
	    series : [
	        {
	            type: 'scatter',
	            coordinateSystem: 'bmap',
	            data: convertData(data),
	            symbolSize: function (val) {
	                return val[2] *10;
	            },
	            itemStyle: {
	                normal: {
	                    color: '#ddb926'
	                }
	            }
	        }
	    ]
	};
	
myChart.setOption(option);
</script>
</html>