package Grp1.testCases;


import java.io.IOException;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
//import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.*;

import Grp1.HelperClasses.ExcelHandler;
import Grp1.base.BaseClass;
import Grp1.base.ConfigurationClass;
import Grp1.testPOM.HomePagePOM;
import Grp1.testPOM.LandingPage;
import Grp1.testPOM.SignInSignUpPagePOM;
import org.apache.logging.log4j.*;

public class LoginTestCase  {
	
	//String baseURL="https://www.zoho.com/";
	
	HomePagePOM objHomePOM;
	SignInSignUpPagePOM objLoginPOM;
	Map<String,String> LogCreds=new HashMap<String,String>();
	public final static Logger log = LogManager.getLogger(LoginTestCase.class);
	
	@BeforeTest
	public void testSteps() throws InterruptedException, IOException {	
		ExcelHandler iterate=new ExcelHandler();
		iterate.setExcelFile();
		LogCreds=iterate.getCellData();
		Iterator iterator = LogCreds.entrySet().iterator();
		 while (iterator.hasNext()) {
		        Map.Entry pair = (Map.Entry)iterator.next();
		        System.out.println(pair.getKey() + ","+ pair.getValue());
		        String UserID=(String)pair.getKey();
		        String passWord=(String) pair.getValue();
		        log.info("LoginTestCase started");
		        HomePagePOM objHomePOM = new HomePagePOM(ConfigurationClass.BrowserPicker);
		        objHomePOM.ClickSignIn();
		        objLoginPOM=new SignInSignUpPagePOM(ConfigurationClass.BrowserPicker);
		        objLoginPOM.UserLogin(UserID, passWord);
		        LandingPage objLandingPage=new LandingPage(ConfigurationClass.BrowserPicker);
		        Thread.sleep(5000);
		        objLandingPage.clickSignout();
		        iterator.remove();  // avoids a ConcurrentModificationException
		 }
		 
		BaseClass.teardownDriver(); 
	}
	
}

