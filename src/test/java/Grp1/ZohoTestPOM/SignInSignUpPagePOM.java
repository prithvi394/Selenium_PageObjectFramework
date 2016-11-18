package Grp1.ZohoTestPOM;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

import Grp1.base.BaseClass;

public class SignInSignUpPagePOM extends BaseClass {
	
	public SignInSignUpPagePOM(String BrowserPicker) {
		super(BrowserPicker);
		// TODO Auto-generated constructor stub
	}

	//Locators
	//LoginPage
	By usrNameLoginPage=By.id("email");
	By usrPswdLoginPage=By.id("passwd");
	By signInButton=By.id("SubmitLogin");

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
	 System.out.println("Im here");
	 setUserName(usrName);
	 setUserPswd(pswdName);
	 clickSubmit();
 }

}

