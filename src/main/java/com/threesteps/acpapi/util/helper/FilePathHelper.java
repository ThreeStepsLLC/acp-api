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
        if (fileName == null || fileName.isEmpty()) {
            return staticMediaBaseUrl;
        }
        // Ensure no double slashes
        if (staticMediaBaseUrl.endsWith("/") && fileName.startsWith("/")) {
            return staticMediaBaseUrl + fileName.substring(1);
        }
        if (!staticMediaBaseUrl.endsWith("/") && !fileName.startsWith("/")) {
            return staticMediaBaseUrl + "/" + fileName;
        }
        return staticMediaBaseUrl + fileName;
    }

}
