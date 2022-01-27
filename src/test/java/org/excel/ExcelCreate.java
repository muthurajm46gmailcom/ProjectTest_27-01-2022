package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCreate {
	
	public static void main(String[] args) throws IOException {
		
		File loc =new File("C:\\Users\\Muthu Raj\\eclipse-workspace\\MavenProject\\src\\test\\resources\\Excel\\mut.xlsx");
		
	//	Workbook w=new XSSFWorkbook();
		
	//	Sheet s = w.createSheet("m1");
		
	//	Row r = s.createRow(3);
		
	//	Cell cell = r.createCell(3);
		
//		cell.setCellValue("ravi");
//		
//		FileOutputStream fo=new FileOutputStream(loc);
//		
//		w.write(fo);
//		
//		System.out.println("done");
		
		FileInputStream fi=new FileInputStream(loc);
		
		
        Workbook w=new XSSFWorkbook(fi);
		
		Sheet s = w.getSheet("m1");
		
		Row r = s.getRow(3);
		
		Cell cell = r.getCell(3);
		
		String value = cell.getStringCellValue();
		if(value.equals("suja")) {
			cell.setCellValue("man");	
		}
		
		
		
		System.out.println(cell);
		
		FileOutputStream fo=new FileOutputStream(loc);
		
		w.write(fo);
		
		System.out.println("done");
		
		
	}

}
