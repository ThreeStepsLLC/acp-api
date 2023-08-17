package com.threesteps.acpapi.service.helper;

import com.threesteps.acpapi.service.SettingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LanguageService {

    private final HttpServletRequest httpServletRequest;
    private final SettingService settingService;

    public LanguageService(HttpServletRequest httpServletRequest, SettingService settingService) {
        this.httpServletRequest = httpServletRequest;
        this.settingService = settingService;
    }

    public String getLanguage() {
        var language = httpServletRequest.getHeader("lang");
        if (Objects.equals(language, "") || Objects.equals(language, null)) {
            return settingService.get().getDefaultLanguage();
        }

        return language;
    }
}
