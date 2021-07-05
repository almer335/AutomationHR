package com.automation.core;

import com.automation.pages.MulesoftSiteMap;
import com.automation.webdriver.ExtendedWebDriver;
import com.automation.webdriver.WebDriverBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;


public class TestBaseFrontEnd extends TestBase {

    protected ExtendedWebDriver driver;

    protected MulesoftSiteMap mulesoftSiteMap;

    private static final Logger logger = LoggerFactory.getLogger(TestBaseFrontEnd.class);

    @Parameters({"environment"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("prod") String environment) {
        driver = new ExtendedWebDriver(new WebDriverBuilder(this.environment).build());
        mulesoftSiteMap = new MulesoftSiteMap(driver, this.environment);
        logger.info("Setup done.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        driver.closeDriver();
        logger.info("Driver closed");
    }

}


