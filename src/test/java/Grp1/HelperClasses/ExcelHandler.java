package Grp1.HelperClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.*;

import Grp1.base.ConfigurationClass;

public class ExcelHandler {
	
	public static XSSFSheet XLWSheet;
	public static XSSFWorkbook XLWbook;
	public static XSSFCell xLCell1;
	public static XSSFCell xLCell2;
	public static XSSFCell xLCell3;
	public static XSSFCell xLCell;
	
	public void setExcelFile() throws IOException {	
		
		FileInputStream excelFile= new FileInputStream(ConfigurationClass.XLPath);
		System.out.println(ConfigurationClass.XLPath);
		XLWbook=new XSSFWorkbook(excelFile);
		XLWSheet=XLWbook.getSheet(ConfigurationClass.XLSheetName);
		System.out.println(XLWSheet.getSheetName());
	}
	
	public  Map<String, String> getCellData(){
		int lastRow=XLWSheet.getLastRowNum();
		System.out.println(lastRow);
		int counter=1;
		Map <String,String> loginCreds=new HashMap<String,String>();
			while(counter<=lastRow){
				xLCell1=XLWSheet.getRow(counter).getCell(0);
				xLCell2=XLWSheet.getRow(counter).getCell(1);
				xLCell3=XLWSheet.getRow(counter).getCell(2);
				loginCreds.put(xLCell1.getStringCellValue(), xLCell2.getStringCellValue());
				counter+=1;
			}
		return loginCreds;
		 
	}
	
	public  void setCellData(String data,int rownum,int colnum ){
		XSSFRow Row=XLWSheet.getRow(rownum);
		xLCell=Row.getCell(colnum,Row.RETURN_BLANK_AS_NULL);
			if(xLCell==null){
				xLCell=Row.createCell(colnum);
				xLCell.setCellValue(data);
			}
			else{
				xLCell.setCellValue(data);
			}
	}
		
		
		
		
	}
	
	
	
	
