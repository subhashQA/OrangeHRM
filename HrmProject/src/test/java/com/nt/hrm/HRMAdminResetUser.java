package com.nt.hrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HRMAdminResetUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HRMAdminResetUser reset = new HRMAdminResetUser();
		reset.systemUserReset("ESS", "Ananya Dash", "Enabled");
	}
public void systemUserReset(String userroll ,String employeeName,String status){
		
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
		
		//Rset passwrod code 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Admin"))).build().perform();//Mouse over the admin link
		actions.moveToElement(driver.findElement(By.linkText("User Management"))).build().perform();//Mouse over the suer managment
		driver.findElement(By.linkText("Users")).click();//Click on Users link 
		
		WebElement UserRole = driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']"));
		Select select = new Select(UserRole);
		select.selectByVisibleText(userroll);//Select visiable text from userRole dropdonw

		driver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']")).sendKeys(employeeName);//Enter employee name 
		
		WebElement Status = driver.findElement(By.xpath("//select[@id='searchSystemUser_status']"));
		Select status1 = new Select(Status);
		status1.selectByVisibleText(status); // Select visible text from status dropdown
		
		driver.findElement(By.xpath("//input[@id='resetBtn']")).click();  // Click on Reset button 
		
		System.out.println("-----------------------------------------------------------------------");
	}
}
