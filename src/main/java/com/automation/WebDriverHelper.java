package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverHelper {

	private static final String VERSION = "91.0.4472.114"; // Change accordingly
	ChromeOptions options;
	
	public WebDriver generateWebDriver(){
		WebDriverManager.chromedriver().version(VERSION).setup();
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		return new ChromeDriver(options);
	}

}
