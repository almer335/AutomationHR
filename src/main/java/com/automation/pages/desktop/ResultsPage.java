package com.automation.pages.desktop;

import com.automation.models.results.Results;
import com.automation.pages.common.Page;
import com.automation.pages.desktop.components.ResultsList;
import com.automation.support.SearchTab;
import com.automation.webdriver.ExtendedWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.env.Environment;

import java.util.List;

public class ResultsPage extends Page {

    @FindBy(css = "div[class=search-selectors] a")
    private List<WebElement> searchSelectors;

    @FindBy(css = "span[class=search-term-tk]")
    private WebElement searchTerm;

    private ResultsList resultsList;

    protected ResultsPage(ExtendedWebDriver webDriver, Environment environment) {
        super(webDriver, environment);
        resultsList = new ResultsList(this);
    }

    public ResultsList resultsList() {
        resultsList.refresh();
        return resultsList;
    }

    public List<Results> getResultsForSpecificTab(SearchTab tab) {
        sleep(A_LITTLE);
        searchSelectors.stream().filter(x->
                x.getText().equalsIgnoreCase(tab.getValue())).findFirst().get().click();
        sleep(NORMAL);
        return resultsList().getResults();
    }

    public String getSearchTerm() {
        return searchTerm.getText();
    }

    public Boolean isSearchTermDisplayed() {
        return searchTerm.isDisplayed();
    }

}
