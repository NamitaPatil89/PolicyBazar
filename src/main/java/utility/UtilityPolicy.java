package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class UtilityPolicy 
{
	

		public static void captureScreenshot(WebDriver driver,String fileName) throws IOException 
		{
			File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File Dest=new File("D:\\screenshot\\"+fileName+".png");
			org.openqa.selenium.io.FileHandler.copy(Source, Dest);
			Reporter.log("Taking screenshot..",true);
		}
		
		public static void ScrollIntoView(WebDriver driver,WebElement element)
		{
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)",true);
			Reporter.log("scrolling into view", true);
		}
		
		//public static String ReadExcelsheet1(int rowNum,int cellNum) throws EncryptedDocumentException, IOException
		//{
//			FileInputStream myFile=new FileInputStream("F:\\ExcelSheet\\Excelpom.xlsx");
			//String value = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
			//Reporter.log("reading data from excel",true);
//			return value;
		//	}
		public static String ReadExcelSheet1(int rowNum,int cellNum) throws EncryptedDocumentException, IOException
		{
			FileInputStream myFile=new FileInputStream("F:\\ExcelSheet\\Excelpom.xlsx");
			String value = WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
			Reporter.log("reading data",true);
			return value;
		}
		
		
		public static void wait(int waitTime) throws InterruptedException
		{
			Thread.sleep(waitTime);
		}
	}