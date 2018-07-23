package HybridFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;

import KeywordDriven.Actions;

class readvalues{
	// static LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>();
	 
	void readtestsuit() throws IOException, InterruptedException
	{
		File testsuit_filepath=new File("E:\\framework\\testsuit.xlsx");
		FileInputStream fis=new FileInputStream(testsuit_filepath);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		int rowcount=sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		System.out.println("row count in testsuit sheet "+rowcount);
		
		for(int i=1;i<=rowcount;i++) {
		sheet1.getRow(i);
		String data =sheet1.getRow(i).getCell(0).getStringCellValue();
		String data1 =sheet1.getRow(i).getCell(1).getStringCellValue();
		
		//System.out.println(data+ " " + data1);
		readscript(data,data1);
		
		}

		
	}
	
void objectexcel() throws IOException
{
	File object_filepath=new File("E:\\framework\\object.xlsx");
	FileInputStream fis2=new FileInputStream(object_filepath);
	XSSFWorkbook wb2=new XSSFWorkbook(fis2);
	XSSFSheet objsheet=wb2.getSheetAt(0);
	int noofsheets= wb2.getNumberOfSheets();
	System.out.println("sheets in object files: "+noofsheets);
	
	
	for(int i=0;i<noofsheets;i++)
	{
		String sheetname1=wb2.getSheetName(i);
		System.out.println("SheetName"+ sheetname1 );
	
	}
	
	
}
	
 void  readscript(String data, String data1) throws IOException, InterruptedException
	{
	 		
	    objectexcel();
	//	System.out.println(data+ "   " +data1);
		File script_filepath=new File("E:\\framework\\testscript.xlsx");
		FileInputStream fis1=new FileInputStream(script_filepath);
		XSSFWorkbook wb1=new XSSFWorkbook(fis1);
		XSSFSheet sheet2=wb1.getSheetAt(0);
		int noofsheets=wb1.getNumberOfSheets();
		//System.out.println(noofsheets);
		int rowcount1=sheet2.getLastRowNum()-sheet2.getFirstRowNum();
		
		String value=sheet2.getRow(1).getCell(1).getStringCellValue(); 
		 System.out.println("cell value in script sheet "+ value);
		
		
			for(int i=0;i<noofsheets;i++)
			{	
				
				String sheetname=wb1.getSheetName(i);
				//System.out.println("SheetName"+ sheetname );
				//System.out.println("value of data" + data);
				//System.out.println("value of data1"+ data1);
				
				//if(data=="Y" && data1.equals(sheetname))
				if(data.equals("Y") && data1.equals(sheetname))
				{
					System.out.println("Equals");
				}
				else
				{
					System.out.println("not Equals");
				}
			}
			
		
			for(int j=1;j<=rowcount1;j++) 
			{
				
			 String cell =sheet2.getRow(j).getCell(0).getStringCellValue();
			// System.out.println(cell);
			 String cell1=sheet2.getRow(j).getCell(2).getStringCellValue();
			// System.out.println(cell1);
			 String cell2=sheet2.getRow(j).getCell(3).getStringCellValue();
			// System.out.println(cell2);
			 
			if(cell.equals("openBrowser"))
			{
				Actions.openBrowser();
				
			}else if(cell.equals("navigate")) 
			{
				Actions.navigate(cell1);
				
			}else if(cell.equals("type"))
			{
				Actions.type(cell1, cell2);
				
			}else if(cell.equals("click"))
			{
				Actions.click(cell1);
				
			}else if(cell.equals("closeBrowser"))
			{
				Actions.closeBrowser();
			}
			
			
		
		}
		
		
	}
 
}
		
	


public class ReadExcelData {
	public static void main(String args[]) throws IOException, InterruptedException
	{
		readvalues object=new readvalues();
		
		object.readtestsuit();
		
		
	}

	
}
