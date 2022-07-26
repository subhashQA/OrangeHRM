package com.nt.hrmapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HRMAdmin {
	
public void addUser(String userRole,String employeeName,String userName,String status,
              String password,String conformPasword) throws InterruptedException{

		//Browser Code 
		String app_url = "https://opensource-demo.orangehrmlive.com/";
		String browser_path="lib/chromedriver/chromedriverv103.exe";
		System.setProperty("webdriver.chrome.driver", browser_path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(app_url);
		System.out.println("Sucessfully launched chrome browser");
		//Login Code 
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
				
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Admin"))).build().perform();//Mouse over the admin link
		actions.moveToElement(driver.findElement(By.linkText("User Management"))).build().perform();//Mouse over the User Management
		driver.findElement(By.linkText("Users")).click();//Click on User link 
		
		//Add User code 
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();  // Click on Add button 
		
		WebElement element =driver.findElement(By.xpath("//select[@id='systemUser_userType']")); // Select user role from dropdown
		Select userrole = new Select(element);
		userrole.selectByVisibleText(userRole);
		driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys(employeeName);// Enter Employee Name
		driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(userName);//Enter Username
		
		WebElement element1=driver.findElement(By.xpath("//select[@id='systemUser_status']"));//Select status
		Select Status = new Select(element1);
		Status.selectByVisibleText(status); 
		driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys(password); //Enter password
		driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys(conformPasword);//Enter conform password
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();//Click on save button 
		
		Thread.sleep(10000);
		String actResult = driver.findElement(By.xpath("//div[@class='message success fadable' and contains(text(), 'Successfully Saved')]")).getText();
		String expResult="Successfully Saved";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actResult, expResult);
		
		System.out.println("---------------------User Add Sucessfully------------------------");
		
		driver.quit();
		
		//driver.findElement(By.xpath("//input[@id='btnCancel']")).click();//Click on cancel button 
		
	}

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

public void systemUserSearch(String username){
	
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


	//System Search Code
	driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
	
	System.out.println("-------------------------------");
	
	driver.close();

}
public void systemUserSearch(String userroll ,String employeeName) throws InterruptedException{
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
			
			//System Search Code
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.linkText("Admin"))).build().perform();//Mouse over the admin link
			actions.moveToElement(driver.findElement(By.linkText("User Management"))).build().perform();
			driver.findElement(By.linkText("Users")).click();
			
			WebElement element = driver.findElement(By.xpath("//select[@id='searchSystemUser_userType']"));
			Select select = new Select(element);
			select.selectByVisibleText(userroll);
			driver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']")).sendKeys(employeeName);
			driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
			
	
}
@Test
public void updateUser() throws InterruptedException{
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
	
	//Update User code
	
	String beforeXpath = "//table/tbody/tr[";
	String afterXpath="]/td[2]";
	
	List elemnt =driver.findElements(By.xpath("//table/tbody/tr"));
	int elementSize = elemnt.size();
	System.out.println("List of Users :: "+elementSize);
	
    for(int i=2;i<elementSize;i++){
    	
    	String ListOfUsers =driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
    	System.out.println("List of User avilabe ::  "+ListOfUsers);
    	if(ListOfUsers.contains("Aravind")){
    		driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]/a")).click();
    		System.out.println("User can clik on hyperlink");
    		driver.findElement(By.xpath("//input[@id='btnSave']")).click();//Click on Edit Button
    		
    		WebElement elements = driver.findElement(By.xpath("//select[@id='systemUser_userType']"));
            Select userSelect = new Select(elements);
            userSelect.selectByVisibleText("ESS");
    	    
    		
    		driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).clear();
    		driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys("Cassidy Hope");//Enter Employee name
    		
    		driver.findElement(By.xpath("//input[@id='systemUser_userName']")).clear();
    		driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys("Aravind");//Enter User Name
    
    		WebElement elements1 = driver.findElement(By.xpath("//select[@id='systemUser_status']"));
            Select userSelect1 = new Select(elements1);
            userSelect1.selectByVisibleText("Enabled");
            
            Thread.sleep(5000);
            
            driver.findElement(By.xpath("//input[@id='systemUser_chkChangePassword']")).click();
            
            driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys("Subhash");//Enter Password
    		driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys("Password@123");             
    		driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys("Subhash");//Enter Employee name
    		driver.findElement(By.xpath("//input[@id='systemUser_userName']")).click();//Click on Save button
    		System.out.println("User Updated Sucessfyully");
            
            
    		 
 
    	}
    	
    }
	
	}
}
