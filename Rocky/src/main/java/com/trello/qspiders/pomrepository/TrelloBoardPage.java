package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardPage 
{
	WebDriver driver;
	public TrelloBoardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@aria-label='Show menu']/span")
	private WebElement MenuInUserCreatedBoardsPage;
	
	@FindBy(xpath = "//div[@title='Aj']")
	private WebElement WorkingBoardCalledAj;
	
	public WebElement getWorkingBoardCalledAj() {
		return WorkingBoardCalledAj;
	}
	@FindBy(xpath ="//a[@class='board-menu-navigation-item-link js-open-more']")
	private WebElement MoreOpetionsInMenu;
	
	@FindBy(xpath = "//a[contains(.,'Close board…')]")
	private WebElement CloseBoardInMenu;
	
	@FindBy(xpath = "//input[@value='Close']")
	private WebElement CloseButton;
	
	@FindBy(xpath = "//button[text()='Permanently delete board']")
	private WebElement PermanentlyDeleteBoard;
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement DeleteBoard;
	
	public WebElement getMenuInUserCreatedBoardsPage() {
		return MenuInUserCreatedBoardsPage;
	}

	public WebElement getMoreOpetionsInMenu() {
		return MoreOpetionsInMenu;
	}

	public WebElement getCloseBoardInMenu() {
		return CloseBoardInMenu;
	}

	public WebElement getCloseButton() {
		return CloseButton;
	}

	public WebElement getPermanentlyDeleteBoard() {
		return PermanentlyDeleteBoard;
	}

	public WebElement getDeleteBoard() {
		return DeleteBoard;
	}
}
