package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.CreateSeparateLicenseRequest;
import com.threesteps.acpapi.dto.SeparateLicenseDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.SeparateLicenseMapper;
import com.threesteps.acpapi.model.SeparateLicense;
import com.threesteps.acpapi.repository.SeparateLicenseRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class SeparateLicenseService {

    private final SeparateLicenseRepository repository;
    private final SeparateLicenseMapper separateLicenseMapper;
    private final FileService fileService;

    public SeparateLicenseService(SeparateLicenseRepository repository,
                                  SeparateLicenseMapper separateLicenseMapper,
                                  FileService fileService) {
        this.repository = repository;
        this.separateLicenseMapper = separateLicenseMapper;
        this.fileService = fileService;
    }

    public List<SeparateLicenseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = separateLicenseMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public SeparateLicense findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find separateLicense with id: " + id));
    }

    public void add(MultipartFile file) {
        var request = new CreateSeparateLicenseRequest();
        request.setImageUrl(fileService.saveFile(file));
        repository.save(separateLicenseMapper.toDBO(request));
    }

    public void deleteById(String id) {
        var entity = findById(id);
        fileService.deleteFile(entity.getImageUrl());
        repository.deleteById(id);
    }

}