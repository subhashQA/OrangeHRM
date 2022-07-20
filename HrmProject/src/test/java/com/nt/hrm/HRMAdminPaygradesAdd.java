package com.nt.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HRMAdminPaygradesAdd {
	@Test()
	public void addJobTitle() throws InterruptedException{
		
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
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.linkText("Job"))).build().perform();
		driver.findElement(By.linkText("Pay Grades")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		
		//Pay Grade
		driver.findElement(By.xpath("//input[@id='payGrade_name']")).sendKeys("GradeDew");
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
		String actResult = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]")).getText();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResult, "Successfully Saved");
		
		
		//Add Currency
		
		driver.findElement(By.xpath("//input[@id='btnAddCurrency']")).click();
		
		driver.findElement(By.xpath("//input[@id='payGradeCurrency_currencyName']")).sendKeys("INR - Indian Rupee");//CurrencyType
		driver.findElement(By.xpath("//input[@id='payGradeCurrency_minSalary']")).sendKeys("1000");
		driver.findElement(By.xpath("//input[@id='payGradeCurrency_maxSalary']")).sendKeys("10000");
		driver.findElement(By.xpath("//input[@id='btnSaveCurrency']")).click();
		
		
		String actResult1 = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]")).getText();
		SoftAssert softassert1 = new SoftAssert();
		softassert.assertEquals(actResult, "Successfully Saved");
		
		
		//Assigned Currency
		
		
		System.out.println("----------------------------------------------");
		//driver.quit();
		

}
}