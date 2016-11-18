package Grp1.ZohoTestPOM;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import Grp1.base.BaseClass;

public class HomePagePOM extends BaseClass  {
	
	//Locators
	
	public HomePagePOM(String BrowserPicker) {
		super(BrowserPicker);
		// TODO Auto-generated constructor stub
	}

	//HomePage
	By SignInLinkHomePage=By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By ContactUsHomePage=By.xpath(".//*[@id='contact-link']/a");
	


 public void ClickSignIn(){
	 driver.findElement(SignInLinkHomePage).click(); 
 }
 
 public void ClickContactUs(){
	 driver.findElement(ContactUsHomePage).click(); 
 }


}
