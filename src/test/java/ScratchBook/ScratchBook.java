package ScratchBook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScratchBook {
	
	WebDriver driver;
	
	public static void main (String [] args) throws InterruptedException {
		ScratchBook scratchBook = new ScratchBook();
		scratchBook.intializeFirefoxDriver();
	}
	
	public void intializeFirefoxDriver() throws InterruptedException{
	System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\Practice\\Firefox driver\\geckodriver.exe");
	driver =new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
	driver.get("https://www.amazon.com/");
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	WebDriverWait wait=new WebDriverWait (driver,500);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nav-link-accountList']/span[2]")));
	System.out.println("Im here1");
	driver.findElement(By.xpath(".//*[@id='nav-link-accountList']/span[2]")).click();
	driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
	driver.findElement(By.id("ap_email")).sendKeys("");
	driver.findElement(By.id("ap_password")).sendKeys("");
	driver.findElement(By.xpath(".//*[@id='signInSubmit']")).submit();
	Thread.sleep(5000);
	driver.quit();
	}
}