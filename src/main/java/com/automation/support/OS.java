package com.automation.support;

public enum OS {

    WINDOWS("Windows", "win64",".zip"),
    MAC("Mac", "macos64",".zip"),
    LINUX("Linux","linux64",".tar.gz");

    private String option;

    private String version;

    private String extensionFile;

    OS(String option, String version, String extensionFile) {
        this.option = option;
        this.version = version;
        this.extensionFile = extensionFile;
    }

    public String getOption() {
        return option;
    }

    public String getVersion() {
        return version;
    }

    public String getExtension() {
        return extensionFile;
    }
}
