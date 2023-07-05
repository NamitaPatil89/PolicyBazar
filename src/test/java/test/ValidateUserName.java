package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BasePolicy;
import pomPolicyBazar.Login;
import pomPolicyBazar.MyAccountPage;
import utility.UtilityPolicy;
import utility.UtilityPolicy;

public class ValidateUserName extends BasePolicy
{
	MyAccountPage myAcc;
	Login login;
	
	@BeforeClass
	public void luanchPolicyBazar() throws InterruptedException 
	{
		UtilityPolicy.wait(1000);
		LaunchBrowser();
		login =new Login(driver);
		//myAcc=new MyAccountPage(driver);
		myAcc=new MyAccountPage(driver);

	}
	
	@BeforeMethod
	public void signInToPolicyBazar() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		
		UtilityPolicy.wait(1000);
		login.clickOnsignInButton1();
		UtilityPolicy.wait(1000);
		login.enterMobileNumberInField(UtilityPolicy.ReadExcelSheet1(0, 0));
		UtilityPolicy.wait(1000);
		login.clickOnsignInWithPassword();
		UtilityPolicy.wait(1000);
		login.entePassWordField(UtilityPolicy.ReadExcelSheet1(0, 1));
		UtilityPolicy.wait(1000);
		login.clickOnsignInButton2();
		UtilityPolicy.wait(1000);
		login.clickOnMyAccount();
		UtilityPolicy.wait(1000);
		login.clickOnMyProfile();
		UtilityPolicy.wait(1000);
		Set<String> s1 = driver.getWindowHandles();
		//ArrayList<String> li= new ArrayList<>(s1);
		ArrayList<String>li=new ArrayList<String>(s1);
		String childID = li.get(1);
		driver.switchTo().window(childID);
		UtilityPolicy.wait(1500);
		Reporter.log("Switching to Child Page",true);
		UtilityPolicy.wait(2000);
		}

	
	
  @Test
  public void validateUserName1() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  UtilityPolicy.wait(2000);
	  String actualUN=myAcc.validateUserName();
	  String expectedUN=UtilityPolicy.ReadExcelSheet1(0,2);
	  Reporter.log(actualUN, true);
	  Reporter.log(expectedUN,true);
     //Assert.assertEquals(actualUN,expectedUN,"Tc is fail actual & expected is not matching");
      Assert.assertEquals(actualUN,expectedUN,"Tc is fail actual & expected is not matching");
	  
	  UtilityPolicy.captureScreenshot(driver,actualUN);
  
  }
  @AfterMethod
  public void logoutFromPolicyBazar()
  {
	  myAcc.clickOnLogOutButton();
  }
  @AfterClass
  public void closePolicyBazar()
  {
	  CloseBrowser();
  }
}