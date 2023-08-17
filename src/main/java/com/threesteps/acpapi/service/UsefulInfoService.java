package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.UsefulInfoDto;
import com.threesteps.acpapi.dto.CreateUsefulInfoRequest;
import com.threesteps.acpapi.dto.UsefulInfoLangedDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.UsefulInfoMapper;
import com.threesteps.acpapi.model.UsefulInfo;
import com.threesteps.acpapi.repository.UsefulInfoRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsefulInfoService {

    private final UsefulInfoRepository repository;
    private final UsefulInfoMapper usefulInfoMapper;
    private final FileService fileService;

    public UsefulInfoService(UsefulInfoRepository repository,
                             UsefulInfoMapper usefulInfoMapper,
                             FileService fileService) {
        this.repository = repository;
        this.usefulInfoMapper = usefulInfoMapper;
        this.fileService = fileService;
    }

    public List<UsefulInfoDto> getAll() {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = usefulInfoMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public List<UsefulInfoLangedDto> getLastLanged(String language) {
        return repository
                .findAllByOrderByCreateDateDesc()
                .stream()
                .map(x -> {
                    var dto = usefulInfoMapper.toUsefulInfoLangedDto(x, language);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public UsefulInfo findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find usefulInfo with id: " + id));
    }

    public UsefulInfoDto getById(String id) {
        var dto = usefulInfoMapper.toDTO(findById(id));
        dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
        return dto;
    }

    public void add(CreateUsefulInfoRequest request, MultipartFile file) {
        if (file != null) {
            request.setImageUrl(fileService.saveFile(file));
        }

        request.setCreateDate(LocalDateTime.now());
        request.setStatus(true);
        repository.save(usefulInfoMapper.toDBO(request));
    }

    public UsefulInfoDto update(UsefulInfoDto usefulInfoDto, MultipartFile file) {
        var entityInDb = findById(usefulInfoDto.getId());
        usefulInfoDto.setImageUrl(entityInDb.getImageUrl());
        if (file != null) {
            fileService.deleteFile(usefulInfoDto.getImageUrl());
            usefulInfoDto.setImageUrl(fileService.saveFile(file));
        }

        var entity = usefulInfoMapper.toDBO(usefulInfoDto);
        repository.save(entity);
        return usefulInfoMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public List<UsefulInfoLangedDto> getAllLanged(String language) {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = usefulInfoMapper.toUsefulInfoLangedDto(x, language);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public UsefulInfoLangedDto getByIdLanged(String id, String language) {
        var dto = usefulInfoMapper.toUsefulInfoLangedDto(findById(id), language);
        dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
        return dto;
    }
}