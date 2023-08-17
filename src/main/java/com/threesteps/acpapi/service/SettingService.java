package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.CreateSettingRequest;
import com.threesteps.acpapi.dto.SettingDto;
import com.threesteps.acpapi.mapper.SettingMapper;
import com.threesteps.acpapi.repository.SettingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService {

    private final SettingRepository repository;
    private final SettingMapper settingMapper;

    public SettingService(SettingRepository repository, SettingMapper settingMapper) {
        this.repository = repository;
        this.settingMapper = settingMapper;
    }

    public List<SettingDto> getAll() {
        return repository.findAll()
                .stream()
                .map(settingMapper::toDTO)
                .toList();
    }

    public SettingDto get() {
        return getAll().get(0);
    }

    public void add(CreateSettingRequest request) {
        repository.save(settingMapper.toDBO(request));
    }

    public SettingDto update(SettingDto settingDto) {
        var entity = settingMapper.toDBO(settingDto);
        repository.save(entity);
        return settingMapper.toDTO(entity);
    }
}