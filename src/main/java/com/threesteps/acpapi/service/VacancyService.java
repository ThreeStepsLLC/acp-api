package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.VacancyDto;
import com.threesteps.acpapi.dto.CreateVacancyRequest;
import com.threesteps.acpapi.exception.NotFoundException;
import com.threesteps.acpapi.mapper.VacancyMapper;
import com.threesteps.acpapi.model.Vacancy;
import com.threesteps.acpapi.repository.VacancyRepository;
import com.threesteps.acpapi.service.helper.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VacancyService {

    private final VacancyRepository repository;
    private final VacancyMapper vacancyMapper;
    private final FileService fileService;

    public VacancyService(VacancyRepository repository, VacancyMapper vacancyMapper, FileService fileService) {
        this.repository = repository;
        this.vacancyMapper = vacancyMapper;
        this.fileService = fileService;
    }

    public List<VacancyDto> getAll() {
        return repository.findAllByOrderByCreateDateDesc()
                .stream()
                .map(vacancyMapper::toDTO)
                .toList();
    }

    public Vacancy findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Couldn't find vacancy with id: " + id));
    }

    public VacancyDto getById(String id) {
        return vacancyMapper.toDTO(findById(id));
    }

    public void add(CreateVacancyRequest request, MultipartFile file) {
        if (file != null) {
            request.setCvFilePath(fileService.saveFile(file));
        }

        request.setCreateDate(LocalDateTime.now());
        repository.save(vacancyMapper.toDBO(request));
    }

    public VacancyDto update(VacancyDto vacancyDto, MultipartFile file) {
        if (file != null) {
            var entityInDb = findById(vacancyDto.getId());
            fileService.deleteFile(entityInDb.getCvFilePath());
            vacancyDto.setCvFilePath(fileService.saveFile(file));
        }

        var entity = vacancyMapper.toDBO(vacancyDto);
        repository.save(entity);
        return vacancyMapper.toDTO(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}