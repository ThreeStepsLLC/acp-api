package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.ConstantDto;
import com.threesteps.acpapi.dto.ConstantLangedDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.ConstantMapper;
import com.threesteps.acpapi.model.Constant;
import com.threesteps.acpapi.repository.ConstantRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ConstantService {

    private final ConstantRepository repository;
    private final ConstantMapper constantMapper;
    private final FileService fileService;

    public ConstantService(ConstantRepository repository,
                           ConstantMapper constantMapper,
                           FileService fileService) {
        this.repository = repository;
        this.constantMapper = constantMapper;
        this.fileService = fileService;
    }

    public List<ConstantDto> getAll() {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var response = constantMapper.toDTO(x);
                    response.setImageUrl(FilePathHelper.combineForMedia(response.getImageUrl()));
                    response.setMediaContentUrl1(FilePathHelper.combineForMedia(response.getMediaContentUrl1()));
                    response.setMediaContentUrl2(FilePathHelper.combineForMedia(response.getMediaContentUrl2()));
                    return response;
                })
                .toList();
    }

    public Constant findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find constant with id: " + id));
    }

    public Optional<Constant> findByIdOptional(String id) {
        return repository.findById(id);
    }

    public ConstantDto getById(String id) {
        var response = constantMapper.toDTO(findById(id));
        response.setImageUrl(FilePathHelper.combineForMedia(response.getImageUrl()));
        response.setMediaContentUrl1(FilePathHelper.combineForMedia(response.getMediaContentUrl1()));
        response.setMediaContentUrl2(FilePathHelper.combineForMedia(response.getMediaContentUrl2()));
        return response;
    }

    public ConstantDto update(ConstantDto constantDto, MultipartFile file, MultipartFile media1, MultipartFile media2) {
        var constantInDb = findById(constantDto.getId());
        constantDto.setImageUrl(file == null
                ? constantInDb.getImageUrl()
                : fileService.saveFile(file));

        constantDto.setMediaContentUrl1(media1 == null
                ? constantInDb.getMediaContentUrl1()
                : fileService.saveFile(media1));

        constantDto.setMediaContentUrl2(media2 == null
                ? constantInDb.getMediaContentUrl2()
                : fileService.saveFile(media2));

        var entity = constantMapper.toDBO(constantDto);
        repository.save(entity);
        return constantMapper.toDTO(entity);
    }

    public void add(Constant constant) {
        repository.save(constant);
    }

    public ConstantLangedDto getConstantByIdLanged(String id, String language) {
        var response = constantMapper.toConstantLangedDto(findById(id), language);
        response.setImageUrl(FilePathHelper.combineForMedia(response.getImageUrl()));
        response.setMediaContentUrl1(FilePathHelper.combineForMedia(response.getMediaContentUrl1()));
        response.setMediaContentUrl2(FilePathHelper.combineForMedia(response.getMediaContentUrl2()));
        return response;
    }

}