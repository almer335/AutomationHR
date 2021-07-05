package com.automation.frontend.desktop;

import com.automation.core.TestBaseFrontEnd;
import com.automation.helpers.DownloadHelper;
import com.automation.pages.desktop.platforms.anypoint.AnypointDownloadPage;
import com.automation.support.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AnypointStudioDowloadTest extends TestBaseFrontEnd {

    @Autowired
    private DownloadHelper downloadHelper;

    @AfterTest()
    private void deleteFiles() {
        downloadHelper.deleteFiles();
    }

    @Test(groups = {"frontend", "anypoint", "anypointStudio", "anypointDownload"})
    public void isDownloadFormAvailable() {
        AnypointDownloadPage anypointDownloadPage = mulesoftSiteMap.anypointDownloadPage();
        assertTrue(anypointDownloadPage.isDownloadFormAvailable());
    }

    @Test(groups = {"frontend", "anypoint", "anypointStudio", "anypointDownload"}, dependsOnMethods = "isDownloadFormAvailable")
    public void isAnypointStudioDownloadAvaibleForWindows() {
        AnypointDownloadPage anypointDownloadPage = mulesoftSiteMap.anypointDownloadPage();
        anypointDownloadPage.selectOS(OS.WINDOWS);
        anypointDownloadPage.setInfoUser(downloadHelper.getUserByDefault());
        anypointDownloadPage.setLicenseAgreement(true);
        anypointDownloadPage.clickDownloadButton();
        assertTrue(downloadHelper.itsFileDownloadingForSpecificOS(OS.WINDOWS));
    }

    @Test(groups = {"frontend", "anypoint", "anypointStudio", "anypointDownload"}, dependsOnMethods = "isDownloadFormAvailable")
    public void isAnypointStudioDownloadAvaibleForLinux() {
        AnypointDownloadPage anypointDownloadPage = mulesoftSiteMap.anypointDownloadPage();
        anypointDownloadPage.selectOS(OS.LINUX);
        anypointDownloadPage.setInfoUser(downloadHelper.getUserByDefault());
        anypointDownloadPage.setLicenseAgreement(true);
        anypointDownloadPage.clickDownloadButton();
        assertTrue(downloadHelper.itsFileDownloadingForSpecificOS(OS.LINUX));
    }

    @Test(groups = {"frontend", "anypoint", "anypointStudio", "anypointDownload"})
    public void isAnypointStudioDownloadAvaibleForMac() {
        AnypointDownloadPage anypointDownloadPage = mulesoftSiteMap.anypointDownloadPage();
        anypointDownloadPage.selectOS(OS.MAC);
        anypointDownloadPage.setInfoUser(downloadHelper.getUserByDefault());
        anypointDownloadPage.setLicenseAgreement(true);
        anypointDownloadPage.clickDownloadButton();
        assertTrue(downloadHelper.itsFileDownloadingForSpecificOS(OS.MAC));
    }

}
