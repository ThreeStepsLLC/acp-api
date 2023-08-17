package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.CreateSurgeryRequest;
import com.threesteps.acpapi.dto.SurgeryDto;
import com.threesteps.acpapi.dto.SurgeryLangedDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.SurgeryMapper;
import com.threesteps.acpapi.model.Surgery;
import com.threesteps.acpapi.repository.SurgeryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SurgeryService {

    private final SurgeryRepository repository;
    private final SurgeryMapper surgeryMapper;

    public SurgeryService(SurgeryRepository repository,
                          SurgeryMapper surgeryMapper) {
        this.repository = repository;
        this.surgeryMapper = surgeryMapper;
    }

    public List<SurgeryDto> getAll() {
        return repository.findAll()
                .stream()
                .map(surgeryMapper::toDTO)
                .toList();
    }

    public List<SurgeryLangedDto> getAllLanged(String language) {
        return repository.findAll()
                .stream()
                .map(x -> surgeryMapper.toSurgeryLangedDto(x, language))
                .toList();
    }

    public Surgery findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find surgery with id: " + id));
    }

    public SurgeryDto getById(String id) {
        return surgeryMapper.toDTO(findById(id));
    }

    public void add(CreateSurgeryRequest request) {
        request.setCreateDate(LocalDateTime.now());
        request.setStatus(true);
        repository.save(surgeryMapper.toDBO(request));
    }

    public SurgeryDto update(SurgeryDto request) {
        var entity = surgeryMapper.toDBO(request);
        repository.save(entity);
        return surgeryMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public SurgeryLangedDto getByIdLanged(String id, String language) {
        return surgeryMapper.toSurgeryLangedDto(findById(id), language);
    }
}