package com.nt.hrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HRMAdminDeleteUser {

	@Test
	public void deleteUser() throws InterruptedException{
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
		
		String beforeXpah = "//table/tbody/tr[";
		String afterXpah = "]/td[2]";
		
		List listuser = driver.findElements(By.xpath("//table/tbody/tr"));
		
		int sizeOfUsers= listuser.size();
		
		System.out.println("Size of UserList :: "+sizeOfUsers);
		
		for (int i=2;i<=sizeOfUsers;i++){
			String listUsers =driver.findElement(By.xpath(beforeXpah+i+afterXpah)).getText();
			System.out.println("List of Users :: "+listUsers);
			if(listUsers.contains("dilshad")){
				driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]/input")).click();
				driver.findElement(By.xpath("//input[@id='btnDelete']")).click(); //Click on Delete Button
				Thread.sleep(10000);
				driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();//Click on Delete button on the popup
				//driver.findElement(By.xpath("//input[@class='btn reset']")).click();
				System.out.println("User Deleted sucessfully");
				System.out.println("==============================================================");
				
				
			}
		}
	}
   
}
