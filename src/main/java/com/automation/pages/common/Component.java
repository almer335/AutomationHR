package com.automation.pages.common;

import com.automation.helpers.CommonHelper;
import com.automation.webdriver.ExtendedWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.env.Environment;


public class Component extends CommonHelper {

    private final Page page;

    public Component(Page page) {
        this.page = page;
        refresh();
    }

    protected ExtendedWebDriver webDriver() {
        return page.webDriver;
    }

    protected Environment environment(){
        return page.environment;
    }

    protected final Wait<WebDriver> setWait(){
        return new WebDriverWait(page.webDriver, 10);
    }

    public void refresh(){
        PageFactory.initElements(page.webDriver, this);
    }

}
