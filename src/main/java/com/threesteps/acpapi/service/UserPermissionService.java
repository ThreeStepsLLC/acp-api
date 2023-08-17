package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.CreateUserPermissionRequest;
import com.threesteps.acpapi.dto.PermissionDto;
import com.threesteps.acpapi.dto.UserPermissionDto;
import com.threesteps.acpapi.dto.UserPermissionManyRequest;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.PermissionMapper;
import com.threesteps.acpapi.mapper.UserPermissionMapper;
import com.threesteps.acpapi.model.Permission;
import com.threesteps.acpapi.model.User;
import com.threesteps.acpapi.model.UserPermission;
import com.threesteps.acpapi.repository.UserPermissionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPermissionService {

    private final UserPermissionRepository repository;
    private final UserPermissionMapper userPermissionMapper;
    private final PermissionMapper permissionMapper;

    public UserPermissionService(UserPermissionRepository repository,
                                 UserPermissionMapper userPermissionMapper,
                                 PermissionMapper permissionMapper) {
        this.repository = repository;
        this.userPermissionMapper = userPermissionMapper;
        this.permissionMapper = permissionMapper;
    }

    public List<UserPermissionDto> getAll() {
        return repository.findAll()
                .stream()
                .map(userPermissionMapper::toDTO)
                .toList();
    }

    public UserPermission findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find userPermission with id: " + id));
    }

    public UserPermissionDto getById(String id) {
        return userPermissionMapper.toDTO(findById(id));
    }

    public List<UserPermissionDto> add(CreateUserPermissionRequest request) {
        repository.save(userPermissionMapper.toDBO(request));
        return getAll();
    }

    public List<UserPermissionDto> add(UserPermission userPermission) {
        repository.save(userPermission);
        return getAll();
    }

    public UserPermissionDto update(UserPermission userPermission) {
        repository.save(userPermission);
        return userPermissionMapper.toDTO(userPermission);
    }

    public List<UserPermissionDto> deleteById(String id) {
        repository.deleteById(id);
        return getAll();
    }

    public List<Permission> findPermissionsByUserId(String userId) {
        return repository.findAllByUserId(userId)
                .stream()
                .map(UserPermission::getPermission)
                .toList();
    }

    public List<PermissionDto> getPermissionsByUserId(String userId) {
        return findPermissionsByUserId(userId)
                .stream()
                .map(permissionMapper::toDTO)
                .toList();
    }

    public Optional<UserPermission> findUserPermissionByPermissionIdAndUserId(String permissionId, String userId) {
        return repository.findByPermissionIdAndUserId(permissionId, userId);
    }

    @Transactional
    public void updatePermissions(UserPermissionManyRequest request) {
        repository.deleteByUserId(request.getUserId());
        for (var permissionId : request.getPermissions()) {
            var userPermission = new UserPermission(null,
                    new User(request.getUserId()),
                    new Permission(permissionId));
            repository.save(userPermission);
        }
    }
}