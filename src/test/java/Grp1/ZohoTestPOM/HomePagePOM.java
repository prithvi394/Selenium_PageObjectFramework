package Grp1.ZohoTestPOM;

import org.testng.annotations.Test;

import base.BaseClass;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterClass;

public class HomePagePOM {
	
	WebDriver driver;
	
	public HomePagePOM(WebDriver driver) {
		this.driver=driver;		
	}
	
	public void intializeFireFoxDriver(){
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\Practice\\Firefox driver\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
	}
	
	public WebDriver intializeChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Training\\Practice\\Firefox driver\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		return driver;
	}

	String baseURL="https://www.zoho.com/";
	
	//Locators
	
	//HomePage
	By loginLinkHomePage=By.xpath("html/body/div[1]/div[1]/div[2]/a[3]");
	By signUpNowHomePage=By.xpath("html/body/div[1]/div[1]/div[2]/a[4]");
	
	//LoginPage
	By usrNameLoginPage=By.id("lid");
	By usrPswdLoginPage=By.id("pwd");
	By signInButton=By.id("submit_but");
	

 public void openbaseURL(){
	 driver.get(baseURL);	 
 }

 
 public void setUserName(String UserName){	 
	 driver.findElement(usrNameLoginPage).sendKeys(UserName);
 }
 
 public void setUserPswd(String PassWord){	 
	 driver.findElement(usrPswdLoginPage).sendKeys(PassWord);
 }
 
 public void clickSubmit(){	 
	 driver.findElement(signInButton).click();
 }
 
 public void UserLogin(String usrName ,String pswdName ){
	 this.setUserName(usrName);
	 this.setUserPswd(pswdName);
	 this.clickSubmit();
 }

}
