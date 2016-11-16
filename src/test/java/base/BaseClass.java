package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	 WebDriver driver;
	
	public WebDriver intializeFireFoxDriver(){
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\Practice\\Firefox driver\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		return driver;
	}
	
	public WebDriver intializeChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Training\\Practice\\Firefox driver\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		return driver;
	}
	
	
}


