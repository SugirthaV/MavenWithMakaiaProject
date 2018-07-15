package Excel;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
public String[][] Excel(String ExcelFileName) throws IOException {
	XSSFWorkbook wbook = new XSSFWorkbook("./data/"+ExcelFileName+".xlsx");
	XSSFSheet sheet = wbook.getSheetAt(0);
	int rowcnt = sheet.getLastRowNum();
	System.out.println(rowcnt);
	XSSFRow headerrow = sheet.getRow(0); 
	int lastCellNum = headerrow.getLastCellNum();System.out.println(lastCellNum);
	String[][] data = new String[rowcnt][lastCellNum] ;
	for(int i=1;i<=rowcnt;i++) //i=1 bcos i=0 points to RowHeader which we re not going to read
	{
		for(int j=0;j<lastCellNum;j++)
		{
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(j);
			String val = cell.getStringCellValue();
			System.out.println(val);
			data[i-1][j] = val;
		}
	}
	wbook.close();
	return data;
}
}
