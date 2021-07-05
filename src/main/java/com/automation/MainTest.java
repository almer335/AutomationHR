package com.automation;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class MainTest {

	private WebDriver driver;

	@Before
	public void beforeTest() {
		driver = new WebDriverHelper().generateWebDriver();
	}

	@After
	public void afterTest() {
		driver.quit();
	}
}
