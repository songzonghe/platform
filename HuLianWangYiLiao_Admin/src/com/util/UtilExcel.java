package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.controllerAdmin.ControllerUtil;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * excel 读取操作工具类 2015年10月23日23:36:05
 * 
 * @author 李飞
 * 
 */
public class UtilExcel {
	// 定义日志方法
	private static Logger logger = Logger.getLogger(ControllerUtil.class);
	
	/**
	 * 生成导出excel文件名称
	 * @return String
	 */
	public static String getExcelFilePath()throws Exception{
		return SysFinal.tempFile+UtilSql.getTimeId()+".xls";
	}
	
	/**
	 * 读取excel
	 * @param fileName 当前excel文件
	 * @param rsRows 读取的行数  0表示读取一行  1表示读取全部
	 * @return List<List<String>> 
	 * @throws Exception
	 */
	public static List<List<String>> getExcelTitle(String fileName,int rsRows)throws Exception{
		logger.info("开始读取excel数据...");
		List<List<String>> list_listStr = new ArrayList<List<String>>();
		Workbook readwb = null;
		InputStream instream = null ;
		try {
			instream = new FileInputStream(fileName);
			readwb = Workbook.getWorkbook(instream);
			// Sheet的下标是从0开始
			// 获取第一张Sheet表
			Sheet readsheet = readwb.getSheet(0);
			// 获取Sheet表中所包含的总列数
			int rsColumns = readsheet.getColumns();
			// 获取Sheet表中所包含的总行数
			if(1==rsRows){
				rsRows = readsheet.getRows();
			}else{
				rsRows = 1;
			}
			// 获取指定单元格的对象引用
			for (int i = 0; i < rsRows; i++){
				List<String> listStr = new ArrayList<String>();
				for (int j = 0; j < rsColumns; j++){
					Cell cell = readsheet.getCell(j, i);
					listStr.add(cell.getContents());
				}
				list_listStr.add(listStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("读取excel数据错误"+e.getMessage());
		} finally {
			try {
				readwb.close();
				instream.close();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("关闭读取excel数据错误"+e.getMessage());
			}
		}
		return list_listStr;
	}
	
	
	/**
	 * 导出Excel
	 * @param list_StrName 导出 title 头
	 * @param ListMapData 导出数据集合
	 * @param index 从那里开始
	 * @throws Exception
	 */
	public static void writeExcle(List<String> list_title,List<Map<String, Object>> ListMapData,int index,String filePath) throws Exception {
		logger.info("开始导出excel数据...");
		WritableWorkbook wwb  = null ;
		OutputStream os = null ;
		try {
			os = new FileOutputStream(SysFinal.file+filePath);
			// 创建Excel工作薄
			wwb  = Workbook.createWorkbook(os);
			// 添加第一个工作表并设置第一个Sheet的名字
			WritableSheet sheet = wwb.createSheet("系统导出数据", 0);
			Label label = null;
			jxl.write.WritableFont wfcNav =new jxl.write.WritableFont(WritableFont.ARIAL,13, WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
	        WritableCellFormat wcfN=new WritableCellFormat(wfcNav);
		    wcfN.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框
		    wcfN.setAlignment(Alignment.CENTRE); //设置水平对齐
		    wcfN.setVerticalAlignment(VerticalAlignment.CENTRE);//垂直居中
		    wcfN.setWrap(false); //设置自动换行
	      
		    Map<Integer,Integer> nums= new HashMap<Integer, Integer>();
			if(index==0){
				/********************定义表头**********************/
				for (int i = 0; i < list_title.size(); i++) {
					label = new Label(i, 0,list_title.get(i),wcfN);
					nums.put(i, list_title.get(i).getBytes().length+5);
					sheet.addCell(label);
				}
			}
			 jxl.write.WritableFont wfcontent =new jxl.write.WritableFont(WritableFont.ARIAL,12, WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
		       WritableCellFormat wcfcontent = new WritableCellFormat(wfcontent);
		       wcfcontent.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框
		       wcfcontent.setAlignment(Alignment.CENTRE);
		       wcfcontent.setVerticalAlignment(VerticalAlignment.CENTRE);//垂直居中
			/********************定义表内容******************/
		       sheet.setRowView(0,500);
			for (int i = 0; i < ListMapData.size(); i++) {
				sheet.setRowView(i+1,500);
				int j = 0 ;
				for(Map.Entry<String, Object> entry:ListMapData.get(i).entrySet()){
					label = new Label(j+index, i+1,UtilStr.getStr(entry.getValue()),wcfcontent);
					if(nums.get(j)<(UtilStr.getStr(entry.getValue()).getBytes().length+5)) {
						nums.put(j, UtilStr.getStr(entry.getValue()).getBytes().length+5);
					}
					sheet.addCell(label);
					j++;
				} 
			}
			for (int i = 0; i < list_title.size(); i++) {
				sheet.setColumnView(i, nums.get(i));//根据内容自动设置列宽
			}
			wwb.write();
		} catch (Exception e) {
			logger.error("导入excle错误...");
			throw e;
		}finally{
			if(null!=wwb){
				wwb.close();
			}
			if(null!=os){
				os.close();
			}
		}
	}
	
	
	/**
	 * 导出Excel 
	 * list_title标题
	 * ListMapData 内容
	 * filePath 文件名称
	 */
	public static void writeExcle(List<String> list_title,List<Map<String, Object>> ListMapData,String filePath) throws Exception {
		logger.info("开始导出excel数据...");
		WritableWorkbook wwb  = null ;
		OutputStream os = null ;
		try {
			os = new FileOutputStream(SysFinal.file+"/"+filePath);
			// 创建Excel工作薄
			wwb  = Workbook.createWorkbook(os);
			// 添加第一个工作表并设置第一个Sheet的名字
			WritableSheet sheet = wwb.createSheet("导出", 0);
			Label label = null;
			
			jxl.write.WritableFont wfcNav =new jxl.write.WritableFont(WritableFont.createFont("仿宋"),12, WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);
	        WritableCellFormat wcfN=new WritableCellFormat(wfcNav);
		    wcfN.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK); //BorderLineStyle边框
		    wcfN.setAlignment(Alignment.CENTRE); //设置水平对齐
		    wcfN.setVerticalAlignment(VerticalAlignment.CENTRE);//垂直居中
		    wcfN.setWrap(false); //设置自动换行
	      
		    Map<Integer,Integer> nums= new HashMap<Integer, Integer>();
			/********************定义表头**********************/
			for (int i = 0; i < list_title.size(); i++) {
				label = new Label(i, 0,list_title.get(i),wcfN);
				nums.put(i, list_title.get(i).getBytes().length+5);
				sheet.addCell(label);
			}
			sheet.setRowView(0,700);
			/********************定义表内容******************/
			if(null!=ListMapData) {
				for (int i = 0; i < ListMapData.size(); i++) {
					sheet.setRowView(i+1,600);
					int j = 0 ;
					for(Map.Entry<String, Object> entry:ListMapData.get(i).entrySet()){
						String data=entry.getValue()+"";
						if(data.indexOf("##")!=-1) {
							data=data.replaceAll("##", "\n");
						}
						label = new Label(j, i+1,UtilStr.getStr(data),wcfN);
						if(UtilValiDate.isEmpty(nums.get(j)) && nums.get(j)<(UtilStr.getStr(entry.getValue()+"").getBytes().length+5)) {
							nums.put(j, UtilStr.getStr(entry.getValue()+"").getBytes().length+5);
						}
						sheet.addCell(label);
						j++;
					} 
				}
			}
			for (int i = 0; i < list_title.size(); i++) {
				sheet.setColumnView(i, nums.get(i));//根据内容自动设置列宽
			}
			wwb.write();
		} catch (Exception e) {
			logger.error("导出excle错误...");
			throw e;
		}finally{
			if(null!=wwb){
				wwb.close();
			}
			if(null!=os){
				os.close();
			}
		}
	}
	
	/**
	 * 导入excel  获取文件内容
	 */
	public static List<Map<String, Object>> readExcel(File file)throws Exception{
		 List<Map<String, Object>>list =new  LinkedList<Map<String,Object>>();
	    try {
	        // 判断文件是否存在
	            // 创建工作簿
	            Workbook workbook = Workbook.getWorkbook(file);//只支持  xls 格式
	            // 获得第一个工作表sheet1
	            Sheet sheet = workbook.getSheet(0);
	            // 获得数据
	            for (int i = 1; i < sheet.getRows(); i++) {// sheet.getRows():表格文件行数
	                Map<String, Object>map = new LinkedHashMap<String, Object>();
	                boolean bool=true;
	                for (int j = 0; j < sheet.getColumns(); j++) {// sheet.getColumns():表格文件列数
	                    Cell cell = sheet.getCell(j, i);
	                    if(j==0 && !UtilValiDate.isEmpty(cell.getContents())) {//排除掉序号为空的
	                    	bool=false;
	                    	break;
	                    }
	                    if(j==0 && !"序号".equals(sheet.getCell(j,0).getContents().trim())){
	                    	map.put("序号", i);
	                    }
	                    if(UtilValiDate.isEmpty(sheet.getCell(j,0).getContents())) {
	                    	map.put((sheet.getCell(j,0).getContents()).trim(), (cell.getContents()).trim()+"");
	                    }
	                }
	                if(bool) {
	                	list.add(map);
	                }
	            }
	            workbook.close();// 关闭
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    return list;
	}
}
