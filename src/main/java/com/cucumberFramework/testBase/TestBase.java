package com.cucumberFramework.testBase;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumberFramework.enums.Browsers;
import com.cucumberFramework.enums.OS;
import com.cucumberFramework.utils.TestUtitlities;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase extends TestUtitlities{

	public static WebDriver driver;
	FileInputStream fs = null;
	Properties prop = null;

	public Properties getProperties() {
		try {
			File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
			fs = new FileInputStream(file);
			prop = new Properties();
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException fe) {
			fe.printStackTrace();
		}

		return prop;
	}

	public WebDriver selectBrowser(String browser) {
		WebDriver delegate;
		if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				WebDriverManager.chromedriver().setup();
				delegate = new ChromeDriver();
				driver = SelfHealingDriver.create(delegate);
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				WebDriverManager.firefoxdriver().setup();
				delegate = new FirefoxDriver();
				driver = SelfHealingDriver.create(delegate);
				driver.manage().window().maximize();
			}
		} else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				WebDriverManager.chromedriver().setup();
				delegate = new ChromeDriver();
				driver = SelfHealingDriver.create(delegate);
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				WebDriverManager.firefoxdriver().setup();
				delegate = new FirefoxDriver();
				driver = SelfHealingDriver.create(delegate);
			}

		}
		return driver;
	}
}
