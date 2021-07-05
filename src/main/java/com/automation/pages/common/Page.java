package com.automation.pages.common;

import com.automation.helpers.CommonHelper;
import com.automation.webdriver.ExtendedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

public class Page extends CommonHelper {

    private static final int TIMEOUT_FOR_DOCUMENT_READY = 40;

    protected ExtendedWebDriver webDriver;

    protected Environment environment;

    private static final Logger LOGGER = LoggerFactory.getLogger(Page.class);

    protected Page(ExtendedWebDriver webDriver, Environment environment) {
        this.webDriver = webDriver;
        this.environment = environment;
        PageFactory.initElements(webDriver, this);
        waitUntilDocumentReadyStateIsComplete();
    }

    public String url() {
        return webDriver.getCurrentUrl();
    }

    protected void waitUntilDocumentReadyStateIsComplete() {
        try{
        webDriver.waitUntil(TIMEOUT_FOR_DOCUMENT_READY, wd -> webDriver.executeScript("return document.readyState").equals("complete"));
        }catch (TimeoutException e) {
            throw new IllegalArgumentException("The Document it's No Ready Yet ");
        }
    }

    protected void closeCookiesAlertIfItsPresent(){
        try{
            webDriver.findElement(By.id("onetrust-accept-btn-handler")).click();
            sleep(A_LITTLE);
        }
        catch (NoSuchElementException e){
            LOGGER.warn("Cookie its no Present");
        }
    }
}
