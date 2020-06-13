package com.Vtiger.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login 
{
	@FindBy(name = "user_name")
	private WebElement userNameTF;
	
	@FindBy(name = "user_password")
	private WebElement passwordTF;
	
	@FindBy(id = "submitButton")
	private WebElement submitButton;
	
	
	//getter methods
	public WebElement getUserName()
	{
		return userNameTF;
	}
	
	public WebElement getUserPassword()
	{
		return passwordTF;
	}
	
	public WebElement getSubmitButton()
	{
		return submitButton;
	}
	
	//Business logic
	public void login(String userName, String password)
	{
		userNameTF.sendKeys(userName);
		passwordTF.sendKeys(password);
		submitButton.click();
	}
	
}
