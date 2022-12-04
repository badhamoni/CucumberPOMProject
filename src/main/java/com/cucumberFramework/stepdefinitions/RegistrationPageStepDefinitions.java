package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.stepdefinitions.helper.WaitHelper;
import com.cucumberFramework.pageObjects.RegistrationPage;
import com.cucumberFramework.testBase.TestBase;
import com.cucumberFramework.utils.CredentialsPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Properties;

public class RegistrationPageStepDefinitions extends TestBase {

	WaitHelper waitHelper = new WaitHelper(driver);
	Response response;
	Properties prop = getProperties();
	CredentialsPojo creds;
	String country_id = "US";
	RegistrationPage registrationPage = new RegistrationPage(driver);

	@Then("I click on New User! Register Here button and wait for Registration page")
	public void i_click_on_new_user_register_here_button_and_wait_for_registration_page() {
		registrationPage.clickOnRegistration();
		waitHelper.WaitForElement(registrationPage.userName, 60);
	}

	@Then("I should see Registration Page")
	public void i_should_see_registration_page() {
		Assert.assertEquals(registrationPage.getRegisterHereText(), "Register Here");
	}

	@Then("^Enter person username")
	public void i_enter_username_as() throws Throwable {
		String randomUsername = generateRandomUsername();
		creds = new CredentialsPojo();
		creds.setUserName(randomUsername);
		registrationPage.enterUserName(randomUsername);
	}

	@Then("^Enter user password")
	public void enter_user_password() throws Throwable {
		registrationPage.enterPassword("123456");
	}

	@Then("I enter First Name")
	public void i_enter_first_name() {
		registrationPage.enterFirstName("jhon12");
	}

	@Then("I enter Last Name")
	public void i_enter_last_name() throws InterruptedException{
		Thread.sleep(5000);
		registrationPage.enterLastName("12345");
	}

	@Then("I enter Address")
	public void i_enter_address() {
		registrationPage.enterAddress("HN0 123 Street");
	}

	@Then("I enter Phone No")
	public void i_enter_phone_no() {
		registrationPage.enterPhoneNo("1234567890");
	}

	@Then("I enter Email Id")
	public void i_enter_email_id() {
		registrationPage.enterEmailID("test@gmail.com");
	}

	@When("I click on I AGREE FOR ALL TERMS & CONDITIONS! REGISTER ME")
	public void i_click_on_i_agree_for_all_terms_conditions_register_me() throws InterruptedException {
		registrationPage.clickOnAgreeAndSubmit();
		Thread.sleep(5000);
	}

	@Then("I should verify whether registration is successful or not")
	public void i_should_verify_whether_registration_is_successful_or_not() {
		Assert.assertEquals(registrationPage.getRegistrationMsg(), "User Registered Successfully");
	}

	@Given("I perform GET operation on URL with {string} values")
	public void i_perform_get_operation_on_url_with_values(String param) {
		response = RestAssured.get("https://api.nationalize.io/?"+param);
		System.out.println(response);
	}
	@Then("User should validate the response")
	public void user_should_validate_the_response() {
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Then("verify the country name string in the response body")
	public void verify_the_country_name_string_in_the_response_body() {
		JsonPath jsonPath = response.jsonPath();
		String country = jsonPath.getString("country[1].country_id");
		Assert.assertEquals(country, country_id);
	}

}