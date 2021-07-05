package com.automation.models.results;

public class Results {

    private String resultTitle;

    private String resultTitleHref;

    private String resultUrl;

    private String resultSnippet;

    public Results(String resultTitle, String resultTitleHref, String resultUrl, String resultSnippet) {
        this.resultTitle = resultTitle;
        this.resultTitleHref = resultTitleHref;
        this.resultUrl = resultUrl;
        this.resultSnippet = resultSnippet;
    }

    public String getResultTitle() {
        return resultTitle;
    }

    public String getResultTitleHref() {
        return resultTitleHref;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public String getResultSnippet() {
        return resultSnippet;
    }
}
