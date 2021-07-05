package com.automation.pages.desktop.platforms.anypoint;

import com.automation.pages.common.Page;
import com.automation.webdriver.ExtendedWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.env.Environment;

public class ForgotCredentialsPage extends Page {

    @FindBy(css = "input[name=credentials]")
    private WebElement emailInput;

    @FindBy(css = "button[data-anypoint-component=button]")
    private WebElement requestCredentialsButton;

    protected ForgotCredentialsPage(ExtendedWebDriver webDriver, Environment environment) {
        super(webDriver, environment);
    }

    public Boolean isEmailInputDisplayed(){
        return  emailInput.isDisplayed() && emailInput.isEnabled();
    }


}
