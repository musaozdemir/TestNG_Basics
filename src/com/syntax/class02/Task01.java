package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task01 {
//	Open chrome browser
//	Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//	Login into the application
//	Click on Add Employee
//	Verify labels: Full Name, Employee Id, Photograph are displayed
//	Provide Employee First and Last Name
//	Add a picture to the profile
//	Verify Employee has been added successfully
//	Close the browser

	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void addEmployee() throws InterruptedException {
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		Thread.sleep(2000);
		
		SoftAssert softAssertion = new SoftAssert();
//		WebElement loginDetailsText =  driver.findElement(By.xpath("//label[@for= 'chkLogin']"));
//		softAssertion.assertFalse(loginDetailsText.isDisplayed());
//		
		String expectedFullNameText = "Full Name";
		String actualFullNameText = driver.findElement(By.xpath("//label[@class= 'hasTopFieldHelp']")).getText();
		softAssertion.assertEquals(actualFullNameText, expectedFullNameText);
		
		String expectedEmployeeId = "Employee Id";
		String actualEmployeeIdText = driver.findElement(By.xpath("//label[@for= 'employeeId']")).getText();
		softAssertion.assertEquals(actualEmployeeIdText, expectedEmployeeId);
		
		String expectedPhotographText = "Photograph";
		String actualPhotographText = driver.findElement(By.xpath("//label[@for= 'photofile']")).getText();
		softAssertion.assertEquals(actualPhotographText, expectedPhotographText);
		
		softAssertion.assertAll();
		
		driver.findElement(By.id("firstName")).sendKeys("Musa");
		driver.findElement(By.id("lastName")).sendKeys("OZ");
		WebElement chooseFileButton = driver.findElement(By.id("photofile"));
		chooseFileButton.sendKeys("/Users/musaozdemir/Desktop/dont-ever-give-up.jpg");
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(5000);
		
		String expectedEmployeeName = "Musa";
		String actualEmployeeName = driver.findElement(By.id("personal_txtEmpFirstName")).getText();
		softAssertion.assertEquals(actualEmployeeName, expectedEmployeeName);
		
	}

}
