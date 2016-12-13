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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Grp1.HelperClasses.ExcelHandler;
import Grp1.base.BaseClass;
import Grp1.base.BaseGrid;
import Grp1.base.ConfigurationClass;
import Grp1.testPOM.HomePagePOM;
import Grp1.testPOM.LandingPage;
import Grp1.testPOM.SignInSignUpPagePOM;
import org.apache.logging.log4j.*;

public class LoginTestGrid  extends BaseClass {

	public LoginTestGrid() throws MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
	}

	//Map<String,String> LogCreds=new HashMap<String,String>();
	//String baseURL="https://www.zoho.com/";
	
	public Logger log = LogManager.getLogger(LoginTestCase.class);
	public ExtentReports report;
	 public ExtentTest logger;
	
	@Test(groups={"Regression"},dataProvider="GetExcelInputs")
	public void testSteps(String userid,String passw0rd,String browser) throws InterruptedException, IOException{
		report=new ExtentReports("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\ExtentReports\\POMFrameWorkDemo.html",false);
		logger=report.startTest("LoginTestCase started with"+userid+passw0rd+browser);
		
		//System.out.println(userid);
		//System.out.println(passw0rd);
		//System.out.println(browser);
		
						
							//Iterator iterator = LogCreds.entrySet().iterator();
							// while (iterator.hasNext()) {
						       // Map.Entry pair = (Map.Entry)iterator.next();
						        //System.out.println(pair.getKey() + ","+ pair.getValue());
						        //String UserID=(String)pair.getKey();
						        //String passWord=(String) pair.getValue();
						        //LoginTestCase obj=new LoginTestCase();
						        //WebDriver CurrDriver=driver;
				//System.out.println(BrowserType);
				BaseGrid.OpenUrl(driver, baseURL); 
		        log.info("LoginTestCase started with"+userid+passw0rd+browser);
		        logger.log(LogStatus.PASS, "Browser open");
		        HomePagePOM objHomePOM = PageFactory.initElements(driver, HomePagePOM.class);
		        objHomePOM.ClickSignIn();
		        SignInSignUpPagePOM objLoginPOM=PageFactory.initElements(driver, SignInSignUpPagePOM.class);
		        objLoginPOM.UserLogin(userid, passw0rd);
		        logger.log(LogStatus.PASS, "SignIn successful");
		        LandingPage objLandingPage=PageFactory.initElements(driver, LandingPage.class);
		        Thread.sleep(5000);
		        objLandingPage.clickSignout();
		        logger.log(LogStatus.PASS, "SignOut successful");
		        report.endTest(logger);
		        report.flush();
		        //
		        //iterator.remove();
		        //BaseClass.teardownDriver(driver);
		}
		
		@AfterTest
		public void teardown(){
			BaseGrid.teardownDriver(driver); 
			
			report.flush();
		}

		@DataProvider(name="GetExcelInputs")
		public Object[][] getDataFromDataprovider() throws IOException{
			List<ArrayList<String>> LogCreds;
			String buffer1;
			String buffer2;
			String buffer3;
			int DimArrRowCounter=0;
			int matrixRowCounter=0;
			ExcelHandler iterate=new ExcelHandler();
			iterate.setExcelFile(this.getClass().toString());
			LogCreds=iterate.getCellData();
			Iterator<ArrayList<String>> itRowCheck=LogCreds.iterator();
				while(itRowCheck.hasNext()){
					String[] browserList=itRowCheck.next().get(2).split(";");
					for (int matrixInc=0;matrixInc<browserList.length;matrixInc++) {
						DimArrRowCounter+=1;
					}
				}
				
				Object[][] arrayExcelData = new Object[DimArrRowCounter][3]  ;
				System.out.println(DimArrRowCounter);
				Iterator<ArrayList<String>> itRowAsgn=LogCreds.iterator();
				while(itRowAsgn.hasNext()){
					ArrayList<String> buffer=itRowAsgn.next();
					buffer1=buffer.get(0);
					buffer2=buffer.get(1);
					buffer3=buffer.get(2);
					String[] browserList=buffer3.split(";");
						for (int matrixInc=0;matrixInc<browserList.length;matrixInc++) {
							//System.out.println(buffer1);
							//System.out.println(buffer2);
							//System.out.println(browserList[matrixInc]);
								arrayExcelData[matrixRowCounter][0]=buffer1;
								arrayExcelData[matrixRowCounter][1]=buffer2;
								arrayExcelData[matrixRowCounter][2]=browserList[matrixInc];
								matrixRowCounter+=1;
					}
				}
				
				
			//System.out.println(LogCreds.length);
			/*for(int matrixRowCounter=0 ;matrixRowCounter<LogCreds.length;matrixRowCounter++){
				String[] browserList= Arrays.asList( LogCreds[matrixRowCounter][2]).toString().split(";");
				for (int matrixInc=0;matrixInc<browserList.length;matrixInc++) {
					arrayExcelData[matrixInc][0]=LogCreds[matrixRowCounter][0];
					arrayExcelData[matrixInc][1]=LogCreds[matrixRowCounter][1];
					arrayExcelData[matrixInc][2]=browserList[matrixInc];
					//matrixInc+=1;
					}
				matrixRowCounter+=1;
			}
			System.out.println(arrayExcelData.length);*/
			
				//Iterator<ArrayList<Object>> itRowTest=arrayExcelData.iterator();
					//while(itRowTest.hasNext()){
						//Iterator<Object> itColTest=itRowTest.next().iterator();
						 //	while(itColTest.hasNext()){
						 	//	System.out.println(itColTest.next());
						//}
					//}
			/*//Object[][] returnStr=arrayExcelData;
			//return new Object[][] {{arrayExcelData}};*/
			return arrayExcelData;
	
		}
	
	 
}


