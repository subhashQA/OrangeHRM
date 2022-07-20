package com.nt.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Browsers {


	@Test
	public void chromeBrowser(){
		System.out.println("Testing Started");
		
		String app_url = "https://opensource-demo.orangehrmlive.com/";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.get(app_url);
        String actResult= driver.getTitle();
        System.out.println("Actual Result :: "+actResult);
        String expResult="OrangeHRM";
        //Assert.assertEquals(actResult, expResult);//Hard Assert
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actResult, expResult);
        System.out.println("Sucessfully launched chrome browser");
        softassert.assertAll();
        
        
	}
	@Test
	public void firefoxBrowser(){
		
	System.out.println("Testing Started");
		
		String app_url = "https://opensource-demo.orangehrmlive.com/";
		String browser_path="lib/geckodriver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", browser_path);
		WebDriver driver = new FirefoxDriver();
	    driver.manage().window().maximize();
        driver.get(app_url);
        String actualResult =driver.findElement(By.linkText("Forgot your password?")).getText();
        String expResult="Forgot your password?";
        SoftAssert softassert = new SoftAssert();
        softassert.assertNotEquals(actualResult, expResult, "This both actResult and ExpResult are not mathced");
        System.out.println("Sucessfully launched firefox browser");
		
	}

}
