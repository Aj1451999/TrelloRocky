package com.trello.qspiders.datadriventesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DataMining {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.facebook.com/signup");
			List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
			System.out.println(allDropDowns.size());
			driver.manage().window().minimize();
			
			driver.quit();
			
		
	}

}
