package Grp1.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.Generate.ExtendedLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.*;

import Grp1.testCases.LoginTestCase;
import Grp1.testPOM.SignInSignUpPagePOM;

public class BaseClass {
	
	 public WebDriver driver=null;
	 public String baseURL="http://automationpractice.com/index.php";
	 public static Logger baselog = LogManager.getLogger(BaseClass.class);
	 public ExtentReports report;
	 public ExtentTest logger;

	 //report=new ExtentReports("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\ExtentReports\\POMFrameWorkDemo.html",true);
	 
	 public BaseClass() {
		 
		 report=new ExtentReports("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\ExtentReports\\POMFrameWorkDemo.html",false);
		 
		// report=new ExtentReports("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\ExtentReports\\POMFrameWorkDemo.html",true);
		 		 
		// 	if(BrowserPicker=="Firefox"){
		//	 		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\Practice\\Firefox driver\\geckodriver.exe");
			 	    driver =new FirefoxDriver();
			 	//}
			 	/*if(BrowserPicker=="Chrome"){
			 		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Training\\Practice\\Chrome Driver\\chromedriver.exe");
			 		driver =new ChromeDriver();
			 		log.info("ChromeDriverDeclared");
			 	}*/

			 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.get(baseURL);
			
		// }
	 }
	
	public static void OpenUrl(WebDriver driver,String baseUrl){
			//System.out.println("I am trying to navigate to URL page ");
			driver.get(baseUrl);
			baselog.info("Opened the baseURL");
			
		}
	 
	 
	public static void teardownDriver(WebDriver driver){
		driver.quit();
		
	}
	
	 public static void  getscreenshot(WebDriver driver,String className,String capturedScenario) 
     {
             try{
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          //The below method will save the screen shot in d drive with name "screenshot.png"
             FileUtils.copyFile(scrFile, new File("C:\\Users\\Prithviraj\\SeleniumExecutionResults\\Screenshots\\" + className+"\\"+capturedScenario+".png"));
     }
             catch (Exception e){
            	 System.out.println(e.getMessage()); 	 
             }
             
     }
	
}


