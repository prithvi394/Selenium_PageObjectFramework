package Grp1.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import Grp1.testCases.LoginTestCase;
import Grp1.testPOM.SignInSignUpPagePOM;

public class BaseGrid {
	
	 public WebDriver driver=null;
	 public String baseURL="http://automationpractice.com/index.php";
	 
	 public BaseGrid() throws MalformedURLException {
		 final Logger log = LogManager.getLogger(LoginTestCase.class);
		 	DesiredCapabilities capability= DesiredCapabilities.firefox();
		 	driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
			 	
			 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
			driver.get(baseURL);
			
		// }
	 }
	
	public static void OpenUrl(WebDriver driver,String baseUrl){
			System.out.println("I am trying to navigate to URL page ");
			driver.get(baseUrl);
			
		}
	 
	 
	public static void teardownDriver(WebDriver driver){
		driver.quit();
		
	}
	
}



