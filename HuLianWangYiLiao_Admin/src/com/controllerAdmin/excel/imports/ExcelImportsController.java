package com.controllerAdmin.excel.imports;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.controllerAdmin.ControllerUtil;
import com.google.gson.Gson;
import com.servicesAdmin.excel.imports.ExcelImportsServer;
import com.util.SysFinal;
import com.util.UtilExcel;
import com.util.UtilJson;
import com.util.UtilSql;
import com.util.UtilTime;
import com.util.UtilValiDate;
/**
 *excel导入
 */
@Controller
public class ExcelImportsController extends ControllerUtil{

	@Resource
	private ExcelImportsServer excelImportsServerImp;
	/**
	 * 打开导入框
	 * @return String 
	 */
	@RequestMapping(value = "/excelImports_importBoxPage.do")
	public String importBoxPage(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		req.setAttribute("dataBaseName", req.getParameter("dataBaseName"));
		List<String>parameterTitle=new LinkedList<String>();//导入文字名称
		//药品 需要导入的字段
		if("util_drug".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug(parameterTitle,null,null,"showName");
		}
		//国际icd 需要导入的字段
		if("util_icd".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_icd(parameterTitle,null,null,"showName");
		}
		//医嘱 需要导入的字段
		if("util_medical_advice".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_medical_advice(parameterTitle,null,null,"showName");
		}
		
		//频率 需要导入的字段
		if("util_drug_frequency".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug_frequency(parameterTitle,null,null,"showName");
		}
		//用法 需要导入的字段
		if("util_drug_usage".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug_usage(parameterTitle,null,null,"showName");
		}
		//属性 需要导入的字段
		if("util_drug_attribute_option".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug_attribute_option(parameterTitle,null,null,"showName");
		}
		//批号 需要导入的字段
		if("util_batch_number".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug_attribute_option(parameterTitle,null,null,"showName");
		}
		//厂家 需要导入的字段
		if("util_company".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug_attribute_option(parameterTitle,null,null,"showName");
		}
		
		//门店机构 需要导入的字段
		if("store_info".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportstore_info_attribute_option(parameterTitle,null,null,"showName");
		}
		
		//字典导入
		if("util_dictionaries".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtilDictionaries(parameterTitle,null,null,"showName");
		}
		req.setAttribute("parameterTitle", parameterTitle);
		return "form_util/page/excelPage.jsp";
	}
	
	/**
	 * 获取导入模板
	 */
	@RequestMapping(value = "/excelImports_importGetDataPage.do")
	public void importGetDataPage(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		req.setAttribute("dataBaseName", req.getParameter("dataBaseName"));
		List<String>parameterTitle=new LinkedList<String>();//导入文字名称
		String filePath=SysFinal.tempFile;
		//药品提示 需要导入的字段
		if("util_drug".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug(parameterTitle,null,null,"showName");
			filePath+="药品数据模板.xls";
		}
		//国际icd 需要导入的字段
		if("util_icd".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_icd(parameterTitle,null,null,"showName");
			filePath+="国际icd模板.xls";
		}
		if("util_medical_advice".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_medical_advice(parameterTitle,null,null,"showName");
			filePath+="医嘱数据模板.xls";
		}
		if("util_drug_frequency".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug_frequency(parameterTitle,null,null,"showName");
			filePath+="频率数据模板.xls";
		}
		if("util_drug_usage".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug_usage(parameterTitle,null,null,"showName");
			filePath+="用法数据模板.xls";
		}
		if("util_drug_attribute_option".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug_attribute_option(parameterTitle,null,null,"showName");
			filePath+="属性数据模板.xls";
		}
		if("util_batch_number".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug_attribute_option(parameterTitle,null,null,"showName");
			filePath+="批号数据模板.xls";
		}
		if("util_company".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtil_drug_attribute_option(parameterTitle,null,null,"showName");
			filePath+="厂家数据模板.xls";
		}
		
		if("store_info".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportstore_info_attribute_option(parameterTitle,null,null,"showName");
			filePath+="门店机构数据模板.xls";
		}
		//字典导入
		if("util_dictionaries".equals(req.getParameter("dataBaseName"))){
			excelImportsServerImp.addImportUtilDictionaries(parameterTitle,null,null,"showName");
			filePath+="字典数据模板.xls";
		}
		Map<String, String>backmap=new HashMap<String, String>();
		if(parameterTitle.size()>0) {
			//开始导出
			UtilExcel.writeExcle(parameterTitle, null, filePath);//将需导出的文件写到服务器
			backmap.put("code", "200");
			backmap.put("info", "导入模板获取成功！");
			backmap.put("data", filePath);//导出文件地址
			respBack(UtilJson.mapToJson(backmap), resp);
		}else {
			backmap.put("code", "250");
			backmap.put("info", "没有编辑导入模板！");
			backmap.put("data", filePath);//导出文件地址
			respBack(UtilJson.mapToJson(backmap), resp);
		}
	}
	
