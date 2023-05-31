package com.trello.qspiders.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass 
{
	public WebDriver driver;
	public WebDriverUtility webdriverUtiles = new WebDriverUtility();
	public FileUtility fileUtils = new FileUtility();
	public JavaUtility javaUtils = new JavaUtility();
	public ExcelUtility excelUtils = new ExcelUtility();
	@BeforeClass
	public void configBeforeMethod() throws IOException {
		String browserName = fileUtils.readDataFromPropertyFile("browser");
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}else
			if(browserName.equals("edge"))
			{
				driver = new EdgeDriver();
			}
		driver.manage().window().maximize();
		driver.get(fileUtils.readDataFromPropertyFile("url"));
	}
	@AfterClass
	public void configAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
	}

}
