package com.syntax.class01;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DifferentAnnotations {


	@BeforeMethod
	public void before() {
		System.out.println("This is before method");
	}
	
	
	@Test
	public void testMethod1() {
		System.out.println("This is actual test method 1");
	}

	@Test
	public void testMethod2() {
		System.out.println("This is actual test method 2");
	}

	@Test
	public void testMethod3() { 
		System.out.println("This is actual test method 3");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("This is after method");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("-----This is before class annotation -----");
	}
	
	@AfterClass
	public void afterCls() {
		System.out.println("-----This is after class annotation -----");
	}
	
	
}
