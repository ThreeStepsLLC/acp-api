package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.SettingDto;
import com.threesteps.acpapi.dto.CreateSettingRequest;
import com.threesteps.acpapi.model.Setting;
import org.springframework.stereotype.Component;

@Component
public class SettingMapper {

    public SettingDto toDTO(Setting from) {
        if (from == null) return null;

        return new SettingDto(from.getId(),
                from.getDefaultLanguage(),
                from.getMailAdressForContact(),
                from.getPhone(),
                from.getFacebook(),
                from.getLinkedin(),
                from.getInstagram(),
                from.getYouTube(),
                from.getStatus());
    }

    public Setting toDBO(CreateSettingRequest from) {
        if (from == null) return null;

        return new Setting(null,
                from.getDefaultLanguage(),
                from.getMailAdressForContact(),
                from.getPhone(),
                from.getFacebook(),
                from.getLinkedin(),
                from.getInstagram(),
                from.getYouTube(),
                from.getStatus());
    }

    public Setting toDBO(SettingDto from) {
        if (from == null) return null;

        return new Setting(from.getId(),
                from.getDefaultLanguage(),
                from.getMailAdressForContact(),
                from.getPhone(),
                from.getFacebook(),
                from.getLinkedin(),
                from.getInstagram(),
                from.getYouTube(),
                from.getStatus());
    }

}