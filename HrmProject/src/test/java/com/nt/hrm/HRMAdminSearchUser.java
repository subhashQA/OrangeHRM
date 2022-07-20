package com.nt.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HRMAdminSearchUser {

	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		HRMAdminSearchUser systemuser = new HRMAdminSearchUser();
		//systemuser.systemUserSearch("Admin");
		//systemuser.systemUserSearch("ESS", "Aravind");
	
	}
	public void systemUserSearch(String username){
		
		//Browser Code 
		String app_url = "https://opensource-demo.orangehrmlive.com/";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.get(app_url);
        System.out.println("Sucessfully launched chrome browser");
        //Loign Code 
		driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		//Steps to navigate to user
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Admin"))).build().perform();//Mouse over the admin link
		actions.moveToElement(driver.findElement(By.linkText("User Management"))).build().perform();
		driver.findElement(By.linkText("Users")).click();
	

		//System Search Code
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		
		System.out.println("-------------------------------");
		
		driver.close();
	
	}
	public void systemUserSearch(String userroll ,String employeeName) throws InterruptedException{
		//Browser Code 
				String app_url = "https://opensource-demo.orangehrmlive.com/";
				String browser_path="lib/chromedriver/chromedriverv103.exe";
				System.setProperty("webdriver.chrome.driver", browser_path);
				WebDriver driver = new ChromeDriver();
			    driver.manage().window().maximize();
		        driver.get(app_url);
		        System.out.println("Sucessfully launched chrome browser");
		        //Loign Code 
				driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
				driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
				driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
				driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
				driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
				
				//System Search Code
				Actions actions = new Actions(driver);
				actions.moveToElement(driver.findElement(By.linkText("Admin"))).build().perform();//Mouse over the admin link
				actions.moveToElement(driver.findElement(By.linkText("User Management"))).build().perform();
				driver.findElement(By.linkText("Users")).click();
				
				WebElement element = driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']"));
				Select select = new Select(element);
				select.selectByVisibleText(userroll);
				driver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']")).sendKeys(employeeName);
				driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
				
		
	}
	
}
