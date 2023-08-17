package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.ConstantDto;
import com.threesteps.acpapi.dto.ConstantLangedDto;
import com.threesteps.acpapi.model.Constant;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ConstantMapper {

    public ConstantDto toDTO(Constant from) {
        if (from == null) return null;

        return new ConstantDto(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU());
    }

    public Constant toDBO(ConstantDto from) {
        if (from == null) return null;

        return new Constant(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU());
    }

    public ConstantLangedDto toConstantLangedDto(Constant from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new ConstantLangedDto(
                    from.getId(),
                    from.getTitleAZ(),
                    from.getDescriptionAZ()
            );
        }

        if (Objects.equals(language, "ru")) {
            return new ConstantLangedDto(
                    from.getId(),
                    from.getTitleRU(),
                    from.getDescriptionRU()
            );
        }

        return new ConstantLangedDto(
                from.getId(),
                from.getTitleEN(),
                from.getDescriptionEN()
        );
    }

}