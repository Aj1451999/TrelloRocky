package com.trello.qspiders.learntestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssert 
{
	WebDriver driver;
	@BeforeMethod
	@Parameters({"browserName","url"})
	
	public void configBeforeMethod(String browserName,String url) {
		if(browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		}else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		Reporter.log("Browser has been launched");
		driver.get(url);
		Reporter.log("URL applied");
	}
	@AfterMethod
	public void configAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
		Reporter.log("Browser Session Terminated");
	}
	@Test
	public void actiTimeLOginLogut(String username,String password) throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(wait.until(ExpectedConditions.titleIs("actiTIME-Login")), "The Login page title is not found correct");
		//Assert.assertTrue(wait.until(ExpectedConditions.titleIs("actiTIME-Login")), "The Login page title is not found correct");
		Assert.assertEquals(driver.getTitle(), "actiTIME-Login");
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.actitime.com/login.do");
		Reporter.log("Login Page is displayed.");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		Reporter.log("Successfully Logged into the application");
		//Thread.sleep(5000);
		
		
		softAssert.assertTrue(wait.until(ExpectedConditions.titleIs("actiTIME-Enter Time-Track")), "Home Page title is found incorrect");
		SoftAssert softAssert2 = new SoftAssert();
		//Assert.assertTrue(wait.until(ExpectedConditions.titleIs("actiTIME-Login")), "The Login page title is not found correct");
		//Assert.assertEquals(driver.getTitle(), "actiTIME-Login");
		softAssert2.assertEquals(driver.getCurrentUrl(), "https://demo.actitime.com/submit_tt.do");
		softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutLink"))).isDisplayed(),"The Logout Option is not visible");
		Reporter.log("Home Page is displayed.");
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLInk")));
		WebElement logoutLink = driver.findElement(By.id("logoutLink"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='prelnsertedTransformedMoireld']")));
		logoutLink.click();
		Reporter.log("Successfully Logged out into the application");
		softAssert.assertAll("All Validations are Sucessfull");
		
	}

}
