package com.syntax.class02;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("-----This is before Suite-----");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("-----This is before Test-----");
	}
	
	
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
	
	
	
	@AfterTest
	public void AfterTest() {
		System.out.println("-----This is After Test-----");
	}
	
	@AfterSuite
	public void AfterSuitee() {
		System.out.println("-----This is After Suite-----");
	}

}
