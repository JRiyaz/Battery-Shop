package com.batteryshop.service;

import com.batteryshop.entity.FileEntity;
import com.batteryshop.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public List<FileEntity> findAll() {
        return fileRepository.findAll();
    }

    public FileEntity saveFile(MultipartFile file) {

        FileEntity fileEntity = null;

        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            fileEntity = fileRepository
                    .save(new FileEntity(fileName, file.getContentType(), file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileEntity;
    }

    public FileEntity getFile(Integer fileId) {
        return fileRepository.findById(fileId).orElse(new FileEntity());
    }

    public List<FileEntity> saveAll(MultipartFile[] files) {
        Arrays.stream(files)
                .forEach(file -> saveFile(file));

        return fileRepository.findAll();
    }
}
