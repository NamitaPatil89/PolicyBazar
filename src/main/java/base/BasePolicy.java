package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BasePolicy
{
	protected WebDriver driver;
	
	public void LaunchBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.policybazaar.com/");
		Reporter.log("Launching browser..",true);

		
		
	}
	
	public void CloseBrowser()
	{
		//utility.wait(1000);
		Reporter.log("Closing browser...",true);
        driver.quit();
	
	}

}