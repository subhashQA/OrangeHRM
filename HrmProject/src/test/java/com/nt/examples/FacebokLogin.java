package com.nt.examples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.nt.hrm.TestBase;

public class FacebokLogin extends TestBase {
	
	@Test()
	public static void loigFacebook() {
		// TODO Auto-generated method stub
		
//		String URL="https://www.facebook.com/";
//		System.setProperty("webdriver.chrome.driver", "lib/Chromedriverv103/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.facebook.com/");
		
		//FaceBook Loing 
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test.subhash@gmail.com");  //Enter user name 
//		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Subhash9596");  				//Ener Password
//		driver.findElement(By.xpath("//button[@name='login']")).click(); //Click on Loing BUTTON
//		System.out.println("Sucessfull runing login test scripts");
//		driver.close();
	

	}

}
