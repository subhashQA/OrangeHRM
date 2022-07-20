package com.nt.hrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HRMAdminJob {
	
	//@Test()
	public void addJobTitle(){
		
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
		driver.findElement(By.linkText("Job Titles")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
	
		driver.findElement(By.xpath("//input[@id='jobTitle_jobTitle']")).sendKeys("ManagerQA");//Job Title
		driver.findElement(By.xpath("//textarea[@id= 'jobTitle_jobDescription']")).sendKeys("JobDescription");//Job Description
		driver.findElement(By.xpath("//textarea[@id= 'jobTitle_note']")).sendKeys("Note");//Note
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();//Click on Add Button
		
		
		String actResult = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]")).getText();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResult, "Successfully Saved");
		
		System.out.println("----------------------------------------------");
		driver.quit();
	}
	
	@Test(priority=1)
    public void updateJobTitle() throws InterruptedException{
		
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
		driver.findElement(By.linkText("Job Titles")).click();
	
		
		
		Thread.sleep(5000);
		
		String beforeXpath ="//table/tbody/tr[";
		String afterXpath="]/td[2]";
	
		
		List elemnt =driver.findElements(By.xpath("//table/tbody/tr"));//Get the all list of job titles 
		int elementSize = elemnt.size();//Get the size of the elements in integer
		System.out.println("List Job Title :: "+elementSize);//Print thte size
		
	for(int i=2;i<elementSize;i++){  //Using for loop
    	String listOfTitle =driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();//Get text of all elements
    	System.out.println("List of User avilabe ::  "+listOfTitle);
    	
    	if(listOfTitle.contains("Automation Tester")){	
    	}
    	System.out.println("User can clik on hyperlink");
    		driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]/a")).click();
    	
    		
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();//click on Edit button on popup
	
		driver.findElement(By.xpath("//input[@id='jobTitle_jobTitle']")).sendKeys("Ass.Manager");//Job Title
		driver.findElement(By.xpath("//textarea[@id= 'jobTitle_jobDescription']")).sendKeys("JobDescription");//Job Description
		driver.findElement(By.xpath("//textarea[@id= 'jobTitle_note']")).sendKeys("Note");//Note
		driver.findElement(By.xpath("//input[@id='btnSave']")).click(); //Click on Add Button
		
		
		String actResult = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Updated')]")).getText();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResult, "Successfully Updated");
		
		System.out.println("----------------------------------------------");
		driver.close();
	}
	}

}
