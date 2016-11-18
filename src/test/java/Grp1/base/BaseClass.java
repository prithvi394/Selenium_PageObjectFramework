package Grp1.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	 public static WebDriver driver=null;
	 public String baseURL="http://automationpractice.com/index.php";
	 
	 public BaseClass(String BrowserPicker) {
		 if(driver==null){
			 	if(BrowserPicker=="FF"){
			 		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\Practice\\Firefox driver\\geckodriver.exe");
			 	    driver =new FirefoxDriver();
			 	}
			 	if(BrowserPicker=="CD"){
			 		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Training\\Practice\\Chrome Driver\\chromedriver.exe");
			 		driver =new ChromeDriver();
			 	}

			 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
			driver.get(baseURL);
		 }
	 }
	
	
	public void teardownDriver(){
		driver.close();
		
	}
	
}


