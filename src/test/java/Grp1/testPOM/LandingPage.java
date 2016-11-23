package Grp1.testPOM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import Grp1.base.BaseClass;

public class LandingPage  {

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how=How.XPATH,using=".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement SignOut;
	
	public void clickSignout() throws InterruptedException{
		SignOut.click();
		Thread.sleep(5000);
	
	}
	
}
