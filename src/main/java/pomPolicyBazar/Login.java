	package pomPolicyBazar;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.Reporter;

	public class Login

	{
		//variable
		
		@FindBy(xpath = "//a[text()='Sign in']")private WebElement signInButton1;
		@FindBy(xpath="(//input[@type='number'])[2]")private WebElement mobileNumberField;
		@FindBy(xpath="(//span[text()='Sign in with Password'])[2]")private WebElement signInWithPassword;
		@FindBy(xpath = "//input[@type='password']") private WebElement passWordField;
		@FindBy(xpath = "//span[text()='Sign in']")private WebElement signInButton2;
		@FindBy(xpath = "//div[text()='My Account']")private WebElement MyAccount;
		@FindBy(xpath = "//span[text()=' My profile ']")private WebElement MyProfile;
		
		//constructor
		public Login(WebDriver driver)
		{
		PageFactory.initElements(driver,this);
		}
		
		
		//Methods
		
		public void clickOnsignInButton1()
		{
		Reporter.log("Clicking on Home Page sign In button",true);
		signInButton1.click();
		}
		
		public void enterMobileNumberInField(String mobNum) 
		{
		Reporter.log("Clicking on Enter Mobile Number button",true);
		mobileNumberField.sendKeys(mobNum);
		} 
		public void clickOnsignInWithPassword()
		{
		Reporter.log("Clicking on Sign In with password button",true);
		signInWithPassword.click();
		}
		public void entePassWordField(String password) 
		{
		Reporter.log("Clicking Enter Password button",true);
		passWordField.sendKeys(password);
		}
		public void clickOnsignInButton2()
		{
		Reporter.log("Clicking on sign In button",true);
		signInButton2.click();
		}
		public void clickOnMyAccount()
		{
		Reporter.log("Clicking on MyAccount button",true);
		MyAccount.click();
		}
		public void clickOnMyProfile()
		{
		Reporter.log("Clicking on My Profile button",true);
		MyProfile.click();
	}
		
	}


