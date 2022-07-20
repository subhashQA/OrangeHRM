package com.nt.hrm;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HRMUserWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//@Test
	public void userTable(){
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
			
				
				//Click on 5th column and select the check box 
				String textName = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText();
				System.out.println("This is usrname ::"+textName);
				driver.findElement(By.xpath("//table/tbody/tr[5]/td[1]")).click();
				System.out.println("===========================================");
		

		
	}

}