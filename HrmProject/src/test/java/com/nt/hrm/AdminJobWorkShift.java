package com.nt.hrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AdminJobWorkShift {
	@Test
	public void addWorkshift() throws InterruptedException {
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
		driver.findElement(By.linkText("Work Shifts")).click();//click on Job Categories
		
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();//Click on add button
		
		//Add work shift
		driver.findElement(By.xpath("//input[@id='workShift_name']")).clear();
		driver.findElement(By.xpath("//input[@id='workShift_name']")).sendKeys("US");//Enter Shift Name
		
		WebElement element =driver.findElement(By.xpath("//select[@id='workShift_workHours_from']"));
		Select workshiftFrom = new Select(element);
		workshiftFrom.selectByVisibleText("09:00");

		WebElement element1 =driver.findElement(By.xpath("//select[@id='workShift_workHours_to']"));
		Select workshoftto = new Select(element1);
		workshoftto.selectByVisibleText("18:00");
		

		WebElement element2 =driver.findElement(By.xpath("//select[@id='workShift_availableEmp']"));
		Select listEmployee = new Select(element2);
		System.out.println("Employee List"+listEmployee);
		listEmployee.selectByVisibleText("vijaya bunage");
		driver.findElement(By.xpath("//a[@id='btnAssignEmployee']")).click();
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();

}
}