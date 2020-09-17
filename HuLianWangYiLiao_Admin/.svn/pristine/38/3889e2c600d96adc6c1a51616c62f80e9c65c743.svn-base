
//弹窗 
var numallPrescription;
function printing(num,id){
	numallPrescription = num;
	if(num == 0 || num == 1){// 0 历史处方详情  1 历史处方打印 2检验打印  3 建议指导打印 4 住院建议打印
		var jsonData={
			"prescription_id" : id
		}
		var urldo = 'reportForm_getInquiryLogPrescriptionDetails';
		var backdo = 'getInquiryLogPrescriptionDetails_back';
	}else if( num == 2 ){
		var jsonData={
				"checklist_id" : id
			}
		var urldo = 'reportForm_getInquiryLogChecklistDetails';
		var backdo = 'getInquiryLogChecklistDetails_back';
	}else if(num == 3){
		var jsonData={
				"guidance_id" : id
			}
		var urldo = 'reportForm_getInquiryLogHealthGuidanceDetails';
		var backdo = 'getInquiryLogHealthGuidanceDetails_back';
	}else if(num == 4){
		var jsonData={
				"hospitalization_id" : id
			}
		var urldo = 'reportForm_getInquiryLogHospitalizationDetails';
		var backdo = 'getInquiryLogHospitalizationDetails_back';
	}
	console.log(jsonData)
	var jsonAjax = {
		"url": urldo+".do",
		"jsonData": {"mapStr":jsonToStr(jsonData)},
		"methodName":backdo
	}
	getAjaxData(jsonAjax);
}


