package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInToContinuePage {
	WebDriver driver;
	public LogInToContinuePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id ="password" )
	private WebElement PWDtextfield;
	public WebElement getPWDtextfield() {
		return PWDtextfield;
	}
	@FindBy(id ="login-submit" )
	private WebElement PWDLoginButton;
	public WebElement getPWDLoginButton() {
		return PWDLoginButton;
	}
}
