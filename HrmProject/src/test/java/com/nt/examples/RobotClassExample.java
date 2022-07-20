package com.nt.examples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotClassExample {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		
		String URL="https://www.facebook.com/";
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver/chromedriverv103.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//FaceBook Loing 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test.subhash@gmail.com");  //Enter user name 
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Subhash9596");  				//Ener Password
		//driver.findElement(By.xpath("//button[@name='login']")).click(); //Click on Loing BUTTON
		//Enter key using robout class
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
		System.out.println("Sucessfull runing login test scripts");
		driver.close();
	

	}

}
