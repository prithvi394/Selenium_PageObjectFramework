package Grp1.ZohoTestPOM;

import org.testng.annotations.Test;

import base.BaseClass;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterClass;

public class LoginPagePOM {
	
	WebDriver driver;
	
	//Locators

	//LoginPage
	By usrNameLoginPage=By.id("lid");
	By usrPswdLoginPage=By.id("pwd");
	By signInButton=By.id("submit_but");
	

 public LoginPagePOM(WebDriver driver) {
		this.driver=driver;
	}

public  void setUserName(String UserName){	 
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

