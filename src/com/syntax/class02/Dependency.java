package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dependency {
	
	public static WebDriver driver;
	@BeforeMethod
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	}
	
	@Test()
	public void validLogin() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		String welcomeText  = driver.findElement(By.id("welcome")).getText();
		
		if(welcomeText.contains("Admin")) {
			System.out.println("Admin is logged in.test pass");
		} else {
			System.out.println("Admin is NOT logged in.test fail");
		}
	}
	
	@Test(groups="regression",dependsOnMethods = "validLogin")//if validlogin has only than execute invalidlogin
										  // otherwise if validLogin  	
	public void invalidLogin() {
	
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		
		
		String spanMessage = driver.findElement(By.id("spanMessage")).getText();
		String expectedErrorMessage = "Password cannot be empty";
		
		if(spanMessage.contentEquals(expectedErrorMessage)) {
			System.out.println("empty Password message displayed. test pass");
		} else {
			System.out.println("empty Password message Not displayed. test fail");
		}
		
	}
	

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
