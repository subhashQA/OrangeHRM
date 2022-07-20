package com.nt.examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertClassExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Test
	public void getText(){
		
		//Browser Code 
		String app_url = "http://demo.guru99.com/test/delete_customer.php";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.get(app_url);
        System.out.println("Sucessfully launched chrome browser");
        
        
        //click on ok windows alreat code
        
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        Alert alert= driver.switchTo().alert();
        String TextName =alert.getText();//To get text from popup 
        System.out.println("Woindow popup text naem ::  "+TextName);
        alert.accept();//Click on Ok button on Alreat Popup
        alert.dismiss();//Click on Cancel Button
        alert.sendKeys("This is used for send keys");//This is used for send keys.
        
        
        
        
		
	}

}
