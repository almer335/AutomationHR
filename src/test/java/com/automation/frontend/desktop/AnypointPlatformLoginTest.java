package com.automation.frontend.desktop;

import com.automation.core.TestBaseFrontEnd;
import com.automation.helpers.LoginHelper;
import com.automation.pages.desktop.HomePage;
import com.automation.pages.desktop.platforms.anypoint.AnypointHomePage;
import com.automation.pages.desktop.platforms.anypoint.AnypointLoginPage;
import com.automation.pages.desktop.platforms.anypoint.ForgotCredentialsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AnypointPlatformLoginTest extends TestBaseFrontEnd {

    @Autowired
    LoginHelper loginHelper;

    @Test(groups = {"frontend", "anypointPlatfom", "login"})
    public void errorMessageIsDisplayedWhenLoginWithInvalidCredentials() {
        HomePage homePage = mulesoftSiteMap.homePage();
        AnypointLoginPage loginPage = homePage.clickAnypointPlatformLogin();
        loginPage.loginIntoAnypoinPlatform("zaraza", "zaraza");
        assertTrue(loginPage.isErrorMessageDisplayed());
        assertEquals(loginPage.getErrorMessage(), loginHelper.getAnypoinErrorLoginMessage());
    }

    @Test(groups = {"frontend", "anypointPlatfom", "login"})
    public void userFieldShowRequiredMessageWhenUserDoNoPutUsername() {
        HomePage homePage = mulesoftSiteMap.homePage();
        AnypointLoginPage loginPage = homePage.clickAnypointPlatformLogin();
        loginPage.loginIntoAnypoinPlatform("", loginHelper.getAnypointUserPassword());
        assertTrue(loginPage.isRequiredTextDisplayedForInputUser());
    }

    @Test(groups = {"frontend", "anypointPlatfom", "login"})
    public void passwordFieldShowRequiredMessageWhenUserDoNoPutPassword() {
        HomePage homePage = mulesoftSiteMap.homePage();
        AnypointLoginPage loginPage = homePage.clickAnypointPlatformLogin();
        loginPage.loginIntoAnypoinPlatform(loginHelper.getAnypointUserName(), "");
        assertTrue(loginPage.isRequiredTextDisplayedForInputPassword());
    }

    @Test(groups = {"frontend", "anypointPlatfom", "login"})
    public void thePasswordFieldIsHidingTheCharacters() {
        HomePage homePage = mulesoftSiteMap.homePage();
        AnypointLoginPage loginPage = homePage.clickAnypointPlatformLogin();
        loginPage.login().enterPassword(loginHelper.getAnypointUserPassword());
        assertEquals(loginPage.getPasswordFieldTypeValue(), "password");
    }

    @Test(groups = {"frontend", "anypointPlatfom", "login"})
    public void passwordAndUsernameAreRequiredFieldsForLogin() {
        HomePage homePage = mulesoftSiteMap.homePage();
        AnypointLoginPage loginPage = homePage.clickAnypointPlatformLogin();
        loginPage.loginIntoAnypoinPlatform("", "");
        assertTrue(loginPage.isRequiredTextDisplayedForInputUser());
        assertTrue(loginPage.isRequiredTextDisplayedForInputPassword());
    }

    @Test(groups = {"frontend", "anypointPlatfom", "login"})
    public void usernameInputDoesNotAllowsBlankSpace() {
        HomePage homePage = mulesoftSiteMap.homePage();
        AnypointLoginPage loginPage = homePage.clickAnypointPlatformLogin();
        loginPage.loginIntoAnypoinPlatform(" ", loginHelper.getAnypointUserPassword());
        assertTrue(loginPage.isRequiredTextDisplayedForInputUser());
        assertEquals(loginPage.getErrorMessage(), loginHelper.getAnypoinErrorLoginMessage());
    }

    @Test(groups = {"frontend", "anypointPlatfom", "login"})
    public void forgotCredentialLinkGoesToRequestCredentialPageAndShowEmailInput() {
        HomePage homePage = mulesoftSiteMap.homePage();
        AnypointLoginPage loginPage = homePage.clickAnypointPlatformLogin();
        ForgotCredentialsPage forgotCredentialsPage = loginPage.clickForgotCredentials();
        assertEquals(forgotCredentialsPage.url(), loginHelper.getAnypointForgotSignUrl());
        assertTrue(forgotCredentialsPage.isEmailInputDisplayed());
    }

    @Test(groups = {"frontend", "anypointPlatfom", "login"})
    public void isPossibleLoginWithValidUser() {
        HomePage homePage = mulesoftSiteMap.homePage();
        AnypointLoginPage loginPage = homePage.clickAnypointPlatformLogin();
        AnypointHomePage anypointHomePage = loginPage.loginIntoAnypoinPlatform(loginHelper.getAnypointUserName(), loginHelper.getAnypointUserPassword());
        assertTrue(anypointHomePage.url().startsWith(loginHelper.getAnypointPlatformHomeUrl()));
    }

}
