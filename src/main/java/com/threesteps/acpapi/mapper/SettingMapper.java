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
                from.getMailAddressForContact(),
                from.getOfficeAddress(),
                from.getPhone(),
                from.getFacebook(),
                from.getLinkedin(),
                from.getInstagram(),
                from.getYouTube(),
                from.getTwitter(),
                from.getWhatsapp(),
                from.getTotalProjects(),
                from.getTotalRoad(),
                from.getTotalTunnels(),
                from.getTotalBridges());
    }

    public Setting toDBO(CreateSettingRequest from) {
        if (from == null) return null;

        return new Setting(null,
                from.getDefaultLanguage(),
                from.getMailAddressForContact(),
                from.getOfficeAddress(),
                from.getPhone(),
                from.getFacebook(),
                from.getLinkedin(),
                from.getInstagram(),
                from.getYouTube(),
                from.getTwitter(),
                from.getWhatsapp(),
                from.getTotalProjects(),
                from.getTotalRoad(),
                from.getTotalTunnels(),
                from.getTotalBridges());
    }

    public Setting toDBO(SettingDto from) {
        if (from == null) return null;

        return new Setting(from.getId(),
                from.getDefaultLanguage(),
                from.getMailAddressForContact(),
                from.getOfficeAddress(),
                from.getPhone(),
                from.getFacebook(),
                from.getLinkedin(),
                from.getInstagram(),
                from.getYouTube(),
                from.getTwitter(),
                from.getWhatsapp(),
                from.getTotalProjects(),
                from.getTotalRoad(),
                from.getTotalTunnels(),
                from.getTotalBridges());
    }

}