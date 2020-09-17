package com.servicesAdmin.excel.export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.util.SysFinal;
import com.util.UtilExcel;
import com.util.UtilJson;
import com.util.UtilValiDate;

/**
 * excel导出
 */
@Service("excelExportServerImp")
public class ExcelExportServerImp implements ExcelExportServer{
	 @Resource 
	 private GYDAO gyDAOimp;// dao操作类
	/**
	 * 数据导出总分类
	 */
	public String getDataExportData(Map<String,String> mapStr)throws Exception{
		List<String>list_title=new LinkedList<String>();
		List<Map<String, Object>>ListMapData=new LinkedList<Map<String, Object>>();
		Map<String, String>backmap=new HashMap<String, String>();
		if(!UtilValiDate.isEmpty(mapStr.get("dataBaseName"))){
			backmap.put("code", "250");
			backmap.put("info", "请选定需导出的数据表！");
			return UtilJson.mapToJson(backmap);
		}
		String filePath=SysFinal.tempFile;
		//获取基本数据
		if("t_BasicInfo".equals(mapStr.get("dataBaseName"))){
			getBasicInfo(list_title, ListMapData);
			filePath+="基本数据.xls";
		}
		//获取 传统项目
		if("t_Item".equals(mapStr.get("dataBaseName"))){
			this.getTableItem(list_title, ListMapData);
			filePath+="传统项目.xls";
		}
		//获取 串联项目
		if("t_Item_ms".equals(mapStr.get("dataBaseName"))){
			this.getTabledItemMs(list_title, ListMapData);
			filePath+="串联项目.xls";
		}
		//获取 疾病信息
		if("t_Disease".equals(mapStr.get("dataBaseName"))){
			this.getTabledDisease(list_title, ListMapData);
			filePath+="疾病信息.xls";
		}
		//获取质控管理 质控数据
		if("t_ControlData".equals(mapStr.get("dataBaseName"))){
			this.getTabledControlData(list_title, ListMapData);
			filePath+="质控数据.xls";
		}
		//获取质控管理 质控批号
		if("t_ControlBatch".equals(mapStr.get("dataBaseName"))){
			this.getTabledControlBatch(list_title, ListMapData);
			filePath+="质控批号.xls";
		}
		//获取质控管理 质控物
		if("t_Controler".equals(mapStr.get("dataBaseName"))){
			this.getTabledControler(list_title, ListMapData);
			filePath+="质控物.xls";
		}
		//获取样本管理 筛查登记
		if("t_BloodDetail1".equals(mapStr.get("dataBaseName"))){
			this.getTabledScreening(list_title, ListMapData);
			filePath+="采血卡登记.xls";
		}
		//获取样本管理 采血卡核收
		if("t_BloodDetail2".equals(mapStr.get("dataBaseName"))){
			this.getTabledAcceptanceCheck(list_title, ListMapData);
			filePath+="采血卡核收.xls";
		}
		//获取传统项目 实验数据
		if("t_ExperimentalData7".equals(mapStr.get("dataBaseName"))){
			this.getTableExperiment(list_title, ListMapData);
			filePath+="实验数据.xls";
		}
		//获取传统项目 筛查结果
		if("t_BloodDetail4".equals(mapStr.get("dataBaseName"))){
			this.getTableScreening(list_title, ListMapData);
			filePath+="传统项目筛查结果.xls";
		}
		//获取串联项目 实验数据
		if("t_Item_ms7".equals(mapStr.get("dataBaseName"))){
			this.getTableSeriEsexperiments(list_title, ListMapData);
			filePath+="串联项目实验数据.xls";
		}
		//获取串联项目 筛查结果
		if("t_BloodDetail9".equals(mapStr.get("dataBaseName"))){
			this.getTableTandemScreening(list_title, ListMapData);
			filePath+="串联项目筛查结果.xls";
		}
		
		if(list_title.size()<=0) {
			backmap.put("code", "220");
			backmap.put("info", "没有指定导出的标题！");
			return UtilJson.mapToJson(backmap);
		}
		if(ListMapData.size()<=0) {
			backmap.put("code", "230");
			backmap.put("info", "没有需要导出的数据！");
			return UtilJson.mapToJson(backmap);
		}
		
		UtilExcel.writeExcle(list_title, ListMapData, filePath);//将需导出的文件写到服务器
		backmap.put("code", "200");
		backmap.put("info", "导出数据获取成功！");
		backmap.put("data", filePath);//导出文件地址
		return UtilJson.mapToJson(backmap);
	}
	
	
	/******************************************获取导出的数据模板*************************************************/
	/**
	 * 基本资料 导出模板
	 */
	public void getBasicInfo(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("类型");
		list_title.add("编号");
		list_title.add("名称");
		StringBuffer sql = new StringBuffer();Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY FType,FNumber) as  num,FType,FNumber,FName from t_BasicInfo");
		ListMapData.addAll(this.gyDAOimp.findSqlList(sql, mapSQLParameter));
		//对数据进行处理 将类型的数字变为对应的文字
		for (Map<String, Object> map : ListMapData){
			if("1".equals(map.get("FType")+"")) {
				map.put("FType", "区域");
			}else if("2".equals(map.get("FType")+"")) {
				map.put("FType", "省份");
			}else if("3".equals(map.get("FType")+"")) {
				map.put("FType", "样本属性");
			}else if("4".equals(map.get("FType")+"")) {
				map.put("FType", "样本质量");
			}else if("5".equals(map.get("FType")+"")) {
				map.put("FType", "样本类型");
			}else if("6".equals(map.get("FType")+"")) {
				map.put("FType", "筛查结论");
			}else if("7".equals(map.get("FType")+"")) {
				map.put("FType", "试验结论");
			}
		}
	}
	/**
	 * 基本资料 导出模板
	 */
	public void getTableItem(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("编号");
		list_title.add("项目名称");
		list_title.add("指标简称");
		list_title.add("测试方法");
		list_title.add("参考范围");
		list_title.add("单位");
		list_title.add("收费金额");
		list_title.add("返还金额");
		list_title.add("排序");
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY FNumber) as  num,FNumber,FName,FSortName,FTestType,FRef,FUnit,FPrice,FRePrice,FOrderID from t_Item");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
	}
	
	/**
	 * 基本资料 导出模板 串联项目
	 */
	public void getTabledItemMs(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("编号");
		list_title.add("项目名称");
		list_title.add("指标简称");
		list_title.add("单位");
		list_title.add("下限");
		list_title.add("上限");
		list_title.add("打印");
		list_title.add("计算");
		list_title.add("排序");
		list_title.add("公式");
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY FNumber) as  num,FNumber,FName,FSortName,FUnit,FLWLimit,FUPLimit,FIsPrint,FIsCalculate,FOrderID,FFormula from t_Item_ms");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
		//对数据进行处理 将类型的数字变为对应的文字
		for (Map<String, Object> map : ListMapData){
			if("0".equals(map.get("FIsPrint")+"")) {
				map.put("FIsPrint", "否");
			}else if("1".equals(map.get("FIsPrint")+"")) {
				map.put("FIsPrint", "是");
			}else if("0".equals(map.get("FIsCalculate")+"")) {
				map.put("FIsCalculate", "否");
			}else if("1".equals(map.get("FIsCalculate")+"")) {
				map.put("FIsCalculate", "是");
			}
		}
	}

	/**
	 * 基本资料 导出模板  疾病信息
	 */
	public void getTabledDisease(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("ID");
		list_title.add("疾病名称");
		list_title.add("显示名称");
		list_title.add("显示排序");
		list_title.add("公式");
		list_title.add("适用范围");
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY FID) as  num,FID,FName,FDisplay,FSort_index,FFormula,FStatus from t_Disease");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
		//对数据进行处理 将类型的数字变为对应的文字
		for (Map<String, Object> map : ListMapData){
			if("0".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "停用");
			}else if("1".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "上升");
			}else if("2".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "下降");
			}
		}
		
		
	}
	
	/**
	 * 质控管理 导出模板  质控数据
	 */
	public void getTabledControlData(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("日期");
		list_title.add("质控物");
		list_title.add("质控数据");
		list_title.add("质控批号");
		list_title.add("项目");

		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY t.FControlDate) as  num, t.FControlDate,tc.FName as  FControlerName,FControlData,t.FControlBatch,it.FName from t_ControlData t ,t_Controler tc ,(select FNumber as FItem,FName from t_Item union all select FNumber as FItem,FName from t_Item_ms) it where it.FItem=t.FItem and tc.FNumber=t.FControler");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
	}
	/**
	 * 质控管理 导出模板  质控批号
	 */
	public void getTabledControlBatch(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("质控批号");
		list_title.add("质控物");
		list_title.add("靶值");
		list_title.add("SD值");
		list_title.add("CV值");
		list_title.add("价格");
		list_title.add("规格");

		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY FControlBatch) as  num,t.FControlBatch,t.FControler,t.FTarget,t.FSD,t.FCV,t.FPrice,t.FFormat,tc.FName from t_ControlBatch t,t_Controler tc where tc.FNumber=t.FControler");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
	}
	
	/**
	 * 质控管理 导出模板  质控物
	 */
	public void getTabledControler(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("质控物编号");
		list_title.add("质控物名称");
		list_title.add("标识");
		list_title.add("单位");
		list_title.add("项目");
		list_title.add("方法学");
		list_title.add("厂家");

		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		//sql.append("select ROW_NUMBER() OVER(ORDER BY FNumber) as  num,FNumber,FName,FFlag,FUnit,FItem,FFangfaxue,FFatory from t_Controler");
		sql.append("select ROW_NUMBER() OVER(ORDER BY FNumber) as  num,FNumber,FName,FFlag,FUnit,FItem,FFangfaxue,FFatory from t_Controler");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
	}
	
	/**
	 * 基本资料 导出模板  筛查登记
	 */
	public void getTabledScreening(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("采血卡号");
		list_title.add("采血单位");
		list_title.add("母亲名字");
		list_title.add("性别");
		list_title.add("核收日期");
		list_title.add("出生日期");
		list_title.add("采血日期");
		list_title.add("时间");
		list_title.add("联系手机");
		list_title.add("状态");

		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY FBloodNumber) as  num,FBloodNumber,FBloodUnit,FMotherName,FSex,FReceiveDate,FBirthday,FBloodDate,FBloodTime,FPhone,FStatus from t_BloodDetail");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
		//对数据进行处理 将类型的数字变为对应的文字
		for (Map<String, Object> map : ListMapData){
			if("0".equals(map.get("FSex")+"")) {
				map.put("FSex", "男");
			}else if("1".equals(map.get("FSex")+"")) {
				map.put("FSex", "女");
			}else if("0".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "未上传");
			}else if("1".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已上传");
			}else if("2".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已核收");
			}else if("3".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "退回");
			}else if("4".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已检测");
			}else if("5".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已审核");
			}else if("7".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已分审");
			}
		}
	}
	
	/**
	 * 基本资料 导出模板  采血卡核收
	 */
	public void getTabledAcceptanceCheck(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("采血卡号");
		list_title.add("样本编号");
		list_title.add("采血单位");
		list_title.add("母亲名字");
		list_title.add("性别");
		list_title.add("出生日期");
		list_title.add("采血日期");
		list_title.add("核收日期");
		list_title.add("样本属性");
		list_title.add("状态");
		
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY FBloodNumber) as  num,FBloodNumber,FTestNumber,FBloodUnit,FMotherName,FSex,FBirthday,FBloodDate,FReceiveDate,FSampleAttribute,FStatus from t_BloodDetail");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
		//对数据进行处理 将类型的数字变为对应的文字
		for (Map<String, Object> map : ListMapData){
			if("0".equals(map.get("FSex")+"")) {
				map.put("FSex", "男");
			}else if("1".equals(map.get("FSex")+"")) {
				map.put("FSex", "女");
			}else if("0".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "未上传");
			}else if("1".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已上传");
			}else if("2".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已核收");
			}else if("3".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "退回");
			}else if("4".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已检测");
			}else if("5".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已审核");
			}else if("7".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已分审");
			}
		}
	}
	/**
	 * 传统项目 导出模板  实验数据
	 */
	public void getTableExperiment(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("样本编号");
		list_title.add("实验日期");
		list_title.add("实验员");
		list_title.add("项目");
		list_title.add("方法学");
		list_title.add("实验数据");
		list_title.add("标识");
		list_title.add("参考范围");
		
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY t.FNumber) as num, t.FNumber,CONVERT(varchar(100),t. FTestDate, 23) as FTestDate,t.FTestMan,a.FName,a.FTestType,t.FTestValue,t.FResult,a.FRef from t_ExperimentalData t join t_Item a on t.FItem=a.FNumber");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
		//对数据进行处理 将类型的数字变为对应的文字
		for (Map<String, Object> map : ListMapData){
			if("1".equals(map.get("FResult")+"")) {
				map.put("FResult", "阴性");
			}else if("2".equals(map.get("FResult")+"")) {
				map.put("FResult", "杂合子");
			}else if("3".equals(map.get("FResult")+"")) {
				map.put("FResult", "样本不及格");
			}else if("4".equals(map.get("FResult")+"")) {
				map.put("FResult", "阳性");
			}else if("5".equals(map.get("FResult")+"")) {
				map.put("FResult", "临界区间");
			}
		}
 
	}
	
	/**
	 * 传统项目 导出模板  筛查结果
	 */
	public void getTableScreening(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("样本编号");
		list_title.add("采血卡号");
		list_title.add("采血单位");
		list_title.add("采血日期");
		list_title.add("母亲名字");
		list_title.add("性别");
		
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY a.FTestNumber) as num, a.FTestNumber,a.FBloodNumber,a.FBloodUnit,a.FBloodDate,a.FMotherName,a.FMotherName,a.FSex from t_BloodDetail a,t_Item t where t.FNumber=a.FTestNumber");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
		//对数据进行处理 将类型的数字变为对应的文字
		for (Map<String, Object> map : ListMapData){
			if("0".equals(map.get("FSex")+"")) {
				map.put("FSex", "男");
			}else if("1".equals(map.get("FSex")+"")) {
				map.put("FSex", "女");
			}
		}
	}
	
	/**
	 * 串联项目 导出模板  实验数据
	 */
	public void getTableSeriEsexperiments(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("样本编号");
		list_title.add("实验日期");
		list_title.add("实验员");
		list_title.add("阳性");
		list_title.add("筛查结果");
		list_title.add("结论与建议");
		
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY a.FNumber) as num, a.FNumber,a.FLastLoginDate,a.FTestMan,a.Fstatus,a.FConclusion,a.FDoctorNote from t_Item_ms t,t_data a where 1=1 and t.FNumber=a.FNumber");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
		//对数据进行处理 将类型的数字变为对应的文字
		for (Map<String, Object> map : ListMapData){
			if("0".equals(map.get("Fstatus")+"")) {
				map.put("Fstatus", "阴性");
			}else if("1".equals(map.get("Fstatus")+"")) {
				map.put("Fstatus", "阳性");
			}
		}
	}
	
	/**
	 * 串联项目 导出模板  筛查结果
	 */
	public void getTableTandemScreening(List<String>list_title,List<Map<String, Object>>ListMapData) throws Exception {
		//导出的名称
		list_title.add("序号");
		list_title.add("样本编号");
		list_title.add("采血卡号");
		list_title.add("采血单位");
		list_title.add("采血日期");
		list_title.add("母亲名字");
		list_title.add("性别");
		list_title.add("筛查结果");
		list_title.add("状态");
		
		StringBuffer sql = new StringBuffer();
		Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		//获取导出的数据
		sql.append("select ROW_NUMBER() OVER(ORDER BY a.FTestNumber) as num, a.FTestNumber,a.FBloodNumber,a.FBloodUnit,a.FBloodDate,a.FMotherName,a.FSex,a.FMotherCard,a.FStatus from t_BloodDetail a,t_Item t where 1=1 and t.FNumber=a.FTestNumber");
		List<Map<String, Object>> findSqlList = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
		if(findSqlList.size()>0){
			ListMapData.addAll(findSqlList);
		}
		//对数据进行处理 将类型的数字变为对应的文字
		for (Map<String, Object> map : ListMapData){
			if("0".equals(map.get("FSex")+"")) {
				map.put("FSex", "男");
			}else if("1".equals(map.get("FSex")+"")) {
				map.put("FSex", "女");
			}else if("0".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "未上传");
			}else if("1".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已上传");
			}else if("2".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已核收");
			}else if("3".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "退回");
			}else if("4".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已检测");
			}else if("5".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已审核");
			}else if("7".equals(map.get("FStatus")+"")) {
				map.put("FStatus", "已分审");
			}
		}
	}
	
	
	
	@Override
	public String excelExport(Map<String, String> mapStr) throws Exception {
		Map<String, Object> exportMap = UtilJson.strToMap(mapStr.get("info"));
		//exportType   1正常导出  2自定义导出
		if("1".equals(exportMap.get("exportType"))){
			StringBuffer sql = new StringBuffer();
			Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
			//获取头部信息
			Gson gson = new Gson();
			List<String> list= gson.fromJson(mapStr.get("titleList"), new TypeToken<List<String>>() {}.getType());
			List<String> listTitle= new ArrayList<String>();
			listTitle.add("序号");
			listTitle.addAll(list);
			//获取需显示的字段
			String count=mapStr.get("counts");
			//获取界面名
			sql.append("select (@i:=@i+1)as rowNo, ");
			if(UtilValiDate.isEmpty(count)){
				sql.append(count);
			}else{
				sql.append("a.*");
			}
			sql.append("   from (");
			sql.append(exportMap.get("title"));
			sql.append(" order by t.gxsj desc ");
			sql.append(" )  a,(select   @i:=0)i ");
			mapSQLParameter = UtilJson.strToMap(exportMap.get("info").toString());
			List<Map<String, Object>> listMap = this.gyDAOimp.findSqlList(sql, mapSQLParameter);
			String filePath= UtilExcel.getExcelFilePath();
			UtilExcel.writeExcle(listTitle, listMap, 0, filePath);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("data", filePath);
			map.put("code", "200");
			return UtilJson.mapToJson(map);
		}else if("2".equals(exportMap.get("exportType"))){
			String filePath= UtilExcel.getExcelFilePath();
			Gson gson = new Gson();
			List<String> titlelist= gson.fromJson(exportMap.get("title")+"", new TypeToken<List<String>>() {}.getType());
			List<Map<String, Object>>dataList= gson.fromJson(exportMap.get("info").toString(), new TypeToken<List<Map<String, Object>>>() {}.getType());
			UtilExcel.writeExcle(titlelist, dataList, 0, filePath);
			
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("data", filePath);
			map.put("code", "200");
			return UtilJson.mapToJson(map);
		}
		return "";
	}
	
	
	
	
	
}
