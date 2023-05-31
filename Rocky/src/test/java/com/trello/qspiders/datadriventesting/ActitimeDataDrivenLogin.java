package com.trello.qspiders.datadriventesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActitimeDataDrivenLogin 
{
	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resource/actitimedata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String browsername = pobj.getProperty("browser");
		if (browsername.equals("edge"))
		{
			driver =new EdgeDriver();
		}else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get(pobj.getProperty("url"));
		driver.findElement(By.id("username")).sendKeys(pobj.getProperty("username"));
		driver.findElement(By.name("pwd")).sendKeys(pobj.getProperty("password"));
		Thread.sleep(5000);
		driver.findElement(By.id("loginButton")).click();
	}

}
