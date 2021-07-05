package com.automation.helpers;


import com.automation.models.users.User;
import com.automation.support.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component @Lazy
public class DownloadHelper extends CommonHelper {

    @Autowired
    private Environment environment;

    @Value("${HOME}")
    private String userHomeDir;

    @Value("${anypoint.studio.name}-${anypoint.studio.version}-{0}{1}.crdownload")
    private String anypointStudioNameTemplate;

    public User getUserByDefault() {
        return new User(
                environment.getProperty("default.user.first.name"),
                environment.getProperty("default.user.last.name"),
                environment.getProperty("default.user.email"),
                environment.getProperty("default.user.company"),
                environment.getProperty("default.user.job.title"),
                environment.getProperty("default.user.phone.number")
        );
    }

    public Boolean itsAnyFileDownloading() {
        sleep(NORMAL);
        return Arrays.stream(getFiles()).filter(x-> x.getName().endsWith(".crdownload")).count() >= 1;
    }

    public Boolean itsFileDownloadingForSpecificOS(OS os) {
        sleep(NORMAL);
        String fileName = MessageFormat.format(anypointStudioNameTemplate, os.getVersion(), os.getExtension());
        return Arrays.stream(getFiles()).filter(x->
                x.getName().endsWith(fileName))
                .count() == 1;
    }

    private File[] getFiles() {
        return new File(userHomeDir + "/Downloads").listFiles();
    }

    public void deleteFiles() {
        Arrays.stream(getFiles()).filter(x->
                x.getName().endsWith(".crdownload")).collect(Collectors.toList())
                .forEach(x->x.delete());
    }

}
