package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.PositionDto;
import com.threesteps.acpapi.dto.CreatePositionRequest;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.PositionMapper;
import com.threesteps.acpapi.model.Position;
import com.threesteps.acpapi.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository repository;
    private final PositionMapper positionMapper;

    public PositionService(PositionRepository repository, PositionMapper positionMapper) {
        this.repository = repository;
        this.positionMapper = positionMapper;
    }

    public List<PositionDto> getAll() {
        return repository.findAll()
                .stream()
                .map(positionMapper::toDTO)
                .toList();
    }

    public Position findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find position with id: " + id));
    }

    public PositionDto getById(String id) {
        return positionMapper.toDTO(findById(id));
    }

    public void add(CreatePositionRequest request) {
        repository.save(positionMapper.toDBO(request));
    }

    public PositionDto update(PositionDto positionDto) {
        var entity = positionMapper.toDBO(positionDto);
        repository.save(entity);
        return positionMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}