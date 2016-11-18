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
	
	String baseURL="https://www.zoho.com/";
	String BrowserPicker="CD";
	HomePagePOM objHomePOM;
	SignInSignUpPagePOM objLoginPOM;
	
	@Test
	public void testSteps() throws InterruptedException {	
		HomePagePOM objHomePOM = new HomePagePOM(BrowserPicker);
		objHomePOM.ClickSignIn();
		objLoginPOM=new SignInSignUpPagePOM(BrowserPicker);
		objLoginPOM.UserLogin("seleniumtestemail1234@gmail.com", "passw0rd1234");
		objLoginPOM.teardownDriver();
	}
	
}

