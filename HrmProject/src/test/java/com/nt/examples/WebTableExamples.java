package com.nt.examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String app_url = "D://SeleniumTraining By Ashok Ready//Documents//Selenium\\WebTable.html";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get(app_url);
        System.out.println("Sucessfully launched chrome browser");
        
       String textName= driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
       String beforexpath = "//table/tbody/tr[";
       String afterXpath="]/td[2]";
       
      List getRowcount= driver.findElements(By.xpath("//table/tbody/tr"));
      System.out.println("Numbrr of rows"+getRowcount);
      int rowCount=getRowcount.size();
      System.out.println("Numbrr of rows ::"+rowCount);
 
      for(int i=2;i<=rowCount;i++){
    	 String name= driver.findElement(By.xpath(beforexpath+i+afterXpath)).getText();
    	 System.out.println("Text Name ="+name);
    	 
    	 if (name.contains("Cecil.Bonaparte")){
    		 driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]/input")).click();
    		 break;
    		 
    	 }
    		 
      }
     
	}

}