//处方记录详情
function getInquiryLogPrescriptionDetails_back(jsonBack){
	console.log(jsonBack.data)
	debugger;
	var data=strToJson(jsonBack.data).data;
	var doctorMap = data.doctorMap;
	var prescriptionMap = data.prescriptionMap;////处方内容
	var prescriptionList = prescriptionMap.prescriptionList;//处方
	var inquiryMap = data.inquiryMap;//诊断信息
	var content='';
	if(numallPrescription == 0){
		content +='<h1 style="margin-top: 20px;font-size: 16px;font-weight: bold;text-align: center;position: relative;">用药详情 <span onclick="closeimg()" style="position: absolute; top: 0px;    cursor: pointer;  right: 10px; display: inline-block; width: 14px; height: 14px;" >X</span></h1>';
		content +='<div class="width_title detailsmedication_text" style=" display: flex; align-items: center; flex-wrap: wrap;" >';
		if(prescriptionMap.prescription_type == 1){//处方类型  1中药 2西药
			content +='<div style="flex: 1;  color: #666; font-size: 14px;margin-top: 20px; text-align: center; overflow: hidden;">用药方法：<span style="color: #46a2fe;">'+ prescriptionMap.prescription_taking +'</span></div>';
			content +='<div style="flex: 1;  color: #666; font-size: 14px;margin-top: 20px; text-align: center; overflow: hidden;">天数(付数)：<span style="color: #46a2fe;">'+ prescriptionMap.prescription_num +'</span></div>';
			content +='<div style="flex: 1;  color: #666; font-size: 14px;margin-top: 20px; text-align: center; overflow: hidden;">用药要求：<span style="color: #46a2fe;">'+ prescriptionMap.prescription_requirements +'</span></div>';
		}
		
		content +='</div><div class="width_title backgroundf8f7f7" style="border: none;padding: 10px;background: #f8f7f7; margin: 20px;    display: flex;align-items: center; flex-wrap: wrap;"><div  style="flex: 1;  color: #999; font-size: 12px;text-align: center; overflow: hidden;">药品名称</div>';
		content +='<div style="flex: 1;  color: #999; font-size: 12px;text-align: center; overflow: hidden;">用量</div><div style="flex: 1;  color: #999; font-size: 12px;text-align: center; overflow: hidden;">用量单位</div><div style="flex: 1;  color: #999; font-size: 12px;text-align: center; overflow: hidden;">特殊用法</div></div>';
		content +='<ul class="ullist" style="height: 350px;overflow: hidden;overflow-y: scroll;    list-style: none;">';
		for(var i = 0; i < prescriptionList.length;i++){
			content +='<li style="margin: 0px 20px;padding: 10px 0;"><div class="width_title" style="display: flex;align-items: center; flex-wrap: wrap;">';
			content +='<div style="flex: 1; color: #666; font-size: 14px;text-align: center; overflow: hidden;">'+ prescriptionList[i].drug_name +'</div>';
			content +='<div style="flex: 1; color: #666; font-size: 14px;text-align: center; overflow: hidden;">'+ prescriptionList[i].details_consumption +'</div>';
			content +='<div style="flex: 1; color: #666; font-size: 14px;text-align: center; overflow: hidden;">'+ nothingFun(prescriptionList[i].details_consumption_util,' ') +'</div>';
			content +='<div style="flex: 1; color: #666; font-size: 14px;text-align: center; overflow: hidden;">'+ prescriptionList[i].details_usage +'</div>';
			content +='</div></li>';
		}
		
		content +='</ul>';
		jQuery('.PrescriptionDetails').html(content)
	}else{
		content +='<div class="bcImg" style="background: #e8f3fb;height:735px;">';
		content +='<div class="w420" style="width: 520px;  margin: 0 auto; background: #e8f3fb; overflow: hidden; font-size:12px ;">';
		content +='<div class="cf-one noewm" style=" padding: 5px 10px 0px 10px;  position: relative; z-index: 3;">';
		content +='<div style="position:absolute;top:20px;right:20px;border:1px solid #C5C5C5; color:#C5C5C5;   line-height: 16px;">';
		content +='<span style="display:block">普　　通</span><span style="display:block">药品处方</span>';
		content +='</div><h1 class="txtc bold" style=" font-size: 16px; line-height: 20px;text-align:center;">';
		content +='<div>珠海高新技术产业开发区人民医院</div><div >(广东省第二人民医院珠海医院)</div><div>互联网医院处方笺</div></h1>';
		content +='<div class="top-box" style=" position: relative; padding: 10px 0; border-bottom: 1px solid #999;  overflow: hidden;">';
		content +='<span class="feibie" style="line-height: 34px;  height: 34px; color: #333; position: absolute; width: 38px; margin-left: -35px;">费别：</span>';
		content +='<div class="top-r" style="  overflow: hidden; line-height: 14px;">';
		content +='<div class="clearfix" style="overflow:hidden">';
		content +='<span class="xz" style=" height: 14px; line-height: 14px;  width: 45px; display: block; float: left;"><img style="margin-right: 3px; float: left;" src="form/reportForm/img/feiyongiocn.png">公费</span>';
		content +='<span class="xz" style=" height: 14px;  line-height: 14px;  width: 45px;  display: block; float: left;"><img style="margin-right: 3px; float: left;" src="form/reportForm/img/feiyongiocnA.png">自费</span>';
		content +='</div><div class="clearfix pt5" style="overflow:hidden;padding-top: 5px;">';
		content +='<span class="fr code_box" style="float: right; line-height: 14px;    margin-right: 4px;">处方编号：<em id="recipe_code">' + nothinglrsj(prescriptionMap.lrsj)+ '' + prescriptionMap.prescription_id+ '</em></span> ';
		content +='<span class="xz" style="height: 14px; line-height: 14px; width: 45px; display: block;  float: left;"><img style="margin-right: 3px;  float: left;" src="form/reportForm/img/feiyongiocn.png">医保</span> ';
		content +='<span class="xz" style="height: 14px; line-height: 14px;  width: 45px;  display: block; float: left;"><img style="margin-right: 3px; float: left;" src="form/reportForm/img/feiyongiocn.png">其他</span> <b id="">自费病人</b>';
		content +='</div></div></div><div class="info-one" style="  padding: 5px 0; border-bottom: 1px solid #999;">';
		content +='<div class="info-list" style=" line-height: 24px;  overflow: hidden;">';
		content +='<span class="grgy" style="float: left; min-height: 18px; color: #333;">姓名：</span>';
		content +='<span class="ws1" style="width: 110px; border-bottom: 1px solid #999;  line-height: 18px; height: 18px;  float: left; min-height: 18px;">' + inquiryMap.inquiry_patient_name + '</span>';
		content +='<span class="ml20 grgy" style=" float: left;  min-height: 18px; margin-left: 5px;color: #333;">性别：</span>';
		if(inquiryMap.inquiry_patient_sex == 0){
			content +='<span class="xz" style="float: left;  min-height: 18px;height: 14px; line-height: 14px;  width: 40px;  display: block;  margin-top: 2px;"><img style="margin-right: 3px; float: left" src="form/reportForm/img/feiyongiocnA.png">男</span> ';
			content +='<span class="xz" style=" float: left; min-height: 18px;height: 14px; line-height: 14px;  width: 40px;  display: block; margin-top: 2px;"><img style="margin-right: 3px; float: left" src="form/reportForm/img/feiyongiocn.png">女</span>';
		}else{
			content +='<span class="xz" style="float: left;  min-height: 18px;height: 14px; line-height: 14px;  width: 40px;  display: block;  margin-top: 2px;"><img style="margin-right: 3px; float: left" src="form/reportForm/img/feiyongiocn.png">男</span> ';
			content +='<span class="xz" style=" float: left; min-height: 18px;height: 14px; line-height: 14px;  width: 40px;  display: block; margin-top: 2px;"><img style="margin-right: 3px; float: left" src="form/reportForm/img/feiyongiocnA.png">女</span>';
		}
		content +='<span class="ml20 grgy" style=" float: left;  min-height: 18px; margin-left: 0px;color: #333;">年龄：</span>';
		content +='<span class="ws5" style="width: 76px; border-bottom: 1px solid #999; line-height: 18px; height: 18px;float: left;  min-height: 18px;">'+ /*inquiryMap.patientAge*/inquiryMap.inquiry_patient_age +'岁</span>';
		content +='<span class="grgy tz" style="float: left; min-height: 18px; color: #333;">体重：</span>';
		content +='<span class="ws3 tz" id="weight" style="width: 41px; float: left;  min-height: 18px; border-bottom: 1px solid #999;  line-height: 18px;  height: 18px;">'+ nothingFun(inquiryMap.inquiry_patient_weight,'---') +'</span>';
		content +='<span class="tz" style="line-height: 18px;float: left;  min-height: 18px;">千克</span>';
		content +='</div><div class="info-list tzbox" style="line-height: 24px; overflow: hidden;">';
		content +='<span class="grgy wdd1" style="float: left; min-height: 18px;  color: #333;  line-height: 18px;">门诊/住院病历号：</span>';
		content +='<span class="ws12" id="doc_mz" style="width: 156px;float: left; min-height: 18px;border-bottom: 1px solid #999;  line-height: 18px; height: 18px;">' + nothinglrsj(inquiryMap.lrsj)+ ''+ inquiryMap.log_id +'</span>';
		content +='<span class="grgy wdd1" style="float: left;     margin-left: 10px;min-height: 18px;color: #333;line-height: 18px;">科别（病区/床位号）：</span>';
		content +='<span class="ws2" id="doc_dept" style="width: 75px; float: left;  min-height: 18px;  border-bottom: 1px solid #999; line-height: 18px; height: 18px;">'+ doctorMap.department_name +'</span>';
		content +='</div><div class="info-list" style="line-height: 24px;  overflow: hidden;">';
		content +='<span class="grgy wdd1" style="float: left; min-height: 18px; color: #333;line-height: 18px;">临床诊断：</span>';
		var lof_diagnosis = inquiryMap.lof_diagnosis;
		var lof_diagnosis2='';
//		alert(inquiryMap.lof_diagnosis.length)
//		if(!isUndefinedAndEmpty(inquiryMap.lof_diagnosis)){
//			if(inquiryMap.lof_diagnosis.length > 12){
//				var lof_diagnosis = inquiryMap.lof_diagnosis.substring(0, 12)
//				var lof_diagnosis2 = inquiryMap.lof_diagnosis.substring(12,100)
//			}
//		}
		content +='<span id="diagnose" class="ws6" style="white-space: nowrap; word-wrap: break-word;break-word: break-all;float: left;  min-height: 18px;  width: 196px;  border-bottom: 1px solid #999;  line-height: 18px;  height: 18px;"><span></span></span>';
		content +='<span class="grgy ml10 wdd1" style=" float: left;  min-height: 18px;color: #333; margin-left: 10px;line-height: 18px;">开具日期：</span>';
		content +='<span class="ws1" id="recipe_date" style="width: 152px; border-bottom: 1px solid #999;  line-height: 18px;  height: 18px; float: left;  min-height: 18px;">' + nothinglrsj2(prescriptionMap.lrsj)+ '</span>';
		content +='</div><div class="info-list pl60" style="padding-left: 60px;line-height: 24px; overflow: hidden;">';
		content +='<span class="ws16" id="diagnose2" style="white-space: nowrap;  float: left;  min-height: 18px;min-width: 196px; border-bottom: 1px solid #999; line-height: 19px;  padding: 3px 0px"><span></span></span>';
		content +='</div><div class="info-list" style="line-height: 24px;  overflow: hidden;">';
		content +='<span class="grgy wdd1" style="float: left; min-height: 18px;color: #333;line-height: 18px;">住址/电话：</span>';
		content +='<span class="ws7" style="float: left;  min-height: 18px; width: 415px; border-bottom: 1px solid #999;  line-height: 18px;   padding: 2px 0px;" id="telbos"><em id="more_address">'+ nothingFun(inquiryMap.inquiry_patient_address,'未提供')+'/</em><em class="ml10" style="margin-left: 10px;" id="phone">'+  nothingFun(inquiryMap.inquiry_patient_phone,'未提供') +'</em></span>';
		content +='</div></div>';
		content +='<div class="info-two" style="padding-top: 5px;  padding-bottom: 5px;  border-bottom: 1px solid #999;position: relative;">';
		content +='<p class="font14 bold" style="font-size:14px;font-weight: bold;-webkit-margin-before: 0; -webkit-margin-after: 0; -webkit-margin-start: 0px;  -webkit-margin-end: 0px;">Rp</p>';
		content +='<div class="info-twoin" id="recipe_dd" style="  height: 300px;  position: relative;">';
		content +='<table width="100%" border="0" cellspacing="0" cellpadding="0" class="mt5" style="    border: none;margin-top: 0px;font-size:12px;line-height: 16px;overflow: hidden;">';
		for(var i = 0; i < prescriptionList.length;i++){
			if(prescriptionMap.prescription_type == 2){//处方类型  1中药 2西药
				content +='<tbody><tr style="font-size:12px">';
				content +='<td width="6%" height="16" class="color9" style="font-size:12px;padding:0">'+ (i+1) +'、 </td>';
				content +='<td width="94%" height="16" colspan="2" style="font-size:12px;padding:0"><span class="pr10" style="font-size:12px">'+ prescriptionList[i].drug_name +'</span>　'+ prescriptionList[i].details_num+prescriptionList[i].drug_packaging_unit +' ('+ prescriptionList[i].drug_specifications +')</td>';
				content +='</tr><tr>';
				content +='<td width="6%" height="16" class="color9" style="font-size:12px;padding:0"></td>';
				content +='<td width="8%" height="16" class="color9" style="font-size:12px;padding:0">Sig：</td>';
				content +='<td width="86%" height="16" style="font-size:12px;padding:0">'+ prescriptionList[i].details_usage+' '+prescriptionList[i].details_frequency_str+'　每次'+prescriptionList[i].details_consumption+''+prescriptionList[i].details_consumption_util+'　用药'+prescriptionList[i].details_day+'天</td>';
				content +='</tr></tbody>';
			}else{
				content +='<tbody style="float:left;width:50%"><tr style="font-size:12px">';
				content +='<td width="6%" height="16" class="color9" style="font-size:12px;padding:0">'+ (i+1) +'、 </td>';
				content +='<td width="94%" height="16" colspan="2" style="font-size:12px;padding:0"><span class="pr10" style="font-size:12px;    width: 100px;">'+ prescriptionList[i].drug_name +'</span>　　'+ prescriptionList[i].details_consumption +''+prescriptionList[i].details_consumption_util+'　　'+ nothingFun(prescriptionList[i].details_usage,'')+'</td>';
				content +='</tr></tbody>';
			}
		}
		content +='</table>';
		content +='<p style="font-size: 12px;  text-align: center; padding-top: 5px;-webkit-margin-before: 0; -webkit-margin-after: 0; -webkit-margin-start: 0px;  -webkit-margin-end: 0px;">本页完</p></div>';
		if(prescriptionMap.prescription_type == 1){//处方类型  1中药 2西药
			content +='<div class="tips" style="font-weight: bold;position: absolute; bottom: 0; left: 0;">'+ prescriptionMap.prescription_requirements +'，'+ prescriptionMap.prescription_taking +'，'+ prescriptionMap.prescription_num +'付</div>';			
		}	
		content +='</div>';
		content +='<div class="info-three" style="padding-top: 5px;  padding-bottom: 2px; border-bottom: 1px solid #999;  position: relative;">';
		content +='<div class="imgbox"style="position: absolute;right: 0; top: -10px;display: none;"></div>';
		content +='<div class="info">';
		content +='<div class="noyibao" style="margin-top: 5px;"><div class="info-list" style="line-height: 24px; overflow: hidden;">';
		content +='<div class="info-threer" style="width: 255px;float: left;line-height: 18px;">';
		content +='<span class="ysspan grgy wdd1" style=" float: left; min-height: 18px;padding-top: 10px;color: #333;line-height: 18px;">医&nbsp;&nbsp;师：</span>';
		content +='<div class="info-three-qm"style="width: 182px; margin-top: 10px; float: left;    position: relative; border-bottom: 1px solid #999;line-height: 18px;">';
		if(!isUndefinedAndEmpty(doctorMap.doctor_autograph)){
			content +='<span class="info-three-qmin"style=" float: left; min-height: 18px;width: 60px;height: 30px; line-height: 18px;  position: absolute; top: -12px; right: 25px;" id="doctor_name">';
			content +='<img src="'+ doctorMap.doctor_autograph +'" style="width:60px; height:30px;border-radius:0 !important;vertical-align: top; border: none;  "></span>';
		}
		content +='<div id="docnamestr"style=" clear: both;height: 19px;line-height: 19px;">' + doctorMap.doctor_name + '</div>';
		content +='</div></div>';
		content +='<div class="ddsa" style=" padding-top: 10px; float: left;line-height: 18px;">';
		content +='<span class="grgy wdd1" style=" float: left; min-height: 18px;color: #333;line-height: 18px;">';
		var prescription_price=''
		if(prescriptionMap.prescription_price != 0){
			var prescription_price = prescriptionMap.prescription_price;
		}
		content +='药品金额：</span> <span class="ws8" id="fourid" style="float: left;  min-height: 18px; width: 165px;  border-bottom: 1px solid #999;  line-height: 18px; height: 18px;">' + prescription_price + '</span>';
		content +='</div></div></div>';
//		
		content +='<div class="noyibao" style="margin-top: 5px;"><div class="info-list" style="line-height: 24px; overflow: hidden;">';
		content +='<div class="info-threer" style="width: 255px;float: left;line-height: 18px;">';
		content +='<span class="ysspan grgy wdd1" style=" float: left; min-height: 18px;padding-top: 10px;color: #333;line-height: 18px;">审核药师：</span>';
		content +='<div class="info-three-qm"style="width: 165px; margin-top: 10px; float: left;    position: relative; border-bottom: 1px solid #999;line-height: 18px;">';
		if(!isUndefinedAndEmpty(prescriptionMap.prescription_audited_doctor_img)){
			content +='<span class="info-three-qmin"style=" float: left; min-height: 18px;width: 60px;height: 30px;line-height: 18px;  position: absolute; top: -12px; right: 25px;" id="doctor_name">';
			content +='<img src="'+ prescriptionMap.prescription_audited_doctor_img +'" style="width:60px; height:30px;vertical-align: top; border: none;  border-radius:0 !important"></span>';
		}
		content +='<div id="docnamestr"style=" clear: both;height: 19px;line-height: 19px;">'+  nothingFun(prescriptionMap.prescription_audited_doctor,'') +'</div>';
		content +='</div></div>';
		content +='<div class="ddsa" style=" padding-top: 10px; float: left;line-height: 18px;">';
		content +='<span class="grgy wdd1" style=" float: left; min-height: 18px;color: #333;line-height: 18px;">';
		content +='调配药师/士：</span> <span class="ws8" id="fourid" style="float: left;  min-height: 18px; width: 148px;  border-bottom: 1px solid #999;  line-height: 18px; height: 18px;"></span>';
		content +='</div></div></div>';
		content +='<div class="clearfix signature"style="overflow:hidden;line-height: 22px;margin-top:12px">';
		content +='<span class="grgy wdd1"style="float: left;color: #333; line-height: 22px;">核对、发药药师：</span>';
		content +='<span class="ws9 hd"style="float: left;width: 384px;border-bottom: 1px solid #999;line-height: 18px; height: 18px;"id="hedui"><b></b><img width="70px" class="noshow"style="display: none;"><img width="70px" class="noprint"style="display:none; position: absolute;margin-top: -10px; max-height: 35px;vertical-align: top;border: none;"></span>';
		content +='</div></div></div>';
		content +='<p class="pt10 clserd"style=" padding-top: 5px; -webkit-margin-before: 0;-webkit-margin-after: 0; -webkit-margin-start: 0px;-webkit-margin-end: 0px;">医师处方仅开具当日有效（医师注明除外）</p>';
		content +='</div></div></div>';	
		content +='<div class="tapBtn" style="text-align: center;">';	
		content +='<div class="cursor buttoncursor"  style="display: inline-block;margin: 20px 10px;  padding: 2px 20px;  background: #2b73cc !important;  border: 1px solid #2b73cc !important;  color: #fff !important; border-radius: 6px;cursor: pointer;" onclick="printAll(1,'+ prescriptionMap.prescription_id +')">打印</div>';
		content +='<div class="cursor buttoncursor2" style=" background: #fff;border: 1px solid #00b3ff; color: #00b3ff;display: inline-block; margin: 20px 10px;padding: 2px 20px;border-radius: 6px; cursor: pointer;"><a style="    color: #00b3ff;" class="cursor downloadimg" href="'+ prescriptionMap.prescription_imgurl +'" download="处方' + nothinglrsj(prescriptionMap.lrsj)+ ''+ prescriptionMap.prescription_id +'.png">保存图片</a></div>';
		content +='</div>';	
		content +='</div><img class="prescription_imgurl" style="cursor: pointer;position: absolute; top: 50px; left: 0;  z-index: -1;display:none"  src="'+ prescriptionMap.prescription_imgurl +'"/>';
		jQuery('.dy_PrescriptionDetails').html(content);
		tustr(inquiryMap.lof_diagnosis)
	}
	
}
//检验打印 
function getInquiryLogChecklistDetails_back(jsonBack){
	console.log(jsonBack.data)
	var data=strToJson(jsonBack.data).data;
	var checklistMap = data.checklistMap;//检验信息
	var checklistDetailsList = checklistMap.checklistDetailsList;//检验列表
	var doctorMap = data.doctorMap;//医生信息
	var inquiryMap = data.inquiryMap;//诊断信息
	var content='';
	// checklist_type 检验单类型 1普通建议单  2心电检验单  3普通检验单
	if(checklistMap.checklist_type == 1){
		content +='<div class="w420 arial" style="width: 520px;  margin: 0 auto; background: #fff; overflow: hidden; font-size:12px ;">';
		content +='<div class="cf-one" style="width: 520px; padding: 10px 15px 0px 15px; position: relative;  z-index: 3;">';
		content +='<h1 class="txtc bold" style="font-size: 16px; line-height: 20px;text-align:center;">';
		content +='<div>珠海高新技术产业开发区人民医院</div><div >(广东省第二人民医院珠海医院)</div><div>互联网医院检验检查单</div>';
		content +='</h1><div class="clearfix pt10 pb10" style="padding: 0; width:490px;margin-right:10px;height:30px">';
		content +='<em class="fr" style="float: right;">NO.<span id="applyid">' + nothinglrsj(inquiryMap.lrsj)+ '' + checklistMap.checklist_id + '</span></em>';
		content +='</div><div class="info-five" style="width: 490px;border: 1px solid #d2d4d7;border-bottom:none">';
		content +='<table width="100%" border="0" cellspacing="0" cellpadding="0" class="info-table" style="border:none;margin:0; width: 100%; font-size:12px;">';
		content +='<tbody><tr>';
		content +='<td width="33%" height="28" style="border-right: 1px solid #d2d4d7;border-bottom: 1px solid #d2d4d7;padding: 3px;"><span class="color9" style="color: #999;">姓名：</span><span id="name">' + inquiryMap.inquiry_patient_name + '</span></td>';
		if(inquiryMap.inquiry_patient_sex == 0){
			content +='<td width="32%" height="28" style="border-right: 1px solid #d2d4d7;border-bottom: 1px solid #d2d4d7;padding: 3px;"><span class="color9"style="color: #999;">性别：</span><span >男</span> </td>';
		}else{
			content +='<td width="32%" height="28" style="border-right: 1px solid #d2d4d7;border-bottom: 1px solid #d2d4d7;padding: 3px;"><span class="color9"style="color: #999;">性别：</span><span >女</span> </td>';
		}
		content +='<td width="35%" height="28" style="border-bottom: 1px solid #d2d4d7;padding: 3px;"><span class="color9"style="color: #999;">年龄：</span><span >'+ /*inquiryMap.patientAge*/inquiryMap.inquiry_patient_age +'岁</span></td>';
		content +='</tr><tr>';
		content +='<td height="28" style="border-right: 1px solid #d2d4d7;border-bottom: 1px solid #d2d4d7;padding: 3px;"><span class="color9"style="color: #999;">电话：</span><span>'+ nothingFun(inquiryMap.inquiry_patient_phone,'未提供') +'</span></td>';
		content +='<td height="28" style="border-right: 1px solid #d2d4d7;border-bottom: 1px solid #d2d4d7;padding: 3px;"><span class="color9"style="color: #999;">指导医生：</span><span id="doctorname">'+ doctorMap.doctor_name +'</span></td>';
		content +='<td height="28" style="border-bottom: 1px solid #d2d4d7;padding: 3px;"><span class="color9"style="color: #999;">就诊日期：</span><span id="date">'+ nothinglrsj2(checklistMap.lrsj) +'</span></td>';
		content +='</tr><tr>';
		content +='<td height="60" colspan="3" valign="top" style="border-bottom: 1px solid #d2d4d7;padding: 3px;line-height:18px;word-wrap: break-word;word-break: break-all;">';
		content +='<span class="bold" style="line-height: 18px;  word-wrap: break-word;  word-break: break-all;">初步诊断：</span><span id="Diagnosis" style="word-wrap: break-word;">'+ nothingFun(inquiryMap.lof_diagnosis) +'</span>';
		content +='</td></tr><tr>';
		content +='<td height="30" colspan="3" valign="top" style="border-bottom: 1px solid #d2d4d7;padding: 3px;line-height:18px;word-wrap: break-word;word-break: break-all;"><span class="color9" style="color: #999;">主诉：</span><span id="main_diag" style="word-wrap: break-word;">'+ nothingFun(inquiryMap.log_main_suit) +'</span></td>';
		content +='</tr></tbody></table></div>';
		content +='<div class="info-six clearfix" style="border-right: 1px solid #d2d4d7; border-bottom: 1px solid #d2d4d7;     background: #d2d4d7; border-left: 1px solid #d2d4d7;  width: 490px;overflow:hidden">';
		content +='<div class="info-sixin" style="width:244px;float: left;">';
		content +='<div class="info-sixin-title" style="height: 30px; line-height: 30px;  padding: 0px 10px;  font-weight: bold; border-bottom: 1px solid #d2d4d7;">检验项目</div>';
		content +='<div class="info-sixin-body" id="jianyan" style="padding: 0px 5px 10px 5px; min-height: 180px;    background: #fff;">';
		for(var i = 0; i < checklistDetailsList.length;i++){
			if(checklistDetailsList[i].checklist_type == 1){//检查类型 1检验（只能建议）  2检查（只能建议）  3心电检验（可申请） 4普通检验（可申请）
				content +='<p style="padding-top: 5px; font-size:12px; line-height: 16px; display: block; -webkit-margin-before: 0;  -webkit-margin-after: 0; -webkit-margin-start: 0px;  -webkit-margin-end: 0px;"><span class="color9" style="color: #999;">'+ (i+1) +'、</span>'+ checklistDetailsList[i].checklist_name +'</p>';
			}
		}
		content +='</div></div><div class="info-sixin" style="width: 244px; float: left;">';
		content +='<div class="info-sixin-title" style="background: #d2d4d7;border-left:1px solid #d2d4d7;height: 30px;line-height: 30px; padding: 0px 10px; font-weight: bold;  border-bottom: 1px solid #d2d4d7;">检查项目</div>';
		content +='<div class="info-sixin-body" id="jiancha" style="padding: 0px 5px 10px 5px;min-height: 180px;    background: #fff; border-left: 1px solid #d2d4d7;">';
		for(var i = 0; i < checklistDetailsList.length;i++){
			if(checklistDetailsList[i].checklist_type != 1){//检查类型 1检验（只能建议）  2检查（只能建议）  3心电检验（可申请） 4普通检验（可申请）
				content +='<p style="padding-top: 5px; font-size:12px;line-height: 16px;display: block; -webkit-margin-before: 0;  -webkit-margin-after: 0; -webkit-margin-start: 0px;  -webkit-margin-end: 0px;"><span class="color9" style="color: #999;">'+ (i+1) +'、</span>'+ checklistDetailsList[i].checklist_name +'</p>';
			}
		}
		content +='</div></div></div>';
		content +='<div class="info-six clearfix" style="border-left:1px solid #d2d4d7; border-bottom:1px solid #d2d4d7; background:none;width: 490px;    border-right: 1px solid #d2d4d7;">';
		content +='<div class="info-sixin-title" style="height: 30px;  line-height: 30px; padding: 0px 10px; font-weight: bold; border-bottom: 1px solid #d2d4d7;">处理意见</div>';
		content +='<div class="info-sixin-body" style="padding: 0px 5px 10px 5px;min-height:50px; padding-top:5px;word-wrap: break-word;word-break: normal;">';
		content +='<span id="yijian" style="word-wrap: break-word;">'+ nothingFun(checklistMap.treatment_suggestion,'') +'</span>';
		content +='</div></div><div class="pt10" style="padding-top: 0px;">';
		content +='<p class="bold pb5" style="padding-bottom: 0px; font-size:12px;font-weight: bold;  display: block; -webkit-margin-before: 0;  -webkit-margin-after: 0; -webkit-margin-start: 0px;  -webkit-margin-end: 0px;">温馨提醒：</p>';
		content +='<p class="color9" style="color: #999;line-height: 16px;font-size:12px;font-weight: bold;  display: block; -webkit-margin-before: 0;  -webkit-margin-after: 0; -webkit-margin-start: 0px;  -webkit-margin-end: 0px;">您的病情暂无法给出明确诊断，需完善上述检查之后再来复诊，祝您早日康复！</p>';
		content +='</div> </div>';
		content +='<div class="tapBtn backgbule" style="text-align:center"><div style="cursor: pointer;display: inline-block;margin: 20px 10px;  padding: 2px 20px;  background: #2b73cc !important;  border: 1px solid #2b73cc !important;  color: #fff !important; border-radius: 6px;" class="backgroundbule cursor buttoncursor" onclick="printAll(2,'+ checklistMap.checklist_id +')">打印</div></div>';	
        content +='</div>';
	}else if(checklistMap.checklist_type == 2 || checklistMap.checklist_type == 3 ){
		content +='<div class="ckWrap" id="electrocardioList" style="    width: 520px; background: #fff; margin: 0 auto;background: #fff; overflow: hidden; font-size:12px ;">';
		content +='<h1 class="txtc bold" style="font-size: 16px; line-height: 20px;text-align:center;">';
		content +='<div>珠海高新技术产业开发区人民医院</div><div >(广东省第二人民医院珠海医院)</div><div>'+ checklistMap.checklist_name +'申请单</div>';
		content +='</h1><div class="ckBody"><div class="topboxs" style="clear:both;">';
		content +='<p class="ckNumber" style="float: right;display: inline-block;margin: 8px 0 4px;">NO.' + nothinglrsj(inquiryMap.lrsj)+ '' + checklistMap.checklist_id + '</p>';
		content +='</div><table class="ckTable" cellspacing="0" border="1" style="border-collapse: collapse; border-spacing: 0; border: 1px solid #d2d4d7;font-size:12px ; width: 100%; margin-bottom: 10px; color: #000;">';
		content +='<tbody><tr class="ckTr1" style="line-height: 26px;">';
		content +='<td style=" width: 120px; padding-left: 8px;  padding-right: 4px;  border: 1px solid #d2d4d7; word-break: break-all;  word-wrap: break-word;"><span class="ckGray" style=" color: #8f9399;">姓名：</span>' + inquiryMap.inquiry_patient_name + '</td>';
		if(inquiryMap.inquiry_patient_sex == 0){
			content +='<td class="wd1" style="width: 140px;padding-left: 8px;  padding-right: 4px;  border: 1px solid #d2d4d7; word-break: break-all;  word-wrap: break-word;"><span class="ckGray" style=" color: #8f9399;">性别：</span>男</td>';
		}else{
			content +='<td class="wd1" style="width: 140px;padding-left: 8px;  padding-right: 4px;  border: 1px solid #d2d4d7; word-break: break-all;  word-wrap: break-word;"><span class="ckGray" style=" color: #8f9399;">性别：</span>女</td>';
		}
		content +='<td class="wd2" style="width: 138px;padding-left: 8px;  padding-right: 4px;  border: 1px solid #d2d4d7; word-break: break-all;  word-wrap: break-word;"><span class="ckGray"style=" color: #8f9399;">年龄：</span>'+ /*inquiryMap.patientAge*/inquiryMap.inquiry_patient_age +'岁</td>';
		content +='</tr><tr class="ckTr1" style="line-height: 26px;">';
		content +='<td style=" width: 120px; padding-left: 8px;  padding-right: 4px;  border: 1px solid #d2d4d7; word-break: break-all;  word-wrap: break-word;"><span class="ckGray" style=" color: #8f9399;">电话：</span>'+ nothingFun(inquiryMap.inquiry_patient_phone,'未提供') +'</td>';
		content +='<td class="wd1" style="width: 140px;padding-left: 8px;  padding-right: 4px;  border: 1px solid #d2d4d7; word-break: break-all;  word-wrap: break-word;"><span class="ckGray" style=" color: #8f9399;">指导医生：</span>'+ doctorMap.doctor_name +'</td>';
		content +='<td class="wd2" style="width: 138px;padding-left: 8px;  padding-right: 4px;  border: 1px solid #d2d4d7; word-break: break-all;  word-wrap: break-word;"><span class="ckGray"style=" color: #8f9399;">就诊日期：</span>'+ nothinglrsj2(checklistMap.lrsj) +'</td>';
		content +='</tr><tr class="ckTr2" style="line-height: 26px;">';
		content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">检查项目：</td>';
		var  checklist_name ='';
		for(var i =0;i < checklistDetailsList.length;i++){
			checklist_name +=checklistDetailsList[i].checklist_name +'、'
		}
		
		content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">'+ checklist_name.substring(0,checklist_name.length-1); +'</td>';
		content +='</tr>';
		if(checklistMap.checklist_type == 2){
			content +='<tr class="ckTr2" style="    line-height: 26px;">';
			content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">上次心电图检查号：</td>';
			content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">'+ checklistMap.checklist_last_code +'</td>';
			content +='</tr>';
		}
		content +='<tr class="ckTr2" style="line-height: 26px;">';
		content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">病史检查摘要：</td>';
		content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">'+ checklistMap.checklist_abstract +'</td>';
		content +='</tr>';
		if(checklistMap.checklist_type == 2){
			content +='<tr class="ckTr2" style="line-height: 26px;">';
			content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">【血压】收缩压：</td>';
			content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">'+ checklistMap.checklist_sbp +'毫米汞柱</td>';
			content +='</tr><tr class="ckTr2" style="line-height: 26px;">';
			content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">【血压】舒张压：</td>';
			content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">'+ checklistMap.checklist_dbp +'毫米汞柱</td>';
			content +='</tr>';
		}
		content +='<tr class="ckTr2" style="    line-height: 26px;">';
		content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">主诉：</td>';
		content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">'+ nothingFun(inquiryMap.log_main_suit) +'</td>';
		content +='</tr><tr class="ckTr2" style="line-height: 26px;">';
		content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">现病史：</td>';
		content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">'+ nothingFun(inquiryMap.log_present_illness,'') +'</td>';
		content +='</tr>';
		if(checklistMap.checklist_type == 3){
			content +='<tr class="ckTr2" style="    line-height: 26px;">';
			content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">有关检验结果：</td>';
			content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">'+ checklistMap.checklist_inspection_result +'</td>';
			content +='</tr>';
		}
		content +='<tr class="ckTr2" style="line-height: 26px;">';
		content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">临床诊断：</td>';
		content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">'+ nothingFun(inquiryMap.lof_diagnosis) +'</td>';			
		content +='</tr>';
		if(checklistMap.checklist_type == 2){
			content +='<tr class="ckTr2" style="    line-height: 26px;">';
			content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">最近两周洋地黄用量：</td>';				
			content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">';
			if(checklistMap.is_digitalization == 0){//是否使用过洋地黄  0否 1是
				content +='否';
			}else{
				content +='是，用量：'+ checklistMap.checklist_digitalization_num+'，时间：'+ checklistMap.checklist_digitalization_start+'-'+ checklistMap.checklist_digitalization_end+'';				
			}
			content +='</td></tr><tr class="ckTr2" style="    line-height: 26px;">';
			content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">其他有关药物：</td>';				
			content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">';
			if(checklistMap.is_other_drugs == 0){//是否使用有关药物    0否 1是
				content +='无';
			}else{
				content +='是，名称：'+ checklistMap.checklist_other_drugs_name+'，用量：'+ checklistMap.checklist_other_drugs_num+'，时间：'+ checklistMap.checklist_other_drugs_start+'-'+ checklistMap.checklist_other_drugs_end+'';	
			}
			content +='</td></tr>';
		}
		content +='<tr class="ckTr2" style="    line-height: 26px;">';				
		content +='<td class="ckGray2" style="width: 120px;padding-top: 4px;  padding-bottom: 4px; padding-left: 8px;   padding-right: 4px;  border: 1px solid #d2d4d7;  word-break: break-all; word-wrap: break-word;">备注：</td>';
		content +='<td class="wd3" colspan="2" style="padding-top: 4px;padding-bottom: 4px;padding-left: 8px; padding-right: 4px;  border: 1px solid #d2d4d7;word-break: break-all; word-wrap: break-word; width: 236px;">'+ nothingFun(checklistMap.bz,'') +'</td>';
		content +='</tr></tbody></table>';	
		if(checklistMap.checklist_type == 3){
			content +='<p style=" font-weight: bold;  display: block; -webkit-margin-before: 0;  -webkit-margin-after: 0; -webkit-margin-start: 0px;  -webkit-margin-end: 0px;    line-height: 16px;"><span style="color:#e70000">*</span>被检查须知：探查胆囊、胰腺应空腹、探查下腹部（子宫、附近、膀胱、前列腺）应膀胱贮尿;需做经直肠超声、经腔内超声造影、经颅彩色多普勒、超声引导下介入、经食复诊请带回上次检查报告单。</p>';
		}
		content +='</div>';	
		content +='<div class="tapBtn backgbule" style="text-align:center"><div style="cursor: pointer;display: inline-block;margin: 20px 10px;  padding: 2px 20px;  background: #2b73cc !important;  border: 1px solid #2b73cc !important;  color: #fff !important; border-radius: 6px;" class="backgroundbule cursor buttoncursor" onclick="printAll(2,'+ checklistMap.checklist_id +')">打印</div></div>';		
		content +='</div>';
	}
	jQuery('.ChecklistDetails').html(content)
}


