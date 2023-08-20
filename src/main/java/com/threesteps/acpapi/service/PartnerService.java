package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.PartnerDto;
import com.threesteps.acpapi.dto.CreatePartnerRequest;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.PartnerMapper;
import com.threesteps.acpapi.model.Partner;
import com.threesteps.acpapi.repository.PartnerRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PartnerService {

    private final PartnerRepository repository;
    private final PartnerMapper partnerMapper;
    private final FileService fileService;

    public PartnerService(PartnerRepository repository,
                          PartnerMapper partnerMapper,
                          FileService fileService) {
        this.repository = repository;
        this.partnerMapper = partnerMapper;
        this.fileService = fileService;
    }

    public List<PartnerDto> getAll() {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = partnerMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public List<PartnerDto> getAllLast() {
        return repository.findAllByOrderByCreateDateDesc()
                .stream()
                .map(x -> {
                    var dto = partnerMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public List<PartnerDto> getLast(int count) {
        return repository
                .findAllByOrderByCreateDateDesc(PageRequest.of(0, count))
                .stream()
                .map(x -> {
                    var dto = partnerMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public Partner findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find partner with id: " + id));
    }

    public PartnerDto getById(String id) {
        return partnerMapper.toDTO(findById(id));
    }

    public void add(CreatePartnerRequest request, MultipartFile file) {
        if (file != null) {
            request.setImageUrl(fileService.saveFile(file));
        }

        request.setCreateDate(LocalDateTime.now());
        request.setStatus(true);
        repository.save(partnerMapper.toDBO(request));
    }

    public PartnerDto update(PartnerDto partnerDto, MultipartFile file) {
        var entityInDb = findById(partnerDto.getId());
        partnerDto.setImageUrl(fileService.saveFile(file));

        if (file != null) {
            fileService.deleteFile(entityInDb.getImageUrl());
            partnerDto.setImageUrl(fileService.saveFile(file));
        }

        var entity = partnerMapper.toDBO(partnerDto);
        repository.save(entity);
        return partnerMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}