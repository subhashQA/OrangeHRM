package com.nt.examples;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestCaseWithDataProvider {
	@Test(dataProvider="testdata")
	public void facebookLogin(String Username,String password) throws AWTException{
		
		String URL="https://www.facebook.com/";
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver/chromedriverv103.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//FaceBook Loing 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Username);  //Enter user name 
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);  				//Ener Password
		driver.findElement(By.xpath("//button[@name='login']")).click(); //Click on Loing BUTTON
		System.out.println("Sucessfull runing login test scripts");
		driver.close();	
	}
	@DataProvider(name="testdata")
	public Object[][] testDataFacebook(){
			return new Object [][]{
			{"test.subhash@gmail.com","Subhash9596"},	
			{"ingale.subhash@gmail.com","subhash1984"}
			
		};
	}

}
