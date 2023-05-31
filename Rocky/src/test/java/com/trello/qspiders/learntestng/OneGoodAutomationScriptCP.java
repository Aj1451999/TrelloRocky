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

	public class OneGoodAutomationScriptCP {
		WebDriver driver;

		@BeforeMethod
		@Parameters({ "browserName", "url" })
		public void configBeforeMethod(String browserName, String url) {
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
		@Parameters({ "username", "password" })
		public void actiTimeLoginLogout(String username, String password) throws Throwable {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(wait.until(ExpectedConditions.titleIs("actiTIME - Login")),"The Login page title is not found correct.");
			//Assert.assertTrue(wait.until(ExpectedConditions.titleIs("actiTIME - Login")),"The Login page title is not found correct.");
			// Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
			Assert.assertEquals(driver.getCurrentUrl(), "https://demo.actitime.com/login.do");
			Reporter.log("Login Page Is displayed.");
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.name("pwd")).sendKeys(password);
			driver.findElement(By.id("loginButton")).click();
			Reporter.log("Sucessfully Logged into the application.");
			// Thread.sleep(5000);
			softAssert.assertTrue(wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track")),
					"Home Page title is found incorrect.");
			softAssert.assertEquals(driver.getCurrentUrl(), "https://demo.actitime.com/user/submit_tt.do");
			softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutLink"))).isDisplayed(),
					"The Logout Option Is not visible.");
			Reporter.log("Home Page is displayed");
			// wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
			WebElement logoutLink = driver.findElement(By.id("logoutLink"));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='preInsertedTransformedMoireId']")));
			logoutLink.click();
			Reporter.log("Sucessfully logged out from the application.");
			softAssert.assertAll("All Validations are Sucessfull");
		}
	}
