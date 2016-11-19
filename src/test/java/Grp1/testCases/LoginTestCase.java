package Grp1.testCases;


import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;

import Grp1.ZohoTestPOM.HomePagePOM;
import Grp1.ZohoTestPOM.SignInSignUpPagePOM;

public class LoginTestCase  {
	
	String baseURL="https://www.zoho.com/";
	String BrowserPicker="CD";
	HomePagePOM objHomePOM;
	SignInSignUpPagePOM objLoginPOM;
	public final static Logger log = LogManager.getLogger(LoginTestCase.class);
	
	@Test
	public void testSteps() throws InterruptedException {	
	
	    log.trace("LoginTestCase");
		HomePagePOM objHomePOM = new HomePagePOM(BrowserPicker);
		objHomePOM.ClickSignIn();
		objLoginPOM=new SignInSignUpPagePOM(BrowserPicker);
		objLoginPOM.UserLogin("seleniumtestemail1234@gmail.com", "passw0rd1234");
		Thread.sleep(5000);
		//objLoginPOM.teardownDriver();
	}
	
}

