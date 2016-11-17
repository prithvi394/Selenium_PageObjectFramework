package Grp1.ZohoTestPOM;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class SignInSignUpPagePOM  {
	
	WebDriver driver;
	//Locators
	//LoginPage
	By usrNameLoginPage=By.id("email");
	By usrPswdLoginPage=By.id("passwd");
	By signInButton=By.id("SubmitLogin");


public SignInSignUpPagePOM(WebDriver driver) {
		this.driver = driver;
	}

public  void setUserName(WebDriver driver,String UserName){	 
	 driver.findElement(usrNameLoginPage).sendKeys(UserName);
 }
 
 public void setUserPswd(WebDriver driver,String PassWord){	 
	 driver.findElement(usrPswdLoginPage).sendKeys(PassWord);
 }
 
 public void clickSubmit(WebDriver driver){	 
	 driver.findElement(signInButton).click();
 }
 
 public void UserLogin(WebDriver driver,String usrName ,String pswdName ){
	 System.out.println("Im here");
	 this.setUserName(driver,usrName);
	 setUserPswd(driver,pswdName);
	 clickSubmit(driver);
 }

}

