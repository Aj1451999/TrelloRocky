package com.trello.qspiders.JavaScriptexecutor;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
public class CaptureHeightandWidth 
{
	public static void main(String[] args)
	{
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//driver.get("https://demo.actitime.com/login.do");
		driver.get("https://www.google.com/doodles");
		JavascriptExecutor JSE = (JavascriptExecutor)driver;
		for ( ; ; )
		{
		try
		{
			WebElement Icelandday= driver.findElement(By.xpath("//a[text()='Iceland National Day 2022']"));
			//a[text()='44th Anniversary of the Birth of Hip Hop']
			Icelandday.click();
			break;
	
		} catch (NoSuchElementException e)
		{
			JSE.executeScript("window.scrollBy(0,500)");
		}
		}
	}

}
