package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.CreateSliderImageRequest;
import com.threesteps.acpapi.dto.SliderImageDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.SliderImageMapper;
import com.threesteps.acpapi.model.SliderImage;
import com.threesteps.acpapi.repository.SliderImageRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class SliderImageService {

    private final SliderImageRepository repository;
    private final SliderImageMapper sliderImageMapper;
    private final FileService fileService;

    public SliderImageService(SliderImageRepository repository,
                              SliderImageMapper sliderImageMapper,
                              FileService fileService) {
        this.repository = repository;
        this.sliderImageMapper = sliderImageMapper;
        this.fileService = fileService;
    }

    public List<SliderImageDto> getAll() {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = sliderImageMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public SliderImage findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find sliderImage with id: " + id));
    }

    public void add(MultipartFile file) {
        var request = new CreateSliderImageRequest();
        request.setImageUrl(fileService.saveFile(file));
        repository.save(sliderImageMapper.toDBO(request));
    }

    public void deleteById(String id) {
        var entity = findById(id);
        fileService.deleteFile(entity.getImageUrl());
        repository.deleteById(id);
    }

}