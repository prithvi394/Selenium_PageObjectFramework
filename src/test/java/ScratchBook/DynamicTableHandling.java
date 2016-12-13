package ScratchBook;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class DynamicTableHandling {
	
	WebDriver driver;
	List<Hashtable> hshList=new ArrayList(); ;
	Hashtable<String,String> fetchTableVal;
	
	@Before
	public void initialize(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://toolsqa.wpengine.com/automation-practice-table/");
	}
	
	@Test
	public void testSteps() throws InterruptedException{
		int rowNum=1;
		int Counter=0;
		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		while(driver.findElements(By.xpath("//*[@id='content']/table/tbody/tr["+ rowNum +"]/th")).size()>0){
			int colNum=1;
			fetchTableVal=new Hashtable<String,String>();	
			String hashKey=driver.findElement(By.xpath(".//*[@id='content']/table/thead/tr/th[" +colNum+"]")).getText();
			String hashValue=driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr["+rowNum+"]/th")).getText();
			//System.out.println(hashKey+"<---->"+hashValue);
			fetchTableVal.put(hashKey, hashValue);
			colNum+=1;
			while(driver.findElements(By.xpath(".//*[@id='content']/table/thead/tr/th["+colNum+"]")).size()>0){
				
				hashKey=driver.findElement(By.xpath(".//*[@id='content']/table/thead/tr/th["+colNum+"]")).getText();
				hashValue=driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr["+rowNum+"]/td["+(colNum-1)+"]")).getText();
				//System.out.println(hashKey+"<---->"+hashValue);
				fetchTableVal.put(hashKey, hashValue);
				colNum+=1;
			}
			
			/*hshList.add(fetchTableVal);
			Iterator it=fetchTableVal.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry pair=(Map.Entry) it.next();
				System.out.println(pair.getKey()+"<---->"+pair.getValue());
				it.remove();
			}*/
			hshList.add(fetchTableVal);
			rowNum+=1;
		}	
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("------------------------------------------------------");
		
		for(Hashtable hshElem:hshList){
			Iterator it=hshElem.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry pair=(Map.Entry) it.next();
					System.out.println(pair.getKey()+"<---->"+pair.getValue());
					it.remove();
				}
				
		System.out.println("------------------------------------------------------");
			
		}

	}
	
	
	@After
	public void teardown(){
		driver.quit();
		
	}
	
	

}
