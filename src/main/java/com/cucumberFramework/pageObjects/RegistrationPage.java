package com.cucumberFramework.pageObjects;

import com.cucumberFramework.stepdefinitions.helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	@FindBy(xpath = "//a[text()='New user ! Register Here']")
	public WebElement registrationButton;

	@FindBy(xpath = "//td[text()='Register Here']")
	public WebElement registerHereText;
	@FindBy(xpath = "//input[@name='username']")
	public WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	@FindBy(xpath = "//input[@name='lastname']")
	public WebElement lastname;
	@FindBy(xpath = "//input[@name='address']")
	public WebElement address;
	@FindBy(xpath = "//input[@name='firstname']")
	public WebElement firstname;
	@FindBy(xpath = "//input[@name='phone']")
	public WebElement phoneNo;
	@FindBy(xpath = "//input[@name='mailid']")
	public WebElement mailid;
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement iAgreeButton;
	@FindBy(xpath = "//div[@id='topmid']/following-sibling::h3")
	public WebElement registrationSuccessMsg;

	@FindBy(xpath = "//a[text()='Login']")
	public WebElement loginButton;
	WaitHelper waitHelper;
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public void clickOnRegistration() {
		registrationButton.click();
	}

	public String getRegisterHereText() {
		return registerHereText.getText();
	}

	public void enterUserName(String userName) {
		this.userName.sendKeys(userName);
	}

	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	public void enterFirstName(String firstname) {
		this.firstname.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		this.lastname.sendKeys(lastname);
	}

	public void enterAddress(String address) {
		this.address.sendKeys(address);
	}

	public void enterPhoneNo(String phoneNo) {
		this.phoneNo.sendKeys(phoneNo);
	}

	public void enterEmailID(String emailID) {
		this.mailid.sendKeys(emailID);
	}

	public void clickOnAgreeAndSubmit() {
		iAgreeButton.click();
	}

	public String getRegistrationMsg() {
		return registrationSuccessMsg.getText();
	}
}
