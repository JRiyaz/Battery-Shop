package com.batteryshop.controller;

import com.batteryshop.entity.FileEntity;
import com.batteryshop.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Controller
@RequestMapping("/file")
@AllArgsConstructor
public class FileController {

    public final FileService fileService;

    @GetMapping
    public String file() {
//        return "file-upload";
        return "demo-file";
    }

    @PostMapping("/upload-multiple")
    @ResponseBody
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        fileService.saveAll(files);
        return "Files Uploaded successfully";
    }

    @PostMapping("/upload")
//    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        FileEntity fileEntity = fileService.saveFile(file);

//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/file/download/")
//                .path(fileEntity.getId().toString())
//                .toUriString();
//
//        return new FileResponse(fileEntity.getFileName(), fileDownloadUri,
//                file.getContentType(), file.getSize());
        return "redirect:all?success";
    }

    @GetMapping("/download/{fileId}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer fileId) {

        // Load file from database
        FileEntity file = fileService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getFile()));
    }

    @GetMapping("/show")
    public String showFile(@RequestParam Integer fileId, Model model) {

        FileEntity file = fileService.getFile(fileId);

        String image = FileEntity.BytesToImageConverter(file.getFile());
        model.addAttribute("files", new ArrayList<>());
        model.addAttribute("file", image);
        model.addAttribute("fileName", file.getFileName());
        model.addAttribute("fileType", file.getFileType());
        return "show-file";
    }

    @GetMapping("/all")
    public String allFiles(Model model) {

        model.addAttribute("files", fileService.findAll());
        model.addAttribute("file", null);
        return "show-file";
    }
}
