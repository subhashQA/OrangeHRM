package com.nt.hrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminPayGrades {
	//@Test
	public void payGrades() {
		
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
		action.moveToElement(driver.findElement(By.linkText("Job"))).build().perform();
		driver.findElement(By.linkText("Pay Grades")).click();//Move to pay grades link
		
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();//Click on add button
	
		driver.findElement(By.xpath("//input[@id='payGrade_name']")).sendKeys("ManagerQA");//Enter  Name

		driver.findElement(By.xpath("//input[@id='btnSave']")).click();//Enter  save button
		
		String actResult = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]")).getText();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResult, "Successfully Saved");
		
		//Assign Currency
		
		driver.findElement(By.xpath("//input[@id='btnAddCurrency']")).click();//Click on add button
		
		
		driver.findElement(By.xpath("//input[@id= 'payGradeCurrency_currencyName']")).sendKeys("INR - Indian Rupee");//search and select currency
		driver.findElement(By.xpath("//input[@id= 'payGradeCurrency_minSalary']")).sendKeys("1000");//Enter minimum Salary
		driver.findElement(By.xpath("//input[@id= 'payGradeCurrency_maxSalary']")).sendKeys("10000");//Enter Maximum Salary
		driver.findElement(By.xpath("//input[@id='btnSaveCurrency']")).click();//Click on save button
		
		String actResult1 = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]")).getText();
		SoftAssert softassert1 = new SoftAssert();
		softassert.assertEquals(actResult, "Successfully Saved");
		

		System.out.println("----------------------------------------------");
		driver.quit();
	}
	
	//@Test(priority=1)
    public void updatePayGrade() throws InterruptedException{
		
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
		driver.findElement(By.linkText("Pay Grades")).click();
	
		
		//Click on 1th column and select the check box 
		//String textName = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
		//System.out.println("This is usrname ::"+textName);
		//driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).click();
		//driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).click();
		
		System.out.println("===========================================");
		
		
		Thread.sleep(5000);
		
		String beforeXpath ="//table/tbody/tr[";
		String afterXpath="]/td[2]";
	
		
		List elemnt =driver.findElements(By.xpath("//table/tbody/tr"));//Get the all list of job titles 
		int elementSize = elemnt.size();//Get the size of the elements in integer
		System.out.println("List Job Title :: "+elementSize);//Print thte size
		
	   for(int i=2;i<elementSize;i++){  //Using for loop
    	 String listOfpayGrases =driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();//Get text of all elements
    	 System.out.println("List of Pay Grades avilabe ::  "+listOfpayGrases);
    	
    	if(listOfpayGrases.contains("ManagerQA")){	
    		
        driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]/a")).click();//Click on HyperLink	
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();//click on Edit button on popup
		driver.findElement(By.xpath("//input[@id='payGrade_name']")).clear();
		driver.findElement(By.xpath("//input[@id='payGrade_name']")).sendKeys("ManagerQAUpdate");//Job Title
		
		driver.findElement(By.xpath("//input[@id='btnSave']")).click(); //Click on Add Button

		String actResult = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]")).getText();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResult, "Successfully Saved");
		
		System.out.println("----------------------------------------------");
		driver.close();
	} 	
	}
	}
	@Test
	public void deleteGrade() {
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
			driver.findElement(By.linkText("Pay Grades")).click();
		
			
			//Click on 1th column and select the check box AND delete 
	
			driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).click();
			driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
			driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
			System.out.println("===========================================");
			
		
	}
}

