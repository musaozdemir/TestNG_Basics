package com.syntax.class01;

import org.testng.annotations.Test;

public class TestNGintro {
	
	@Test //we use annotation to mark a method as a test method
	public void testOne() {
		System.out.println("I am test oen");
	}
	@Test
	public void testTwo() {
		System.out.println("I am test two");
	}
	@Test
	public void testThree() {
		System.out.println("I am test three");
	}
	
	@Test
	public void testFour() {
		System.out.println("I am test four");
		
	}
	//all test method will get executed in alphabetical order
}
