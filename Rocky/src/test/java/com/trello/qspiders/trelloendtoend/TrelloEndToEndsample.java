package com.trello.qspiders.trelloendtoend;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.trello.qspiders.genericutility.BaseClass;
import com.trello.qspiders.pomrepository.ConformLogout;
import com.trello.qspiders.pomrepository.CreateNewBoard;
import com.trello.qspiders.pomrepository.LogInToContinuePage;
import com.trello.qspiders.pomrepository.LogIntoTrelloPage;
import com.trello.qspiders.pomrepository.TrelloBoardPage;
import com.trello.qspiders.pomrepository.TrelloHomePage;

public class TrelloEndToEndsample extends BaseClass
{	
	@Test
	public void CreateAndDeleteTrelloBoard() throws IOException,Throwable 
	{
		webdriverUtiles.implicitlyWait(driver);
		TrelloHomePage homepage = new TrelloHomePage(driver);
		homepage.getLoginOption().click();
		TrelloBoardPage boardspage = new TrelloBoardPage(driver);
		LogIntoTrelloPage loginpage = new LogIntoTrelloPage(driver);
		loginpage.getUNtextfield().sendKeys(fileUtils.readDataFromPropertyFile("username"));
		Thread.sleep(2000);
		loginpage.getLoginButton().submit();
		LogInToContinuePage continuelogin = new LogInToContinuePage(driver);
		webdriverUtiles.elementVisibilityByLocator(driver, "password");
		Thread.sleep(5000);
		continuelogin.getPWDtextfield().sendKeys(fileUtils.readDataFromPropertyFile("password"));
		Thread.sleep(2000);
		continuelogin.getPWDLoginButton().submit();
		CreateNewBoard newBoard = new CreateNewBoard(driver);
		newBoard.getNewBoard().click();
		newBoard.getnewBoardTextField().sendKeys(fileUtils.readDataFromPropertyFile("title"));
		Thread.sleep(2000);
		newBoard.getCreateButtonInCreateNewBoard().click();
		Thread.sleep(5000);
		boardspage.getMenuInUserCreatedBoardsPage().click();
		boardspage.getMoreOpetionsInMenu().click();
		boardspage.getCloseBoardInMenu().click();
		boardspage.getCloseButton().click();
		Thread.sleep(2000);
		boardspage.getPermanentlyDeleteBoard().click();
		boardspage.getDeleteBoard().click();
		ConformLogout conformLogOut = new ConformLogout(driver);
		conformLogOut.getprofilButton().click();
		conformLogOut.getLogoutButton().click();
		Thread.sleep(2000);
		conformLogOut.getConfromLogoutButton().submit();
	}
	 public void handlingActiveElements() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://trello.com/");
		//identify the email Text Field.
		// it is an active element
		driver.switchTo().activeElement().sendKeys("peoplefortiptur@gmail.com");
		}
	

}
