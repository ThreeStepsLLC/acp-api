package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.SurgeryDto;
import com.threesteps.acpapi.dto.CreateSurgeryRequest;
import com.threesteps.acpapi.dto.SurgeryLangedDto;
import com.threesteps.acpapi.model.Surgery;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SurgeryMapper {

    public SurgeryDto toDTO(Surgery from) {
        if (from == null) return null;

        return new SurgeryDto(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getCreateDate(),
                from.getStatus());
    }

    public Surgery toDBO(CreateSurgeryRequest from) {
        if (from == null) return null;

        return new Surgery(null,
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getCreateDate(),
                from.getStatus());
    }

    public Surgery toDBO(SurgeryDto from) {
        if (from == null) return null;

        return new Surgery(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getCreateDate(),
                from.getStatus());
    }

    public SurgeryLangedDto toSurgeryLangedDto(Surgery from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new SurgeryLangedDto(from.getId(),
                    from.getTitleAZ(),
                    from.getDescriptionAZ(),
                    from.getCreateDate(),
                    from.getStatus());
        }

        if (Objects.equals(language, "ru")) {
            return new SurgeryLangedDto(from.getId(),
                    from.getTitleRU(),
                    from.getDescriptionRU(),
                    from.getCreateDate(),
                    from.getStatus());
        }


        return new SurgeryLangedDto(from.getId(),
                from.getTitleEN(),
                from.getDescriptionEN(),
                from.getCreateDate(),
                from.getStatus());


    }
}