package com.controllerAdmin.excel.export;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.excel.export.ExcelExportServer;
import com.util.UtilJson;
import com.util.UtilSql;
/**
 * excel导出
 */
@Controller
public class ExcelExportController extends ControllerUtil{
	@Resource
	private ExcelExportServer  excelExportServerImp;
	/**************************excel文件导出***********************************/
	@RequestMapping(value = "/excelExport_excelFileExport.do")
	public void excelFileExport(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			logger.info(UtilSql.getGXSJ()+"=====准备导出excel文件=====");
			this.respBack(excelExportServerImp.getDataExportData(mapStr), resp);
		} catch (Exception e) {
			logger.info(UtilSql.getGXSJ()+"=====导出excel文件出错====="+e);
			this.errorResp(e, resp);
		}
	}
	
	/**
	  * 文件下载
    */
    @RequestMapping(value = "/excelExport_download.do")
	  public void download(HttpServletRequest req,HttpServletResponse resp){
    	try {
    		String filePath=req.getParameter("filePath");
    		//下载
		   this.downloadUtil(req,resp, req.getSession().getServletContext().getRealPath("/")+"/"+filePath);	
		} catch (Exception e) {
			e.printStackTrace();
			this.errorResp(e,resp);
		}
    }
	
    

	/**
     * 导出Excel
     */
     @RequestMapping(value = "/excelExport_getExportExcel.do")
	 public void getExportExcel(HttpServletRequest req,HttpServletResponse resp){
    	 try {
    		Map<String,String> mapStr = UtilJson.toMap(req.getParameter("mapStr"));
    		//获取文件名并生成文件
 		    String filePath=excelExportServerImp.excelExport(mapStr);
 		    respBack(filePath, resp);
		 } catch (Exception e) {
			e.printStackTrace();
			this.errorResp(e,resp);
		}
     }
}
