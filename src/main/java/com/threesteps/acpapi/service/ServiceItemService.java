package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.ServiceItemDto;
import com.threesteps.acpapi.dto.CreateServiceItemRequest;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.ServiceItemMapper;
import com.threesteps.acpapi.model.ServiceItem;
import com.threesteps.acpapi.repository.ServiceItemRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceItemService {

    private final ServiceItemRepository repository;
    private final ServiceItemMapper serviceItemMapper;
    private final FileService fileService;

    public ServiceItemService(ServiceItemRepository repository,
                              ServiceItemMapper serviceItemMapper,
                              FileService fileService) {
        this.repository = repository;
        this.serviceItemMapper = serviceItemMapper;
        this.fileService = fileService;
    }

    public List<ServiceItemDto> getAll() {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = serviceItemMapper.toDTO(x);
                    dto.setIconUrl(FilePathHelper.combineForMedia(dto.getIconUrl()));
                    return dto;
                })
                .toList();
    }

    public List<ServiceItemDto> getAllByOrder() {
        return repository.findAllByOrderByOrderNumberAsc()
                .stream()
                .map(x -> {
                    var dto = serviceItemMapper.toDTO(x);
                    dto.setIconUrl(FilePathHelper.combineForMedia(dto.getIconUrl()));
                    return dto;
                })
                .toList();
    }

    public List<ServiceItemDto> getLast(int count) {
        return repository
                .findAllByOrderByOrderNumberAsc(PageRequest.of(0, count))
                .stream()
                .map(x -> {
                    var dto = serviceItemMapper.toDTO(x);
                    dto.setIconUrl(FilePathHelper.combineForMedia(dto.getIconUrl()));
                    return dto;
                })
                .toList();
    }

    public ServiceItem findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find service item with id: " + id));
    }

    public ServiceItemDto getById(String id) {
        return serviceItemMapper.toDTO(findById(id));
    }

    public void add(CreateServiceItemRequest request, MultipartFile file) {
        if (file != null) {
            request.setIconUrl(fileService.saveFile(file));
        }

        request.setCreateDate(LocalDateTime.now());
        request.setStatus(true);
        repository.save(serviceItemMapper.toDBO(request));
    }

    public ServiceItemDto update(ServiceItemDto serviceItemDto, MultipartFile file) {
        var entityInDb = findById(serviceItemDto.getId());

        if (file != null) {
            fileService.deleteFile(entityInDb.getIconUrl());
            serviceItemDto.setIconUrl(fileService.saveFile(file));
        } else {
            serviceItemDto.setIconUrl(entityInDb.getIconUrl());
        }

        var entity = serviceItemMapper.toDBO(serviceItemDto);
        repository.save(entity);
        return serviceItemMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        var entity = findById(id);
        if (entity.getIconUrl() != null) {
            fileService.deleteFile(entity.getIconUrl());
        }
        repository.deleteById(id);
    }

}
