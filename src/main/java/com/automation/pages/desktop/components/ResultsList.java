package com.automation.pages.desktop.components;

import com.automation.models.results.Results;
import com.automation.pages.common.Component;
import com.automation.pages.common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsList extends Component {

    @FindBy(css = "div[class=sresult]")
    private List<WebElement> resultsList;

    public ResultsList(Page page) {
        super(page);
    }

    public List<Results> getResults() {
        return resultsList.stream().map(x->{
            WebElement titleWebElement = x.findElement(By.cssSelector("h4[class=sresult-title] a"));
            String title = titleWebElement.getText();
            String titleHref = titleWebElement.getAttribute("href");
            String url = x.findElement(By.cssSelector("p[class=sresult-url]")).getText();
            String snippet = x.findElement(By.cssSelector("p[class=sresult-snippet]")).getText();
            return new Results(title, titleHref, url, snippet);
        }).collect(Collectors.toList());
    }

}
