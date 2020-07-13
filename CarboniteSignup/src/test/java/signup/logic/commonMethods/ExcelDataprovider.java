package signup.logic.commonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataprovider
{

	  XSSFWorkbook xwb;
	 public ExcelDataprovider()
	 {
		 File sourceloc= new File(".//DataProvider//ElementDetail.xlsx");
		 
		 try 
		     {
			FileInputStream fis=new FileInputStream(sourceloc);
			 xwb=new XSSFWorkbook(fis);
		     } 
		 
		  catch (Exception e) 
		     {
				System.out.println("Unable to read data from excel file!!!"+e.getMessage());
		    }
	 }
	 
	 
	 public String GetElementfromExcel(int row,int col)
	 {
		 return xwb.getSheet("Signup").getRow(row).getCell(col).getStringCellValue();
	 }
	 public String GetDatafromExcel(int row,int col)
	 {
		 return xwb.getSheet("Datainfo").getRow(row).getCell(col).getStringCellValue();
	 }
}
