package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.CreatePatientReviewRequest;
import com.threesteps.acpapi.dto.PatientReviewDto;
import com.threesteps.acpapi.dto.PatientReviewLangedDto;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.PatientReviewMapper;
import com.threesteps.acpapi.model.PatientReview;
import com.threesteps.acpapi.repository.PatientReviewRepository;
import com.threesteps.acpapi.service.helper.FileService;
import com.threesteps.acpapi.util.helper.FilePathHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientReviewService {

    private final PatientReviewRepository repository;
    private final PatientReviewMapper patientReviewMapper;
    private final FileService fileService;

    public PatientReviewService(PatientReviewRepository repository, PatientReviewMapper patientReviewMapper, FileService fileService) {
        this.repository = repository;
        this.patientReviewMapper = patientReviewMapper;
        this.fileService = fileService;
    }

    public List<PatientReviewDto> getAll() {
        return repository.findAll()
                .stream()
                .map(x -> {
                    var dto = patientReviewMapper.toDTO(x);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public PatientReview findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find patientReview with id: " + id));
    }

    public PatientReviewDto getById(String id) {
        var dto = patientReviewMapper.toDTO(findById(id));
        dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
        return dto;
    }

    public void add(CreatePatientReviewRequest request, MultipartFile file) {
        if (file != null) {
            var fileName = fileService.saveFile(file);
            request.setImageUrl(fileName);
        }

        request.setCreateDate(LocalDateTime.now());
        request.setStatus(true);
        repository.save(patientReviewMapper.toDBO(request));
    }

    public PatientReviewDto update(PatientReviewDto patientReviewDto, MultipartFile file) {
        if (file != null) {
            var imageUrl = findById(patientReviewDto.getId()).getImageUrl();
            fileService.deleteFile(imageUrl);
            patientReviewDto.setImageUrl(fileService.saveFile(file));
        }

        var entity = patientReviewMapper.toDBO(patientReviewDto);
        repository.save(entity);
        return patientReviewMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public List<PatientReviewLangedDto> getLastLanged(String language) {
        return repository
                .findAllByOrderByCreateDateDesc()
                .stream()
                .map(x -> {
                    var dto = patientReviewMapper.toPatientReviewDtoLanged(x, language);
                    dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
                    return dto;
                })
                .toList();
    }

    public PatientReviewLangedDto getByIdLanged(String id, String language) {
        var dto = patientReviewMapper.toPatientReviewDtoLanged(findById(id), language);
        dto.setImageUrl(FilePathHelper.combineForMedia(dto.getImageUrl()));
        return dto;
    }
}