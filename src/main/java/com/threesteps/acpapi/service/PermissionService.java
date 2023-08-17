package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.PermissionDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.PermissionMapper;
import com.threesteps.acpapi.model.Permission;
import com.threesteps.acpapi.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    private final PermissionRepository repository;
    private final PermissionMapper permissionMapper;

    public PermissionService(PermissionRepository repository, PermissionMapper permissionMapper) {
        this.repository = repository;
        this.permissionMapper = permissionMapper;
    }

    public List<PermissionDto> getAll() {
        return repository.findAll()
                .stream()
                .map(permissionMapper::toDTO)
                .toList();
    }

    public Permission findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find permission with id: " + id));
    }

    public Permission findByTitleWithoutException(String title) {
        return repository.findByTitle(title).orElse(null);
    }

    public PermissionDto getById(String id) {
        return permissionMapper.toDTO(findById(id));
    }

    public List<PermissionDto> add(Permission permission) {
        repository.save(permission);
        return getAll();
    }

    public Permission update(Permission permission) {
        repository.save(permission);
        return permission;
    }

    public List<PermissionDto> deleteById(String id) {
        repository.deleteById(id);
        return getAll();
    }

    public Optional<Permission> findByIdOptional(String id) {
        return repository.findById(id);
    }
}