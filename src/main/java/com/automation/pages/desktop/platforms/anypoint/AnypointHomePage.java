package com.automation.pages.desktop.platforms.anypoint;

import com.automation.pages.common.Page;
import com.automation.webdriver.ExtendedWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.env.Environment;

public class AnypointHomePage extends Page {

    @FindBy(css = "div[data-test-id=navbar-page-name]")
    private WebElement navBarPageName;

    public AnypointHomePage(ExtendedWebDriver webDriver, Environment environment) {
        super(webDriver, environment);
    }

    public Boolean navBarPageNameIsVisible() {
        return navBarPageName.isDisplayed();
    }

}
