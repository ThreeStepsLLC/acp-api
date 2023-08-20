package com.threesteps.acpapi.startup;

import com.threesteps.acpapi.dto.CreateSettingRequest;
import com.threesteps.acpapi.service.SettingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SettingStartup implements CommandLineRunner {

    private final SettingService settingService;

    public SettingStartup(SettingService settingService) {
        this.settingService = settingService;
    }

    @Override
    public void run(String... args) {
        var settingList = settingService.getAll();
        if (settingList.size() > 0) return;

        var constant = new CreateSettingRequest(
                "az",
                "mail@gmail.com",
                "officeAddress",
                "phone",
                "https://www.facebook.com",
                "https://www.linkedin.com",
                "https://www.instagram.com",
                "https://www.youtube.com",
                "https://www.twitter.com",
                "https://www.whatsapp.com",
                "0",
                "0",
                "0",
                "0"
        );

        settingService.add(constant);
    }
}
