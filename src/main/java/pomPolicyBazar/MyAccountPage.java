package pomPolicyBazar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyAccountPage 
{
	//variable
	
		@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']")private WebElement userName;
		@FindBy(xpath="//div[@class='h_l']")private WebElement LogoutButton;
		
		//constructor
		public MyAccountPage(WebDriver driver)
		{
		Reporter.log("Clicking on My AccountPage button",true);
		PageFactory.initElements(driver, this);
		}
		
		//Method
		
		public void clickOnLogOutButton()
		{
			Reporter.log("Logging out",true);
		LogoutButton.click();
		}
		public String validateUserName()
		{
		//String actualUN = userName.getText();
		//System.out.println(actualUN);
		//Reporter.log("getting UN"+actualUN+true);
		//return actualUN;
		String actualUN = userName.getText();
		return actualUN;
			
		}
		}




