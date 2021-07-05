package com.automation.frontend.desktop;

import com.automation.core.TestBaseFrontEnd;
import com.automation.models.results.Results;
import com.automation.pages.desktop.ResultsPage;
import com.automation.support.SearchTab;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchResultTest extends TestBaseFrontEnd {

    @Value("${site.endpoint}")
    private String urlMulesoft;

    @Value("${docs.site.endpoint}")
    private String urlDocs;

    public static final String TERM_TRIAL = "trial", TERM_TRAINIGN = "training";

    @Test(groups = {"frontend", "results", "trial"})
    public void searchFunctionReturnResultsForTrialKeyword() {
        ResultsPage resultsPage = mulesoftSiteMap.homePage().lookForResults(TERM_TRIAL);
        List<Results> resultsList = resultsPage.resultsList().getResults();
        assertTrue(resultsList.size() > 0);
    }

    @Test(groups = {"frontend", "results", "training"})
    public void searchFunctionReturnResultsForTrainingKeyword() {
        ResultsPage resultsPage = mulesoftSiteMap.homePage().lookForResults(TERM_TRAINIGN);
        List<Results> resultsList = resultsPage.resultsList().getResults();
        assertTrue(resultsList.size() > 0);
    }

    @Test(groups = {"frontend", "results", "trial"})
    public void searchFunctionShowTrialKeywordInSearchTerm() {
        ResultsPage resultsPage = mulesoftSiteMap.homePage().lookForResults(TERM_TRIAL);
        assertTrue(resultsPage.isSearchTermDisplayed());
        assertEquals(resultsPage.getSearchTerm(), TERM_TRIAL);
    }

    @Test(groups = {"frontend", "results", "training"})
    public void searchFunctionShowTrainingKeywordInSearchTerm() {
        ResultsPage resultsPage = mulesoftSiteMap.homePage().lookForResults(TERM_TRAINIGN);
        assertTrue(resultsPage.isSearchTermDisplayed());
        assertEquals(resultsPage.getSearchTerm(), TERM_TRAINIGN);
    }

    @Test(groups = {"frontend", "results", "trial"})
    public void searchFunctionOnlyReturnUrlsfromMulesoftSiteInAllTabForTrialKeyword() {
        ResultsPage resultsPage = mulesoftSiteMap.homePage().lookForResults(TERM_TRIAL);
        List<Results> resultsList = resultsPage.resultsList().getResults();
        resultsList.forEach(x->{
            assertTrue(x.getResultUrl().startsWith(urlMulesoft), "Error on result: \"" + x.getResultTitle() + "\" has this url: " + x.getResultUrl());
            assertTrue(x.getResultTitleHref().startsWith(urlMulesoft), "Error on result: \"" + x.getResultTitle() + "\" has this hrf: " + x.getResultTitleHref());
        });
    }

    @Test(groups = {"frontend", "results", "training"})
    public void searchFunctionOnlyReturnUrlsfromMulesoftSiteInAllTabForTrainingKeyword() {
        ResultsPage resultsPage = mulesoftSiteMap.homePage().lookForResults(TERM_TRAINIGN);
        List<Results> resultsList = resultsPage.resultsList().getResults();
        resultsList.forEach(x->{
            assertTrue(x.getResultUrl().startsWith(urlMulesoft), "Error on result: \"" + x.getResultTitle() + "\" has this url: " + x.getResultUrl());
            assertTrue(x.getResultTitleHref().startsWith(urlMulesoft), "Error on result: \"" + x.getResultTitle() + "\" has this hrf: " + x.getResultTitleHref());
        });
    }

    @Test(groups = {"frontend", "results", "trial", "docs"})
    public void searchFunctionOnlyReturnUrlsfromDocsSiteInDocsTabForTrialKeyword() {
        ResultsPage resultsPage = mulesoftSiteMap.homePage().lookForResults(TERM_TRIAL);
        List<Results> resultsList = resultsPage.getResultsForSpecificTab(SearchTab.DOCS);
        resultsList.forEach(x->{
            assertTrue(x.getResultUrl().startsWith(urlDocs), "Error on result: \"" + x.getResultTitle() + "\" has this url: " + x.getResultUrl());
            assertTrue(x.getResultTitleHref().startsWith(urlDocs), "Error on result: \"" + x.getResultTitle() + "\" has this hrf: " + x.getResultTitleHref());
        });
    }

    @Test(groups = {"frontend", "results", "training", "docs"})
    public void searchFunctionOnlyReturnUrlsfromDocsSiteInDocsTabForTrainingKeyword() {
        ResultsPage resultsPage = mulesoftSiteMap.homePage().lookForResults(TERM_TRIAL);
        List<Results> resultsList = resultsPage.getResultsForSpecificTab(SearchTab.DOCS);
        resultsList.forEach(x->{
            assertTrue(x.getResultUrl().startsWith(urlDocs), "Error on result: \"" + x.getResultTitle() + "\" has this url: " + x.getResultUrl());
            assertTrue(x.getResultTitleHref().startsWith(urlDocs), "Error on result: \"" + x.getResultTitle() + "\" has this hrf: " + x.getResultTitleHref());
        });
    }
}
