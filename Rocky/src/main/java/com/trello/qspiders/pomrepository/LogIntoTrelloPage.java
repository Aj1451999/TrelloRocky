package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIntoTrelloPage {
	WebDriver driver;
	public LogIntoTrelloPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "user")
	private WebElement UNtextfield;
	public WebElement getUNtextfield() {
		return UNtextfield;
	}
	@FindBy(id = "login")
	private WebElement LoginButton;
	public WebElement getLoginButton()
	{
		return LoginButton;
	}
}