//健康指导
function getInquiryLogHealthGuidanceDetails_back(jsonBack){
	debugger;
	console.log(jsonBack.data)
	var data=strToJson(jsonBack.data).data;
	var doctorMap = data.doctorMap;//医生信息
	
	var inquiryMap = data.inquiryMap;//诊断信息
	var guidanceMap = data.guidanceMap;//诊断信息
	var content='';	
	
	content +='<div class="main_warp w420" style="width:520px;  margin: 0 auto; background: #fff; overflow: hidden; font-size:12px ;">';	
	content +='<h1 class="txtc bold" style="font-size: 16px; line-height: 20px;text-align:center;">';	
	content +='<div>珠海高新技术产业开发区人民医院</div><div >(广东省第二人民医院珠海医院)</div><div>互联网医院健康指导意见书</div>';	
	content +='</h1><div class="center_box" style="padding: 10px 15px 0;">';	
	content +='<ul style="overflow: hidden; list-style-type: none;-webkit-margin-before: 0;-webkit-padding-start: 0;  -webkit-margin-after: 0;  -webkit-margin-start: 0px;">';	
	content +='<li style="float: left;  width: 33.3%; line-height: 24px;"><em style="font-weight: bold;  font-style: normal;">姓名：</em><span >' + inquiryMap.inquiry_patient_name + '</span></li>';	
	if(inquiryMap.inquiry_patient_sex == 0){
		content +='<li style="float: left;  width: 33.3%; line-height: 24px;"><em style="font-weight: bold;  font-style: normal;">性别：</em><span >男</span></li>';	
	}else{
		content +='<li style="float: left;  width: 33.3%; line-height: 24px;"><em style="font-weight: bold;  font-style: normal;">性别：</em><span >女</span></li>';	
	}
	content +='<li style="float: left;  width: 33.3%; line-height: 24px;"><em style="font-weight: bold;  font-style: normal;">年龄：</em><span  >'+ /*inquiryMap.patientAge*/inquiryMap.inquiry_patient_age +'岁</span></li>';	
	content +='<li style="float: left;  width: 100%; line-height: 24px;"><em style="font-weight: bold;  font-style: normal;">初步诊断：</em><span  >'+ nothingFun(inquiryMap.lof_diagnosis) +'</span></li>';	
	content +='<li style="float: left;  width: 100%; line-height: 24px;"><em style="font-weight: bold;  font-style: normal;">健康指导：</em><span>';	
	content +='<div class="yijian" style="min-height: 350px;  padding: 5px 10px 5px;  line-height: 22px; color: #333;  border: 1px solid #e2e2e2;  word-break: break-all;  word-wrap: break-word;">'+ nothingFun(guidanceMap.guidance_content) +'</div>';	
	content +='</li></ul>';	
	content +='<div class="time" style="line-height: 30px; color: #bbbbbb;">';	
	content +='<span style="float: right;">指导医生：<b id="doctor" style="font-weight: normal;">'+ doctorMap.doctor_name +'</b></span>';	
	content +='指导日期：<b id="time"style="font-weight: normal;">'+ guidanceMap.lrsj +'</b>';	
	content +='</div></div>';
	content +='<div class="tapBtn backgbule" style="text-align:center">';
	content +='<div class="backgroundbule cursor buttoncursor" style="cursor: pointer;display: inline-block;margin: 20px 10px;  padding: 2px 20px;  background: #2b73cc !important;  border: 1px solid #2b73cc !important;  color: #fff !important; border-radius: 6px;" onclick="printAll(3,'+ guidanceMap.guidance_id+')">打印</div>';
	content +='</div>';
	content +='</div>';	
	
	jQuery('.HealthGuidanceDetails').html(content)
}
//住院建议
function getInquiryLogHospitalizationDetails_back(jsonBack){
	console.log(jsonBack.data)
	var data=strToJson(jsonBack.data).data;
	var hospitalizationMap = data.hospitalizationMap;
	var doctorMap = data.doctorMap;
	var inquiryMap = data.inquiryMap;
	var content='';	
	content +='<div class="w420 arial" style="width: 520px; margin: 0 auto; background: #fff;font-size:12px;  overflow-y: auto;  position: relative;">';
	content +='<div class="cf-one" style="width: 520px;  padding: 10px 0 0px; position: relative;  z-index: 3; ">';
	content +='<h1 class="txtc bold" style="font-size: 16px; line-height: 20px;text-align:center;">';
	content +='<div>珠海高新技术产业开发区人民医院</div><div >(广东省第二人民医院珠海医院)</div><div>互联网医院住院建议书</div></h1>';
	content +='<div class="info-five clearfix">';
	content +='<table width="100%" border="0" cellspacing="0" cellpadding="0" class="info-table" style="width: 100%;  border-left: 1px solid #d2d4d7; border-top: 1px solid #d2d4d7;">';
	content +='<tbody><tr>';
	content +='<td width="50%" class="style1" style="border-right: 1px solid #d2d4d7;  border-bottom: 1px solid #d2d4d7; padding: 10px;"><span class="color9" style="color: #999;">姓名：</span><span >' + inquiryMap.inquiry_patient_name + '</span></td>';
	content +='<td width="50%" class="style1" style="border-right: 1px solid #d2d4d7;  border-bottom: 1px solid #d2d4d7; padding: 10px;"><span class="color9" style="color:#999">年龄：</span><span >'+ /*inquiryMap.patientAge*/inquiryMap.inquiry_patient_age +'岁</span></td>';
	content +='</tr><tr><td width="50%" class="style1" style="border-right: 1px solid #d2d4d7;  border-bottom: 1px solid #d2d4d7; padding: 10px;"><span class="color9" style="color: #999;">性别：</span>';
	if(inquiryMap.inquiry_patient_sex == 0){
		content +='<span>男</span>';
	}else{
		content +='<span>女</span>';
	}
	
	content +='</td>';
	content +='<td width="50%" class="style1" style="border-right: 1px solid #d2d4d7;  border-bottom: 1px solid #d2d4d7; padding: 10px;"><span class="color9" style="color:#999">手机：</span><span >'+ nothingFun(inquiryMap.inquiry_patient_phone,'未提供') +'</span></td>';
	content +='</tr><tr>';
	content +='<td colspan="2" style="border-right: 1px solid #d2d4d7;  border-bottom: 1px solid #d2d4d7; padding: 10px;"><span class="color9" style="color:#999">身份证号码：</span><span id="cridcode">' + nothingFun(inquiryMap.inquiry_patient_idcard,'未提供') + '</span></td>';
	content +='</tr><tr>';
	content +='<td height="80" colspan="2" valign="top" style="line-height:18px;word-wrap: break-word;word-break: break-all;border-right: 1px solid #d2d4d7; border-bottom: 1px solid #d2d4d7;  padding: 10px;">';
	content +='<span class="color9" style="color: #999;">初步诊断：</span><span id="Diagnosis" style="word-wrap: break-word;">'+ nothingFun(inquiryMap.lof_diagnosis) +'</span>';
	content +='</td></tr><tr>';
	content +='<td height="80" colspan="2" valign="top" style="line-height:18px;word-wrap: break-word;word-break: break-all;border-right: 1px solid #d2d4d7; border-bottom: 1px solid #d2d4d7;  padding: 10px;">';
	content +='<span class="color9" style="color: #999;">主要症状：</span><span id="main_diag" style="word-wrap: break-word;">'+ nothingFun(inquiryMap.log_main_suit) +'</span>';
	content +='</td></tr>';
	content +='<tr>';
	content +='<td colspan="2" style="border-right: 1px solid #d2d4d7;  border-bottom: 1px solid #d2d4d7; padding: 10px;"<span class="color9" class="color9">建议：</span><span id="jianyi">到'+hospitalizationMap.hospitalization_hospital+hospitalizationMap.hospitalization_department +'办理住院手续</span></td>';
	content +='</tr>';
	content +='<tr>';
	content +='<td height="60" colspan="2" valign="top" style="line-height:18px;word-wrap: break-word;word-break: break-all;border-right: 1px solid #d2d4d7;  border-bottom: 1px solid #d2d4d7; padding: 10px;">';
	content +='<span class="color9" style="color: #999;">备注：</span><span id="remark">'+ nothingFun(hospitalizationMap.bz,'') +'</span>';
	content +='</td></tr><tr><td height="48" colspan="2" style="border-right: 1px solid #d2d4d7;  border-bottom: 1px solid #d2d4d7; padding: 10px;"><span class="color9" style="color:#999">医生签名：</span><span id="signimg">'+ doctorMap.doctor_name +'';
	if(!isUndefinedAndEmpty(doctorMap.doctor_autograph)){
		content +='<img src="'+ doctorMap.doctor_autograph +'" style="width:60px; height:30px;border-radius:0 !important">';
	}
	
	content +='</span></td></tr></tbody></table>';
	content +='<div class="pt10 fl" style="float: left; padding-top: 0;">';
	content +='<p class="color9 pb5" style="padding-bottom: 5px;color: #999;-webkit-margin-before: 0;-webkit-margin-after: 0;-webkit-margin-start: 0px;-webkit-margin-end: 0px;">联系电话：<span id="hos_phone">'+ doctorMap.doctor_phone +'</span></p>';
	content +='</div>';
	content +='<div class="pt10 fr" style="padding-top: 0px; float: right;">';
	content +='<p class="color9 pb5" style="padding-bottom: 5px;color: #999;-webkit-margin-before: 0;-webkit-margin-after: 0;-webkit-margin-start: 0px;-webkit-margin-end: 0px;">开具日期：<span id="cr_time">'+ hospitalizationMap.lrsj +'</span></p>';
	content +='</div></div></div>';
	content +='<div class="tapBtn backgbule" style="text-align:center">';	
	content +='<div class="backgroundbule cursor buttoncursor" style="cursor: pointer;display: inline-block;margin: 20px 10px;  padding: 2px 20px;  background: #2b73cc !important;  border: 1px solid #2b73cc !important;  color: #fff !important; border-radius: 6px;" onclick="printAll(4,'+ hospitalizationMap.hospitalization_id +')">打印</div>';
	content +='</div>';
	content +='</div>';
	jQuery('.HospitalizationDetails').html(content)
}

function nothingFun(str,txt) {
	if(isUndefinedAndEmpty(str)){
		return txt
	}else{
		return str
	}
}
function nothinglrsj2(str) {
	var str_Y = str.substring(0,4);
	var str_M = str.substring(5,7);
	var str_D = str.substring(8,10);
	return str_Y + '年' + str_M +'月' + str_D +'日';
	
}
function nothinglrsj(str) {
	var str_Y = str.substring(0,4);
	var str_M = str.substring(5,7);
	var str_D = str.substring(8,10);
	return str_Y + str_M + str_D;
	
}
function tustr(text){
	var w = $("body #diagnose").width();
	   String.prototype.visualLength = function(){ 
	    var ruler = $("body #diagnose >span"); 
	    ruler.text(this); 
	    return ruler[0].offsetWidth; 
	   } 
	   var len = 0; 
	   var txt ='';
	   for(var i=0; i<text.length; i++){
	    if(len<w){
	     len += text[i].visualLength();
	     txt += text[i];
	    }
	   } 
	   $("body span#diagnose >span").html(txt);
	   $("body span#diagnose2 >span").html(text.substring(txt.length,text.length))
}