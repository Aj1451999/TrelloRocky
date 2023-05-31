package com.trello.qspiders.HandlingPopus;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Popups 
{
	WebDriver driver;
	@Test(enabled = false)
	public void hiddenDivisionPopUp() throws Throwable
	//Example for Hidden division popup is 
	// Login Page popup
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		WebElement CloseButtonInHDPu = driver.findElement(By.xpath("//button[text()='✕']"));
		CloseButtonInHDPu.click();
		//((WebDriver) CloseButtonInHDPu).close();  "{','}" ClassCastException
	}
	@Test
	public void notificationPopup() {
		//create the Object of ChromeOptions - Selenium Class
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.ajio.com/");
		//driver.get("https://pib.gov.in/");
	}
	
						/* JAVA SCRIPT POPUPS
							1. CONFROMATION POPUP
							2. ALERT POPUP
							3. PROMPT POPUP */
	@Test
	public void alertPopup() throws Throwable{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//block the notifications and trigger URL leads to get ALert popuop
		driver.get("https://pib.gov.in/");
		Thread.sleep(5000);
		//print the ALERT message
		System.out.println(driver.switchTo().alert().getText());
		//handle the Alert Popup
		driver.switchTo().alert().accept();
	}
	@Test
	public void PromptPopUP() throws Throwable 
	{
		/*  Example for prompt popus is asking minimum age to grant permission
		 * 
		 * HTML Code for Prompt popup
		 *     <html>
		 *          <head>
		 *             <script>
							let age = prompt("what is your age?");
							console.log(age);
			           </script>
			         </head>
			    </html>
		*/ 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("file:///C:/Users/AJAY BOSS/Desktop/PromptPopUp.html");
		//get the prompt message
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(5000);
		//pass the prompt data
		driver.switchTo().alert().sendKeys("32");
		driver.switchTo().alert().accept();
		
	}
	@Test
	public void confirmationPopup() throws Throwable 
	{
		// Example for conformation popup is in Press Information Beaur
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://pib.gov.in/");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		//identify min of Defense and click
		WebElement minOfDefense = driver.findElement(By.linkText("Ministry of Defence"));
		Actions actions = new Actions(driver);
		actions.scrollToElement(minOfDefense).pause(3000).click(minOfDefense).perform();
		//print the confirmation message
		String confirmationMessage = driver.switchTo().alert().getText();
		System.out.println("confirmationMessage = " + confirmationMessage);
		//handle the confirmation popup by clicking On Cancel button
		//driver.switchTo().alert().dismiss();
		//handle by clicking on Ok
		driver.switchTo().alert().accept();
		//close the defense tab
		for (String wid  : driver.getWindowHandles()) {
			String windowTitle = driver.switchTo().window(wid).getTitle();
			if (windowTitle.equals("Ministry of Defence| Home")) {
				driver.close();
			}
		}
	}
	@Test
	public void fileDownLoadPopup() throws Throwable {
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.selenium.dev/downloads/");
		driver.findElement(By.linkText("4.8.3")).click();
		Thread.sleep(2000);
		driver.get("chrome://downloads/");
		Thread.sleep(2000);
		WebElement hostEle = driver.findElement(By.tagName("downloads-manager"));
		Thread.sleep(2000);
		WebElement shadowHostEle = hostEle.getShadowRoot().findElement(By.cssSelector("downloads-item[id='frb0']"));
		Thread.sleep(2000);
		shadowHostEle.getShadowRoot().findElement(By.cssSelector("div[id='dangerous']")).findElement(By.cssSelector("cr-button[focus-type='save']")).click();
		//driver.switchTo().alert().accept();
		//NoAlertPresentException Sel - run - unchecked
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(200);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(200);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(200);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.navigate().back();
	}
	@Test
	public void fileUploadPopup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.foundit.in/seeker/registration");
		WebElement fileUploadButton = driver.findElement(By.xpath("//input[@type='file']"));
		fileUploadButton.sendKeys("C:\\Users\\QSP\\Desktop\\pm.pdf");
	}
	@Test
	public void openNewWindowAndTab() {
		driver = new ChromeDriver();
		//create the new window with same browser object
		//driver.switchTo().newWindow(WindowType.WINDOW);
		//create the new tab in the same window and it's object refernce
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.TAB);
	}
}
