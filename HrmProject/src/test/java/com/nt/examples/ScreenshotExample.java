package com.nt.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScreenshotExample {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		String URL="https://www.facebook.com/";
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver/chromedriverv103.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//FaceBook Loing 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test.subhash@gmail.com");  //Enter user name 
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Subhash9596");  				//Ener Password
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
	   //TakeScreehShotCode
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File file=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D:\\screenshot\\filescreehshot.png"));
		
//		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screenshot, new File("D:\\screenshot\\filescreehshot.png"));
		
			// TODO Auto-generated catch block
	
		
	         
		}
	

}
