package Grp1.testCases;


import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
//import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.*;

import Grp1.testPOM.HomePagePOM;
import Grp1.testPOM.SignInSignUpPagePOM;

import org.apache.logging.log4j.*;

public class LoginTestCase  {
	
	String baseURL="https://www.zoho.com/";
	String BrowserPicker="CD";
	HomePagePOM objHomePOM;
	SignInSignUpPagePOM objLoginPOM;
	public final static Logger log = LogManager.getLogger(LoginTestCase.class);
	
	@BeforeTest
	public void testSteps() throws InterruptedException {	
	
	    log.info("LoginTestCase started");
		HomePagePOM objHomePOM = new HomePagePOM(BrowserPicker);
		objHomePOM.ClickSignIn();
		objLoginPOM=new SignInSignUpPagePOM(BrowserPicker);
		objLoginPOM.UserLogin("seleniumtestemail1234@gmail.com", "passw0rd1234");
		Thread.sleep(5000);
		//objLoginPOM.teardownDriver();
	}
	
}

