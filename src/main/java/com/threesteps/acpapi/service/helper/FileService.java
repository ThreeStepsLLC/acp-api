package com.threesteps.acpapi.service.helper;

import com.threesteps.acpapi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class FileService {

    @Value("${file-upload.path}")
    private String fileUploadPath;

    public String saveFile(MultipartFile file) {
        if (file == null) {
            throw new NotFoundException("File not found");
        }
        String uuid = UUID.randomUUID().toString();
        String fileName = file.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        var filePath = Path.of(fileUploadPath, uuid + "." + fileExtension);
        try {
            Files.write(filePath, file.getBytes());
            return uuid + "." + fileExtension;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFile(String fileName) {
        var path = Path.of(fileUploadPath, fileName);
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}