	/**
	 * excel文件导入
	 * 返回参数   code(返回码  )   info（提示信息）total(总数)  success(成功数) 
	 * code(返回码  ) 1  导入完全正常 200   2导入格式错误  210   3导入标题不正确   220   4导入内容为空 230    5导入错误 240    6未指定数据表 250 
	 */
	@RequestMapping(value = "/excelImports_excelFileImport.do")
	public void excelFileImport(@RequestParam(value = "uploadName", required = false) MultipartFile file,HttpServletRequest req,HttpServletResponse resp) {
		try {
			String uploadName = file.getOriginalFilename();
			Map<String,Object> backmap=new LinkedHashMap<String, Object>();
			logger.info(UtilSql.getGXSJ()+"=====准备导入excel文件====="+uploadName);
			//是否存在导入的数据表
			String  dataBaseName=req.getParameter("dataBaseName");
			if(!UtilValiDate.isEmpty(dataBaseName)) {
				backmap.put("code", "250");
				backmap.put("info", "请指定需导入的数据表！");
				this.respBack(getExcelBackInfo(backmap), resp);
				return ;
			}
			if (UtilValiDate.isEmpty(uploadName)){
				if(!UtilValiDate.isExcel(uploadName)){
					backmap.put("code", "210");
					backmap.put("info", "格式错误,请上传xls的文件");
					this.respBack(getExcelBackInfo(backmap), resp);
					return ;
				}
				//将文件上传到服务器 用作读取文件内容
				String newFileName = UtilTime.getTime(SysFinal.YYYYMMDDHHMMSSSSS)+System.currentTimeMillis()+uploadName.substring(uploadName.indexOf("."));
				String filePath =SysFinal.fileFile+UtilTime.getTime("yyyy-MM");
				File fileDir = new File(req.getSession().getServletContext().getRealPath("/")+"/"+filePath);
				if(!fileDir.exists()){//没有文件夹 则创建
					fileDir.mkdirs();
				}
				File savefile = new File(fileDir,newFileName);
				file.transferTo(savefile);//存入数据
				//获取文件中的字段与数据
				List<Map<String, Object>>listContent=UtilExcel.readExcel(savefile);//读取文件内容
				//完成数据读取后删除导入时存在服务器的文件
				String fileAddr=req.getSession().getServletContext().getRealPath("/")+"/"+filePath+"/"+newFileName;
				File fileDel = new File(fileAddr);
				if(fileDel.exists()){
					fileDel.delete();
				}
				//至少有一条内容
				if(!UtilValiDate.isEmpty(listContent) || listContent.size()<1) {
					backmap.put("code", "230");
					backmap.put("info", "请保证导入的文件中存在数据！");
					this.respBack(getExcelBackInfo(backmap), resp);
					return ;
				}
				//开始导入
				Map<String,String> mapStr = this.getMapStr(req);
				mapStr.put("dataBaseName", dataBaseName);
				
				this.respBack(getExcelBackInfo(excelImportsServerImp.addImportDataBaseData(listContent, mapStr)), resp);
			}else{
				this.respBack("error",resp);
				logger.info("excel导入出现错误"+uploadName);
			}
		} catch (Exception e) {
			this.errorResp(e, resp);
		}
	}
	
	/**
	 * 返回参数
	 * @param mapStr
	 * @return
	 */
	private String getExcelBackInfo(Map<String,Object> mapStr){
		Map<String,String> backMap =new LinkedHashMap<String, String>();
		//返回参数
		//返回码1  导入完全正常 200   2导入格式错误  210   3导入标题不正确   220   4导入内容为空 230    5导入错误 240    6未指定数据表 250 
		backMap.put("code", mapStr.get("code")+"");//返回码
		backMap.put("info", mapStr.get("info")+"");//提示信息
		if(UtilValiDate.isEmpty(mapStr.get("total"))){
			backMap.put("total", mapStr.get("total")+"");//总数
		}else {
			backMap.put("total", "0");//总数
		}
		if(UtilValiDate.isEmpty(mapStr.get("success"))){
			backMap.put("success", mapStr.get("success")+"");//成功数
		}else {
			backMap.put("success", "0");//成功数
		}
		Gson gson=new Gson();
		return gson.toJson(backMap);
	}
}
