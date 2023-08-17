package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.GalleryDto;
import com.threesteps.acpapi.dto.CreateGalleryRequest;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.GalleryMapper;
import com.threesteps.acpapi.model.Gallery;
import com.threesteps.acpapi.repository.GalleryRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GalleryService {

    private final GalleryRepository repository;
    private final GalleryMapper galleryMapper;
    private final FileService fileService;

    public GalleryService(GalleryRepository repository,
                          GalleryMapper galleryMapper,
                          FileService fileService) {
        this.repository = repository;
        this.galleryMapper = galleryMapper;
        this.fileService = fileService;
    }

    public List<GalleryDto> getAll() {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = galleryMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public List<GalleryDto> getAllLast() {
        return repository.findAllByOrderByCreateDateDesc()
                .stream()
                .map(x -> {
                    var dto = galleryMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public List<GalleryDto> getLast(int count) {
        return repository
                .findAllByOrderByCreateDateDesc(PageRequest.of(0, count))
                .stream()
                .map(x -> {
                    var dto = galleryMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public Gallery findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find gallery with id: " + id));
    }

    public GalleryDto getById(String id) {
        return galleryMapper.toDTO(findById(id));
    }

    public void add(CreateGalleryRequest request, MultipartFile file) {
        if (file != null) {
            request.setImageUrl(fileService.saveFile(file));
        }

        request.setCreateDate(LocalDateTime.now());
        request.setStatus(true);
        repository.save(galleryMapper.toDBO(request));
    }

    public GalleryDto update(GalleryDto galleryDto, MultipartFile file) {
        if (file != null) {
            var entityInDb = findById(galleryDto.getId());
            fileService.deleteFile(entityInDb.getImageUrl());
            galleryDto.setImageUrl(fileService.saveFile(file));
        }

        var entity = galleryMapper.toDBO(galleryDto);
        repository.save(entity);
        return galleryMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}