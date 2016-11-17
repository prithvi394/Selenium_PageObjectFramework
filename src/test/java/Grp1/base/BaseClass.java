package Grp1.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	 public WebDriver driver;
	 public String baseURL="http://automationpractice.com/index.php";
	 
	 public BaseClass(WebDriver driver){
		 this.driver=driver;
	 }
	 
	public WebDriver intializeFirefoxDriver(){
	System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\Practice\\Firefox driver\\geckodriver.exe");
	driver =new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
	driver.get(baseURL);
	return driver;
	}
	
	public WebDriver intializeChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Training\\Practice\\Firefox driver\\geckodriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(450, TimeUnit.SECONDS);
		return driver;
	}
	
	public void teardownDriver(){
		driver.quit();
		
	}
	
}


