package Grp1.testPOM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Grp1.base.BaseClass;

public class SignInSignUpPagePOM {
	
	WebDriver driver;
	Logger log = LogManager.getLogger(SignInSignUpPagePOM.class);
	public SignInSignUpPagePOM(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
		//PageFactory.initElements(driver, this);
		//
	}

	//Locators
	//LoginPage
	By usrNameLoginPage=By.id("email");
	By usrPswdLoginPage=By.id("passwd");
	//By signInButton=By.id("SubmitLogin");
	
	@FindBy(how=How.ID,using="SubmitLogin")
	WebElement signInButton;
	
	
	
public  void setUserName(String UserName){	 
	 driver.findElement(usrNameLoginPage).sendKeys(UserName);
	 log.info("UserName set");
 }
 
 public void setUserPswd(String PassWord){	 
	 driver.findElement(usrPswdLoginPage).sendKeys(PassWord);
	 log.info("Password set");
 }
 
 public void clickSubmit(){	 
	 signInButton.click();
	 log.info("Clicked SignIn button");
 }
 
 public void UserLogin(String usrName ,String pswdName ){
	 //System.out.println("Im here");
	 setUserName(usrName);
	 setUserPswd(pswdName);
	 clickSubmit();
 }

}

