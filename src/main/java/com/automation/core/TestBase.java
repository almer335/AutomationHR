package com.automation.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@ContextConfiguration( classes = {SpringConfiguration.class})
public class TestBase extends AbstractTestNGSpringContextTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);

    @Autowired
    protected Environment environment;

    @Parameters({"customParams"})
    @BeforeSuite(alwaysRun = true)
    public void setUpSuite(@Optional("") String customParams) throws Exception {
        System.setProperty("customParams", customParams);
        super.springTestContextPrepareTestInstance();
    }

    @BeforeMethod(alwaysRun = true)
    protected void logStartTest() {
        LOGGER.info("TEST-START.");
    }

    @AfterMethod(alwaysRun = true)
    protected void logEndTest(){
        LOGGER.info("TEST-END.");
    }

}
