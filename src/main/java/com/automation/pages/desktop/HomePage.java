package com.automation.pages.desktop;

import com.automation.pages.common.Page;
import com.automation.pages.desktop.platforms.anypoint.AnypointLoginPage;
import com.automation.support.PlatformsOptions;
import com.automation.webdriver.ExtendedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.env.Environment;

import java.util.List;

public class HomePage extends Page {

    @FindBy(css = "header[class='ms-com-header desktop-header']")
    private WebElement header;

    @FindBy(css = ".menu-item.flyout-right")
    private WebElement login;

    @FindBy(id = "header-nav-search-form")
    private WebElement searchForm;

    public HomePage(ExtendedWebDriver webDriver, Environment environment) {
        super(webDriver, environment);
        closeCookiesAlertIfItsPresent();
    }

    private void openLoginOptions(){
        login.click();
    }

    private List<WebElement> getLoginOptions(){
        return login.findElements(By.cssSelector("nav[class=menu] a"));
    }

    public Boolean isAnyLoginPlatformVisible(){
        openLoginOptions();
        return getLoginOptions().stream().findAny().get().isDisplayed();
    }

    private WebElement getLoginOptionWebElement(PlatformsOptions platform) {
         return getLoginOptions().stream().filter(x->
                x.getText().equalsIgnoreCase(platform.getValue())).
                findFirst().get();
    }

    public Boolean isLoginAvailableByPlatform(PlatformsOptions platform){
        openLoginOptions();
        return getLoginOptionWebElement(platform).isDisplayed();
    }

    private void clickLoginOptionByPlatform(PlatformsOptions platform){
        openLoginOptions();
        getLoginOptionWebElement(platform).click();
    }

    public AnypointLoginPage clickAnypointPlatformLogin(){
        clickLoginOptionByPlatform(PlatformsOptions.ANYPOINT);
        return new AnypointLoginPage(this.webDriver, this.environment);
    }

    public Boolean isHeaderDisplayed() {
        return this.header.isDisplayed();
    }

    private WebElement getLogo() {
        return this.header.findElement(By.cssSelector("a[class=logo]"));
    }

    public Boolean isMulesoftLogoDisplayed() {
        return getLogo().isDisplayed();
    }

    public Boolean logoHasCorrectHref() {
        return getLogo().getAttribute("href").equalsIgnoreCase(environment.getProperty("site.endpoint"));
    }

    public ResultsPage lookForResults(String keyword) {
        this.searchForm.click();
        this.searchForm.findElement(By.cssSelector("input[type=text]")).sendKeys(keyword);
        this.searchForm.findElement(By.cssSelector("input[type=text]")).submit();
        return new ResultsPage(webDriver,environment);
    }
}
