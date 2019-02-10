package com.testngsetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	WebDriver driver;
	String expectedURL = "https://www.amazon.com/";

	@BeforeClass
	public void runSetup() {
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println();

		String path = System.getProperty("user.dir");
		String winDriverPath = path + "\\Driver\\chromedriver.exe";

		String macDriverPath = path + "/Driver/chromedriver";

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", macDriverPath);
		} else {
			System.setProperty("webdriver.chrome.driver", winDriverPath);
		}

		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void getURL() {
		driver.navigate().to(expectedURL);
		String actualURL = driver.getCurrentUrl();
		System.out.println("URL Validation Test");
		System.out.println("\n Expected URL and Actual URL are the SAME. Validation passed!!!");
		try {
			Assert.assertEquals(expectedURL, actualURL);
		} catch (Exception e) {
			System.out.println("\n Expected URL and Actual URL are NOT the same. Validation failed!!!");
			System.out.println();
		}
	}

	@AfterTest
	public void segregateTestCases() {
		System.out.println("Testing is complete");
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
