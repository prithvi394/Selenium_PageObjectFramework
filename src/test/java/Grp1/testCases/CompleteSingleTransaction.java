package Grp1.testCases;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ReporterType;
import Grp1.base.BaseClass;
import Grp1.base.BaseGrid;
import Grp1.testPOM.*;
import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import java.net.MalformedURLException;
import java.util.*;
import javax.lang.model.element.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class CompleteSingleTransaction extends BaseClass {
	
  public CompleteSingleTransaction() throws MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
	}
  	

    public final Logger log = LogManager.getLogger(CompleteSingleTransaction.class);

    
@SuppressWarnings("deprecation")
@Test(groups={"Smoke Test"},dataProvider = "dp")
  public void testSteps(String usrName, String passW0rd) throws InterruptedException  {
		logger=report.startTest("CompleteSingleTransaction");
		log.info("CompleteSingleTransaction started");
		
		BaseClass.OpenUrl(driver, baseURL);
		//logger.log(LogStatus.INFO, "Browser Open");
		logger.log(LogStatus.INFO, "Browser Open: " + logger.addScreenCapture("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\Screenshots\\" + this.getClass().toString()+"\\Browser Open.png"));
		
		HomePagePOM objHomePOM = PageFactory.initElements(driver, HomePagePOM.class);
		objHomePOM.ClickSignIn();
		logger.log(LogStatus.PASS, "Clicked on SignIn button");
		
		SignInSignUpPagePOM objSignInSignUpPagePOM=PageFactory.initElements(driver,SignInSignUpPagePOM.class);
		objSignInSignUpPagePOM.UserLogin(usrName, passW0rd);
		//logger.log(LogStatus.PASS, "Login Successful");
		logger.log(LogStatus.PASS, "Login Successful:" + logger.addScreenCapture("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\Screenshots\\" + this.getClass().toString()+"\\Login Successful.png"));
		Thread.sleep(5000);
		
		LandingPage objLandingPage=PageFactory.initElements(driver,LandingPage.class);
		objLandingPage.SearchFunc();
		//logger.log(LogStatus.PASS, "Search Successful");
		logger.log(LogStatus.PASS, "Search Successful: " + logger.addScreenCapture("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\Screenshots\\" + this.getClass().toString()+"\\Search Successful.png"));
		BaseClass.getscreenshot(driver, this.getClass().toString(), "test");
		Thread.sleep(5000);
		
		WebElement elem=driver.findElement(By.xpath(".//*[@id='center_column']/ul"));
		//String elemHTML=elem.getAttribute("innerHTML");
		//List<String> linkList=elemHTML.
		//System.out.println(elem.getAttribute("innerHTML"));
		List<WebElement> linkList=	elem.findElements(By.tagName("img"));//we can use Link or i
		System.out.println(linkList.size());

		
			if(linkList.size()== 7){
				logger.log(LogStatus.PASS, "Exact number of items found");
			}
			else{
				logger.log(LogStatus.FAIL, "Exact number of items NOT found");
				}
			
			int itemCounter=1;
			
			//for(WebElement a:linkList){
			//System.out.println("-------------------------------------------------------------");
			//System.out.println(a.getAttribute("innerHTML"));
			//builder.moveToElement(hoverImg);
			//builder.perform();
			
			while(itemCounter<=linkList.size()){
				Actions builder = new Actions(driver);
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("scroll(0, 500);");
					WebElement hoverImg=driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[" + itemCounter + "]/div/div[2]"));
					hoverImg.click();
					Thread.sleep(20000);
					driver.findElement(By.xpath(".//*[@id='center_column']/ul/li[" + itemCounter + "]/div/div[2]/div[2]/a[1]/span")).click();
					Thread.sleep(2000);		
					//driver.navigate().back();
					objLandingPage.clickSignout();
					Thread.sleep(2000);	
					itemCounter+=1;
				}
			
			
			
		
		objLandingPage.clickSignout();
		objLandingPage.clickSignout();
		//logger.log(LogStatus.PASS, "SignOut Successful");
		logger.log(LogStatus.PASS, "SignOut Successful: " + logger.addScreenCapture("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\Screenshots\\" + this.getClass().toString()+"\\SignOut Successful.png"));
		
		report.endTest(logger);
		report.flush();
  }



  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "seleniumtestemail1234@gmail.com", "passw0rd1234" },
     // new Object[] { 2, "b" },
    };
    
  }
  
  
  
  
  @AfterMethod
  public void tearDown(ITestResult result) {
	  
	if (result.getStatus()==ITestResult.FAILURE) { //takes screenshots on failure
		  
		  BaseClass.getscreenshot(driver, this.getClass().toString(), "FailureScreenprint " + this.getClass().toString());
	  }
	  
	  BaseClass.teardownDriver(driver);
	 
	  
  }

}
