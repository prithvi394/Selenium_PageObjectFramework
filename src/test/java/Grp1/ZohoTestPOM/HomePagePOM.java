package Grp1.ZohoTestPOM;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class HomePagePOM  {
	
	public WebDriver driver;
	
	public HomePagePOM(WebDriver driver){
		this.driver=driver;
	}
	
	//Locators
	
	//HomePage
	By SignInLinkHomePage=By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By ContactUsHomePage=By.xpath(".//*[@id='contact-link']/a");
	


 public void ClickSignIn(WebDriver driver){
	 driver.findElement(SignInLinkHomePage).click(); 
 }
 
 public void ClickContactUs(WebDriver driver){
	 driver.findElement(ContactUsHomePage).click(); 
 }


}
