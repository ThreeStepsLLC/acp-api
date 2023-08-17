package com.threesteps.acpapi.util.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FilePathHelper {

    private static String staticMediaBaseUrl;

    @Value("${media.base-url}")
    public void setMediaBaseUrl(String mediaBaseUrl) {
        FilePathHelper.staticMediaBaseUrl = mediaBaseUrl;
    }

    public static String combineForMedia(String fileName) {
        return staticMediaBaseUrl + fileName;
    }

}
