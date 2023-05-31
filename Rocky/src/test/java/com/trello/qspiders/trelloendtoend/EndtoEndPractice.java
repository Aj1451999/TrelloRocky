package com.trello.qspiders.trelloendtoend;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trello.qspiders.genericutility.BaseClass;
import com.trello.qspiders.pomrepository.ConformLogout;
import com.trello.qspiders.pomrepository.LogInToContinuePage;
import com.trello.qspiders.pomrepository.LogIntoTrelloPage;
import com.trello.qspiders.pomrepository.TrelloBoardPage;
import com.trello.qspiders.pomrepository.TrelloHomePage;

public class EndtoEndPractice extends BaseClass 
{
	@BeforeMethod
	public void starting() throws IOException, Throwable 
	{
	webdriverUtiles.implicitlyWait(driver);
	TrelloHomePage homepage = new TrelloHomePage(driver);
	homepage.getLoginOption().click();
	LogIntoTrelloPage loginpage = new LogIntoTrelloPage(driver);
	loginpage.getUNtextfield().sendKeys(fileUtils.readDataFromPropertyFile("username"));
	Thread.sleep(2000);
	loginpage.getLoginButton().submit();
	LogInToContinuePage continuelogin = new LogInToContinuePage(driver);
	webdriverUtiles.elementVisibilityByLocator(driver, "password");
	Thread.sleep(2000);
	continuelogin.getPWDtextfield().sendKeys(fileUtils.readDataFromPropertyFile("password"));
	Thread.sleep(2000);
	continuelogin.getPWDLoginButton().submit();
	}
	@Test
	public void UserCreatedBoardPage() throws Throwable
	{
		webdriverUtiles.implicitlyWait(driver);
		TrelloBoardPage boardspage = new TrelloBoardPage(driver);
		boardspage.getWorkingBoardCalledAj().click();
		Thread.sleep(5000);

		Actions actions = new Actions(driver);
		List<WebElement> AllCardList = driver.findElements(By.xpath("//div[@class=\"list-card-details js-card-details\"]"));
		List<WebElement> AllCardTitle = driver.findElements(By.xpath("//div[@class='list-card-details js-card-details']/span[@class='list-card-title js-card-name']"));
		WebElement Destination = driver.findElement(By.xpath("//h2[text()='Selenium']/../..//div[@class='list-cards u-fancy-scrollbar js-list-cards js-sortable ui-sortable']"));
		WebElement Destination2 = driver.findElement(By.xpath("//h2[text()='Java']/../..//div[@class=\"list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable\"]"));
		for (WebElement cards:AllCardTitle)
		{
			if(cards.getText().contains("Selenium"))
			{
			actions.dragAndDrop(cards,Destination).perform();
			actions.pause(1000);
			}
			else if (cards.getText().contains("Java"))
			{
				actions.dragAndDrop(cards,Destination2).perform();
				actions.pause(1000);
			}
		}
	}
	@AfterMethod
	public void conformLogoutPage() throws Throwable
	{
		webdriverUtiles.implicitlyWait(driver);
		ConformLogout conformLogOut = new ConformLogout(driver);
		conformLogOut.getprofilButton().click();
		conformLogOut.getLogoutButton().click();
		Thread.sleep(2000);
		conformLogOut.getConfromLogoutButton().submit();
	}
}
