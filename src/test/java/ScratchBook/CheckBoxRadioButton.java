package ScratchBook;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class CheckBoxRadioButton {
	WebDriver driver=new FirefoxDriver();
	@Test
	public void testSteps() throws InterruptedException{	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.navigate().to("http://toolsqa.wpengine.com/automation-practice-form/");
	List<WebElement> RadioButEleList=driver.findElements(By.name("exp"));
	
	for(int i=0;i<RadioButEleList.size();i++){
		
		RadioButEleList.get(i).click();
		Thread.sleep(2000);	
			
		}
	
	List<WebElement> CheckListElems=driver.findElements(By.name("profession"));
	
	CheckListElems.get(0).click();
	Thread.sleep(2000);
	CheckListElems.get(1).click();
	Thread.sleep(2000);
	CheckListElems.get(1).click();
	Thread.sleep(2000);
	
	List<WebElement> CheckList2Elems=driver.findElements(By.name("tool"));
	CheckList2Elems.get(0).click();
	Thread.sleep(2000);
	CheckList2Elems.get(1).click();
	Thread.sleep(2000);
//CheckList2Elems.get(2).getLocation();
	Thread.sleep(2000);
		System.out.println(CheckListElems.get(0).isSelected());
		
		
	WebElement DropDwn=driver.findElement(By.id("continents"));
	Select DropDwnSel=new Select(DropDwn);
	DropDwnSel.selectByIndex(2);
	Thread.sleep(2000);
	//DropDwnSel.selectByValue("Europe");
	//Thread.sleep(2000);
	DropDwnSel.selectByVisibleText("South America");
	Thread.sleep(2000);
	System.out.println(DropDwnSel.getFirstSelectedOption().getText());
	Thread.sleep(2000);
	//DropDwnSel.deselectAll();
	//Thread.sleep(2000);
	List<WebElement> DropDwnSelList= DropDwnSel.getOptions();
	for(WebElement Option :DropDwnSelList ){
		System.out.println(Option.getText());
	}
	
	
	
	
	}
	
	@After
	public void tearDown(){
		System.out.println("I'm here");
		driver.quit();
	}
	
	
	

}
