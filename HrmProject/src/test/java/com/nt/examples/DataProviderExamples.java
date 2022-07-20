package com.nt.examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;

public class DataProviderExamples {
	
	
	
	//@Test(dataProvider="testData")
	public void stringAarry ( String d){
		
		System.out.println(">>>>>>"+d);
		
	}
	//@DataProvider(name="testData")
	public String [] testdata(){
		String [] data= new String []
			{"subhash","ingale","test","test2"};
		    return data;
	}
	

	//@Test(dataProvider="testData")
	public void singaleDimArray( String a){
		
		System.out.println(">>>>>>"+a);
		
	}
	//@DataProvider(name="testData")
	public Object [] testdata2(){
		Object [] data= new Object []{"subhah","ingale"};
		    return data;
	}
	
	@Test(dataProvider="testData")
	public void multiDimArry( String a,String b){
		
		System.out.println(a+">>>>>>"+b);
		
	}
	@DataProvider(name="testData")
	public Object [][] testdata1(){
		Object [][] data= new Object [][] {
			{"subhah","ingale"},
			{"subhah","ingale"}
	} ;	
	return data;
	}
}






