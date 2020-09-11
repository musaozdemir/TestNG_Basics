package com.syntax.class01;

import org.testng.annotations.Test;

public class TestNGDepencies {

	@Test
	public void login() {
		System.out.println("Test that logges in into the application");
	}
	
	@Test(dependsOnMethods = "login")
	public void checkReports() {
		System.out.println("test for check reports");
	}
	
	
	
}
