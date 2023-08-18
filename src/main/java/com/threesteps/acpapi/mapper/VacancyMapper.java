package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.PositionDto;
import com.threesteps.acpapi.dto.VacancyDto;
import com.threesteps.acpapi.dto.CreateVacancyRequest;
import com.threesteps.acpapi.model.Vacancy;
import org.springframework.stereotype.Component;

@Component
public class VacancyMapper {

    private final PositionMapper positionMapper;

    public VacancyMapper(PositionMapper positionMapper) {
        this.positionMapper = positionMapper;
    }

    public VacancyDto toDTO(Vacancy from) {
        if (from == null) return null;

        return new VacancyDto(from.getId(),
                from.getFullName(),
                from.getMail(),
                from.getCity(),
                positionMapper.toDTO(from.getPosition()),
                from.getCvFilePath(),
                from.getCreateDate());
    }

    public Vacancy toDBO(CreateVacancyRequest from) {
        if (from == null) return null;

        return new Vacancy(null,
                from.getFullName(),
                from.getMail(),
                from.getCity(),
                positionMapper.toDBO(new PositionDto(from.getPosition().getId())),
                from.getCvFilePath(),
                from.getCreateDate());
    }

    public Vacancy toDBO(VacancyDto from) {
        if (from == null) return null;

        return new Vacancy(from.getId(),
                from.getFullName(),
                from.getMail(),
                from.getCity(),
                positionMapper.toDBO(from.getPosition()),
                from.getCvFilePath(),
                from.getCreateDate());
    }

}