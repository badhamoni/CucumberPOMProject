package com.cucumberFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.stepdefinitions.helper.WaitHelper;

public class LoginPage {

	private WebDriver driver;

	@FindBy(xpath="//a[contains(@href,'UserLogin')]")
	public WebElement loginAsUserButton;
	@FindBy(xpath="//input[@name='username']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;

	@FindBy(xpath="//input[contains(@value,'LOGIN AS USER')]")
	WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'tab hd brown')]")
	WebElement loginMessage;
	
	WaitHelper waitHelper;

	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	
	public void enterUserName(String userName){
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword(String password){
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton(){
		loginButton.click();
	}

	public void loginAsUser(){
		loginAsUserButton.click();
	}

	public String getLoginMessage(){
		return loginMessage.getText();
	}

}
