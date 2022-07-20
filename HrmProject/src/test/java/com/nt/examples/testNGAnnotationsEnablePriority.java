package com.nt.examples;

import org.testng.annotations.Test;

public class testNGAnnotationsEnablePriority {
    @Test()
	public void  login(){
		System.out.println("I am in Loing ");
	}
    @Test(priority=1)
	public void  AddUser(){
		System.out.println("I am in addUser ");
	}
    @Test(enabled=false)
	public void  UpdateUser(){
		System.out.println("I am in UpdateUser ");
	}
    @Test(priority=2)
	public void  deleteUser(){
		System.out.println("I am in deleteUser ");
	}
    @Test(priority=3)
	public void  Logout(){
		System.out.println("I am in logout ");
	}
}
