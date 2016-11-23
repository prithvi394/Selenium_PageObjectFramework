package Grp1.testPOM;

import org.openqa.selenium.*;
import Grp1.testCases.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Grp1.base.BaseClass;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class HomePagePOM {
	
	//Locators
	WebDriver driver;
	
	public HomePagePOM(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	//HomePage
	@FindBy(how=How.XPATH,using= ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement SignInLinkHomePage;
	
	By ContactUsHomePage=By.xpath(".//*[@id='contact-link']/a");
	


 public void ClickSignIn(){
	 final Logger log = LogManager.getLogger(LoginTestCase.class);
	 SignInLinkHomePage.click(); 
	 log.info("Clicked on SignINButton");
 }
 
 public void ClickContactUs(){
	 driver.findElement(ContactUsHomePage).click(); 
 }


}
