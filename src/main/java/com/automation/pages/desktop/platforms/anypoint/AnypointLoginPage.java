package com.automation.pages.desktop.platforms.anypoint;

import com.automation.pages.common.Login;
import com.automation.pages.common.Page;
import com.automation.webdriver.ExtendedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.env.Environment;

import java.util.List;

public class AnypointLoginPage extends Page {

    @FindBy(css = "input[data-test-id=SignIn-Username]")
    private WebElement userInput;

    @FindBy(css = "input[data-test-id=SignIn-Password]")
    private WebElement passwordInput;

    @FindBy(css = "button[data-test-id=SignIn-Submit]")
    private WebElement signinButton;

    @FindBy(css = "div[data-test-id=SignIn-ErrorMessage]")
    private WebElement errorMesage;

    @FindBy(css = "[data-test-id= SignIn-Forgot]")
    private WebElement forgotSignLink;


    private Login loginComponent;

    public AnypointLoginPage(ExtendedWebDriver webDriver, Environment environment) {
        super(webDriver, environment);
        this.loginComponent = new Login(this, this.userInput, this.passwordInput, this.signinButton);
    }

    public Login login (){
        loginComponent.refresh();
        return this.loginComponent;
    }

    public AnypointHomePage loginIntoAnypoinPlatform(String user, String password) {
        loginComponent.enterUser(user);
        loginComponent.enterPassword(password);
        loginComponent.signIn();
        sleep(A_LITTLE);
        return new AnypointHomePage(webDriver, environment);
    }

    public String getErrorMessage(){
        return this.errorMesage.getText();
    }

    public Boolean isErrorMessageDisplayed(){ return this.errorMesage.isDisplayed(); }

    public Boolean isRequiredTextDisplayedForInputUser() {
        List<WebElement> required = userInput.findElement(By.xpath("../..")).findElements(By.tagName("ul"));
        return required.size() > 0 && required.get(0).getText().equalsIgnoreCase("Required");
    }

    public Boolean isRequiredTextDisplayedForInputPassword() {
        List<WebElement> required = passwordInput.findElement(By.xpath("../..")).findElements(By.cssSelector("ul[class^=ErrorRenderer--error-list] li"));
        return required.size() > 0 && required.get(0).getText().equalsIgnoreCase("Required");
    }

    public String getPasswordFieldTypeValue() {
        return passwordInput.getAttribute("type");
    }

    public ForgotCredentialsPage clickForgotCredentials() {
        this.forgotSignLink.click();
        return new ForgotCredentialsPage(webDriver, environment);
    }

}
