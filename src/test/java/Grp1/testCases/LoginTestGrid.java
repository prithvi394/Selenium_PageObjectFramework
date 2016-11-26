package Grp1.testCases;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.*;

import Grp1.HelperClasses.ExcelHandler;
import Grp1.base.BaseGrid;
import Grp1.base.ConfigurationClass;
import Grp1.testPOM.HomePagePOM;
import Grp1.testPOM.LandingPage;
import Grp1.testPOM.SignInSignUpPagePOM;
import org.apache.logging.log4j.*;

public class LoginTestGrid  extends BaseGrid {

	public LoginTestGrid() throws MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
	}

	Map<String,String> LogCreds=new HashMap<String,String>();
	public final static Logger log = LogManager.getLogger(LoginTestCase.class);
	//String baseURL="https://www.zoho.com/";

	@BeforeTest
	public void testSteps() throws InterruptedException, IOException{
		ExcelHandler iterate=new ExcelHandler();
		iterate.setExcelFile();
		LogCreds=iterate.getCellData();
		Iterator iterator = LogCreds.entrySet().iterator();
		 while (iterator.hasNext()) {
		        Map.Entry pair = (Map.Entry)iterator.next();
		        System.out.println(pair.getKey() + ","+ pair.getValue());
		        String UserID=(String)pair.getKey();
		        String passWord=(String) pair.getValue();
		        //LoginTestCase obj=new LoginTestCase();
				BaseGrid.OpenUrl(driver, baseURL); 
		        log.info("LoginTestCase started");
		        HomePagePOM objHomePOM = PageFactory.initElements(driver, HomePagePOM.class);
		        objHomePOM.ClickSignIn();
		        SignInSignUpPagePOM objLoginPOM=PageFactory.initElements(driver, SignInSignUpPagePOM.class);
		        objLoginPOM.UserLogin(UserID, passWord);
		        LandingPage objLandingPage=PageFactory.initElements(driver, LandingPage.class);
		        Thread.sleep(5000);
		        objLandingPage.clickSignout();
		        //
		        iterator.remove();
		 }
		 BaseGrid.teardownDriver(driver); 
	}
	
	 
}


