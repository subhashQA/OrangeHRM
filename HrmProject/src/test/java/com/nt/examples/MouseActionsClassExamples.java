package com.nt.examples;
//This code used to drap and drop of element using actions class
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsClassExamples {
    static WebDriver driver;
	public static void main(String[] args){ 
		//Loing 
		String app_url = "https://jqueryui.com/";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get(app_url);
        System.out.println("Sucessfully launched chrome browser");
		//Drab and drop the element
        driver.findElement(By.linkText("Draggable")).click();
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        
        Actions browseract = new Actions(driver);
        browseract.dragAndDropBy(driver.findElement(By.id("draggable")), 100, 100).build().perform();
        
	}
}
