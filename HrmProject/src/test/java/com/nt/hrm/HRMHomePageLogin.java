package com.nt.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HRMHomePageLogin {
	
	WebDriver driver;

	@Test
	public void hrm_Login() throws InterruptedException{
		
		String app_url = "https://opensource-demo.orangehrmlive.com/";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.get(app_url);
        System.out.println("----------Sucessfully launched chrome browser----------");
        
		driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		//Verify account disable 
		//String actResult =driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
		//System.out.println("Account is disable ::"+actResult);
		
		//Loign Validatioan 
		String actResuelt =driver.findElement(By.xpath("//div/h1")).getText();
		String expResult="Dashboard";//Text in under Dashboard tab
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResuelt, expResult);
		System.out.println("------------Application Loing Sucessfully------------");
		softassert.assertAll();
		
	   
	}

}
