package com.trello.qspiders.learnactionclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoSuggestions
{
	WebDriver driver;
	@Test
	public void handlingmyntraAutoSuggestion() throws Throwable
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.myntra.com/");
		WebElement searchbar = driver.findElement(By.className("desktop-searchBar"));
		searchbar.sendKeys("jac");
		List<WebElement> allAutoSuggestion = driver.findElements(By.xpath("//ul[@class='desktop-group']/li"));
		System.out.println("allAutoSuggestion are  "+ allAutoSuggestion.size());
		for (WebElement suggestion : allAutoSuggestion) {
			String options = suggestion.getText();
			if(options.equals("Jacket Kids"))
			{
				Thread.sleep(1000);
				System.out.println("We got Jacket kids");
				suggestion.click();
				break;
			}
		}
		driver.quit();
	}
	@Test
	public void handlingActive()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		driver.switchTo().activeElement().sendKeys("Aj Tech Monster");
	}
	@Test
	public void defaultAutoSuggestion()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		WebElement searchbar = driver.findElement(By.id("APjFqb"));
		searchbar.click();
		//searchbar.sendKeys(" ");
		List<WebElement> allAutoSuggestion = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
		//System.out.println("allAutoSuggestion are  "+ allAutoSuggestion.size());
		System.out.println(allAutoSuggestion);
		for (WebElement defaultSuggestion : allAutoSuggestion)
		{
			System.out.println(defaultSuggestion.getText());
		}
		driver.quit();
	}
}
























