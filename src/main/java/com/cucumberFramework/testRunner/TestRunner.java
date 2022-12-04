package com.cucumberFramework.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src\\test\\resources\\features\\login\\login.feature"}, glue = { "com/cucumberFramework/stepdefinitions" }, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = false, dryRun = false, publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
