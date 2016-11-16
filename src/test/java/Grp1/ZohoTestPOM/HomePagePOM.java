package Grp1.ZohoTestPOM;

import org.testng.annotations.Test;

import base.BaseClass;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterClass;

public class HomePagePOM {
	
	WebDriver driver;
	
	public HomePagePOM(WebDriver driver) {
		this.driver=driver;		
	}
	
	
	
	//Locators
	
	//HomePage
	By loginLinkHomePage=By.xpath("html/body/div[1]/div[1]/div[2]/a[3]");
	By signUpNowHomePage=By.xpath("html/body/div[1]/div[1]/div[2]/a[4]");
	

 /*public WebDriver openbaseURL(WebDriver driver){
	 driver.get(baseURL);	
	 return driver;
 }*/

 public void ClickLogin(){
	 System.out.println("Im here");
	 driver.findElement(loginLinkHomePage).click(); 
 }
 
 public void ClickSignUp(){
	 driver.findElement(signUpNowHomePage).click(); 
 }


 


}
