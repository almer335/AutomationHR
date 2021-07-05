package com.automation.support;

public enum SearchTab {

    ALL_SITE("All Sites"),
    DOCS("Docs"),
    EXCHANGE("Exchange"),
    BLOG("Blog"),
    FORUM("Forum"),
    TRAINING("Training"),
    DEVELOPERS("Developers"),
    VIDEOS("Videos");

    private String value;

    SearchTab(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
