package com.automation.helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component @Lazy
public class LoginHelper extends CommonHelper {

    @Value("${anypoint.login.error.message}")
    private String anypoinErrorLoginMessage;

    @Value("${anypoint.user.name}")
    private String anypointUserName;

    @Value("${anypoint.user.password}")
    private String anypointUserPassword;

    @Value("${anypoint.forgot.sign.endpoint}")
    private String anypointForgotSignUrl;

    @Value("${anypoint.platform.home.site.endpoint}")
    private String anypointPlatformHomeUrl;

    public String getAnypoinErrorLoginMessage() {
        return anypoinErrorLoginMessage;
    }

    public String getAnypointUserName() {
        return anypointUserName;
    }

    public String getAnypointUserPassword() {
        return anypointUserPassword;
    }

    public String getAnypointForgotSignUrl() {
        return anypointForgotSignUrl;
    }

    public String getAnypointPlatformHomeUrl() {
        return anypointPlatformHomeUrl;
    }
}
