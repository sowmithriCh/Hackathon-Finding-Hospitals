package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base_Page.Test_Base;


public class excel {
	public void createExcel() throws IOException { 
		FileOutputStream 	file= new FileOutputStream(System.getProperty("user.dir")+"\\testData\\data.xlsx");
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet s = book.createSheet("sheet1");
		List<String> list=Test_Base.data;
		for(int i=0;i<list.size();i++) {
			XSSFRow r = s.createRow(i);
			XSSFCell c = r.createCell(0);
			c.setCellValue(list.get(i));
			
			}
		
		book.write(file);
		book.close(); 
		file.close();
	}
  
}
