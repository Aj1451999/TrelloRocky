package com.trello.qspiders.learnactionclass;


	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.testng.Reporter;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class ActionsOnMyntracop {
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
		public void moveMousePointerOnMenSection() throws Throwable {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Actions actions = new Actions(driver);
			WebElement menSectionOnNav = driver.findElement(By.xpath("//div[@class='desktop-navLinks']//a[text()='Men']"));
			//move the control of the mouse pointer on to the element.
			//moveToElement(WebElement target)
			//With calling the perform() at last action will not be performed on the app.
			actions.moveToElement(menSectionOnNav).perform();
			Thread.sleep(5000);
		}
		@Test
		public void moveOnSoManyEleAtATime() throws Throwable {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Actions actions = new Actions(driver);
			List<WebElement> allNavMenuOptions = driver.findElements(By.xpath("//div[@class='desktop-navContent']"));
			for (WebElement navOption : allNavMenuOptions) {
				//we have more than one action - composite action
				//we can pause the series actions class action with the interval 
				//pause(long pause) 
				actions.moveToElement(navOption).pause(2000).perform();
			}
		}
		@Test
		public void oneEleOffsetAndMoveToOther() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Actions actions = new Actions(driver);
			WebElement menSectionOnNav = driver.findElement(By.xpath("//div[@class='desktop-navLinks']//a[text()='Men']"));
			actions.moveToElement(menSectionOnNav).pause(1000).moveByOffset(31, 0).pause(1000).moveByOffset(104, 0).pause(2000).moveByOffset(178, 0).pause(1000).moveByOffset(276, 0).pause(1000).moveByOffset(384, 0).moveByOffset(465, 0).build().perform();
		}
	}
