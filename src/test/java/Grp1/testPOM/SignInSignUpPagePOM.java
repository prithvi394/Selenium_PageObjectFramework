package Grp1.testPOM;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Grp1.base.BaseClass;

public class SignInSignUpPagePOM {
	
	WebDriver driver;
	
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
 }
 
 public void setUserPswd(String PassWord){	 
	 driver.findElement(usrPswdLoginPage).sendKeys(PassWord);
 }
 
 public void clickSubmit(){	 
	 signInButton.click();
 }
 
 public void UserLogin(String usrName ,String pswdName ){
	 System.out.println("Im here");
	 setUserName(usrName);
	 setUserPswd(pswdName);
	 clickSubmit();
 }

}

