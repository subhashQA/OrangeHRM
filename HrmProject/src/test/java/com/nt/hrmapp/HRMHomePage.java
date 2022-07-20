package com.nt.hrmapp;

import javax.management.DescriptorKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HRMHomePage {
	@Test(priority=1,description = "This test case validates to check ForgotPassword Link")
	public void verify_Forgotpwdlink(){
	   //Browser Launch Code
	   String app_url = "https://opensource-demo.orangehrmlive.com/";
	   String browser_path="lib/chromedriver/chromedriverv103.exe";
	   System.setProperty("webdriver.chrome.driver", browser_path);
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get(app_url);
	   System.out.println("=============Sucessfully launched chrome browser===========");
	   
	   String actResult=driver.findElement(By.linkText("Forgot your password?")).getText();
	   String expResult ="Forgot your password?";
	   SoftAssert softassert = new SoftAssert();
	   softassert.assertEquals(actResult, expResult);
	   System.out.println("--------------------------------");	
	}
	
	@Test(enabled=false)
	public void  VerifyResetPassword(){
		//Browser Launch Code
		System.out.println("------------------Applicatin Start --------------------");
		String app_url = "https://opensource-demo.orangehrmlive.com/";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.get(app_url);
        System.out.println("Sucessfully launched chrome browser");
        //Forgot Password code
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@id='securityAuthentication_userName']")).sendKeys("abcd");
		//Validation for forgot password
		driver.findElement(By.xpath("//input[@id='btnSearchValues']")).click();
		
	    String actResult =driver.findElement(By.xpath("//*[contains(text(),'Please contact HR admin in order to reset the password')]")).getText();
        String expResult ="Please contact HR admin in order to reset the password";
   
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actResult, expResult);
        System.out.println("--------------------------------------");
		
		//driver.findElement(By.xpath("//input[@id='btnCancel']")).click();
	}
	
	@Test()
	public void  verifyCancelForgotPassword(){
		//Browser Launch Code
		System.out.println("------------------Applicatin Start --------------------");
		String app_url = "https://opensource-demo.orangehrmlive.com/";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.get(app_url);
        System.out.println("Sucessfully launched chrome browser");
        //Forgot Password code
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@id='securityAuthentication_userName']")).sendKeys("abcd");
		//Validation for cancel reset password
		//driver.findElement(By.xpath("//input[@id='btnSearchValues']")).click();
		driver.findElement(By.xpath("//input[@id='btnCancel']")).click();
		
	    String actResult =driver.findElement(By.xpath("//div[contains(text(), 'LOGIN Panel')]")).getText();
        String expResult ="LOGIN Panel";
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actResult, expResult);
        System.out.println("------------------Cancel password --------------------");
	}
	

}
