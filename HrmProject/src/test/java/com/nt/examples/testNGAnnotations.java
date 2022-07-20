package com.nt.examples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGAnnotations {
	@BeforeSuite
	public void method1(){
		System.out.println("I am in method 1 and before SUIT");
	}
	@AfterSuite
	public void method2(){
		System.out.println("I am in method 2 and AFTER SUIT");
	}
	@BeforeTest
	public void method3(){
		System.out.println("I am in method 3 and BEFORE TEST");	
	}
    @AfterTest
	public void method4(){  
		System.out.println("I am in method 4 and AFTER TEST");	
	}
    @BeforeGroups
	public void method5(){  
		System.out.println("I am in method 5 and BEFORE GROUP");
	}
	@AfterGroups
	public void method6(){
		System.out.println("I am in method 6 and AFTER GROUP");
	}
	
	@BeforeClass
	public void method7(){  
		System.out.println("I am in method 7 and BEFORE CLASS");
	}
	@AfterClass
	public void method8(){
		System.out.println("I am in method 8 and AFTER CLASS");
	}
	
	@BeforeMethod
	public void method9(){
		System.out.println("I am in method 9 and BEFORE METHOD");	
	}
	@AfterMethod
	public void method10(){  
		System.out.println("I am in method 10 and AFTER METHOD");
	}
	@Test
	public void method11(){  
		System.out.println("I am in method 11 and TEST");
	}
	@Test
	public void method12(){
		  
		System.out.println("I am in method 12 and TEST");
		
	}
	
}
