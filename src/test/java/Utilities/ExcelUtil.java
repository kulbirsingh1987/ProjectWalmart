package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {

	
	File f;
	FileInputStream fis;
	Workbook wb = null;
	Sheet sh = null;

	public ExcelUtil(){
		 f = new File(".//testdata.xlsx");
		try {
			fis = new FileInputStream(f);
		
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet("Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String returnExcelData (int r, int c)  {
		
		Row row = sh.getRow(r);
		String s = row.getCell(c).getStringCellValue();

		return s;
		
	}
	public void closeExcel() {
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
