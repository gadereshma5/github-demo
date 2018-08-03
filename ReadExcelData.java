package HybridFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

class ReadExcelData  {
	// static LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>();
	static Logger logger =  Logger.getLogger("ReadExcelData");
	
	void readtestsuit() throws IOException, InterruptedException
	{
		PropertyConfigurator.configure("Log4j.properties");
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
		
		System.out.println(data+ " " + data1);
		readscript(data,data1);
		
		}
		
		
	}
	
	
 void  readscript(String data, String data1) throws IOException, InterruptedException
	{
	 	System.out.println("function called");
	    //objectexcel();
	    //System.out.println(data+ "   " +data1);
		File script_filepath=new File("E:\\framework\\testscript.xlsx");
		FileInputStream fis1=new FileInputStream(script_filepath);
		XSSFWorkbook wb1=new XSSFWorkbook(fis1);
		XSSFSheet sheet2=wb1.getSheetAt(0);
		int noofsheets=wb1.getNumberOfSheets();
		System.out.println(noofsheets);
		int rowcount1=sheet2.getLastRowNum()-sheet2.getFirstRowNum();
		System.out.println("rows in script sheet "+rowcount1);
		//String value=sheet2.getRow(1).getCell(1).getStringCellValue(); 
		// System.out.println("cell value in script sheet "+ value);
		
		
		for(int i=0;i<noofsheets;i++)
		{	
			 //XSSFSheet sheetname=wb1.getSheetName(i);
				System.out.println("Inside For loop");
				XSSFSheet sheetname=wb1.getSheetAt(i);
				String scriptsheetname=wb1.getSheetName(i);
				
				if(data.equals("Y") && data1.equals(scriptsheetname))
				{
					System.out.println("Equals");
					show(sheetname);
					
				}
				
		}
			
	}

	public static void show(XSSFSheet sheetname) throws InterruptedException, IOException

		{
			
			System.out.println("SHOW FUNCTION");
			XSSFSheet scriptsheetname=sheetname;
			//System.out.println("SheetMame" + sheetname);
			
			
			//System.out.println("Inside loop******");	
			
			int rowcount1=scriptsheetname.getLastRowNum()-scriptsheetname.getFirstRowNum();
			System.out.println("****RowCount" + rowcount1);
			
			for(int i=2;i<=rowcount1;i++) 
			{
			
			
			 String cell =scriptsheetname.getRow(i).getCell(0).getStringCellValue();
			 System.out.println(cell);
			 String cell1=scriptsheetname.getRow(i).getCell(2).getStringCellValue();
			 System.out.println(cell1);
			 String cell2=scriptsheetname.getRow(i).getCell(3).getStringCellValue();
			 //System.out.println(cell2);
			// XSSFCell cell2=scriptsheetname.getRow(i).getCell(3);
			// System.out.println(cell2);
			 
			
				 
			 
			 if(cell.equals("openBrowser"))
		 		{
		 			Actions.openBrowser();
			
		 		}else if(cell.equals("navigate")) 
		 		{
		 			Actions.navigate(cell1);
		 		}
			
		 		else if(cell.equals("type"))
		 		{
		 			
		 			//String input=scriptsheetname.getRow(i).getCell(3).getStringCellValue();
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
 
		
		@Test(priority=1)
	public static void get() throws IOException, InterruptedException
	{
		
		System.out.println("Inside Main");
		ReadExcelData object=new ReadExcelData();
		object.readtestsuit();
		
	}

	
}
