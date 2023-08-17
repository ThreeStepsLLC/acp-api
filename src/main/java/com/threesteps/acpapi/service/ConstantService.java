package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.ConstantDto;
import com.threesteps.acpapi.dto.ConstantLangedDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.ConstantMapper;
import com.threesteps.acpapi.model.Constant;
import com.threesteps.acpapi.repository.ConstantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstantService {

    private final ConstantRepository repository;
    private final ConstantMapper constantMapper;

    public ConstantService(ConstantRepository repository,
                           ConstantMapper constantMapper) {
        this.repository = repository;
        this.constantMapper = constantMapper;
    }

    public List<ConstantDto> getAll() {
        return repository.findAll()
                .stream()
                .map(constantMapper::toDTO)
                .toList();
    }

    public Constant findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find constant with id: " + id));
    }

    public Optional<Constant> findByIdOptional(String id) {
        return repository.findById(id);
    }

    public ConstantDto getById(String id) {
        return constantMapper.toDTO(findById(id));
    }

    public ConstantDto update(ConstantDto constantDto) {
        var entity = constantMapper.toDBO(constantDto);
        repository.save(entity);
        return constantMapper.toDTO(entity);
    }

    public void add(Constant constant) {
        repository.save(constant);
    }

    public ConstantLangedDto getConstantByIdLanged(String id, String language) {
        return constantMapper.toConstantLangedDto(findById(id), language);
    }

}