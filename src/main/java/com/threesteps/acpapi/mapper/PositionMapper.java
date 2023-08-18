package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.PositionDto;
import com.threesteps.acpapi.dto.CreatePositionRequest;
import com.threesteps.acpapi.model.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {

    public PositionDto toDTO(Position from) {
        if (from == null) return null;

        return new PositionDto(from.getId(), from.getTitle());
    }

    public Position toDBO(CreatePositionRequest from) {
        if (from == null) return null;

        return new Position(null, from.getTitle());
    }

    public Position toDBO(PositionDto from) {
        if (from == null) return null;

        return new Position(from.getId(), from.getTitle());
    }

}