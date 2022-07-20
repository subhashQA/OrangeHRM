package com.nt.hrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminJobJobCategories {
	
	@Test(priority=1)
	public void addJobCategories() throws InterruptedException {
		String app_url = "https://opensource-demo.orangehrmlive.com/";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(app_url);
		System.out.println("-------------------Sucessfully launched chrome browser----------------");
		//Login Code 
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		System.out.println("-------------------Login Sucessfully----------------");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Admin"))).build().perform();
		action.moveToElement(driver.findElement(By.linkText("Job"))).build().perform();//Move to Job
		driver.findElement(By.linkText("Job Categories")).click();//click on Job Categories
		
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();//Click on add button
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='jobCategory_name']")).sendKeys("TestJob1");//Enter Employment Status

		driver.findElement(By.xpath("//input[@id='btnSave']")).click();//Enter  save button
		
		String actResult = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]")).getText();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResult, "Successfully Saved");
		
		System.out.println("----------------------------------------------");
		driver.quit();
	}
	
	@Test(priority=2)
    public void updateJobCategories() throws InterruptedException{
		
		String app_url = "https://opensource-demo.orangehrmlive.com/";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(app_url);
		System.out.println("Sucessfully launched chrome browser");
		//Login Code 
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Admin"))).build().perform();
		action.moveToElement(driver.findElement(By.linkText("Job"))).build().perform();
		driver.findElement(By.linkText("Job Categories")).click();//click on job CATEGOREI
		Thread.sleep(5000);
		String beforeXpath ="//table/tbody/tr[";
		String afterXpath="]/td[2]";
		List elemnt =driver.findElements(By.xpath("//table/tbody/tr"));//Get the all list of job titles 
		int elementSize = elemnt.size();//Get the size of the elements in integer
		System.out.println("List Job Title :: "+elementSize);//Print thte size
		
	   for(int i=2;i<elementSize;i++){  //Using for loop
    	 String listOfEmpStatus =driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();//Get text of all elements
    	 System.out.println("List Employment Status ::  "+listOfEmpStatus);
    	
    	if(listOfEmpStatus.contains("Professionals")){	
    		
        driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]/a")).click();//Click on HyperLink	
    	Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='jobCategory_name']")).clear();
		driver.findElement(By.xpath("//input[@id='jobCategory_name']")).sendKeys("UpdateProfessionals");//Enter Name
		driver.findElement(By.xpath("//input[@id='btnSave']")).click(); //Click on Add Button

		String actResult = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]")).getText();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResult, "Successfully Saved");
		
		System.out.println("----------------------------------------------");
		driver.close();
	} 	
	}
	}
	@Test(priority=3)
	public void deleteJobCategories() {
			String app_url = "https://opensource-demo.orangehrmlive.com/";
			String browser_path="lib/chromedriver/chromedriverv103.exe";
			System.setProperty("webdriver.chrome.driver", browser_path);
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(app_url);
			System.out.println("Sucessfully launched chrome browser");
			//Login Code 
		    driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.linkText("Admin"))).build().perform();
			action.moveToElement(driver.findElement(By.linkText("Job"))).build().perform();
			driver.findElement(By.linkText("Job Categories")).click();
		
			
			//Click on 1th column and select the check box AND delete 
	
			driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).click();
			driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
			driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
			
			String actResult = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Deleted')]")).getText();
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(actResult, "Successfully Deleted");
			System.out.println("===========================================");
			driver.close();
			
		
	}
}


