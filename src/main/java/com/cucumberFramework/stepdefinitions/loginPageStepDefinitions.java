package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.pageObjects.LoginPage;

import com.cucumberFramework.stepdefinitions.helper.WaitHelper;
import com.cucumberFramework.testBase.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Properties;
import java.util.logging.Logger;

import org.testng.Assert;

public class loginPageStepDefinitions extends TestBase {

    LoginPage loginPage = new LoginPage(driver);

    WaitHelper waitHelper = new WaitHelper(driver);

    Properties prop = getProperties();

    @Given("^I am on the Login page URL")
    public void i_am_on_the_Login_page_URL() throws Throwable {
        driver.get(prop.getProperty("app_url"));
    }

    @Then("^I click on login as user button and wait for login page$")
    public void i_click_on_login_as_user_button_and_wait_for_login_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.loginAsUser();
        waitHelper.WaitForElement(loginPage.userName, 60);
    }

    @Then("^I should see login Page$")
    public void i_should_see_login_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(driver.getTitle(), "Book Store");
    }

    @When("^I enter username")
    public void i_enter_username_as() throws Throwable {
        loginPage.enterUserName(prop.getProperty("username"));
    }

    @When("^I enter password")
    public void i_enter_password_as() throws Throwable {
        loginPage.enterPassword(prop.getProperty("password"));
    }

    @When("^click on login button$")
    public void click_on_login_button() throws Throwable {
        loginPage.clickLoginButton();
    }

}