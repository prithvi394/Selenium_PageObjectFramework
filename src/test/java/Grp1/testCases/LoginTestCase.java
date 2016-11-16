package Grp1.testCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Grp1.ZohoTestPOM.HomePagePOM;
import Grp1.ZohoTestPOM.LoginPagePOM;
import base.BaseClass;

public class LoginTestCase  {
	
	WebDriver driver;
	String baseURL="https://www.zoho.com/";
	HomePagePOM objHomePOM;
	LoginPagePOM objLoginPOM;
	
	@BeforeTest
	public void intializeFireFoxDriver() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\Practice\\Firefox driver\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		driver.get(baseURL);
		Thread.sleep(20000);
	}

	//
	

	@Test
	public void testSteps(){	
		 objHomePOM = new HomePagePOM(driver);
		objHomePOM.ClickLogin();
		
		
		objLoginPOM=new LoginPagePOM(driver);
		////LoginPagePOM.UserLogin("prithviraj394@yahoo.com", "passw0rd");
	}
	
}

