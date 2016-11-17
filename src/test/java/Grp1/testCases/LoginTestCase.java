package Grp1.testCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Grp1.ZohoTestPOM.HomePagePOM;
import Grp1.ZohoTestPOM.SignInSignUpPagePOM;
import Grp1.base.BaseClass;

public class LoginTestCase  {
	
	WebDriver driver;
	String baseURL="https://www.zoho.com/";
	HomePagePOM objHomePOM;
	SignInSignUpPagePOM objLoginPOM;
	
	@BeforeTest
	public void InitDriver(){
		BaseClass baseObj=new BaseClass(driver);
		driver= baseObj.intializeFirefoxDriver();
	}
	
	@Test
	public void testSteps() throws InterruptedException{	
		HomePagePOM objHomePOM = new HomePagePOM(driver);
		objHomePOM.ClickSignIn(driver);
		objLoginPOM=new SignInSignUpPagePOM(driver);
		objLoginPOM.UserLogin(driver, "seleniumtestemail1234@gmail.com", "passw0rd1234");
	}
	
}

