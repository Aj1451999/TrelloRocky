package com.trello.qspiders.learntestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OneGoodAutomationScript 
{
	WebDriver driver;
	@BeforeMethod
	@Parameters({"browsername","url"})
	public void configBeforeMethod(String browsername,String url) {
		if (browsername.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (browsername.equals("edge")) {
			driver= new EdgeDriver();
		}
		else if (browsername.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		Reporter.log("Browser has been Launched");
		driver.manage().window().maximize();
		driver.get(url);
		Reporter.log("URL Triggered");
		
	}
	@AfterMethod
	public void configAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
		Reporter.log("Browser Session Terminated");
		
	}
	@Test
	@Parameters({"username","password"})
	public void actiTimeLoginLogout(String username,String password) throws Throwable 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		Reporter.log("Successfully Logged into the application");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutLink")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Successfully logged out from the application");
		
	}
	

}
