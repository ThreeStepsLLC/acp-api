package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.CreatePositionRequest;
import com.threesteps.acpapi.dto.PositionDto;
import com.threesteps.acpapi.dto.PositionLangedDto;
import com.threesteps.acpapi.model.Position;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PositionMapper {

    public PositionDto toDTO(Position from) {
        if (from == null) return null;

        return new PositionDto(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU()
        );
    }

    public Position toDBO(CreatePositionRequest from) {
        if (from == null) return null;

        return new Position(null,
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU());
    }

    public Position toDBO(PositionDto from) {
        if (from == null) return null;

        return new Position(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU());
    }

    public PositionLangedDto toConstantLangedDto(Position from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new PositionLangedDto(
                    from.getId(),
                    from.getTitleAZ()
            );
        }

        if (Objects.equals(language, "ru")) {
            return new PositionLangedDto(
                    from.getId(),
                    from.getTitleRU()
            );
        }

        return new PositionLangedDto(
                from.getId(),
                from.getTitleEN());
    }

}