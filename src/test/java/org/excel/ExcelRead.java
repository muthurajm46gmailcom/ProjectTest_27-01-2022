package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelRead {
	
	public static void main(String[] args) throws IOException {
		// File
		File Location=new File("C:\\Users\\Muthu Raj\\eclipse-workspace\\MavenProject\\src\\test\\resources\\Excel\\Excel.xlsx");
		
		//InputStreem
		FileInputStream fi=new FileInputStream(Location);
		
		//WorkBook
		Workbook w=new XSSFWorkbook(fi);
		
		//Sheet
		Sheet s=w.getSheet("Muthu");
		
		//Row
		Row row=s.getRow(4);
		
		//Cell
		Cell cell=row.getCell(0);
		System.out.println(cell);
		
		//Row Count
		int NumofRows = s.getPhysicalNumberOfRows();
		System.out.println(NumofRows);
		
		//Cell Count
		int CellCount = row.getPhysicalNumberOfCells();
		System.out.println(CellCount);
		
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row rows=s.getRow(i);
			for (int j = 0; j < rows.getPhysicalNumberOfCells(); j++) {
			 Cell cells = rows.getCell(j);
			 
			 int type = cells.getCellType();
				System.out.println(type);
				
				if(type==1) {
					String value = cells.getStringCellValue();
					System.out.println(value);
				}else {
					if(DateUtil.isCellDateFormatted(cells)) {
						Date date = cells.getDateCellValue();
						SimpleDateFormat si=new SimpleDateFormat("dd/MMM/yyyy");
						String value = si.format(date);
						System.out.println(value);
					}else {
							double db = cells.getNumericCellValue();
							long l=(long)db;
							String value = String.valueOf(l);
							System.out.println(value);
					}
				}
		
			}
		}
	}

}
