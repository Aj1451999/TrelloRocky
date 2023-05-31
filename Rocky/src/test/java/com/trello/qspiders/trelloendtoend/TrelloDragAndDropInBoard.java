package com.trello.qspiders.trelloendtoend;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.trello.qspiders.genericutility.BaseClass;

public class TrelloDragAndDropInBoard extends BaseClass
{
	@Test
	public void DragandDrop() throws Throwable
	{
		Actions actions = new Actions(driver);
		List<WebElement> location = driver.findElements(By.xpath("//div[@class=\"list-card-details js-card-details\"]"));
		WebElement Destination = driver.findElement(By.xpath("//h2[text()='Selenium']/../..//div[@class=\"list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable\"]"));
		for (WebElement cards : location)
		{
			actions.dragAndDrop(cards, Destination);
			Thread.sleep(5000);
			
		}
	}

}
