package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.ServiceDescriptionDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.ServiceDescriptionMapper;
import com.threesteps.acpapi.model.ServiceDescription;
import com.threesteps.acpapi.repository.ServiceDescriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceDescriptionService {

    private final ServiceDescriptionRepository repository;
    private final ServiceDescriptionMapper mapper;

    public ServiceDescriptionService(ServiceDescriptionRepository repository, ServiceDescriptionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ServiceDescriptionDto get() {
        return repository.findAll().stream()
                .findFirst()
                .map(mapper::toDto)
                .orElse(null);
    }

    public ServiceDescriptionDto getById(String id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("Service description not found"));
    }

    public void create(ServiceDescriptionDto dto) {
        ServiceDescription entity = mapper.toEntity(dto);
        repository.save(entity);
    }

    public ServiceDescriptionDto update(ServiceDescriptionDto dto) {
        ServiceDescription entity = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Service description not found"));
        
        entity.setDescriptionAz(dto.getDescriptionAz());
        entity.setDescriptionEn(dto.getDescriptionEn());
        entity.setDescriptionRu(dto.getDescriptionRu());
        
        return mapper.toDto(repository.save(entity));
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Service description not found");
        }
        repository.deleteById(id);
    }

}
