package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.UsefulInfoDto;
import com.threesteps.acpapi.dto.CreateUsefulInfoRequest;
import com.threesteps.acpapi.dto.UsefulInfoLangedDto;
import com.threesteps.acpapi.model.UsefulInfo;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UsefulInfoMapper {

    public UsefulInfoDto toDTO(UsefulInfo from) {
        if (from == null) return null;

        return new UsefulInfoDto(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public UsefulInfo toDBO(CreateUsefulInfoRequest from) {
        if (from == null) return null;

        return new UsefulInfo(null,
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public UsefulInfo toDBO(UsefulInfoDto from) {
        if (from == null) return null;

        return new UsefulInfo(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public UsefulInfoLangedDto toUsefulInfoLangedDto(UsefulInfo from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new UsefulInfoLangedDto(from.getId(),
                    from.getTitleAZ(),
                    from.getDescriptionAZ(),
                    from.getImageUrl(),
                    from.getCreateDate(),
                    from.getStatus());
        }

        if (Objects.equals(language, "ru")) {
            return new UsefulInfoLangedDto(from.getId(),
                    from.getTitleRU(),
                    from.getDescriptionRU(),
                    from.getImageUrl(),
                    from.getCreateDate(),
                    from.getStatus());
        }

        return new UsefulInfoLangedDto(from.getId(),
                from.getTitleEN(),
                from.getDescriptionEN(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());

    }

}