package Grp1.testPOM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import Grp1.base.BaseClass;
import Grp1.testCases.LoginTestCase;

public class LandingPage  {

	WebDriver driver;
	Logger log = LogManager.getLogger(LandingPage.class);
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how=How.XPATH,using=".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement SignOut;
	@FindBy(how=How.ID,using="search_query_top")
	WebElement SearchField;
	@FindBy(how=How.XPATH,using=".//*[@id='searchbox']/button")
	WebElement SearchButton;
	
	public void SearchFunc() throws InterruptedException {
		SearchField.sendKeys("Dresses");
		log.info("Entered the search text");
		Thread.sleep(5000);
		SearchButton.click();
		Thread.sleep(5000);
		log.info("Clicked on search button");
	}
	
	public void clickSignout() throws InterruptedException{
		SignOut.click();
		Thread.sleep(5000);
		log.info("Clicked on SignOut button");
	}
	
}
