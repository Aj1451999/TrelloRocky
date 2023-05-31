package com.trello.qspiders.learnactionclass;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionOnMyntra 
{
	WebDriver driver;
	@BeforeMethod
	public void configBeforeMethod() {
		String url ="https://www.myntra.com/";
		String browserName = "edge";
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		Reporter.log("Browser Launched");
		driver.manage().window().maximize();
		driver.get(url);
		Reporter.log("URL Triggered.");
	}
	@AfterMethod
	public void configAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
		Reporter.log("Browser Session Terminated");
	}
	@Test
	public void moveOnSoManyEleAtATime()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions actionrefrence= new Actions(driver);
		List<WebElement> allNavMenuOptions = driver.findElements(By.xpath("//div[@class='desktop-navContent']"));
		for (WebElement navOption : allNavMenuOptions)
		{
			actionrefrence.moveToElement(navOption).pause(2000).perform();
		}
	}
}
























