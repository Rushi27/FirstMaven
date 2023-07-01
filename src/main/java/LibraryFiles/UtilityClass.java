package LibraryFiles;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass 
{
	
	//@AuthorName: Rushikesh
	//This method is use to get Test data from excel.
	//need to pass 2 inputs: 1-rowIndex, 2-colIndex
   public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException
   {
	   FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\PolicyBazaar\\TestData\\DDF1.xlsx");
		 Sheet sh = WorkbookFactory.create(file).getSheet("Sheet2");
		 String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		 
		 return value;
   }
   
   public static void captureSS(WebDriver driver ,int TCID) throws IOException
   {
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest=new File("C:\\Users\\Admin\\eclipse-workspace\\PolicyBazaar\\FailedTCesSS"+TCID+".jpg");
	  FileUtils.copyFile(src, dest);
   }
   
   public static String getPFdata(String key) throws IOException 
   {
	  FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\PolicyBazaar\\PropertyFile.properties");
      
	  Properties p=new Properties();
	  p.load(file);
	  
	   String value = p.getProperty(key);
	  
	  return value;
   }
}











