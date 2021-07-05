package com.automation.support;

public enum PlatformsOptions {

    ANYPOINT("Anypoint Platform"),
    TRAINING("Training"),
    HELPCENTER("Help Center");

    private String value;


    PlatformsOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
