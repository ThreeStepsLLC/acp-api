package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.UpdatePasswordRequest;
import com.threesteps.acpapi.dto.UserDto;
import com.threesteps.acpapi.dto.CreateUserRequest;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.UserMapper;
import com.threesteps.acpapi.model.User;
import com.threesteps.acpapi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository repository,
                       UserMapper userMapper,
                       BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    public List<UserDto> getAll() {
        return repository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    public User findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find user with id: " + id));
    }

    public UserDto getById(String id) {
        return userMapper.toDTO(findById(id));
    }

    public User findByUsernameWithoutException(String username) {
        return repository.findByUsername(username).orElse(null);
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Couldn't find user with usernmae: " + username));
    }

    public UserDto add(CreateUserRequest request) {
        var entity = repository.save(userMapper.toDBO(request));
        return userMapper.toDTO(entity);
    }

    public List<UserDto> deleteById(String id) {
        repository.deleteById(id);
        return getAll();
    }

    public void updatePassword(UpdatePasswordRequest request) {
        var user = findById(request.getUserId());
        user.setPassword(encoder.encode(request.getPassword()));
        repository.save(user);
    }
}