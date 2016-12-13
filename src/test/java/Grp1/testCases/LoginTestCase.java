package Grp1.testCases;


import java.io.IOException;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Grp1.HelperClasses.ExcelHandler;
import Grp1.base.BaseClass;
import Grp1.base.ConfigurationClass;
import Grp1.testPOM.HomePagePOM;
import Grp1.testPOM.LandingPage;
import Grp1.testPOM.SignInSignUpPagePOM;
import org.apache.logging.log4j.*;

public class LoginTestCase  extends BaseClass {

	Map<String,String> LogCreds=new HashMap<String,String>();
	public final static Logger log = LogManager.getLogger(LoginTestCase.class);
	 //public ExtentReports report;
	 //public ExtentTest logger;
	//String baseURL="https://www.zoho.com/";

	@Test
	public void testSteps() throws InterruptedException, IOException{
		//report=new ExtentReports("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\ExtentReports\\POMFrameWorkDemo.html",true);
		//logger=report.startTest("LoginTestCase");
		ExcelHandler iterate=new ExcelHandler();
		iterate.setExcelFile(this.getClass().toString());
		//LogCreds=iterate.getCellData();
		Iterator iterator = LogCreds.entrySet().iterator();
		 while (iterator.hasNext()) {
		        Map.Entry pair = (Map.Entry)iterator.next();
		        System.out.println(pair.getKey() + ","+ pair.getValue());
		        String UserID=(String)pair.getKey();
		        String passWord=(String) pair.getValue();
		        //LoginTestCase obj=new LoginTestCase();
				BaseClass.OpenUrl(driver, baseURL); 
		        log.info("LoginTestCase started");
		  //      logger.log(LogStatus.INFO, "LoginTestCase started");
		        HomePagePOM objHomePOM = PageFactory.initElements(driver, HomePagePOM.class);
		        objHomePOM.ClickSignIn();
		        SignInSignUpPagePOM objLoginPOM=PageFactory.initElements(driver, SignInSignUpPagePOM.class);
		        objLoginPOM.UserLogin(UserID, passWord);
		    //    logger.log(LogStatus.PASS, "SignIn Successful");
		        LandingPage objLandingPage=PageFactory.initElements(driver, LandingPage.class);
		        Thread.sleep(5000);
		        objLandingPage.clickSignout();
		      //  logger.log(LogStatus.PASS, "SignOut Successful");
		        //
		        iterator.remove();
		 }
		// BaseClass.teardownDriver(driver); 
		  //report.endTest(logger);
		  //report.flush();
	}
	
	 


@AfterMethod
public void tearDown(ITestResult result) {
	  
	if (result.getStatus()==ITestResult.FAILURE) { //takes screenshots on failure
		  
		  BaseClass.getscreenshot(driver, this.getClass().toString(), "FailureScreenprint " + this.getClass().toString());
	  }
	  
	  BaseClass.teardownDriver(driver);
	  //report.endTest(logger);
	  //report.flush();
	  
}

}


