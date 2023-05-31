package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConformLogout 
{
	WebDriver driver;
	public ConformLogout(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@aria-label='Open member menu']")
	private WebElement profilButton;
	public WebElement getprofilButton()
	{
		return profilButton;
	}
	@FindBy(xpath = "//button[@data-testid='account-menu-logout']")
	private WebElement LogoutButton;
	public WebElement getLogoutButton()
	{
		return LogoutButton;
	}
	
	@FindBy(id = "logout-submit")
	private WebElement ConfromLogoutButton;
	public WebElement getConfromLogoutButton()
	{
		return ConfromLogoutButton;
	}
}
