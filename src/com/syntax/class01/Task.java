package com.syntax.class01;

import org.testng.annotations.Test;

public class Task {

	int num=22;
	
	@Test
	public void number() {
		for(int i=0; i<num;i++) {
			System.out.print(i);
		}
	}
}
