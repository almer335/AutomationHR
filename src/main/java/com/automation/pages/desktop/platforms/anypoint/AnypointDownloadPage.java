package com.automation.pages.desktop.platforms.anypoint;

import com.automation.models.users.User;
import com.automation.pages.common.Page;
import com.automation.support.OS;
import com.automation.webdriver.ExtendedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.core.env.Environment;

public class AnypointDownloadPage extends Page {

    @FindBy(css = "form[id^=mktoForm_]")
    private WebElement downloadForm;

    @FindBy(css = "select[id=operatingSystem]")
    private WebElement operatingSystemSelect;

    @FindBy(css = "input[id=FirstName]")
    private WebElement firstNameInput;

    @FindBy(css = "input[id=LastName]")
    private WebElement lastNameInput;

    @FindBy(css = "input[id=Email]")
    private WebElement emailInput;

    @FindBy(css = "input[id=Company]")
    private WebElement companyInput;

    @FindBy(css = "input[id=Title]")
    private WebElement jobTitleInput;

    @FindBy(css = "input[id=Phone]")
    private WebElement phoneNumberInput;

    @FindBy(css = "input[id=Beta_License_Agreement__c]")
    private WebElement licenseAgreementCheckbox;

    @FindBy(css = "button[class=mktoButton]")
    private WebElement downloadButton;

    public AnypointDownloadPage(ExtendedWebDriver webDriver, Environment environment) {
        super(webDriver, environment);
        closeCookiesAlertIfItsPresent();
    }

    public Boolean isDownloadFormAvailable(){
        return downloadForm.isDisplayed() && downloadForm.isEnabled();
    }

    public void selectOS(OS os) {
        Select selectOS = new Select(operatingSystemSelect);
        selectOS.selectByValue(os.getOption());
    }

    public void setInfoUser(User user) {
        this.firstNameInput.sendKeys(user.getFirstName());
        this.lastNameInput.sendKeys(user.getLastName());
        this.emailInput.sendKeys(user.getEmail());
        this.companyInput.sendKeys(user.getCompany());
        this.jobTitleInput.sendKeys(user.getJobTitle());
        this.phoneNumberInput.sendKeys(user.getPhoneNumber());
    }

    public void setLicenseAgreement(Boolean value) {
        webDriver.forceClick(licenseAgreementCheckbox);
        Boolean isChecked = Boolean.valueOf(licenseAgreementCheckbox.findElement(By.xpath("..")).getAttribute("aria-invalid"));
        if(isChecked == value) {
            webDriver.forceClick(licenseAgreementCheckbox);
        }
    }

    public void clickDownloadButton() {
        this.downloadButton.click();
        sleep(A_LITTLE);
    }

}
