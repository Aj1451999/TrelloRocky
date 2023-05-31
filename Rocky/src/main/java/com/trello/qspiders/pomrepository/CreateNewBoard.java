package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewBoard {
WebDriver driver;
public CreateNewBoard(WebDriver driver) 
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//div[@class='board-tile mod-add']")
private WebElement newBoard;
public WebElement getNewBoard() {
	return newBoard;
}
		@FindBy(xpath = "//div[text()='Board title']/following-sibling::input[@type='text']")
		private WebElement newBoardTextField;
		public WebElement getnewBoardTextField()
		{
			return newBoardTextField;
		}
		@FindBy(xpath = "//button[text()='Create']")
		private WebElement CreateButtonInCreateNewBoard;
		public WebElement getCreateButtonInCreateNewBoard()
		{
			return CreateButtonInCreateNewBoard;
		}
		
}



























