package com.trello.qspiders.learntestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsageOfBeforeAndAfterMethod 
{
	WebDriver driver;
	@BeforeMethod
	public void configBeforeMethod() {
		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
	}
	@AfterMethod
	public void configAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
	}
	@Test
	public void testcase() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("loginButton")).click();
		System.out.println("Ajay I have done");
		Thread.sleep(5000);
		
	}

}
