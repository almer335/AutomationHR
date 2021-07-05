package com.automation.helpers;

public class CommonHelper {

    protected static final Integer TOO_MUCH = 20000;

    protected static final Integer A_LOT = 10000;

    protected static final Integer NORMAL = 5000;

    protected static final Integer A_LITTLE = 3000;

    protected void sleep(Integer milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

}
