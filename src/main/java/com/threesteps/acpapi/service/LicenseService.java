package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.CreateLicenseRequest;
import com.threesteps.acpapi.dto.LicenseDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.LicenseMapper;
import com.threesteps.acpapi.model.License;
import com.threesteps.acpapi.repository.LicenseRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class LicenseService {

    private final LicenseRepository repository;
    private final LicenseMapper licenseMapper;
    private final FileService fileService;

    public LicenseService(LicenseRepository repository,
                          LicenseMapper licenseMapper,
                          FileService fileService) {
        this.repository = repository;
        this.licenseMapper = licenseMapper;
        this.fileService = fileService;
    }

    public List<LicenseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = licenseMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public License findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find license with id: " + id));
    }

    public void add(MultipartFile file) {
        var request = new CreateLicenseRequest();
        request.setImageUrl(fileService.saveFile(file));
        repository.save(licenseMapper.toDBO(request));
    }

    public void deleteById(String id) {
        var entity = findById(id);
        fileService.deleteFile(entity.getImageUrl());
        repository.deleteById(id);
    }

}