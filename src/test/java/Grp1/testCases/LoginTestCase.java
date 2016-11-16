package Grp1.testCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Grp1.ZohoTestPOM.HomePagePOM;
import base.BaseClass;

public class LoginTestCase  {
	WebDriver driver;
	HomePagePOM objPOM=new HomePagePOM(driver);
	
	@Test
	public void testSteps(){	
		objPOM.intializeFireFoxDriver();
		objPOM.openbaseURL();
		objPOM.UserLogin("prithviraj394@yahoo.com", "passw0rd1");
	}
	
}

