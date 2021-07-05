package com.automation.frontend.desktop;

import com.automation.core.TestBaseFrontEnd;
import com.automation.pages.desktop.HomePage;
import com.automation.support.PlatformsOptions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomeTest extends TestBaseFrontEnd {

    @Test(groups = {"frontend", "home"})
    public void isHeaderDisplayed() {
        HomePage homePage = mulesoftSiteMap.homePage();
        assertTrue(homePage.isHeaderDisplayed());
    }

    @Test(groups = {"frontend", "home"})
    public void isLogoDisplayed() {
        HomePage homePage = mulesoftSiteMap.homePage();
        assertTrue(homePage.isMulesoftLogoDisplayed());
    }

    @Test(groups = {"frontend", "home"})
    public void hasTheLogoTheCorrectHref() {
        HomePage homePage = mulesoftSiteMap.homePage();
        assertTrue(homePage.logoHasCorrectHref());
    }

    @Test(groups = {"frontend", "home", "login", "loginOptions"})
    public void thereAreLoginOptionsDisplayed() {
        HomePage homePage = mulesoftSiteMap.homePage();
        assertTrue(homePage.isAnyLoginPlatformVisible());
    }

    @Test(groups = {"frontend", "home", "login", "loginOptions"})
    public void isAnypointPlatformLoginDisplayed() {
        HomePage homePage = mulesoftSiteMap.homePage();
        assertTrue(homePage.isLoginAvailableByPlatform(PlatformsOptions.ANYPOINT));
    }

    @Test(groups = {"frontend", "home", "login", "loginOptions"})
    public void isTrainingLoginDisplayed() {
        HomePage homePage = mulesoftSiteMap.homePage();
        assertTrue(homePage.isLoginAvailableByPlatform(PlatformsOptions.TRAINING));
    }

    @Test(groups = {"frontend", "home", "login", "loginOptions"})
    public void isHelpCenterPlatformLoginDisplayed() {
        HomePage homePage = mulesoftSiteMap.homePage();
        assertTrue(homePage.isLoginAvailableByPlatform(PlatformsOptions.HELPCENTER));
    }

}