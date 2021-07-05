package com.automation.pages;

import com.automation.pages.desktop.HomePage;
import com.automation.pages.desktop.platforms.anypoint.AnypointDownloadPage;
import com.automation.webdriver.ExtendedWebDriver;
import org.springframework.core.env.Environment;


public class MulesoftSiteMap {

    private final ExtendedWebDriver extendedWebDriver;

    private Environment environment;

    public MulesoftSiteMap(ExtendedWebDriver extendedWebDriver, Environment environment) {
        this.extendedWebDriver = extendedWebDriver;
        this.environment = environment;
    }

    public HomePage homePage(){
        extendedWebDriver.get(environment.getProperty("site.endpoint"));
        return new HomePage(extendedWebDriver,environment);
    }

    public AnypointDownloadPage anypointDownloadPage() {
        extendedWebDriver.get(environment.getProperty("anypoint.studio.download.site.endpoint"));
        return new AnypointDownloadPage(extendedWebDriver,environment);
    }

}
