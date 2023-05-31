package com.trello.qspiders.trelloendtoend;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.trello.qspiders.genericutility.BaseClass;
import com.trello.qspiders.pomrepository.ConformLogout;
import com.trello.qspiders.pomrepository.CreateNewBoard;
import com.trello.qspiders.pomrepository.LogInToContinuePage;
import com.trello.qspiders.pomrepository.LogIntoTrelloPage;
import com.trello.qspiders.pomrepository.TrelloBoardPage;
import com.trello.qspiders.pomrepository.TrelloHomePage;

public class TrelloEndToEnd extends BaseClass
{
	@Test(priority = 1)
	public void TrelloHomePage()
	{
		webdriverUtiles.implicitlyWait(driver);
		TrelloHomePage homepage = new TrelloHomePage(driver);
		homepage.getLoginOption().click();
	}
	@Test(priority = 2)
	public void LoginPage() throws Throwable
	{
		webdriverUtiles.implicitlyWait(driver);
		LogIntoTrelloPage loginpage = new LogIntoTrelloPage(driver);
		loginpage.getUNtextfield().sendKeys(fileUtils.readDataFromPropertyFile("username"));
		Thread.sleep(2000);
		loginpage.getLoginButton().submit();	
	}
	@Test(priority = 3)
	public void continuetoLoginPage() throws Throwable
	{
		webdriverUtiles.implicitlyWait(driver);
		LogInToContinuePage continuelogin = new LogInToContinuePage(driver);
		webdriverUtiles.elementVisibilityByLocator(driver, "password");
		continuelogin.getPWDtextfield().sendKeys(fileUtils.readDataFromPropertyFile("password"));
		Thread.sleep(2000);
		continuelogin.getPWDLoginButton().submit();
	}
	@Test
	public void UserCreatedBoardPage()
	{
		webdriverUtiles.implicitlyWait(driver);
		TrelloBoardPage boardspage = new TrelloBoardPage(driver);
		boardspage.getWorkingBoardCalledAj().click();
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
	@Test(enabled = false)
	public void boardspage() throws IOException, Throwable 
	{
		webdriverUtiles.implicitlyWait(driver);
		Thread.sleep(15000);
		CreateNewBoard newBoard = new CreateNewBoard(driver);
		newBoard.getNewBoard().click();
		newBoard.getnewBoardTextField().sendKeys(fileUtils.readDataFromPropertyFile("title"));
		Thread.sleep(2000);
		newBoard.getCreateButtonInCreateNewBoard().click();
		TrelloBoardPage boardspage = new TrelloBoardPage(driver);
		boardspage.getMenuInUserCreatedBoardsPage().click();
		boardspage.getMoreOpetionsInMenu().click();
		boardspage.getCloseBoardInMenu().click();
		boardspage.getCloseButton().click();
		Thread.sleep(2000);
		boardspage.getPermanentlyDeleteBoard().click();
		boardspage.getDeleteBoard().click();
		
	}
}
